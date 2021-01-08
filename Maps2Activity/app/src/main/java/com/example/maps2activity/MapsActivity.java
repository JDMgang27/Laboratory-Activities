package com.example.maps2activity;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

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
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(16.069452, 120.758722))
                .radius(150)
                .strokeWidth(10)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0)));


        mMap.addCircle(new CircleOptions()
                .center(new LatLng(15.890104, 120.686434))
                .radius(10)
                .strokeWidth(10)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0)));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(15.970214, 120.577519))
                .radius(10)
                .strokeWidth(10)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0)));

        //  Mark Jason Marker and Move the Camera
        LatLng sannicolas = new LatLng(16.069452, 120.758722);
        mMap.addMarker(new MarkerOptions().position(sannicolas).title("Marker in Jason's House"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sannicolas));
        //   UCU Marker
        LatLng UCU = new LatLng(15.979605, 120.560573);
        mMap.addMarker(new MarkerOptions().position(UCU).title("Marker in UCU"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(UCU));

        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);



        mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(16.0688503,120.758985),
                        new LatLng(16.0669477,120.7604021),
                        new LatLng(16.0503225,120.7544021),
                        new LatLng(16.0309886,120.7450473),
                        new LatLng(16.0246397,120.7442992),
                        new LatLng(16.0146369,120.7374776),
                        new LatLng(16.008674,120.7343474),
                        new LatLng(16.0012737,120.7300581),
                        new LatLng(15.9905033,120.7171318),
                        new LatLng(15.9892039,120.7117613),
                        new LatLng(15.9892039,120.7117613),
                        new LatLng(15.9873556,120.7053629),
                        new LatLng(15.9827391,120.6955024),
                        new LatLng(15.9895061,120.6852679),
                        new LatLng(16.0045104,120.6823576),
                        new LatLng(16.0027649,120.6727183),
                        new LatLng(16.0027649,120.6727183),
                        new LatLng(15.979248, 120.622968),
                        new LatLng(15.975884, 120.570643),
                        new LatLng(15.979246, 120.571040),
                        new LatLng(15.978836, 120.565910),
                        new LatLng(15.981376, 120.560941),
                        new LatLng(15.979605, 120.560573))
                .width(10)
                .color(Color.BLUE));

        //  John Maverick Marker and Move the Camera
        LatLng balungao = new LatLng(15.890104, 120.686434);
        mMap.addMarker(new MarkerOptions().position(balungao).title("Marker in John Maverick's House"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(balungao));

        mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(15.890104, 120.686434 ),
                        new LatLng(15.896684, 120.680441),
                        new LatLng(15.897972, 120.673840),
                        new LatLng(15.895906, 120.667849),
                        new LatLng(15.894750, 120.654483),
                        new LatLng(15.895468, 120.651573),
                        new LatLng(15.895491, 120.650720),
                        new LatLng(15.896795, 120.645056),
                        new LatLng(15.892770, 120.632789),
                        new LatLng(15.897437, 120.626528),
                        new LatLng(15.897743, 120.625940),
                        new LatLng(15.897797, 120.622214),
                        new LatLng(15.894785, 120.615416),
                        new LatLng(15.886050, 120.602549),
                        new LatLng(15.885456, 120.597568),
                        new LatLng(15.906327, 120.585182),
                        new LatLng(15.929941, 120.580820),
                        new LatLng(15.943960, 120.580603),
                        new LatLng(15.975830, 120.570717),
                        new LatLng(15.979246, 120.571003),
                        new LatLng(15.978864, 120.565636),
                        new LatLng(15.981532, 120.560654),
                        new LatLng(15.979605, 120.560573))
                .width(10)
                .color(Color.BLUE));





        mMap.addCircle(new CircleOptions()
                .center(new LatLng(15.987206, 120.499045))
                .radius(10)
                .strokeWidth(10)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0)));

        LatLng urdaneta = new LatLng(15.970214, 120.577519);
        mMap.addMarker(new MarkerOptions().position(urdaneta).title("Marker in Daniel's House"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(urdaneta));

        mMap.addPolyline(new PolylineOptions()

                .add(new LatLng(15.970605, 120.577549),
                        new LatLng(15.970447, 120.573597),
                        new LatLng(15.969763, 120.571834),
                        new LatLng(15.975918, 120.570695),
                        new LatLng(15.979227, 120.571015),
                        new LatLng(15.978889, 120.565599),
                        new LatLng(15.981509, 120.560684),
                        new LatLng(15.979605, 120.560573))

                .width(10)
                .color(Color.BLUE));



    }


}