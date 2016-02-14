package br.com.gustavodiniz.rankingApp.domain;

import java.util.TreeMap;

public class Jogador {

	private String nomeJogador;
	private TreeMap<String, Integer> armasUtilizadas;
	
	public Jogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
		armasUtilizadas = new TreeMap<String, Integer>();
	}
	
	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public TreeMap<String, Integer> getArmasUtilizadas() {
		return armasUtilizadas;
	}

	public void setArmasUtilizadas(TreeMap<String, Integer> armasUtilizadas) {
		this.armasUtilizadas = armasUtilizadas;
	}
	
}
