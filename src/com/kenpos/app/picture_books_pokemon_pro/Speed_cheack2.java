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

public class Speed_cheack2 extends serch_methods implements OnClickListener{
	
	protected Cursor cursor;
	protected ListAdapter adapter;
	protected ListView cigaretteList;
	static EditText level1, level2,kotaiti1,kotaiti2,doryokuti1,doryokuti2;
	static SQLiteDatabase db;
	DatabaseHelper helper = new DatabaseHelper(this);
	public String serch1, serch2, serch3, serch4, serch5, serch6, serch7;
	Spinner spinner1,spinner3,spinner5,spinner7;
	CheckBox chkbox1,chkbox2,chkbox3,chkbox4;
	int LV1;
	double HOSEI1 = 1.0;
	private ArrayAdapter<CharSequence> adapter1;
	private AutoCompleteTextView NAME1;
	TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10,textView11,textView12,textView13;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTheme(R.style.Sherlock___Theme_DarkActionBar);
		setContentView(R.layout.speed_cheack2);
		promotion_method();
		
		// ポケモンの名前入力
		adapter1 = ArrayAdapter.createFromResource(this, R.array.day,
				android.R.layout.simple_dropdown_item_1line);
		NAME1 = (AutoCompleteTextView) findViewById(R.id.name1);
		NAME1.setAdapter(adapter1);
		NAME1.setTextColor(Color.BLACK);

		spinner1 = (Spinner) findViewById(R.id.seikaku1);
		spinner5 = (Spinner) findViewById(R.id.dougu_Spinner1);
		spinner7 = (Spinner) findViewById(R.id.Rank_Spinner1);
		
		level1 = (EditText) findViewById(R.id.level1);
		level1.setTextColor(Color.BLACK);
		// 個体値
		kotaiti1 = (EditText) findViewById(R.id.kotaiti1);
		kotaiti1.setTextColor(Color.BLACK);

		// 努力値
		doryokuti1 = (EditText) findViewById(R.id.doryokuti1);
		doryokuti1.setTextColor(Color.BLACK);

		chkbox1 = (CheckBox)findViewById(R.id.mahi_checkBox1);
		chkbox4 = (CheckBox)findViewById(R.id.oikaze_checkBox1);
		chkbox3 = (CheckBox)findViewById(R.id.hayaasi_checkBox1);
		chkbox2 = (CheckBox)findViewById(R.id.abi_Box01);
		
		 textView1 = (TextView)findViewById(R.id.textView6);
		 textView2 = (TextView)findViewById(R.id.text1);
		 textView3 = (TextView)findViewById(R.id.text3);
		 textView4 = (TextView)findViewById(R.id.text4);
		 textView5 = (TextView)findViewById(R.id.text5);
		 textView6 = (TextView)findViewById(R.id.text6);
		 textView7 = (TextView)findViewById(R.id.text7);
		 textView8 = (TextView)findViewById(R.id.text8);
		 textView9 = (TextView)findViewById(R.id.text10);
		 textView10 = (TextView)findViewById(R.id.text11);
		 textView11 = (TextView)findViewById(R.id.text12);
		 textView12 = (TextView)findViewById(R.id.text13);
		 textView13 = (TextView)findViewById(R.id.text14);
		 
