package game.armas;

import game.caracteristicas.TipoArmasArmaduras;

public abstract class Armas {

	public String nome;
	public int dano;
	public TipoArmasArmaduras tipo;

	public Armas(String nome, int dano, TipoArmasArmaduras tipo) {
		this.nome = nome;
		this.dano = dano;
		this.tipo = tipo;
	}
	
	
	public int causarDano() {
		return this.dano;
	}
}
