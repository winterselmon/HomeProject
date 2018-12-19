package com.example.bestl.homeproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bestl.homeproject.model.Items;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper implements Serializable {

    private final String TAG = "database_name";
    private SQLiteDatabase sqLiteDatabase;
    private List<String> templeList;

    private Context context;

    public DBHelper(Context context) {
        super(context, Items.DATABASE_NAME, null, Items.DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_Temple_TABLE = String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY  AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                Items.TABLE,
                Items.Column.ID,
                Items.Column.ITEMS_NAME,
                Items.Column.ITEMS_AMOUNT,
                Items.Column.ITEMS_PACK,
                Items.Column.ITEMS_PRICE,
                Items.Column.IMAGE_PATH);

        Log.i(TAG, CREATE_Temple_TABLE);

        sqLiteDatabase.execSQL(CREATE_Temple_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public Items getItemsList(String id) {
        sqLiteDatabase = this.getReadableDatabase();
        Items items = new Items();
        Cursor cursor = sqLiteDatabase.query(Items.TABLE,
                null,
                Items.Column.ID + " = ? ",
                new String[]{id},
                null,
                null,
                null,
                null);

        if (cursor != null && cursor.moveToFirst()) {
            items.setId((int) cursor.getLong(0));
            items.setItems_name(cursor.getString(1));
            items.setItems_pack(cursor.getString(2));
            items.setItems_amount(cursor.getString(3));
            items.setItems_price(cursor.getString(4));
            items.setImage_path(cursor.getString(5));

        }

        return items;
    }


    public void addItems(Items items) {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Items.Column.ITEMS_NAME, items.getItems_name());
        values.put(Items.Column.ITEMS_PACK, items.getItems_pack());
        values.put(Items.Column.ITEMS_AMOUNT, items.getItems_amount());
        values.put(Items.Column.ITEMS_PRICE, items.getItems_price());
        values.put(Items.Column.IMAGE_PATH, items.getImage_path());

        sqLiteDatabase.insert(Items.TABLE, null, values);

        sqLiteDatabase.close();
    }

    public void updateItems(Items items) {

        sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Items.Column.ID, items.getId());
        values.put(Items.Column.ITEMS_NAME, items.getItems_name());
        values.put(Items.Column.ITEMS_PACK, items.getItems_pack());
        values.put(Items.Column.ITEMS_AMOUNT, items.getItems_amount());
        values.put(Items.Column.ITEMS_PRICE, items.getItems_price());
        values.put(Items.Column.IMAGE_PATH, items.getImage_path());

        int row = sqLiteDatabase.update(Items.TABLE,
                values,
                Items.Column.ID + " = ? ",
                new String[]{String.valueOf(items.getId())});

        sqLiteDatabase.close();
    }


    public ArrayList<String> getItems_name() {
        ArrayList<String> items_list = new ArrayList<String>();
        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(Items.TABLE,
                null,
                Items.Column.ITEMS_NAME + " = ?",
                null,
                null,
                null,
                null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while (!cursor.isAfterLast()) {
            items_list.add(cursor.getString(1));
            cursor.moveToNext();
        }

        sqLiteDatabase.close();

        return items_list;
    }


    public void deleteItems(String id) {

        sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.delete(Items.TABLE, Items.Column.ID + " = " + id, null);

        sqLiteDatabase.close();
    }
}
