package com.kenpos.app.picture_books_pro_pokemon_variables;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.kenpos.app.picture_books_pokemon_pro_Data_Base_Set.DatabaseHelper;

public class variables extends Activity {

	// 以下ワイ氏が作り上げた努力の結晶
	public String serch;

	public static EditText edit;
	public static SQLiteDatabase db;
	public DatabaseHelper helper = new DatabaseHelper(this);

	// ステータス
	public static String ID = "";
	public static String No = "";
	public static String NAME = "";
	public static String HP = "";
	public static String ATK = "";
	public static String DEF = "";
	public static String SATK = "";
	public static String SDEF = "";
	public static String SPE = "";
	public static String SUM = "";
	public static String TYPE = "";
	public static String TYPE1 = "";
	public static String TYPE2 = "";
	public static String ABI1 = "";
	public static String ABI2 = "";
	public static String D_ABI = "";
	public static String WEI = "";
	public static String HIG = "";
	public static String FOL = "";

	// タマゴ関連
	public static String EGG_TYPE1 = "";
	public static String EGG_TYPE2 = "";
	public static String WALK = "";

	// その他
	public static String GET_POINT = "";
	public static String GET_houhou = "";
	public static String ITEM = "";
	public static String SEX1 = "", SEX2 = "";

	// 進化
	public static String REVO1 = "";
	public static String REVO2 = "";
	public static String REVO3 = "";
	public static String REVO4 = "";
	public static String REVO5 = "";
	public static String REVO6 = "";
	public static String REVO7 = "";
	public static String REVO8 = "";
	public static String REVO9 = "";
	public static String EXPO2 = "";
	public static String EXPO3 = "";
	public static String EXPO4 = "";
	public static String EXPO5 = "";
	public static String EXPO6 = "";
	public static String EXPO7 = "";
	public static String EXPO8 = "";
	public static String EXPO9 = "";

	public static String NATUKI = "";

	public static String DORYOKUTI = "";

	public static String AISYOU1 = "";
	public static String AISYOU2 = "";
	public static String AISYOU3 = "";
	public static String AISYOU4 = "";
	public static String AISYOU5 = "";
	public static String AISYOU6 = "";
	public static String AISYOU7 = "";
	public static String AISYOU8 = "";
	public static String AISYOU9 = "";
	public static String AISYOU10 = "";
	public static String AISYOU11 = "";
	public static String AISYOU12 = "";
	public static String AISYOU13 = "";
	public static String AISYOU14 = "";
	public static String AISYOU15 = "";
	public static String AISYOU16 = "";
	public static String AISYOU17 = "";
	public static String AISYOU18 = "";

	public static String KEI_TYPE = "";

	public static String DAIGO_WAZA = "";
	public static String DAIGO_LEVEL = "";
	public static String DAIGO_OSIE = "";
	public static String DAIGO_IDEN = "";

	public static String DAIROKU_WAZA = "";
	public static String DAIROKU_LEVEL = "";
	public static String DAIROKU_OSIE = "";
	public static String DAIROKU_IDEN = "";

	public static String DAISAN_WAZA = "";
	public static String DAISAN_LEVEL = "";
	public static String DAISAN_OSIE = "";
	public static String DAISAN_IDEN = "";

	public static String DAIYON_WAZA = "";
	public static String DAIYON_LEVEL = "";
	public static String DAIYON_OSIE = "";
	public static String DAIYON_IDEN = "";

	public static String HP_RANK = "";
	public static String ATK_RANK = "";
	public static String DEF_RANK = "";
	public static String SATK_RANK = "";
	public static String SDEF_RANK = "";
	public static String SPE_RANK = "";
	public static String SUM_RANK = "";

	public static String FOL_CHANGE1 = "";
	public static String FOL_CHANGE2 = "";
	public static String FOL_CHANGE3 = "";
	public static String FOL_CHANGE4 = "";
	public static String FOL_CHANGE5 = "";

	public ArrayAdapter<CharSequence> adapter;
	public AutoCompleteTextView _autoCompleteTextView;



}
