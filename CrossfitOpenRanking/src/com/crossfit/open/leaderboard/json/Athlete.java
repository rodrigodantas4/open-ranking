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
    			+ "\t" + affiliate;
    }
    

	@Override
	public int compareTo(Athlete o) {
		return new Integer(this.overallrank).compareTo(new Integer(o.overallrank));
	}
}
