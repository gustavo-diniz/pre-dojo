package br.com.gustavodiniz.rankingApp.domain;

import java.sql.Timestamp;

public class GameLog {

	private String idPartida; 
	private Timestamp dataEvento;
	private String jogadorVencedor;
	private String jogadorPerdedor;
	private String arma;

	public Timestamp getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Timestamp dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getJogadorVencedor() {
		return jogadorVencedor;
	}

	public void setJogadorVencedor(String jogadorVencedor) {
		this.jogadorVencedor = jogadorVencedor;
	}

	public String getJogadorPerdedor() {
		return jogadorPerdedor;
	}

	public void setJogadorPerdedor(String jogadorPerdedor) {
		this.jogadorPerdedor = jogadorPerdedor;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(String idPartida) {
		this.idPartida = idPartida;
	}
	
	

}
