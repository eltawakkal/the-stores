package com.example.thebestone.thestores.model;

/**
 * Created by thebestone on 10/5/17.
 */

public class Custom_header extends Items {

    public Custom_header(String product_name, String store_name, String product_price) {
        super(product_name, store_name, product_price);
    }

    @Override
    public int getItemType() {
        return HEADER_ITEM_TYPE;
    }




}
