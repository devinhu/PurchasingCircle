/*
    ShengDao Android Client, CategoryActivity
    Copyright (c) 2014 ShengDao Tech Company Limited
 */

package com.sd.one.activity.category;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.sd.one.R;
import com.sd.one.activity.BaseActivity;

/**
 * [下单页面]
 * 
 * @author huxinwu
 * @version 1.0
 * @date 2014-11-6
 * 
 **/
public class CategoryActivity extends BaseActivity implements View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category_layout);

		tv_title.setText(getString(R.string.menu_category_title));
		tv_title.setFocusable(true);
		tv_title.setFocusableInTouchMode(true);
		tv_title.requestFocus();

		btn_left.setVisibility(View.GONE);
		btn_right.setVisibility(View.VISIBLE);
		btn_right.setOnClickListener(this);
		btn_right.setText("添加");
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return getParent().onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.btn_right:

				break;
		}
	}
}
