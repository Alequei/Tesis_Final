package com.pruebas.tesiss_app;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng MA1 = new LatLng( -12.075120, -77.078649);
        LatLng MA2 = new LatLng(-12.004856, -77.054402);
        LatLng MA3 = new LatLng(-12.053534, -77.032825);
        LatLng MA4 = new LatLng(-12.075602, -77.053002);
     mMap.addMarker(new MarkerOptions().position(MA1).title("Avenida Manuel Cipriano Dulanto 2039, Pueblo Libre 15084"));
        mMap.addMarker(new MarkerOptions().position(MA2).title("Trumalinas, Cercado de Lima 15311"));
        mMap.addMarker(new MarkerOptions().position(MA3).title("Av Inca Garcilaso de la Vega 1298, Cercado de Lima 15001"));
        mMap.addMarker(new MarkerOptions().position(MA4).title("Av. Húsares de Junin 184, Jesús María 15072"));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(MA1,10));
    }
}
