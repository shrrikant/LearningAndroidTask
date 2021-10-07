package com.example.tmdb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recycleviewmultipleviews.BR;
import com.example.recycleviewmultipleviews.R;

import com.example.recycleviewmultipleviews.databinding.RowMovieListBinding;
import com.example.tmdb.model.TmdbMovie;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<com.example.tmdb.MovieListAdapter.Viewholder> {

    private Context context;
    private List<TmdbMovie> dataModelArrayList;
    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private static final String BASE_URL_IMG = "https://image.tmdb.org/t/p/w500";
    private boolean isLoadingAdded = false;

    // Constructor
    public MovieListAdapter(Context context, List<TmdbMovie> dataModelArrayList) {
        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    public MovieListAdapter(Context context) {
        this.context = context;
        this.dataModelArrayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public com.example.tmdb.MovieListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        RowMovieListBinding view = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_movie_list, parent, false);
        return new com.example.tmdb.MovieListAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.tmdb.MovieListAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        TmdbMovie model = dataModelArrayList.get(position);
        holder.bind(model);
        String image = "";
        image = BASE_URL_IMG + model.getPoster_path();
        Glide.with(context).load(image).into(holder.movieBinding.poster);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(context, MovieDetailsActivity.class);
                i.putExtra("movie_id",model.id);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
                //context.startActivity(new Intent(view.getContext(), MovieDetailsActivity.class));
            }
        });
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
        RowMovieListBinding movieBinding;

        public Viewholder(@NonNull RowMovieListBinding itemView) {
            super(itemView.getRoot());
            this.movieBinding = itemView;

        }

        public void bind(Object obj) {
            movieBinding.setVariable(BR.model, obj);
            movieBinding.executePendingBindings();
        }
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new TmdbMovie());
    }

    public void add(TmdbMovie r) {
        dataModelArrayList.add(r);
        notifyItemInserted(dataModelArrayList.size() - 1);
    }

    public void addAll(List<TmdbMovie> moveResults) {
        for (TmdbMovie result : moveResults) {
            add(result);
        }
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = dataModelArrayList.size() - 1;
        TmdbMovie result = getItem(position);

        if (result != null) {
            dataModelArrayList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public TmdbMovie getItem(int position) {
        return dataModelArrayList.get(position);
    }
}
