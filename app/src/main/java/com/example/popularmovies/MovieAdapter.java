package com.example.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> mMovies;
    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClick(Movie movie);
    }

    //
    // MovieViewHolder class
    //
    public class MovieViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public TextView nameTextView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_movie_list_item_title);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(mMovies.get(clickedPosition));
        }
    }

    public MovieAdapter(List<Movie> movies, ListItemClickListener onClickListener) {
        mMovies = movies;
        mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View movieView = layoutInflater.inflate(R.layout.movie_list_item, parent, false);

        return new MovieViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        Movie movieTitle = mMovies.get(position);

        TextView textView = holder.nameTextView;
        textView.setText(movieTitle.getTitle());
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }
}
