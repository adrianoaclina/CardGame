package game.armas;

import game.armas.adagas.AdagaFlamejante;
import game.armas.adagas.AdagaVenenosa;
import game.armas.adagas.Kama;
import game.armas.arcos.ArcoAquatico;
import game.armas.arcos.ArcoEletrico;
import game.armas.arcos.ArcoFlamejante;
import game.armas.arcos.ArcoTerrestre;
import game.armas.arcos.ArcoVenenoso;
import game.armas.espadas.EspadaAquatica;
import game.armas.espadas.EspadaFlamejante;
import game.armas.espadas.EspadaSanguinaria;
import game.armas.lancas.LancaEletrica;
import game.armas.lancas.LancaMortal;
import game.armas.lancas.LancaTerrestre;
import game.armas.machados.MachadoAquatico;
import game.armas.machados.MachadoEletrico;
import game.armas.machados.MachadoFlamejante;
import game.armas.machados.MachadoMortal;
import game.armas.machados.MachadoTerrestre;
import game.armas.machados.MachadoVenenoso;

public class FactoryArmas {
	public Armas getArmas(int numeroArma) {
		switch(numeroArma) {
		case 1:
			return new AdagaFlamejante();
		case 2:
			return new Kama();
		case 3:
			return new AdagaVenenosa();
		case 4:
			return new ArcoAquatico();
		case 5:
			return new ArcoEletrico();
		case 6:
			return new ArcoFlamejante();
		case 7:
			return new ArcoTerrestre();
		case 8:
			return new ArcoVenenoso();
		case 9:
			return new EspadaFlamejante();
		case 10:
			return new EspadaAquatica();
		case 11:
			return new EspadaSanguinaria();
		case 12:
			return new LancaMortal();
		case 13:
			return new LancaEletrica();
		case 14:
			return new MachadoAquatico();
		case 15:
			return new MachadoFlamejante();
		case 16:
			return new MachadoMortal();
		case 17:
			return new MachadoTerrestre();
		case 18:
			return new MachadoVenenoso();
		case 19:
			return new MachadoEletrico();
		case 20:
			return new LancaTerrestre();
		default:
			return null;
		}
	}
}
