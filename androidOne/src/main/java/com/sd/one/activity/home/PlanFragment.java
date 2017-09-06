package com.sd.one.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sd.one.R;
import com.sd.one.activity.BaseFragment;
import com.sd.one.activity.adapter.OrderAdapter;
import com.sd.one.activity.adapter.PlanAdapter;
import com.sd.one.common.async.HttpException;
import com.sd.one.utils.StringUtils;
import com.sd.one.utils.db.entity.Customer;
import com.sd.one.utils.db.entity.Order;
import com.sd.one.widget.NoScrollerListView;
import com.sd.one.widget.dialog.LoadDialog;
import com.sd.one.widget.pulltorefresh.PullToRefreshBase;
import com.sd.one.widget.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;


/**
 * [我的订单 Fragment]
 *
 * @author zhouyuandong
 * @version 1.0
 * @date 2016-5-4
 *
 **/
public class PlanFragment extends BaseFragment implements AdapterView.OnItemClickListener{

    public static final int GET_PLAN_LIST = 1002;

    private View fragmentView;
    private String type;
    private NoScrollerListView refreshlistview;
    private PlanAdapter mAdapter;

    @Override
    public View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.order_layout, container, false);
        fragmentView.setFocusable(true);
        fragmentView.setFocusableInTouchMode(true);
        fragmentView.requestFocus();
        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void initViews(){
        refreshlistview = getViewById(R.id.listview);
        refreshlistview.setOnItemClickListener(this);


        LoadDialog.show(mContext);
        request(GET_PLAN_LIST);

    }

    @Override
    public Object doInBackground(int requestCode) throws HttpException {
        switch (requestCode) {
            case GET_PLAN_LIST:
                return action.getPlanList();
        }
        return null;
    }

    @Override
    public void onSuccess(int requestCode, Object result) {
        switch (requestCode) {
            case GET_PLAN_LIST:
                LoadDialog.dismiss(mContext);
                if (result != null) {
                    List<Order> list = (ArrayList<Order>) result;
                    mAdapter = new PlanAdapter(getActivity());
                    refreshlistview.setAdapter(mAdapter);
                    mAdapter.setDataSet(list);
                    mAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @Override
    public void onFailure(int requestCode, int state, Object result) {
        super.onFailure(requestCode, state, result);
        switch (requestCode) {
            case GET_PLAN_LIST:
                LoadDialog.dismiss(mContext);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }
}

