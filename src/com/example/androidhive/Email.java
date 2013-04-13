package com.example.androidhive;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Email extends Activity 
{

	EditText e_email;
	Button b_encode;
	String email= "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.email);
		
		e_email = (EditText)findViewById(R.id.edit_email);
		b_encode=(Button)findViewById(R.id.b_email);
		
	
		
		b_encode.setOnClickListener(new View.OnClickListener() 
		{
		
			@Override
			public void onClick(View v) 
			{
				email= e_email.getText().toString();
				
				Toast.makeText(getApplicationContext(),email,Toast.LENGTH_LONG).show();

				encodeBarcode("EMAIL_TYPE", email);
			}
		});
		
		
	}
	private void encodeBarcode(CharSequence type, CharSequence data) {
	    IntentIntegrator integrator = new IntentIntegrator(this);
	    integrator.shareText(data, type);
	  }

	  private void encodeBarcode(CharSequence type, Bundle data) {
	    IntentIntegrator integrator = new IntentIntegrator(this);
	    integrator.addExtra("ENCODE_DATA", data);
	    integrator.shareText(data.toString(), type); // data.toString() isn't used
	  }
	
}
