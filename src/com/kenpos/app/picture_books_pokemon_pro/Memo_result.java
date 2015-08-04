package com.kenpos.app.picture_books_pokemon_pro;


import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.subDBhelper2;
import com.kenpos.app.picture_books_pro_pokemon_variables.serch_methods;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;



public class Memo_result extends serch_methods{
	 protected SQLiteDatabase db;
	 protected Cursor cursor;
	 protected ListAdapter adapter;
	 protected ListView cigaretteList;
	 String lgin_name;
	 TextView textView,textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10,textView11,textView12,textView13,textView14,textView15,textView16,textView17;

AlertDialog.Builder alertDialog;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock); 
		setContentView(R.layout.memo_result);
		 textView = (TextView)findViewById(R.id.NAME);
  		 textView1 = (TextView)findViewById(R.id.NAME);
	     textView2 = (TextView)findViewById(R.id.nikku_name);
		 textView3 = (TextView)findViewById(R.id.seikaku);
		 textView4 = (TextView)findViewById(R.id.tokusei);
		 textView5 = (TextView)findViewById(R.id.item);
		 textView7 = (TextView)findViewById(R.id.HP_text);
		 textView8 = (TextView)findViewById(R.id.ATK_text);
		 textView9 = (TextView)findViewById(R.id.DEF_text);
		textView10 = (TextView)findViewById(R.id.SATK_text);
		 textView11 = (TextView)findViewById(R.id.SDEF_text);
		 textView12 = (TextView)findViewById(R.id.SPE_text);
		textView13 = (TextView)findViewById(R.id.waza_list1);
		 textView14 = (TextView)findViewById(R.id.waza_list2);
		 textView15 = (TextView)findViewById(R.id.waza_list3);
		 textView16 = (TextView)findViewById(R.id.waza_list4);
		 textView17 = (TextView)findViewById(R.id.comment);
	

		 daiitikensaku();
		
			//-----------------広告　ここから-------------//
promotion_method();
			//-----------------広告　ここまで-------------//
	}
	
	public void jump(View view) {
    	Intent i = new Intent(this, Memo_Activity.class);
    	startActivity(i);
    	this.finish();
	}

	public void daiitikensaku() {
		// TODO Auto-generated method stub
		  db = (new subDBhelper2(this)).getWritableDatabase();
		  String table ="'育成ポケモン'";
		  String[] columns = {"*"};
		  String selection = null;
		  String[] selectionArgs = null;
		  String limit = null;
try{
	Cursor  c = db.query(table,columns, selection, selectionArgs, null, null,null,limit);
	  c.moveToFirst();
  		textView.setText(c.getString(0));
  		textView1.setText(c.getString(1));
	    textView2.setText(c.getString(2));
		textView3.setText(c.getString(3));
		textView4.setText(c.getString(4));
		textView5.setText(c.getString(5));
		textView7.setText(c.getString(6));
		textView8.setText(c.getString(7));
		textView9.setText(c.getString(8));
		textView10.setText(c.getString(9));
		textView11.setText(c.getString(10));
		textView12.setText(c.getString(11));
		textView13.setText(c.getString(12));
		textView14.setText(c.getString(13));
		textView15.setText(c.getString(14));
		textView16.setText(c.getString(15));
		textView17.setText(c.getString(16));
	
		  SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(this, 
	               R.layout.pokemon_adana,
	               c, 
	               new String[] {"_id","NAME", "コメント"}, 
	               new int[] {R.id.list_number,R.id.list_name, R.id.comment});
		 
		  		 cigaretteList = (ListView)findViewById(R.id.listView1);
	             cigaretteList.setAdapter(myAdapter);
	             // リストビューのアイテムがクリックされた時に呼び出されるコールバックリスナーを登録します
	             cigaretteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	                 @Override
	                 public void onItemClick(AdapterView<?> parent, View view,
	                         int position, long id) {
	                     ListView listView = (ListView) parent;
	                     // クリックされたアイテムを取得します
	                     Cursor item = (Cursor)listView.getItemAtPosition(position);
	                     String lgin_name = item.getString(item.getColumnIndex("_id"));
//	                     title.Name_serch(lgin_name);
	                 	// 検索結果の表示
	                     serching(lgin_name);
	                     
	                 	
	                 }
	             });
	             
	             alertDialog=new AlertDialog.Builder(this);
	             //長押し処理
	             cigaretteList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
	                 @Override
	                 public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
	                     //ここに処理を書く
	                     // クリックされたアイテムを取得します
	                	  ListView listView = (ListView) parent;
	                     Cursor item = (Cursor)listView.getItemAtPosition(position);
	                     lgin_name = item.getString(item.getColumnIndex("_id"));
	                     
	        	        // ダイアログの設定
	        	        alertDialog.setTitle("削除確認");      //タイトル設定
	        	        alertDialog.setMessage("選択されたポケモンを削除しますか？");  //内容(メッセージ)設定
	        	        // OK(肯定的な)ボタンの設定
	        	        alertDialog.setPositiveButton("はい", new DialogInterface.OnClickListener() {
	        	            public void onClick(DialogInterface dialog, int which) {
	        	                // OKボタン押下時の処理
	        	            	db.delete("育成ポケモン", "_id=?", new String[] {lgin_name});
	        	                Log.d("AlertDialog", "Positive which :" + which);
	        	                daiitikensaku();
	        	            }
	        	        });
	        	 
	        	        // SKIP(中立的な)ボタンの設定
	        	        alertDialog.setNeutralButton("いいえ", new DialogInterface.OnClickListener() {
	        	            public void onClick(DialogInterface dialog, int which) {
	        	                // SKIPボタン押下時の処理
	        	                Log.d("AlertDialog", "Neutral which :" + which);
	        	            }
	        	        });
	        	        
						alertDialog.show();
	                     return false;
	                 }
	             });
	            
}catch (Exception e){

}

	}
	
	
 private void serching(String test){

	  String table ="'育成ポケモン'";
//NAME,ニックネーム TEXT,特性 TEXT,性格 TEXT,道具 TEXT,HP TEXT,攻撃 TEXT,防御 TEXT,特攻 TEXT,特防 TEXT,素早 TEXT,技1 TEXT,技2 TEXT,技3 TEXT,技4 TEXT,コメント TEXT
	  String[] columns = {"*"};
	  String selection = "_id = ?";
	  String[] selectionArgs = {test};
	  String limit = "1";
try{
Cursor  c = db.query(table,columns, selection, selectionArgs, null, null,null,limit);
 c.moveToFirst();
 textView.setText(c.getString(0));
 textView1.setText(c.getString(1));
   textView2.setText(c.getString(2));
	textView3.setText(c.getString(3));
	textView4.setText(c.getString(4));
	textView5.setText(c.getString(5));
	textView7.setText(c.getString(6));
	textView8.setText(c.getString(7));
	textView9.setText(c.getString(8));
	textView10.setText(c.getString(9));
	textView11.setText(c.getString(10));
	textView12.setText(c.getString(11));
	textView13.setText(c.getString(12));
	textView14.setText(c.getString(13));
	textView15.setText(c.getString(14));
	textView16.setText(c.getString(15));
	textView17.setText(c.getString(16));
 }catch(Exception e){

}
 }
}
