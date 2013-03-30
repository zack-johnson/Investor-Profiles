/*
 * file: InvestorDBHelper.java
 * 
 * author: Zack Johnson <zackary.w.johnson@gmail.com>
 * 
 * purpose: This class is in charge of setting up the database with initial
 * 			data in the investor table and has static attributes which
 * 			can be used as the central reference point for database and table
 * 			constants.
 * 
 * notes: This class should most likely be made into a Singleton.
 */
package com.example.investorprofiles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InvestorDBHelper extends SQLiteOpenHelper {
	
	//Constants defining table and column names for the investorData table.
	public static final String TABLE_NAME = "investorData";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME_INVESTOR = "investor";
	public static final String COLUMN_NAME_ANGEL_LIST_RANK = "angelListRank";
	public static final String COLUMN_NAME_AGE = "age";
	public static final String COLUMN_NAME_WEBSITE= "website";
	public static final String COLUMN_NAME_NET_WORTH = "netWorth";
	public static final String COLUMN_NAME_NUMBER_OF_INVESTEMENTS = "numInvestments";
	public static final String COLUMN_NAME_NOTABLE_INVESTMENTS = "notableInvestments";
	public static final String COLUMN_NAME_ACCOLADES = "accolades";
	
	//Constants defining the database name and the schema version.
	private static final String DATABASE_NAME = "investor.db";
	private static final int DATABASE_VERSION = 1;
	
	//Generate the insert statements for data that is to be in the database
	//immediately after database creation.
	private static final String[] insertStatements = generateInsertStatements();
	
	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_NAME + "(" + COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_NAME_INVESTOR + " text, "
			+ COLUMN_NAME_ANGEL_LIST_RANK + " integer, "
			+ COLUMN_NAME_AGE + " integer, "
			+ COLUMN_NAME_WEBSITE + " text, "
			+ COLUMN_NAME_NET_WORTH + " integer, "
			+ COLUMN_NAME_NUMBER_OF_INVESTEMENTS + " integer, "
			+ COLUMN_NAME_NOTABLE_INVESTMENTS + " text, "
			+ COLUMN_NAME_ACCOLADES + " text);";

	public InvestorDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//Create the database
		db.execSQL(DATABASE_CREATE);
		
		//Insert initial data into the database.
		for (int i = 0; i < insertStatements.length; i++) {
			db.execSQL(insertStatements[i]);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	private static String[] generateInsertStatements() {
		String[] investors = {
				"Dave McClure",
				"Brad Feld",
				"Reid Hoffman",
				"Fred Wilson",
				"Ron Conway",
				"Peter Thiel",
				"Marc Andreeson",
				"Chris Dixon",
				"Mitch Kapor",
				"Jason Calacanis",
				"Chris Sacca",
				"Steve Case",
				"Mark Cuban",
				"Paul Graham",
				"Hadi Partovi",
				"Mark Pincus"};
		
		int[] angelRanks = {-1,6,1,3,-1,-1,12,17,5,2,11,22,41,-1,-1,-1};
		
		int[] ages = {-1,-1,-1,-1,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,-1,-1};
		
		String[] websites = {"",
			"feld.com",
			"http://www.en.wikipedia.org/wiki/Reid",
			"",
			"",
			"",
			"",
			"cdixon.org",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
		};
		
		int[] netWorths = {-1,-1,1800000000,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};
		
		int[] investments = {254,25,80,10,22,-1,38,30,58,32,77,22,31,-1,29,1};
		
		String[] notables = {
			"Visually, Simpy Hired, Bit.ly, 500 Startups",
			"Zynga, TechStars",
			"LinkedIn, PayPal, Facebook, Zynga, Kongregate, Digg, Flickr" +
			"Groupon, Friendster, Last.fm",
			"Twitter, Zynga",
			"",
			"PayPal, FaceBook",
			"Twitter, Pinterest, Zynga, Facebook, foursquare, Digg, Skype",
			"Skype, Foursquare, Kickstarter, Invite Media, CardPool, Dropbox, Pinterest",
			"Dropcam, StumbleUpon, Bit.ly, Wikia, Real Networks",
			"Uber, Gowalla, Tweetup",
			"Facebook, Twitter, Kickstarter, Poll Everywhere",
			"Living Social, Ubermedia, AOL",
			"Slideshare, Nimble, Smash Technologies",
			"",
			"Zappos, Flixster, Dropbox, Break Media",
			"Grockit"
		};
		
		String[] accolades = {
			"",
			"",
			"2012 ranked third on the Forbes Midas List of the top tech investors. 2011 Ernst and Young U.S. Entrepreneur of the Year Award",
			"",
			"",
			"",
			"",
			"TechCrunch Angel of the Year 2012.  2010 Tech Angel Investor of the year",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
		};
		
		//Container for created queries
		String[] insertQueries = new String[16];
		
		for(int i = 0; i < insertQueries.length; i++) {
			//Build query from arrays created above
			insertQueries[i] = "insert into " + TABLE_NAME 
				+ "(" + COLUMN_NAME_INVESTOR
				+ "," + COLUMN_NAME_ANGEL_LIST_RANK
				+ "," + COLUMN_NAME_AGE 
				+ "," + COLUMN_NAME_WEBSITE 
				+ "," + COLUMN_NAME_NET_WORTH 
				+ "," + COLUMN_NAME_NUMBER_OF_INVESTEMENTS
				+ "," + COLUMN_NAME_NOTABLE_INVESTMENTS 
				+ "," + COLUMN_NAME_ACCOLADES
				+ ") values(\""	+ investors[i] + "\"," 
				+ angelRanks[i] + "," 
				+ ages[i] + ",\""	
				+ websites[i] + "\"," 
				+ netWorths[i] + "," 
				+ investments[i] + ",\"" 
				+ notables[i] + "\",\""
				+ accolades[i] + "\");";
		}
		
		return insertQueries;
	}

}
