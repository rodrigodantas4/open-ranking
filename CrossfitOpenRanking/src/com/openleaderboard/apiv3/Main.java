package com.openleaderboard.apiv3;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.crossfit.open.leaderboard.comparators.ComparatorWod;
import com.crossfit.open.leaderboard.comparators.ComparatorWodFive;
import com.crossfit.open.leaderboard.comparators.ComparatorWodFour;
import com.crossfit.open.leaderboard.comparators.ComparatorWodOne;
import com.crossfit.open.leaderboard.comparators.ComparatorWodThree;
import com.crossfit.open.leaderboard.comparators.ComparatorWodTwo;
import com.crossfit.open.leaderboard.json.Athlete;
import com.crossfit.open.leaderboard.json.Score;
import com.google.gson.Gson;
import com.openleaderboard.apiv3.json.Leaderboard;
import com.openleaderboard.apiv3.json.LeaderboardRows;

public class Main {

	private static final int WOD_ONE_INDEX = 0;
	private static final int WOD_TWO_INDEX = 1;
	private static final int WOD_THREE_INDEX = 2;
	private static final int WOD_FOUR_INDEX = 3;
	private static final int WOD_FIVE_INDEX = 4;
	
	private static List<DivisionType> allCategory = new ArrayList<DivisionType>();
	private static List<DivisionType> menCategory = new ArrayList<DivisionType>();
	private static List<DivisionType> womenCategory = new ArrayList<DivisionType>();
	private static List<DivisionType> mastersMenCategory = new ArrayList<DivisionType>();
	private static List<DivisionType> mastersWomenCategory = new ArrayList<DivisionType>();
	
	
	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		List<LeaderboardRows> athletes = new ArrayList<LeaderboardRows>();
				
		Map<String, String> affiliatesMap = loadAffiliates();
		setUpRankingCategories();
		
		//"https://games.crossfit.com/competitions/api/v1/competitions/open/2018/leaderboards?affiliate=15671&division=2&&page=1"
		//Parameters - :affiliateId, :divisionId, :pageNumber
		String urlBase = "https://games.crossfit.com/competitions/api/v1/competitions/open/2018/leaderboards?affiliate=:affiliateId&division=:divisionId&page=:pageNumber";
		
		//load athletes from affiliates
		for (String affiliateId : affiliatesMap.keySet()) {
			for (DivisionType division : DivisionType.values()) {
				int page = 1;
				String url = buildURL(urlBase, affiliateId, division.id() , page);
				System.out.println("Processing: " + url);
				
				Leaderboard leaderboard = gson.fromJson(IOUtils.toString(new URL(url), "UTF-8"), Leaderboard.class);
				athletes.addAll(leaderboard.getLeaderboardRows());
				
				int totalPages = new Integer(leaderboard.getPagination().getTotalPages());
				
				for (page = 2; page <= totalPages; page++) {
					url = buildURL(urlBase, affiliateId, division.id() , page);
					System.out.println("Processing: " + url);
				
					leaderboard = gson.fromJson(IOUtils.toString(new URL(url), "UTF-8"), Leaderboard.class);
					athletes.addAll(leaderboard.getLeaderboardRows());
				}
			}
		}
		
