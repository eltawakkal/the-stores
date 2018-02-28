package com.example.thebestone.thestores.model;

/**
 * Created by thebestone on 10/5/17.
 */

public abstract class Items {

    public static final int HEADER_ITEM_TYPE = 0;
    public static final int CHILD_ITEM_TYPE = 1;

    private String product_name;
    private String store_name;
    private String product_price;

    public Items(String product_name, String store_name, String product_price) {
        this.product_name = product_name;
        this.store_name = store_name;
        this.product_price = product_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getStore_name() {
        return store_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public abstract int getItemType();
}
