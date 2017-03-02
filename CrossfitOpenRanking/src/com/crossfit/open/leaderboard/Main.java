package com.crossfit.open.leaderboard;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.crossfit.open.leaderboard.comparators.ComparatorWodOne;
import com.crossfit.open.leaderboard.json.Athlete;
import com.crossfit.open.leaderboard.json.Leaderboard;
import com.crossfit.open.leaderboard.json.Score;
import com.google.gson.Gson;

public class Main {

	public static final String ALL      = "0";
	public static final String MAN      = "1";
	public static final String MAN14_15 = "14";
	public static final String MAN16_17 = "16";
	public static final String MAN35_39 = "18";
	public static final String MAN40_44 = "12";
	public static final String MAN45_49 = "3";
	public static final String MAN50_54 = "5";
	public static final String MAN55_59 = "7";
	public static final String MAN60    = "9";
	public static final String WOMAN    = "2";
	public static final String WOMAN14_15 = "15";
	public static final String WOMAN16_17 = "17";
	public static final String WOMAN35_39 = "19";
	public static final String WOMAN40_44 = "13";
	public static final String WOMAN45_49 = "4";
	public static final String WOMAN50_54 = "6";
	public static final String WOMAN55_59 = "8";
	public static final String WOMAN60    = "10";
	
	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		List<Athlete> allAthletes = new ArrayList<Athlete>();
		List<String> allCategory = new ArrayList<String>();
		List<String> menCategory = new ArrayList<String>();
		List<String> womenCategory = new ArrayList<String>();
		menCategory.add(MAN);
		menCategory.add(MAN35_39);
		menCategory.add(MAN14_15);
		menCategory.add(MAN16_17);
		menCategory.add(MAN35_39);
		menCategory.add(MAN40_44);
		menCategory.add(MAN45_49);
		menCategory.add(MAN50_54);
		menCategory.add(MAN55_59);
		menCategory.add(MAN60);
		womenCategory.add(WOMAN);
		womenCategory.add(WOMAN14_15);
		womenCategory.add(WOMAN16_17);
		womenCategory.add(WOMAN35_39);
		womenCategory.add(WOMAN40_44);
		womenCategory.add(WOMAN45_49);
		womenCategory.add(WOMAN50_54);
		womenCategory.add(WOMAN55_59);
		womenCategory.add(WOMAN60   );
		allCategory.add(ALL);
		
		Map<String, String> affiliates = setUpAffiliates();
		
		String urlBase = "https://games.crossfit.com/competitions/api/v1/competitions/open/2017/leaderboards?affiliate=";
		
		for (String affiliateId : affiliates.keySet()) {
			int page = 1;
			String url = buildURL(urlBase, affiliateId, page);
//			System.out.println("Processando: " + url);

			Leaderboard leaderboard = gson.fromJson(IOUtils.toString(new URL(url), "UTF-8"), Leaderboard.class);
			allAthletes.addAll(leaderboard.athletes);
			
			for (page = 2; page <= leaderboard.totalpages; page++) {
				url = buildURL(urlBase, affiliateId, page);
//				System.out.println("Processando: " + url);
			
				leaderboard = gson.fromJson(IOUtils.toString(new URL(url), "UTF-8"), Leaderboard.class);
				allAthletes.addAll(leaderboard.athletes);
			}
		}
		
		fillAffiliatesName(allAthletes, affiliates);
		
		generateRanking(allAthletes, allCategory);
		generateRanking(allAthletes, menCategory);
		generateRanking(allAthletes, womenCategory);
	}

	private static void generateRanking(List<Athlete> allAthletes, List<String> rankType) {
		List<Athlete> athletesList;
		athletesList = new ArrayList<Athlete>(allAthletes);
		List<String> unaffiliateds = unaffiliated();
		
			if (rankType.get(0).equals(ALL)) {
				athletesList = new ArrayList<Athlete>(allAthletes);
				
			} else {
				athletesList = new ArrayList<Athlete>();
				
				for (Athlete a : allAthletes) {
					for(int i = 0; i < rankType.size() ; i++)
					{
						if (a.divisionid.equals(rankType.get(i))) {
							if(a.affiliate.equals("CROSSFIT CANGACO")){
								if(unaffiliateds.contains(a.name)){
									athletesList.add(a);
								}
							}
							else{
								athletesList.add(a);
							}
						}
					}
				}
			}
			
		
		recalculateWodScore(athletesList, 0);	
		
		System.out.println("----------------------------------------------------------");
		for (Athlete a : athletesList) {
			System.out.println(a);
		}
		
	}

	private static void fillAffiliatesName(List<Athlete> allAthletes,
			Map<String, String> affiliates) {
		for (Athlete a : allAthletes) {
			a.affiliate = affiliates.get(a.affiliateid);
		}
	}

	private static String buildURL(String urlBase, String affiliateId, int page) {
		return urlBase + affiliateId + "&page=" + page;
	}

	private static Map<String, String> setUpAffiliates() {
		Map<String, String> affiliates = new HashMap<String, String>();
		
		affiliates.put("14372", "CROSSFIT MONSTER FACTORY");
		affiliates.put("15671", "CROSSFIT JAMPA");
		affiliates.put("14187", "CROSSFIT BESSA");
		affiliates.put("10108", "CROSSFIT BRABO");
		affiliates.put("17794", "CROSSFIT MANAIRA");
		affiliates.put("17445", "BLACKBELT CROSSFIT");
		affiliates.put("9571" , "CROSSFIT CANGACO");
		return affiliates;
	}
	
	private static List<String> unaffiliated(){
		List<String> unaffiliated = new ArrayList<String>();
		
		unaffiliated.add("Aaron Damasceno");
		unaffiliated.add("Anderson Diniz");
		unaffiliated.add("Sales Wallace");
		unaffiliated.add("Daniel Costa");
		unaffiliated.add("Antonio Bezerra Neto");
		unaffiliated.add("Arnaud Duarte");
		unaffiliated.add("Amanda Guerra");
		unaffiliated.add("Marcos Silva");
		
		return unaffiliated;
	}

	private static void recalculateWodScore(List<Athlete> allAthletes, int wodIndex) {
		if (wodIndex == 0) {
			Collections.sort(allAthletes, new ComparatorWodOne());
		} //adicionar outros comparators a medida que os novos wods forem lan�ados
		
		for (int i = 0, rank = 1; i < allAthletes.size(); i++) {
			if (i == 0) {
				allAthletes.get(i).scores.get(wodIndex).workoutrank = Integer.toString(rank);
				
			} else {
				Score lastScore = allAthletes.get(i - 1).scores.get(wodIndex);
				
				if (!allAthletes.get(i).scores.get(wodIndex).equals(lastScore)) {
					rank += 1;
				}
				
				allAthletes.get(i).scores.get(wodIndex).workoutrank = Integer.toString(rank);
			}
		}
	}
	
	

	
	
}
