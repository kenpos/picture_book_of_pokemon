package com.kenpos.app.picture_books_pokemon_pro;


import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.DatabaseHelper;
import com.kenpos.app.picture_books_pro_pokemon_Fragment.MainActivity;
import com.kenpos.app.picture_books_pro_pokemon_variables.serch_methods;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Waza_result extends serch_methods{
	 protected SQLiteDatabase db;
	 protected Cursor cursor;
	 protected ListAdapter adapter;
	 protected ListView cigaretteList;
	 public static boolean flag =false;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock); 
		setContentView(R.layout.waza_result);
		
		if(flag  == true ){
			flag = false;
			Waza_serch.helper = new DatabaseHelper(this);
			Waza_serch.db = helper.getReadableDatabase();
            try{
        		Waza_serch.kensaku_waza(Waza_serch.serch);
                }catch(Exception e){
                }finally{
            		Intent intent = new Intent(this, Waza_result.class);
                	startActivity(intent);
                }

		}

	        TextView textView1 = (TextView)findViewById(R.id.WAZA_NAME);
	    	textView1.setText(com.kenpos.app.picture_books_pokemon_pro.Waza_serch.WAZA_NAME);
		    TextView textView2 = (TextView)findViewById(R.id.textView);
		    textView2.setText(com.kenpos.app.picture_books_pokemon_pro.Waza_serch.WAZA_TYPE);
			TextView textView3 = (TextView)findViewById(R.id.iryoku_text);
			textView3.setText(com.kenpos.app.picture_books_pokemon_pro.Waza_serch.WAZA_IRYOKU);
			TextView textView4 = (TextView)findViewById(R.id.meityu_text);
			textView4.setText(com.kenpos.app.picture_books_pokemon_pro.Waza_serch.WAZA_MEITYU);
			TextView textView5 = (TextView)findViewById(R.id.PP_txt);
			textView5.setText(com.kenpos.app.picture_books_pokemon_pro.Waza_serch.WAZA_PP);
			TextView textView7 = (TextView)findViewById(R.id.bun_txt);
			textView7.setText(com.kenpos.app.picture_books_pokemon_pro.Waza_serch.WAZA_BUNRUI);
			TextView textView8 = (TextView)findViewById(R.id.tai_txt);
			textView8.setText(com.kenpos.app.picture_books_pokemon_pro.Waza_serch.WAZA_ENKAKU);
			TextView textView9 = (TextView)findViewById(R.id.sessyoku_txt);
			textView9.setText(com.kenpos.app.picture_books_pokemon_pro.Waza_serch.WAZA_SESSYOKU);
			TextView textView10 = (TextView)findViewById(R.id.kouka1);
			textView10.setText(com.kenpos.app.picture_books_pokemon_pro.Waza_serch.WAZA_KOUKA1);
	
			onClick(textView1.getText().toString());
			
			//-----------------広告　ここから-------------//
			promotion_method();
				    	//-----------------広告　ここまで-------------//
	}

	public void onClick(String pokemonID) {
		// TODO Auto-generated method stub
		  db = (new DatabaseHelper(this)).getWritableDatabase();

		  String table ="'ステータス'";
		  String[] columns = { "_id","No","NAME", "タイプ1", "タイプ2" };
		  String selection ="No IN(select No from 第六世代遺伝技 where 技 =?)"
		  		+ "or No IN(select No from 第六世代レベル技 where 技 =?)"
		  		+ "or No IN(select No from 第六世代技マシン where 技 =?)";
		  String[] selectionArgs = { pokemonID,pokemonID,pokemonID};
		  String limit = null;

Cursor  c = db.query(table,columns, selection, selectionArgs, null, null,null,limit);
		  c.moveToFirst();

		  SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(this, 
	               R.layout.list_item,
	               c, 
	               new String[] {"No","NAME", "タイプ1", "タイプ2"}, 
	               new int[] {R.id.list_number,R.id.list_name, R.id.list_fom, R.id.list_type_1});
		 
		  		 cigaretteList = (ListView)findViewById(R.id.listView1);
	             cigaretteList.setAdapter(myAdapter);
	             final Intent intent = new Intent(this, MainActivity.class);
	             // リストビューのアイテムがクリックされた時に呼び出されるコールバックリスナーを登録します
	             cigaretteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	                 @Override
	                 public void onItemClick(AdapterView<?> parent, View view,
	                         int position, long id) {
	                     ListView listView = (ListView) parent;
	                     // クリックされたアイテムを取得します
	                     Cursor item = (Cursor) listView.getItemAtPosition(position);
	                     String lgin_id = item.getString(item.getColumnIndex("_id"));
	                     String lgin_name = item.getString(item.getColumnIndex("NAME")); 
	                
	                     title.Name_serch(lgin_name);
	                 	// 検索結果の表示
	                 	
	                 	startActivity(intent);
	                 	
	                 }
	             });

	             
	}
	
	
	
}
