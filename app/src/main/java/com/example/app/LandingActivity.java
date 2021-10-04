package com.example.app;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewmultipleviews.ItemClass;
import com.example.recycleviewmultipleviews.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class LandingActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;
    String jsonFileString = "";
    // Arraylist for storing data
    private ArrayList<DentistDataModal> courseModelArrayList = new ArrayList<>();
    private DentistModal dentistDataModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_activity);
        categoryRecyclerView = findViewById(R.id.category_recycler_view);
        getDentistData();
    }


    private void getDentistData() {
        dentistDataModal = new DentistModal();
        jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "categoryJSONResponse.json");
        Log.i("data", jsonFileString);
        Gson gson = new Gson();
        dentistDataModal = gson.fromJson(jsonFileString, DentistModal.class);
        courseModelArrayList = dentistDataModal.getData();
        setCategoryAdapetr();
    }

    private void setCategoryAdapetr() {

        // we are initializing our adapter class and passing our arraylist to it.
        AdapterLanding courseAdapter = new AdapterLanding(this, courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        categoryRecyclerView.setLayoutManager(linearLayoutManager);
        categoryRecyclerView.setAdapter(courseAdapter);
    }
}