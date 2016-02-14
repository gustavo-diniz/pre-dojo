package br.com.gustavodiniz.rankingApp.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.gustavodiniz.rankingApp.domain.GameLog;

public class GameServiceTest {

	@Test
	public void extraiDadosDeLogTest() throws Exception{
		
		GameService gameService = new GameService();
		List<GameLog> game = gameService.extraiDadosDeLog("inputLogExemplo.log");
		
		Assert.assertTrue(game.size()>0);
	}
	
	@Test
	public void extraiDadosDeLogComArquivoErradoTest() throws Exception{
		
		GameService gameService = new GameService();
		List<GameLog> game = gameService.extraiDadosDeLog("inputLogExemploError.log");
		
		Assert.assertTrue(game.size() == 0);
	}
}
