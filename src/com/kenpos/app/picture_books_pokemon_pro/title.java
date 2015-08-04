package com.kenpos.app.picture_books_pokemon_pro;


import com.kenpos.app.picture_books_pro_pokemon_Fragment.MainActivity;
import com.kenpos.app.picture_books_pro_pokemon_variables.serch_methods;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class title extends serch_methods implements OnClickListener {

	@SuppressLint("CutPasteId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock);
		setContentView(R.layout.top);

		edit = (EditText) findViewById(R.id.autoCompleteTextView1);
		edit.setTextColor(Color.BLACK);

		serch = edit.getText().toString();
		View Button = findViewById(R.id.button1);
		Button.setOnClickListener(this);

		adapter = ArrayAdapter.createFromResource(this, R.array.day,
				android.R.layout.simple_dropdown_item_1line);
		_autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		_autoCompleteTextView.setAdapter(adapter);

		// データベースの宣言
		// ＤＢオープン
		db = helper.getReadableDatabase();
		promotion_method();

	}


	// ボタンを押した時に呼び出されます
	public void onClick(View v) {
		// 例外処理
		//ポケモン図鑑番号で検索できるようにする
		try{
			
			No_c2();
			status_c(ID);
			egg_c(No);
			getpoint_c(No);
			get_c(No);
			Item_c(No);
			sex_c(No);
			revo_c(No);
			syokinatukido_c(No);
			doryokuti_c(No);
			aisyou_c(TYPE);
			keikenti_type_c(No);
			daigosedai(No);
			ranking_c(NAME);
			daiyonsedai(No);
			dairokusedai(No);
			daisansedai(No);
			change_fol_c(ID);

			chack_method();

			// 検索結果の表示
			edit.setText("");
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}catch(Exception e){
		try {// 各種検索します。
			No_c();
			status_c(ID);
			egg_c(No);
			getpoint_c(No);
			get_c(No);
			Item_c(No);
			sex_c(No);
			revo_c(No);
			syokinatukido_c(No);
			doryokuti_c(No);
			aisyou_c(TYPE);
			keikenti_type_c(No);
			daigosedai(No);
			ranking_c(NAME);
			daiyonsedai(No);
			dairokusedai(No);
			daisansedai(No);
			change_fol_c(ID);

			chack_method();

			// 検索結果の表示
			edit.setText("");
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);

		} 
	catch (Exception el) {
			// TODO: handle exception
			// 確認ダイアログの生成
			AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);

			if (serch == "ぴよらっと") {
				alertDlg.setTitle("ぴよらっとモード");
				alertDlg.setMessage("これはポケモン図鑑であって、ぴよらっと図鑑ではない。\n\n※やめるんだ！");
			} else {
				alertDlg.setTitle("検索失敗");
				alertDlg.setMessage("別の名前で再検索お願いします。\n\n※うまく検索できない場合は名前が間違えている可能性があります。\n正しい名前に変えて試してみてください");
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
	}

	

	// バックボタンを無効にする
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			switch (event.getKeyCode()) {
			case KeyEvent.KEYCODE_BACK:
				// ダイアログ表示など特定の処理を行いたい場合はここに記述
				// 親クラスのdispatchKeyEvent()を呼び出さずにtrueを返す
				return true;
			}
		}
		return super.dispatchKeyEvent(event);
	}


}