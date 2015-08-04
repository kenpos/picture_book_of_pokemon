package com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.ContentValues;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Insert_class extends Activity {

    //データベースヘルパーの作成
    DatabaseHelper helper;
    //データベースの宣言
    SQLiteDatabase mDb;



	public static void aisyou(SQLiteDatabase mDb,AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf;

				bf = new BufferedReader(new InputStreamReader(
						as.open("aisyou.csv")));
		 
			String s;
			ContentValues value = new ContentValues();


			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("相性", "" + strAry[0] + "");
				value.put("タイプ1", strAry[0]);
				value.put("タイプ2", strAry[1]);
				value.put("複合", strAry[2]);
				value.put("ノ", strAry[3]);
				value.put("炎", strAry[4]);
				value.put("水", strAry[5]);
				value.put("電", strAry[6]);
				value.put("草", strAry[7]);
				value.put("氷", strAry[8]);
				value.put("格", strAry[9]);
				value.put("毒", strAry[10]);
				value.put("地", strAry[11]);
				value.put("飛", strAry[12]);
				value.put("エ", strAry[13]);
				value.put("虫", strAry[14]);
				value.put("岩", strAry[15]);
				value.put("ゴ", strAry[16]);
				value.put("ド", strAry[17]);
				value.put("悪", strAry[18]);
				value.put("鋼", strAry[19]);
				value.put("フ", strAry[20]);
				mDb.insert("相性", null, value);
			}
            // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void daigo_iden(SQLiteDatabase mDb,AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("daigo_iden.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第五世代遺伝技", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("技", strAry[1]);
				value.put("種別",strAry[2]);
				mDb.insert("第五世代遺伝技", null, value);
			}
			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void daigo_level(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("daigo_level.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第五世代レベル技", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("LV", strAry[1]);
				value.put("技", strAry[2]);
				mDb.insert("第五世代レベル技", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void daigo_osie(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("daigo_osie.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第五世代教え技", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("技", strAry[1]);
				mDb.insert("第五世代教え技", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void daigo_waza(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("daigo_waza.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第五世代技マシン", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("waza_NO", strAry[1]);
				value.put("技", strAry[2]);
				mDb.insert("第五世代技マシン", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void dairoku_iden(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("dairoku_iden.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第六世代遺伝技", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("技", strAry[1]);
				value.put("種別",strAry[2]);
				mDb.insert("第六世代遺伝技", null, value);
			}
			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void dairoku_level(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("dairoku_level.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第六世代レベル技", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("LV", strAry[1]);
				value.put("技", strAry[2]);
				mDb.insert("第六世代レベル技", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void dairoku_waza(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("dairoku_waza.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第六世代技マシン", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("waza_NO", strAry[1]);
				value.put("技", strAry[2]);
				mDb.insert("第六世代技マシン", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void daisan_iden(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("daisan_iden.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第三世代遺伝技", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("種別", strAry[1]);
				value.put("技", strAry[2]);
				mDb.insert("第三世代遺伝技", null, value);
			}
			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void daisan_level(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("daisan_level.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第三世代レベル技", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("LV", strAry[1]);
				value.put("技", strAry[2]);
				mDb.insert("第三世代レベル技", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void daisan_osie(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("daisan_osie.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第三教え技", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("種別", strAry[1]);
				value.put("技", strAry[2]);
				mDb.insert("第三世代教え技", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void daisan_waza(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("daisan_waza.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第三世代技マシン", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("waza_NO", strAry[1]);
				value.put("技", strAry[2]);
				mDb.insert("第三世代技マシン", null, value);
			}
			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void daiyon_iden(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("daiyon_iden.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第四世代遺伝技", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("種別", strAry[1]);
				value.put("技", strAry[2]);
				mDb.insert("第四世代遺伝技", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void daiyon_level(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("daiyon_level.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第四世代レベル技", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("LV", strAry[1]);
				value.put("技", strAry[2]);
				mDb.insert("第四世代レベル技", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void daiyon_osie(SQLiteDatabase mDb, AssetManager as) {

		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("daiyon_osie.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第四世代教え技", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("種別", strAry[1]);
				value.put("技", strAry[2]);
				mDb.insert("第四世代教え技", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	
	public static void daiyon_waza(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("daiyon_waza.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("第四世代技マシン", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("waza_NO", strAry[1]);
				value.put("技", strAry[2]);
				mDb.insert("第四世代技マシン", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void doryokuti(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("doryokuti.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("努力値", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("HP", strAry[1]);
				value.put("攻撃", strAry[2]);
				value.put("防御", strAry[3]);
				value.put("特攻", strAry[4]);
				value.put("特防", strAry[5]);
				value.put("素早", strAry[6]);
				mDb.insert("努力値", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void egg_Type(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("egg_Type.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("タマゴタイプ", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("タマゴ_タイプ1", strAry[1]);
				value.put("タマゴ_タイプ2", strAry[2]);
				value.put("歩数", strAry[3]);
				mDb.insert("タマゴタイプ", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void get_point(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("get_point.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("捕まえやすさ", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("捕まえやすさ", strAry[1]);
				mDb.insert("捕まえやすさ", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void tukamaekata(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("hokakuhouhou.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("捕獲方法", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("捕まえ方", strAry[1]);
				mDb.insert("捕獲方法", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void item(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("item.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("落とす道具", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("確率", strAry[1]);
				value.put("道具", strAry[2]);
				mDb.insert("落とす道具", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void kinomi(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("kinomi.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("きのみ", "" + strAry[0] + "");
				value.put("kinomi_No", strAry[0]);
				value.put("kinomi_NAME", strAry[1]);
				value.put("色", strAry[2]);
				value.put("時間", strAry[3]);
				value.put("最小", strAry[4]);
				value.put("最大", strAry[5]);
				value.put("効果1", strAry[6]);
				value.put("効果2", strAry[7]);
				value.put("入手方法1", strAry[8]);
				value.put("入手方法2", strAry[9]);
				mDb.insert("きのみ", null, value);
			}
			
			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void mure(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("mure_batoru.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("群れバトル", "" + strAry[0] + "");
				value.put("場所", strAry[0]);
				value.put("雨の有無", strAry[1]);
				value.put("ポケモン1", strAry[2]);
				value.put("ポケモン2", strAry[3]);
				value.put("ポケモン3", strAry[4]);
				value.put("ポケモン4", strAry[5]);
				mDb.insert("群れバトル", null, value);
			}
			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void revo(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("revo.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("進化", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("第一進化", strAry[1]);
				value.put("第二進化", strAry[2]);
				value.put("第二進化条件", strAry[3]);
				value.put("第三進化", strAry[4]);
				value.put("第三進化条件", strAry[5]);
				value.put("第四進化", strAry[6]);
				value.put("第四進化条件", strAry[7]);
				value.put("第五進化", strAry[8]);
				value.put("第五進化条件", strAry[9]);
				value.put("第六進化", strAry[10]);
				value.put("第六進化条件", strAry[11]);
				value.put("第七進化", strAry[12]);
				value.put("第七進化条件", strAry[13]);
				value.put("第八進化", strAry[14]);
				value.put("第八進化条件", strAry[15]);
				value.put("第九進化", strAry[16]);
				value.put("第九進化条件", strAry[17]);
				mDb.insert("進化", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void sex(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("sex.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("性別", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("男", strAry[1]);
				value.put("女", strAry[2]);
				mDb.insert("性別", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void status(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("status.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("ステータス", "" + strAry[0] + "");
				value.put("_id", strAry[0]);
				value.put("No", strAry[1]);
				value.put("NAME", strAry[2]);
				value.put("HP", strAry[3]);
				value.put("攻撃", strAry[4]);
				value.put("防御", strAry[5]);
				value.put("特攻", strAry[6]);
				value.put("特防", strAry[7]);
				value.put("素早", strAry[8]);
				value.put("合計", strAry[9]);
				value.put("タイプ1", strAry[10]);
				value.put("タイプ2", strAry[11]);
				value.put("特性1", strAry[12]);
				value.put("特性2", strAry[13]);
				value.put("夢特性", strAry[14]);
				value.put("体重", strAry[15]);
				value.put("高さ", strAry[16]);
				value.put("フォルム", strAry[17]);
				mDb.insert("ステータス", null, value);
			}
			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }

	}

	public static void syokinatuki(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("syokinatuki.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("初期なつき", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("なつき度", strAry[1]);
				mDb.insert("初期なつき度", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	

	public static void tokuseiitiran(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("tokuseiitiran.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("特性一覧", "" + strAry[0] + "");
				value.put("_id", strAry[0]);
				value.put("特性名", strAry[1]);
				value.put("効果", strAry[2]);
				mDb.insert("特性一覧", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void type(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("type.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("検索用タイプ", "" + strAry[0] + "");
				value.put("_id", strAry[0]);
				value.put("タイプ1", strAry[1]);
				value.put("タイプ2", strAry[2]);
				mDb.insert("検索用タイプ", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}


	public static void wazaitiran(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("wazaitiran.csv")));
			String s;
			ContentValues value = new ContentValues();
			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("技一覧", "" + strAry[0] + "");
				value.put("_id", strAry[0]);
				value.put("技", strAry[1]);
				value.put("タイプ", strAry[2]);
				value.put("分類", strAry[3]);
				value.put("威力", strAry[4]);
				value.put("命中", strAry[5]);
				value.put("PP", strAry[6]);
				value.put("対象", strAry[7]);
				value.put("遠隔", strAry[8]);
				value.put("接触", strAry[9]);
				value.put("効果1", strAry[10]);
				value.put("効果2", strAry[11]);
				value.put("効果3", strAry[12]);
				value.put("効果4", strAry[13]);
				value.put("効果5", strAry[14]);
				value.put("効果6", strAry[15]);
				value.put("効果7", strAry[16]);
				mDb.insert("技一覧", null, value);
			}

			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}

	public static void wazamachine(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("wazamachine.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("技マシン一覧", "" + strAry[0] + "");
				value.put("waza_NO", strAry[0]);
				value.put("NAME", strAry[1]);
				value.put("Type", strAry[2]);
				mDb.insert("技マシン一覧", null, value);
			}
			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}
	
	//経験値タイプ
	public static void keikenti_type(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("keikenti_Type.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("経験値タイプ", "" + strAry[0] + "");
				value.put("No", strAry[0]);
				value.put("経験値タイプ", strAry[1]);
				mDb.insert("経験値タイプ", null, value);
			}
			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }
	}
	
	public static void ranking(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("ranking.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("種族値ランキング", "" + strAry[0] + "");
				value.put("NAME", strAry[0]);
				value.put("フォルム", strAry[1]);
				value.put("HP", strAry[2]);
				value.put("攻撃", strAry[3]);
				value.put("防御", strAry[4]);
				value.put("特攻", strAry[5]);
				value.put("特防", strAry[6]);
				value.put("素早", strAry[7]);
				value.put("合計", strAry[8]);
				mDb.insert("種族値ランキング", null, value);
			}
			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }

	}
	

	public static void fol_change(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("fol_change.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("フォルムチェンジ", "" + strAry[0] + "");
				value.put("_id", strAry[0]);
				value.put("No", strAry[1]);
				value.put("NAME", strAry[2]);
				value.put("フォルム1", strAry[3]);
				value.put("フォルム2", strAry[4]);
				value.put("フォルム3", strAry[5]);
				value.put("フォルム4", strAry[6]);
				value.put("フォルム5", strAry[7]);
				mDb.insert("フォルムチェンジ", null, value);
			}
			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }

	}
	
	public static void dougu(SQLiteDatabase mDb, AssetManager as) {
		try {
		    // トランザクション開始
            mDb.beginTransaction();
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					as.open("dougu.csv")));
			String s;
			ContentValues value = new ContentValues();

			while ((s = bf.readLine()) != null) {
				String[] strAry = s.split(",");
				Log.d("道具一覧", "" + strAry[0] +strAry[1]+ "");
				value.put("アイテム名", strAry[0]);
				value.put("説明", strAry[1]);
				mDb.insert("道具一覧", null, value);
			}
			 // 全件正常に挿入したら、トランザクション成功
            mDb.setTransactionSuccessful();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
            // トランザクションの終了
            mDb.endTransaction();
        }

	}
}