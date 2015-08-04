package com.kenpos.app.picture_books_pro_pokemon_Fragment;

import com.kenpos.app.picture_books_pokemon_pro.R;
import com.kenpos.app.picture_books_pokemon_pro.TYPE_serch;
import com.kenpos.app.picture_books_pokemon_pro.Tokusei_serch;
import com.kenpos.app.picture_books_pokemon_pro.egg_result;
import com.kenpos.app.picture_books_pokemon_pro.tokusei_result;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class Status_Fragment extends Fragment {
	public static final String ARG_SECTION_NUMBER = "section_number";
	protected ListView cigaretteList;

	TextView textView1;// = (TextView) getActivity().findViewById(R.id.No_txt);
	TextView textView2;// = (TextView) getActivity().findViewById(
						// R.id.abillity2);
	TextView textView5;// = (TextView) getActivity().findViewById(
						// R.id.ATK_txt);
	TextView textView6;// = (TextView) getActivity().findViewById(
						// R.id.DEF_txt);
	TextView textView7;// = (TextView) getActivity().findViewById(
						// R.id.doryokuti);
	TextView textView8;// = (TextView) getActivity().findViewById(
						// R.id.dream_txt);
	TextView textView9;// = (TextView) getActivity().findViewById(
						// R.id.egg_type1);
	TextView textView10;// = (TextView) getActivity().findViewById(
						// R.id.egg_type2);
	TextView textView11;// = (TextView) getActivity().findViewById(
						// R.id.folm_txt);
	TextView textView12;// = (TextView) getActivity().findViewById(
						// R.id.hig_txt);
	TextView textView13;// = (TextView) getActivity().findViewById(
						// R.id.hokakudo_txt);
	TextView textView14;// = (TextView) getActivity().findViewById(
						// R.id.HP_txt);
	TextView textView15;// = (TextView) getActivity().findViewById(
						// R.id.Item_txt);
	TextView textView16;// = (TextView) getActivity().findViewById(
						// R.id.keikentiType_txt);
	// TextView textView17 ;//= (TextView) //
	// getActivity().findViewById(R.id.kisokeikenti_txt);
	TextView textView18;// = (TextView) getActivity().findViewById(
						// R.id.Name_txt);
	TextView textView19;// = (TextView) getActivity().findViewById(
						// R.id.natukido_txt);
	TextView textView20;// = (TextView) getActivity().findViewById(
						// R.id.No_txt);
	TextView textView21;// = (TextView) getActivity().findViewById(
						// R.id.SAT_txt);
	TextView textView22;// = (TextView) getActivity().findViewById(
						// R.id.SDE_txt);
	TextView textView23;// = (TextView) getActivity().findViewById(
						// R.id.SPE_txt);
	TextView textView24;// = (TextView) getActivity().findViewById(
						// R.id.SUM_txt);
	TextView textView25;// = (TextView) getActivity().findViewById(
						// R.id.tukamaekata_txt);
	TextView textView26;// = (TextView) getActivity().findViewById(
						// R.id.Walk_txt);
	TextView textView27;// = (TextView) getActivity().findViewById(
						// R.id.wei_txt);
	TextView textView28;// = (TextView) getActivity().findViewById(
						// R.id.revolution_txt);
	TextView textView29;// = (TextView) getActivity().findViewById(
						// R.id.ability1_txt);
	TextView textView30;// = (TextView) getActivity().findViewById(
						// R.id.Type_txt);
	TextView textView77;// = (TextView) getActivity().findViewById( R.id.type2);
	TextView textView31;// = (TextView) getActivity().findViewById(
						// R.id.SEX_txt);
	TextView textView76;// = (TextView) getActivity().findViewById(
						// R.id.SEX2_txt);
	// ランキング
	TextView textView32;// = (TextView) getActivity().findViewById(
						// R.id.HP_ranking);
	TextView textView33;// = (TextView) getActivity().findViewById(
						// R.id.ATK_ranking);
	TextView textView34;// = (TextView) getActivity().findViewById(
						// R.id.DEF_ranking);
	TextView textView35;// = (TextView) getActivity().findViewById(
						// R.id.SATK_ranking);
	TextView textView36;// = (TextView) getActivity().findViewById(
						// R.id.SDEF_ranking);
	TextView textView37;// = (TextView) getActivity().findViewById(
						// R.id.SPE_ranking);
	TextView textView38;// = (TextView) getActivity().findViewById(
						// R.id.SUM_ranking);

	TextView textView39;// = (TextView) getActivity().findViewById(
						// R.id.change_fol1);
	TextView textView40;// = (TextView) getActivity().findViewById(
						// R.id.change_fol2);
	TextView textView41;// = (TextView) getActivity().findViewById(
						// R.id.change_fol3);
	TextView textView42;// = (TextView) getActivity().findViewById(
						// R.id.change_fol4);
	TextView textView43;// = (TextView) getActivity().findViewById(
						// R.id.change_fol5);

	TextView textView44;// = (TextView) getActivity().findViewById(
						// R.id.revolution2_txt);
	TextView textView45;// = (TextView) getActivity().findViewById(
						// R.id.revolution3_txt);
	TextView textView46;// = (TextView) getActivity().findViewById(
						// R.id.revolution4_txt);
	TextView textView47;// = (TextView) getActivity().findViewById(
						// R.id.revolution5_txt);
	TextView textView48;// = (TextView) getActivity().findViewById(
						// R.id.revolution6_txt);
	TextView textView49;// = (TextView) getActivity().findViewById(
						// R.id.revolution7_txt);
	TextView textView50;// = (TextView) getActivity().findViewById(
						// R.id.revolution8_txt);
	TextView textView51;// = (TextView) getActivity().findViewById(
						// R.id.revolution9_txt);

	TextView textView52;// = (TextView) getActivity() .findViewById(R.id.exp2);
	TextView textView53;// = (TextView) getActivity() .findViewById(R.id.exp3);
	TextView textView54;// = (TextView) getActivity() .findViewById(R.id.exp4);
	TextView textView55;// = (TextView) getActivity() .findViewById(R.id.exp5);
	TextView textView56;// = (TextView) getActivity() .findViewById(R.id.exp6);
	TextView textView57;// = (TextView) getActivity() .findViewById(R.id.exp7);
	TextView textView58;// = (TextView) getActivity() .findViewById(R.id.exp8);
	TextView textView59;// = (TextView) getActivity() .findViewById(R.id.exp9);
	TextView textView3;// = (TextView) getActivity().findViewById( R.id.normal);
	TextView textView4;// = (TextView) getActivity().findViewById(R.id.fire);
	TextView textView60;// = (TextView) getActivity().findViewById( R.id.water);
	TextView textView61;// = (TextView) getActivity().findViewById( R.id.elect);
	TextView textView62;// = (TextView) getActivity().findViewById( R.id.glass);
	TextView textView63;// = (TextView) getActivity().findViewById(R.id.ice);
	TextView textView64;// = (TextView) getActivity().findViewById( R.id.fight);
	TextView textView65;// = (TextView) getActivity().findViewById(
						// R.id.poisson);
	TextView textView66;// = (TextView) getActivity().findViewById(
						// R.id.ground);
	TextView textView67;// = (TextView) getActivity().findViewById(R.id.fly);
	TextView textView68;// = (TextView) getActivity().findViewById( R.id.esper);
	TextView textView69;// = (TextView) getActivity().findViewById(R.id.bag);
	TextView textView70;// = (TextView) getActivity() .findViewById(R.id.rock);
	TextView textView71;// = (TextView) getActivity().findViewById( R.id.goast);
	TextView textView72;// = (TextView) getActivity().findViewById(
						// R.id.dragon);
	TextView textView73;// = (TextView) getActivity() .findViewById(R.id.dark);
	TextView textView74;// = (TextView) getActivity().findViewById( R.id.steal);
	TextView textView75;// = (TextView) getActivity().findViewById( R.id.fealy);

	TextView textView78;// = (TextView) getActivity().findViewById(
						// R.id.textView18);
	TextView textView79;// = (TextView) getActivity().findViewById(
						// R.id.textView17);
	TextView textView80;// = (TextView) getActivity().findViewById(
						// R.id.textView16);
	TextView textView81;// = (TextView) getActivity().findViewById(
						// R.id.textView15);
	TextView textView82;// = (TextView) getActivity().findViewById(
						// R.id.textView14);
	TextView textView83;// = (TextView) getActivity().findViewById(
						// R.id.textView13);
	TextView textView84;// = (TextView) getActivity().findViewById(
						// R.id.textView12);

	int HP;// = Integer
			// .parseInt(com.kenpos.app.picture_books_pokemon.title.HP);
	int ATK;// = Integer
			// .parseInt(com.kenpos.app.picture_books_pokemon.title.ATK);
	int DEF;// = Integer
			// .parseInt(com.kenpos.app.picture_books_pokemon.title.DEF);
	int SATK;// = Integer
				// .parseInt(com.kenpos.app.picture_books_pokemon.title.SATK);
	int SDEF;// = Integer
				// .parseInt(com.kenpos.app.picture_books_pokemon.title.SDEF);
	int SPE;// = Integer
			// .parseInt(com.kenpos.app.picture_books_pokemon.title.SPE);
	int SUM;// = Integer
			// .parseInt(com.kenpos.app.picture_books_pokemon.title.SUM) / 6;
	ScrollView Scrollview;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.page1r, container, false);
		// View に ScrollView を設定

		return rootView;
	}

	int i = 0;
	String t = " ";

	// Status_Fragmentに値をセットします
	public void set_val() {
		textView1.setText(com.kenpos.app.picture_books_pokemon_pro.title.No);
		textView2.setText(com.kenpos.app.picture_books_pokemon_pro.title.ABI2);
		textView5.setText(com.kenpos.app.picture_books_pokemon_pro.title.ATK);
		textView6.setText(com.kenpos.app.picture_books_pokemon_pro.title.DEF);
		textView7.setText(com.kenpos.app.picture_books_pokemon_pro.title.DORYOKUTI);
		textView8.setText(com.kenpos.app.picture_books_pokemon_pro.title.D_ABI);
		textView9.setText(com.kenpos.app.picture_books_pokemon_pro.title.EGG_TYPE1);
		textView10
				.setText(com.kenpos.app.picture_books_pokemon_pro.title.EGG_TYPE2);
		textView11.setText(com.kenpos.app.picture_books_pokemon_pro.title.FOL);
		textView12.setText(com.kenpos.app.picture_books_pokemon_pro.title.HIG);
		textView13
				.setText(com.kenpos.app.picture_books_pokemon_pro.title.GET_POINT);
		textView14.setText(com.kenpos.app.picture_books_pokemon_pro.title.HP);
		textView15.setText(com.kenpos.app.picture_books_pokemon_pro.title.ITEM);
		textView16.setText(com.kenpos.app.picture_books_pokemon_pro.title.KEI_TYPE);
		// textView17.setText(com.kenpos.app.pokemonmonXY.title.);
		textView18.setText(com.kenpos.app.picture_books_pokemon_pro.title.NAME);
		textView19.setText(com.kenpos.app.picture_books_pokemon_pro.title.NATUKI);
		textView20.setText(com.kenpos.app.picture_books_pokemon_pro.title.No);
		textView21.setText(com.kenpos.app.picture_books_pokemon_pro.title.SATK);
		textView22.setText(com.kenpos.app.picture_books_pokemon_pro.title.SDEF);
		textView23.setText(com.kenpos.app.picture_books_pokemon_pro.title.SPE);
		textView24.setText(com.kenpos.app.picture_books_pokemon_pro.title.SUM);
		textView25
				.setText(com.kenpos.app.picture_books_pokemon_pro.title.GET_houhou);
		textView26.setText(com.kenpos.app.picture_books_pokemon_pro.title.WALK);
		textView27.setText(com.kenpos.app.picture_books_pokemon_pro.title.WEI);
		textView28.setText(com.kenpos.app.picture_books_pokemon_pro.title.REVO1);
		textView29.setText(com.kenpos.app.picture_books_pokemon_pro.title.ABI1);
		textView30.setText(com.kenpos.app.picture_books_pokemon_pro.title.TYPE1);
		textView77.setText(com.kenpos.app.picture_books_pokemon_pro.title.TYPE2);
		textView31.setText(com.kenpos.app.picture_books_pokemon_pro.title.SEX1);
		textView76.setText(com.kenpos.app.picture_books_pokemon_pro.title.SEX2);
		textView32.setText(com.kenpos.app.picture_books_pokemon_pro.title.HP_RANK);
		textView33.setText(com.kenpos.app.picture_books_pokemon_pro.title.ATK_RANK);
		textView34.setText(com.kenpos.app.picture_books_pokemon_pro.title.DEF_RANK);
		textView35
				.setText(com.kenpos.app.picture_books_pokemon_pro.title.SATK_RANK);
		textView36
				.setText(com.kenpos.app.picture_books_pokemon_pro.title.SDEF_RANK);
		textView37.setText(com.kenpos.app.picture_books_pokemon_pro.title.SPE_RANK);
		textView38.setText(com.kenpos.app.picture_books_pokemon_pro.title.SUM_RANK);
		textView39
				.setText(com.kenpos.app.picture_books_pokemon_pro.title.FOL_CHANGE1);
		textView40
				.setText(com.kenpos.app.picture_books_pokemon_pro.title.FOL_CHANGE2);
		textView41
				.setText(com.kenpos.app.picture_books_pokemon_pro.title.FOL_CHANGE3);
		textView42
				.setText(com.kenpos.app.picture_books_pokemon_pro.title.FOL_CHANGE4);
		textView43
				.setText(com.kenpos.app.picture_books_pokemon_pro.title.FOL_CHANGE5);

		textView44.setText(com.kenpos.app.picture_books_pokemon_pro.title.REVO2);
		textView45.setText(com.kenpos.app.picture_books_pokemon_pro.title.REVO3);
		textView46.setText(com.kenpos.app.picture_books_pokemon_pro.title.REVO4);
		textView47.setText(com.kenpos.app.picture_books_pokemon_pro.title.REVO5);
		textView48.setText(com.kenpos.app.picture_books_pokemon_pro.title.REVO6);
		textView49.setText(com.kenpos.app.picture_books_pokemon_pro.title.REVO7);
		textView50.setText(com.kenpos.app.picture_books_pokemon_pro.title.REVO8);
		textView51.setText(com.kenpos.app.picture_books_pokemon_pro.title.REVO9);

		textView52.setText(com.kenpos.app.picture_books_pokemon_pro.title.EXPO2);
		textView53.setText(com.kenpos.app.picture_books_pokemon_pro.title.EXPO3);
		textView54.setText(com.kenpos.app.picture_books_pokemon_pro.title.EXPO4);
		textView55.setText(com.kenpos.app.picture_books_pokemon_pro.title.EXPO5);
		textView56.setText(com.kenpos.app.picture_books_pokemon_pro.title.EXPO6);
		textView57.setText(com.kenpos.app.picture_books_pokemon_pro.title.EXPO7);
		textView58.setText(com.kenpos.app.picture_books_pokemon_pro.title.EXPO8);
		textView59.setText(com.kenpos.app.picture_books_pokemon_pro.title.EXPO9);
		textView3.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU1);
		textView4.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU2);
		textView60.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU3);
		textView61.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU4);
		textView62.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU5);
		textView63.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU6);
		textView64.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU7);
		textView65.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU8);
		textView66.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU9);
		textView67.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU10);
		textView68.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU11);
		textView69.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU12);
		textView70.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU13);
		textView71.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU14);
		textView72.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU15);
		textView73.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU16);
		textView74.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU17);
		textView75.setText(com.kenpos.app.picture_books_pokemon_pro.title.AISYOU18);
		
		//相性表数値の位置
		textView3.setGravity(Gravity.CENTER);//AISYOU1);
		textView4.setGravity(Gravity.CENTER);//AISYOU2);
		textView60.setGravity(Gravity.CENTER);//AISYOU3);
		textView61.setGravity(Gravity.CENTER);//AISYOU4);
		textView62.setGravity(Gravity.CENTER);//AISYOU5);
		textView63.setGravity(Gravity.CENTER);//AISYOU6);
		textView64.setGravity(Gravity.CENTER);//AISYOU7);
		textView65.setGravity(Gravity.CENTER);//AISYOU8);
		textView66.setGravity(Gravity.CENTER);//AISYOU9);
		textView67.setGravity(Gravity.CENTER);//AISYOU10);
		textView68.setGravity(Gravity.CENTER);//AISYOU11);
		textView69.setGravity(Gravity.CENTER);//AISYOU12);
		textView70.setGravity(Gravity.CENTER);//AISYOU13);
		textView71.setGravity(Gravity.CENTER);//AISYOU14);
		textView72.setGravity(Gravity.CENTER);//AISYOU15);
		textView73.setGravity(Gravity.CENTER);//AISYOU16);
		textView74.setGravity(Gravity.CENTER);//AISYOU17);
		textView75.setGravity(Gravity.CENTER);
		
		Scrollview = (ScrollView) getActivity().findViewById(R.id.scrollView);
		
		int stringToValue = Integer
				.parseInt(com.kenpos.app.picture_books_pokemon_pro.title.ID);

		// XMLで指定した画像の配列を取ってきてうへぇってやってる。
		TypedArray imgs = getResources().obtainTypedArray(R.array.img_array);
		Drawable drawable = imgs.getDrawable(stringToValue);
		ImageView oppai = (ImageView) getActivity().findViewById(
				R.id.imageView2);
		oppai.setImageDrawable(drawable);
		
		Scrollview.fullScroll(ScrollView.FOCUS_UP);

		int HP = Integer
		 .parseInt(com.kenpos.app.picture_books_pokemon_pro.title.HP)*3/7;
