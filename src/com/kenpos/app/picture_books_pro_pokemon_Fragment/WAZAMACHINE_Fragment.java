package com.kenpos.app.picture_books_pro_pokemon_Fragment;


import com.kenpos.app.picture_books_pokemon_pro.R;
import com.kenpos.app.picture_books_pokemon_pro.Waza_result;
import com.kenpos.app.picture_books_pokemon_pro.Waza_serch;
import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.DatabaseHelper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class WAZAMACHINE_Fragment extends Fragment {
	public static final String ARG_SECTION_NUMBER = "section_number";

	public WAZAMACHINE_Fragment() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.page3r, container, false);
	
		return rootView;
	}
	
    public void onStart() {
        super.onStart();
//       	final TextView textView35 = (TextView) getActivity().findViewById(R.id.waza_machine_txt);
//       	textView35.setText(com.kenpos.app.picture_books_pokemon.title.DAIROKU_WAZA);
    	final TextView textView37 = (TextView) getActivity().findViewById(R.id.WAXA_MACHINE);
    	
     	Lv_waza_serch(com.kenpos.app.picture_books_pokemon_pro.title.No,"第六世代技マシン");
    	
      	final TextView waza_gen3 = (TextView) getActivity().findViewById(R.id.waza_gen3);
       	final TextView waza_gen4 = (TextView) getActivity().findViewById(R.id.waza_gen4);
       	final TextView waza_gen5 = (TextView) getActivity().findViewById(R.id.waza_gen5);
       	final TextView waza_gen6 = (TextView) getActivity().findViewById(R.id.waza_gen6);
    	waza_gen3.setClickable(true);
    	waza_gen4.setClickable(true);
    	waza_gen5.setClickable(true);
    	waza_gen6.setClickable(true);
    	
        	waza_gen6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 	textView37.setText("技マシンで覚える技（第六世代）");
                 	Lv_waza_serch(com.kenpos.app.picture_books_pokemon_pro.title.No,"第六世代技マシン");
             }
         });

        //五世代
        waza_gen5.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
            	 	textView37.setText("技マシンで覚える技（第五世代）");
            	 	Lv_waza_serch(com.kenpos.app.picture_books_pokemon_pro.title.No,"第五世代技マシン");

             }
         });
        
        //四世代
        waza_gen4.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
            	 	textView37.setText("技マシンで覚える技（第四世代）");
            	 	Lv_waza_serch(com.kenpos.app.picture_books_pokemon_pro.title.No,"第四世代技マシン");

             }
         });
        
        //三世代
        waza_gen3.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
            	 	textView37.setText("技マシンで覚える技（第三世代）");
            	 	Lv_waza_serch(com.kenpos.app.picture_books_pokemon_pro.title.No,"第三世代技マシン");

             }
         });    
}

    
    protected ListView cigaretteList;
    public void Lv_waza_serch(String pokemonID,String table) {
		// TODO Auto-generated method stub

//		  String table ="'第六世代レベル技'";
		  String[] columns = { "_id","No","waza_NO","技"};
		  String selection = "No =?";
		  String[] selectionArgs = {pokemonID};
		  String limit = null;
		  SQLiteDatabase db = (new DatabaseHelper(getActivity())).getWritableDatabase();
		  DatabaseHelper helper = new DatabaseHelper(getActivity());
Cursor  c = db.query(table,columns, selection, selectionArgs, null, null,null,limit);
		  c.moveToFirst();

		  SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(getActivity(), 
	               R.layout.waza_list_lv,
	               c, 
	               new String[] {"waza_NO", "技","_id"}, 
	               new int[] {R.id.textView,R.id.list_name});
		 
		  		 cigaretteList = (ListView)getActivity().findViewById(R.id.listView2);
	             cigaretteList.setAdapter(myAdapter);
	             final Intent intent = new Intent(getActivity(), Waza_result.class);
	             // リストビューのアイテムがクリックされた時に呼び出されるコールバックリスナーを登録します
	             cigaretteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	                 @Override
	                 public void onItemClick(AdapterView<?> parent, View view,
	                         int position, long id) {
	                     ListView listView = (ListView) parent;
	                     // クリックされたアイテムを取得します
	                     Cursor item = (Cursor) listView.getItemAtPosition(position);
	                     String lgin_id = item.getString(item.getColumnIndex("技"));
	                    
	                     try{
		                     Waza_result.flag = true;
		                     Waza_serch.serch = lgin_id;
		                     startActivity(intent);
		                     }catch(Exception e){

		                     }          
	                 }
	             });

	}
}
