package com.tiwari.satya.accenture.accenturenewjoinee;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    GPSTracker mGPS;
    double lat,lng;
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
        mGPS = new GPSTracker(MapsActivity.this);

        if (mGPS.canGetLocation) {
            lat = mGPS.getLatitude();
            lng = mGPS.getLongitude();
            {
                mMap = googleMap;

                // Add a marker in Sydney and move the camera
                LatLng HDC1=new LatLng(17.4446175,78.3808413);
                LatLng HDC2=new LatLng(17.4187473,78.3475858);
                LatLng HDC3=new LatLng(17.4214908,78.3751058);
                LatLng HDC4=new LatLng(17.4236113,78.3398104);
                LatLng hyd = new LatLng(lat, lng);
                mMap.addMarker(new MarkerOptions().position(HDC1).title("Accenture HDC1"));
                mMap.addMarker(new MarkerOptions().position(HDC2).title("Accenture HDC2"));
                mMap.addMarker(new MarkerOptions().position(HDC3).title("Accenture HDC3"));
                mMap.addMarker(new MarkerOptions().position(HDC4).title("Accenture HDC4"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(hyd));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hyd,
                        15));


                //mMap.moveCamera(CameraUpdateFactory.newLatLng(hyd));
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

                // Showing / hiding your current location
                mMap.setMyLocationEnabled(true);

                // Enable / Disable zooming controls
                mMap.getUiSettings().setZoomControlsEnabled(true);

                // Enable / Disable my location button
                mMap.getUiSettings().setMyLocationButtonEnabled(true);

                // Enable / Disable Compass icon
                mMap.getUiSettings().setCompassEnabled(true);

                // Enable / Disable Rotate gesture
                mMap.getUiSettings().setRotateGesturesEnabled(true);

                // Enable / Disable zooming functionality
                mMap.getUiSettings().setZoomGesturesEnabled(true);

                CameraPosition myPosition = new CameraPosition.Builder().target(hyd).zoom(15).bearing(90).tilt(0).build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(myPosition));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(20), 5000, null);
                mMap.addMarker(new MarkerOptions().position(hyd).title("My Positon!"));

            }
        }
    }}