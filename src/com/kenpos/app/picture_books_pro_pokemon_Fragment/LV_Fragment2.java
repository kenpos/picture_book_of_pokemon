package com.kenpos.app.picture_books_pro_pokemon_Fragment;


import com.kenpos.app.picture_books_pokemon_pro.R;
import com.kenpos.app.picture_books_pokemon_pro.Waza_result;
import com.kenpos.app.picture_books_pokemon_pro.Waza_serch;
import com.kenpos.app.picture_books_pokemon_pro.title;
import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.DatabaseHelper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class LV_Fragment2 extends Fragment {
	public static final String ARG_SECTION_NUMBER = "section_number";
	protected ListView cigaretteList;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.page2r, container, false);
		

		return rootView;
	}

	@Override
    public void onStart() {
       super.onStart();

   	final TextView textView37 = (TextView) getActivity().findViewById(R.id.LEVEL_UP);
   	textView37.setText("レベルアップで覚える技（第六世代）");
   	
   	Lv_waza_serch(com.kenpos.app.picture_books_pokemon_pro.title.No,"第六世代レベル技");
   	
   	final TextView gen3 = (TextView) getActivity().findViewById(R.id.gen3);
   	final TextView gen4 = (TextView) getActivity().findViewById(R.id.gen4);
   	final TextView gen5 = (TextView) getActivity().findViewById(R.id.gen5);
   	final TextView gen6 = (TextView) getActivity().findViewById(R.id.gen6);
	gen3.setClickable(true);
	gen4.setClickable(true);
	gen5.setClickable(true);
	gen6.setClickable(true);
	
	
           
   	

    	gen6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             	textView37.setText("レベルアップで覚える技（第六世代）");
           	Lv_waza_serch(com.kenpos.app.picture_books_pokemon_pro.title.No,"第六世代レベル技");
         }
     });

    //五世代
    gen5.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
        	 	textView37.setText("レベルアップで覚える技（第五世代）");
           	Lv_waza_serch(com.kenpos.app.picture_books_pokemon_pro.title.No,"第五世代レベル技");
         }
     });
    
    //四世代
    gen4.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
        	 	textView37.setText("レベルアップで覚える技（第四世代）");
           	Lv_waza_serch(com.kenpos.app.picture_books_pokemon_pro.title.No,"第四世代レベル技");
         }
     });
    
    //三世代
    gen3.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
        	 	textView37.setText("レベルアップで覚える技（第三世代）");
           	Lv_waza_serch(com.kenpos.app.picture_books_pokemon_pro.title.No,"第三世代レベル技");
         }
     });    
    
 }
	
	public void Lv_waza_serch(String pokemonID,String table) {
		// TODO Auto-generated method stub

//		  String table ="'第六世代レベル技'";
		  String[] columns = { "_id","No","LV","技"};
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
	               new String[] {"LV", "技","_id"}, 
	               new int[] {R.id.textView,R.id.list_name});
		 
		  		 cigaretteList = (ListView)getActivity().findViewById(R.id.listView1);
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
		                     }catch(Exception e){

		                     }finally{
	                 	startActivity(intent);
		                     }
	                 }
	             }); 

	}
		
}
