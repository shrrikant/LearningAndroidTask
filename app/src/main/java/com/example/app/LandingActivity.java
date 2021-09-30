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

    //String JSON_STRING = "{\"status\":100,\"message\":\"success\",\"data\":[{\"id\":1,\"name\":\"Restorative Dentistry\",\"shortName\":\"Restorative\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Restorative+Dentistry.png\",\"totalCourses\":10},{\"id\":2,\"name\":\"Prosthodontics\",\"shortName\":\"Prostho\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Prosthodontics.png\",\"totalCourses\":1},{\"id\":3,\"name\":\"Periodontics\",\"shortName\":\"Perio\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Periodontics.png\",\"totalCourses\":3},{\"id\":4,\"name\":\"Oral Implantology\",\"shortName\":\"Implants\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Oral+Implantology.png\",\"totalCourses\":5},{\"id\":5,\"name\":\"Full Mouth Rehabilitation\",\"shortName\":\"FMR\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/FMR.png\",\"totalCourses\":4},{\"id\":6,\"name\":\"Endodontics\",\"shortName\":\"Endo\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Endodontic.png\",\"totalCourses\":2},{\"id\":7,\"name\":\"Esthetics\",\"shortName\":\"Esthetics\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Esthetics.png\",\"totalCourses\":6},{\"id\":8,\"name\":\"Complete Dentures\",\"shortName\":\"CD\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Complete+Dentures.png\",\"totalCourses\":3},{\"id\":9,\"name\":\"Practice Management\",\"shortName\":\"PM\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Practice+Management.png\",\"totalCourses\":0},{\"id\":11,\"name\":\"Pedodontics\",\"shortName\":\"Pedo\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Pedodontics.png\",\"totalCourses\":0},{\"id\":12,\"name\":\"Oral Surgery\",\"shortName\":\"OS\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Oral+Surgery.png\",\"totalCourses\":0}],\"total\":0,\"count\":0,\"currentPage\":0}";
    //private RecyclerView courseRV;
    String jsonFileString ="";
    // Arraylist for storing data
    private ArrayList<DataModel> courseModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_activity);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // From the MainActivity, find the RecyclerView.
        //recyclerView
        //       = findViewById(R.id.recyclerView);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        //getSupportActionBar().hide();
        // Create and set the layout manager
        // For the RecyclerView.
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "categoryJSONResponse.json");
        Log.i("data", jsonFileString);

        try {

            getDentistData();

            //JSONObject root = new JSONObject(JSON_STRING);


            /*JSONArray array = root.getJSONArray("data");

            dm = new DentistModal();

            dm.setStatus(Integer.parseInt(root.getString("status")));
            dm.setMessage(root.getString("message"));
            dm.setTotal(Integer.parseInt(root.getString("total")));
            dm.setCount(Integer.parseInt(root.getString("count")));
            dm.setCurrentPage(Integer.parseInt(root.getString("currentPage")));

            ArrayList<DentistDataModal> mItemListArray = new ArrayList<DentistDataModal>();

            for (int i = 0; i < array.length(); i++) {
                DentistDataModal ddm = new DentistDataModal();

                JSONObject object = array.getJSONObject(i);

                ddm.setId(Integer.parseInt(object.getString("id")));
                ddm.setName(object.getString("name"));
                ddm.setShortName(object.getString("shortName"));
                ddm.setImage(object.getString("image"));
                ddm.setTotalCourses(object.getString("totalCourses"));
                mItemListArray.add(ddm);
            }

            dm.setData(mItemListArray);


        //courseRV = findViewById(R.id.recyclerView);

        // here we have created new array list and added data to it.
        courseModelArrayList = new ArrayList<>();

        for(int i=0; i<dm.getData().size(); i++) {


            courseModelArrayList.add(new DataModel(dm.getData().get(i).getName(), dm.getData().get(i).getImage()));
        }

        // we are initializing our adapter class and passing our arraylist to it.
        AdapterLanding courseAdapter = new AdapterLanding(this, courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(courseAdapter);*/
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    private List<DentistDataModal> getDentistData() {
        if (jsonFileString != null) {

            Gson gson = new Gson();
            DentistModal baseData = gson.fromJson(jsonFileString, DentistModal.class);
            return baseData.getDentistdata();

        } else {
            Toast.makeText(this, "Please load JSON", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}