package com.example.recycleviewmultipleviews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    int TIME = 5000; //5000 ms (5 Seconds)
    AdapterClass adapter;
    RecyclerView recyclerView;
    CoordinatorLayout coordinatorLayout;
    public Toolbar toolbar;
    private AppBarConfiguration mAppBarConfiguration;
    public DrawerLayout drawerLayout;

    public NavController navController;

    public NavigationView navigationView;

    private BottomNavigationView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigation();
        //bottomNavigationView = findViewById(R.id.bottomNavigationView);

        //bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView.setSelectedItemId(R.id.person);
        // From the MainActivity, find the RecyclerView.
        /*recyclerView
                = findViewById(R.id.recyclerView);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        //getSupportActionBar().hide();
        // Create and set the layout manager
        // For the RecyclerView.
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this);
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

                Toast.makeText(getApplicationContext(),
                        "Hello from Layout Three!",
                        Toast.LENGTH_LONG)
                        .show();
                //function(); //call function!
                //adapterClass.removeItem(8);
            }
        }, TIME);
*/
        //enableSwipeToDeleteAndUndo();

    }

    // Setting Up One Time Navigation
    private void setupNavigation() {

        toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.navigationView);
        bottomNavView = findViewById(R.id.bottom_nav_view);
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.first, R.id.second, R.id.third,
                R.id.fourth)
                .setDrawerLayout(drawerLayout)
                .build();*/

        navController = navHostFragment.getNavController();

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
        //navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);

        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(bottomNavView, navController);

         navigationView.setNavigationItemSelectedListener(this);
         bottomNavView.setOnNavigationItemSelectedListener(this);
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

            case R.id.fourth:
                navController.navigate(R.id.fourthFragment);
                break;

        }
        return true;

    }

    private void enableSwipeToDeleteAndUndo() {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this) {
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