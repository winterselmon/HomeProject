package com.example.bestl.homeproject.model;

import android.provider.BaseColumns;

public class Items {

    private int id;
    private String items_name;
    private String items_pack;
    private String items_amount;
    private String items_price;
    private String image_path;

    public static final String DATABASE_NAME = "items.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "items";

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String ITEMS_NAME = "items_name";
        public static final String ITEMS_PACK = "items_pack";
        public static final String ITEMS_AMOUNT = "items_amount";
        public static final String ITEMS_PRICE = "items_price";
        public static final String IMAGE_PATH = "image_path";
    }

    public Items() {

    }

    public Items(int id, String items_name, String items_pack, String items_amount, String items_price, String image_path) {
        this.id = id;
        this.items_name = items_name;
        this.items_pack = items_pack;
        this.items_amount = items_amount;
        this.items_price = items_price;
        this.image_path = image_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItems_name() {
        return items_name;
    }

    public void setItems_name(String items_name) {
        this.items_name = items_name;
    }

    public String getItems_amount() {
        return items_amount;
    }

    public void setItems_amount(String items_amount) {
        this.items_amount = items_amount;
    }

    public String getItems_pack() {
        return items_pack;
    }

    public void setItems_pack(String items_pack) {
        this.items_pack = items_pack;
    }

    public String getItems_price() {
        return items_price;
    }

    public void setItems_price(String items_price) {
        this.items_price = items_price;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}
