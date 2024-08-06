package com.snt;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SnT extends Activity {
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sn_t);
        
        webview=(WebView)findViewById(R.id.webView1);
        webview.setWebViewClient(new MyWebViewClient());
        openURL();
    }

    private void openURL() {
		// TODO Auto-generated method stub
    	 webview.loadUrl("https://docs.google.com/forms/d/1_-MsPIhbClBjftkRR4dWwSFo6UYp_l27UQm8iX_3Df4/viewform");
         webview.requestFocus();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_sn_t, menu);
        return true;
    }
    
}
