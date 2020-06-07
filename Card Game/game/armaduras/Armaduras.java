package game.armaduras;

import game.caracteristicas.TipoArmasArmaduras;

public abstract class Armaduras {
	
	public String nome;
	public int defesa;
	public TipoArmasArmaduras tipo;
	
	public Armaduras(String nome, int defesa, TipoArmasArmaduras tipo) {
		this.nome = nome;
		this.defesa = defesa;
		this.tipo = tipo;
	}
	
	public int reduzirDano() {
		return this.defesa;
	}
}
