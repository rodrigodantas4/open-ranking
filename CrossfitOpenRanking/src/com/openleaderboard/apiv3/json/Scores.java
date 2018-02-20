package com.openleaderboard.apiv3.json;

public class Scores {
	private String score;

	private String ordinal;

	private String breakdown;

	private String scoreIdentifier;

	private String heat;

	private String lane;

	private String rank;

	private String affiliate;

	private String time;

	private String scaled;

	private String judge;

	private String scoreDisplay;

	private String mobileScoreDisplay;

	private String video;

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(String ordinal) {
		this.ordinal = ordinal;
	}

	public String getBreakdown() {
		return breakdown;
	}

	public void setBreakdown(String breakdown) {
		this.breakdown = breakdown;
	}

	public String getScoreIdentifier() {
		return scoreIdentifier;
	}

	public void setScoreIdentifier(String scoreIdentifier) {
		this.scoreIdentifier = scoreIdentifier;
	}

	public String getHeat() {
		return heat;
	}

	public void setHeat(String heat) {
		this.heat = heat;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(String affiliate) {
		this.affiliate = affiliate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getScaled() {
		return scaled;
	}

	public void setScaled(String scaled) {
		this.scaled = scaled;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String getScoreDisplay() {
		return scoreDisplay;
	}

	public void setScoreDisplay(String scoreDisplay) {
		this.scoreDisplay = scoreDisplay;
	}

	public String getMobileScoreDisplay() {
		return mobileScoreDisplay;
	}

	public void setMobileScoreDisplay(String mobileScoreDisplay) {
		this.mobileScoreDisplay = mobileScoreDisplay;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "ClassPojo [score = " + score + ", ordinal = " + ordinal
				+ ", breakdown = " + breakdown + ", scoreIdentifier = "
				+ scoreIdentifier + ", heat = " + heat + ", lane = " + lane
				+ ", rank = " + rank + ", affiliate = " + affiliate
				+ ", time = " + time + ", scaled = " + scaled + ", judge = "
				+ judge + ", scoreDisplay = " + scoreDisplay
				+ ", mobileScoreDisplay = " + mobileScoreDisplay + ", video = "
				+ video + "]";
	}
}