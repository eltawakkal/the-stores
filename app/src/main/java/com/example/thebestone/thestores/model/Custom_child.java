package com.example.thebestone.thestores.model;

/**
 * Created by thebestone on 10/5/17.
 */

public class Custom_child extends Items {

    public Custom_child(String product_name, String store_name, String product_price) {
        super(product_name, store_name, product_price);
    }

    @Override
    public int getItemType() {
        return CHILD_ITEM_TYPE;
    }
}
