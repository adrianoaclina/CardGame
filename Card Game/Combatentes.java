import java.util.Random;

public class Combatentes {
	String nome;
	int energia;
	
	public int ataque() {
		Random dano = new Random(); 
		int ataque = dano.nextInt(10);
		return ataque;
	}
	
	public int defesa(int dano) {
		return dano;
	}
	
	public boolean estaVivo() {
		if(this.energia > 0) {
			return true;
		} else {
			return false;
		}
	}
}
