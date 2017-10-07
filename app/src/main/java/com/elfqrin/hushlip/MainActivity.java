package com.elfqrin.hushlip;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements View.OnClickListener {

    private WebView browser;
    protected String urlHushlip = "http://www.hushlip.com/index.php?dv=appand";
    protected String urlFacebook = "https://www.facebook.com/hushlip";
    ImageButton home, facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = (WebView)findViewById(R.id.webview);
        browser.getSettings();
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setDomStorageEnabled(true);
        browser.loadUrl(urlHushlip);

        home = (ImageButton)findViewById(R.id.Hushlip_show);
        facebook = (ImageButton)findViewById(R.id.Facebook_show);

        home.setOnClickListener(this);
        facebook.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {

            case R.id.Hushlip_show:
                browser.getSettings().setLoadsImagesAutomatically(true);
                browser.getSettings().setJavaScriptEnabled(true);
                browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                browser.loadUrl(urlHushlip);
                break;
            case R.id.Facebook_show:
                // HTTPS not open directly on webview.
                // For test on real device uncomment this code, and comment the other.
                /*
                browser.getSettings().setLoadsImagesAutomatically(true);
                browser.getSettings().setJavaScriptEnabled(true);
                browser.getSettings().setDomStorageEnabled(true);
                browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                browser.loadUrl(urlFacebook);
                */
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(urlFacebook));
                startActivity(intent);
                break;
        }
    }



}


