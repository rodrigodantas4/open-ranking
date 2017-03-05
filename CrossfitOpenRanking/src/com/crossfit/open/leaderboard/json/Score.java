package com.crossfit.open.leaderboard.json;

public class Score {

	public String workoutrank;
	public String workoutresult;
	public String scoreidentifier;
	public String scoredisplay;
    public String video;
    public ScoreDetail scoredetails;

    @Override
    public String toString() {
    	return workoutrank + " (" + scoredisplay + ")";
    }
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (scoredetails == null) {
			if (other.scoredetails != null)
				return false;
		} else if (!scoredetails.equals(other.scoredetails))
			return false;
		if (scoredisplay == null) {
			if (other.scoredisplay != null)
				return false;
		} else if (!scoredisplay.equals(other.scoredisplay))
			return false;
		return true;
	}
	
    
}
