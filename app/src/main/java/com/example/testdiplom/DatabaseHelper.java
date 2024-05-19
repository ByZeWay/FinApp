package com.example.testdiplom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.testdiplom.account.Account;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "finance_manager.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ACCOUNTS = "accounts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AMOUNT = "amount";
    private static final String COLUMN_INCLUDE_IN_BALANCE = "include_in_balance";
    private static final String COLUMN_ICON_RES_ID = "icon_res_id";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACCOUNTS_TABLE = "CREATE TABLE " + TABLE_ACCOUNTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_AMOUNT + " REAL,"
                + COLUMN_INCLUDE_IN_BALANCE + " INTEGER,"
                + COLUMN_ICON_RES_ID + " INTEGER" + ")";
        db.execSQL(CREATE_ACCOUNTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);
        onCreate(db);
    }

    public void addAccount(Account account) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, account.getName());
        values.put(COLUMN_AMOUNT, account.getAmount());
        values.put(COLUMN_INCLUDE_IN_BALANCE, account.isIncludeInBalance() ? 1 : 0);
        values.put(COLUMN_ICON_RES_ID, account.getIconResId());

        db.insert(TABLE_ACCOUNTS, null, values);
        db.close();
    }

    public List<Account> getAllAccounts() {
        List<Account> accountList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_ACCOUNTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Account account = new Account(
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                        cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)),
                        cursor.getInt(cursor.getColumnIndex(COLUMN_INCLUDE_IN_BALANCE)) == 1,
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ICON_RES_ID))
                );
                accountList.add(account);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return accountList;
    }
}
