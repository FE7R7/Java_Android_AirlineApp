package com.example.demo;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;


public class TravelList extends AppCompatActivity {

    private Button b_travelToMain;

    private Toolbar toolbar;

    private ListView listview;

    private ArrayAdapter<String> travelListAdapter;

    private final String[] arrayTravelList = {"Passport", "Money", "phone charger", "sunglasses", "House keys", "Flight Tickets", "Accommodation Reservation", "sunscreen"};



    // ---------------------------------------------------- //


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_travel_list);

        // ---------------------------------------------------- //


        b_travelToMain = findViewById(R.id.b_listToMain);

        toolbar = findViewById(R.id.toolbar_travel_list);

        listview = findViewById(R.id.travelList_listView);


        // ---------------------------------------------------- //


        travelListAdapter = new ArrayAdapter<>(this, R.layout.list_custom_text, arrayTravelList);


        // ---------------------------------------------------- //


        listview.setAdapter(travelListAdapter);


        // ---------------------------------------------------- //


        b_travelToMain.setOnClickListener(view -> {

            Intent i = new Intent(TravelList.this, MainActivity_WelCome.class);

            startActivity(i);

        });

        // --------- Toolbar ---------- //

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Search...");

        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
    }


    // ---------------------------------------------------- //


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // ---------------------------------------------------- //


        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem menuItem = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setQueryHint("Please, Search Here...");

        // ---------------------------------------------------- //

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            // ---------------------------------------------------- //

            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            // ---------------------------------------------------- //

            @Override
            public boolean onQueryTextChange(String newText) {

                travelListAdapter.getFilter().filter(newText);

                return false;
            }

        });

        // ---------------------------------------------------- //

        return super.onCreateOptionsMenu(menu);

    }

}