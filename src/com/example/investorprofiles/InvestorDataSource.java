/*
 * file: InvestorDataSource.java
 * 
 * author: Zack Johnson <zackary.w.johnson@gmail.com>
 * 
 * purpose: This class abstracts the database to just being a data source for 
 * 			the client program to consume.  The main functionality is that the
 * 			class will query the database for investor records and then 
 * 			translate those records into new InvestorInfo objects which the 
 * 			client class can query for info using it's getter methods.
 */
package com.example.investorprofiles;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

//Should make this class a Singleton
public class InvestorDataSource {
	
	private SQLiteDatabase database;
	private InvestorDBHelper dbHelper;
	private String[] allColumns = {InvestorDBHelper.COLUMN_ID,
			InvestorDBHelper.COLUMN_NAME_INVESTOR,
			InvestorDBHelper.COLUMN_NAME_ANGEL_LIST_RANK,
			InvestorDBHelper.COLUMN_NAME_AGE,
			InvestorDBHelper.COLUMN_NAME_WEBSITE,
			InvestorDBHelper.COLUMN_NAME_NET_WORTH,
			InvestorDBHelper.COLUMN_NAME_NUMBER_OF_INVESTEMENTS,
			InvestorDBHelper.COLUMN_NAME_NOTABLE_INVESTMENTS,
			InvestorDBHelper.COLUMN_NAME_ACCOLADES
			};
	
	public InvestorDataSource(Context context) {
		dbHelper = new InvestorDBHelper(context);
	}
	
	public void open() throws SQLException {
		database = dbHelper.getReadableDatabase();
	}
	
	public void close() {
		if(dbHelper != null) {
			dbHelper.close();
		}
		if(database != null) {
			database.close();
		}
	}

	public List<InvestorInfo> getRecords() {
		//Create a list of InvestorInfo entries that will be populated
		//and returned
		List<InvestorInfo> investorList = new ArrayList<InvestorInfo>();

		//Query the database for the whole investors table
		Cursor cursor = database.query(InvestorDBHelper.TABLE_NAME, allColumns, 
				null, null, null, null, null);
		
		//Move cursor to first record
		cursor.moveToFirst();
		
		//Create an object for each record in database and add the object to 
		//the investor list.
		while(!cursor.isAfterLast()) {
			//Create a new Investor Info Object
			InvestorInfo info = new InvestorInfo();
		
			//Get each column and set properties of the InvestorInfo object.
			info.setName(cursor.getString(1));
			info.setAngelListSignalRank(cursor.getInt(2));
			info.setAge(cursor.getInt(3));
			info.setWebsite(cursor.getString(4));
			info.setNetWorth(cursor.getInt(5));
			info.setNumberOfInvestments(cursor.getInt(6));
			info.setNotableInvestments(cursor.getString(7));
			info.setAccolades(cursor.getString(8));
			
			//Add the InvestorInfo object to the investorList.
			investorList.add(info);
			
			//Move cursor to next record.
			cursor.moveToNext();
			
		}

		//Close the cursor
		cursor.close();
		
		return investorList;
	}

}
