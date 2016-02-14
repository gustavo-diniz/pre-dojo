package br.com.gustavodiniz.rankingApp.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import br.com.gustavodiniz.rankingApp.domain.GameLog;
import br.com.gustavodiniz.rankingApp.domain.Jogador;
import br.com.gustavodiniz.rankingApp.domain.Ranking;
import br.com.gustavodiniz.rankingApp.domain.ScorePlayer;

public class RankingService {

	/**
	 * Método responsável por exibir o ranking do jogo
	 * de acordo com os dados do arquivo de log informado 
	 * @param arquivoLog
	 */
	public Ranking exibeRanking(String arquivoLog){
		Ranking ranking = new Ranking();
		try {
			GameService service = new GameService();
			List<GameLog> lista = service.extraiDadosDeLog(arquivoLog);
			ranking = adcionaJogadoresAoRanking(lista);
			calculaPontuacaoJogadores(lista, ranking);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ranking;
	}	
	
	/**
	 * Exibe os dados de ranking conforme calculo efetudo
	 * no objeto ranking
	 * @param ranking
	 */
	public void exibePontuacao(Ranking ranking) {
		for(ScorePlayer players : ranking.getScorePlayers()){
			if(!players.getJogador().getNomeJogador().equals("<WORLD>")){
				
				String armaMaisUtilizada = verificaArmaMaisUtilizadaDoJogador(players);
				
				System.out.println("Player: "+players.getJogador().getNomeJogador()+
								   " - Vitorias: "+players.getTotalVitorias()+
								   " - Derrotas: "+players.getTotalDerrotas()+
								   " - última arma / Arma mais utilizada: "+armaMaisUtilizada);
			}else{
				System.out.println("<WORLD> executou: "+players.getTotalVitorias()+" jogadores");
			}
		}
	}

	/**
	 * Verifica a arma mais utilizada do jogador durante o cálculo
	 * @param players
	 * @return
	 */
	private String verificaArmaMaisUtilizadaDoJogador(ScorePlayer players) {
		String armaMaisUtilizada = "";
		int maiorValor = (Collections.max(players.getJogador().getArmasUtilizadas().values()));
		for (Entry<String, Integer> entry : players.getJogador().getArmasUtilizadas().entrySet()) {
		    if (entry.getValue() == maiorValor) {
		    	armaMaisUtilizada = entry.getKey();
		    }
		}
		return armaMaisUtilizada;
	}

	/**
	 * Metodo responsavel por avaliar e calcular a pontuação dos jogares participantes
	 * @param lista
	 * @param ranking
	 */
	public Ranking calculaPontuacaoJogadores(List<GameLog> lista, Ranking ranking) {
		for(GameLog game : lista){
			efetuaCalculoDePontuacaoDosJogadores(ranking, game);
		}
		return ranking;
	}

	/**
	 * Efetua o calculo de total de vitorias e derrotas por jogador
	 * OBS: para o jopgador <WORLD> as vitorias são desconsideradas, e somente
	 * são avaliadas a pontuação de derrota para o jogador que perdeu para <WORLD>
	 * @param ranking
	 * @param game
	 */
	private void efetuaCalculoDePontuacaoDosJogadores(Ranking ranking, GameLog game) {
		for(ScorePlayer score : ranking.getScorePlayers()){
			if(score.getJogador().getNomeJogador().equals(game.getJogadorVencedor())){
				score.setTotalVitorias(score.getTotalVitorias()+1);
				adcionaQtdArmautilizada(game, score);
			}
			if(score.getJogador().getNomeJogador().equals(game.getJogadorPerdedor())){
				score.setTotalDerrotas(score.getTotalDerrotas()+1);
			}
		}
	}

	private void adcionaQtdArmautilizada(GameLog game, ScorePlayer score) {
		if(score.getJogador().getArmasUtilizadas().containsKey(game.getArma())){
			Integer qtdUtilizacao = score.getJogador().getArmasUtilizadas().get(game.getArma());
			score.getJogador().getArmasUtilizadas().put(game.getArma(), qtdUtilizacao+1);
		}else{
			score.getJogador().getArmasUtilizadas().put(game.getArma(), 1);
		}
	}

	/**
	 * Método responsável por inserir os jogadores que participam
	 * do jogo no ranking do jogo, neste momento, ainda não são
	 * avaliados as pontuações e demais dados de ranking.
	 * @param lista
	 * @return
	 */
	public Ranking adcionaJogadoresAoRanking(List<GameLog> lista) {
		Set<ScorePlayer> scorePlayers = new HashSet<ScorePlayer>();
		Ranking ranking = new Ranking();

		for(GameLog game : lista){
			ScorePlayer score = populaObjetoScorePlayer(game.getIdPartida(), game.getJogadorVencedor());
			scorePlayers.add(score);
			
			score = populaObjetoScorePlayer(game.getIdPartida(), game.getJogadorPerdedor());
			scorePlayers.add(score);
		}
		
		ranking.setScorePlayers(scorePlayers);
		
		return ranking;
	}

	/**
	 * Metodo responsável por popular novo objeto de ScorePlayer ao qual será usado
	 * no ranking.
	 * @param idPartida
	 * @param player
	 * @return
	 */
	private ScorePlayer populaObjetoScorePlayer(String idPartida, String player) {
		ScorePlayer score = new ScorePlayer();
		score.setIdPlayer(idPartida+"-"+player);
		score.setJogador(new Jogador(player));
		score.setTotalDerrotas(0);
		score.setTotalVitorias(0);
		return score;
	}
	
}
