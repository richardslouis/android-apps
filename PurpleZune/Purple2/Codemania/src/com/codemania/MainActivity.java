package com.codemania;

import com.codemania.MainActivity.MyWebViewClient;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	public class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
  }

	WebView webview;
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	      // TODO Auto-generated method stub
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_main);

	      webview=(WebView)findViewById(R.id.webView1);
	      webview.setWebViewClient(new MyWebViewClient());
	      openURL();
	  }

  private void openURL() {
	  webview.setInitialScale(1);
	  webview.getSettings().setJavaScriptEnabled(true);
	  webview.getSettings().setLoadWithOverviewMode(true);
	  webview.getSettings().setUseWideViewPort(true);
	  webview.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
	  webview.setScrollbarFadingEnabled(false);

      webview.loadUrl("http://m.codingcopypaste.com/site/mobile#0232");
  }	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}