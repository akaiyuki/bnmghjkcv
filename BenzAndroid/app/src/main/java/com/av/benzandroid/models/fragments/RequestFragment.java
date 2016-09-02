package com.av.benzandroid.models.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.av.benzandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RequestFragment extends Fragment {

    private EditText mEditName;
    private EditText mEditEmail;
    private EditText mEditCompany;
    private EditText mEditMobile;
    private EditText mEditDebt;

    private Button mButtonSend;


    public RequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_request, container, false);


        mEditName = (EditText) view.findViewById(R.id.editname);
        mEditEmail = (EditText) view.findViewById(R.id.editemail);
        mEditCompany = (EditText) view.findViewById(R.id.editcompany);
        mEditMobile = (EditText) view.findViewById(R.id.editmobile);
        mEditDebt = (EditText) view.findViewById(R.id.editdebt);

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




        mButtonSend = (Button) view.findViewById(R.id.buttonsend);

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mEditName.getText().length() != 0 && mEditEmail.getText().length() != 0
                        && mEditDebt.getText().length() != 0){

                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND, Uri.fromParts(
                            "mailto","abc@gmail.com", null));

                    emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"info@benzrecovery.com.sg"});

                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Debt Recovery Submission Request");

                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                            "Name: "+mEditName.getText().toString()+
                                    "  Email: "+mEditEmail.getText().toString()+
                                    "  Mobile: "+mEditMobile.getText().toString()+
                                    "  Company: "+mEditCompany.getText().toString()+
                                    "  Debt amount: "+mEditDebt.getText().toString());

                    emailIntent.setType("message/rfc822");

                    startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));

                }




            }
        });


        return view;
    }

}
