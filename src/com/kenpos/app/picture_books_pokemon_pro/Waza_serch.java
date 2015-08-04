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

public class Waza_serch extends serch_methods implements OnClickListener {
	
	static EditText edit;
	static SQLiteDatabase db;
	public static DatabaseHelper helper ;
	public static String serch ="";

	 
	private ArrayAdapter<CharSequence> adapter;
	private AutoCompleteTextView _autoCompleteTextView;

	public static String  WAZA_NO ="", WAZA_NAME="",WAZA_TYPE="",WAZA_BUNRUI="",WAZA_IRYOKU="",WAZA_MEITYU="",WAZA_PP="",WAZA_TAISYOU="",WAZA_ENKAKU="",WAZA_SESSYOKU="",WAZA_KOUKA1="",WAZA_KOUKA2="",WAZA_KOUKA3="",WAZA_KOUKA4="",WAZA_KOUKA5="",WAZA_KOUKA6="",WAZA_KOUKA7="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock); 
		setContentView(R.layout.waza_serch);

		edit = (EditText) findViewById(R.id.autoCompleteTextView1);
		edit.setTextColor(Color.BLACK);
		View Button = findViewById(R.id.button1);
		Button.setOnClickListener(this);

		 adapter = ArrayAdapter.createFromResource(this, R.array.waza, android.R.layout.simple_dropdown_item_1line);
		 _autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		 _autoCompleteTextView.setAdapter(adapter);
		 
			helper = new DatabaseHelper(this);
			db = helper.getReadableDatabase();
		//-----------------広告　ここから-------------//
		promotion_method();
		//-----------------広告　ここまで-------------//
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	try {
		serch = edit.getText().toString();
		kensaku_waza(serch);
		
		// 検索結果の表示
		Intent intent = new Intent(this, Waza_result.class);
		startActivity(intent);
	} catch (Exception e) {
		// TODO: handle exception
		   // 確認ダイアログの生成
	    AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
	   
	    alertDlg.setTitle("検索失敗");
	    alertDlg.setMessage("別の特性名で再検索お願いします。\n\n※うまく検索できない場合は名前が間違えている可能性があります。\n正しい名前に変えて試してみてください");
	    alertDlg.setNegativeButton(
	        "OK",
	        new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	                // OK ボタンクリック処理
	            }
	        });
	    alertDlg.setNegativeButton(
	        "Cancel",
	        new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	                // Cancel ボタンクリック処理
	            }
	        });

	    // 表示
	    alertDlg.create().show();
	}
	}

    public static void kensaku_waza(String waza_na){
    	WAZA_NO ="";
    	WAZA_NAME="";
    	WAZA_TYPE="";
    	WAZA_BUNRUI="";
    	WAZA_IRYOKU="";
    	WAZA_MEITYU="";
    	WAZA_PP="";
    	WAZA_TAISYOU="";
    	WAZA_ENKAKU="";
    	WAZA_SESSYOKU="";
    	WAZA_KOUKA1="";
    	WAZA_KOUKA2="";
    	WAZA_KOUKA3="";
    	WAZA_KOUKA4="";
    	WAZA_KOUKA5="";
    	WAZA_KOUKA6="";
    	WAZA_KOUKA7="";
    	
		
		
    	String selection = "技 LIKE ?";
		String selectionArgs[] = {waza_na + "%" };
		String limit = null;
		Cursor c = db.query("技一覧", new String[] { "_id", "技", "タイプ", "分類",
				"威力", "命中", "PP", "対象", "遠隔", "接触", "効果1", "効果2", "効果3",
				"効果4", "効果5", "効果6","効果7" }, selection, selectionArgs, null, null,
				limit);
		 c.moveToFirst();
			WAZA_NO = c.getString(0);
			WAZA_NAME = c.getString(1);
			WAZA_TYPE = c.getString(2);
			WAZA_BUNRUI = c.getString(3);
			WAZA_IRYOKU = c.getString(4);
			WAZA_MEITYU = c.getString(5);
			WAZA_PP = c.getString(6);
			WAZA_TAISYOU = c.getString(7);
			WAZA_ENKAKU = c.getString(8);
			WAZA_SESSYOKU = c.getString(9);
			WAZA_KOUKA1 += String.format("%s %s %s %s %s %s %s \n",
					c.getString(10), c.getString(11),
					c.getString(12), c.getString(13), c.getString(14),
					c.getString(15), c.getString(16));
		c.close();
    }
    
}
