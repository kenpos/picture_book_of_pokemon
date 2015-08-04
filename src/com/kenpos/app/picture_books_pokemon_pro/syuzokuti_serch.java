package com.kenpos.app.picture_books_pokemon_pro;


import com.kenpos.app.picture_books_pro_pokemon_variables.serch_methods;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class syuzokuti_serch extends serch_methods implements OnClickListener {
	
	static EditText edit1,edit2,edit3,edit4,edit5,edit6;
	static SQLiteDatabase db;
	private static String serch1,serch2,serch3,serch4,serch5,serch6;
	public static int count = 0;
	public static RadioGroup group1,group2,group3,group4,group5,group6;
	//広告用
	//				
	String  HP ="", ATK="",DEF="",SATK="",SDEF="",SPE="";
	Intent intent;
	@Override

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Sherlock___Theme_DarkActionBar); 
		setContentView(R.layout.syuzokuti_serch);
	
		edit1 = (EditText) findViewById(R.id.editText1);
		edit1.setTextColor(Color.BLACK);
		edit2 = (EditText) findViewById(R.id.editText2);
		edit2.setTextColor(Color.BLACK);
		edit3 = (EditText) findViewById(R.id.editText3);
		edit3.setTextColor(Color.BLACK);
		edit4 = (EditText) findViewById(R.id.editText4);
		edit4.setTextColor(Color.BLACK);
		edit5 = (EditText) findViewById(R.id.editText5);
		edit5.setTextColor(Color.BLACK);
		edit6 = (EditText) findViewById(R.id.editText6);
		edit6.setTextColor(Color.BLACK);
		group1 = (RadioGroup)this.findViewById(R.id.radioGroup1);
		group2 = (RadioGroup)this.findViewById(R.id.radioGroup2);
		group3 = (RadioGroup)this.findViewById(R.id.radioGroup3);
		group4 = (RadioGroup)this.findViewById(R.id.radioGroup4);
		group5 = (RadioGroup)this.findViewById(R.id.radioGroup5);
		group6 = (RadioGroup)this.findViewById(R.id.radioGroup6);
		
		View Button = findViewById(R.id.button1);
		Button.setOnClickListener(this);
		
		// 検索結果の表示
			 intent = new Intent(this, syuzokuti_result.class);
		// データベースの宣言
		// ＤＢオープン
				//-----------------広告　ここから-------------//
			 promotion_method();
				    	//-----------------広告　ここまで-------------//
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	try {
		HP = edit1.getText().toString();
		ATK = edit2.getText().toString();
		DEF = edit3.getText().toString();
		SATK = edit4.getText().toString();
		SDEF = edit5.getText().toString();
		SPE = edit6.getText().toString();
		count=0;
		if(HP.length() >0){
			count++;
		}
		if(ATK.length() >0){
			count++;
		}
		if(DEF.length() >0){
			count++;
		}
		if(SATK.length() >0){
			count++;
		}
		if(SDEF.length() >0){
			count++;
		}
		if(SPE.length() >0){
			count++;
		}
		
		// チェックされている RadioButton を取得
        RadioButton group1_rb = (RadioButton) group1.findViewById(group1.getCheckedRadioButtonId());
        RadioButton group2_rb = (RadioButton) group2.findViewById(group2.getCheckedRadioButtonId());
        RadioButton group3_rb = (RadioButton) group3.findViewById(group3.getCheckedRadioButtonId());
        RadioButton group4_rb = (RadioButton) group4.findViewById(group4.getCheckedRadioButtonId());
        RadioButton group5_rb = (RadioButton) group5.findViewById(group5.getCheckedRadioButtonId());
        RadioButton group6_rb = (RadioButton) group6.findViewById(group6.getCheckedRadioButtonId());
        
        // ラジオボタンの設定ラベルを取得
         String rbStr1 = group1_rb.getText().toString();
         String rbStr2 = group2_rb.getText().toString();
         String rbStr3 = group3_rb.getText().toString();
         String rbStr4 = group4_rb.getText().toString();
         String rbStr5 = group5_rb.getText().toString();
         String rbStr6 = group6_rb.getText().toString();
	     
         // インテントに任意の値をセット
         intent.putExtra("HP",rbStr1);
         intent.putExtra("攻撃",rbStr2);
         intent.putExtra("防御",rbStr3);
         intent.putExtra("特攻",rbStr4);
         intent.putExtra("特防",rbStr5);
         intent.putExtra("素早",rbStr6);
         
         //intentに数値データを入れる
         intent.putExtra("HP_val", HP);
         intent.putExtra("攻撃_val", ATK);
         intent.putExtra("防御_val", DEF);
         intent.putExtra("特攻_val", SATK);
         intent.putExtra("特防_val", SDEF);
         intent.putExtra("素早_val", SPE);
		startActivity(intent);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		   // 確認ダイアログの生成
	    AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
	   
	    alertDlg.setTitle("検索失敗");
	    alertDlg.setMessage("条件に合うポケモンが見つかりませんでした。\n値の設定を見なおしてください");
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

 
    
}
