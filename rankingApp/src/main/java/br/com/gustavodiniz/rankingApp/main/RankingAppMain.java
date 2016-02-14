package br.com.gustavodiniz.rankingApp.main;

import br.com.gustavodiniz.rankingApp.domain.Ranking;
import br.com.gustavodiniz.rankingApp.service.RankingService;

public class RankingAppMain {

	public static void main(String[] args){
		System.out.println("Iniciando processo de cálculo de ranking !");
		if(args.length == 0){
			System.out.println("Arquivo Incorreto, informe o caminho do arquivo !");
		}else{
			String path = "inputLogExemplo.log";
			RankingService rankingService = new RankingService();
			Ranking ranking = rankingService.exibeRanking(path);
			rankingService.exibePontuacao(ranking);
		}
	}
}
