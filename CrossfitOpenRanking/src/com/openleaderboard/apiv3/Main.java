package com.openleaderboard.apiv3;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.openleaderboard.apiv3.json.Leaderboard;
import com.openleaderboard.apiv3.json.LeaderboardRows;

public class Main {

	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		List<LeaderboardRows> athletes = new ArrayList<LeaderboardRows>();
//		List<Athlete> allAthletes = new ArrayList<Athlete>();
				
		Map<String, String> affiliatesMap = loadAffiliates();
//		setUpRankingCategories();
		
		//"https://games.crossfit.com/competitions/api/v1/competitions/open/2018/leaderboards?affiliate=15671&division=2&&page=1"
		//Parameters - :affiliateId, :divisionId, :pageNumber
		String urlBase = "https://games.crossfit.com/competitions/api/v1/competitions/open/2018/leaderboards?affiliate=:affiliateId&division=:divisionId&page=:pageNumber";
		
		for (String affiliateId : affiliatesMap.keySet()) {
			for (DivisionType division : DivisionType.values()) {
				int page = 1;
				String url = buildURL(urlBase, affiliateId, division.id() , page);
				System.out.println("Processing: " + url);
				
				Leaderboard leaderboard = gson.fromJson(IOUtils.toString(new URL(url), "UTF-8"), Leaderboard.class);
				athletes.addAll(leaderboard.getLeaderboardRows());
				
//				allAthletes.addAll(leaderboard.athletes);
				
//			for (page = 2; page <= leaderboard.totalpages; page++) {
//				String url = buildURL(urlBase, affiliateId, divisionId , page);
////				System.out.println("Processando: " + url);
//			
//				leaderboard = gson.fromJson(IOUtils.toString(new URL(url), "UTF-8"), Leaderboard.class);
//				allAthletes.addAll(leaderboard.athletes);
//			}
				
			}
		}
		
//		List<String> athletesToNotRemove = setUpUnaffiliateds();
//		removeAthletesFromAffiliated(allAthletes, athletesToNotRemove, "CROSSFIT CANGACO");
		
		
		
//		generateRanking(allAthletes, allCategory);
//		generateRanking(allAthletes, menCategory);
//		generateRanking(allAthletes, womenCategory);
//		generateRanking(allAthletes, mastersMenCategory);
//		generateRanking(allAthletes, mastersWomenCategory);
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
