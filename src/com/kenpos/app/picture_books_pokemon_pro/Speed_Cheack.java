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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Speed_Cheack extends serch_methods implements OnClickListener {
	protected Cursor cursor;
	protected ListAdapter adapter;
	protected ListView cigaretteList;
	static EditText level1, level2,kotaiti1,kotaiti2,doryokuti1,doryokuti2;
	static SQLiteDatabase db;
	DatabaseHelper helper = new DatabaseHelper(this);
	public String serch1, serch2, serch3, serch4, serch5, serch6, serch7;
	Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8;
	// 実測値
	int SPE1, SPE2;
	// 努力値
	int SPE_d1 = 0, SPE_d2 = 0;
	// 個体値
	int SPE_k1 = 0, SPE_k2 = 0;
	//種族値
	int SPE_s1 = 0, SPE_s2 = 0;
	// 結果
	int SPE_a1 = 0, SPE_a2 = 0;
	int LV1, LV2;
	double HOSEI1 = 1.0, HOSEI2 = 1.0;
	private ArrayAdapter<CharSequence> adapter1;
	private AutoCompleteTextView NAME1, NAME2;

	TextView textView1;
	TextView textView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Sherlock___Theme_DarkActionBar);
		setContentView(R.layout.speed_cheack);

		// ポケモンの名前入力
		adapter1 = ArrayAdapter.createFromResource(this, R.array.day,
				android.R.layout.simple_dropdown_item_1line);
		NAME1 = (AutoCompleteTextView) findViewById(R.id.name1);
		NAME1.setAdapter(adapter1);
		NAME1.setTextColor(Color.BLACK);
		NAME2 = (AutoCompleteTextView) findViewById(R.id.name2);
		NAME2.setAdapter(adapter1);
		NAME2.setTextColor(Color.BLACK);

		spinner1 = (Spinner) findViewById(R.id.seikaku1);
		spinner3 = (Spinner) findViewById(R.id.tokusei_Spinner1);
		spinner5 = (Spinner) findViewById(R.id.dougu_Spinner1);
		spinner7 = (Spinner) findViewById(R.id.Rank_Spinner1);
		
		spinner2 = (Spinner) findViewById(R.id.seikaku_spinner2);
		spinner4 = (Spinner) findViewById(R.id.tokusei2);
		spinner6 = (Spinner) findViewById(R.id.dougu_Spinner2);
		spinner8 = (Spinner) findViewById(R.id.Rank_Spinner2);
		
		
		level1 = (EditText) findViewById(R.id.level1);
		level1.setTextColor(Color.BLACK);
		level2 = (EditText) findViewById(R.id.level2);
		level2.setTextColor(Color.BLACK);
		// 個体値
		kotaiti1 = (EditText) findViewById(R.id.kotaiti1);
		kotaiti1.setTextColor(Color.BLACK);
		kotaiti2 = (EditText) findViewById(R.id.kotaiti2);
		kotaiti2.setTextColor(Color.BLACK);

		// 努力値
		doryokuti1 = (EditText) findViewById(R.id.doryokuti1);
		doryokuti1.setTextColor(Color.BLACK);
		doryokuti2 = (EditText) findViewById(R.id.doryokuti2);
		doryokuti2.setTextColor(Color.BLACK);

		textView1 = (TextView) findViewById(R.id.kekka_SPE1);
		textView2 = (TextView) findViewById(R.id.kekka_SPE2);

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
			//例外処理しとこ
			if(NAME1.getText().toString().length()>0){
			serch1 = NAME1.getText().toString();
			serch2 = (String) spinner1.getSelectedItem();
			SPE_d1 = Integer.parseInt(doryokuti1.getText().toString());
			SPE_k1 = Integer.parseInt(kotaiti1.getText().toString());
			LV1 = Integer.parseInt(level1.getText().toString());
			SPE_s1 = kensaku_syuzokuti(serch1);
			HOSEI1	= check(serch2);
			SPE_a1 = keisan(SPE_s1,SPE_k1,SPE_d1,LV1,HOSEI1);
			
			//補正値を取得して計算していく
		 double	tokusei1 = tokusei((String) spinner3.getSelectedItem());
		 double dougu1 =ITEM((String) spinner5.getSelectedItem());
		 double rank1 =rank((String) spinner7.getSelectedItem());
		 SPE_a1 =(int)(SPE_a1 * tokusei1 * dougu1 * rank1);
	
		 //麻痺の場合
		final CheckBox chkbox = (CheckBox)findViewById(R.id.mahi_checkBox1);
		if(chkbox.isChecked() == true) {
			SPE_a1 =(int)(SPE_a1 * 0.25);
		}	
	 //おいかぜの場合
	final CheckBox chkbox2 = (CheckBox)findViewById(R.id.oikaze_checkBox1);
	if(chkbox2.isChecked() == true) {
		SPE_a1 =(int)(SPE_a1 * 2.0);
	}
			textView1.setText(String.valueOf(SPE_a1));
			}

			
			if(NAME2.getText().toString().length()>0){
			serch3 = NAME2.getText().toString();
			serch4 = (String) spinner2.getSelectedItem();
			SPE_d2 = Integer.parseInt(doryokuti1.getText().toString());
			SPE_k2 = Integer.parseInt(kotaiti1.getText().toString());
			LV2 = Integer.parseInt(level1.getText().toString());
			SPE_s2 = kensaku_syuzokuti(serch3);
			HOSEI2	= check(serch4);
			SPE_a2 = keisan(SPE_s2,SPE_k2,SPE_d2,LV2,HOSEI2);
			
			//補正値取得して計算していく
			 double	tokusei2 = tokusei((String) spinner4.getSelectedItem());
			 double dougu2 =ITEM((String) spinner6.getSelectedItem());
			 double rank2 =rank((String) spinner8.getSelectedItem());
			 SPE_a2 =(int)(SPE_a2 * tokusei2 * dougu2 * rank2);
			 
			 //麻痺の場合
				final CheckBox chkbox3 = (CheckBox)findViewById(R.id.mahi_checkBox2);
				if(chkbox3.isChecked() == true) {
					SPE_a2 =(int)(SPE_a2 * 0.25);
				}
				//追い風の場合
				 //麻痺の場合
				final CheckBox chkbox4 = (CheckBox)findViewById(R.id.oikaze_checkBox2);
				if(chkbox4.isChecked() == true) {
					SPE_a2 =(int)(SPE_a2 * 2.0);
				}		
				textView2.setText(String.valueOf(SPE_a2));
			}
			
	
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

	//全てを計算します。
	private int keisan(int spe_s,int spe_k,int spe_d,int lv,double hosei) {
		// TODO Auto-generated method stub
		return (int) ((((spe_s * 2 + spe_k + spe_d / 4) * lv / 100) + 5) * hosei);
	}

	
	//性格に対する補正を行います
	private double check(String seikaku) {
		if (seikaku.equals("おくびょう") || seikaku.equals("せっかち")
				|| seikaku.equals("ようき") || seikaku.equals("むじゃき")) {
			return 1.1;
		}
		else if (seikaku.equals("ゆうかん") || seikaku.equals("のんき")
				|| seikaku.equals("なまいき") || seikaku.equals("れいせい")) {
			return 0.9;
		}
		return 1.0;
	}
	
	//特性に対する補正を行います
	private double tokusei(String seikaku) {
		if (seikaku.equals("すいすい") || seikaku.equals("ようりょくそ")
				|| seikaku.equals("かるわざ")) {
			return 2.0;
		}
		else if (seikaku.equals("はやあし")) {
			return 1.5;
		}else if (seikaku.equals("スロースタート")){
			return 0.5;
		}
		return 1.0;
	}
	
	//道具に対する補正を行います
	private double ITEM(String seikaku) {
		if (seikaku.equals("こだわりスカーフ")) {
			return 2.0;
		}
		else if (seikaku.equals("スピードパウダー")) {
			return 1.5;
		}else if (seikaku.equals("くろいてっきゅう")||seikaku.equals("きょうせいギブス")||seikaku.equals("パワー系")) {
			return 0.5;
		}
		return 1.0;
	}

	//ランクに対する補正を行います
	private double rank(String seikaku) {
		if (seikaku.equals("+1")) {
			return 1.5;
		}
		else if (seikaku.equals("+2")) {
			return 2.0;
		}		else if (seikaku.equals("+3")) {
			return 2.5;
		}		else if (seikaku.equals("+4")) {
			return 3.0;
		}		else if (seikaku.equals("+5")) {
			return 3.5;
		}		else if (seikaku.equals("+6")) {
			return 4.0;
		}		else if (seikaku.equals("-1")) {
			return 0.67;
		}		else if (seikaku.equals("-2")) {
			return 0.5;
		}		else if (seikaku.equals("-3")) {
			return 0.4;
		}		else if (seikaku.equals("-4")) {
			return 0.33;
		}		else if (seikaku.equals("-5")) {
			return 0.29;
		}		else if (seikaku.equals("-6")) {
			return 0.25;
		}
			return 1.0;
	}
	
	
	
//名前から検索して
	private int kensaku_syuzokuti(String type1) {
		String s_SPE = "";
		String table = "ステータス";
		String[] columns = { "素早" };
		String selection = "NAME = ?";
		String[] selectionArgs = { type1 };
		String limit = null;

		Cursor c = db.query(table, columns, selection, selectionArgs, null,
				null, null, limit);
		c.moveToFirst();

		s_SPE = c.getString(0);

		return Integer.parseInt(s_SPE);

	}
}
