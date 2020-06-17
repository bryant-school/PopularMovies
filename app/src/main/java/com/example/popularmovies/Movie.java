package com.example.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

import java.net.URL;
import java.util.ArrayList;

public class Movie implements Parcelable {

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

    public Movie(Parcel parcel) {
        mTitle = parcel.readString();
        mReleaseDate = parcel.readString();
        mMoviePoster = parcel.readString();
        mVoteAverage = parcel.readInt();
        mPlotSynopsis = parcel.readString();
    }

    private static int lastMovieId = 0;

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mReleaseDate);
        dest.writeString(mMoviePoster);
        dest.writeInt(mVoteAverage);
        dest.writeString(mPlotSynopsis);
    }
}
