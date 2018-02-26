package com.openleaderboard.apiv3.comparators;

import com.openleaderboard.apiv3.json.LeaderboardRows;

public class ComparatorWodOne extends LeaderboardRowComparator {

	private final static int WOD_INDEX = 0;
	
//	@Override
//	public int compare(LeaderboardRows a1, LeaderboardRows a2) {
//		String score1 = a1.scores.get(WOD_INDEX).scoredisplay;
//		String score2 = a2.scores.get(WOD_INDEX).scoredisplay;
//		
//		int initialComparison = compareZeroAndScaledScore(score1, score2);
//		
//		if (initialComparison >= -1 && initialComparison <= 1) {
//			return initialComparison;
//		}
//		
//		if (isScoreWithReps(score1)) {
//			if (isScoreWithReps(score2)) {
//				return compareReps(a1, a2, score1, score2, WOD_INDEX);
//				
//			} else { //score with time
//				return 1; //time better than reps
//			}
//			
//		} else { //score has time
//			if (isScoreWithReps(score2)) {
//				return -1; //time better than reps
//			} else {
//				return score1.compareTo(score2); //compare time
//			}
//		}
//	}
	
	@Override
	public int compare(LeaderboardRows a1, LeaderboardRows a2) {
		Integer score1 = Integer.parseInt(a1.getScores().get(WOD_INDEX).getScore());
		Integer score2 = Integer.parseInt(a2.getScores().get(WOD_INDEX).getScore());
		
		return -score1.compareTo(score2);
//		String score1 = a1.scores.get(WOD_INDEX).scoredisplay;
//		String score2 = a2.scores.get(WOD_INDEX).scoredisplay;
		
//		int initialComparison = compareZeroAndScaledScore(score1, score2);
//		
//		if (initialComparison >= -1 && initialComparison <= 1) {
//			return initialComparison;
//		}
//		
//		if (isScoreWithReps(score1)) {
//			if (isScoreWithReps(score2)) {
//				return compareReps(a1, a2, score1, score2, WOD_INDEX);
//				
//			} else { //score with time
//				return 1; //time better than reps
//			}
//			
//		} else { //score has time
//			if (isScoreWithReps(score2)) {
//				return -1; //time better than reps
//			} else {
//				return score1.compareTo(score2); //compare time
//			}
//		}
	}
	
}
