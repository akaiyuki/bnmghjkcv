package com.av.benzandroid.models.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

import com.av.benzandroid.R;
import com.av.benzandroid.functions.core.BaseActivity;

public class OnlinePaymentActivity extends BaseActivity {

    private WebView mWebView;
    private String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_payment);

        mWebView = (WebView) findViewById(R.id.default_webview);
        mWebView.getSettings().setJavaScriptEnabled(true);


        mUrl = "http://www.benzrecovery.com.sg/online-payment";
        mWebView.loadUrl(mUrl);
        this.finish();
    }
}
