package game.settings;

import java.util.Scanner;

import game.caracteristicas.FraquezasArmasArmaduras;
import game.caracteristicas.TipoJoias;
import game.caracteristicas.VantagensCombatentes;
import game.combatentes.Combatentes;

public class Batalha {
	Jogador jogador1;
	Jogador jogador2;

	public Batalha(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
	}
	
	VantagensCombatentes vantagensCombatentes = new VantagensCombatentes();
	FraquezasArmasArmaduras fraquezasArmasArmaduras = new FraquezasArmasArmaduras();

	public void batalhar() throws InterruptedException {
		Scanner input = new Scanner(System.in);
		int rounds = 1;
		while (jogador1.cartasVivas() > 0 && jogador2.cartasVivas() > 0) {
			System.out.println("Agora vamos decidir quem começará atacando no Round " + rounds);
			System.out.println("----------------------------------------------");
			System.out.println(this.jogador1.nome + " digite um número impar ou par");
			int escolha = input.nextInt();
			if (escolha % 2 == 1) {
				System.out.println(this.jogador1.nome + " você começará atacando!");
				System.out.println("----------------------------------------------");
			} else {
				System.out.println(this.jogador2.nome + " você começará atacando!");
				System.out.println("----------------------------------------------");
			}
			this.round(escolha, rounds);
			rounds++;
			jogador1.deck.tiraCardsMortas();
			jogador2.deck.tiraCardsMortas();
		}
		if(jogador1.deck.cards.size() > 0) {
			System.out.println(this.jogador1.nome + " você ganhou!!!");
		} else{
			System.out.println(this.jogador2.nome + " você ganhou!!!");
		}
		
	}
	public void round(int escolha, int rounds) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		System.out.println("O Round "+ rounds+ " vai começar !!!");
		System.out.println(this.jogador1.nome + " escolha uma carta para esse round:");
		for (int i = 0; i < this.jogador1.deck.getCartasSize(); i++) {
			System.out.println("#" + i + "- " + this.jogador1.deck.cards.get(i).nome);
		}
		int cardEscolhida1 = input.nextInt();
		System.out.println(this.jogador1.nome + " escolha uma arma para esse round:");
		for (int i = 0; i < this.jogador1.deck.getArmasSize(); i++) {
			System.out.println("#" + i + "- " + this.jogador1.deck.armas.get(i).nome);
		}
		int armaEscolhida1 = input.nextInt();
		System.out.println(this.jogador1.nome + " escolha uma armadura para esse round:");
		for (int i = 0; i < this.jogador1.deck.getArmadurasSize(); i++) {
			System.out.println("#" + i + "- " + this.jogador1.deck.armaduras.get(i).nome);
		}
		int armaduraEscolhida1 = input.nextInt();
		System.out.println(this.jogador1.nome + " escolha uma joia para esse round:");
		for (int i = 0; i < this.jogador1.deck.getJoiasSize(); i++) {
			System.out.println("#" + i + "- " + this.jogador1.deck.joias.get(i).nome);
		}
		int joiaEscolhida1 = input.nextInt();
		
		System.out.println(this.jogador2.nome + " escolha uma carta para esse round:");
		for (int i = 0; i < this.jogador2.deck.getCartasSize(); i++) {
			System.out.println("#" + i + "- " + this.jogador2.deck.cards.get(i).nome);
		}
		int cardEscolhida2 = input.nextInt();
		System.out.println(this.jogador2.nome + " escolha uma arma para esse round:");
		for (int i = 0; i < this.jogador2.deck.getArmasSize(); i++) {
			System.out.println("#" + i + "- " + this.jogador2.deck.armas.get(i).nome);
		}
		int armaEscolhida2 = input.nextInt();
		System.out.println(this.jogador2.nome + " escolha uma armadura para esse round:");
		for (int i = 0; i < this.jogador2.deck.getArmadurasSize(); i++) {
			System.out.println("#" + i + "- " + this.jogador2.deck.armaduras.get(i).nome);
		}
		int armaduraEscolhida2 = input.nextInt();
		System.out.println(this.jogador2.nome + " escolha uma joia para esse round:");
		for (int i = 0; i < this.jogador2.deck.getJoiasSize(); i++) {
			System.out.println("#" + i + "- " + this.jogador2.deck.joias.get(i).nome);
		}
		int joiaEscolhida2 = input.nextInt();
		

		Combatentes card1 = this.jogador1.deck.cards.get(cardEscolhida1);
		card1.arma = this.jogador1.deck.armas.get(armaEscolhida1);
		card1.armadura = this.jogador1.deck.armaduras.get(armaduraEscolhida1);
		card1.joia = this.jogador1.deck.joias.get(joiaEscolhida1);
		Combatentes card2 = this.jogador2.deck.cards.get(cardEscolhida2);
		card2.arma = this.jogador2.deck.armas.get(armaEscolhida2);
		card2.armadura = this.jogador2.deck.armaduras.get(armaduraEscolhida2);
		card2.joia = this.jogador2.deck.joias.get(joiaEscolhida2);
		
		
		
