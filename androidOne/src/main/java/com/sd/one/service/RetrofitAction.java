package com.sd.one.service;

import android.content.Context;
import com.sd.one.model.base.BaseResponse;
import com.sd.one.model.response.ConfigData;
import com.sd.one.utils.DateUtils;
import com.sd.one.utils.db.DBManager;
import com.sd.one.utils.db.entity.Customer;
import com.sd.one.utils.db.entity.Order;
import com.sd.one.utils.db.entity.Product;

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
    public Customer addCustomer(String name, String phone){
        Customer bean = new Customer();
        bean.setName(name);
        bean.setPhone(phone);
        bean.setCreteTime(DateUtils.currentDateTime());
        long rowId = DBManager.getInstance(mContext).getDaoSession().getCustomerDao().insert(bean);
        if(rowId > 0){
            return DBManager.getInstance(mContext).getDaoSession().getCustomerDao().loadByRowId(rowId);
        }
        return null;
    }


    /**
     * 添加订单
     * @param customer
     * @param productName
     * @param number
     * @param baseprice
     * @param desc
     * @param image
     * @param planflag
     * @return
     */
    public Long addOder(Customer customer, String productName, String number, String baseprice, String desc, String image, boolean planflag){
        Order order = new Order();

        //将产品信息入库
        Product product = new Product();
        product.setPorductName(productName);
        product.setBasePrice(baseprice);
        product.setImage(image);
        product.setDesc(desc);
        long rowId = DBManager.getInstance(mContext).getDaoSession().getProductDao().insert(product);


        //获取产品id
        Product pro = DBManager.getInstance(mContext).getDaoSession().getProductDao().loadByRowId(rowId);
        order.setProductId(pro.getProductId());
        order.setPorductName(pro.getPorductName());
        order.setBaseprice(pro.getBasePrice());
        order.setDesc(pro.getDesc());
        order.setNumber(number);
        order.setCreteTime(DateUtils.currentDateTime());

        //OrderStatus 0:为付款 1:已付款 2:已发货
        order.setOrderStatus("0");
        order.setPlanflag(planflag);

        order.setCustomerId(customer.getCustomerId());
        order.setCustomerName(customer.getName());
        order.setCustomerPhone(customer.getPhone());

        return DBManager.getInstance(mContext).getDaoSession().getOrderDao().insert(order);
    }

    /**
     * 查询订单列表
     * @return
     */
    public List<Order> getOrderList(){
        return DBManager.getInstance(mContext).getDaoSession().getOrderDao().loadAll();
    }
}
