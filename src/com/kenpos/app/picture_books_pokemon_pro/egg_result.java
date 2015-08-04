package com.kenpos.app.picture_books_pokemon_pro;


import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.DatabaseHelper;
import com.kenpos.app.picture_books_pro_pokemon_Fragment.MainActivity;
import com.kenpos.app.picture_books_pro_pokemon_variables.serch_methods;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class egg_result extends serch_methods implements OnClickListener {
	 protected Cursor cursor;
	 protected SpinnerAdapter adapter;
	 protected ListView cigaretteList;
	static EditText edit1,edit2;
	static SQLiteDatabase db;
	DatabaseHelper helper = new DatabaseHelper(this);
	public static  String serch1=" " ,serch2=" ";
	
     Spinner spinner1 ;
     Spinner spinner2 ;
     static Cursor c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Sherlock___Theme_DarkActionBar); 
		setContentView(R.layout.egg_serch);
		
		promotion_method();
		
	      // Spinnerオブジェクトを取得
        spinner1 = (Spinner)findViewById(R.id.spin1);
        spinner2 = (Spinner)findViewById(R.id.spin2);
		// データベースの宣言
		// ＤＢオープン
		db = helper.getReadableDatabase();
		 View Button = findViewById(R.id.button1);
			Button.setOnClickListener(this);
			
			
			egg_serchi(serch1,serch2);
			 kensaku_tokusei();
	}

	@Override
	public void onClick(View v) {
		serch1 = (String)spinner1.getSelectedItem();
		serch2 = (String)spinner2.getSelectedItem();
		// TODO Auto-generated method stub
		// 例外処理
		try {// 各種検索します。
			egg_serchi(serch1,serch2);
			 kensaku_tokusei();

		} catch (Exception e) {
			// TODO: handle exception
			// 確認ダイアログの生成
			AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
				alertDlg.setTitle("検索失敗");
				alertDlg.setMessage("もしかしたら、タイプの入力が正しくないのかもしれません。\n水タイプ⇒みず　このように表記してみてください");
			alertDlg.setNegativeButton("OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							// OK ボタンクリック処理
						}
					});
			alertDlg.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							// Cancel ボタンクリック処理
						}
					});

			// 表示
			alertDlg.create().show();
		}
	}
	
	public static void egg_serchi(String type1,String type2){
		  String table ="ステータス";
		  String[] columns = { "_id","No","NAME", "タイプ1", "タイプ2" };
		  String selection ="";
		  String[] selectionArgs = {type1,type2,type2,type1};
		  String limit = null;
		  //タイプ2が空白なら
		if(type2.length() <=1 ){
			selectionArgs =new String[] {type1};
			  selection ="No IN(select No from タマゴタイプ where タマゴ_タイプ1 =? and タマゴ_タイプ2 = ' ')";
		}else if(type1.length()<=1){
			selectionArgs =new String[] {type2};
			selection ="No IN(select No from タマゴタイプ where タマゴ_タイプ1 = ? and タマゴ_タイプ2 =' ')";
		}else if(type1==type2){
			selectionArgs =new String[] {type1};
			  selection ="No IN(select No from タマゴタイプ where タマゴ_タイプ1 =? and タマゴ_タイプ2 =' ')";
		}else{
		  selection ="No IN(select No from タマゴタイプ where タマゴ_タイプ1 =? and タマゴ_タイプ2=?)"
		  		+ "or No IN(select No from タマゴタイプ where タマゴ_タイプ1 =? and タマゴ_タイプ2=?)";
		}
		c = db.query(table,columns, selection, selectionArgs, null, null,null,limit);
		  c.moveToFirst();
    }
	
	
	private void kensaku_tokusei(){
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
//	                     String lgin_id = item.getString(item.getColumnIndex("_id"));
	                     String lgin_name = item.getString(item.getColumnIndex("NAME")); 
	                     title.Name_serch(lgin_name);
	                     startActivity(intent);
	}
	             });
	}
	
}
