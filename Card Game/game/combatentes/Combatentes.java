package game.combatentes;
import java.util.Random;

public abstract class Combatentes {
	public String nome;
	public int energia;
	public boolean vivo;
	
	public Combatentes(String nome, int energia) {
		this.nome = nome;
		this.energia = energia;
	}
	
	public int ataque() {
		Random dano = new Random(); 
		int ataque = dano.nextInt(10);
		return ataque;
	}
	
	public int defesa(int dano) {
		return dano;
	}
	
	public boolean vivo() {
		if(this.energia > 0) {
			return true;
		} else {
			return false;
		}
	}
}
