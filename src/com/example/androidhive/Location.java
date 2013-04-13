package com.example.androidhive;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Location extends Activity
{

	EditText log,lat;
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		log=(EditText) findViewById(R.id.edit_long);
		lat=(EditText) findViewById(R.id.edit_lat);
		b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				 Bundle bundle = new Bundle();
			      bundle.putFloat("LAT", 40.829208f);
			      bundle.putFloat("LONG", -74.191279f);
			      encodeBarcode("LOCATION_TYPE", bundle);
				
			}
		});
		
	}	  
	  private void encodeBarcode(CharSequence type, CharSequence data)
	  {
		    IntentIntegrator integrator = new IntentIntegrator(this);
		    integrator.shareText(data, type);
	  }

	  private void encodeBarcode(CharSequence type, Bundle data) 
	  {
		    IntentIntegrator integrator = new IntentIntegrator(this);
		    integrator.addExtra("ENCODE_DATA", data);
		    integrator.shareText(data.toString(), type); // data.toString() isn't used
	  }
}
