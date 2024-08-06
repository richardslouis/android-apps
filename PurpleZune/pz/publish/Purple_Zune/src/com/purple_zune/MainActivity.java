
package com.purple_zune;

import com.purple_zune.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;

import android.view.View.OnClickListener;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

import android.webkit.WebViewClient;

import android.widget.Button;
import android.widget.ProgressBar;

import android.widget.EditText;




public class MainActivity extends Activity implements Handler.Callback {

    /** Called when the activity is first created. */

 

 EditText URLText;

 Button GoButton,Back,Forward,Stop,Reload,Flip;

 WebView Browser;
 
 ProgressBar pb;
 final Context context = this;


 WebViewClient client=new WebViewClient(){ 
      public boolean shouldOverrideUrlLoading(WebView view, String url) { 
          handler.sendEmptyMessage(2);
          return false;
      } 
 };

      final Handler handler = new Handler(this);


	@Override
	public boolean handleMessage(Message msg) {
	    if (msg.what == 2){
	        handler.removeMessages(1);
	        return true;
	    }
	    if (msg.what == 1){
	        //Toast.makeText(this, "WebView clicked", Toast.LENGTH_SHORT).show();
	    	
	    	//URLText.setText(Browser.getUrl().toCharArray(), 0,Browser.getUrl().length()-1);
	    	
	        return true;
	    }
	    return false;
	}


    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

         

        URLText = (EditText)findViewById(R.id.URL);

        GoButton = (Button)findViewById(R.id.Go);
        Back = (Button)findViewById(R.id.back);
        Forward = (Button)findViewById(R.id.forward);
        Reload = (Button)findViewById(R.id.reload);
        Stop = (Button)findViewById(R.id.stop);
        Flip = (Button)findViewById(R.id.flip);
        Browser = (WebView) findViewById(R.id.WebEngine);
        Browser.setWebViewClient(client);
        pb = (ProgressBar) findViewById(R.id.progressBar1);
        pb.setVisibility(View.INVISIBLE);
        pb.setMax(100);
        final Handler handler1=handler;
        Browser.setOnTouchListener(new OnTouchListener (){

        	@Override
        	 public boolean onTouch(View v, MotionEvent event) {
        	     if (v.getId() == R.id.WebEngine && event.getAction() == MotionEvent.ACTION_DOWN){
        	         handler.sendEmptyMessageDelayed(/*CLICK_ON_WEBVIEW*/1, 1000);
        	     }
        	     return false;
        	 }
        	
        });



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
            if(pb.getVisibility()==View.INVISIBLE&&progress!=100){
            	pb.setVisibility(View.VISIBLE);
            }
             // Return the app name after finish loading
                if(progress == 100){
                	if(URLText.getText().toString()!=Browser.getUrl())
                		URLText.setText(Browser.getUrl().toCharArray(), 0,Browser.getUrl().length());
                	
                	pb.setVisibility(View.INVISIBLE);
                }
              }
            });

// Load URL

        //Browser.loadUrl("http://www.google.co.in/");

        URLText.setOnKeyListener(new OnKeyListener(){

			@Override
			public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
				// TODO Auto-generated method stub
			    if(arg2.getAction() == KeyEvent.ACTION_UP)
			    {
			        switch(arg1)
			        {
			        case KeyEvent.KEYCODE_ENTER:
			            //ENTER WAS PRESSED!
			        	
			        	if(URLText.getText().toString().startsWith("http://")){
			        		 Browser.loadUrl(URLText.getText().toString());
			        		 
			        	}
			        	 else if(URLText.getText().toString().startsWith("https://")){
			        		 Browser.loadUrl(URLText.getText().toString());
			        	 }
			        	 else{	 
			        		 Browser.loadUrl("http://"+URLText.getText().toString());
			        	 }
			        	URLText.setText(URLText.getText().toString());
			            return true;
			        }
			    }

			    return false;

			}
        	
        });
        
         GoButton.setOnClickListener(new OnClickListener()
         
         {

 public void onClick(View v) {
	 

// Browser.setWebViewClient(client);
 pb.setVisibility(View.VISIBLE);
 if(URLText.getText().toString().startsWith("http://"))
	 Browser.loadUrl(URLText.getText().toString());
 else if(URLText.getText().toString().startsWith("https://"))
	 Browser.loadUrl(URLText.getText().toString());
 else	 
	 Browser.loadUrl("http://"+URLText.getText().toString()); 

 }

 });
Back.setOnClickListener(new OnClickListener()
         
         {

 public void onClick(View v){
	 if(Browser.canGoBack())
		 Browser.goBack();
 }
         });

Forward.setOnClickListener(new OnClickListener()

{

public void onClick(View v){
	if(Browser.canGoForward())
		Browser.goForward();
}
});

Flip.setOnClickListener(new OnClickListener()

{

public void onClick(View v){
	Intent intent = new Intent(context, MainActivity2.class);
    startActivity(intent);
    finish();
}
});



Reload.setOnClickListener(new OnClickListener()

{

public void onClick(View v){

	 pb.setVisibility(View.VISIBLE);
	 if(URLText.getText().toString().startsWith("http://"))
		 Browser.loadUrl(URLText.getText().toString());
	 else if(URLText.getText().toString().startsWith("https://"))
		 Browser.loadUrl(URLText.getText().toString());
	 else	 
		 Browser.loadUrl("http://"+URLText.getText().toString()); 
}
});

Stop.setOnClickListener(new OnClickListener()

{

public void onClick(View v){
	Browser.stopLoading();

}
});

    }

}
