package com.example.androidhive;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DatabaseViewCall extends Activity 
{
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.database_button_call);
		
		b=(Button)findViewById(R.id.button_databaselist_call);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent intent = new Intent(getApplicationContext(), DatabaseView.class);
		
				startActivity(intent);
		        
				
			}
		});
		
	}
	

}
