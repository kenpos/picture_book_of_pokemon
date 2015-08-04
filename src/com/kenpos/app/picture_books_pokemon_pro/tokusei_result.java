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
import android.widget.TextView;

public class tokusei_result extends serch_methods implements OnClickListener {
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected ListAdapter adapter;
	protected ListView cigaretteList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock);
		setContentView(R.layout.tokusei_result);

		TextView textView1 = (TextView) findViewById(R.id.TOKUSEI_NAME);
		textView1.setText(com.kenpos.app.picture_books_pokemon_pro.Tokusei_serch.TOKUSEI_NAME);
		TextView textView2 = (TextView) findViewById(R.id.kouka1);
		textView2.setText(com.kenpos.app.picture_books_pokemon_pro.Tokusei_serch.TOKUSEI_KOUKA);
		TextView textView3 = (TextView) findViewById(R.id.gen3);
		textView3.setClickable(true);

		onClick(textView1.getText().toString());

		// -----------------広告　ここから-------------//
		promotion_method();
		// -----------------広告　ここまで-------------//
	}

	public void onClick(String pokemonID) {
		// TODO Auto-generated method stub
		db = (new DatabaseHelper(this)).getWritableDatabase();

		String[] columns = { "_id", "No", "NAME", "タイプ1", "タイプ2" };
		String selection = "特性1 = ? or 特性2 = ?  or 夢特性 = ? ";
		String[] selectionArgs = { pokemonID, pokemonID, pokemonID };
		String limit = null;

		Cursor c = db.query("ステータス", columns, selection, selectionArgs, null,
				null, limit);
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
