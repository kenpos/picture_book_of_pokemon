package com.kenpos.app.picture_books_pro_pokemon_Fragment;

import java.util.Locale;
import com.kenpos.app.picture_books_pokemon_pro.Memo_result;
import com.kenpos.app.picture_books_pokemon_pro.R;
import com.kenpos.app.picture_books_pokemon_pro.Speed_Cheack;
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

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public  class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	// The {@link ViewPager} that will host the section contents.
	ViewPager mViewPager;
	
	static Intent intent ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setTheme(R.style.Theme_Sherlock);  
		setContentView(R.layout.activity_main);

		
		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
//		actionBar.hide();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}  
	
	// 消された時に自動で呼び出されるメソッド
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		//db.close();
		super.onDestroy();
	}

	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment;
			switch (position) {
			case 0:
				fragment = new Status_Fragment();
				break;
			case 1:
				fragment = new LV_Fragment2();
				break;
			case 2:
				fragment = new WAZAMACHINE_Fragment();
				break;
			case 3:
				fragment = new IDEN_Fragment4();
				break;
			case 4:
				fragment = new OSIEWAZA_Fragment5();
				break;

				
			default:
				throw new IllegalArgumentException("Invalid section number");
			}
			Bundle args = new Bundle();
			args.putInt(Status_Fragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// ページ総数
			return 5;
		}

		// ページタイトル
		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return getString(R.string.title_section4).toUpperCase(l);
			case 4:
				return getString(R.string.title_section5).toUpperCase(l);

			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

public static void fol_cousor(String serch){
title.fol_serch(serch);
	
}
public static void revo_cousor(String serch){
title.revo_serch(serch);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {

	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}
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
      	Intent intent14 = new Intent(this, Speed_Cheack.class);
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

@Override
public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
	// TODO Auto-generated method stub
	mViewPager.setCurrentItem(tab.getPosition());
}

@Override
public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
	// TODO Auto-generated method stub
	 
	 mViewPager.setCurrentItem(tab.getPosition());
}

@Override
public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
	// TODO Auto-generated method stub
	
}

public class SectionsPagerAdapter1 extends FragmentPagerAdapter {

	public SectionsPagerAdapter1(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		// getItem is called to instantiate the fragment for the given page.
		// Return a PlaceholderFragment (defined as a static inner class
		// below).
		return PlaceholderFragment.newInstance(position + 1);
	}

	@Override
	public int getCount() {
		// Show 3 total pages.
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			return getString(R.string.title_section1).toUpperCase(l);
		case 1:
			return getString(R.string.title_section2).toUpperCase(l);
		case 2:
			return getString(R.string.title_section3).toUpperCase(l);
		}
		return null;
	}
}

/**
 * A placeholder fragment containing a simple view.
 */
public static class PlaceholderFragment extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static PlaceholderFragment newInstance(int sectionNumber) {
		PlaceholderFragment fragment = new PlaceholderFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.page1r, container,
				false);
		TextView textView = (TextView) rootView
				.findViewById(R.id.section_label);
		textView.setText(Integer.toString(getArguments().getInt(
				ARG_SECTION_NUMBER)));
		return rootView;
	}
}



}
	
