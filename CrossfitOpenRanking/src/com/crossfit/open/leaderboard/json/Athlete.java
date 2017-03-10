package com.crossfit.open.leaderboard.json;

import java.util.ArrayList;
import java.util.List;

public class Athlete implements Comparable<Athlete>{
	public String userid;
	public String name;
	public String regionid;
	public String affiliateid;
	public String divisionid;
	public int highlight;
	public int age;
	public String region;
	public String height;
	public String weight;
	public String profilepic;
	public String overallrank;
	public String overallscore;
	public String affiliate;
	public int division;
	public List<Score> scores = new ArrayList<Score>();

    public int getOverallScoreRecalculated() {
    	int overallScoreRecalculated = 0;
    	for (Score s : scores) {
			int wodScore = 0;
			
			if (!s.workoutrank.equals("--")) {
				wodScore = Integer.parseInt(s.workoutrank);
				
			}
			
    		overallScoreRecalculated += wodScore;
		}
    	
    	return overallScoreRecalculated;
    }

    @Override
    public String toString() {
    	return  overallrank
    			+ "\t" + name
    			+ "\t" + getOverallScoreRecalculated()
    			+ "\t" + scores.get(0).toString()
    			+ "\t" + scores.get(1).toString()
    			+ "\t" + scores.get(2).toString()
    			+ "\t" + scores.get(3).toString()
    			+ "\t" + scores.get(4).toString()
    			+ "\t" + getDivisionString(divisionid)
    			+ "\t" + affiliate;
    }
    
    public String getDivisionString(String divisionid){
		
    	switch (divisionid) {
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
    		
    	}
    	return divisionid;
    	
    }
    
	@Override
	public int compareTo(Athlete o) {
		return new Integer(this.getOverallScoreRecalculated()).compareTo(new Integer(o.getOverallScoreRecalculated()));
	}
	
	public static final String ALL        = "0";
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
