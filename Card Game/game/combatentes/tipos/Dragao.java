package game.combatentes.tipos;

import game.caracteristicas.TipoCombatentes;

public abstract class Dragao extends Monstros{

	public Dragao(String nome) {
		super(nome, TipoCombatentes.VOADOR);
	}
	
}
