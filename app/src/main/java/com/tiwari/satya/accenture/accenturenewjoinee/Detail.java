package com.tiwari.satya.accenture.accenturenewjoinee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class Detail extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Spinner element
        Spinner country = (Spinner) findViewById(R.id.country);
        Spinner city = (Spinner)findViewById(R.id.cities);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Detail.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        // Spinner click listener

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Select Country");
        categories.add("India");
        categories.add("United States Of Ameria");
        categories.add("Italy");
        categories.add("Russia");
        categories.add("Germany");
        categories.add("Australia");
        categories.add("London");
        categories.add("Ireland");
        categories.add("Japan");
        categories.add("NetherLand");


        // Creating adapter for spinner
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.spinnertext,categories);
        country.setAdapter(adapter1);


        List<String> cities = new ArrayList<String>();
        cities.add("Select City");
        cities.add("Hyderabad");
        cities.add("Mumbai");
        cities.add("Benguluru");
        cities.add("Chennai");
        cities.add("Pune");
        cities.add("Gurugram");
        cities.add("New Delhi");


        // Creating adapter for spinner
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.spinnertext,cities);
        city.setAdapter(adapter2);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Detail Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.tiwari.satya.accenture.accenturenewjoinee/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Detail Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.tiwari.satya.accenture.accenturenewjoinee/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

