package com.example.tmdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recycleviewmultipleviews.BR;
import com.example.recycleviewmultipleviews.R;
import com.example.recycleviewmultipleviews.databinding.ActivityMovieListBinding;
import com.example.tmdb.model.TmdbMovie;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<com.example.tmdb.MovieListAdapter.Viewholder> {

    private Context context;
    private List<TmdbMovie> dataModelArrayList;

    // Constructor
    public MovieListAdapter(Context context, List<TmdbMovie> dataModelArrayList) {
        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    @NonNull
    @Override
    public com.example.tmdb.MovieListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ActivityMovieListBinding view = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.activity_movie_list, parent, false);
        return new com.example.tmdb.MovieListAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.tmdb.MovieListAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        TmdbMovie model = dataModelArrayList.get(position);
        holder.bind(model);
        String image = "";
        image = "https://image.tmdb.org/t/p/w500" + model.getPoster_path();
        Glide.with(context).load(image).into(holder.movieBinding.poster);
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return dataModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        ActivityMovieListBinding movieBinding;

        public Viewholder(@NonNull ActivityMovieListBinding itemView) {
            super(itemView.getRoot());
            this.movieBinding = itemView;

        }

        public void bind(Object obj) {
            movieBinding.setVariable(BR.model, obj);
            movieBinding.executePendingBindings();
        }
    }
}
