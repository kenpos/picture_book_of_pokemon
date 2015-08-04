package com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set;

import com.kenpos.app.picture_books_pokemon_pro.Start;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends  SQLiteOpenHelper{

    //コンテキスト
    public DatabaseHelper(Context context){
    	//データベースの更新を行う。　super（コンテキスト,データベース名,null,データベースのバージョン）
    	//プログラムの処理的にデータベース名かバージョンを上げると一から全てデータベースを作り直してくれるよ
        super(context,"pokepokepoke1.db",null,1);
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
        db.execSQL("CREATE TABLE 相性 (タイプ1 TEXT,タイプ2 TEXT,複合 TEXT,ノ TEXT,炎 TEXT,水 TEXT,電 TEXT,草 TEXT,氷 TEXT,格 TEXT,毒 TEXT,地 TEXT,飛 TEXT,エ TEXT,虫 TEXT,岩 TEXT,ゴ TEXT,ド TEXT,悪 TEXT,鋼 TEXT,フ TEXT)");
        db.execSQL("CREATE TABLE 第五世代遺伝技 (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,技 TEXT,種別 TEXT)");
        db.execSQL("CREATE TABLE 第五世代レベル技 (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,LV TEXT,技 TEXT)");
        db.execSQL("CREATE TABLE 第五世代教え技 (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,技 TEXT)");
        db.execSQL("CREATE TABLE 第五世代技マシン (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,waza_NO INTEGER,技 TEXT)");
        db.execSQL("CREATE TABLE 第六世代遺伝技 (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,技 TEXT,種別 TEXT)");
        db.execSQL("CREATE TABLE 第六世代レベル技 (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,LV TEXT,技 TEXT)");
        db.execSQL("CREATE TABLE 第六世代技マシン (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,waza_NO INTEGER,技 TEXT)");
        db.execSQL("CREATE TABLE 第三世代遺伝技 (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,種別 TEXT,技 TEXT)");
        db.execSQL("CREATE TABLE 第三世代レベル技 (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,LV TEXT,技 TEXT)");
        db.execSQL("CREATE TABLE 第三世代教え技 (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,種別 TEXT, 技 TEXT)");
        db.execSQL("CREATE TABLE 第三世代技マシン (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,waza_NO INTEGER,技 TEXT)");
        db.execSQL("CREATE TABLE 第四世代遺伝技 (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,種別 TEXT, 技 TEXT)");
        db.execSQL("CREATE TABLE 第四世代レベル技 (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,LV TEXT,技 TEXT)");
        db.execSQL("CREATE TABLE 第四世代教え技 (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,種別 TEXT,技 TEXT)");
        db.execSQL("CREATE TABLE 第四世代技マシン (_id INTEGER PRIMARY KEY AUTOINCREMENT ,No INTEGER,waza_NO INTEGER,技 TEXT)");
        db.execSQL("CREATE TABLE きのみ (kinomi_No INTEGER,kinomi_NAME TEXT,色 TEXT,時間 INTEGER,最小 INTEGER,最大 INTEGER,効果1 TEXT,効果2 TEXT,入手方法1 TEXT,入手方法2 TEXT)");
        db.execSQL("CREATE TABLE 群れバトル (場所 TEXT,雨の有無 TEXT,ポケモン1 TEXT,ポケモン2 TEXT,ポケモン3 TEXT,ポケモン4 TEXT)");
        db.execSQL("CREATE TABLE 努力値 (No INTEGER,HP INTEGER,攻撃 INTEGER,防御 INTEGER,特攻 INTEGER,特防 INTEGER,素早 INTEGER)");
        db.execSQL("CREATE TABLE タマゴタイプ (No INTEGER,タマゴ_タイプ1 TEXT,タマゴ_タイプ2 TEXT,歩数 TEXT)");
        db.execSQL("CREATE TABLE 捕まえやすさ (No INTEGER,捕まえやすさ INTEGER)");
        db.execSQL("CREATE TABLE 捕獲方法 (No INTEGER,捕まえ方 TEXT)");
        db.execSQL("CREATE TABLE 落とす道具 (No INTEGER,確率 TEXT,道具 TEXT)");
        db.execSQL("CREATE TABLE 進化 (No INTEGER,第一進化 TEXT ,第二進化 TEXT ,第二進化条件 TEXT,第三進化 TEXT,第三進化条件 TEXT ,第四進化 TEXT,第四進化条件 TEXT,第五進化 TEXT,第五進化条件 TEXT,第六進化 TEXT,第六進化条件 TEXT,第七進化 TEXT,第七進化条件 TEXT,第八進化 TEXT,第八進化条件 TEXT,第九進化 TEXT,第九進化条件 TEXT)"); 
        db.execSQL("CREATE TABLE 性別 (No INTEGER,男 TEXT,女 TEXT)");
        db.execSQL("CREATE TABLE ステータス (_id INTEGER,No INTEGER,NAME TEXT,HP INTEGER,攻撃 INTEGER,防御 INTEGER,特攻 INTEGER,特防 INTEGER,素早 INTEGER,合計 INTEGER,タイプ1 TEXT,タイプ2 TEXT,特性1 TEXT,特性2 TEXT,夢特性 TEXT,体重 TEXT,高さ TEXT,フォルム TEXT)");
        db.execSQL("CREATE TABLE 検索用タイプ (_id INTEGER,タイプ1 TEXT,タイプ2 TEXT)");
        db.execSQL("CREATE TABLE 初期なつき度 (No INTEGER,なつき度 INTEGER)");
        db.execSQL("CREATE TABLE 特性一覧 (_id INTEGER,特性名 TEXT,効果 TEXT)");
        db.execSQL("CREATE TABLE 技一覧 (_id INTEGER ,技 TEXT,タイプ TEXT,分類 TEXT,威力 TEXT,命中 TEXT,PP TEXT,対象 TEXT,遠隔 TEXT,接触 TEXT,効果1 TEXT,効果2 TEXT,効果3 TEXT,効果4 TEXT,効果5 TEXT,効果6 TEXT,効果7 TEXT)");
        db.execSQL("CREATE TABLE 技マシン一覧 (waza_NO INTEGER,NAME TEXT,Type TEXT)");
        db.execSQL("CREATE TABLE 経験値タイプ (No INTEGER,経験値タイプ TEXT)");
        db.execSQL("CREATE TABLE 種族値ランキング (NAME TEXT,フォルム TEXT,HP INTEGER,攻撃 INTEGER,防御 INTEGER,特攻 INTEGER,特防 INTEGER,素早 INTEGER,合計 INTEGER)");
        db.execSQL("CREATE TABLE フォルムチェンジ (_id INTEGER ,No INTEGER,NAME TEXT,フォルム1 TEXT,フォルム2 TEXT,フォルム3 TEXT,フォルム4 TEXT,フォルム5 TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS  道具一覧 (アイテム名 TEXT,説明 TEXT)");
        //        db.execSQL("CREATE TABLE 育成ポケモン (_id INTEGER  primary key autoincrement, NAME TEXT,ニックネーム TEXT,特性 TEXT,性格 TEXT,道具 TEXT,HP TEXT,攻撃 TEXT,防御 TEXT,特攻 TEXT,特防 TEXT,素早 TEXT,技1 TEXT,技2 TEXT,技3 TEXT,技4 TEXT,コメント TEXT)");
	}



    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        Log.d("デバッグ","データベース消します");
        db.execSQL("DROP TABLE 相性");
        db.execSQL("DROP TABLE 第五世代遺伝技");
        db.execSQL("DROP TABLE 第五世代レベル技");
        db.execSQL("DROP TABLE 第五世代教え技");
        db.execSQL("DROP TABLE 第五世代技マシン");
        db.execSQL("DROP TABLE 第六世代遺伝技");
        db.execSQL("DROP TABLE 第六世代レベル技");
        db.execSQL("DROP TABLE 第六世代技マシン");
        db.execSQL("DROP TABLE 第三世代遺伝技");
        db.execSQL("DROP TABLE 第三世代レベル技");
        db.execSQL("DROP TABLE 第三世代教え技");
        db.execSQL("DROP TABLE 第三世代技マシン");
        db.execSQL("DROP TABLE 第四世代遺伝技");
        db.execSQL("DROP TABLE 第四世代レベル技");
        db.execSQL("DROP TABLE 第四世代教え技");
        db.execSQL("DROP TABLE 第四世代技マシン");
        db.execSQL("DROP TABLE きのみ");
        db.execSQL("DROP TABLE 群れバトル");
        db.execSQL("DROP TABLE 努力値");
        db.execSQL("DROP TABLE タマゴタイプ");
        db.execSQL("DROP TABLE 捕まえやすさ");
        db.execSQL("DROP TABLE 捕獲方法");
        db.execSQL("DROP TABLE 落とす道具");
        db.execSQL("DROP TABLE 進化");
        db.execSQL("DROP TABLE 性別");
        db.execSQL("DROP TABLE ステータス");
        db.execSQL("DROP TABLE 初期なつき度");
        db.execSQL("DROP TABLE 特性一覧");
        db.execSQL("DROP TABLE 技一覧");
        db.execSQL("DROP TABLE 技マシン一覧");
        db.execSQL("DROP TABLE 経験値タイプ");    
        db.execSQL("DROP TABLE 種族値ランキング"); 
        db.execSQL("DROP TABLE フォルムチェンジ");
        db.execSQL("DROP TABLE 検索用タイプ");

//        db.execSQL("DROP TABLE 育成ポケモン");
        Create_Table(db); // 新バージョンでテーブルを作成し直す
        Start.editor = Start.preference.edit();  
        Start.editor.putBoolean("Launched", false);  
       
        Start.editor.commit();  
    
    }
    
 
}
