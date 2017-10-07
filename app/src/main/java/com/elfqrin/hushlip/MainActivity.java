package com.elfqrin.hushlip;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

public class MainActivity extends Activity implements View.OnClickListener {

    private WebView browser;
    protected String urlHushlip = "http://www.hushlip.com/index.php?dv=appand";
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = (WebView)findViewById(R.id.webview);
        browser.getSettings();
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setDomStorageEnabled(true);
        browser.setWebViewClient(new hushlipWebClient());
        browser.loadUrl(urlHushlip);

        home = (ImageButton)findViewById(R.id.Hushlip_show);

        home.setOnClickListener(this);
    }

    private class hushlipWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {

            case R.id.Hushlip_show:
                this.recreate();
        }
    }
}


