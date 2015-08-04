package com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class subDBhelper2 extends  SQLiteOpenHelper{

    //コンテキスト
    public subDBhelper2(Context context){
    	//データベースの更新を行う。　super（コンテキスト,データベース名,null,データベースのバージョン）
    	//プログラムの処理的にデータベース名かバージョンを上げると一から全てデータベースを作り直してくれるよ
        super(context,"pokepoke.db",null,1);
        //super(context, null, null, 1);
        System.out.println("DBです");
        
    }


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Create_Table(db);
	}
 

	public void Create_Table (SQLiteDatabase db) {
        // TODO 自動生成されたメソッド・スタブ

		Log.d("デバッグ","データベース作ります");
        db.execSQL("CREATE TABLE 育成ポケモン (_id INTEGER  primary key autoincrement, NAME TEXT,ニックネーム TEXT,特性 TEXT,性格 TEXT,道具 TEXT,HP TEXT,攻撃 TEXT,防御 TEXT,特攻 TEXT,特防 TEXT,素早 TEXT,技1 TEXT,技2 TEXT,技3 TEXT,技4 TEXT,コメント TEXT)");
	}



    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        Log.d("デバッグ","データベース消します");
        db.execSQL("DROP TABLE 育成ポケモン");
        Create_Table(db); // 新バージョンでテーブルを作成し直す
    }
    
 
}
