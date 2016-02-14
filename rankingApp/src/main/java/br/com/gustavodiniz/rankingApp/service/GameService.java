package br.com.gustavodiniz.rankingApp.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.gustavodiniz.rankingApp.domain.GameLog;

public class GameService {

	/**
	 * Método responsável por extrair os dados de do arquivo de log e inseri-las 
	 * no objeto GameLog
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public List<GameLog> extraiDadosDeLog(String path){
		List<GameLog> gameLogs = new ArrayList<GameLog>();
		String idPartida = "";
		
		BufferedReader buffRead;
		try {
			buffRead = new BufferedReader(new FileReader(path));
		
			String linha = "";
			while (true) {
				linha = buffRead.readLine();
				if (linha != null) {
					String[] log = linha.split(" ");
					if(log.length > 1){
						if(log[3].equalsIgnoreCase("New") && log[4].equalsIgnoreCase("match") ){
							// iniciar ranking de partida
							idPartida = log[5];
						}else if(log[3].equalsIgnoreCase("Match") ){
							// finalizar ranking de partida
							idPartida = "";
						}else{
							Timestamp dataLog = stringToData(log[0]+" "+log[1], "dd/MM/yyyy HH:mm:ss");
							if(dataLog != null){
								GameLog gamelog = new GameLog();
								gamelog.setIdPartida(idPartida);
								gamelog.setDataEvento(dataLog);
								gamelog.setJogadorVencedor(log[3]);
								gamelog.setJogadorPerdedor(log[5]);
								gamelog.setArma(log[7]);
								gameLogs.add(gamelog);
							}
						}
					}
				} else
					break;
				
			}
			buffRead.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não localizado !");
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo !");
		}
		
		return gameLogs;
	}
	
	private Timestamp stringToData(String pData, String mascara) {
		java.util.Date date = null;
		SimpleDateFormat formatador;

		try {
			formatador = new SimpleDateFormat(mascara);
			date = formatador.parse(pData);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return new Timestamp(date.getTime());
	}
	
}
