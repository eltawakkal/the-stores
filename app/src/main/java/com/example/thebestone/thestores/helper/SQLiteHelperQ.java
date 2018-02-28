package com.example.thebestone.thestores.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * Created by thebestone on 10/10/17.
 */

public class SQLiteHelperQ extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dbTheStore";
    private static final String CREATE_TABLE = "CREATE TABLE tbProduct (ID VARCHAR(225), PRODUCT_NAME VARCHAR(225), " +
            "PRODUCT_PRICE VARCHAR(225), PRODUCT_DESC VARCHAR(225), PRODUCT_INGREDIENTS VARCHAR(225), PRODUCT_CATEGORY VARCHAR(225), " +
            "PRODUCT_STORE_NAME VARCHAR, PRODUCT_STOCK VARCHAR(225))";

    public SQLiteHelperQ(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
