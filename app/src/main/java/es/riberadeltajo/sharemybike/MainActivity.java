package es.riberadeltajo.sharemybike;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

import es.riberadeltajo.sharemybike.repository.FirebaseDataHelperFire;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private Button googleButton;
    private Button googleMapsButton;

    //private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Inicializar botón de inicio de sesión con Google
        googleButton = findViewById(R.id.googleButton);
        googleMapsButton = findViewById(R.id.googleMapsButton);

        // Configurar opciones de inicio de sesión de Google
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        // Inicializar cliente de inicio de sesión de Google
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        FirebaseDataHelperFire firebaseDataHelperFire = new FirebaseDataHelperFire();

        // Establecer el listener del botón de inicio de sesión con Google
        googleButton.setOnClickListener(v -> lanzarActividad());
        googleMapsButton.setOnClickListener(v -> lanzarFragmentdMaps());
    }


    private void lanzarActividad() {
        Intent intent = new Intent(MainActivity.this, BikeListActivity.class);
        startActivity(intent);
    }

    private void lanzarFragmentdMaps() {
        Intent intent = new Intent(MainActivity.this, BikesMap.class);
        startActivity(intent);
    }




}