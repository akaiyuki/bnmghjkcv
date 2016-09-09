package com.av.benzandroid.models.fragments;


import android.app.Dialog;
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
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.av.benzandroid.R;
import com.av.benzandroid.models.activity.WriteMessageActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesFragment extends Fragment {

    private ImageView mButtonFloating;


    public ServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services, container, false);

        mButtonFloating = (ImageView) view.findViewById(R.id.floatingicon);
        mButtonFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showDialogMessage();
                startActivity(new Intent(getActivity(), WriteMessageActivity.class));
            }
        });

        return view;
    }

    public void showDialogMessage(){

        final Dialog dialog = new Dialog(getActivity());
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

}
