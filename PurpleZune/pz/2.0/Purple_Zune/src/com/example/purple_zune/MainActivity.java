
package com.example.purple_zune;

import android.app.Activity;

import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

import android.view.View.OnClickListener;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

import android.webkit.WebViewClient;

import android.widget.Button;
import android.widget.ProgressBar;

import android.widget.EditText;




public class MainActivity extends Activity {

    /** Called when the activity is first created. */

 

 EditText URLText;

 Button GoButton;

 WebView Browser;
 
 ProgressBar pb;

 

 private class MyWebViewClient extends WebViewClient {

     @Override

     public boolean shouldOverrideUrlLoading(WebView view, String url) {

         view.loadUrl(url);

         return true;

     }

 }

 

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

         

        URLText = (EditText)findViewById(R.id.URL);

        GoButton = (Button)findViewById(R.id.Go);

        Browser = (WebView) findViewById(R.id.WebEngine);
        
        pb = (ProgressBar) findViewById(R.id.progressBar1);
        pb.setVisibility(View.INVISIBLE);
        pb.setMax(100);

        Browser.getSettings().setJavaScriptEnabled(true);   
        Browser.getSettings().setSupportZoom(true);       //Zoom Control on web (You don't need this 
        //if ROM supports Multi-Touch      
        Browser.getSettings().setBuiltInZoomControls(true); //Enable Multitouch if supported by ROM
        final Activity activity=this; 
        Browser.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)   
            {

            activity.setProgress(progress);
            pb.setProgress(progress);
             // Return the app name after finish loading
                if(progress == 100)
                	pb.setVisibility(View.INVISIBLE);
              }
            });

// Load URL

        //Browser.loadUrl("http://www.google.co.in/");

        URLText.setOnKeyListener(new OnKeyListener(){

			@Override
			public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
				// TODO Auto-generated method stub
			    if(arg2.getAction() == KeyEvent.ACTION_DOWN)
			    {
			        switch(arg1)
			        {
			        case KeyEvent.KEYCODE_ENTER:
			            //ENTER WAS PRESSED!
			        	/*if(URLText.getText().toString().startsWith("http://"))
			        		 Browser.loadUrl(URLText.getText().toString());
			        	 else if(URLText.getText().toString().startsWith("https://"))
			        		 Browser.loadUrl(URLText.getText().toString());
			        	 else	 
			        		 Browser.loadUrl("http://"+URLText.getText().toString()); 	*/	        	
			            return true;
			        }
			    }

			    return false;

			}
        	
        });
        
         GoButton.setOnClickListener(new OnClickListener() {

 public void onClick(View v) {
	 

 Browser.setWebViewClient(new MyWebViewClient());
 pb.setVisibility(View.VISIBLE);
 if(URLText.getText().toString().startsWith("http://"))
	 Browser.loadUrl(URLText.getText().toString());
 else if(URLText.getText().toString().startsWith("https://"))
	 Browser.loadUrl(URLText.getText().toString());
 else	 
	 Browser.loadUrl("http://"+URLText.getText().toString()); 

 }

 });

    }

}




