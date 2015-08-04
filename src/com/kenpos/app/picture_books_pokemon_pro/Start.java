/*
 * もしもデータベースが更新できないなって思った時は
 * おとなしく新しいデータベース名を指定して
 * 古いデータベースを削除するプログラムでも書くといいよ
 *  
 */

package com.kenpos.app.picture_books_pokemon_pro;


import net.nend.android.NendAdView;

import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.DatabaseHelper;
import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.Insert_class;
import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.subDBhelper2;

import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.RelativeLayout;

public class Start extends Activity implements OnClickListener{  
    //メンバー変数
    //データベースヘルパーの作成
    DatabaseHelper helper;
	subDBhelper2 helper1;
    //データベースの宣言
    SQLiteDatabase mDb,mDb1;
    //プリファレンス  
   public static SharedPreferences preference;  
   public static Editor editor;  
   
   Handler handler= new Handler();

 //Activityが破棄されても、オブジェクトを保持できるようにstaticで宣言する。
//   private static ProgressTask mTask;   
   
  

    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setTheme(R.style.Theme_Sherlock); 
        setContentView(R.layout.start);

        
        //プリファレンスの準備  
        preference = getSharedPreferences("Preference Name", MODE_PRIVATE);  
    	editor = preference.edit();  
    	editor.commit();  
        
    	helper  = new DatabaseHelper(this);
        mDb = helper.getWritableDatabase(); //呼び出して初めて空のデータベースが作られる。アップデート時にはすべてのテーブル消してもう一度作りなおすはず。
    	helper1  = new subDBhelper2(this);
        mDb1 = helper.getWritableDatabase();
    if (preference.getBoolean("Launched", false)==false) {  
   	 //初回起動時の処理
    	
//		-----------------広告　ここから-------------//
		 RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.root);

			        NendAdView nendAdView = 
			                new NendAdView(getApplicationContext(), 152265, "7a354d40b5ee958b58d6f170de85d0b83ca02163");
			        // 中央下部表示の場合
			        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
			                LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
			        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
			        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			        // 上部表示の場合
			        //params.addRule(RelativeLayout.ALIGN_PARENT_TOP);

			        rootLayout.addView(nendAdView, params);

			        nendAdView.loadAd();
//			    	-----------------広告　ここまで-------------//
			        
    	// マルチスレッドにしたい処理 ここから
        (new Thread(new Runnable() { 
    				@Override
    				public void run() {
    					// 通常バックグランドをここに記述します
    					databaseSet();
        				
    				}
    				})).start();
    			}else {  
            
                //二回目以降の処理  
               	Intent intent = new Intent(this, title.class);
            	startActivity(intent);
    			}
    }


    


    public void databaseSet(){
                Log.d("デバッグ","ファイルはありません");
            	//CSVファイルの読み込み準備
                AssetManager as = getResources().getAssets();            

                Insert_class.wazamachine(mDb, as);
                Insert_class.aisyou(mDb, as);    
                Insert_class.daigo_iden(mDb, as);
                Insert_class.daigo_level(mDb, as);
                Insert_class.daigo_osie(mDb, as);
                Insert_class.daigo_waza(mDb, as);
                Insert_class.dairoku_iden(mDb, as);
                Insert_class.dairoku_level(mDb, as);
                Insert_class.dairoku_waza(mDb, as);
                Insert_class.daisan_iden(mDb, as);
                Insert_class.daisan_level(mDb, as);
                Insert_class.daisan_osie(mDb, as);
                Insert_class.daisan_waza(mDb, as);
                Insert_class.daiyon_iden(mDb, as);
                Insert_class.daiyon_level(mDb, as);
                Insert_class.daiyon_osie(mDb, as);
                Insert_class.daiyon_waza(mDb, as);
                Insert_class.doryokuti(mDb, as);
                Insert_class.egg_Type(mDb, as);
                Insert_class.get_point(mDb, as);
                Insert_class.item(mDb, as);
                Insert_class.kinomi(mDb, as);
                Insert_class.mure(mDb, as);
                Insert_class.revo(mDb, as);
                Insert_class.sex(mDb, as);
                Insert_class.status(mDb, as);
                Insert_class.syokinatuki(mDb, as);
                Insert_class.tokuseiitiran(mDb, as);
                Insert_class.tukamaekata(mDb, as);
                Insert_class.wazaitiran(mDb, as);
                Insert_class.wazamachine(mDb, as);
                Insert_class.keikenti_type(mDb, as);
                Insert_class.ranking(mDb, as);
                Insert_class.fol_change(mDb, as);
                Insert_class.type(mDb, as);
                Insert_class.dougu(mDb, as);
                //プリファレンスの書き変え  
                editor.putBoolean("Launched", true);  
                editor.commit();  
               	Intent intent = new Intent(this, title.class);
            	startActivity(intent);
    }  

    @Override
    public void onDestroy() {
     super.onDestroy();
     mDb.close();
    }

	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
	

	
	}

  