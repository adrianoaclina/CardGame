package game.combatentes.tipos;

import game.caracteristicas.TipoCombatentes;

public abstract class Magos extends Humanos{

	public Magos(String nome) {
		super(nome, TipoCombatentes.MÁGICO);
	}

}
