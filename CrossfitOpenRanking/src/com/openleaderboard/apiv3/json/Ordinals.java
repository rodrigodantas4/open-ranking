package com.openleaderboard.apiv3.json;

public class Ordinals {
	private String columnName;

	private String ordinal;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(String ordinal) {
		this.ordinal = ordinal;
	}

	@Override
	public String toString() {
		return "ClassPojo [columnName = " + columnName + ", ordinal = "
				+ ordinal + "]";
	}
}
