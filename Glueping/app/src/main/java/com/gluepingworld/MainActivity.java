package com.gluepingworld;

import com.gluepingworld.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Build;

public class MainActivity extends Activity {

    private WebView mWebView;
    private ProgressBar mProgressBar;
    Button Back/*,Forward,Stop*/,Reload,Flip;
    final Context context = this;


    @SuppressLint("SetJavaScriptEnabled") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Back = (Button)findViewById(R.id.back);
       /* Forward = (Button)findViewById(R.id.forward);
        Stop = (Button)findViewById(R.id.stop);*/
        Reload = (Button)findViewById(R.id.button);

        mWebView = (WebView) findViewById(R.id.webView1);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
        mProgressBar.setVisibility(View.VISIBLE);

        Flip = (Button)findViewById(R.id.flip);

        mWebView.getSettings().setBuiltInZoomControls(false);
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                mProgressBar.setProgress(progress);
            }
        });

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                mWebView.setBackgroundColor(Color.TRANSPARENT);
                mWebView.loadUrl("file:///android_asset/www/offline.html");
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView webview, String url) {
                mProgressBar.setProgress(0);
                mProgressBar.setVisibility(View.VISIBLE);
                webview.loadUrl(url);
                mProgressBar.setIndeterminate(true);
                mProgressBar.getIndeterminateDrawable().setColorFilter(0xFFFF4081, android.graphics.PorterDuff.Mode.SRC_ATOP);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mWebView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
            }
        });
        mWebView.setBackgroundColor(Color.TRANSPARENT);
        mWebView.loadUrl("file:///android_asset/www/index.html");

        Back.setOnClickListener(new View.OnClickListener()

        {

            public void onClick(View v){
                if(mWebView.canGoBack())
                    mWebView.goBack();
            }
        });

      /*  Forward.setOnClickListener(new View.OnClickListener()

        {

            public void onClick(View v){
                if(mWebView.canGoForward())
                    mWebView.goForward();
            }
        }); */

        Reload.setOnClickListener(new View.OnClickListener()

        {

            public void onClick(View v){
                mWebView.reload();
            }
        });

        Flip.setOnClickListener(new View.OnClickListener()

        {

            public void onClick(View v){
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

      /*  Stop.setOnClickListener(new View.OnClickListener()

        {

            public void onClick(View v){
                mWebView.stopLoading();

            }
        }); */

    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mProgressBar.setProgress(0);
            mProgressBar.setVisibility(View.VISIBLE);
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}