		//TODO load athletes not affiliated (individual)
		//TODO is there api?
		
		
		generateRanking(athletes, menCategory);
//		generateRanking(allAthletes, womenCategory);
//		generateRanking(allAthletes, mastersMenCategory);
//		generateRanking(allAthletes, mastersWomenCategory);
	}

	private static void setUpRankingCategories() {
			menCategory.add(DivisionType.MAN);
			menCategory.add(DivisionType.MAN35_39);
			menCategory.add(DivisionType.MAN14_15);
			menCategory.add(DivisionType.MAN16_17);
			menCategory.add(DivisionType.MAN35_39);
			menCategory.add(DivisionType.MAN40_44);
			menCategory.add(DivisionType.MAN45_49);
			menCategory.add(DivisionType.MAN50_54);
			menCategory.add(DivisionType.MAN55_59);
			menCategory.add(DivisionType.MAN60);
			
			womenCategory.add(DivisionType.WOMAN);
			womenCategory.add(DivisionType.WOMAN14_15);
			womenCategory.add(DivisionType.WOMAN16_17);
			womenCategory.add(DivisionType.WOMAN35_39);
			womenCategory.add(DivisionType.WOMAN40_44);
			womenCategory.add(DivisionType.WOMAN45_49);
			womenCategory.add(DivisionType.WOMAN50_54);
			womenCategory.add(DivisionType.WOMAN55_59);
			womenCategory.add(DivisionType.WOMAN60   );

			mastersWomenCategory.add(DivisionType.WOMAN35_39);
			mastersWomenCategory.add(DivisionType.WOMAN40_44);
			mastersWomenCategory.add(DivisionType.WOMAN45_49);
			mastersWomenCategory.add(DivisionType.WOMAN50_54);
			mastersWomenCategory.add(DivisionType.WOMAN55_59);
			mastersWomenCategory.add(DivisionType.WOMAN60   );
			
			mastersMenCategory.add(DivisionType.MAN35_39);
			mastersMenCategory.add(DivisionType.MAN40_44);
			mastersMenCategory.add(DivisionType.MAN45_49);
			mastersMenCategory.add(DivisionType.MAN50_54);
			mastersMenCategory.add(DivisionType.MAN55_59);
			mastersMenCategory.add(DivisionType.MAN60);
			
	}
	
	private static void generateRanking(List<LeaderboardRows> athletes, List<DivisionType> category) {
		List<LeaderboardRows> athletesList;
		
		athletesList = new ArrayList<LeaderboardRows>();
		
		for (LeaderboardRows a : athletes) {
			if (category.contains(a.getEntrant().getDivisionId()) {
				athletesList.add(a);
			}
		}
		
		recalculateWodScore(athletesList, WOD_ONE_INDEX);
//		recalculateWodScore(athletesList, WOD_TWO_INDEX);
//		recalculateWodScore(athletesList, WOD_THREE_INDEX);
//		recalculateWodScore(athletesList, WOD_FOUR_INDEX);
//		recalculateWodScore(athletesList, WOD_FIVE_INDEX);
		
		recalculateOverallRanking(athletesList);
		
		printRanking(athletesList);
	}


	private static void recalculateWodScore(List<Athlete> allAthletes, int wodIndex) {
		ComparatorWod comparator;
		
		switch (wodIndex) {
			case WOD_ONE_INDEX:
				comparator = new ComparatorWodOne();
				break;
				
			case WOD_TWO_INDEX:
				comparator = new ComparatorWodTwo();
				break;
			
			case WOD_THREE_INDEX:
				comparator = new ComparatorWodThree();
				break;
				
			case WOD_FOUR_INDEX:
				comparator = new ComparatorWodFour();
				break;
				
			case WOD_FIVE_INDEX:
				comparator = new ComparatorWodFive();
				break;
				
			default:
				comparator = new ComparatorWodOne();
				break;
		}
		
		Collections.sort(allAthletes, comparator);
		
		for (int i = 0, rank = 1; i < allAthletes.size(); i++) {
			if (i == 0) {
				allAthletes.get(i).scores.get(wodIndex).workoutrank = Integer.toString(rank);
				
			} else {
				Score lastScore = allAthletes.get(i - 1).scores.get(wodIndex);
				
				if (!allAthletes.get(i).scores.get(wodIndex).equals(lastScore)) {
					rank = i+1;
				}
				
				allAthletes.get(i).scores.get(wodIndex).workoutrank = Integer.toString(rank);
			}
		}
	}

	private static void recalculateOverallRanking(List<Athlete> allAthletes) {
		Collections.sort(allAthletes);
		
		for (int i = 0, rank = 1; i < allAthletes.size(); i++) {
			if (i == 0) {
				allAthletes.get(i).overallrank = Integer.toString(rank);
				
			} else {
				int lastScore = allAthletes.get(i - 1).getOverallScoreRecalculated();
				
				if (allAthletes.get(i).getOverallScoreRecalculated() != lastScore) {
					rank = i + 1;
				}
				
				allAthletes.get(i).overallrank = Integer.toString(rank);
			}
		}
	}

	private static Map<String, String> loadAffiliates() {
		// TODO carregar lista de afiliadas a partir de um arquivo
		Map<String, String> affiliates = new HashMap<String, String>();
		
		affiliates.put("14372", "CrossFit Monster Factory");
		affiliates.put("15671", "CrossFit Jampa");
		affiliates.put("14187", "CrossFit Bessa");
		affiliates.put("10108", "CrossFit Brabo");
		affiliates.put("17794", "CrossFit Manaira");
		affiliates.put("17445", "Blackbelt CrossFit");
		affiliates.put("18771", "CrossFit Bancários");
		affiliates.put("19364", "BoxCon CrossFit Altiplano ");
		affiliates.put("19176", "CrossFit Beira Rio ");
		affiliates.put("20226", "Speed Iron CrossFit ");
		
		return affiliates;
	}

	private static String buildURL(String urlBase, String affiliateId, String divisionId, int page) {
		String url = urlBase.replace(":affiliateId", affiliateId)
							.replace(":divisionId", divisionId)
							.replace(":pageNumber", Integer.toString(page));
		
		return url;
	}
}
