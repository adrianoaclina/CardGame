
public class Combatentes {
	String nome;
	int energia;
	
	public int ataque(int dano) {
		return dano;
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
