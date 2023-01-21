package es.riberadeltajo.sharemybike;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import es.riberadeltajo.sharemybike.model.Bike;
import es.riberadeltajo.sharemybike.repository.FirebaseDataHelperFire;
import es.riberadeltajo.sharemybike.repository.FirebaseDataHelperReal;
import es.riberadeltajo.sharemybike.repository.FirebaseStorageHelper;

public class BikeAdapter extends BaseAdapter {

    public static List<Bike> bikeList;
    private final FirebaseStorageHelper firebaseStorageHelper;
    private Context context;
    public static Uri uri;

    public BikeAdapter(Context context) {
        this.context = context;
        BikeAdapter.bikeList = new ArrayList<>();
        FirebaseDataHelperFire firebaseDataHelperFire = new FirebaseDataHelperFire();
        FirebaseDataHelperReal firebaseDataHelperReal = new FirebaseDataHelperReal();
        firebaseDataHelperReal.getAllBikes();
        ///firebaseDataHelperFire.getAllBikes();
        this.firebaseStorageHelper =   new FirebaseStorageHelper(context);
    }

    @Override
    public int getCount() {
        return bikeList.size();
    }

    @Override
    public Object getItem(int position) {
        return bikeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.bike_item, parent, false);
        }
        ImageView imageView = view.findViewById(R.id.imageView);

        Bike bike = bikeList.get(position);
        
        //set image of imageView
        firebaseStorageHelper.getImage(imageView, bike.getImage());

        return view;
    }


}
