/*
 * file: InvestorDetails.java
 * 
 * author: Zack Johnson <zackary.w.johnson@gmail.com>
 * 
 * purpose: The InvestorDetails class is an Activity which displays the
 * 			profile information which another activity sends to it.
 * 			The Activity shows a picture of the investor corresponding
 * 			to the investor profile information passed to the Activity
 * 			as well as additional information given.
 * 
 * notes:   The layout needs to include a ScrollView wrapper so that the
 * 			activity's contents can be viewed correctly.
 */

package com.example.investorprofiles;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class InvestorDetails extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		//Call superclass constructor and set the ContentView.
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_investor_details);
		
		//Get the extra information from the Intent passed.
		Bundle extras = getIntent().getExtras();
		if(extras == null) {
			return;
		}
		
		//NEEDS IMPROVEMENT! Shouldn't have to rely on position number from
		//		another activity
		//
		//Get the position in the list of the main Activity in order to 
		//determine which picture should be shown.
		int pos = extras.getInt("pos");

		//NEEDS IMPROVEMENT!  Relying on list position from another activity
		//		to select which picture needs to be shown in this one.
		//
		//Grab the profile picture resource and display it in the Image View.
		Drawable profilePicture = selectProfilePicture(pos);
		ImageView imageView = (ImageView) findViewById(R.id.investorImage);
		imageView.setImageDrawable(profilePicture);
		
		//NEEDS IMPROVEMENT!  Shouldn't show fields which have 'N/A/ values
		//
		//Display the investors name in the large text field.
		TextView nameText = (TextView) findViewById(R.id.investorNameTextView);
		nameText.setText(extras.getString("name"));
		
		//Get and display angel rank
		int angelRank = extras.getInt("angelRank");
		if(-1 != angelRank) {
			TextView angelRankText = (TextView) findViewById(R.id.angelRankTextView);
			angelRankText.setText(Integer.valueOf(angelRank).toString());
		}
		
		//Get and display age.
		int age = extras.getInt("age");
		if(-1 != age) {
			TextView ageText = (TextView) findViewById(R.id.ageTextView);
			ageText.setText(Integer.valueOf(age).toString());
		}
		
		//Get and display website.
		String website = extras.getString("website");
		if(website.compareTo("") != 0) {
			TextView websiteText = (TextView) findViewById(R.id.websiteTextView);
			websiteText.setText(website);
		}
		
		//Get and display net worth.
		int netWorth = extras.getInt("netWorth");
		if(-1 != netWorth) {
			TextView netWorthText = (TextView) findViewById(R.id.netWorthTextView);
			netWorthText.setText(Integer.valueOf(netWorth).toString());
		}
		
		//Get and display number of investments.
		int numInvestments = extras.getInt("numInvestments");
		if(-1 != numInvestments) {
			TextView numInvestmentsText = (TextView) findViewById(R.id.numInvestmentsTextView);
			numInvestmentsText.setText(Integer.valueOf(numInvestments).toString());
		}
		
		//Get and display notable investments.
		String notableInvestments = extras.getString("notableInvestments");
		if(notableInvestments.compareTo("") != 0) {
			TextView notableInvestmentsText = (TextView) findViewById(R.id.notableInvestmentsTextView);
			notableInvestmentsText.setText(notableInvestments);
		}
		
		//Get and dislpay accolades.
		String accolades = extras.getString("accolades");
		if(accolades.compareTo("") != 0) {
			TextView accoladesText = (TextView) findViewById(R.id.accoladesTextView);
			accoladesText.setText(accolades);
		}
	}

	
	/*
	 * Purpose: Takes a position of a investor in a list defined elsewhere,
	 * 			and uses that number to determine which Drawable resource
	 * 			is to be returned.
	 * PRE: 	The possible returned values point to a valid resource.
	 * POST:	A Drawable resource is returned.
	 */
	private Drawable selectProfilePicture(int pos) {
		
		Resources res = getResources();
		Drawable d;		//The Drawable resource to be returned.
		
		switch(pos) {
		case 0:
			d = res.getDrawable(R.drawable.davemcclure);
			break;
		case 1:
			d = res.getDrawable(R.drawable.bradfeld);
			break;
		case 2:
			d = res.getDrawable(R.drawable.reidhoffman);
			break;
		case 3:
			d =  res.getDrawable(R.drawable.fredwilson);
			break;
		case 4:
			d =  res.getDrawable(R.drawable.ronconway);
			break;
		case 5:
			d = res.getDrawable(R.drawable.peterthiel);
			break;
		case 6:
			d = res.getDrawable(R.drawable.marcandreeson);
			break;
		case 7:
			d = res.getDrawable(R.drawable.chrisdixon);
			break;
		case 8:
			d = res.getDrawable(R.drawable.mitchkapor);
			break;
		case 9:
			d = res.getDrawable(R.drawable.jasoncalacanis);
			break;
		case 10:
			d =  res.getDrawable(R.drawable.chrissacca);
			break;
		case 11:
			d =  res.getDrawable(R.drawable.stevecase);
			break;
		case 12:
			d = res.getDrawable(R.drawable.marccuban);
			break;
		case 13:
			d = res.getDrawable(R.drawable.paulgraham);
			break;
		case 14:
			d = res.getDrawable(R.drawable.hadipartovi);
			break;
		case 15:
		default:
			d = res.getDrawable(R.drawable.markpincus);
			break;
		}
		return d;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.investor_details, menu);
		return true;
	}

}
