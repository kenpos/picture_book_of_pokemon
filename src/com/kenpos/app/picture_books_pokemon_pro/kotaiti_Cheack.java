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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class kotaiti_Cheack extends serch_methods implements OnClickListener {
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

	TextView[] HP0  =new TextView[32];
	TextView[] ATK0 =new TextView[32];
	TextView[] DEF0 =new TextView[32];
	TextView[] SATK0 =new TextView[32];
	TextView[] SDEF0 =new TextView[32];
	TextView[] SPE0 =new TextView[32];
	
    int[] HPs = {
    		R.id.kekka_HP0,
    		R.id.kekka_HP1,
    		R.id.kekka_HP2,
    		R.id.kekka_HP3,
    		R.id.kekka_HP4,
    		R.id.kekka_HP5,
    		R.id.kekka_HP6,
    		R.id.kekka_HP7,
    		R.id.kekka_HP8,
    		R.id.kekka_HP9,
    		R.id.kekka_HP10,
    		R.id.kekka_HP11,
    		R.id.kekka_HP12,
    		R.id.kekka_HP13,
    		R.id.kekka_HP14,
    		R.id.kekka_HP15,
    		R.id.kekka_HP16,
    		R.id.kekka_HP17,
    		R.id.kekka_HP18,
    		R.id.kekka_HP19,
    		R.id.kekka_HP20,
    		R.id.kekka_HP21,
    		R.id.kekka_HP22,
    		R.id.kekka_HP23,
    		R.id.kekka_HP24,
    		R.id.kekka_HP25,
    		R.id.kekka_HP26,
    		R.id.kekka_HP27,
    		R.id.kekka_HP28,
    		R.id.kekka_HP29,
    		R.id.kekka_HP30,
    		R.id.kekka_HP31
    		  };
    int[] ATKs ={R.id.kekka_ATK0,
    		R.id.kekka_ATK1,
    		R.id.kekka_ATK2,
    		R.id.kekka_ATK3,
    		R.id.kekka_ATK4,
    		R.id.kekka_ATK5,
    		R.id.kekka_ATK6,
    		R.id.kekka_ATK7,
    		R.id.kekka_ATK8,
    		R.id.kekka_ATK9,
    		R.id.kekka_ATK10,
    		R.id.kekka_ATK11,
    		R.id.kekka_ATK12,
    		R.id.kekka_ATK13,
    		R.id.kekka_ATK14,
    		R.id.kekka_ATK15,
    		R.id.kekka_ATK16,
    		R.id.kekka_ATK17,
    		R.id.kekka_ATK18,
    		R.id.kekka_ATK19,
    		R.id.kekka_ATK20,
    		R.id.kekka_ATK21,
    		R.id.kekka_ATK22,
    		R.id.kekka_ATK23,
    		R.id.kekka_ATK24,
    		R.id.kekka_ATK25,
    		R.id.kekka_ATK26,
    		R.id.kekka_ATK27,
    		R.id.kekka_ATK28,
    		R.id.kekka_ATK29,
    		R.id.kekka_ATK30,
    		R.id.kekka_ATK31
    		};
    int[] DEFs ={R.id.kekka_DEF0,
    		R.id.kekka_DEF1,
    		R.id.kekka_DEF2,
    		R.id.kekka_DEF3,
    		R.id.kekka_DEF4,
    		R.id.kekka_DEF5,
    		R.id.kekka_DEF6,
    		R.id.kekka_DEF7,
    		R.id.kekka_DEF8,
    		R.id.kekka_DEF9,
    		R.id.kekka_DEF10,
    		R.id.kekka_DEF11,
    		R.id.kekka_DEF12,
    		R.id.kekka_DEF13,
    		R.id.kekka_DEF14,
    		R.id.kekka_DEF15,
    		R.id.kekka_DEF16,
    		R.id.kekka_DEF17,
    		R.id.kekka_DEF18,
    		R.id.kekka_DEF19,
    		R.id.kekka_DEF20,
    		R.id.kekka_DEF21,
    		R.id.kekka_DEF22,
    		R.id.kekka_DEF23,
    		R.id.kekka_DEF24,
    		R.id.kekka_DEF25,
    		R.id.kekka_DEF26,
    		R.id.kekka_DEF27,
    		R.id.kekka_DEF28,
    		R.id.kekka_DEF29,
    		R.id.kekka_DEF30,
    		R.id.kekka_DEF31
};
    int[] SATKs ={R.id.kekka_SATK0,
    		R.id.kekka_SATK1,
    		R.id.kekka_SATK2,
    		R.id.kekka_SATK3,
    		R.id.kekka_SATK4,
    		R.id.kekka_SATK5,
    		R.id.kekka_SATK6,
    		R.id.kekka_SATK7,
    		R.id.kekka_SATK8,
    		R.id.kekka_SATK9,
    		R.id.kekka_SATK10,
    		R.id.kekka_SATK11,
    		R.id.kekka_SATK12,
    		R.id.kekka_SATK13,
    		R.id.kekka_SATK14,
    		R.id.kekka_SATK15,
    		R.id.kekka_SATK16,
    		R.id.kekka_SATK17,
    		R.id.kekka_SATK18,
    		R.id.kekka_SATK19,
    		R.id.kekka_SATK20,
    		R.id.kekka_SATK21,
    		R.id.kekka_SATK22,
    		R.id.kekka_SATK23,
    		R.id.kekka_SATK24,
    		R.id.kekka_SATK25,
    		R.id.kekka_SATK26,
    		R.id.kekka_SATK27,
    		R.id.kekka_SATK28,
    		R.id.kekka_SATK29,
    		R.id.kekka_SATK30,
    		R.id.kekka_SATK31
};
    int[] SDEFs ={R.id.kekka_SDEF0,
    		R.id.kekka_SDEF1,
    		R.id.kekka_SDEF2,
    		R.id.kekka_SDEF3,
    		R.id.kekka_SDEF4,
    		R.id.kekka_SDEF5,
    		R.id.kekka_SDEF6,
    		R.id.kekka_SDEF7,
    		R.id.kekka_SDEF8,
    		R.id.kekka_SDEF9,
    		R.id.kekka_SDEF10,
    		R.id.kekka_SDEF11,
    		R.id.kekka_SDEF12,
    		R.id.kekka_SDEF13,
    		R.id.kekka_SDEF14,
    		R.id.kekka_SDEF15,
    		R.id.kekka_SDEF16,
    		R.id.kekka_SDEF17,
    		R.id.kekka_SDEF18,
    		R.id.kekka_SDEF19,
    		R.id.kekka_SDEF20,
    		R.id.kekka_SDEF21,
    		R.id.kekka_SDEF22,
    		R.id.kekka_SDEF23,
    		R.id.kekka_SDEF24,
    		R.id.kekka_SDEF25,
    		R.id.kekka_SDEF26,
    		R.id.kekka_SDEF27,
    		R.id.kekka_SDEF28,
    		R.id.kekka_SDEF29,
    		R.id.kekka_SDEF30,
    		R.id.kekka_SDEF31
};
    int[] SPEs ={R.id.kekka_SPE0,
    		R.id.kekka_SPE1,
    		R.id.kekka_SPE2,
    		R.id.kekka_SPE3,
    		R.id.kekka_SPE4,
    		R.id.kekka_SPE5,
    		R.id.kekka_SPE6,
    		R.id.kekka_SPE7,
    		R.id.kekka_SPE8,
    		R.id.kekka_SPE9,
    		R.id.kekka_SPE10,
    		R.id.kekka_SPE11,
    		R.id.kekka_SPE12,
    		R.id.kekka_SPE13,
    		R.id.kekka_SPE14,
    		R.id.kekka_SPE15,
    		R.id.kekka_SPE16,
    		R.id.kekka_SPE17,
    		R.id.kekka_SPE18,
    		R.id.kekka_SPE19,
    		R.id.kekka_SPE20,
    		R.id.kekka_SPE21,
    		R.id.kekka_SPE22,
    		R.id.kekka_SPE23,
    		R.id.kekka_SPE24,
    		R.id.kekka_SPE25,
    		R.id.kekka_SPE26,
    		R.id.kekka_SPE27,
    		R.id.kekka_SPE28,
    		R.id.kekka_SPE29,
    		R.id.kekka_SPE30,
    		R.id.kekka_SPE31
};
    
    
    TableRow row ;
	TableLayout table ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Sherlock___Theme_DarkActionBar);
		setContentView(R.layout.kotaiti_cheack);

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

	for(int i=0 ;i<32;i++){
		HP0[i] = (TextView)findViewById(HPs[i]);
		ATK0[i] = (TextView)findViewById(ATKs[i]);
		DEF0[i] = (TextView)findViewById(DEFs[i]);
		SATK0[i] = (TextView)findViewById(SATKs[i]);
		SDEF0[i] = (TextView)findViewById(SDEFs[i]);
		SPE0[i] = (TextView)findViewById(SPEs[i]);
	}

		
		// データベースの宣言
		// ＤＢオープン
		db = helper.getReadableDatabase();
		View Button = findViewById(R.id.button1);
		Button.setOnClickListener(this);
		


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
		
		//ステータス
		HP_k = Integer.parseInt(edit4.getText().toString());
		ATK_k =Integer.parseInt(edit5.getText().toString());
		DEF_k =Integer.parseInt(edit6.getText().toString());
		SATK_k =Integer.parseInt(edit7.getText().toString());
		SDEF_k =Integer.parseInt(edit8.getText().toString());
		SPE_k =Integer.parseInt(edit9.getText().toString());
		
		//努力値
		HP_d = Integer.parseInt(edit10.getText().toString());
		ATK_d =Integer.parseInt(edit11.getText().toString());
		DEF_d =Integer.parseInt(edit12.getText().toString());
		SATK_d =Integer.parseInt(edit13.getText().toString());
		SDEF_d =Integer.parseInt(edit14.getText().toString());
		SPE_d =Integer.parseInt(edit15.getText().toString());
		
		for(int doryokuti=31;doryokuti>=0;doryokuti--){
		HP_a = ((HP * 2 + doryokuti + HP_d / 4) * LV / 100) + 10 + LV;
		ATK_a = (int) ((((ATK * 2 + doryokuti + ATK_d / 4) * LV / 100) + 5) * HOSEI1);
		DEF_a = (int) ((((DEF * 2 + doryokuti + DEF_d / 4) * LV / 100) + 5) * HOSEI2);
		SATK_a = (int) ((((SATK * 2 + doryokuti + SATK_d / 4) * LV / 100) + 5) * HOSEI3);
		SDEF_a = (int) ((((SDEF * 2 + doryokuti + SDEF_d / 4) * LV / 100) + 5) * HOSEI4);
		SPE_a = (int) ((((SPE * 2 + doryokuti + SPE_d / 4) * LV / 100) + 5) * HOSEI5);

		HP0[doryokuti].setText(String.valueOf(HP_a));
		ATK0[doryokuti].setText(String.valueOf(ATK_a));
		DEF0[doryokuti].setText(String.valueOf(DEF_a));
		SATK0[doryokuti].setText(String.valueOf(SATK_a));
		SDEF0[doryokuti].setText(String.valueOf(SDEF_a));
		SPE0[doryokuti].setText(String.valueOf(SPE_a));

		if(HP_a==HP_k){
			 HP0[doryokuti].setBackgroundColor(Color.RED);
		}if(ATK_a==ATK_k){
			ATK0[doryokuti].setBackgroundColor(Color.RED);
		}if(DEF_a==DEF_k){
			DEF0[doryokuti].setBackgroundColor(Color.RED);
		}if(SATK_a==SATK_k){
			SATK0[doryokuti].setBackgroundColor(Color.RED);
		}if(SDEF_a==SDEF_k){
			SDEF0[doryokuti].setBackgroundColor(Color.RED);
		}if(SPE_a==SPE_k){
			SPE0[doryokuti].setBackgroundColor(Color.RED);
		}
		
		}

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
