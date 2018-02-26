package com.openleaderboard.apiv3.json;

import com.crossfit.open.leaderboard.json.Athlete;

public class Entrant {
	private String lastName;

	private String weight;

	private String affiliateName;

	private String status;

	private String profilePicS3key;

	private String profession;

	private String regionName;

	private String countryShortCode;

	private String affiliateId;

	private String competitorId;

	private String teamCaptain;

	private String height;

	private String competitorName;

	private String divisionId;
	
	private String divisionDisplay;

	private String age;

	private String gender;

	private String firstName;

	private String bibId;

	private String regionalCode;

	private String regionId;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getAffiliateName() {
		return affiliateName;
	}

	public void setAffiliateName(String affiliateName) {
		this.affiliateName = affiliateName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProfilePicS3key() {
		return profilePicS3key;
	}

	public void setProfilePicS3key(String profilePicS3key) {
		this.profilePicS3key = profilePicS3key;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCountryShortCode() {
		return countryShortCode;
	}

	public void setCountryShortCode(String countryShortCode) {
		this.countryShortCode = countryShortCode;
	}

	public String getAffiliateId() {
		return affiliateId;
	}

	public void setAffiliateId(String affiliateId) {
		this.affiliateId = affiliateId;
	}

	public String getCompetitorId() {
		return competitorId;
	}

	public void setCompetitorId(String competitorId) {
		this.competitorId = competitorId;
	}

	public String getTeamCaptain() {
		return teamCaptain;
	}

	public void setTeamCaptain(String teamCaptain) {
		this.teamCaptain = teamCaptain;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getCompetitorName() {
		return competitorName;
	}

	public void setCompetitorName(String competitorName) {
		this.competitorName = competitorName;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getBibId() {
		return bibId;
	}

	public void setBibId(String bibId) {
		this.bibId = bibId;
	}

	public String getRegionalCode() {
		return regionalCode;
	}

	public void setRegionalCode(String regionalCode) {
		this.regionalCode = regionalCode;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	@Override
	public String toString() {
		return "ClassPojo [lastName = " + lastName + ", weight = " + weight
				+ ", affiliateName = " + affiliateName + ", status = " + status
				+ ", profilePicS3key = " + profilePicS3key + ", profession = "
				+ profession + ", regionName = " + regionName
				+ ", countryShortCode = " + countryShortCode
				+ ", affiliateId = " + affiliateId + ", competitorId = "
				+ competitorId + ", teamCaptain = " + teamCaptain
				+ ", height = " + height + ", competitorName = "
				+ competitorName + ", divisionId = " + divisionId + ", age = "
				+ age + ", gender = " + gender + ", firstName = " + firstName
				+ ", bibId = " + bibId + ", regionalCode = " + regionalCode
				+ ", regionId = " + regionId + "]";
	}

	public void setDivisionDisplay(String divisionDisplay) {
		this.divisionDisplay = divisionDisplay;
	}
	
	public String getDivisionDisplay(){
    	switch (this.divisionId) {
	    	case MAN:        return "Masculino";
	    	case MAN14_15  : return "Teen 14-15";
	    	case MAN16_17  : return "Teen 16-17";
	    	case MAN35_39  : return "Masters 35-39";
	    	case MAN40_44  : return "Masters 40-44";
	    	case MAN45_49  : return "Masters 45-49";
	    	case MAN50_54  : return "Masters 50-54";
	    	case MAN55_59  : return "Masters 55-59";
	    	case MAN60     : return "Masters 60";
	    	case WOMAN     : return "Feminino";
	    	case WOMAN14_15: return "Teen 14-15";
	    	case WOMAN16_17: return "Teen 16-17";
	    	case WOMAN35_39: return "Masters 35-39";
	    	case WOMAN40_44: return "Masters 40-44";
	    	case WOMAN45_49: return "Masters 45-49";
	    	case WOMAN50_54: return "Masters 50-54";
	    	case WOMAN55_59: return "Masters 55-59";
	    	case WOMAN60   : return "Masters 60";
	    	default 	   : return "???";
    	}
    }
    
	public static final String MAN        = "1";
	public static final String MAN14_15   = "14";
	public static final String MAN16_17   = "16";
	public static final String MAN35_39   = "18";
	public static final String MAN40_44   = "12";
	public static final String MAN45_49   = "3";
	public static final String MAN50_54   = "5";
	public static final String MAN55_59   = "7";
	public static final String MAN60      = "9";
	public static final String WOMAN      = "2";
	public static final String WOMAN14_15 = "15";
	public static final String WOMAN16_17 = "17";
	public static final String WOMAN35_39 = "19";
	public static final String WOMAN40_44 = "13";
	public static final String WOMAN45_49 = "4";
	public static final String WOMAN50_54 = "6";
	public static final String WOMAN55_59 = "8";
	public static final String WOMAN60    = "10";
}