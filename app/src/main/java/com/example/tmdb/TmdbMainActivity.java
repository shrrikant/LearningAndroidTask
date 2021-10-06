package com.example.tmdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.recycleviewmultipleviews.R;
import com.example.recycleviewmultipleviews.databinding.ActivityTmdbMainBinding;
import com.example.tmdb.model.Tmdb;
import com.example.tmdb.model.TmdbMovie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TmdbMainActivity extends AppCompatActivity {
    static final String TAG = TmdbMainActivity.class.getSimpleName();
    static final String BASE_URL = "https://api.themoviedb.org/3/";
    static Retrofit retrofit = null;
    final static String API_KEY = "079ab243592a5951f8c22cff6482f258";
    private ActivityTmdbMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_tmdb_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tmdb_main);
        connect();


    }

    private void connect() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        MovieApiService movieApiService = retrofit.create(MovieApiService.class);
        Call<Tmdb> call = movieApiService.getMovies(API_KEY);
        call.enqueue(new Callback<Tmdb>() {
            @Override
            public void onResponse(Call<Tmdb> call, Response<Tmdb> response) {

                List<TmdbMovie> tmdbMovieList = response.body().results;
                Log.i(TAG, tmdbMovieList.toString());
                setMovieAdapter(tmdbMovieList);

            }

            @Override
            public void onFailure(Call<Tmdb> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }

    private void setMovieAdapter(List<TmdbMovie> tmdbMovieList) {

        // we are initializing our adapter class and passing our arraylist to it.
        MovieListAdapter movieAdapter = new MovieListAdapter(this, tmdbMovieList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        RecyclerView.LayoutManager linearLayoutManager = new GridLayoutManager(this, 2);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        binding.movieRecyclerView.setLayoutManager(linearLayoutManager);
        binding.setMyAdapter(movieAdapter);
    }
}
