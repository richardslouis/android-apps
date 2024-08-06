package com.applabs;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class Registernow extends Activity {
	private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
  }
  Button btnBack;
  WebView webview;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
      // TODO Auto-generated method stub
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_registernow);

      webview=(WebView)findViewById(R.id.webView);
      webview.setWebViewClient(new MyWebViewClient());
      openURL();
  }

   /** Opens the URL in a browser */
  private void openURL() {
      webview.loadUrl("https://docs.google.com/forms/d/1gEZPbLN-rZ1L8sDkP8gKmrQJ4etmPfknA7ZBgNWsl_Y/viewform");
      webview.requestFocus();
  }

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_registernow, menu);
		return true;
	}
	


}
