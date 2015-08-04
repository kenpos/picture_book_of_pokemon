package com.kenpos.app.picture_books_pokemon_pro;


import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.DatabaseHelper;
import com.kenpos.app.picture_books_pro_pokemon_variables.serch_methods;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Status_Cheack extends serch_methods implements OnClickListener {
	protected Cursor cursor;
	protected ListAdapter adapter;
	protected ListView cigaretteList;
	static EditText edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8,
			edit9, edit10, edit11, edit12, edit13, edit14, edit15;
	static SQLiteDatabase db;
	DatabaseHelper helper = new DatabaseHelper(this);
	public String serch1, serch2, serch3, serch4, serch5, serch6, serch7,
			serch8, serch9, serch10, serch11, serch12, serch13, serch14,
			serch15;
	Spinner spinner1;
	int HP, ATK, DEF, SATK, SDEF, SPE;
	int HP_d=0, ATK_d=0, DEF_d=0, SATK_d=0, SDEF_d=0, SPE_d=0;
	int HP_k=0, ATK_k=0, DEF_k=0, SATK_k=0, SDEF_k=0, SPE_k=0;
	int HP_a=0, ATK_a=0, DEF_a=0, SATK_a=0, SDEF_a=0, SPE_a=0;
	int LV;
	double HOSEI1 = 1.0, HOSEI2 = 1.0, HOSEI3 = 1.0, HOSEI4 = 1.0,
			HOSEI5 = 1.0, HOSEI6 = 1.0;

	private ArrayAdapter<CharSequence> adapter1;
	private AutoCompleteTextView _autoCompleteTextView;

	TextView textView1; 
	TextView textView2 ;
	TextView textView3 ;
	TextView textView4 ;
	TextView textView5 ;
	TextView textView6 ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Sherlock___Theme_DarkActionBar); 
		setContentView(R.layout.status_cheack);

		// ポケモンの名前入力
		adapter1 = ArrayAdapter.createFromResource(this, R.array.day,
				android.R.layout.simple_dropdown_item_1line);
		_autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.pokemon_name);
		_autoCompleteTextView.setAdapter(adapter1);
		_autoCompleteTextView.setTextColor(Color.BLACK);

		// Spinnerオブジェクトを取得
		spinner1 = (Spinner) findViewById(R.id.seikaku);
		edit3 = (EditText) findViewById(R.id.level);
		edit3.setTextColor(Color.BLACK);

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

		// 努力値
		edit10 = (EditText) findViewById(R.id.doryokuti_HP);
		edit10.setTextColor(Color.BLACK);
		edit11 = (EditText) findViewById(R.id.doryokuti_ATK);
		edit11.setTextColor(Color.BLACK);
		edit12 = (EditText) findViewById(R.id.doryokuti_DEF);
		edit12.setTextColor(Color.BLACK);
		edit13 = (EditText) findViewById(R.id.doryokuti_SATK);
		edit13.setTextColor(Color.BLACK);
		edit14 = (EditText) findViewById(R.id.doryokuti_SDEF);
		edit14.setTextColor(Color.BLACK);
		edit15 = (EditText) findViewById(R.id.doryokuti_SPE);
		edit15.setTextColor(Color.BLACK);

		textView1 = (TextView)findViewById(R.id.kekka_HP);
		textView2 = (TextView)findViewById(R.id.kekka_ATK);
		textView3 = (TextView)findViewById(R.id.kekka_DEF);
		textView4 = (TextView)findViewById(R.id.kekka_SATK);
		textView5 = (TextView)findViewById(R.id.kekka_SDEF);
		textView6 = (TextView)findViewById(R.id.kekka_SPE);
		
        
		// データベースの宣言
		// ＤＢオープン
		db = helper.getReadableDatabase();
		View Button = findViewById(R.id.button1);
		Button.setOnClickListener(this);

		
		//-----------------広告　ここから-------------//
		promotion_method();
			    	//-----------------広告　ここまで-------------//
	}

	@Override
	public void onClick(View v) {
		// 例外処理
		 try {// 各種検索します。
		// Spinnerオブジェクトを取得
		serch1 = _autoCompleteTextView.getText().toString();
		serch2 = (String) spinner1.getSelectedItem();
		serch3 = edit3.getText().toString();
		kensaku_tokusei(serch1);
		
		
		check();
		keisan();

		textView1.setText(String.valueOf(HP_a));
		textView2.setText(String.valueOf(ATK_a));
		textView3.setText(String.valueOf(DEF_a));
		textView4.setText(String.valueOf(SATK_a));
		textView5.setText(String.valueOf(SDEF_a));
		textView6.setText(String.valueOf(SPE_a));
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

	private void keisan() {
		// TODO Auto-generated method stub
		// HP
		HP_k = Integer.parseInt(edit4.getText().toString());
		ATK_k =Integer.parseInt(edit5.getText().toString());
		DEF_k =Integer.parseInt(edit6.getText().toString());
		SATK_k =Integer.parseInt(edit7.getText().toString());
		SDEF_k =Integer.parseInt(edit8.getText().toString());
		SPE_k =Integer.parseInt(edit9.getText().toString());
		
		HP_d = Integer.parseInt(edit10.getText().toString());
		ATK_d =Integer.parseInt(edit11.getText().toString());
		DEF_d =Integer.parseInt(edit12.getText().toString());
		SATK_d =Integer.parseInt(edit13.getText().toString());
		SDEF_d =Integer.parseInt(edit14.getText().toString());
		SPE_d =Integer.parseInt(edit15.getText().toString());
		
		HP_a = ((HP * 2 + HP_k + HP_d / 4) * LV / 100) + 10 + LV;
		ATK_a = (int) ((((ATK * 2 + ATK_k + ATK_d / 4) * LV / 100) + 5) * HOSEI1);
		DEF_a = (int) ((((DEF * 2 + DEF_k + DEF_d / 4) * LV / 100) + 5) * HOSEI2);
		SATK_a = (int) ((((SATK * 2 + SATK_k + SATK_d / 4) * LV / 100) + 5) * HOSEI3);
		SDEF_a = (int) ((((SDEF * 2 + SDEF_k + SDEF_d / 4) * LV / 100) + 5) * HOSEI4);
		SPE_a = (int) ((((SPE * 2 + SPE_k + SPE_d / 4) * LV / 100) + 5) * HOSEI5);

		System.out.print(HP_a);
		System.out.print(ATK_a);
		System.out.print(DEF_a);
		System.out.print(ATK_a);
		System.out.print(DEF_a);
		System.out.print(SPE_a);


	}

	private void check() {
		HOSEI1 = 1.0; HOSEI2 = 1.0; HOSEI3 = 1.0; HOSEI4 = 1.0;
				HOSEI5 = 1.0; HOSEI6 = 1.0;
		if (serch2.equals("さみしがり") || serch2.equals("いじっぱり")
				|| serch2.equals("やんちゃ") || serch2.equals("ゆうかん")) {
			HOSEI1 = 1.1;

		} else if (serch2.equals("ずぶとい") || serch2.equals("わんぱく")
				|| serch2.equals("のうてんい") || serch2.equals("のんき")) {
			HOSEI2 = 1.1;

		} else if (serch2.equals("ひかえめ") || serch2.equals("おっとり")
				|| serch2.equals("うっかりや") || serch2.equals("れいせい")) {
			HOSEI3 = 1.1;

		} else if (serch2.equals("おだやか") || serch2.equals("おとなしい")
				|| serch2.equals("しんちょう") || serch2.equals("なまいき")) {
			HOSEI4 = 1.1;

		} else if (serch2.equals("おくびょう") || serch2.equals("せっかち")
				|| serch2.equals("ようき") || serch2.equals("むじゃき")) {
			HOSEI5 = 1.1;
		}

		if (serch2.equals("ずぶとい") || serch2.equals("ひかえめ")
				|| serch2.equals("おだやか") || serch2.equals("おくびょう")) {
			HOSEI1 = 0.9;

		} else if (serch2.equals("さみしがり") || serch2.equals("おっとり")
				|| serch2.equals("おとなしい") || serch2.equals("せっかち")) {
			HOSEI2 = 0.9;

		} else if (serch2.equals("いじっぱり") || serch2.equals("わんぱく")
				|| serch2.equals("しんちょう") || serch2.equals("ようき")) {
			HOSEI3 = 0.9;

		} else if (serch2.equals("やんちゃ") || serch2.equals("うっかりや")
				|| serch2.equals("むじゃき") || serch2.equals("のうてんき")) {
			HOSEI4 = 0.9;

		} else if (serch2.equals("ゆうかん") || serch2.equals("のんき")
				|| serch2.equals("なまいき") || serch2.equals("れいせい")) {
			HOSEI5 = 0.9;

		}
	}

	private void kensaku_tokusei(String type1) {
		String s_HP = "", s_ATK = "", s_DEF = "", s_SATK = "", s_SDEF = "", s_SPE = "";
		String table = "ステータス";
		String[] columns = { "HP", "攻撃", "防御", "特攻", "特防", "素早" };
		String selection = "NAME = ?";
		String[] selectionArgs = { type1 };
		String limit = null;

		Cursor c = db.query(table, columns, selection, selectionArgs, null,
				null, null, limit);
		c.moveToFirst();

		s_HP = c.getString(0);
		s_ATK = c.getString(1);
		s_DEF = c.getString(2);
		s_SATK = c.getString(3);
		s_SDEF = c.getString(4);
		s_SPE = c.getString(5);

		HP = Integer.parseInt(s_HP);
		ATK = Integer.parseInt(s_ATK);
		DEF = Integer.parseInt(s_DEF);
		SATK = Integer.parseInt(s_SATK);
		SDEF = Integer.parseInt(s_SDEF);
		SPE = Integer.parseInt(s_SPE);

		HP_d = Integer.parseInt(edit4.getText().toString());
		ATK_d = Integer.parseInt(edit5.getText().toString());
		DEF_d = Integer.parseInt(edit6.getText().toString());
		SATK_d = Integer.parseInt(edit7.getText().toString());
		SDEF_d = Integer.parseInt(edit8.getText().toString());
		SPE_d = Integer.parseInt(edit9.getText().toString());

		HP_k = Integer.parseInt(edit10.getText().toString());
		ATK_k = Integer.parseInt(edit11.getText().toString());
		DEF_k = Integer.parseInt(edit12.getText().toString());
		SATK_k = Integer.parseInt(edit13.getText().toString());
		SDEF_k = Integer.parseInt(edit14.getText().toString());
		SPE_k = Integer.parseInt(edit15.getText().toString());

		LV = Integer.parseInt(edit3.getText().toString());
	}
}
