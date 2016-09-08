package com.av.benzandroid.models.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.av.benzandroid.R;
import com.av.benzandroid.functions.core.BaseActivity;

public class WriteMessageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_message);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        TextView txtTitle = (TextView) toolbar.findViewById(R.id.title);
        txtTitle.setText("Write Us a Message");
        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        final EditText mEditName = (EditText) findViewById(R.id.editname);
        final EditText mEditEmail = (EditText) findViewById(R.id.editemail);
        final EditText mEditSubject = (EditText) findViewById(R.id.editcompany);
        final EditText mEditMobile = (EditText) findViewById(R.id.editmobile);
        final EditText mEditMessage = (EditText) findViewById(R.id.editmessage);


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



        Button mButtonSubmit = (Button) findViewById(R.id.button_submit);
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mEditMobile.getText().length() != 0 && mEditEmail.getText().length() != 0){

                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND, Uri.fromParts(
                            "mailto","abc@gmail.com", null));

                    emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"info@benzrecovery.com.sg"});

                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, mEditSubject.getText().toString());

                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                            "Name: "+mEditName.getText().toString()+
                                    "  Email: "+mEditEmail.getText().toString()+
                                    "  Mobile: "+mEditMobile.getText().toString()+
                                    "  Debt Message: "+mEditMessage.getText().toString());

                    emailIntent.setType("message/rfc822");

                    startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));

                }



            }
        });



    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }

}
