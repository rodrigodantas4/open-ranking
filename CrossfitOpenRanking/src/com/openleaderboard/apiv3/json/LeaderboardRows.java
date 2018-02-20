package com.openleaderboard.apiv3.json;

public class LeaderboardRows {
	private String overallScore;

	private Ui ui;

	private Entrant entrant;

	private String nextStage;

	private Scores[] scores;

	private String overallRank;

	public String getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(String overallScore) {
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

	public Scores[] getScores() {
		return scores;
	}

	public void setScores(Scores[] scores) {
		this.scores = scores;
	}

	public String getOverallRank() {
		return overallRank;
	}

	public void setOverallRank(String overallRank) {
		this.overallRank = overallRank;
	}

	@Override
	public String toString() {
		return "ClassPojo [overallScore = " + overallScore + ", ui = " + ui
				+ ", entrant = " + entrant + ", nextStage = " + nextStage
				+ ", scores = " + scores + ", overallRank = " + overallRank
				+ "]";
	}
}
