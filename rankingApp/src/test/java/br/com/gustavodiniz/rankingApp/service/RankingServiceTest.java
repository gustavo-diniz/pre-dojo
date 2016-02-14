package br.com.gustavodiniz.rankingApp.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.gustavodiniz.rankingApp.domain.GameLog;
import br.com.gustavodiniz.rankingApp.domain.Ranking;

public class RankingServiceTest {

	@Test
	public void exibeRankingTest(){
		RankingService rankingService = new RankingService();
		
		//neste arquivo de log de ranking, existem 5 players
		Ranking ranking = rankingService.exibeRanking("inputLogExemplo.log");
		
		Assert.assertTrue(ranking.getScorePlayers().size() == 5);
		
	}
	
	@Test
	public void adicionaJogadoresRankingTest(){
		RankingService rankingService = new RankingService();
		GameService gameService = new GameService();
		
		List<GameLog> lista = gameService.extraiDadosDeLog("inputLogExemplo.log");
		Ranking ranking = rankingService.adcionaJogadoresAoRanking(lista);
		
		Assert.assertTrue(ranking.getScorePlayers().size() == 5);
		
	}
	
}
