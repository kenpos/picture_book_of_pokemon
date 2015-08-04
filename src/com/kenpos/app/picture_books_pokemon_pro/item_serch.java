package com.kenpos.app.picture_books_pokemon_pro;


import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.DatabaseHelper;
import com.kenpos.app.picture_books_pro_pokemon_variables.serch_methods;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

public class item_serch extends serch_methods implements OnClickListener {

	static EditText edit;
	static SQLiteDatabase db;
	DatabaseHelper helper = new DatabaseHelper(this);
	public static String serch;
	public static String  ITEM_NAME ="", ITEM_KOUKA="";

	TextView textView1,textView2;
	private ArrayAdapter<CharSequence> adapter;
	 private AutoCompleteTextView _autoCompleteTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock); 
		setContentView(R.layout.item_serch);

//		edit = (EditText) findViewById(R.id.autoCompleteTextView1);
	
//		serch = edit.getText().toString();
		View Button = findViewById(R.id.button1);
		Button.setOnClickListener(this);

		 adapter = ArrayAdapter.createFromResource(this, R.array.itemlist, android.R.layout.simple_dropdown_item_1line);
		 _autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
			_autoCompleteTextView.setTextColor(Color.BLACK);
		 _autoCompleteTextView.setAdapter(adapter);
		 

			textView1 = (TextView)findViewById(R.id.textView3);
			  textView2 = (TextView)findViewById(R.id.TextView01);
		 
		// データベースの宣言
		// ＤＢオープン
		db = helper.getReadableDatabase();
		
		
		promotion_method();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// 例外処理
		try {// 各種検索します。
			serch = _autoCompleteTextView.getText().toString();
			kensaku_tokusei(serch);
	
			// 検索結果の表示
//			Intent intent = new Intent(this, item_result.class);
//			startActivity(intent);

		} catch (Exception e) {
			// TODO: handle exception
			// 確認ダイアログの生成
			AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);

			if (serch == "ぴよらっと") {
				alertDlg.setTitle("ぴよらっとモード");
				alertDlg.setMessage("これはポケモン図鑑であって、ぴよらっと図鑑ではない。\n\n※やめるんだ！");
			} else {
				alertDlg.setTitle("検索失敗");
				alertDlg.setMessage("別のアイテム名で再検索お願いします。\n\n※うまく検索できない場合は\nアイテム名を変えて試してみてください");
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
	
	private void kensaku_tokusei(String tokusei_na){
		ITEM_NAME ="";
		ITEM_KOUKA="";
    	
    	String selection = "アイテム名  like ?";
		String selectionArgs[] = { "%" + tokusei_na +"%" };
		String limit = null;
		Cursor c = db.query("道具一覧", new String[] {"アイテム名","説明"}, selection, selectionArgs, null, null,
				limit);
		boolean isEof = c.moveToFirst();
		ITEM_NAME = c.getString(0);
		ITEM_KOUKA= c.getString(1);
		c.close();
		textView1.setText(com.kenpos.app.picture_books_pokemon_pro.item_serch.ITEM_NAME);
		textView2.setText(com.kenpos.app.picture_books_pokemon_pro.item_serch.ITEM_KOUKA);
		Log.d(ITEM_NAME, ITEM_KOUKA);
    }
	
	public static String[] Status_Fragment_jump(String tOKUSEI_NAME2) {
		// TODO Auto-generated method stub
		String x[] ={"",""};
	    	
	    	String selection = "特性名= ?";
			String selectionArgs[] = { tOKUSEI_NAME2 };
			String limit = null;
			Cursor c = db.query("特性一覧", new String[] {"特性名","効果"}, selection, selectionArgs, null, null,
					limit);
			boolean isEof = c.moveToFirst();
			x[0] = c.getString(0);
			x[1]= c.getString(1);
			c.close();
	
			return x;
	
	
	}
	
}
