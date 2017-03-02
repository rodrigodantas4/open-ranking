package com.crossfit.open.leaderboard.comparators;

import java.util.Comparator;

import com.crossfit.open.leaderboard.json.Athlete;

public class ComparatorWodOne implements Comparator<Athlete> {

	@Override
	public int compare(Athlete a1, Athlete a2) {
		String score1 = a1.scores.get(0).scoredisplay;
		String score2 = a2.scores.get(0).scoredisplay;
		
		if (score1.contains("--") && score2.contains("--")) {
			return 0;
		}
		
		if (score1.contains("--")){
			return 1;
		}
		
		if (score2.contains("--")){
			return -1;
		}
		
		if (score1.contains("- s")) {
			if (!score2.contains("- s")) {
				return 1;
			}
		} else {
			if (score2.contains("- s")) {
				return -1;
			}
		}
		
		
		if (score1.contains("reps")) {
			if (score2.contains("reps")) {
				if (score1.equals(score2)) { //check tiebrake time
					return a1.scores.get(0).scoredetails.time - a2.scores.get(0).scoredetails.time;
				}
				
				int s1 = Integer.parseInt(score1.replaceAll(" reps", "").replaceAll(" - s", ""));
				int s2 = Integer.parseInt(score2.replaceAll(" reps", "").replaceAll(" - s", ""));
				
				return -(s1 - s2); //number of reps
				
			} else {
				return 1; //time better than reps
			}
			
		} else { //score has time
			if (score2.contains("reps")) {
				return -1; //time better than reps
			} else {
				return score1.compareTo(score2); //compare time's
			}
		}
		
	};
	
}
