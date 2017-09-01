package com.sd.one.activity.more;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sd.one.R;
import com.sd.one.activity.BaseActivity;
import com.sd.one.activity.adapter.ServiceItemAdater;
import com.sd.one.common.async.HttpException;
import com.sd.one.utils.StringUtils;
import com.sd.one.utils.db.entity.Customer;
import com.sd.one.widget.dialog.LoadDialog;
import com.sd.one.widget.pulltorefresh.PullToRefreshBase;
import com.sd.one.widget.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * [客户管理]
 *
 * @author huxinwu
 * @version 1.0
 * @date 2016-5-4
 *
 **/
public class CustomerActivity extends BaseActivity implements View.OnClickListener,AdapterView.OnItemClickListener, PullToRefreshBase.OnRefreshListener<ListView>{

    private final int GET_SERVICE_LIST = 6600;
    private final int DELETE_SERVICE = 6601;
    private final int REQUEST_CODE = 1001;
    private final int REQUEST_EDIT_CODE = 1002;
    private PullToRefreshListView refreshcrollview;
    private ServiceItemAdater mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listview);
        //初始化控件
        initView();
    }

    private void initView() {
        tv_title.setText("客户管理");
        setBtnRight("添加");
        btn_right.setOnClickListener(this);

        refreshcrollview = getViewById(R.id.refreshlistview);
        refreshcrollview.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        refreshcrollview.setOnRefreshListener(this);

        mAdapter = new ServiceItemAdater(this);
        View splitView = LayoutInflater.from(this).inflate(R.layout.split_view, null);
        refreshcrollview.getRefreshableView().addHeaderView(splitView);
        refreshcrollview.getRefreshableView().setAdapter(mAdapter);

        LoadDialog.show(this);
        request(GET_SERVICE_LIST);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_right:
                Intent intent = new Intent(this, CustomerAddActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE:
                if(resultCode== Activity.RESULT_OK){
                    LoadDialog.show(CustomerActivity.this);
                    request(GET_SERVICE_LIST);
                }
                break;
            case REQUEST_EDIT_CODE:
                if(resultCode== Activity.RESULT_OK){
                    LoadDialog.show(CustomerActivity.this);
                    request(GET_SERVICE_LIST);
                }
                break;
            default:
                break;
        }
    }


    @Override
    public Object doInBackground(int requestCode) throws HttpException {
        switch (requestCode) {
            case GET_SERVICE_LIST:
                return action.getCustomerList();

        }
        return null;
    }

    @Override
    public void onSuccess(int requestCode, Object result) {
        switch (requestCode) {
            case GET_SERVICE_LIST:
                LoadDialog.dismiss(mContext);
                if (result != null) {
                    List<Customer> list = (ArrayList<Customer>) result;
                    if (!StringUtils.isEmpty(list)) {
                        mAdapter.removeAll();
                        mAdapter.setDataSet(list);
                        mAdapter.notifyDataSetChanged();
                    }
                }
                refreshcrollview.onRefreshComplete();
                break;
        }
    }

    @Override
    public void onFailure(int requestCode, int state, Object result) {
        super.onFailure(requestCode, state, result);
        switch (requestCode) {
            case GET_SERVICE_LIST:
                LoadDialog.dismiss(mContext);
                refreshcrollview.onRefreshComplete();
                break;
        }
    }

    @Override
    public void onRefresh(PullToRefreshBase<ListView> refreshView) {
        LoadDialog.show(this);
        request(GET_SERVICE_LIST);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Customer model = mAdapter.getDataSet().get(position-1);
    }

//    @Override
//    public boolean onItemLongClick(AdapterView<?> parent, View view, final int mPosition, long id) {
//        ServiceModel model = mListData.get(mPosition-1);
//        mServiceId = model.getId();
//        if(model.getType()==0){
//        }else{
//            messgeDialog = new MessgeDialog(this, "您确定要删除该服务吗?", new OnAlertItemClickListener() {
//                @Override
//                public void onItemClick(Object o, int position) {
//                    if (position == 0) {
//                        //删除服务
//                        mDelPosition = mPosition;
//                        LoadDialog.show(CustomerActivity.this);
//                        request(DELETE_SERVICE);
//                    }
//                }
//            });
//            messgeDialog.setOnDismissListener(new OnDismissListener() {
//                @Override
//                public void onDismiss(Object o) {}
//            });
//            messgeDialog.setCancelable(true);
//            messgeDialog.show();
//        }
//        return true;
//    }
}

