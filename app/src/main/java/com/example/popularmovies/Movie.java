package com.example.popularmovies;

import java.net.URL;
import java.util.ArrayList;

public class Movie {
    private String mTitle;
    private String mReleaseDate;
    private String mMoviePoster;
    private int mVoteAverage;
    private String mPlotSynopsis;

    public Movie(String title, String releaseDate, String moviePoster, int voteAverage, String plotSynopsis) {
        mTitle = title;
        mReleaseDate = releaseDate;
        mMoviePoster = moviePoster;
        mVoteAverage = voteAverage;
        mPlotSynopsis = plotSynopsis;

    }

    private static int lastMovieId = 0;

    public static ArrayList<Movie> CreateMovieList(int numMovies) {
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 1; i <= numMovies; i++) {
            movies.add(new Movie("Movie " + ++lastMovieId, "Release Data", "Poster URL", 0, "Plot Synopsis"));
        }

        return movies;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getMoviePoster() {
        return mMoviePoster;
    }

    public int getVoteAverage() {
        return mVoteAverage;
    }

    public String getPlotSynopsis() {
        return mPlotSynopsis;
    }
}
