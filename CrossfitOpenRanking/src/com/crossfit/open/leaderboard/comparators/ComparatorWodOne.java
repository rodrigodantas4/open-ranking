package com.crossfit.open.leaderboard.comparators;

import com.crossfit.open.leaderboard.json.Athlete;

public class ComparatorWodOne extends ComparatorWod {

	private final static int WOD_INDEX = 0;
	
	@Override
	public int compare(Athlete a1, Athlete a2) {
		String score1 = a1.scores.get(WOD_INDEX).scoredisplay;
		String score2 = a2.scores.get(WOD_INDEX).scoredisplay;
		
		int initialComparison = compareZeroAndScaledScore(score1, score2);
		
		if (initialComparison >= -1 && initialComparison <= 1) {
			return initialComparison;
		}
		
		if (isScoreWithReps(score1)) {
			if (isScoreWithReps(score2)) {
				return compareReps(a1, a2, score1, score2, WOD_INDEX);
				
			} else { //score with time
				return 1; //time better than reps
			}
			
		} else { //score has time
			if (isScoreWithReps(score2)) {
				return -1; //time better than reps
			} else {
				return score1.compareTo(score2); //compare time
			}
		}
	}
	
}
