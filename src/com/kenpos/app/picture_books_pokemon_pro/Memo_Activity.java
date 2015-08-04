package com.kenpos.app.picture_books_pokemon_pro;


import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.subDBhelper2;
import com.kenpos.app.picture_books_pro_pokemon_variables.serch_methods;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Memo_Activity extends serch_methods implements OnClickListener {
	protected Cursor cursor;
	protected ListAdapter adapter;
	protected ListView cigaretteList;
	static EditText edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8,
			edit9, edit10, edit11, edit12, edit13, edit14, edit15;
	public String serch1, serch2, serch3, serch4, serch5, serch6, serch7,
	serch8, serch9, serch10, serch11, serch12, serch13, serch14,
	serch15;
	static SQLiteDatabase db;
	subDBhelper2 helper = new subDBhelper2(this);

	Spinner spinner1;
	private ArrayAdapter<CharSequence> adapter1 ,adapter2,adapter3,adapter4;
	private AutoCompleteTextView _autoCompleteTextView1,_autoCompleteTextView2,_autoCompleteTextView3;

	TextView textView1; 
	TextView textView2 ;
	TextView textView3 ;
	TextView textView4 ;
	TextView textView5 ;
	TextView textView6 ;
	
	public void jump(View view) {
    	Intent i = new Intent(this, Memo_result.class);
    	startActivity(i);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Sherlock___Theme_DarkActionBar); 
		setContentView(R.layout.memo_cheack);
		db = helper.getReadableDatabase();
		// ポケモンの名前入力
		adapter1 = ArrayAdapter.createFromResource(this, R.array.day,
				android.R.layout.simple_dropdown_item_1line);
		_autoCompleteTextView1 = (AutoCompleteTextView) findViewById(R.id.pokemon_name);
		_autoCompleteTextView1.setAdapter(adapter1);
		_autoCompleteTextView1.setTextColor(Color.BLACK);

		// 道具
		adapter2 = ArrayAdapter.createFromResource(this, R.array.dougu,
				android.R.layout.simple_dropdown_item_1line);
		_autoCompleteTextView2 = (AutoCompleteTextView) findViewById(R.id.Spinner01);
		_autoCompleteTextView2.setAdapter(adapter2);
		_autoCompleteTextView2.setTextColor(Color.BLACK);
		
		// 特性
		adapter3 = ArrayAdapter.createFromResource(this, R.array.tokusei,
				android.R.layout.simple_dropdown_item_1line);
		_autoCompleteTextView3 = (AutoCompleteTextView) findViewById(R.id.EditText03);
		_autoCompleteTextView3.setAdapter(adapter3);
		_autoCompleteTextView3.setTextColor(Color.BLACK);
		
		// 技
		adapter4 = ArrayAdapter.createFromResource(this, R.array.waza,
				android.R.layout.simple_dropdown_item_1line);
		edit11 = (EditText) findViewById(R.id.AutoCompleteTextView04);
		edit11.setTextColor(Color.BLACK);
		edit12 = (EditText) findViewById(R.id.AutoCompleteTextView03);
		edit12.setTextColor(Color.BLACK);
		edit13 = (EditText) findViewById(R.id.AutoCompleteTextView02);
		edit13.setTextColor(Color.BLACK);
		edit14 = (EditText) findViewById(R.id.AutoCompleteTextView01);
		edit14.setTextColor(Color.BLACK);
		((AutoCompleteTextView) edit11).setAdapter(adapter4);
		((AutoCompleteTextView) edit12).setAdapter(adapter4);
		((AutoCompleteTextView) edit13).setAdapter(adapter4);
		((AutoCompleteTextView) edit14).setAdapter(adapter4);
		
		
		// 性格
		spinner1 = (Spinner) findViewById(R.id.seikaku);
		// 個体値
		edit4 = (EditText) findViewById(R.id.kotaiti_HP);
		edit4.setTextColor(Color.BLACK);
		edit5 = (EditText) findViewById(R.id.kotaiti_ATK);
		edit5.setTextColor(Color.BLACK);
		edit6 = (EditText) findViewById(R.id.kotaiti_DEF);
		edit6.setTextColor(Color.BLACK);
		edit7 = (EditText) findViewById(R.id.kotaiti_SATK);
		edit7.setTextColor(Color.BLACK);
		edit8 = (EditText) findViewById(R.id.kotaiti_SDEF);
		edit8.setTextColor(Color.BLACK);
		edit9 = (EditText) findViewById(R.id.kotaiti_SPE);
		edit9.setTextColor(Color.BLACK);
		edit10 = (EditText) findViewById(R.id.EditText01);
		edit10.setTextColor(Color.BLACK);

		edit15 = (EditText) findViewById(R.id.EditText02);
		edit15.setTextColor(Color.BLACK);
		// データベースの宣言
		// ＤＢオープン
		db = helper.getReadableDatabase();
		View Button = findViewById(R.id.button1);
		Button.setOnClickListener(this);

		
//		//-----------------広告　ここから-------------//
//		 RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.root);
//
//			        NendAdView nendAdView = 
//			                new NendAdView(getApplicationContext(), 152265, "7a354d40b5ee958b58d6f170de85d0b83ca02163");
//			        // 中央下部表示の場合
//			        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
//			                LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
//			        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
//			        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//			        // 上部表示の場合
//			        //params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//
//			        rootLayout.addView(nendAdView, params);
//
//			        nendAdView.loadAd();
//			    	//-----------------広告　ここまで-------------//
	}

	@Override
	public void onClick(View v) {
		// 例外処理
		 try {// 各種検索します。
		insert();
		
		 } catch (Exception e) {
		 // TODO: handle exception
		 // 確認ダイアログの生成
		 AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
		 alertDlg.setTitle("検索失敗");
		 alertDlg.setMessage("入力し忘れている部分はありませんか？");
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


	private void insert() {
		// TODO Auto-generated method stub
		try {

		    // トランザクション開始
            db.beginTransaction();
			ContentValues value = new ContentValues();
				Log.d("育成ポケモン", "");
				value.put("NAME", _autoCompleteTextView1.getText().toString());
				value.put("ニックネーム", edit15.getText().toString());
				value.put("特性", _autoCompleteTextView3.getText().toString());
				value.put("性格", spinner1.getSelectedItem().toString());
				value.put("道具",  _autoCompleteTextView2.getText().toString());
				value.put("HP", edit4.getText().toString());
				value.put("攻撃", edit5.getText().toString());
				value.put("防御", edit6.getText().toString());
				value.put("特攻", edit7.getText().toString());
				value.put("特防", edit8.getText().toString());
				value.put("素早", edit9.getText().toString());
				value.put("技1",  edit11.getText().toString());
				value.put("技2",  edit12.getText().toString());
				value.put("技3",  edit13.getText().toString());
				value.put("技4",  edit14.getText().toString());
				value.put("コメント",edit10.getText().toString());
				db.insert("育成ポケモン", null, value);
			 // 全件正常に挿入したら、トランザクション成功
            db.setTransactionSuccessful();
//		}catch (IOException e) {
//			 //TODO Auto-generated catch block
//			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            db.endTransaction();
            Toast.makeText(this, "登録しました", Toast.LENGTH_SHORT).show();   
        }
	}


}
