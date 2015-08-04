package com.kenpos.app.picture_books_pokemon_pro;


import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.DatabaseHelper;
import com.kenpos.app.picture_books_pro_pokemon_Fragment.MainActivity;
import com.kenpos.app.picture_books_pro_pokemon_variables.serch_methods;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class syuzokuti_result extends serch_methods implements OnClickListener {
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected ListAdapter adapter;
	protected ListView cigaretteList;
	String rbStr_1, rbStr_2, rbStr_3, rbStr_4, rbStr_5, rbStr_6;
	String Str_1, Str_2, Str_3, Str_4, Str_5, Str_6;
	Cursor c;
	String table = "ステータス";
	String[] columns = { "_id", "No", "NAME", "タイプ1", "タイプ2" };
	String selection = "HP >1 ";
	String[] selectionArgs = new String[com.kenpos.app.picture_books_pokemon_pro.syuzokuti_serch.count];
	String limit = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock);  
		setContentView(R.layout.syuzokuti_result);

		DatabaseHelper helper = new DatabaseHelper(this);
		db = helper.getReadableDatabase();
		// インテントを取得
		Intent intent = getIntent();
		// インテントから値を取得
		rbStr_1 = intent.getStringExtra("HP");
		rbStr_2 = intent.getStringExtra("攻撃");
		rbStr_3 = intent.getStringExtra("防御");
		rbStr_4 = intent.getStringExtra("特攻");
		rbStr_5 = intent.getStringExtra("特防");
		rbStr_6 = intent.getStringExtra("素早");
		
		
		
		System.out.println(rbStr_1);
		System.out.println(rbStr_2);
		System.out.println(rbStr_3);
		System.out.println(rbStr_4);
		System.out.println(rbStr_5);
		System.out.println(rbStr_6);
		
		Str_1 = intent.getStringExtra("HP_val");
		Str_2 = intent.getStringExtra("攻撃_val");
		Str_3 = intent.getStringExtra("防御_val");
		Str_4 = intent.getStringExtra("特攻_val");
		Str_5 = intent.getStringExtra("特防_val");
		Str_6 = intent.getStringExtra("素早_val");
		table = "ステータス";
		selection = "特防 >1 ";
		selectionArgs = new String[com.kenpos.app.picture_books_pokemon_pro.syuzokuti_serch.count];
		limit = null;
		serch();

		
		//-----------------広告　ここから-------------//
		promotion_method();
			    	//-----------------広告　ここまで-------------//
	}

	void serch() {
		// TODO Auto-generated method stub

		// com.kenpos.app.pokemondex6.syuzokuti_serch.特防,com.kenpos.app.pokemondex6.syuzokuti_serch.ATK,com.kenpos.app.pokemondex6.syuzokuti_serch.DEF,com.kenpos.app.pokemondex6.syuzokuti_serch.SATK,com.kenpos.app.pokemondex6.syuzokuti_serch.SDEF,com.kenpos.app.pokemondex6.syuzokuti_serch.SPE
		// 特防が空白で無いなら
		int i = 0;
		if (Str_1.length() >= 1) {
			selectionArgs[i] = Str_1;
			// ラジオボタンが変化した時のイベントを取得
            if (rbStr_1.equals("同じ")) {
                selection += "and _id IN(select _id from ステータス where HP =? ) ";

            } else if (rbStr_1.equals("以上")) {
                selection += "and _id IN(select _id from ステータス where HP >=? ) ";

            } else if (rbStr_1.equals("以下")) {
                selection += "and _id IN(select _id from ステータス where HP <=? ) ";

            }
			i++;
		}

		if (Str_2.length() >= 1) {
			selectionArgs[i] = Str_2;

            if (rbStr_2.equals("同じ")) {
                selection += "and _id IN(select _id from ステータス where 攻撃 =? ) ";

            } else if (rbStr_2.equals("以上")) {
                selection += "and _id IN(select _id from ステータス where 攻撃 >=? ) ";

            } else if (rbStr_2.equals("以下")) {
                selection += "and _id IN(select _id from ステータス where 攻撃 <=? ) ";

            }
			i++;
		}


		if (Str_3.length() >= 1) {
			selectionArgs[i] = Str_3;
            if (rbStr_3.equals("同じ")) {
                selection += "and _id IN(select _id from ステータス where 防御 =? ) ";

            } else if (rbStr_3.equals("以上")) {
                selection += "and _id IN(select _id from ステータス where 防御 >=? ) ";

            } else if (rbStr_3.equals("以下")) {
                selection += "and _id IN(select _id from ステータス where 防御 <=? ) ";

            }
			i++;
		}
		if (Str_4.length() >= 1) {
			selectionArgs[i] =Str_4;

            if (rbStr_4.equals("同じ")) {
                selection += "and _id IN(select _id from ステータス where 特攻 =? ) ";

            } else if (rbStr_4.equals("以上")) {
                selection += "and _id IN(select _id from ステータス where 特攻 >=? ) ";

            } else if (rbStr_4.equals("以下")) {
                selection += "and _id IN(select _id from ステータス where 特攻 <=? ) ";

            }
			i++;
		}
			 
		if (Str_5.length() >= 1) {
			selectionArgs[i] = Str_5;
            if (rbStr_5.equals("同じ")) {
                selection += "and _id IN(select _id from ステータス where 特防 =? ) ";

            } else if (rbStr_5.equals("以上")) {
                selection += "and _id IN(select _id from ステータス where 特防 >=? ) ";

            } else if (rbStr_5.equals("以下")) {
                selection += "and _id IN(select _id from ステータス where 特防 <=? ) ";

            }
			i++;
		}

		if (Str_6.length() >= 1) {
			selectionArgs[i] = Str_6;

            if (rbStr_6.equals("同じ")) {
                selection += "and _id IN(select _id from ステータス where 素早 =? ) ";

            } else if (rbStr_6.equals("以上")) {
                selection += "and _id IN(select _id from ステータス where 素早 >=? ) ";

            } else if (rbStr_6.equals("以下")) {
                selection += "and _id IN(select _id from ステータス where 素早 <=? ) ";

            }
			i++;
		}
		
		System.out.println(selection);
		c = db.query(table, columns, selection, selectionArgs, null, null,null, limit);
		c.moveToFirst();

		SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(this,
				R.layout.list_item, c, new String[] { "No", "NAME", "タイプ2",
						"タイプ1" }, new int[] { R.id.list_number, R.id.list_name,
						R.id.list_fom, R.id.list_type_1 });

		cigaretteList = (ListView) findViewById(R.id.listView1);
		cigaretteList.setAdapter(myAdapter);
		final Intent intent = new Intent(this, MainActivity.class);
		// リストビューのアイテムがクリックされた時に呼び出されるコールバックリスナーを登録します
		cigaretteList
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						ListView listView = (ListView) parent;
						// クリックされたアイテムを取得します
						Cursor item = (Cursor) listView
								.getItemAtPosition(position);
						String lgin_id = item.getString(item
								.getColumnIndex("_id"));
						String lgin_name = item.getString(item
								.getColumnIndex("NAME"));
						Log.d("メニュー", lgin_name);
						title.Name_serch(lgin_name);
						// 検索結果の表示
						startActivity(intent);

					}
				});
	}



	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
}
