package com.applabs;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Richiesoft extends Activity {
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
      setContentView(R.layout.activity_richiesoft);

      webview=(WebView)findViewById(R.id.webView1);
      webview.setWebViewClient(new MyWebViewClient());
      openURL();
  }

   /** Opens the URL in a browser */
  private void openURL() {
	  webview.setInitialScale(1);
	  webview.getSettings().setJavaScriptEnabled(true);
	  webview.getSettings().setLoadWithOverviewMode(true);
	  webview.getSettings().setUseWideViewPort(true);
	  webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
	  webview.setScrollbarFadingEnabled(false);

      webview.loadUrl("http://www.richiesoft.com");
  }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_richiesoft, menu);
		return true;
	}

}
