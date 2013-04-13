package com.example.androidhive;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class InboxActivity extends ListActivity {

	String classes[]={"Scan_Barcode","Input_Image","Encode","History","Last_scanned"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(InboxActivity.this,android.R.layout.simple_list_item_1,classes));
        
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String selected = classes[position];
		Class ourClass;
		try {
			ourClass=Class.forName("com.example.barcodescanner."+selected);
			Intent intent=new Intent(InboxActivity.this,ourClass);
			startActivity(intent);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
				
	}

   
}
