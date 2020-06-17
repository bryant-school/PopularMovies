package com.example.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        // Get the movie details from the extra
        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra("Movie");

        // Populate the movie details layout
        TextView movieName = (TextView) findViewById(R.id.tv_movie_detail_title);
        movieName.setText(movie.getTitle());
    }
}
