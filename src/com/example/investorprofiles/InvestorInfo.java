/*
 * file: InvestorInfo.java
 * 
 * author: Zack Johnson <zackary.w.johnson@gmail.com
 * 
 * description:	This class will basically act as a key/value map for all the details
 *				for the investor.
 */

package com.example.investorprofiles;

public class InvestorInfo {
	private String name;
	private int angelListSignalRank;
	private int age;
	private String website;
	private int netWorth;
	private int numberOfInvestments;
	private String notableInvestments;
	private String accolades;
	
	public InvestorInfo() {
		//All values are set to either the empty string or -1.
		name = "";
		angelListSignalRank = -1;
		age = -1;
		website = "";
		netWorth = -1;
		numberOfInvestments = -1;
		notableInvestments = "";
		accolades = "";
	}

	//Getter and Setter Methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAngelListSignalRank() {
		return angelListSignalRank;
	}

	public void setAngelListSignalRank(int angelListSignalRank) {
		this.angelListSignalRank = angelListSignalRank;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(int netWorth) {
		this.netWorth = netWorth;
	}

	public int getNumberOfInvestments() {
		return numberOfInvestments;
	}

	public void setNumberOfInvestments(int numberOfInvestments) {
		this.numberOfInvestments = numberOfInvestments;
	}

	public String getNotableInvestments() {
		return notableInvestments;
	}

	public void setNotableInvestments(String notableInvestments) {
		this.notableInvestments = notableInvestments;
	}

	public String getAccolades() {
		return accolades;
	}

	public void setAccolades(String accolades) {
		this.accolades = accolades;
	}

	@Override
	public String toString() {
		return getName();
	}
	
}
