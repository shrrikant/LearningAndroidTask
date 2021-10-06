package com.example.tmdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.recycleviewmultipleviews.R;
import com.example.recycleviewmultipleviews.databinding.ActivityMovieBinding;
import com.example.tmdb.model.Tmdb;
import com.example.tmdb.model.TmdbMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDetailsActivity extends AppCompatActivity {
    private ActivityMovieBinding binding;
    static final String TAG = TmdbMainActivity.class.getSimpleName();
    static final String BASE_URL = "https://api.themoviedb.org/3/";
    static Retrofit retrofit = null;
    final static String API_KEY = "079ab243592a5951f8c22cff6482f258";
    int movie_id = 0;
    List<TmdbMovie> tmdbMovieList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie);
        //setContentView(R.layout.activity_movie_details);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            movie_id = extras.getInt("movie_id", 0);
            //The key argument here must match that used in the other activity
        }

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
        Call<TmdbMovie> call = movieApiService.getMovieById(movie_id, API_KEY);
        call.enqueue(new Callback<TmdbMovie>() {
            @Override
            public void onResponse(Call<TmdbMovie> call, Response<TmdbMovie> response) {

                if(null != response) {

                    TmdbMovie tmdbMovie = new TmdbMovie();
                    tmdbMovie = response.body();

                    binding.setModel(tmdbMovie);
                    //binding.title.setText(tmdbMovieList.title);
                }
                //Log.i(TAG, tmdbMovieList.toString());


            }

            @Override
            public void onFailure(Call<TmdbMovie> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }


}