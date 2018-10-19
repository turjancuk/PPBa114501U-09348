package com.example.lenovo.moviefix.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;

import com.example.lenovo.moviefix.R;
import com.example.lenovo.moviefix.helper.DBHandler;

public class Home extends AppCompatActivity {

    private Button btn_tambah;
    private Button btn_lihat;
    private Button btn_hapus;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dbHandler = new DBHandler(Home.this);
        initComponents();
    }

    private void initComponents(){
        btn_tambah = (Button) findViewById(R.id.btn_tambah);
        btn_lihat = (Button) findViewById(R.id.btn_lihat);
        btn_hapus = (Button) findViewById(R.id.btn_hapus);

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Home.this, TambahMovie.class);
                startActivity(i);
            }
        });

        btn_lihat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Home.this, LihatMovie.class));
            }
        });

        btn_hapus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dbHandler.hapusSemuaDataMovie();
                Toast.makeText(Home.this, "Berhasil Menghapus Semua Data Movie", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View view) {
    }
}
