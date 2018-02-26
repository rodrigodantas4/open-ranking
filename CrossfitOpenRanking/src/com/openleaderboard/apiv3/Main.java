package com.openleaderboard.apiv3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.openleaderboard.apiv3.comparators.ComparatorWodOne;
import com.openleaderboard.apiv3.comparators.LeaderboardRowComparator;
import com.openleaderboard.apiv3.json.Leaderboard;
import com.openleaderboard.apiv3.json.LeaderboardRows;
import com.openleaderboard.apiv3.json.Scores;

public class Main {

	private static final int WOD_ONE_INDEX = 0;
	private static final int WOD_TWO_INDEX = 1;
	private static final int WOD_THREE_INDEX = 2;
	private static final int WOD_FOUR_INDEX = 3;
	private static final int WOD_FIVE_INDEX = 4;
	
	private static List<String> menCategory = new ArrayList<String>();
	private static List<String> womenCategory = new ArrayList<String>();
	private static List<String> mastersMenCategory = new ArrayList<String>();
	private static List<String> mastersWomenCategory = new ArrayList<String>();
	private static List<String> teenMenCategory = new ArrayList<String>();
	private static List<String> teenWomenCategory = new ArrayList<String>();
	
	private static Gson gson = new Gson();
	
	public static void main(String[] args) throws Exception {
//		System.setProperty("https.proxyHost", "localhost");
//		System.setProperty("https.proxyPort", "5865");
		
		List<LeaderboardRows> athletes = new ArrayList<LeaderboardRows>();
				
		Map<String, String> affiliatesMap = loadAffiliates();
		setUpRankingCategories();
		
		//"https://games.crossfit.com/competitions/api/v1/competitions/open/2018/leaderboards?affiliate=15671&division=2&&page=1"
		//Parameters - :affiliateId, :divisionId, :pageNumber
		String urlBase = "https://games.crossfit.com/competitions/api/v1/competitions/open/2018/leaderboards?affiliate=:affiliateId&division=:divisionId&page=:pageNumber";
		
		//load athletes from affiliates
		for (String affiliateId : affiliatesMap.keySet()) {
//			for (DivisionType division : DivisionType.values()) {
			for (int division = 1; division <= 2; division++) {
				int page = 1;
				String url = buildURL(urlBase, affiliateId, Integer.toString(division) , page);
				System.out.println("Processing: " + url);
				
				Leaderboard leaderboard = gson.fromJson(IOUtils.toString(new URL(url), "UTF-8"), Leaderboard.class);
				
				if (leaderboard.getLeaderboardRows() != null) {
					athletes.addAll(leaderboard.getLeaderboardRows());

					int totalPages = new Integer(leaderboard.getPagination().getTotalPages());
					
					for (page = 2; page <= totalPages; page++) {
						url = buildURL(urlBase, affiliateId, Integer.toString(division), page);
						System.out.println("Processing: " + url);
						
						leaderboard = gson.fromJson(IOUtils.toString(new URL(url), "UTF-8"), Leaderboard.class);
						athletes.addAll(leaderboard.getLeaderboardRows());
					}
				}
			}
		}
		
		//TODO load athletes not affiliated (individual)
		//TODO is there api?
		
		
		fillDivisionDisplay(athletes);
		
		generateRanking(athletes, menCategory, "masc.json");
		generateRanking(athletes, womenCategory, "fem.json");
		generateRanking(athletes, mastersMenCategory, "master_masc.json");
		generateRanking(athletes, mastersWomenCategory, "master_fem.json");
		generateRanking(athletes, teenMenCategory, "teen_masc.json");
		generateRanking(athletes, teenWomenCategory, "teen_fem.json");		
	}

	private static void fillDivisionDisplay(List<LeaderboardRows> athletes) {
		for (LeaderboardRows a : athletes) {
			a.getEntrant().setDivisionDisplay(a.getEntrant().getDivisionDisplay());
		}
	}

	private static void setUpRankingCategories() {
			menCategory.add(DivisionType.MAN.id());
			menCategory.add(DivisionType.MAN35_39.id());
			menCategory.add(DivisionType.MAN14_15.id());
			menCategory.add(DivisionType.MAN16_17.id());
			menCategory.add(DivisionType.MAN35_39.id());
			menCategory.add(DivisionType.MAN40_44.id());
			menCategory.add(DivisionType.MAN45_49.id());
			menCategory.add(DivisionType.MAN50_54.id());
			menCategory.add(DivisionType.MAN55_59.id());
			menCategory.add(DivisionType.MAN60.id());
			
			womenCategory.add(DivisionType.WOMAN.id());
			womenCategory.add(DivisionType.WOMAN14_15.id());
			womenCategory.add(DivisionType.WOMAN16_17.id());
			womenCategory.add(DivisionType.WOMAN35_39.id());
			womenCategory.add(DivisionType.WOMAN40_44.id());
			womenCategory.add(DivisionType.WOMAN45_49.id());
			womenCategory.add(DivisionType.WOMAN50_54.id());
			womenCategory.add(DivisionType.WOMAN55_59.id());
			womenCategory.add(DivisionType.WOMAN60.id());

			mastersWomenCategory.add(DivisionType.WOMAN35_39.id());
			mastersWomenCategory.add(DivisionType.WOMAN40_44.id());
			mastersWomenCategory.add(DivisionType.WOMAN45_49.id());
			mastersWomenCategory.add(DivisionType.WOMAN50_54.id());
			mastersWomenCategory.add(DivisionType.WOMAN55_59.id());
			mastersWomenCategory.add(DivisionType.WOMAN60.id());
			
			mastersMenCategory.add(DivisionType.MAN35_39.id());
			mastersMenCategory.add(DivisionType.MAN40_44.id());
			mastersMenCategory.add(DivisionType.MAN45_49.id());
			mastersMenCategory.add(DivisionType.MAN50_54.id());
			mastersMenCategory.add(DivisionType.MAN55_59.id());
			mastersMenCategory.add(DivisionType.MAN60.id());
			
			
			teenMenCategory.add(DivisionType.MAN14_15.id());
			teenMenCategory.add(DivisionType.MAN16_17.id());
			
			teenWomenCategory.add(DivisionType.WOMAN14_15.id());
			teenWomenCategory.add(DivisionType.WOMAN16_17.id());
	}
	
