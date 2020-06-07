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
		
		List<Combatentes> combatentes = new ArrayList<Combatentes>();
		for(int i = 1; i < 31; i++) {
			Combatentes combatente = fCombatente.getCombatentes(i);
			combatentes.add(combatente);
		}
		List<Armas> armas = new ArrayList<Armas>();
		List<Armaduras> armaduras = new ArrayList<Armaduras>();
		for (int i = 1; i < 21; i++) {
			Armas arma = fArmas.getArmas(i);
			armas.add(arma);
			Armaduras armadura = fArmaduras.getArmaduras(i);
			armaduras.add(armadura);			
		}
		List<Joias> joias = new ArrayList<Joias>();
		for (int i = 1; i < 10; i++) {
			Joias joia = fJoias.getJoias(i);
			joias.add(joia);
		}
		for(int i = 0; i < 5; i++) {
			Random sorteio = new Random(); 
			int numeroCombatente = sorteio.nextInt(combatentes.size());
			Combatentes combatente = combatentes.get(numeroCombatente);
			deckCombatente.add(combatente);
			combatentes.remove(numeroCombatente);
		}
		for(int i = 0; i < 6; i++) {
			// Sorteio deck de armas
			Random sorteioArma = new Random(); 
			int numeroArma = sorteioArma.nextInt(armas.size());
			Armas arma = armas.get(numeroArma);
			deckArmas.add(arma);
			armas.remove(numeroArma);
			// Sorteio deck de armaduras
			Random sorteioArmadura = new Random(); 
			int numeroArmadura = sorteioArmadura.nextInt(armaduras.size());
			Armaduras armadura = armaduras.get(numeroArmadura);
			deckArmaduras.add(armadura);
			armaduras.remove(numeroArmadura);
			// Sorteio deck de joias
			Random sorteioJoias = new Random(); 
			int numeroJoia = sorteioJoias.nextInt(joias.size());
			Joias joia = joias.get(numeroJoia);
			deckJoias.add(joia);
			joias.remove(numeroJoia);
		}
		this.deck = new Deck(deckCombatente, deckArmas, deckArmaduras, deckJoias);
	}
	public int cartasVivas(){
        int cartasVivas = 0;
        for(int i = 0; i < this.deck.getCartasSize(); i++){
            if(this.deck.getCards().get(i).vivo()){
            	cartasVivas++;
            }
        }
        // Retornando a quantidade de Cards vivas apenas
        return cartasVivas;
        
    }
}
