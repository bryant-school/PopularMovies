package com.example.popularmovies;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {
    private RecyclerView rvMovies;
    private MovieAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    ArrayList<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        rvMovies = (RecyclerView) findViewById(R.id.rv_movie_list);
        movies = Movie.CreateMovieList(100);

        rvMovies.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2 , GridLayoutManager.VERTICAL, false);
        rvMovies.setLayoutManager(layoutManager);

        mAdapter = new MovieAdapter(movies);
        rvMovies.setAdapter(mAdapter);
    }
}
