package com.glueping;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class GluePing extends Activity {
		private class MyWebViewClient extends WebViewClient {
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
		      setContentView(R.layout.activity_glue_ping);

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

	      webview.loadUrl("http://m.glueping.com/site/mobile#3010");
	  }	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_glue_ping, menu);
		return true;
	}

}