package com.kenpos.app.picture_books_pro_pokemon_variables;

import net.nend.android.NendAdView;

import com.kenpos.app.picture_books_pokemon_pro.Memo_result;
import com.kenpos.app.picture_books_pokemon_pro.R;
import com.kenpos.app.picture_books_pokemon_pro.Speed_Cheack;
import com.kenpos.app.picture_books_pokemon_pro.Speed_cheack2;
import com.kenpos.app.picture_books_pokemon_pro.Status_Cheack;
import com.kenpos.app.picture_books_pokemon_pro.TYPE_serch;
import com.kenpos.app.picture_books_pokemon_pro.Tokusei_serch;
import com.kenpos.app.picture_books_pokemon_pro.Waza_serch;
import com.kenpos.app.picture_books_pokemon_pro.egg_result;
import com.kenpos.app.picture_books_pokemon_pro.item_serch;
import com.kenpos.app.picture_books_pokemon_pro.kotaiti_Cheack;
import com.kenpos.app.picture_books_pokemon_pro.mure_buttle;
import com.kenpos.app.picture_books_pokemon_pro.seikakuitiranhyou;
import com.kenpos.app.picture_books_pokemon_pro.syuzokuti_serch;
import com.kenpos.app.picture_books_pokemon_pro.title;

import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

public class serch_methods extends variables {

