package com.kenpos.app.picture_books_pokemon_pro;



import com.kenpos.app.picture_books_pro_pokemon_variables.serch_methods;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class item_result extends serch_methods implements OnClickListener{
	 protected SQLiteDatabase db;
	 protected Cursor cursor;
	 protected ListAdapter adapter;
	 protected ListView cigaretteList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock); 
		setContentView(R.layout.item_result);

		TextView textView1 = (TextView)findViewById(R.id.TOKUSEI_NAME);
	    	textView1.setText(com.kenpos.app.picture_books_pokemon_pro.item_serch.ITEM_NAME);
		    TextView textView2 = (TextView)findViewById(R.id.ITEM_EXSAMPLE);
		    textView2.setText(com.kenpos.app.picture_books_pokemon_pro.item_serch.ITEM_KOUKA);
	    	
		    promotion_method();
	}
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
}