	private static void generateRanking(List<LeaderboardRows> athletes, List<String> category, String filename) throws Exception {
		List<LeaderboardRows> athletesList;
		
		athletesList = new ArrayList<LeaderboardRows>();
		
		for (LeaderboardRows a : athletes) {
			if (category.contains(a.getEntrant().getDivisionId())) {
				athletesList.add(a);
			}
		}
		
		recalculateWodScore(athletesList, WOD_ONE_INDEX);
//		recalculateWodScore(athletesList, WOD_TWO_INDEX);
//		recalculateWodScore(athletesList, WOD_THREE_INDEX);
//		recalculateWodScore(athletesList, WOD_FOUR_INDEX);
//		recalculateWodScore(athletesList, WOD_FIVE_INDEX);
		
		recalculateOverallScore(athletesList);
		recalculateOverallRanking(athletesList);
		
		
		Leaderboard l = new Leaderboard();
		l.setLeaderboardRows(athletesList);
		
		BufferedWriter w = new BufferedWriter(new FileWriter(new File(filename)));
		
		w.write(gson.toJson(l, l.getClass()));
		w.close();
		
//		printRanking(athletesList);
	}
	
	private static void printRanking(List<LeaderboardRows> athletesList) {
		System.out.println("----------------------------------------------------------");
		System.out.println("Posição \tNome \tPontuação \t17.1 \t17.2 \t17.3 \t17.4 \t17.5 \tCategoria \tBox \tAtualizado em: " + new SimpleDateFormat("dd/MM/yy - HH:mm").format(Calendar.getInstance().getTime()));
		
		for (LeaderboardRows a : athletesList) {
			System.out.println(a);
		}
	}
	
	private static void recalculateWodScore(List<LeaderboardRows> allAthletes, int wodIndex) {
		LeaderboardRowComparator comparator;
		
		switch (wodIndex) {
			case WOD_ONE_INDEX:
				comparator = new ComparatorWodOne();
				break;
				
//			case WOD_TWO_INDEX:
//				comparator = new ComparatorWodTwo();
//				break;
//			
//			case WOD_THREE_INDEX:
//				comparator = new ComparatorWodThree();
//				break;
//				
//			case WOD_FOUR_INDEX:
//				comparator = new ComparatorWodFour();
//				break;
//				
//			case WOD_FIVE_INDEX:
//				comparator = new ComparatorWodFive();
//				break;
				
			default:
				comparator = new ComparatorWodOne();
				break;
		}
		
		Collections.sort(allAthletes, comparator);
		
		for (int i = 0, rank = 1; i < allAthletes.size(); i++) {
			if (i == 0) {
				allAthletes.get(i).getScores().get(wodIndex).setRank(Integer.toString(rank));
				
			} else {
				String lastScore = allAthletes.get(i - 1).getScores().get(wodIndex).getScore();
				
				if (!allAthletes.get(i).getScores().get(wodIndex).getScore().equals(lastScore)) {
					rank = i+1;
				}
				
				allAthletes.get(i).getScores().get(wodIndex).setRank(Integer.toString(rank));
			}
		}
	}

	private static void recalculateOverallScore(List<LeaderboardRows> allAthletes) {
		for (LeaderboardRows a : allAthletes) {
			int overallScoreRecalculated = 0;

			for (Scores s : a.getScores()) {
				int wodScore = Integer.parseInt(s.getRank());
				
				overallScoreRecalculated += wodScore;
			}
			
			a.setOverallScore(overallScoreRecalculated);
		}
	}
	
	private static void recalculateOverallRanking(List<LeaderboardRows> allAthletes) {
		Collections.sort(allAthletes);
		
		for (int i = 0, rank = 1; i < allAthletes.size(); i++) {
			if (i == 0) {
				allAthletes.get(i).setOverallRank(Integer.toString(rank));
				
			} else {
				int lastScore = allAthletes.get(i - 1).getOverallScore();
				
				if (allAthletes.get(i).getOverallScore() != lastScore) {
					rank = i + 1;
				}
				
				allAthletes.get(i).setOverallRank(Integer.toString(rank));
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
