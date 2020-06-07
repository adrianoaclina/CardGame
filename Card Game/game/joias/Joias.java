package game.joias;

import game.caracteristicas.TipoJoias;

public abstract class Joias {
	public String nome;
	public int valor;
	public TipoJoias tipo;

	public Joias(String nome, int valor, TipoJoias tipo) {
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
	}

	public int getDefesa() {
		if(this.tipo == TipoJoias.DEFESA) {
			return this.valor;
		}
		return 0;
	}

	public int getAtaque() {
		if(this.tipo == TipoJoias.ATAQUE) {
				return this.valor;
		}
		return 0;
	}
}
