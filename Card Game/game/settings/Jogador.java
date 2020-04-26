package game.settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import game.combatentes.Combatentes;
import game.combatentes.FactoryCombatentes;

public class Jogador {
	public String nome;
	public Deck deck;

	public Jogador(int numJogador) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Qual seu nome jogador " + numJogador + "?");
		String nomeJogador = input.nextLine();
		this.nome = nomeJogador;
	}

	public String retornarNome() {
		return this.nome;
	}

	public void montarDeck() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		FactoryCombatentes fabrica = new FactoryCombatentes();
		List<Combatentes> deckJogador = new ArrayList<Combatentes>();
		System.out.println("Vamos montar o seu deck " + this.nome + " ele deverá ter 3 cartas!");
		for(int i = 0; i < 3; i++) {
			System.out.println("Escolha uma das cartas abaixo, escolha de Nº: "+ (i+1));
			System.out.println("#1- Arqueiro" + "\n#2- Orc do Deserto" + "\n#3- Dragão de gelo" + "\n#4- Mago de Gelo"
					+ "\n#5- Dragão de Fogo" + "\n#6- Orc da Montanha" + "\n#7- Trol Gigante" + "\n#8- Mago Elétrico");
			int card = input.nextInt();
			Combatentes jogador = fabrica.getCombatentes(100, card);
			deckJogador.add(jogador);
			System.out.println("--------------------------------------------------------------------");
		}
		this.deck = new Deck(deckJogador);
	}
	public int cartasVivas(){
        int cartasVivas = 0;
        for(int i = 0; i < this.deck.getTamanhoDeck(); i++){
            if(this.deck.getCards().get(i).vivo()){
            	cartasVivas++;
            }
        }
        // Retornando a quantidade de Cards vivas apenas
        return cartasVivas;
        
    }
}
