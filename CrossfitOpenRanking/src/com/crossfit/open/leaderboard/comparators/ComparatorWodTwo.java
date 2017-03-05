package com.crossfit.open.leaderboard.comparators;

import com.crossfit.open.leaderboard.json.Athlete;

public class ComparatorWodTwo extends ComparatorWod {

	private final static int WOD_INDEX = 1;
	
	@Override
	public int compare(Athlete a1, Athlete a2) {
		String score1 = a1.scores.get(WOD_INDEX).scoredisplay;
		String score2 = a2.scores.get(WOD_INDEX).scoredisplay;
		
		int initialComparison = compareZeroAndScaledScore(score1, score2);
		
		if (initialComparison >= -1 && initialComparison <= 1) {
			return initialComparison;
		}
		
		return compareReps(a1, a2, score1, score2, WOD_INDEX);
	}
	
}
