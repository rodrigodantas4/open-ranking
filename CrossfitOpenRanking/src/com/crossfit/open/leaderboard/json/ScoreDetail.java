package com.crossfit.open.leaderboard.json;

public class ScoreDetail {

	public int time;
	public String breakdown;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreDetail other = (ScoreDetail) obj;
		if (time != other.time)
			return false;
		return true;
	}

	
}
