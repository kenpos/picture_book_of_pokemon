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
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class TYPE_serch extends serch_methods implements OnClickListener {
	protected Cursor cursor;
	protected ListAdapter adapter;
	protected ListView cigaretteList;
//	static EditText edit1, edit2;
	static SQLiteDatabase db;
	DatabaseHelper helper = new DatabaseHelper(this);
	public static String serch1=" " ,serch2= " ";
	Spinner spinner1;
	Spinner spinner2;
	static Cursor c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Sherlock___Theme_DarkActionBar); 
		setContentView(R.layout.type_serch);

		// Spinnerオブジェクトを取得
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
	
		// データベースの宣言
		// ＤＢオープン
		db = helper.getReadableDatabase();
		View Button = findViewById(R.id.button1);
		Button.setOnClickListener(this);
		change_type();
		Log.e(serch1, serch2);
		
		kensaku_tokusei(serch1, serch2);
		type_list();
		
		//-----------------広告　ここから-------------//
promotion_method();
			    	//-----------------広告　ここまで-------------//
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		serch1 = (String) spinner1.getSelectedItem();
		serch2 = (String) spinner2.getSelectedItem();
		// 例外処理
		try {// 各種検索します。
				// Spinnerオブジェクトを取得
			kensaku_tokusei(serch1, serch2);
			type_list();
		} catch (Exception e) {
			// TODO: handle exception
			// 確認ダイアログの生成
			AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
			alertDlg.setTitle("検索失敗");
			alertDlg.setMessage("組み合わせを変えてみてください。もし駄目なら報告お願いします。");
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

	public static void kensaku_tokusei(String type1, String type2) {
		String table = "ステータス";
		String[] columns = { "_id", "No", "NAME", "タイプ1", "タイプ2" };
		String selection ;
		String[] selectionArgs = { type1, type2, type2, type1 };
		String limit = null;
		// タイプ2が空白なら
		if (type2.length() <= 1) {
			selectionArgs = new String[] { type1 };
			selection = "_id IN(select _id from 検索用タイプ where タイプ1 =? and タイプ2 = ' ')";
		} else if (type1.length() <= 1) {
			selectionArgs = new String[] { type2 };
			selection = "_id IN(select _id from 検索用タイプ where タイプ1 = ? and タイプ2 =' ')";
		} else if(type1==type2){
			selectionArgs =new String[] {type1};
			selection ="No IN(select No from 検索用タイプ where タイプ1 =? and タイプ2 =' ')";
		}else {
			selectionArgs = new String[] { type1, type2, type2, type1 };
			selection = "_id IN(select _id from 検索用タイプ where タイプ1 =? and タイプ2=?)"
					+ "or _id IN(select _id from 検索用タイプ where タイプ1 =? and タイプ2=?)";
		}

		 c = db.query(table, columns, selection, selectionArgs, null,
				null, null, limit);
		c.moveToFirst();
	}

	private void type_list(){
		SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(this,
				R.layout.list_item, c, new String[] { "No", "NAME", "タイプ1",
						"タイプ2" }, new int[] { R.id.list_number, R.id.list_name,
						R.id.list_fom, R.id.list_type_1 });

		cigaretteList = (ListView) findViewById(R.id.type_listView);
		cigaretteList.setAdapter(myAdapter);
		final Intent intent = new Intent(this, MainActivity.class);
		// リストビューのアイテムがクリックされた時に呼び出されるコールバックリスナーを登録します
		cigaretteList
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						ListView listView = (ListView) parent;
						// クリックされたアイテムを取得します
						Cursor item = (Cursor) listView
								.getItemAtPosition(position);
						// String lgin_id =
						// item.getString(item.getColumnIndex("_id"));
						String lgin_name = item.getString(item
								.getColumnIndex("NAME"));

						title.Name_serch(lgin_name);
						startActivity(intent);
					}
				});
	}	
	private void change_type(){
		if("ノ".equals(serch1)){
			serch1 ="ノーマル";
		}
		if("炎".equals(serch1)){
			serch1 ="ほのお";
		}
		if("水".equals(serch1)){
			serch1 ="みず";
		}
		if("電".equals(serch1)){
			serch1 ="でんき";
		}
		if("草".equals(serch1)){
			serch1 ="くさ";
		}
		if("氷".equals(serch1)){
			serch1 ="こおり";
		}
		if("格".equals(serch1)){
			serch1 ="かくとう";
		}
		if("毒".equals(serch1)){
			serch1 ="どく";
		}
		if("地".equals(serch1)){
			serch1 ="じめん";
		}
		if("飛".equals(serch1)){
			serch1 ="ひこう";
		}
		if("超".equals(serch1)){
			serch1 ="エスパー";
		}
		if("虫".equals(serch1)){
			serch1 ="むし";
		}
		if("岩".equals(serch1)){
			serch1 ="いわ";
		}
		if("霊".equals(serch1)){
			serch1 ="ゴースト";
		}
		if("竜".equals(serch1)){
			serch1 ="ドラゴン";
		}
		if("悪".equals(serch1)){
			serch1 ="あく";
		}
		if("鋼".equals(serch1)){
			serch1 ="はがね";
		}
		if("妖".equals(serch1)){
			serch1 ="フェアリー";
		}

		if("ノ".equals(serch2)){
			serch2 ="ノーマル";
		}
		if("炎".equals(serch2)){
			serch2 ="ほのお";
		}
		if("水".equals(serch2)){
			serch2 ="みず";
		}
		if("電".equals(serch2)){
			serch2 ="でんき";
		}
		if("草".equals(serch2)){
			serch2 ="くさ";
		}
		if("氷".equals(serch2)){
			serch2 ="こおり";
		}
		if("格".equals(serch2)){
			serch2 ="かくとう";
		}
		if("毒".equals(serch2)){
			serch2 ="どく";
		}
		if("地".equals(serch2)){
			serch2 ="じめん";
		}
		if("飛".equals(serch2)){
			serch2 ="ひこう";
		}
		if("超".equals(serch2)){
			serch2 ="エスパー";
		}
		if("虫".equals(serch2)){
			serch2 ="むし";
		}
		if("岩".equals(serch2)){
			serch2 ="いわ";
		}
		if("霊".equals(serch2)){
			serch2 ="ゴースト";
		}
		if("竜".equals(serch2)){
			serch2 ="ドラゴン";
		}
		if("悪".equals(serch2)){
			serch2 ="あく";
		}
		if("鋼".equals(serch2)){
			serch2 ="はがね";
		}
		if("妖".equals(serch2)){
			serch2 ="フェアリー";
		}

	}
}
