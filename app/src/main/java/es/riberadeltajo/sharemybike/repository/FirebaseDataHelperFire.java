package es.riberadeltajo.sharemybike.repository;


import static android.content.ContentValues.TAG;

import android.util.Log;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

import es.riberadeltajo.sharemybike.BikeAdapter;
import es.riberadeltajo.sharemybike.BikeListActivity;
import es.riberadeltajo.sharemybike.model.Bike;

public class FirebaseDataHelperFire {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference bikes = db.collection("bike_list");

    public FirebaseDataHelperFire() {
    }

    public void getAllBikes(){

        List<Bike> bikeList = new ArrayList<>();
        bikes.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Log.d(TAG, document.getId() + " => " + document.getData());
                    bikeList.add(document.toObject(Bike.class));

                }
            } else {
                Log.d(TAG, "Error getting documents: ", task.getException());
            }
        }).addOnCompleteListener(task -> {
            Log.d(TAG, "onComplete: " + bikeList.size());
            BikeAdapter.bikeList = bikeList;
            BikeListActivity.adapter.notifyDataSetChanged();
        }).addOnSuccessListener(aVoid -> {
            Log.d(TAG, "onSuccess: " + bikeList.size());
        });



    }
}

