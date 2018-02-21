package com.openleaderboard.apiv3.json;

import java.util.List;

public class Leaderboard {
	private String cacheKey;

	private String dataType;

	private String sort;

	private String query;

	private List<LeaderboardRows> leaderboardRows;

	private Ordinals[] ordinals;

	private Pagination pagination;

	private Competition competition;

	private String version;

	public String getCacheKey() {
		return cacheKey;
	}

	public void setCacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<LeaderboardRows> getLeaderboardRows() {
		return leaderboardRows;
	}

	public void setLeaderboardRows(List<LeaderboardRows> leaderboardRows) {
		this.leaderboardRows = leaderboardRows;
	}

	public Ordinals[] getOrdinals() {
		return ordinals;
	}

	public void setOrdinals(Ordinals[] ordinals) {
		this.ordinals = ordinals;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ClassPojo [cacheKey = " + cacheKey + ", dataType = " + dataType
				+ ", sort = " + sort + ", query = " + query
				+ ", leaderboardRows = " + leaderboardRows + ", ordinals = "
				+ ordinals + ", pagination = " + pagination
				+ ", competition = " + competition + ", version = " + version
				+ "]";
	}
}
