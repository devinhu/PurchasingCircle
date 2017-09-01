package com.sd.one.service;

import android.content.Context;
import com.sd.one.model.base.BaseResponse;
import com.sd.one.model.response.ConfigData;
import com.sd.one.utils.db.DBManager;
import com.sd.one.utils.db.entity.Customer;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import retrofit2.Call;

/**
 * [一句话简单描述]
 *
 * @author huxinwu
 * @version 1.0
 * @date 2016/12/14
 */
public class RetrofitAction extends RetrofitManager {

    /**
     * 构造方法
     * @param mContext
     */
    public RetrofitAction(Context mContext) {
        super(mContext);
    }

    /**
     * 获取配置信息接口
     * @return
     */
    public Call<BaseResponse<List<ConfigData>>> getConfig() {
        HashMap params = getRequestParams();
        return apiService.getConfig(params);
    }

    /**
     * 查询客户列表
     * @return
     */
    public List<Customer> getCustomerList(){
        return DBManager.getInstance(mContext).getDaoSession().getCustomerDao().loadAll();
    }

    /**
     * 添加客户
     * @param name
     * @param phone
     */
    public Long addCustomer(String name, String phone){
        Customer bean = new Customer();
        bean.setName(name);
        bean.setPhone(phone);
        bean.setCreteTime(new Date().toString());
        return DBManager.getInstance(mContext).getDaoSession().getCustomerDao().insert(bean);
    }
}
