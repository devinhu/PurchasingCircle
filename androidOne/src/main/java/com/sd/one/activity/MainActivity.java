/*
    ShengDao Android Client, MainActivity
    Copyright (c) 2014 ShengDao Tech Company Limited
 */

package com.sd.one.activity;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import com.sd.one.R;
import com.sd.one.activity.find.FindActivity;
import com.sd.one.activity.product.ProductActivity;
import com.sd.one.activity.customer.CustomerActivity;
import com.sd.one.activity.home.HomeActivity;
import com.sd.one.activity.more.MoerActivity;
import com.sd.one.common.manager.ActivityPageManager;
import com.sd.one.common.manager.LruCacheManager;
import com.sd.one.widget.dialog.MessageDialog;

/**
 * [主页框架]
 *
 * @author huxinwu
 * @version 1.0
 * @date 2014-3-1
 *
 **/
@SuppressWarnings("deprecation")
public class MainActivity extends ActivityGroup implements OnCheckedChangeListener {


	private TabHost tabHost;
	private RadioGroup radioGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);

		Intent orderIntent = new Intent(this, HomeActivity.class);
		Intent productIntent = new Intent(this, ProductActivity.class);
		Intent customerIntent = new Intent(this, CustomerActivity.class);
		Intent findIntent = new Intent(this, FindActivity.class);
		Intent memberIntent = new Intent(this, MoerActivity.class);

		tabHost = (TabHost) findViewById(R.id.tabhost);
		tabHost.setup(getLocalActivityManager());
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("tab1").setContent(orderIntent));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("tab2").setContent(productIntent));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("tab3").setContent(customerIntent));
		tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("tab4").setContent(findIntent));
		tabHost.addTab(tabHost.newTabSpec("tab5").setIndicator("tab5").setContent(memberIntent));

		radioGroup = (RadioGroup) super.findViewById(R.id.radioGroup_menu);
		radioGroup.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int checkedId) {
		switch (checkedId) {
			case R.id.radio_order:
				tabHost.setCurrentTab(0);
				break;

			case R.id.radio_product:
				tabHost.setCurrentTab(1);
				break;

			case R.id.radio_customer:
				tabHost.setCurrentTab(2);
				break;

			case R.id.radio_find:
				tabHost.setCurrentTab(3);
				break;

			case R.id.radio_member:
				tabHost.setCurrentTab(4);
				break;
		}
	}

	/**
	 * 切换tab
	 * @param checkedId
	 */
	public void switchTab(int checkedId){
		radioGroup.check(checkedId);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		//TODO 接受intent
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Activity currentActivity = getLocalActivityManager().getCurrentActivity();
		if(currentActivity instanceof BaseActivity){
			((BaseActivity)currentActivity).onActivityResult(requestCode, resultCode, data);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
	    	MessageDialog dialog = new MessageDialog(MainActivity.this,
					getString(R.string.common_title_tips),
					getString(R.string.common_confirm),
					getString(R.string.common_cancel),
					getString(R.string.common_exit));
			dialog.setBtn1ClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					LruCacheManager.getInstance().evictAll();
					ActivityPageManager.getInstance().exit(MainActivity.this);
				}
			});
			dialog.show();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
}