		this.luta(card1, card2, escolha);
		
	}

	@SuppressWarnings("unlikely-arg-type")
	public void luta(Combatentes carta1, Combatentes carta2, int escolha) throws InterruptedException {
		
		while (carta1.vivo() && carta2.vivo()) {
			if (escolha % 2 == 1) {
				// dano e defesa por vantagens combatentes
				double maisDano = vantagensCombatentes.vantagens(carta1.tipo);
				double danocausado = carta1.ataque() * maisDano;
				double menosDano = vantagensCombatentes.vantagens(carta2.tipo);
				int danoRecebido = (int) carta2.defesa(danocausado * menosDano);
				
				// armas, armaduras e joias
				int danoArma = carta1.arma.dano;
				maisDano = fraquezasArmasArmaduras.fraqueza(carta1.arma.tipo, carta2.armadura.tipo);
				danoArma *= maisDano;
				danoRecebido =  danoRecebido + danoArma;
				int defesaArmadura = carta2.armadura.defesa;
				menosDano = fraquezasArmasArmaduras.fraqueza(carta2.armadura.tipo, carta1.arma.tipo);
				defesaArmadura *= menosDano;
				danoRecebido -= defesaArmadura;
				
				int valorJoia = carta1.joia.valor;
				
				if(carta1.joia.equals(TipoJoias.ATAQUE)) {
					danoRecebido += valorJoia;
				} else if(carta1.joia.equals(TipoJoias.CURA)) {
					carta1.energia += valorJoia;
				}
				int valorJoia2 = carta2.joia.valor;
				if(carta2.joia.equals(TipoJoias.DEFESA)) {
					danoRecebido -= valorJoia2;
					defesaArmadura += valorJoia2;
				}
				if(danoRecebido < 0) {
					danoRecebido = 0;
				}
				carta2.energia -= danoRecebido;
				System.out.println(carta2.nome + " bloqueou: " + defesaArmadura);
				System.out.println(carta1.nome + " causou: " + danoRecebido);
				System.out.println(carta2.nome + " tem " + ((carta2.energia < 0) ? 0 : carta2.energia));
				Thread.sleep(2000);
				if (carta2.energia <= 0) {
					System.out.println(carta2.nome + " morreu.");
					this.jogador2.deck.armas.remove(carta2.arma);
					this.jogador2.deck.armaduras.remove(carta2.armadura);
					this.jogador2.deck.joias.remove(carta2.joia);
					System.out.println("----------------------------------------------");
					break;
				}
				// dano e defesa por vantagens combatentes
				double maisDano2 = vantagensCombatentes.vantagens(carta2.tipo);
				double danocausado2 = carta2.ataque() * maisDano2;
				double menosDano2 = vantagensCombatentes.vantagens(carta1.tipo);
				danoRecebido = (int) carta1.defesa(danocausado2 * menosDano2);
				
				// armas, armaduras e joias
				danoArma = carta2.arma.dano;
				maisDano = fraquezasArmasArmaduras.fraqueza(carta2.arma.tipo, carta1.armadura.tipo);
				danoArma *= maisDano;
				danoRecebido =  danoRecebido + danoArma;
				defesaArmadura = carta1.armadura.defesa;
				menosDano = fraquezasArmasArmaduras.fraqueza(carta1.armadura.tipo, carta2.arma.tipo);
				defesaArmadura *= menosDano;
				danoRecebido -= defesaArmadura;
				
				valorJoia = carta2.joia.valor;
				
				if(carta2.joia.equals(TipoJoias.ATAQUE)) {
					danoRecebido += valorJoia;
				} else if(carta2.joia.equals(TipoJoias.CURA)) {
					carta2.energia += valorJoia;
				}
				valorJoia2 = carta1.joia.valor;
				if(carta1.joia.equals(TipoJoias.DEFESA)) {
					danoRecebido -= valorJoia2;
					defesaArmadura += valorJoia2;
				}
				if(danoRecebido < 0) {
					danoRecebido = 0;
				}
				carta1.energia -= danoRecebido;
				System.out.println(carta1.nome + " bloqueou: " + defesaArmadura);
				System.out.println(carta2.nome + " causou: " + danoRecebido);
				System.out.println(carta1.nome + " tem " + ((carta1.energia < 0) ? 0 : carta1.energia));
				Thread.sleep(2000);
				if (carta1.energia <= 0) {
					System.out.println(carta1.nome + " morreu.");
					this.jogador1.deck.armas.remove(carta1.arma);
					this.jogador1.deck.armaduras.remove(carta1.armadura);
					this.jogador1.deck.joias.remove(carta1.joia);
					System.out.println("----------------------------------------------");
					break;
				}
				System.out.println("----------------------------------------------");
				

			} else {
				// dano e defesa por vantagens combatentes
				double maisDano = vantagensCombatentes.vantagens(carta2.tipo);
				double danocausado = carta2.ataque() * maisDano;
				double menosDano = vantagensCombatentes.vantagens(carta1.tipo);
				int danoRecebido = (int) carta1.defesa(danocausado * menosDano);
				
				// armas, armaduras e joias
				int danoArma = carta2.arma.dano;
				maisDano = fraquezasArmasArmaduras.fraqueza(carta2.arma.tipo, carta1.armadura.tipo);
				danoArma *= maisDano;
				danoRecebido =  danoRecebido + danoArma;
				int defesaArmadura = carta1.armadura.defesa;
				menosDano = fraquezasArmasArmaduras.fraqueza(carta1.armadura.tipo, carta2.arma.tipo);
				defesaArmadura *= menosDano;
				danoRecebido -= defesaArmadura;
				
				int valorJoia = carta2.joia.valor;
				
				if(carta2.joia.equals(TipoJoias.ATAQUE)) {
					danoRecebido += valorJoia;
				} else if(carta2.joia.equals(TipoJoias.CURA)) {
					carta2.energia += valorJoia;
				}
				int valorJoia2 = carta1.joia.valor;
				if(carta1.joia.equals(TipoJoias.DEFESA)) {
					danoRecebido -= valorJoia2;
					defesaArmadura += valorJoia2;
				}
				
				if(danoRecebido < 0) {
					danoRecebido = 0;
				}
				carta1.energia -= danoRecebido;
				System.out.println(carta1.nome + " bloqueou: " + defesaArmadura);
				System.out.println(carta2.nome + " causou: " + danoRecebido);
				System.out.println(carta1.nome + " tem " + ((carta1.energia < 0) ? 0 : carta1.energia));
				Thread.sleep(2000);
				if (carta1.energia <= 0) {
					System.out.println(carta1.nome + " morreu.");
					this.jogador1.deck.armas.remove(carta1.arma);
					this.jogador1.deck.armaduras.remove(carta1.armadura);
					this.jogador1.deck.joias.remove(carta1.joia);
					System.out.println("----------------------------------------------");
					break;
				}
				// dano e defesa por vantagens combatentes
				double maisDano2 = vantagensCombatentes.vantagens(carta1.tipo);
				double danocausado2 = carta1.ataque() * maisDano2;
				double menosDano2 = vantagensCombatentes.vantagens(carta2.tipo);
				danoRecebido = (int) carta2.defesa(danocausado2 * menosDano2);
				
				// armas, armaduras e joias
				danoArma = carta1.arma.dano;
				maisDano = fraquezasArmasArmaduras.fraqueza(carta1.arma.tipo, carta2.armadura.tipo);
				danoArma *= maisDano;
				danoRecebido =  danoRecebido + danoArma;
				defesaArmadura = carta2.armadura.defesa;
				menosDano = fraquezasArmasArmaduras.fraqueza(carta2.armadura.tipo, carta1.arma.tipo);
				defesaArmadura *= menosDano;
				danoRecebido -= defesaArmadura;
				
				valorJoia = carta1.joia.valor;
				if(carta1.joia.equals(TipoJoias.ATAQUE)) {
					danoRecebido += valorJoia;
				} else if(carta1.joia.equals(TipoJoias.CURA)) {
					carta1.energia += valorJoia;
				}
				
				valorJoia2 = carta2.joia.valor;
				if(carta2.joia.equals(TipoJoias.DEFESA)) {
					danoRecebido -= valorJoia2;
					defesaArmadura += valorJoia2;
				}
				
				if(danoRecebido < 0) {
					danoRecebido = 0;
				}
				carta2.energia -= danoRecebido;
				System.out.println(carta2.nome + " bloqueou: " + defesaArmadura);
				System.out.println(carta1.nome + " causou: " + danoRecebido);
				System.out.println(carta2.nome + " tem " + ((carta2.energia < 0) ? 0 : carta2.energia));
				Thread.sleep(2000);
				if (carta2.energia <= 0) {
					System.out.println(carta2.nome + " morreu.");
					this.jogador2.deck.armas.remove(carta2.arma);
					this.jogador2.deck.armaduras.remove(carta2.armadura);
					this.jogador2.deck.joias.remove(carta2.joia);
					System.out.println("----------------------------------------------");
					break;
				}
				System.out.println("----------------------------------------------");
			}
		}

	}

}
