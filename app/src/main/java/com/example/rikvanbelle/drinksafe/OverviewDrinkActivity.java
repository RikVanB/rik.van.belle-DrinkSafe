package com.example.rikvanbelle.drinksafe;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.rikvanbelle.drinksafe.helpers.AdapterBeer;
import com.example.rikvanbelle.drinksafe.helpers.AdapterBeerQuantity;
import com.example.rikvanbelle.drinksafe.models.Beer;

import java.util.ArrayList;
import java.util.HashMap;

public class OverviewDrinkActivity extends AppCompatActivity {

    ListView listViewBeers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview_drink);

        listViewBeers = (ListView) findViewById(R.id.list_beers);

        Intent intent = this.getIntent();
        HashMap<Beer, Integer> listOfBeers = (HashMap<Beer, Integer>) intent.getSerializableExtra("listOfBeers");

        ArrayList<Beer> allBeers = new ArrayList<Beer>();
        allBeers.addAll(listOfBeers.keySet());

        AdapterBeerQuantity adapterBeer = new AdapterBeerQuantity(this, R.layout.row_beer_quantity_layout, allBeers);
        adapterBeer.setBeersWithQuantity(listOfBeers);
        listViewBeers.setAdapter(adapterBeer);
    }
}
