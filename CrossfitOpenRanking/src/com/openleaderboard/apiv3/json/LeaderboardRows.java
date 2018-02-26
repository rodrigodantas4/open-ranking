package com.openleaderboard.apiv3.json;

import java.util.List;

public class LeaderboardRows implements Comparable<LeaderboardRows>{
	private int overallScore;

	private Ui ui;

	private Entrant entrant;

	private String nextStage;

	private List<Scores> scores;

	private String overallRank;

	public int getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(int overallScore) {
		this.overallScore = overallScore;
	}

	public Ui getUi() {
		return ui;
	}

	public void setUi(Ui ui) {
		this.ui = ui;
	}

	public Entrant getEntrant() {
		return entrant;
	}

	public void setEntrant(Entrant entrant) {
		this.entrant = entrant;
	}

	public String getNextStage() {
		return nextStage;
	}

	public void setNextStage(String nextStage) {
		this.nextStage = nextStage;
	}

	public List<Scores> getScores() {
		return scores;
	}

	public void setScores(List<Scores> scores) {
		this.scores = scores;
	}

	public String getOverallRank() {
		return overallRank;
	}

	public void setOverallRank(String overallRank) {
		this.overallRank = overallRank;
	}

//	@Override
//	public String toString() {
//		return "ClassPojo [overallScore = " + overallScore + ", ui = " + ui
//				+ ", entrant = " + entrant + ", nextStage = " + nextStage
//				+ ", scores = " + scores + ", overallRank = " + overallRank
//				+ "]";
//	}
	
	@Override
    public String toString() {
    	return  overallRank
    			+ "\t" + getEntrant().getCompetitorName()
    			+ "\t" + overallScore
    			+ "\t" + scores.get(0).getScoreDisplay()
    			+ "\t" + ""
    			+ "\t" + ""
    			+ "\t" + ""
    			+ "\t" + ""
    			+ "\t" + getEntrant().getDivisionDisplay()
    			+ "\t" + getEntrant().getAffiliateName();
    }

	@Override
	public int compareTo(LeaderboardRows o) {
		return new Integer(this.overallScore).compareTo(o.getOverallScore());
	}
	
}
