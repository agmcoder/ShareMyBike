package es.riberadeltajo.sharemybike.repository;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import es.riberadeltajo.sharemybike.BikeAdapter;
import es.riberadeltajo.sharemybike.BikeListActivity;
import es.riberadeltajo.sharemybike.model.Bike;

public class FirebaseDataHelperReal {
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference myRef = db.getReference("bikes_list");

    public FirebaseDataHelperReal() {
    }

    public void getAllBikes(){

        myRef.addValueEventListener(new ValueEventListener() {
            List<Bike> bikes = new ArrayList<>();
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot bikeSnapshot : dataSnapshot.getChildren()) {
                    Bike bike = bikeSnapshot.getValue(Bike.class);
                    bikes.add(bike);
                }
                BikeAdapter.bikeList = bikes;
                BikeListActivity.adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }
}
