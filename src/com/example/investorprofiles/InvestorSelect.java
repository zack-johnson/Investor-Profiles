/*
 * file: InvestorSelect.java
 * 
 * author: Zack Johnson <zackary.w.johnson@gmail.com>
 * 
 * purpose: This is the main activity that is shown when the app is launched.
 * 			This ListActivity grabs a list of records from the data source and
 * 			displays the names from the records obtained in the list.  When a 
 * 			list item is clicked, the corresponding investor information is 
 * 			sent to the Investor Profile Display activity to be viewed.
 */
package com.example.investorprofiles;

import java.util.List;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class InvestorSelect extends ListActivity {

	private static List<InvestorInfo> investorRecords;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	//Call the superclass constructor and set the Content View.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investor_select);
        
        //Create the data source object to pull investor information from.
        InvestorDataSource investorDataBase = new InvestorDataSource(
        		getApplicationContext());
        
        //Open the data source.
        investorDataBase.open();
        
        //Get all the investor records from the data source.
        investorRecords = investorDataBase.getRecords();
        
        //For each investor record, list their name as a new row in the list 
        //view.
        setListAdapter(new ArrayAdapter<InvestorInfo>(this, 
        		R.layout.simple_list_item_1, investorRecords));
        
        //Close the data source.
        investorDataBase.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.investor_select, menu);
        return true;
    }


    //When a list item is clicked, this activity will create an explicit intent
    //to start the Investor Profile Display activity and will send it the 
    //necessary information for the Display Activity to show correctly
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		//Get the investor information for the person who was clicked on.
		InvestorInfo iinfo = investorRecords.get(position);
		
		//Create an explicit intent to call the Investor Profile Display 
		//activity.
		Intent intent = new Intent(this, InvestorDetails.class);
		
		//Extract the information from the InvestorInfo object and send it as 
		//extra information with the intent.
		intent.putExtra("name", iinfo.getName());
		intent.putExtra("angelRank", iinfo.getAngelListSignalRank());
		intent.putExtra("age", iinfo.getAge());
		intent.putExtra("website", iinfo.getWebsite());
		intent.putExtra("netWorth", iinfo.getNetWorth());
		intent.putExtra("numInvestments", iinfo.getNumberOfInvestments());
		intent.putExtra("notableInvestments", iinfo.getNotableInvestments());
		intent.putExtra("accolades", iinfo.getAccolades());
		intent.putExtra("pos", position);
		
		//Start the Investor Profile Display activity.
		startActivity(intent);
		
	}
    
    
    
}
