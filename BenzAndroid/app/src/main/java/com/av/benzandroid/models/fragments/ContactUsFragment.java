package com.av.benzandroid.models.fragments;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.av.benzandroid.R;
import com.av.benzandroid.functions.BSingleton;
import com.av.benzandroid.models.activity.MainActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends FragmentActivity implements OnMapReadyCallback {

    public static ContactUsFragment INSTANCE =null;
    private LatLng direction;
    private GoogleMap mMap;

    private ImageView mButtonFloating;

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
//        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(INSTANCE);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            View decorView = getActivity().getWindow().getDecorView();
//            // Hide the status bar.
//            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//        }
//
//
//        INSTANCE = this;
//        return view;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_contact_us);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        TextView txtTitle = (TextView) toolbar.findViewById(R.id.title);
        txtTitle.setText(BSingleton.getTextTitle());


        mButtonFloating = (ImageView) findViewById(R.id.floatingicon);
        mButtonFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogMessage();
            }
        });


        INSTANCE = this;


    }

    @Override
    public void onMapReady(GoogleMap map) {

        double latitude = 14.55828;
        double longitude = 121.0547;

        direction = new LatLng(latitude, longitude);

        mMap = map;



        final Marker marker = map.addMarker(new MarkerOptions()
                .title("")
                .position(new LatLng(latitude, longitude))
        );


        map.moveCamera(CameraUpdateFactory.newLatLng(direction));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude))
                .zoom(10)
                .build();

        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }



    public void showDialogMessage(){

        final Dialog dialog = new Dialog(ContactUsFragment.INSTANCE);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_pop_up);


//        Button mButtonSubmit = (Button) dialog.findViewById(R.id.button_submit);
//        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });



        dialog.show();


    }



}
