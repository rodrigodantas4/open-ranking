package com.openleaderboard.apiv3.json;

public class Competition {
	private String countryId;

	private String countryName;

	private String profession;

	private String regionName;

	private String competitionType;

	private String competitionId;

	private String fittestIn;

	private String inSubCat;

	private String division;

	private String scaled;

	private String weight_group;

	private String regional;

	private String stateId;

	private String stateName;

	private String age_group;

	private String year;

	private String regionId;

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
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

	public String getCompetitionType() {
		return competitionType;
	}

	public void setCompetitionType(String competitionType) {
		this.competitionType = competitionType;
	}

	public String getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(String competitionId) {
		this.competitionId = competitionId;
	}

	public String getFittestIn() {
		return fittestIn;
	}

	public void setFittestIn(String fittestIn) {
		this.fittestIn = fittestIn;
	}

	public String getInSubCat() {
		return inSubCat;
	}

	public void setInSubCat(String inSubCat) {
		this.inSubCat = inSubCat;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getScaled() {
		return scaled;
	}

	public void setScaled(String scaled) {
		this.scaled = scaled;
	}

	public String getWeight_group() {
		return weight_group;
	}

	public void setWeight_group(String weight_group) {
		this.weight_group = weight_group;
	}

	public String getRegional() {
		return regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getAge_group() {
		return age_group;
	}

	public void setAge_group(String age_group) {
		this.age_group = age_group;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	@Override
	public String toString() {
		return "ClassPojo [countryId = " + countryId + ", countryName = "
				+ countryName + ", profession = " + profession
				+ ", regionName = " + regionName + ", competitionType = "
				+ competitionType + ", competitionId = " + competitionId
				+ ", fittestIn = " + fittestIn + ", inSubCat = " + inSubCat
				+ ", division = " + division + ", scaled = " + scaled
				+ ", weight_group = " + weight_group + ", regional = "
				+ regional + ", stateId = " + stateId + ", stateName = "
				+ stateName + ", age_group = " + age_group + ", year = " + year
				+ ", regionId = " + regionId + "]";
	}
}