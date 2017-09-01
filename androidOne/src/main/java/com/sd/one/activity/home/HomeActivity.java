/*
    ShengDao Android Client, HomeActivity
    Copyright (c) 2014 ShengDao Tech Company Limited
 */

package com.sd.one.activity.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

import com.sd.one.R;
import com.sd.one.activity.BaseActivity;
import com.sd.one.activity.adapter.TabPagerAdapter;
import com.sd.one.activity.adapter.ViewPagerAdapter;
import com.sd.one.widget.AdImageView;
import com.sd.one.widget.PagerSlidingTabStrip;
import com.sd.one.widget.autopager.AutoScrollViewPager;
import com.sd.one.widget.autopager.CirclePageIndicator;
import com.sd.one.widget.dialog.LoadDialog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * [A brief description]
 * 
 * @author huxinwu
 * @version 1.0
 * @date 2014-11-6
 * 
 **/
public class HomeActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{

	private AutoScrollViewPager adViewpager;
	private CirclePageIndicator indicator;

	private PagerSlidingTabStrip slidingtab;
	private TabPagerAdapter pagerAdapter;
	private ViewPager viewPager;

	private List<Fragment> fragmentList;
	private HashSet<Integer> hashset;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);

		tv_title.setText(getString(R.string.menu_home_title));
		tv_title.setFocusable(true);
		tv_title.setFocusableInTouchMode(true);
		tv_title.requestFocus();

		setBtnLeft(R.drawable.nav_back);
		btn_left.setVisibility(View.GONE);
		btn_left.setOnClickListener(this);
		setBtnRight(R.drawable.nav_back);
		btn_right.setVisibility(View.GONE);
		btn_right.setOnClickListener(this);

		adViewpager = getViewById(R.id.adViewpager);
		indicator = getViewById(R.id.indicator);

		List<String> list = new ArrayList<>();
		list.add("http://ad.qulover.com/o_1b3i202l0kgn1afu1ohi4lqroh9");
		list.add("http://ad.qulover.com/o_1b3i30rdrhd21vc9ebn1tb5j0h4d");
		initAdViews(list);

		initView();

	}

	/**
	 * 初始化广告
	 * @param adlist
	 */
	private void initAdViews(List<String> adlist) {
		AdImageView adImageView = null;
		ArrayList<View> pageViews = new ArrayList<View>();
		if (adlist != null && adlist.size() > 0) {
			for (String url : adlist) {
				adImageView = new AdImageView(mContext);
				adImageView.setUrl(url);
				pageViews.add(adImageView);
			}
		}

		adViewpager.setAdapter(new ViewPagerAdapter(pageViews));
		indicator.setViewPager(adViewpager);
		adViewpager.setInterval(5000);
		adViewpager.startAutoScroll();
	}

	private void initView() {
		hashset = new HashSet<Integer>();
		hashset.add(0);
		fragmentList = new CopyOnWriteArrayList<>();

		OrderFragment fragment1 = new OrderFragment();
		Bundle args = new Bundle();
		args.putString("type", "0");
		fragment1.setArguments(args);

		OrderFragment fragment2 = new OrderFragment();
		args = new Bundle();
		args.putString("type", "1");
		fragment2.setArguments(args);

		fragmentList.add(fragment1);
		fragmentList.add(fragment2);

		pagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
		pagerAdapter.setTitles(new String[]{"计划中", "已完成"});
		pagerAdapter.setFragments(fragmentList);

		viewPager = (ViewPager) findViewById(R.id.viewPager);
		viewPager.setAdapter(pagerAdapter);
		viewPager.setOffscreenPageLimit(fragmentList.size());

		slidingtab = (PagerSlidingTabStrip) findViewById(R.id.slidingtab);
		slidingtab.setViewPager(viewPager);
		slidingtab.setOnPageChangeListener(this);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return getParent().onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {
		if (!hashset.contains(position)) {
			hashset.add(position);
			//((OrderFragment) fragmentList.get(position)).initViews();
		}
	}

	@Override
	public void onPageScrollStateChanged(int position) {

	}
}
