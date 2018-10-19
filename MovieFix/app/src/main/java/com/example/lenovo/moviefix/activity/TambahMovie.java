package com.example.lenovo.moviefix.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.moviefix.R;
import com.example.lenovo.moviefix.adapter.MovieAdapter;
import com.example.lenovo.moviefix.helper.DBHandler;
import com.example.lenovo.moviefix.model.Movie;

import java.util.List;


public class TambahMovie extends AppCompatActivity{
    private EditText et_judul;
    private EditText et_rating;
    private EditText et_status;
    private Button btn_tambah;

    private DBHandler dbHandler;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_data);

        dbHandler = new DBHandler(this);
        initComponents();
    }

    private void initComponents(){
        et_judul = (EditText) findViewById(R.id.et_judul);
        et_rating = (EditText) findViewById(R.id.et_rating);
        et_status = (EditText) findViewById(R.id.et_status);
        btn_tambah = (Button) findViewById(R.id.btn_tambah);

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiForm();
            }
        });
    }

    // FUNGSI INI UNTUK MEMVALIDASI FORM JIKA ADA YANG KOSONG ATAU TIDAK
    // LALU DILANJUT UNTUK MENJALANKAN PERINTAH SELANJUTNYA
    private void validasiForm(){
        String form_judul = et_judul.getText().toString();
        String form_rating = et_rating.getText().toString();
        String form_status = et_status.getText().toString();

        if (form_judul.isEmpty()){
            et_judul.setError("Isi judul dulu");
            et_judul.requestFocus();
        } if (form_rating.isEmpty()){
            et_rating.setError("Isi rating dulu");
            et_rating.requestFocus();
        } if (form_status.isEmpty()){
            et_status.setError("Isi status dulu");
            et_status.requestFocus();
        } else {
            dbHandler.tambahMovie(new Movie(form_judul, form_rating, form_status));
            List<Movie> movieList = dbHandler.getSemuaMovie();
            adapter = new MovieAdapter(movieList);
            adapter.notifyDataSetChanged();

            Toast.makeText(TambahMovie.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
        }
    }
}
