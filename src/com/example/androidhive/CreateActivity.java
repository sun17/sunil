package com.example.androidhive;



import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CreateActivity extends ListActivity {

	String classes[]={"Email","Contact","URL","Location","PhoneNo","SMS"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(CreateActivity.this,android.R.layout.simple_list_item_1,classes));
        
    }
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
	
		super.onListItemClick(l, v, position, id);
		String selected = classes[position];
		
		
		Class ourClass;
		try
		{
			
			ourClass=Class.forName("com.example.androidhive."+selected);
			Intent intent=new Intent(CreateActivity.this,ourClass);
			startActivity(intent);
		} 
		catch (ClassNotFoundException e) 
		{
			Toast.makeText(getApplicationContext(), "Exceptions occured", Toast.LENGTH_LONG);
		}
		
		
	}

   
}
