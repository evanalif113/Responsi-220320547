package com.example.responsi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "pengeluaran";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "tabelpengeluaran";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String TANGGAL_COL = "tanggal";

    // below variable id for our course duration column.
    private static final String KEPERLUAN_COL = "keperluan";

    // below variable for our course description column.
    private static final String NILAI_COL = "nilai";

    // below variable is for our course tracks column.
    private static final String KETERANGAN_COL = "keterangan";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TANGGAL_COL + " TEXT,"
                + KEPERLUAN_COL + " TEXT,"
                + NILAI_COL + " TEXT,"
                + KETERANGAN_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewPengeluaran(String tanggal, String keperluan, String nilai, String keterangan) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(TANGGAL_COL, tanggal);
        values.put(KEPERLUAN_COL, keperluan);
        values.put(NILAI_COL, nilai);
        values.put(KETERANGAN_COL, keterangan);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // we have created a new method for reading all the courses.
    public ArrayList<PengeluaranModal> readPengeluaran() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorPengeluaran = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<PengeluaranModal> PengeluaranModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorPengeluaran.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                PengeluaranModalArrayList.add(new PengeluaranModal(
                        cursorPengeluaran.getString(1),
                        cursorPengeluaran.getString(4),
                        cursorPengeluaran.getString(2),
                        cursorPengeluaran.getString(3)));
            } while (cursorPengeluaran.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorPengeluaran.close();
        return PengeluaranModalArrayList;
    }

    // below is the method for updating our courses
    public void updateCourse(String originalCourseName,
                             String tanggal,
                             String keperluan,
                             String nilai,
                             String keterangan) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(TANGGAL_COL, tanggal);
        values.put(KEPERLUAN_COL, keperluan);
        values.put(NILAI_COL, nilai);
        values.put(KETERANGAN_COL, keterangan);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME, values, "name=?", new String[]{originalCourseName});
        db.close();
    }

    // below is the method for deleting our course.
    public void deleteCourse(String tanggal) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME, "name=?", new String[]{tanggal});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

