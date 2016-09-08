package com.av.benzandroid.models.fragments;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.av.benzandroid.R;
import com.av.benzandroid.functions.BSingleton;
import com.av.benzandroid.functions.CustomScrollView;
import com.av.benzandroid.models.activity.MainActivity;
import com.av.benzandroid.models.activity.WriteMessageActivity;
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

    private TextView mTextContact;
    private TextView mTextEmail;

    public CustomScrollView scrollView;

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
        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        mButtonFloating = (ImageView) findViewById(R.id.floatingicon);
        mButtonFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showDialogMessage();

                startActivity(new Intent(ContactUsFragment.this, WriteMessageActivity.class));

            }
        });

        scrollView = (CustomScrollView) findViewById(R.id.scrollView);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                scrollView.setEnableScrolling(true);
                return false;
            }
        });


        mTextContact = (TextView) findViewById(R.id.txtcontact);
        mTextEmail = (TextView) findViewById(R.id.txtemail);

        mTextContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String callForwardString = "+6590024367";
                Intent intentCallForward = new Intent(Intent.ACTION_DIAL); // ACTION_CALL
                Uri uri2 = Uri.fromParts("tel", callForwardString, "#");
                intentCallForward.setData(uri2);
                startActivity(intentCallForward);
            }
        });

        mTextEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send = new Intent(Intent.ACTION_SENDTO);
                String uriText = "mailto:" + Uri.encode("info@benzrecovery.com.sg") +
                        "?subject=" + Uri.encode("Inquire");
                Uri uri = Uri.parse(uriText);

                send.setData(uri);
                startActivity(Intent.createChooser(send, "Send mail..."));
            }
        });

        INSTANCE = this;


    }

    @Override
    public void onMapReady(GoogleMap map) {

        double latitude = 1.2846288;
        double longitude = 103.8487802;

        direction = new LatLng(latitude, longitude);

        mMap = map;



        final Marker marker = map.addMarker(new MarkerOptions()
                .title("")
                .position(new LatLng(latitude, longitude))
        );


        map.moveCamera(CameraUpdateFactory.newLatLng(direction));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude))
                .zoom(16)
                .build();

        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }


//    public boolean onTouch(View view, MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            ((LoadModelRenderer) mRenderer).getObjectAt(event.getX(), event.getY());
//
//            DesignBoxActivity.INSTANCE.scrollView.setEnableScrolling(false);
//
//        }
//
//        return getActivity().onTouchEvent(event);
//    }



    public void showDialogMessage(){

        final Dialog dialog = new Dialog(ContactUsFragment.INSTANCE);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_pop_up);

        final EditText mEditName = (EditText) dialog.findViewById(R.id.editname);
        final EditText mEditEmail = (EditText) dialog.findViewById(R.id.editemail);
        final EditText mEditCompany = (EditText) dialog.findViewById(R.id.editcompany);
        final EditText mEditMobile = (EditText) dialog.findViewById(R.id.editmobile);
        final EditText mEditMessage = (EditText) dialog.findViewById(R.id.editmessage);


        mEditMobile.setText("+65 9002");
        Selection.setSelection(mEditMobile.getText(), mEditMobile.getText().length());
        mEditMobile.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().contains("+65 9002")){
                    mEditMobile.setText("+65 9002");
                    Selection.setSelection(mEditMobile.getText(), mEditMobile.getText().length());

                }

            }
        });



        Button mButtonSubmit = (Button) dialog.findViewById(R.id.button_submit);
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mEditName.getText().length() != 0 && mEditEmail.getText().length() != 0
                        && mEditMessage.getText().length() != 0){

                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND, Uri.fromParts(
                            "mailto","abc@gmail.com", null));

                    emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"info@benzrecovery.com.sg"});

                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Debt Recovery Write Message");

                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                            "Name: "+mEditName.getText().toString()+
                                    "  Email: "+mEditEmail.getText().toString()+
                                    "  Mobile: "+mEditMobile.getText().toString()+
                                    "  Company: "+mEditCompany.getText().toString()+
                                    "  Debt Message: "+mEditMessage.getText().toString());

                    emailIntent.setType("message/rfc822");

                    startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));

                }


                dialog.dismiss();

            }
        });



        dialog.show();


    }


    @Override
    public void onBackPressed() {

            super.onBackPressed();

    }



}
