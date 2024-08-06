package com.applabs;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;


public class MainActivity extends Activity {	
	/** Called when the user touches the button */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void Registernow(View Registernow) 
    {
    	Intent i = new Intent(getApplicationContext(),Registernow.class);
        startActivity(i);

    }
        public void Labs(View Labs) 
        {
        	Intent o = new Intent(getApplicationContext(),Labs.class);
            startActivity(o);
    }
        public void Richiesoft(View Richiesoft) 
        {
        	Intent m = new Intent(getApplicationContext(),Richiesoft.class);
            startActivity(m);
        }
        public void Info(View Info) 
        {
        	Intent n = new Intent(getApplicationContext(),Info.class);
            startActivity(n);
        }
}
