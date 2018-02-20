package com.openleaderboard.apiv3;

public enum DivisionType {

	MAN        ("1"  , "Masculino"),
	MAN14_15   ("14" , "Teen 14-15"),
	MAN16_17   ("16" , "Teen 16-17"),
	MAN35_39   ("18" , "Masters 35-39"),
	MAN40_44   ("12" , "Masters 40-44"),
	MAN45_49   ("3"  , "Masters 45-49"),
	MAN50_54   ("5"  , "Masters 50-54"),
	MAN55_59   ("7"  , "Masters 55-59"),
	MAN60      ("9"  , "Masters 60"),
	WOMAN      ("2"  , "Feminino"),
	WOMAN14_15 ("15" , "Teen 14-15"),
	WOMAN16_17 ("17" , "Teen 16-17"),
	WOMAN35_39 ("19" , "Masters 35-39"),
	WOMAN40_44 ("13" , "Masters 40-44"),
	WOMAN45_49 ("4"  , "Masters 45-49"),
	WOMAN50_54 ("6"  , "Masters 50-54"),
	WOMAN55_59 ("8"  , "Masters 55-59"),
	WOMAN60    ("10" , "Masters 60");

	private final String id;
    private final String description;
    
    private DivisionType(String id, String description) {
		this.id = id;
		this.description = description;
	}

	public String id() {
		return id;
	}

	public String description() {
		return description;
	}
    
}
