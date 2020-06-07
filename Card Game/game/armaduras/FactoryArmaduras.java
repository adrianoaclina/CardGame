package game.armaduras;

import game.armaduras.tipos.ArmaduraAgua;
import game.armaduras.tipos.ArmaduraBronze;
import game.armaduras.tipos.ArmaduraEletrica;
import game.armaduras.tipos.ArmaduraFerro;
import game.armaduras.tipos.ArmaduraFogo;
import game.armaduras.tipos.ArmaduraOuro;
import game.armaduras.tipos.ArmaduraTerrestre;
import game.armaduras.tipos.ArmaduraVenenosa;
import game.armaduras.tipos.CouracaAgua;
import game.armaduras.tipos.CouracaEletrica;
import game.armaduras.tipos.CouracaFerro;
import game.armaduras.tipos.CouracaFogo;
import game.armaduras.tipos.CouracaPano;
import game.armaduras.tipos.CouracaTerrestre;
import game.armaduras.tipos.CouracaVenenosa;
import game.armaduras.tipos.PeitoralAgua;
import game.armaduras.tipos.PeitoralEletrico;
import game.armaduras.tipos.PeitoralFogo;
import game.armaduras.tipos.PeitoralTerrestre;
import game.armaduras.tipos.PeitoralVenenoso;

public class FactoryArmaduras {
	public Armaduras getArmaduras(int numeroArmadura) {
		switch (numeroArmadura) {
		case 1: 
			return new ArmaduraEletrica();
		case 2: 
			return new ArmaduraFogo();
		case 3: 
			return new ArmaduraAgua();
		case 4: 
			return new ArmaduraTerrestre();
		case 5: 
			return new ArmaduraVenenosa();
		case 6: 
			return new CouracaFogo();
		case 7: 
			return new CouracaAgua();
		case 8: 
			return new CouracaVenenosa();
		case 9: 
			return new CouracaEletrica();
		case 10: 
			return new CouracaTerrestre();
		case 11: 
			return new PeitoralFogo();
		case 12: 
			return new PeitoralAgua();
		case 13: 
			return new PeitoralTerrestre();
		case 14: 
			return new PeitoralVenenoso();
		case 15: 
			return new PeitoralEletrico();
		case 16: 
			return new ArmaduraOuro();
		case 17: 
			return new ArmaduraFerro();
		case 18: 
			return new ArmaduraBronze();
		case 19: 
			return new CouracaFerro();
		case 20: 
			return new CouracaPano();
		default:
			return null;
		}
	}
}
