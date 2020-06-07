package game.settings;

public class Game {

	public static void main(String[] args) {
		
		System.out.println("O jogo vai comecar!!!");
		// Cria e nomeia os dois jogadores
		Jogador jogador1 = new Jogador(1);
		Jogador jogador2 = new Jogador(2);
		
		// Jogadores montam seus decks
		jogador1.montarDeck();
		jogador2.montarDeck();	
			
		// Inicio da batalha
		//Batalha batalha = new Batalha(jogador1, jogador2);
		//batalha.batalhar();
	}
}
