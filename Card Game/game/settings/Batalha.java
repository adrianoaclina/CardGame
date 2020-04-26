package game.settings;

import java.util.Scanner;

import game.combatentes.Combatentes;

public class Batalha {
	Jogador jogador1;
	Jogador jogador2;

	public Batalha(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
	}

	public void batalhar() {
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
		if(jogador1.deck.cards.size()> 0) {
			System.out.println(this.jogador1.nome + " você ganhou!!!");
		} else{
			System.out.println(this.jogador2.nome + " você ganhou!!!");
		}
		
	}
	public void round(int escolha, int rounds) {
		Scanner input = new Scanner(System.in);
		System.out.println("O Round "+ rounds+ " vai começar !!!");
		System.out.println(this.jogador1.nome + " escolha uma carta para esse round:");
		for (int i = 0; i < this.jogador1.deck.getTamanhoDeck(); i++) {
			System.out.println("#" + i + "- " + this.jogador1.deck.cards.get(i).nome);
		}
		int cardEscolhida1 = input.nextInt();

		System.out.println(this.jogador2.nome + " escolha uma carta para esse round:");
		for (int i = 0; i < this.jogador2.deck.getTamanhoDeck(); i++) {
			System.out.println("#" + i + "- " + this.jogador2.deck.cards.get(i).nome);
		}
		int cardEscolhida2 = input.nextInt();

		Combatentes card1 = this.jogador1.deck.cards.get(cardEscolhida1);
		Combatentes card2 = this.jogador2.deck.cards.get(cardEscolhida2);

		this.luta(card1, card2, escolha);
	}

	public void luta(Combatentes carta1, Combatentes carta2, int escolha) {

		while (carta1.vivo() && carta2.vivo()) {
			if (escolha % 2 == 1) {
				int danoRecebido;
				carta2.energia -= (danoRecebido = carta2.defesa(carta1.ataque()));
				System.out.println(carta1.nome + " causou: " + danoRecebido);
				System.out.println(carta2.nome + " tem " + ((carta2.energia < 0) ? 0 : carta2.energia));
				if (carta2.energia <= 0) {
					System.out.println(carta2.nome + " morreu.");
					System.out.println("----------------------------------------------");
					break;
				}
				carta1.energia -= (danoRecebido = carta1.defesa(carta2.ataque()));
				System.out.println(carta2.nome + " causou: " + danoRecebido);
				System.out.println(carta1.nome + " tem " + ((carta1.energia < 0) ? 0 : carta1.energia));
				if (carta1.energia <= 0) {
					System.out.println(carta1.nome + " morreu.");
					System.out.println("----------------------------------------------");
					break;
				}
				System.out.println("----------------------------------------------");

			} else {
				int danoRecebido;
				carta1.energia -= (danoRecebido = carta1.defesa(carta2.ataque()));
				System.out.println(carta2.nome + " causou: " + danoRecebido);
				System.out.println(carta1.nome + " tem " + ((carta1.energia < 0) ? 0 : carta1.energia));
				if (carta1.energia <= 0) {
					System.out.println(carta1.nome + " morreu.");
					System.out.println("----------------------------------------------");
					break;
				}
				carta2.energia -= (danoRecebido = carta2.defesa(carta1.ataque()));
				System.out.println(carta1.nome + " causou: " + danoRecebido);
				System.out.println(carta2.nome + " tem " + ((carta2.energia < 0) ? 0 : carta2.energia));
				if (carta2.energia <= 0) {
					System.out.println(carta2.nome + " morreu.");
					System.out.println("----------------------------------------------");
					break;
				}
				System.out.println("----------------------------------------------");
			}
		}

	}

}
