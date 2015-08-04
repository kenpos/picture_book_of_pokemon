package com.kenpos.app.picture_books_pokemon_pro;


import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.DatabaseHelper;
import com.kenpos.app.picture_books_pro_pokemon_variables.serch_methods;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class Tokusei_serch extends serch_methods implements OnClickListener {

	static EditText edit;
//	DatabaseHelper helper = new DatabaseHelper(this);
	public static String serch;
	public static String  TOKUSEI_NAME ="", TOKUSEI_KOUKA="";

	
	private ArrayAdapter<CharSequence> adapter;
	 private AutoCompleteTextView _autoCompleteTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock); 
		setContentView(R.layout.tokusei_serch);
		
		// ＤＢオープン
		db = helper.getReadableDatabase();

		edit = (EditText) findViewById(R.id.autoCompleteTextView1);
		edit.setTextColor(Color.BLACK);
		serch = edit.getText().toString();
		View Button = findViewById(R.id.button1);
		Button.setOnClickListener(this);

		 adapter = ArrayAdapter.createFromResource(this, R.array.tokusei, android.R.layout.simple_dropdown_item_1line);
		 _autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		 _autoCompleteTextView.setAdapter(adapter);
			
		//-----------------広告　ここから-------------//
		promotion_method();
	    //-----------------広告　ここまで-------------//
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// 例外処理
		try {// 各種検索します。
			serch = edit.getText().toString();
			kensaku_tokusei(serch);
			// 検索結果の表示
			 Intent intent = new Intent(getApplicationContext(), tokusei_result.class);
				startActivity(intent);

		} catch (Exception e) {
			// TODO: handle exception
			// 確認ダイアログの生成
			AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);

			if (serch == "ぴよらっと") {
				alertDlg.setTitle("ぴよらっとモード");
				alertDlg.setMessage("これはポケモン図鑑であって、ぴよらっと図鑑ではない。\n\n※やめるんだ！");
			} else {
				alertDlg.setTitle("検索失敗");
				alertDlg.setMessage("別の特性名で再検索お願いします。\n\n※うまく検索できない場合は\n特性名を変えて試してみてください");
			}
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
	
	public static void kensaku_tokusei(String tokusei_na){
		TOKUSEI_NAME ="";
		TOKUSEI_KOUKA="";

		String selection = "特性名 LIKE ?";
		String selectionArgs[] = {"%" + tokusei_na +"%"};
		String limit = null;
		Cursor c = db.query("特性一覧", new String[] {"特性名","効果"}, selection, selectionArgs, null, null,limit);
		boolean isEof = c.moveToFirst();
		TOKUSEI_NAME = c.getString(0);
		TOKUSEI_KOUKA= c.getString(1);
		c.close();
    }

	public static String[] Status_Fragment_jump(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
