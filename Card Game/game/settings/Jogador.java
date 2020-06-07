package game.settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import game.armaduras.Armaduras;
import game.armaduras.FactoryArmaduras;
import game.armas.Armas;
import game.armas.FactoryArmas;
import game.combatentes.Combatentes;
import game.combatentes.FactoryCombatentes;
import game.joias.FactoryJoias;
import game.joias.Joias;

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
		FactoryCombatentes fCombatente = new FactoryCombatentes();
		FactoryArmas fArmas = new FactoryArmas();
		FactoryArmaduras fArmaduras = new FactoryArmaduras();
		FactoryJoias fJoias = new FactoryJoias();
		List<Combatentes> deckCombatente = new ArrayList<Combatentes>();
		List<Armas> deckArmas = new ArrayList<Armas>();
		List<Armaduras> deckArmaduras = new ArrayList<Armaduras>();
		List<Joias> deckJoias = new ArrayList<Joias>();
		for(int i = 0; i < 5; i++) {
			Random sorteio = new Random(); 
			int numeroCombatente = sorteio.nextInt(30) + 1;
			Combatentes combatente = fCombatente.getCombatentes(numeroCombatente);
			deckCombatente.add(combatente);
		}
		for(int i = 0; i < 6; i++) {
			Random sorteio = new Random(); 
			int numeroArmas = sorteio.nextInt(20) + 1;
			Armas armas = fArmas.getArmas(numeroArmas);
			deckArmas.add(armas);
			Random sorteio2 = new Random(); 
			int numeroArmaduras = sorteio2.nextInt(20) + 1;
			Armaduras armaduras = fArmaduras.getArmaduras(numeroArmaduras);
			deckArmaduras.add(armaduras);
			Random sorteio3 = new Random(); 
			int numeroJoias = sorteio3.nextInt(9) + 1;
			Joias joias = fJoias.getJoias(numeroJoias);
			deckJoias.add(joias);
		}
		this.deck = new Deck(deckCombatente, deckArmas, deckArmaduras, deckJoias);
		System.out.println("");
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
