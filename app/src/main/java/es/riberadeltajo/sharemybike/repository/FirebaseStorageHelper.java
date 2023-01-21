package es.riberadeltajo.sharemybike.repository;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import es.riberadeltajo.sharemybike.BikeListActivity;
import es.riberadeltajo.sharemybike.R;

public class FirebaseStorageHelper {

        private Context context;
        private FirebaseStorage storage;
    public FirebaseStorageHelper(Context context){
         this.storage = FirebaseStorage.getInstance();
        this.context = context;
    }

    public void getImage(final ImageView imageView, String image){
        StorageReference gsReference = storage.getReferenceFromUrl("gs://hale-cocoa-328702.appspot.com/bici.jpg");

        gsReference.getBytes(Long.MAX_VALUE).addOnSuccessListener(bytes -> {
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            imageView.setImageBitmap(bitmap);
            //BikeListActivity.adapter.notifyDataSetChanged();

        }).addOnFailureListener(exception -> {
            imageView.setImageResource(com.google.firebase.storage.R.drawable.common_google_signin_btn_icon_disabled);
        });
    }

}
