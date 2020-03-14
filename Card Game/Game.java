import java.util.Random;

public class Game {

	public static void main(String[] args) {
		System.out.println("O jogo vai comecar!!!");

		OrcMontanha player1 = new OrcMontanha(40);
		Arqueiro player2 = new Arqueiro(40);

		Random sorteio = new Random();
		int numero = sorteio.nextInt(10);
		if (numero % 2 == 1) {
			System.out.println("O Player 1 vai realizar o primeiro ataque!!!");
			while (player1.estaVivo() == true || player2.estaVivo() == true) {
				int danoRecebido;
				player2.energia -= (danoRecebido = player2.defesa(player1.ataque()));
				System.out.println("Player 1 causou: " + danoRecebido);
				System.out.println("Player2 tem " + player2.energia);
				if(player2.energia <= 0) {
					System.out.println("Player 1 ganhou !!!");
					break;
				}
				player1.energia -= (danoRecebido = player1.defesa(player2.ataque()));
				System.out.println("Player 2 causou: " + danoRecebido);
				System.out.println("Player1 tem " + player1.energia);
				if (player1.energia <= 0) {
					System.out.print("Player 2 ganhou !!!");
					break;
				}
			}
		} else {
			System.out.println("O Player 2 vai realizar o primeiro ataque!!!");
			while (player1.estaVivo() == true || player2.estaVivo() == true) {
				int danoRecebido;
				player1.energia -= (danoRecebido = player1.defesa(player2.ataque()));
				System.out.println("Player 2 causou: " + danoRecebido);
				System.out.println("Player1 tem " + player1.energia);
				if (player1.energia <= 0) {
					System.out.print("Player 2 ganhou !!!");
					break;
				}
				player2.energia -= (danoRecebido = player2.defesa(player1.ataque()));
				System.out.println("Player 1 causou: " + danoRecebido);
				System.out.println("Player2 tem " + player2.energia);
				if(player2.energia <= 0) {
					System.out.println("Player 1 ganhou !!!");
					break;
				}
			}
		}
	}
}
