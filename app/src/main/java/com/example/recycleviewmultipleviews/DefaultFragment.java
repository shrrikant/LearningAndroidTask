package com.example.recycleviewmultipleviews;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DefaultFragment extends Fragment {

    int TIME = 5000; //5000 ms (5 Seconds)
    AdapterClass adapter;
    RecyclerView recyclerView;
    ConstraintLayout constraintLayout;
    public Toolbar toolbar;

    //public DrawerLayout drawerLayout;

    //public NavController navController;

    //public NavigationView navigationView;
    View view;
    FragmentActivity c;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.default_fragment, container, false);



        return view;
    }

    private String getListData() {
        String jsonStr = "{\"status\":100,\"message\":\"success\",\"data\":[{\"id\":1,\"name\":\"Restorative Dentistry\",\"shortName\":\"Restorative\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Restorative+Dentistry.png\",\"totalCourses\":10},{\"id\":2,\"name\":\"Prosthodontics\",\"shortName\":\"Prostho\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Prosthodontics.png\",\"totalCourses\":1},{\"id\":3,\"name\":\"Periodontics\",\"shortName\":\"Perio\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Periodontics.png\",\"totalCourses\":3},{\"id\":4,\"name\":\"Oral Implantology\",\"shortName\":\"Implants\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Oral+Implantology.png\",\"totalCourses\":5},{\"id\":5,\"name\":\"Full Mouth Rehabilitation\",\"shortName\":\"FMR\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/FMR.png\",\"totalCourses\":4},{\"id\":6,\"name\":\"Endodontics\",\"shortName\":\"Endo\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Endodontic.png\",\"totalCourses\":2},{\"id\":7,\"name\":\"Esthetics\",\"shortName\":\"Esthetics\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Esthetics.png\",\"totalCourses\":6},{\"id\":8,\"name\":\"Complete Dentures\",\"shortName\":\"CD\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Complete+Dentures.png\",\"totalCourses\":3},{\"id\":9,\"name\":\"Practice Management\",\"shortName\":\"PM\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Practice+Management.png\",\"totalCourses\":0},{\"id\":11,\"name\":\"Pedodontics\",\"shortName\":\"Pedo\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Pedodontics.png\",\"totalCourses\":0},{\"id\":12,\"name\":\"Oral Surgery\",\"shortName\":\"OS\",\"image\":\"https://healthtech-nonprod.s3.ap-south-1.amazonaws.com/qa/images/category/Oral+Surgery.png\",\"totalCourses\":0}],\"total\":0,\"count\":0,\"currentPage\":0}";
        return jsonStr;
    }
}
