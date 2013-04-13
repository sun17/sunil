package com.example.androidhive;

import java.util.ArrayList;


import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class DatabaseView extends Activity
{
	
	SQLiteDatabase db;
	TextView txtMsg;
	ArrayList <String>results = new ArrayList<String>();
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.sqlview); 
       
       TextView tv = (TextView)findViewById(R.id.info);
       
       insertvalues();
       HistoryManager list = new HistoryManager(getApplicationContext());       
       list.open();       
       String info= list.getData();       
       list.close();
       tv.setText(info);

     
     /*  try
       {
    	   insertvalues();
    	   showlist();

       }
       catch(Exception e)
       {
    	   Toast.makeText(getBaseContext(), "db error"+e, 20).show();
       }*/
   }
           
   private void showlist() 
   {

	   	ArrayList results= new ArrayList();
	   	HistoryManager show = new HistoryManager(DatabaseView.this);
		show.open();
		results = show.getDatabaseContent();
		
       // this.setListAdapter(new ArrayAdapter(this,
        //android.R.layout.simple_list_item_1, results));
        
        show.close();
          
   }
   
   private void insertvalues()
   {
	   	HistoryManager entry = new HistoryManager(DatabaseView.this);
		entry.open();
		entry.createEntry("ffffffff","fffff","QRCode");
		entry.createEntry("ffffffff","fffff","QRCode");
		entry.createEntry("ffffffff","fffff","QRCode");
		entry.createEntry("ffffffff","fffff","QRCode");
		entry.createEntry("ffffffff","fffff","QRCode");
		entry.createEntry("ffffffff","fffff","QRCode");
		entry.createEntry("ffffffff","fffff","QRCode");
		entry.close(); 
	    
	}
           
           
}
