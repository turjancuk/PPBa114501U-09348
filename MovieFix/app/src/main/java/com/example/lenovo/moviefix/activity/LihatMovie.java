package com.example.lenovo.moviefix.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.lenovo.moviefix.R;
import com.example.lenovo.moviefix.adapter.MovieAdapter;
import com.example.lenovo.moviefix.helper.DBHandler;
import com.example.lenovo.moviefix.helper.RecyclerItemClickListener;
import com.example.lenovo.moviefix.model.Movie;

import java.util.ArrayList;
import java.util.List;


public class LihatMovie extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MovieAdapter adapter;
    private DBHandler dbHandler;
    private TextView txt_resultadapter;
    private List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_data);

        initComponents();
        initRecyclerView();
        cekDataRecyclerView();
    }

    // FUNGSI INI UNTUK MENG-INIT RECYLERVIEW BESERTA ADAPTERNYA
    private void initRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.rv_movie);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dbHandler = new DBHandler(LihatMovie.this);
        movieList = dbHandler.getSemuaMovie();
        adapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initComponents(){
        txt_resultadapter = (TextView) findViewById(R.id.txt_resultadapter);
    }

    // FUNGSI INI UNTUK MENGECEK APAKAH ADA DATA DI DALEM RECYCLERVIEW ATAU TIDAK
    private void cekDataRecyclerView(){
        if (adapter.getItemCount() == 0){
            txt_resultadapter.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            txt_resultadapter.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {
                            // TODO Handle item click
                            Movie movie = movieList.get(position);
                            String nama = movie.getJudul();

                            Toast.makeText(LihatMovie.this, "Klik di " + nama, Toast.LENGTH_SHORT).show();
                        }
                    })
            );
        }
    }
}
