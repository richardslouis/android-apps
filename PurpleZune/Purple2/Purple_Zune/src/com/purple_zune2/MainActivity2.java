package com.purple_zune2;

import com.purple_zune2.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity2 extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info2);
		Button browsebut=(Button)findViewById(R.id.browse);
		final Context context=this;
		browsebut.setOnClickListener(new OnClickListener()

		{

		public void onClick(View v){
			Intent intent = new Intent(context, MainActivity.class);
		    startActivity(intent);
		    finish();
		}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info2, menu);
		return true;
	}

}
