package br.com.gustavodiniz.rankingApp.domain;

public class ScorePlayer {

	private String idPlayer;
	private Jogador jogador;
	private Integer totalVitorias;
	private Integer totalDerrotas;
	
	public String getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(String idPlayer) {
		this.idPlayer = idPlayer;
	}
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public Integer getTotalVitorias() {
		return totalVitorias;
	}
	public void setTotalVitorias(Integer totalVitorias) {
		this.totalVitorias = totalVitorias;
	}
	public Integer getTotalDerrotas() {
		return totalDerrotas;
	}
	public void setTotalDerrotas(Integer totalDerrotas) {
		this.totalDerrotas = totalDerrotas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPlayer == null) ? 0 : idPlayer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScorePlayer other = (ScorePlayer) obj;
		if (idPlayer == null) {
			if (other.idPlayer != null)
				return false;
		} else if (!idPlayer.equals(other.idPlayer))
			return false;
		return true;
	}

	
}