		// データベースの宣言
		// ＤＢオープン
		db = helper.getReadableDatabase();
		View Button = findViewById(R.id.button1);
		Button.setOnClickListener(this);
		
	}

	
	void calculate() {
			if(NAME1.getText().toString().length()>0){

			//種族値
			int str1 = kensaku_syuzokuti(NAME1.getText().toString());	
			//レベル
			int str2 = Integer.parseInt(level1.getText().toString());
			//個体値
			int str3 =  Integer.parseInt(kotaiti1.getText().toString());
			//努力値
			int str4 =Integer.parseInt(doryokuti1.getText().toString());
			//性格
			double str5 = check((String) spinner1.getSelectedItem());
			//ランク補正
			double str6 = rank((String) spinner7.getSelectedItem());
			//持ち物
			double str7 = ITEM((String) spinner5.getSelectedItem());
			double str8;
			double str9;
			double str10;
			double str11;
			

			//麻痺
			if ( chkbox1.isChecked() == true ){ 
				 str8 = 0.25;
			}else{ 
				 str8 = 1;
			}
			
			//すいすい、葉緑素、すなかき、カルワザ（＊2）
			if (  chkbox2.isChecked() == true ){ 
			 str9 = 2;
			}else{
			 str9 = 1;
			}
			
			//はやあし
			if (  chkbox3.isChecked() == true  ){
				 str10 = 1.5;
			}else{ 
				 str10 = 1;
			}
			
			//おいかぜ
			if (  chkbox4.isChecked() == true  ){
				str11 = 2;
			}else{ 
				str11 = 1;
			}

			//素早さ実数値計算
			double speed =  Math.floor( ( ( ( ( str1 *2 + str3 + str4/4 ) * str2/100 ) +5 ) * str5 ) );

			speed = speed * str6;					// ランク補正
			speed = speed * str7; 					// アイテム補正
			if ( chkbox1.isChecked() == true  )  speed = Math.floor(speed * str8); 	// 麻痺
			if (  chkbox2.isChecked() == true )  speed = Math.floor(speed * str9);	 	// 特性
			if (  chkbox3.isChecked() == true  )  speed = Math.floor(speed * str10); 	// 早足
			if (chkbox4.isChecked() == true  )  speed = Math.floor(speed * str11); 	// 追い風

			//比較対象計算開始
			double h1 = ((50*speed)/(str2*1.1)) - (250/str2) - (31/2) - (252/8);	//最速
			double h2 = ((50*speed)/(str2*1)) - (250/str2) - (31/2) - (252/8);		//準速
			double h3 = ((50*speed)/(str2*1)) - (250/str2) - (31/2);				//無振り
			double h4 = ((50*speed)/(str2*0.9)) - (250/str2);					//最遅
			double h5 = ((50*speed*2/3)/(str2*1.1)) - (250/str2) - (31/2) - (252/8);		//最速スカーフ
			double h6 = ((50*speed*1.5)/(str2*1.1)) - (250/str2) - (31/2) - (252/8);		//最速ねばねば

			 
		    	textView1.setText("素早さ実数値："+speed);
		    	textView2.setText(Math.ceil(h1)-1+"族抜き");
		    	textView3.setText(Math.ceil(h2)-1+"族抜き");
		    	textView4.setText(Math.ceil(h3)-1+"族抜き");
		    	textView5.setText(Math.ceil(h4)-1+"族抜き");
		    	textView6.setText(Math.ceil(h5)-1+"族抜き");
		    	textView7.setText(Math.ceil(h6)-1+"族抜き");

			int i = 1;
			int end = 180;	//全ポケモン中最速種族値
			double speed2 = 0;

			for ( ; i >0 ; i++ ) {	//最速比較計算
				speed2 = Math.floor(((( i*2 + 31 + 63 ) * str2/100 ) +5 ) *1.1 );
				if ( speed == speed2 ) {
					textView8.setText( i + "と同族");
					i = -1;
				}
				if ( speed < speed2 ) {
					textView8.setText( "-");
					break;
				}
			}
			for ( i=1 ; i >0 ; i++ ) {	//準速比較計算
				speed2 = Math.floor((( i*2 + 31 + 63 ) * str2/100 ) +5 );
				if ( speed == speed2 ) {
					textView9.setText( i + "と同族");
					i = -1;
				}
				if ( speed < speed2 ) {
					textView9.setText( "-");
					break;
				}
			}
			for ( i=1 ; i >0 ; i++ ) {	//無振り比較計算
				speed2 = Math.floor((( i*2 + 31 ) * str2/100 ) +5 );
				if ( speed == speed2 ) {
					textView10.setText( i + "と同族");
					i = -1;
				}
				if ( speed < speed2 ) {
					textView10.setText( "-");
					break;
				}
			}
			for ( i=1 ; i >0 ; i++ ) {	//最遅比較計算
				speed2 = Math.floor(((( i*2 ) * str2/100 ) +5 ) *0.9 );
				if ( speed == speed2 ) {
					textView11.setText( i + "と同族");
					i = -1;
				}
				if ( speed < speed2 ) {
					textView11.setText( "-");
					break;
				}
			}
			for ( i=1 ; i >0 ; i++ ) {	//最速スカーフ比較計算
				speed2 = Math.floor(Math.floor(((( i*2 + 31 + 63 ) * str2/100 ) +5 ) *1.1 ) *1.5);
				if ( speed == speed2 ) {
					textView12.setText( i + "と同族");
					i = -1;
				}
				if ( speed < speed2 ) {
					textView12.setText( "-");
					break;
				}
			}
			for ( i=1 ; i >0 ; i++ ) {	//最速ねばねば比較計算
				speed2 = Math.floor(Math.floor(((( i*2 + 31 + 63 ) * str2/100 ) +5 ) *1.1 ) *2/3);
				if ( speed == speed2 ) {
					textView13.setText( i + "と同族");
					i = -1;
				}
				if ( speed < speed2 ) {
					textView13.setText( "-");
					break;
				}
			}
			} 
	}

			//名前から検索して
			private int kensaku_syuzokuti(String type1) {
				String s_SPE = "";
				String table = "ステータス";
				String[] columns = { "素早" };
				String selection = "NAME LIKE ?";
				String[] selectionArgs = { type1+"%" };
				String limit = null;

				Cursor c = db.query(table, columns, selection, selectionArgs, null,
						null, null, limit);
				c.moveToFirst();

				s_SPE = c.getString(0);

				return Integer.parseInt(s_SPE);

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
			
			
			//道具に対する補正を行います
			private double ITEM(String seikaku) {
				if (seikaku.equals("こだわりスカーフ")) {
					return 1.5;
				}
				else if (seikaku.equals("スピードパウダー")||seikaku.equals("カムラのみ")) {
					return 1.5;
				}else if (seikaku.equals("くろいてっきゅう")||seikaku.equals("きょうせいギプス")||seikaku.equals("パワー系")) {
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
					return 0.666666666666667;
				}		else if (seikaku.equals("-2")) {
					return 0.5;
				}		else if (seikaku.equals("-3")) {
					return 0.4;
				}		else if (seikaku.equals("-4")) {
					return 0.333333333333333;
				}		else if (seikaku.equals("-5")) {
					return 0.285714285714285;
				}		else if (seikaku.equals("-6")) {
					return 0.25;
				}
					return 1.0;
			}


		@Override
		public void onClick(View v) {
			// 例外処理
			try {// 各種検索します。
				//例外処理しとこ
				calculate();
		
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
	}