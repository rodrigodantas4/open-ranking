package com.openleaderboard.apiv3.comparators;

import java.util.Comparator;

import com.crossfit.open.leaderboard.json.Athlete;
import com.openleaderboard.apiv3.json.LeaderboardRows;

public abstract class LeaderboardRowComparator implements Comparator<LeaderboardRows> {

	protected boolean isZeroScore(String score) {
		if (score.contains("--") || score.equals("0")) {
			return true;
		}
		
		return false;
	}
	
	protected boolean isScaledScore(String score) {
		if (score.contains("- s")) {
			return true;
		}
		
		return false;
	}
	
	protected boolean isRXScore(String score) {
		if (!score.contains("- s")) {
			return true;
		}
		
		return false;
	}
	
	protected int compareZeroAndScaledScore(String score1, String score2) {
		if (isZeroScore(score1) && isZeroScore(score2)) {
			return 0;
		}
		
		if (isZeroScore(score1)) {
			return 1;
		}
		
		if (isZeroScore(score2)) {
			return -1;
		}
		
		if (isScaledScore(score1)) {
			if (isRXScore(score2)) {
				return 1;
			}
		} else {
			if (isScaledScore(score2)) {
				return -1;
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	protected boolean isScoreWithReps(String score) {
		return score.contains("reps");
	}

	protected int extractNumberOfReps(String score) {
		return Integer.parseInt(score.replaceAll(" reps", "").replaceAll(" - s", ""));
	}
	
	protected int compareReps(Athlete a1, Athlete a2, String score1, String score2, int wodIndex) {
		if (score1.equals(score2)) { //check tiebrake time
			return a1.scores.get(wodIndex).scoredetails.time - a2.scores.get(wodIndex).scoredetails.time;
		}
		
		int s1 = extractNumberOfReps(score1);
		int s2 = extractNumberOfReps(score2);
		
		return -(s1 - s2); //number of reps
	}
	
}
