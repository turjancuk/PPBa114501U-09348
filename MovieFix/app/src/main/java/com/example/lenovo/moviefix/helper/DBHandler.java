package com.example.lenovo.moviefix.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lenovo.moviefix.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_movie"; // NAMA DATABASE
    private static final String TABLE_MOVIE = "table_movie"; // NAMA TABEL
    private static final String COLUMN_ID = "id"; // NAMA KOLOM ID
    private static final String COLUMN_judul = "judul"; // NAMA KOLOM NAMA
    private static final String COLUMN_rating = "rating"; // NAMA KOLOM NAMA
    private static final String COLUMN_status = "status"; // NAMA KOLOM NAMA

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // FUNGSI UNTUK MEMBUAT DATABASENYA
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_MOVIE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_judul + " TEXT," + COLUMN_rating + " TEXT,"
                + COLUMN_status + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    // FUNGSI UNTUK MENGECEK DATABASE ADA ATAU TIDAK.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIE);
        onCreate(db);
    }

    // FUNGSI UNTUK TAMBAH DATA MOVIE
    public void tambahMovie(Movie movie){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_judul, movie.getJudul());
        values.put(COLUMN_rating, movie.getRating());
        values.put(COLUMN_status, movie.getStatus());

        db.insert(TABLE_MOVIE, null, values);
        db.close();
    }

    // FUNGSI UNTUK AMBIL 1 DATA MAHASISWA
    public Movie getMovie(int id_movie){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MOVIE, new String[]{COLUMN_ID, COLUMN_judul, COLUMN_rating, COLUMN_status},
                COLUMN_ID + "=?", new String[]{String.valueOf(id_movie)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Movie movie = new Movie(cursor.getString(1), cursor.getString(2));
        return movie;
    }

    // FUNGSI UNTUK AMBIL SEMUA DATA MAHASISWA
    public List<Movie> getSemuaMovie(){
        List<Movie> movieList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_MOVIE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Movie movie = new Movie(cursor.getString(1), cursor.getString(2));
                movieList.add(movie);
            } while (cursor.moveToNext());
        }
        return movieList;
    }

    // FUNGSI MENGHITUNG ADA BEBERAPA DATA
    public int getMovieCount(){
        String countQuery = "SELECT * FROM " + TABLE_MOVIE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // FUNGSI UPDATE DATA MOVIE
    public int updateDataMovie(Movie movie) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_judul, movie.getJudul());
        values.put(COLUMN_rating, movie.getRating());
        values.put(COLUMN_status, movie.getStatus());
        return db.update(TABLE_MOVIE, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(movie.getId())});
    }

    // FUNGSI HAPUS DATA 1 MOVIE
    public void hapusDataMovie(Movie movie) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MOVIE, COLUMN_ID + " = ?",
                new String[]{String.valueOf(movie.getId())});
        db.close();
    }

    // FUNGSI UNTUK MENGHAPUS SEMUA DATA MOVIE
    public void hapusSemuaDataMovie(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_MOVIE);
    }
}
