package com.example.lenovo.moviefix.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.lenovo.moviefix.R;
import com.example.lenovo.moviefix.model.Movie;

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movieList = new ArrayList<>();

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(view);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {
        holder.txt_resultjudul.setText(movieList.get(position).getJudul());
        holder.txt_resultrating.setText(movieList.get(position).getRating());
        holder.txt_resultstatus.setText(movieList.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView txt_resultjudul;
        TextView txt_resultrating;
        TextView txt_resultstatus;

        public MovieViewHolder(View itemView) {
            super(itemView);

            txt_resultjudul = (TextView) itemView.findViewById(R.id.txt_resultjudul);
            txt_resultrating = (TextView) itemView.findViewById(R.id.txt_resultrating);
            txt_resultstatus = (TextView) itemView.findViewById(R.id.txt_resultstatus);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
