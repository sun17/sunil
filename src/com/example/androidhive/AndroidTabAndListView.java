package com.example.androidhive;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class AndroidTabAndListView extends TabActivity {
	/*
	 *  TabSpec Names
	 */
	private static final String INBOX_SPEC = "Scan";
	private static final String PROFILE_SPEC = "Database";
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TabHost tabHost = getTabHost();
        
        /*
         *  Inbox Tab
         */
        TabSpec inboxSpec = tabHost.newTabSpec(INBOX_SPEC);
        inboxSpec.setIndicator(INBOX_SPEC, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent = new Intent(this, ScanActivity.class);
        inboxSpec.setContent(inboxIntent);
        
        
        /*
         *  database Tab
         */
        TabSpec profileSpec = tabHost.newTabSpec(PROFILE_SPEC);
        profileSpec.setIndicator(PROFILE_SPEC, getResources().getDrawable(R.drawable.icon_profile));
        Intent databaseIntent = new Intent(this, DatabaseViewCall.class);
        profileSpec.setContent(databaseIntent);
        
        /*
         *  Adding all TabSpec to TabHost
         */
        tabHost.addTab(inboxSpec); // Adding Inbox tab
        tabHost.addTab(profileSpec); // Adding Profile tab
    }
}