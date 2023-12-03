package com.example.museum.Map;

import static android.content.ContentValues.TAG;
import static android.content.Context.LOCATION_SERVICE;
import static io.realm.Realm.getApplicationContext;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.museum.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import android.widget.Toast;

import java.util.Arrays;

public class MapsFragmentFullOption extends Fragment implements OnMapReadyCallback , GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {

    private GoogleMap mMap;
    private UiSettings mUiSettings;
    private double x_toado = 21.0278;
    private double y_toado = 105.8342;
    private static final int REQ_PERMISSION = 999;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_maps_full_option, container, false);


        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fulloption);
        mapFragment.getMapAsync(this);


        try {
            // Initialize the SDK
            Places.initializeWithNewPlacesApiEnabled(getApplicationContext(), "AIzaSyC-LVT9MJus_MMgSJ9xdDEc8lUYQu1-J-g");

            PlacesClient placesClient = Places.createClient(getApplicationContext());


            AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                    getChildFragmentManager().findFragmentById(R.id.autocomplete_fragment);
            autocompleteFragment.setHint("Tìm kiếm bảo tàng");
            autocompleteFragment.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

            autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG));

            autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
                @Override
                public void onPlaceSelected(@NonNull Place place) {
                    // TODO: Get info about the selected place.
                    Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());

                    mMap.clear();
                    LatLng test = new LatLng(place.getLatLng().latitude, place.getLatLng().longitude);
                    mMap.addMarker(new MarkerOptions()
                            .position(test)
                            .title("Vị trí của Bảo tàng"));
                    float zoomLevel = 15.0f; //This goes up to 21
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(test, zoomLevel));
                }


                @Override
                public void onError(@NonNull Status status) {
                    // TODO: Handle the error.
                    Log.i(TAG, "An error occurred: " + status);
                }
            });
        } catch (Exception e) {
            System.out.println("First catch");

        }


        return rootView;
    }


    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        set ui setting for map
        mUiSettings = mMap.getUiSettings();
        mUiSettings.setZoomControlsEnabled(true);
        mUiSettings.setCompassEnabled(true);

//        set button my location
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQ_PERMISSION);
            return;
        }
        mMap.setMyLocationEnabled(true);

//        di chuyển camera đến vị trí hiện tại
        fusedLocationProviderClient = new FusedLocationProviderClient(getApplicationContext());
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(final Location location) {
                if (location != null) {
                    x_toado = location.getLatitude();
                    y_toado = location.getLongitude();
                    LatLng latLng = new LatLng(x_toado, y_toado);
                    float zoomLevel = 15.0f; //This goes up to 21
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
                }
            }
        });






    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
    }


    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }


}


