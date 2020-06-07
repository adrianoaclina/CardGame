package game.combatentes;
import java.util.Random;

import game.armaduras.Armaduras;
import game.armas.Armas;
import game.caracteristicas.TipoCombatentes;
import game.joias.Joias;

public abstract class Combatentes {
	public String nome;
	public int energia;
	public boolean vivo;
	public TipoCombatentes tipo;
	
	public Armas arma;
	public Armaduras armadura;
	public Joias joia;
	
	public Combatentes(String nome, int energia, TipoCombatentes tipo) {
		this.nome = nome;
		this.energia = energia;
		this.tipo = tipo;
	}
	
	public int ataque() {
		Random dano = new Random(); 
		int ataque = dano.nextInt(10) + 1;
		return ataque;
	}
	
	public double defesa(double dano) {
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
