package com.example.androidhive;
import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Contact extends Activity 
{

	EditText e_email;
	EditText e_name;
	EditText e_phone;
	EditText e_address;
	 Button b_contact_encode;
	String email= "",name="",phone="",address="";
	@Override
	
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.contactlay);
		
		e_name=(EditText)findViewById(R.id.edit_name);
		e_phone=(EditText)findViewById(R.id.edit_phone);
		e_address=(EditText)findViewById(R.id.edit_address);
		e_email = (EditText)findViewById(R.id.e_email);
		b_contact_encode=(Button)findViewById(R.id.b_email);
		
		b_contact_encode.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				
				Bundle bundle = new Bundle();
			      bundle.putString(ContactsContract.Intents.Insert.NAME, "Jenny");
			      bundle.putString(ContactsContract.Intents.Insert.PHONE, "8675309");
			      bundle.putString(ContactsContract.Intents.Insert.EMAIL, "jenny@the80s.com");
			      bundle.putString(ContactsContract.Intents.Insert.POSTAL, "123 Fake St. San Francisco, CA 94102");
			      encodeBarcode("CONTACT_TYPE", bundle);
				
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
