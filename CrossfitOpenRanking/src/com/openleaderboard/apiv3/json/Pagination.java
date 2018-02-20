package com.openleaderboard.apiv3.json;

public class Pagination {
	private String totalCompetitors;

	private String currentPage;

	private String totalPages;

	public String getTotalCompetitors() {
		return totalCompetitors;
	}

	public void setTotalCompetitors(String totalCompetitors) {
		this.totalCompetitors = totalCompetitors;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return "ClassPojo [totalCompetitors = " + totalCompetitors
				+ ", currentPage = " + currentPage + ", totalPages = "
				+ totalPages + "]";
	}
}