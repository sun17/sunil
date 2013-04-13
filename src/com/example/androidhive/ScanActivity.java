package com.example.androidhive;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ScanActivity extends Activity {

	 String barcode;
	 String typ;
	 EditText etBarcode;
	 EditText ettype;
	 Button bsave;
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scan_activity);
		etBarcode = (EditText) findViewById(R.id.edit_Barcode);
	    ettype = (EditText) findViewById(R.id.edit_type);
	    bsave=(Button)findViewById(R.id.bsave);
		
		
	}

	public void onClick(View view) 
	{
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
	}
	public void saveDatabase(View view)
	{
		
		addEntry();				
		
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) 
	{
		String dialog_string="save to database";
		String intValue_for_phone="";
		AlertDialog alertDialog;
		  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		  if (scanResult != null) 
		  {
		   		    
		    barcode = scanResult.getContents();
		    typ=scanResult.getFormatName();
		    		    		    
		    etBarcode.setText(barcode);
		    ettype.setText(typ); 
		    
		    addEntry();
		    
		   
		    
		    
		    
		   // bsave.setEnabled(true);
		    
		    
		    /*
		     *check output type  and handling events
		     */
		    /*
		    if(barcode.startsWith("http") || barcode.startsWith("www"))
		    {
		    	dialog_string = "open in browser";
		    	alertDialog = new AlertDialog.Builder(this).create();
	            alertDialog.setTitle("Result");
	            alertDialog.setMessage("data"+barcode);
	            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	                 public void onClick(DialogInterface dialog, int which) {
	                         return;
	                 }
	             });
	            alertDialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
	                 public void onClick(DialogInterface dialog, int which) {
	                         return;
	                 }
	             });
	            alertDialog.setButton3("More", new DialogInterface.OnClickListener() {
	                 public void onClick(DialogInterface dialog, int which) {
	                         return;
	                 }
	             });
	            alertDialog.show();
		    	
		    }
		    else if(barcode.startsWith("tel"))
		    {
				intValue_for_phone = barcode.replaceAll("[a-zA-Z]", "");
				
				alertDialog = new AlertDialog.Builder(this).create();
	            alertDialog.setTitle("Result");
	            alertDialog.setMessage("data"+barcode);
	            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	                 public void onClick(DialogInterface dialog, int which) {
	                         return;
	                 }
	             });
	            alertDialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
	                 public void onClick(DialogInterface dialog, int which) {
	                         return;
	                 }
	             });
	            alertDialog.setButton3("More", new DialogInterface.OnClickListener() {
	                 public void onClick(DialogInterface dialog, int which) {
	                         return;
	                 }
	             });
	            alertDialog.show();
		    }
		    else if(barcode.startsWith("sms"))
		    {
		    	alertDialog = new AlertDialog.Builder(this).create();
	            alertDialog.setTitle("Result");
	            alertDialog.setMessage("data"+barcode);
	            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	                 public void onClick(DialogInterface dialog, int which) {
	                         return;
	                 }
	             });
	            alertDialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
	                 public void onClick(DialogInterface dialog, int which) {
	                         return;
	                 }
	             });
	            alertDialog.setButton3("More", new DialogInterface.OnClickListener() {
	                 public void onClick(DialogInterface dialog, int which) {
	                         return;
	                 }
	             });
	            alertDialog.show();
		    	
		    	
		    }
		    else if(barcode.startsWith("MECARD") || barcode.startsWith("vCard"))
		    {
		    	alertDialog = new AlertDialog.Builder(this).create();
	            alertDialog.setTitle("Result");
	            alertDialog.setMessage("data"+barcode);
	            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	                 public void onClick(DialogInterface dialog, int which) {
	                         return;
	                 }
	             });
	            alertDialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
	                 public void onClick(DialogInterface dialog, int which) {
	                         return;
	                 }
	             });
	            alertDialog.setButton3("More", new DialogInterface.OnClickListener() {
	                 public void onClick(DialogInterface dialog, int which) {
	                         return;
	                 }
	             });
	            
	            alertDialog.show();
	            
	            */
		    	
		    }
		    
		    
		  }

	private void addEntry() 
	{
		 barcode = etBarcode.getText().toString();
		 typ = ettype.getText().toString();

		 boolean didItWork=true;
			try{
		    	HistoryManager entry = new HistoryManager(ScanActivity.this);
				entry.open();
				entry.createEntry(barcode,typ,"QRCode");
				entry.close();
		    }
		    catch (Exception e) {
				
		    	didItWork = false;
				String error = e.getMessage();
				Dialog d =new Dialog(this);
				d.setTitle(error);
				d.show();
		    	
			}finally{
				
				if(didItWork)
				{
					Toast.makeText(getBaseContext(), "entry saved in database", 20).show();
				}
				
			}
		
	}
		  
		}
	/*private final class CancelOnClickListener implements DialogInterface.OnClickListener 
	{
		public void onClick(DialogInterface dialog, int which) 
		{
			Toast.makeText(getApplicationContext(), "Activity will continue",
					Toast.LENGTH_LONG).show();
		}
	}

	private final class OkOnClickListener implements DialogInterface.OnClickListener 
	{
		public void onClick(DialogInterface dialog, int which) 
		{
		
		}
	}*/