	// ステータスを検索し,図鑑番号だけぶっこ抜いてその値を返却します。
		// 他のクラスで使うなら,適当なStringにでも入れると使いやすいかな
		public void No_c() {
			ID = "";
			No = "";
			serch = edit.getText().toString();
			String selection = "NAME LIKE ? ";
			String limit = null;
			String[] selectionArgs = {"%" + serch +"%"};

			Cursor c = db.query("ステータス", new String[] { "_id", "No" }, selection,
					selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			while (isEof) {
				ID = c.getString(0);
				No = c.getString(1);
				isEof = c.moveToNext();
			}
			c.close();
			// No = text;
		}

		public void No_c2() {
			ID = "";
			No = "";
			serch = edit.getText().toString();
			String selection = "No = ?";
			String limit = null;
			String[] selectionArgs = { serch };

			Cursor c = db.query("ステータス", new String[] { "_id", "No" }, selection,
					selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			while (isEof) {
				ID = c.getString(0);
				No = c.getString(1);
				isEof = c.moveToNext();
			}
			c.close();
			// No = text;
		}

		// ステータス
		public static void status_c(String pokemonID) {

			NAME = "";
			HP = "";
			ATK = "";
			DEF = "";
			SATK = "";
			SDEF = "";
			SPE = "";
			SUM = "";
			TYPE = "";
			TYPE1 = "";
			TYPE2 = "";
			ABI1 = "";
			ABI2 = "";
			D_ABI = "";
			WEI = "";
			HIG = "";
			FOL = "";

			String selection = "_id = ?";
			String selectionArgs[] = { pokemonID };
			String limit = null;
			Cursor c = db.query("ステータス", new String[] { "NAME", "HP", "攻撃", "防御",
					"特攻", "特防", "素早", "合計", "タイプ1", "タイプ2", "特性1", "特性2", "夢特性",
					"体重", "高さ", "フォルム" }, selection, selectionArgs, null, null,
					limit);
			boolean isEof = c.moveToFirst();
			while (isEof) {
				NAME = c.getString(0);
				HP = c.getString(1);
				ATK = c.getString(2);
				DEF = c.getString(3);
				SATK = c.getString(4);
				SDEF = c.getString(5);
				SPE = c.getString(6);
				SUM = c.getString(7);
				TYPE1 = c.getString(8);
				TYPE2 = c.getString(9);
				ABI1 = c.getString(10);
				ABI2 = c.getString(11);
				D_ABI = c.getString(12);
				WEI = c.getString(13);
				HIG = c.getString(14);
				FOL = c.getString(15);
				isEof = c.moveToNext();
			}
			TYPE = TYPE1 + TYPE2;
			c.close();
		}

		// タマゴ
		public static void egg_c(String pokemonID) {
			EGG_TYPE1 = "";
			EGG_TYPE2 = "";
			WALK = "";

			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("タマゴタイプ", new String[] { "タマゴ_タイプ1", "タマゴ_タイプ2",
					"歩数" }, selection, selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			// while (isEof) {
			EGG_TYPE1 = c.getString(0);
			EGG_TYPE2 = c.getString(1);
			WALK = c.getString(2);
			// isEof = c.moveToNext();
			// }
			c.close();
		}

		// 捕まえやすさ
		public static void getpoint_c(String pokemonID) {
			GET_POINT = "";

			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("捕まえやすさ", new String[] { "捕まえやすさ" }, selection,
					selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			// while (isEof) {
			GET_POINT += String.format("%s", c.getString(0));
			// isEof = c.moveToNext();
			// }
			c.close();
		}

		// 落とす道具
		public static void Item_c(String pokemonID) {

			ITEM = "";

			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("落とす道具", new String[] { "確率,道具" }, selection,
					selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			while (isEof) {
				ITEM += String.format("%s %s\n", c.getString(0), c.getString(1));
				isEof = c.moveToNext();
			}
		}

		// 捕獲方法
		public static void get_c(String pokemonID) {
			GET_houhou = "";

			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("捕獲方法", new String[] { "捕まえ方" }, selection,
					selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			while (isEof) {
				GET_houhou += String.format("%s\n", c.getString(0));
				isEof = c.moveToNext();
			}
			c.close();
		}

		// 性別
		public static void sex_c(String pokemonID) {
			SEX1 = "";
			SEX2 = "";
			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("性別", new String[] { "男", "女" }, selection,
					selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			// while (isEof) {
			SEX1 += String.format("%s", c.getString(0));
			SEX2 += String.format("%s", c.getString(1));
			// isEof = c.moveToNext();
			// }
			c.close();
		}

		// 進化
		public static void revo_c(String pokemonID) {
			REVO1 = "";
			REVO2 = "";
			REVO3 = "";
			REVO4 = "";
			REVO5 = "";
			REVO6 = "";
			REVO7 = "";
			REVO8 = "";
			REVO9 = "";
			EXPO2 = "";
			EXPO3 = "";
			EXPO4 = "";
			EXPO5 = "";
			EXPO6 = "";
			EXPO7 = "";
			EXPO8 = "";
			EXPO9 = "";
			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("進化", new String[] { "第一進化", "第二進化", "第三進化",
					"第四進化", "第五進化", "第六進化", "第七進化", "第八進化", "第九進化", "第二進化条件",
					"第三進化条件", "第四進化条件", "第五進化条件", "第六進化条件", "第七進化条件", "第八進化条件",
					"第九進化条件" }, selection, selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			while (isEof) {
				REVO1 = c.getString(0);
				REVO2 = c.getString(1);
				REVO3 = c.getString(2);
				REVO4 = c.getString(3);
				REVO5 = c.getString(4);
				REVO6 = c.getString(5);
				REVO7 = c.getString(6);
				REVO8 = c.getString(7);
				REVO9 = c.getString(8);
				EXPO2 = c.getString(9);
				EXPO3 = c.getString(10);
				EXPO4 = c.getString(11);
				EXPO5 = c.getString(12);
				EXPO6 = c.getString(13);
				EXPO7 = c.getString(14);
				EXPO8 = c.getString(15);
				EXPO9 = c.getString(16);
				isEof = c.moveToNext();
			}
			c.close();
		}

		// 進化
		public static void change_fol_c(String pokemonID) {
			FOL_CHANGE1 = "";
			FOL_CHANGE2 = "";
			FOL_CHANGE3 = "";
			FOL_CHANGE4 = "";
			FOL_CHANGE5 = "";
			String selection = "_id = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("フォルムチェンジ", new String[] { "フォルム1", "フォルム2",
					"フォルム3", "フォルム4", "フォルム5" }, selection, selectionArgs, null,
					null, limit);
			boolean isEof = c.moveToFirst();
			FOL_CHANGE1 = c.getString(0);
			FOL_CHANGE2 = c.getString(1);
			FOL_CHANGE3 = c.getString(2);
			FOL_CHANGE4 = c.getString(3);
			FOL_CHANGE5 = c.getString(4);
			c.close();
		}

		// 初期なつき度
		public static void syokinatukido_c(String pokemonID) {
			NATUKI = "";
			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("初期なつき度", new String[] { "なつき度" }, selection,
					selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			// while (isEof) {
			NATUKI = c.getString(0);
			// isEof = c.moveToNext();
			// }
			c.close();
		}

		// 努力値
		public static void doryokuti_c(String pokemonID) {
			DORYOKUTI = "";
			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("努力値", new String[] { "HP", "攻撃", "防御", "特攻", "特防",
					"素早" }, selection, selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();

			String mozi = "";
			while (isEof) {
				for (int i = 0; i < 6; i++) {
					if (c.getInt(i) != 0) {
						switch (i) {
						case 0:
							mozi = "HP+";
							DORYOKUTI += String.format("%s\n",
									mozi + c.getString(0));
							break;
						case 1:
							mozi = "攻撃+";
							DORYOKUTI += String.format("%s\n",
									mozi + c.getString(1));
							break;
						case 2:
							mozi = "防御+";
							DORYOKUTI += String.format("%s\n",
									mozi + c.getString(2));
							break;
						case 3:
							mozi = "特攻+";
							DORYOKUTI += String.format("%s\n",
									mozi + c.getString(3));
							break;
						case 4:
							mozi = "特防+";
							DORYOKUTI += String.format("%s\n",
									mozi + c.getString(4));
							break;

						default:
							mozi = "素早+";
							DORYOKUTI += String.format("%s\n",
									mozi + c.getString(5));
							break;
						}
					}
				}
				isEof = c.moveToNext();
			}
			c.close();
		}

		// 相性 (No INTEGER,炎 TEXT,水 TEXT,電 TEXT,草 TEXT,氷 TEXT,格 TEXT,毒 TEXT,地 TEXT,飛
		// TEXT,エ TEXT,虫 TEXT,岩 TEXT,ゴ TEXT,ド TEXT,悪 TEXT,鋼 TEXT,フ TEXT)
		public static void aisyou_c(String pokemonID) {

			AISYOU1 = "";
			AISYOU2 = "";
			AISYOU3 = "";
			AISYOU4 = "";
			AISYOU5 = "";
			AISYOU6 = "";
			AISYOU7 = "";
			AISYOU8 = "";
			AISYOU9 = "";
			AISYOU10 = "";
			AISYOU11 = "";
			AISYOU12 = "";
			AISYOU13 = "";
			AISYOU14 = "";
			AISYOU15 = "";
			AISYOU16 = "";
			AISYOU17 = "";
			AISYOU18 = "";

			String selection = "タイプ1 = ? and タイプ2 =?";
			String[] selectionArgs = { TYPE1, TYPE2 };
			String limit = null;
			Cursor c = db.query("相性", new String[] { "ノ", "炎", "水", "草", "電", "氷",
					"格", "毒", "地", "飛", "エ", "虫", "岩", "ゴ", "ド", "悪", "鋼", "フ" },
					selection, selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			// while (isEof) {
			AISYOU1 = c.getString(0);
			AISYOU2 = c.getString(1);
			AISYOU3 = c.getString(2);
			AISYOU4 = c.getString(3);
			AISYOU5 = c.getString(4);
			AISYOU6 = c.getString(5);
			AISYOU7 = c.getString(6);
			AISYOU8 = c.getString(7);
			AISYOU9 = c.getString(8);
			AISYOU10 = c.getString(9);
			AISYOU11 = c.getString(10);
			AISYOU12 = c.getString(11);
			AISYOU13 = c.getString(12);
			AISYOU14 = c.getString(13);
			AISYOU15 = c.getString(14);
			AISYOU16 = c.getString(15);
			AISYOU17 = c.getString(16);
			AISYOU18 = c.getString(17);

			// }
			c.close();
		}

		// 経験値タイプ
		public static void keikenti_type_c(String pokemonID) {
			KEI_TYPE = "";
			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("経験値タイプ", new String[] { "経験値タイプ" }, selection,
					selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			// while (isEof) {
			KEI_TYPE = c.getString(0);
			// isEof = c.moveToNext();
			// }
			c.close();
		}

		// 第五世代
		public static void daigosedai(String pokemonID) {
			DAIGO_WAZA = "";
			DAIGO_LEVEL = "";
			DAIGO_OSIE = "";
			DAIGO_IDEN = "";
			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("第五世代技マシン", new String[] { "waza_No", "技" },
					selection, selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			while (isEof) {
				DAIGO_WAZA += String.format("%s %s\n", c.getString(0),
						c.getString(1));
				isEof = c.moveToNext();
			}

			Cursor c1 = db.query("第五世代教え技", new String[] { "技" }, selection,
					selectionArgs, null, null, limit);

			isEof = c1.moveToFirst();
			while (isEof) {
				DAIGO_OSIE += String.format("%s\n", c1.getString(0));
				isEof = c1.moveToNext();
			}
			Cursor c2 = db.query("第五世代レベル技", new String[] { "LV", "技" }, selection,
					selectionArgs, null, null, limit);
			isEof = c2.moveToFirst();
			while (isEof) {
				DAIGO_LEVEL += String.format("%3s %s\n", c2.getString(0),
						c2.getString(1));
				isEof = c2.moveToNext();
			}
			Cursor c3 = db.query("第五世代遺伝技", new String[] { "技" }, selection,
					selectionArgs, null, null, limit);
			isEof = c3.moveToFirst();
			while (isEof) {
				DAIGO_IDEN += String.format("%s\n", c3.getString(0));
				isEof = c3.moveToNext();
			}
			c.close();

		}

		// 第六世代
		public static void dairokusedai(String pokemonID) {
			DAIROKU_WAZA = "";
			DAIROKU_LEVEL = "";
			DAIROKU_OSIE = "";
			DAIROKU_IDEN = "";
			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("第六世代技マシン", new String[] { "waza_No", "技" },
					selection, selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			while (isEof) {
				DAIROKU_WAZA += String.format("%s %s\n", c.getString(0),
						c.getString(1));
				isEof = c.moveToNext();
			}

			// Cursor c1 = db.query("第六世代教え技", new String[] {"技"}, selection,
			// selectionArgs, null, null, limit);
			//
			// isEof = c1.moveToFirst();
			// while (isEof) {
			// DAIROKU_OSIE += String.format("%s\n", c1.getString(0));
			// isEof = c1.moveToNext();
			// }
			Cursor c2 = db.query("第六世代レベル技", new String[] { "LV", "技" }, selection,
					selectionArgs, null, null, limit);
			isEof = c2.moveToFirst();
			while (isEof) {
				DAIROKU_LEVEL += String.format("%3s %s\n", c2.getString(0),
						c2.getString(1));
				isEof = c2.moveToNext();
			}
			Cursor c3 = db.query("第六世代遺伝技", new String[] { "技" }, selection,
					selectionArgs, null, null, limit);
			isEof = c3.moveToFirst();
			while (isEof) {
				DAIROKU_IDEN += String.format("%s\n", c3.getString(0));
				isEof = c3.moveToNext();
			}
			c.close();

		}

		public static void daiyonsedai(String pokemonID) {
			DAIYON_WAZA = "";
			DAIYON_LEVEL = "";
			DAIYON_OSIE = "";
			DAIYON_IDEN = "";
			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("第四世代技マシン", new String[] { "waza_No", "技" },
					selection, selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			while (isEof) {
				DAIYON_WAZA += String.format("%s %s\n", c.getString(0),
						c.getString(1));
				isEof = c.moveToNext();
			}

			Cursor c1 = db.query("第四世代教え技", new String[] { "種別", "技" }, selection,
					selectionArgs, null, null, limit);
			isEof = c1.moveToFirst();
			while (isEof) {
				DAIYON_OSIE += String.format("%s　%s\n", c1.getString(0),
						c1.getString(1));
				isEof = c1.moveToNext();
			}
			Cursor c2 = db.query("第四世代レベル技", new String[] { "LV", "技" }, selection,
					selectionArgs, null, null, limit);
			isEof = c2.moveToFirst();
			while (isEof) {
				DAIYON_LEVEL += String.format("%3s %s\n", c2.getString(0),
						c2.getString(1));
				isEof = c2.moveToNext();
			}
			Cursor c3 = db.query("第四世代遺伝技", new String[] { "種別", "技" }, selection,
					selectionArgs, null, null, limit);
			isEof = c3.moveToFirst();
			while (isEof) {
				DAIYON_IDEN += String.format("%s %s\n", c3.getString(0),
						c3.getString(1));
				isEof = c3.moveToNext();
			}
			c.close();

		}

		public static void daisansedai(String pokemonID) {
			DAISAN_WAZA = "";
			DAISAN_LEVEL = "";
			DAISAN_OSIE = "";
			DAISAN_IDEN = "";
			String selection = "No = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("第三世代技マシン", new String[] { "waza_No", "技" },
					selection, selectionArgs, null, null, limit);
			boolean isEof = c.moveToFirst();
			while (isEof) {
				DAISAN_WAZA += String.format("%s %s\n", c.getString(0),
						c.getString(1));
				isEof = c.moveToNext();
			}

			Cursor c1 = db.query("第三世代教え技", new String[] { "種別", "技" }, selection,
					selectionArgs, null, null, limit);

			isEof = c1.moveToFirst();
			while (isEof) {
				DAISAN_OSIE += String.format("%s %s\n", c1.getString(0),
						c1.getString(1));
				isEof = c1.moveToNext();
			}
			Cursor c2 = db.query("第三世代レベル技", new String[] { "LV", "技" }, selection,
					selectionArgs, null, null, limit);
			isEof = c2.moveToFirst();
			while (isEof) {
				DAISAN_LEVEL += String.format("%3s %s\n", c2.getString(0),
						c2.getString(1));
				isEof = c2.moveToNext();
			}
			Cursor c3 = db.query("第三世代遺伝技", new String[] { "種別", "技" }, selection,
					selectionArgs, null, null, limit);
			isEof = c3.moveToFirst();
			while (isEof) {
				DAISAN_IDEN += String.format("%s %s\n", c3.getString(0),
						c3.getString(1));
				isEof = c3.moveToNext();
			}
			c.close();

		}

		// 種族値ランキング
		// ステータス
		public static void ranking_c(String pokemonID) {

			HP_RANK = "";
			ATK_RANK = "";
			DEF_RANK = "";
			SATK_RANK = "";
			SDEF_RANK = "";
			SPE_RANK = "";
			SUM_RANK = "";

			String selection = "NAME = ?";
			String selectionArgs[] = { pokemonID };
			String limit = null;
			Cursor c = db
					.query("種族値ランキング", new String[] { "HP", "攻撃", "防御", "特攻", "特防",
							"素早", "合計" }, selection, selectionArgs, null, null,
							limit);
			boolean isEof = c.moveToFirst();
			HP_RANK += String.format("%s位", c.getString(0));
			ATK_RANK += String.format("%s位", c.getString(1));
			DEF_RANK += String.format("%s位", c.getString(2));
			SATK_RANK += String.format("%s位", c.getString(3));
			SDEF_RANK += String.format("%s位", c.getString(4));
			SPE_RANK += String.format("%s位", c.getString(5));
			SUM_RANK += String.format("%s位", c.getString(6));

			c.close();
		}

		// chackメニュー
		public static void chack_method() {
			Log.d("No", No);
			Log.d("NAME", NAME);
			Log.d("HP", HP);
			Log.d("ATK", ATK);
			Log.d("DEF", DEF);
			Log.d("SATK ", SATK);
			Log.d("SDEF", SDEF);
			Log.d("SPE", SPE);
			Log.d("SUM", SUM);
			Log.d("TYPE", TYPE);
			Log.d("TYPE1", TYPE1);
			Log.d("TYPE2", TYPE2);
			Log.d("ABI1", ABI1);
			Log.d("ABI2", ABI2);
			Log.d("D_ABI", D_ABI);
			Log.d("WEI", WEI);
			Log.d("HIG", HIG);
			Log.d("FOL", FOL);
			Log.d("EGG_TYPE1", EGG_TYPE1);
			Log.d("EGG_TYPE2", EGG_TYPE2);
			Log.d("WALK", WALK);
			Log.d("GET_POINT", GET_POINT);
			Log.d("GET_houhou", GET_houhou);
			Log.d("ITEM ", ITEM);
			Log.d("SEX", SEX1);
			Log.d("REVO1", REVO1);
			// public static String REVO2 ="";
			// public static String REVO3 ="";
			// public static String REVO4 ="";
			// public static String REVO5 ="";
			// public static String REVO6 ="";
			// public static String REVO7 ="";
			// public static String REVO8 ="";
			// public static String REVO9 ="";

			Log.d("NATUKI", NATUKI);
			Log.d("DORYOKU ", DORYOKUTI);
			Log.d("AISYOU1", AISYOU1);
			Log.d("AISYOU2", AISYOU2);
			Log.d("KEI_TYPE", KEI_TYPE);
			Log.d("DAIGO_IDEN", DAIGO_IDEN);
		}

		public static void fol_serch_c(String pokemonID) {

			String selection = "フォルム = ?";
			String[] selectionArgs = { pokemonID };
			String limit = null;
			Cursor c = db.query("ステータス", new String[] { "NAME", "HP", "攻撃", "防御",
					"特攻", "特防", "素早", "合計", "タイプ1", "タイプ2", "特性1", "特性2", "夢特性",
					"体重", "高さ", "フォルム" }, selection, selectionArgs, null, null,
					limit);
			// while (isEof) {
			NAME = c.getString(0);
			HP = c.getString(1);
			ATK = c.getString(2);
			DEF = c.getString(3);
			SATK = c.getString(4);
			SDEF = c.getString(5);
			SPE = c.getString(6);
			SUM = c.getString(7);
			TYPE1 = c.getString(8);
			TYPE2 = c.getString(9);
			ABI1 = c.getString(10);
			ABI2 = c.getString(11);
			D_ABI = c.getString(12);
			WEI = c.getString(13);
			HIG = c.getString(14);
			FOL = c.getString(15);
			c.close();
		}

		public static void No_fol_c(String serch) {
			ID = "";
			No = "";
			String selection = "フォルム = ?";
			String limit = null;
			String[] selectionArgs = { serch };

			Cursor c = db.query("ステータス", new String[] { "_id", "No" }, selection,
					selectionArgs, null, null, limit);
			c.moveToFirst();
			ID = c.getString(0);
			No = c.getString(1);
			c.close();
		}

		public static void No_name_c(String serch) {
			ID = "";
			No = "";
			Log.d("メニュー", serch);
			String selection = "NAME = ?";
			String limit = null;
			String[] selectionArgs = { serch };

			Cursor c = db.query("ステータス", new String[] { "_id", "No", "NAME" },
					selection, selectionArgs, null, null, limit);
			c.moveToFirst();
			ID = c.getString(0);
			No = c.getString(1);
			NAME = c.getString(2);
			c.close();
		}

		public static void fol_serch(String aaa) {

			No_fol_c(aaa);
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

		}

		public static void revo_serch(String aaa) {

			No_name_c(aaa);
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

		}

		public static void Name_serch(String aaa) {
			No_name_c(aaa);
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
		}

//		private SimpleSideDrawer mNav;
//		@Override
//		protected void onCreate(Bundle savedInstanceState) {
//			// TODO Auto-generated method stub
//			super.onCreate(savedInstanceState);
//			navigation_menu();
//		}
//
//		public void navigation_menu() {
//		    mNav = new SimpleSideDrawer(this);
//	        mNav.setLeftBehindContentView(R.layout.activity_behind_left_simple);
//	        setTheme(R.style.Theme_Sherlock);
//		}


		// サイトにジャンプするメソッド
		public void Review(View view) {
			Uri uri = Uri
					.parse("https://play.google.com/store/apps/details?id=com.kenpos.app.pokemondex6&hl=ja");
			Intent i = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(i);
		}

		public void niconico(View view) {
			Uri uri = Uri.parse("http://dic.nicovideo.jp/v/sm5445322");
			Intent i = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(i);
		}

		public void pokesyo(View view) {
			Uri uri = Uri.parse("http://www.pokesho.com/home.html");
			Intent i = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(i);
		}

		public void pokekou(View view) {
			Uri uri = Uri.parse("http://yakkun.com");
			Intent i = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(i);
		}

		//メニューボタンが押された時にメニューが作られる
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {

			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}

		//メニューで選択された場合に呼ばれる
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle action bar item clicks here. The action bar will
			// automatically handle clicks on the Home/Up button, so long
			// as you specify a parent activity in AndroidManifest.xml.


			switch (item.getItemId()) {
			case R.id.name_serch:
				// 検索結果の表示
				Intent intent15 = new Intent(this, title.class);
				startActivity(intent15);
				return true;
			case R.id.waza_serch:
				// 検索結果の表示
				Intent intent = new Intent(this, Waza_serch.class);
				startActivity(intent);
				return true;
			case R.id.ability_serch:
				// 検索結果の表示
				Intent intent2 = new Intent(this, Tokusei_serch.class);
				startActivity(intent2);
				return true;
			case R.id.type_serch:
				// 検索結果の表示
				Intent intent3 = new Intent(this, TYPE_serch.class);
				startActivity(intent3);
				return true;
			case R.id.egg_serch:
				// 検索結果の表示
				Intent intent4 = new Intent(this, egg_result.class);
				startActivity(intent4);
				return true;
			case R.id.syuzokuti_serch:
				// 検索結果の表示
				Intent intent5 = new Intent(this, syuzokuti_serch.class);
				startActivity(intent5);
				return true;
			case R.id.murebuttle_hyou:
				// 検索結果の表示
				Intent intent9 = new Intent(this, mure_buttle.class);
				startActivity(intent9);
				return true;
			case R.id.seikaku_hyou:
				// 検索結果の表示
				Intent intent11 = new Intent(this, seikakuitiranhyou.class);
				startActivity(intent11);
				return true;
			case R.id.status_hamntei:
				// 検索結果の表示
				Intent intent12 = new Intent(this, Status_Cheack.class);
				startActivity(intent12);
				return true;
			case R.id.kotaiti_hantei:
				// 検索結果の表示
				Intent intent13 = new Intent(this, kotaiti_Cheack.class);
				startActivity(intent13);
				return true;
			case R.id.speed_tyousei:
				// 検索結果の表示
				Intent intent14 = new Intent(this, Speed_cheack2.class);
				startActivity(intent14);
				return true;
			case R.id.ikusei_memo:
				// 検索結果の表示
				Intent intent16 = new Intent(this, Memo_result.class);
				startActivity(intent16);
				return true;
			case R.id.item_serch:
				// 検索結果の表示
				Intent intent17 = new Intent(this, item_serch.class);
				startActivity(intent17);
				return true;
			}
			return super.onOptionsItemSelected(item);
		}

		// メニューボタンを押される度に呼ばれる
		@Override
		public boolean onPrepareOptionsMenu(Menu menu) {
			super.onPrepareOptionsMenu(menu);
			Log.d("メニュー", "押された");
			return true;
		}

		// メニューが消える度に呼ばれる
		@Override
		public void onOptionsMenuClosed(Menu menu) {
			super.onPrepareOptionsMenu(menu);
		}

		//終了処理
		@Override
		public void finish() {
		    super.finish();
//		    db.close();
		}

		//画面遷移した時に殺す
		@Override
		protected void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
//			db.close();
		}



	}
