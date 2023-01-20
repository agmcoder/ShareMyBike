package es.riberadeltajo.sharemybike;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

public class BikeListActivity extends AppCompatActivity {

    private ListView listView ;
    @SuppressLint("StaticFieldLeak")
    public static BikeAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_list);
        FirebaseApp.initializeApp(this);
        listView = findViewById(R.id.listView);
        adapter = new BikeAdapter(this);
        listView.setAdapter(adapter);
    }


}