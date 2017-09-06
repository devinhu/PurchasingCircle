package com.sd.one.utils.db.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.sd.one.utils.db.entity.Order;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ORDER".
*/
public class OrderDao extends AbstractDao<Order, Long> {

    public static final String TABLENAME = "ORDER";

    /**
     * Properties of entity Order.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property OrderId = new Property(0, Long.class, "orderId", true, "_id");
        public final static Property CustomerId = new Property(1, long.class, "customerId", false, "CUSTOMER_ID");
        public final static Property CustomerName = new Property(2, String.class, "customerName", false, "CUSTOMER_NAME");
        public final static Property CustomerPhone = new Property(3, String.class, "customerPhone", false, "CUSTOMER_PHONE");
        public final static Property AddressId = new Property(4, Long.class, "addressId", false, "ADDRESS_ID");
        public final static Property PorductName = new Property(5, String.class, "porductName", false, "PORDUCT_NAME");
        public final static Property ProductId = new Property(6, Long.class, "productId", false, "PRODUCT_ID");
        public final static Property FinalPrice = new Property(7, String.class, "finalPrice", false, "FINAL_PRICE");
        public final static Property Baseprice = new Property(8, String.class, "baseprice", false, "BASEPRICE");
        public final static Property Number = new Property(9, int.class, "number", false, "NUMBER");
        public final static Property Desc = new Property(10, String.class, "desc", false, "DESC");
        public final static Property CreteTime = new Property(11, String.class, "creteTime", false, "CRETE_TIME");
        public final static Property OrderStatus = new Property(12, String.class, "orderStatus", false, "ORDER_STATUS");
        public final static Property Planflag = new Property(13, boolean.class, "planflag", false, "PLANFLAG");
    };


    public OrderDao(DaoConfig config) {
        super(config);
    }
    
    public OrderDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORDER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: orderId
                "\"CUSTOMER_ID\" INTEGER NOT NULL ," + // 1: customerId
                "\"CUSTOMER_NAME\" TEXT," + // 2: customerName
                "\"CUSTOMER_PHONE\" TEXT," + // 3: customerPhone
                "\"ADDRESS_ID\" INTEGER," + // 4: addressId
                "\"PORDUCT_NAME\" TEXT," + // 5: porductName
                "\"PRODUCT_ID\" INTEGER," + // 6: productId
                "\"FINAL_PRICE\" TEXT," + // 7: finalPrice
                "\"BASEPRICE\" TEXT," + // 8: baseprice
                "\"NUMBER\" INTEGER NOT NULL ," + // 9: number
                "\"DESC\" TEXT," + // 10: desc
                "\"CRETE_TIME\" TEXT," + // 11: creteTime
                "\"ORDER_STATUS\" TEXT," + // 12: orderStatus
                "\"PLANFLAG\" INTEGER NOT NULL );"); // 13: planflag
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORDER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Order entity) {
        stmt.clearBindings();
 
        Long orderId = entity.getOrderId();
        if (orderId != null) {
            stmt.bindLong(1, orderId);
        }
        stmt.bindLong(2, entity.getCustomerId());
 
        String customerName = entity.getCustomerName();
        if (customerName != null) {
            stmt.bindString(3, customerName);
        }
 
        String customerPhone = entity.getCustomerPhone();
        if (customerPhone != null) {
            stmt.bindString(4, customerPhone);
        }
 
        Long addressId = entity.getAddressId();
        if (addressId != null) {
            stmt.bindLong(5, addressId);
        }
 
        String porductName = entity.getPorductName();
        if (porductName != null) {
            stmt.bindString(6, porductName);
        }
 
        Long productId = entity.getProductId();
        if (productId != null) {
            stmt.bindLong(7, productId);
        }
 
        String finalPrice = entity.getFinalPrice();
        if (finalPrice != null) {
            stmt.bindString(8, finalPrice);
        }
 
        String baseprice = entity.getBaseprice();
        if (baseprice != null) {
            stmt.bindString(9, baseprice);
        }
        stmt.bindLong(10, entity.getNumber());
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(11, desc);
        }
 
        String creteTime = entity.getCreteTime();
        if (creteTime != null) {
            stmt.bindString(12, creteTime);
        }
 
        String orderStatus = entity.getOrderStatus();
        if (orderStatus != null) {
            stmt.bindString(13, orderStatus);
        }
        stmt.bindLong(14, entity.getPlanflag() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Order entity) {
        stmt.clearBindings();
 
        Long orderId = entity.getOrderId();
        if (orderId != null) {
            stmt.bindLong(1, orderId);
        }
        stmt.bindLong(2, entity.getCustomerId());
 
        String customerName = entity.getCustomerName();
        if (customerName != null) {
            stmt.bindString(3, customerName);
        }
 
        String customerPhone = entity.getCustomerPhone();
        if (customerPhone != null) {
            stmt.bindString(4, customerPhone);
        }
 
        Long addressId = entity.getAddressId();
        if (addressId != null) {
            stmt.bindLong(5, addressId);
        }
 
        String porductName = entity.getPorductName();
        if (porductName != null) {
            stmt.bindString(6, porductName);
        }
 
        Long productId = entity.getProductId();
        if (productId != null) {
            stmt.bindLong(7, productId);
        }
 
        String finalPrice = entity.getFinalPrice();
        if (finalPrice != null) {
            stmt.bindString(8, finalPrice);
        }
 
        String baseprice = entity.getBaseprice();
        if (baseprice != null) {
            stmt.bindString(9, baseprice);
        }
        stmt.bindLong(10, entity.getNumber());
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(11, desc);
        }
 
        String creteTime = entity.getCreteTime();
        if (creteTime != null) {
            stmt.bindString(12, creteTime);
        }
 
        String orderStatus = entity.getOrderStatus();
        if (orderStatus != null) {
            stmt.bindString(13, orderStatus);
        }
        stmt.bindLong(14, entity.getPlanflag() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Order readEntity(Cursor cursor, int offset) {
        Order entity = new Order( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // orderId
            cursor.getLong(offset + 1), // customerId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // customerName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // customerPhone
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // addressId
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // porductName
            cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6), // productId
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // finalPrice
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // baseprice
            cursor.getInt(offset + 9), // number
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // desc
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // creteTime
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // orderStatus
            cursor.getShort(offset + 13) != 0 // planflag
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Order entity, int offset) {
        entity.setOrderId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCustomerId(cursor.getLong(offset + 1));
        entity.setCustomerName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCustomerPhone(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAddressId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setPorductName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setProductId(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
        entity.setFinalPrice(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setBaseprice(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setNumber(cursor.getInt(offset + 9));
        entity.setDesc(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setCreteTime(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setOrderStatus(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setPlanflag(cursor.getShort(offset + 13) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Order entity, long rowId) {
        entity.setOrderId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Order entity) {
        if(entity != null) {
            return entity.getOrderId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
