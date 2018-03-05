package com.openleaderboard.apiv3.comparators;

import com.openleaderboard.apiv3.json.LeaderboardRows;

public class WodComparatorByScore extends LeaderboardRowComparator {

	private int wodIndex;
	
	public WodComparatorByScore(int wodIndex) {
		this.wodIndex = wodIndex;
	}
	
	@Override
	public int compare(LeaderboardRows a1, LeaderboardRows a2) {
		Integer score1 = Integer.parseInt(a1.getScores().get(this.wodIndex).getScore());
		Integer score2 = Integer.parseInt(a2.getScores().get(this.wodIndex).getScore());
		
		return -score1.compareTo(score2);
	}
	
}