int ATK = Integer
		 .parseInt(com.kenpos.app.picture_books_pokemon_pro.title.ATK)*3/7;
int DEF = Integer
		 .parseInt(com.kenpos.app.picture_books_pokemon_pro.title.DEF)*3/7;
int SATK = Integer
		 .parseInt(com.kenpos.app.picture_books_pokemon_pro.title.SATK)*3/7;
int SDEF = Integer
		 .parseInt(com.kenpos.app.picture_books_pokemon_pro.title.SDEF)*3/7;
int SPE = Integer
		 .parseInt(com.kenpos.app.picture_books_pokemon_pro.title.SPE)*3/7;
int SUM = Integer
		 .parseInt(com.kenpos.app.picture_books_pokemon_pro.title.SUM)*3/7 / 6;
		// ステータスバーを更新します
		i = 0;
		t = " ";
		while (i < HP) {
			t += " ";
			i++;
		}
		textView78.setText(t);
		i = 0;
		t = " ";
		while (i < ATK) {
			t += " ";
			i++;
		}
		textView79.setText(t);
		i = 0;
		t = " ";
		while (i < DEF) {
			t += " ";
			i++;
		}
		textView80.setText(t);
		i = 0;
		t = " ";
		while (i < SATK) {
			t += " ";
			i++;
		}
		textView81.setText(t);
		i = 0;
		t = " ";
		while (i < SDEF) {
			t += " ";
			i++;
		}
		textView82.setText(t);
		i = 0;
		t = " ";
		while (i < SPE) {
			t += " ";
			i++;
		}
		textView83.setText(t);
		i = 0;
		t = " ";
		while (i < SUM) {
			t += " ";
			i++;
		}
		textView84.setText(t);
		i = 0;
		t = " ";

	}

	@Override
	public void onStart() {
		super.onStart();

		textView1 = (TextView) getActivity().findViewById(R.id.No_txt);
		textView2 = (TextView) getActivity().findViewById(R.id.abillity2);
		textView5 = (TextView) getActivity().findViewById(R.id.ATK_txt);
		textView6 = (TextView) getActivity().findViewById(R.id.DEF_txt);
		textView7 = (TextView) getActivity().findViewById(R.id.doryokuti);
		textView8 = (TextView) getActivity().findViewById(R.id.dream_txt);
		textView9 = (TextView) getActivity().findViewById(R.id.egg_type1);
		textView10 = (TextView) getActivity().findViewById(R.id.egg_type2);
		textView11 = (TextView) getActivity().findViewById(R.id.folm_txt);
		textView12 = (TextView) getActivity().findViewById(R.id.hig_txt);
		textView13 = (TextView) getActivity().findViewById(R.id.hokakudo_txt);
		textView14 = (TextView) getActivity().findViewById(R.id.HP_txt);
		textView15 = (TextView) getActivity().findViewById(R.id.Item_txt);
		textView16 = (TextView) getActivity().findViewById(
				R.id.keikentiType_txt);
		// textView17 = (TextView)
		// getActivity().findViewById(R.id.kisokeikenti_txt);
		textView18 = (TextView) getActivity().findViewById(R.id.Name_txt);
		textView19 = (TextView) getActivity().findViewById(R.id.natukido_txt);
		textView20 = (TextView) getActivity().findViewById(R.id.No_txt);
		textView21 = (TextView) getActivity().findViewById(R.id.SAT_txt);
		textView22 = (TextView) getActivity().findViewById(R.id.SDE_txt);
		textView23 = (TextView) getActivity().findViewById(R.id.SPE_txt);
		textView24 = (TextView) getActivity().findViewById(R.id.SUM_txt);
		textView25 = (TextView) getActivity()
				.findViewById(R.id.tukamaekata_txt);
		textView26 = (TextView) getActivity().findViewById(R.id.Walk_txt);
		textView27 = (TextView) getActivity().findViewById(R.id.wei_txt);
		textView29 = (TextView) getActivity().findViewById(R.id.ability1_txt);
		textView30 = (TextView) getActivity().findViewById(R.id.Type_txt);
		textView77 = (TextView) getActivity().findViewById(R.id.type2);
		textView31 = (TextView) getActivity().findViewById(R.id.SEX_txt);

		textView76 = (TextView) getActivity().findViewById(R.id.SEX2_txt);

		// ランキング
		textView32 = (TextView) getActivity().findViewById(R.id.HP_ranking);
		textView33 = (TextView) getActivity().findViewById(R.id.ATK_ranking);
		textView34 = (TextView) getActivity().findViewById(R.id.DEF_ranking);
		textView35 = (TextView) getActivity().findViewById(R.id.SATK_ranking);
		textView36 = (TextView) getActivity().findViewById(R.id.SDEF_ranking);
		textView37 = (TextView) getActivity().findViewById(R.id.SPE_ranking);
		textView38 = (TextView) getActivity().findViewById(R.id.SUM_ranking);

		textView39 = (TextView) getActivity().findViewById(R.id.change_fol1);
		textView40 = (TextView) getActivity().findViewById(R.id.change_fol2);
		textView41 = (TextView) getActivity().findViewById(R.id.change_fol3);
		textView42 = (TextView) getActivity().findViewById(R.id.change_fol4);
		textView43 = (TextView) getActivity().findViewById(R.id.change_fol5);

		textView28 = (TextView) getActivity().findViewById(R.id.revolution_txt);
		textView44 = (TextView) getActivity()
				.findViewById(R.id.revolution2_txt);
		textView45 = (TextView) getActivity()
				.findViewById(R.id.revolution3_txt);
		textView46 = (TextView) getActivity()
				.findViewById(R.id.revolution4_txt);
		textView47 = (TextView) getActivity()
				.findViewById(R.id.revolution5_txt);
		textView48 = (TextView) getActivity()
				.findViewById(R.id.revolution6_txt);
		textView49 = (TextView) getActivity()
				.findViewById(R.id.revolution7_txt);
		textView50 = (TextView) getActivity()
				.findViewById(R.id.revolution8_txt);
		textView51 = (TextView) getActivity()
				.findViewById(R.id.revolution9_txt);

		textView52 = (TextView) getActivity().findViewById(R.id.exp2);
		textView53 = (TextView) getActivity().findViewById(R.id.exp3);
		textView54 = (TextView) getActivity().findViewById(R.id.exp4);
		textView55 = (TextView) getActivity().findViewById(R.id.exp5);
		textView56 = (TextView) getActivity().findViewById(R.id.exp6);
		textView57 = (TextView) getActivity().findViewById(R.id.exp7);
		textView58 = (TextView) getActivity().findViewById(R.id.exp8);
		textView59 = (TextView) getActivity().findViewById(R.id.exp9);
		textView3 = (TextView) getActivity().findViewById(R.id.normal);
		textView4 = (TextView) getActivity().findViewById(R.id.fire);
		textView60 = (TextView) getActivity().findViewById(R.id.water);
		textView61 = (TextView) getActivity().findViewById(R.id.elect);
		textView62 = (TextView) getActivity().findViewById(R.id.glass);
		textView63 = (TextView) getActivity().findViewById(R.id.ice);
		textView64 = (TextView) getActivity().findViewById(R.id.fight);
		textView65 = (TextView) getActivity().findViewById(R.id.poisson);
		textView66 = (TextView) getActivity().findViewById(R.id.ground);
		textView67 = (TextView) getActivity().findViewById(R.id.fly);
		textView68 = (TextView) getActivity().findViewById(R.id.esper);
		textView69 = (TextView) getActivity().findViewById(R.id.bag);
		textView70 = (TextView) getActivity().findViewById(R.id.rock);
		textView71 = (TextView) getActivity().findViewById(R.id.goast);
		textView72 = (TextView) getActivity().findViewById(R.id.dragon);
		textView73 = (TextView) getActivity().findViewById(R.id.dark);
		textView74 = (TextView) getActivity().findViewById(R.id.steal);
		textView75 = (TextView) getActivity().findViewById(R.id.fealy);

		textView78 = (TextView) getActivity().findViewById(R.id.textView18);
		textView79 = (TextView) getActivity().findViewById(R.id.textView17);
		textView80 = (TextView) getActivity().findViewById(R.id.textView16);
		textView81 = (TextView) getActivity().findViewById(R.id.textView15);
		textView82 = (TextView) getActivity().findViewById(R.id.textView14);
		textView83 = (TextView) getActivity().findViewById(R.id.textView13);
		textView84 = (TextView) getActivity().findViewById(R.id.textView12);

		final int HP = Integer
				.parseInt(com.kenpos.app.picture_books_pokemon_pro.title.HP);
		final int ATK = Integer
				.parseInt(com.kenpos.app.picture_books_pokemon_pro.title.ATK);
		final int DEF = Integer
				.parseInt(com.kenpos.app.picture_books_pokemon_pro.title.DEF);
		final int SATK = Integer
				.parseInt(com.kenpos.app.picture_books_pokemon_pro.title.SATK);
		final int SDEF = Integer
				.parseInt(com.kenpos.app.picture_books_pokemon_pro.title.SDEF);
		final int SPE = Integer
				.parseInt(com.kenpos.app.picture_books_pokemon_pro.title.SPE);
		final int SUM = Integer
				.parseInt(com.kenpos.app.picture_books_pokemon_pro.title.SUM) / 6;

		final ScrollView Scrollview = (ScrollView) getActivity().findViewById(
				R.id.scrollView);
		
		set_val();

		// フォルムチェンジ
		textView39.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView39.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.fol_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				
			}
		});

		// フォルムチェンジ1
		textView40.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView40.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.fol_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				
			}
		});

		// フォルムチェンジ2
		textView41.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView41.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.fol_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				
			}
		});

		// フォルムチェンジ3
		textView42.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView42.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.fol_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				
			}
		});

		// フォルムチェンジ4
		textView43.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView43.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.fol_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				
			}
		});

		//進化1
		textView44.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView44.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.revo_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				
			}
		});

		//進化2
		textView45.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView45.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.revo_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				
			}
		});
		
		//進化3
		textView46.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView46.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.revo_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				
			}
		});
		
		//進化4
		textView47.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView47.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.revo_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				
			}
		});
		
		//進化5
		textView48.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView48.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.revo_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				
			}
		});
		
		//進化6
		textView49.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView49.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.revo_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				
			}
		});
		
		//進化7
		textView50.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView50.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.revo_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				
			}
		});

		
		//進化8
		textView51.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView51.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.revo_cousor(serch);
					set_val();
				}catch (Exception e) {
					
				}
				
			}
		});

		//進化9
		textView28.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView28.getText().toString();
					Log.d("フォルム", serch);
					MainActivity.revo_cousor(serch);
					set_val();
				}catch (Exception e) {
				}
				}
		});
		

		//特性2
		textView2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView2.getText().toString();
					Log.d("フォルム", serch);
					Tokusei_serch.kensaku_tokusei(serch);
					 Intent intent = new Intent(getActivity(), tokusei_result.class);
						startActivity(intent);

				}catch (Exception e) {
				}
			}
		});

		//夢特性
		textView8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView8.getText().toString();
					Log.d("フォルム", serch);
					Tokusei_serch.kensaku_tokusei(serch);
					 Intent intent = new Intent(getActivity(), tokusei_result.class);
						startActivity(intent);
				}catch (Exception e) {
				}
			}
		});

		//特性1
		textView29.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					String serch = textView29.getText().toString();
					Log.d("フォルム", serch);
					Tokusei_serch.kensaku_tokusei(serch);
					 Intent intent = new Intent(getActivity(), tokusei_result.class);
						startActivity(intent);
				}catch (Exception e) {
				}
			}
		});

		
		//タイプ1
		textView30.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					TYPE_serch.serch1 = textView30.getText().toString();
					TYPE_serch.serch2 = textView77.getText().toString();
					 Intent intent = new Intent(getActivity(), TYPE_serch.class);
						startActivity(intent);
				}catch (Exception e) {
				}
			}
		});
		
		//タイプ2
		textView77.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					TYPE_serch.serch1 = textView30.getText().toString();
					TYPE_serch.serch2 = textView77.getText().toString();
					 Intent intent = new Intent(getActivity(), TYPE_serch.class);
					 startActivity(intent);
				}catch (Exception e) {
				}
			}
		});
		
		
		//タマゴ1
		textView9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					egg_result.serch1 = textView9.getText().toString();
					egg_result.serch2 = textView10.getText().toString();
					 Intent intent = new Intent(getActivity(),egg_result.class);
					 startActivity(intent);
				}catch (Exception e) {
				}
			}
		});
		
		//タマゴ2
		textView10.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						try{
							egg_result.serch1 = textView9.getText().toString();
							egg_result.serch2 = textView10.getText().toString();
							 Intent intent = new Intent(getActivity(),egg_result.class);
							 startActivity(intent);
						}catch (Exception e) {
						}
					}
				});
		
	}

}
