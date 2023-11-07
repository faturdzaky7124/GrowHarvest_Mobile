package com.features.growharvest.DatabaseConnection;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "GrowHarvestDB";
    private static final int DATABASE_VERSION = 1;

    // Nama tabel dan kolom dalam database
    String TABLE_USERS = "Akun";
    String COLUMN_NAMA = "nama";
    String COLUMN_EMAIL = "email";
}
