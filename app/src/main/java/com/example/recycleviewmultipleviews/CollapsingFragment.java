package com.example.recycleviewmultipleviews;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class CollapsingFragment extends Fragment {

    int TIME = 5000; //5000 ms (5 Seconds)
    AdapterClass adapter;
    RecyclerView recyclerView;
    CoordinatorLayout coordinatorLayout;
    public Toolbar toolbar;

    public DrawerLayout drawerLayout;

    public NavController navController;

    public NavigationView navigationView;
    View view;
    FragmentActivity c;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_collapsing, container, false);
        //setContentView(R.layout.activity_main);
        c = getActivity();
        //setupNavigation();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        // From the MainActivity, find the RecyclerView.
        //recyclerView
         //       = findViewById(R.id.recyclerView);
        coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinatorLayout);
        //getSupportActionBar().hide();
        // Create and set the layout manager
        // For the RecyclerView.
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);

        List<ItemClass> itemClasses = new ArrayList<>();

        // pass the arguments
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, R.drawable.trash,
                "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, R.drawable.trash,
                "Item Type 1"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.login, R.drawable.trash,
                "Item Type 2", "Text"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, R.drawable.trash,
                "Item Type 1"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.signup, R.drawable.trash,
                "Item Type 2", "Text"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.profile, R.drawable.trash,
                "Item Type 2", "Text"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, R.drawable.trash,
                "Item Type 1"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutTwo, R.drawable.dashboard, R.drawable.trash,
                "Item Type 2", "Text"));
        itemClasses.add(new ItemClass(
                ItemClass.LayoutThree,
                "Loading"));
        AdapterClass adapterClass
                = new AdapterClass(itemClasses);

        adapter
                = new AdapterClass(itemClasses);

        // set the adapter
        recyclerView.setAdapter(adapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(c,
                        "Hello from Layout Three!",
                        Toast.LENGTH_LONG)
                        .show();
                //function(); //call function!
                //adapterClass.removeItem(8);
            }
        }, TIME);

        enableSwipeToDeleteAndUndo();

        return view;
    }

    // Setting Up One Time Navigation
    /*private void setupNavigation() {

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = view.findViewById(R.id.drawer_layout);

        navigationView = view.findViewById(R.id.navigationView);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();


        //navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);

        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), drawerLayout);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        menuItem.setChecked(true);

        drawerLayout.closeDrawers();

        int id = menuItem.getItemId();

        switch (id) {

            case R.id.first:
                navController.navigate(R.id.firstFragment);
                break;

            case R.id.second:
                navController.navigate(R.id.secondFragment);
                break;

            case R.id.third:
                navController.navigate(R.id.thirdFragment);
                break;

        }
        return true;

    }*/

    private void enableSwipeToDeleteAndUndo() {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(c) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                String name = adapter.itemClassList.get(viewHolder.getAdapterPosition()).getText();

                // backup of removed item for undo purpose
                final ItemClass deletedItem = adapter.itemClassList.get(viewHolder.getAdapterPosition());
                final int position = viewHolder.getAdapterPosition();

                //final int position = viewHolder.getAdapterPosition();
                //final ItemClass item = adapter.getItemId(position);

                adapter.removeItem(position);


                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Item was removed from the list.", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        adapter.restoreItem(deletedItem, position);
                        recyclerView.scrollToPosition(position);
                    }
                });

                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();

            }
        };

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(recyclerView);
    }

}