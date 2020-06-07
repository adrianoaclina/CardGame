package game.joias;

import game.joias.ataque.AnelCelestial;
import game.joias.ataque.BraceleteMagico;
import game.joias.ataque.PedraAtacante;
import game.joias.cura.BraceleteCurativo;
import game.joias.cura.ColarPandora;
import game.joias.cura.PedraCurativa;
import game.joias.defesa.BraceleteCelestial;
import game.joias.defesa.PedraDefensora;
import game.joias.defesa.PingenteAzul;

public class FactoryJoias {
	public Joias getJoias(int numeroJoia){
		switch (numeroJoia) {
		case 1: 
			return new AnelCelestial();
		case 2: 
			return new PingenteAzul();
		case 3: 
			return new ColarPandora();
		case 4: 
			return new BraceleteCelestial();
		case 5: 
			return new PedraDefensora();
		case 6: 
			return new PedraAtacante();
		case 7: 
			return new PedraCurativa();
		case 8: 
			return new BraceleteMagico();
		case 9: 
			return new BraceleteCurativo();
		default:
			return null;
		}
	}
}
