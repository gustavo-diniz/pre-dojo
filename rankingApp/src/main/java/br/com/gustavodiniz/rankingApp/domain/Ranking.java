package br.com.gustavodiniz.rankingApp.domain;

import java.util.Set;

public class Ranking {

	private String idMatchLog;
	private Set<ScorePlayer> scorePlayers;

	public String getIdMatchLog() {
		return idMatchLog;
	}

	public void setIdMatchLog(String idMatchLog) {
		this.idMatchLog = idMatchLog;
	}

	public Set<ScorePlayer> getScorePlayers() {
		return scorePlayers;
	}

	public void setScorePlayers(Set<ScorePlayer> scorePlayers) {
		this.scorePlayers = scorePlayers;
	}

	

}
