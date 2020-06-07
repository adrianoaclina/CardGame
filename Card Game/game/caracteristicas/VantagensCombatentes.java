package game.caracteristicas;

public class VantagensCombatentes {
	
	public double vantagens(TipoCombatentes combatente) {
		if(combatente.equals(TipoCombatentes.VOADOR)) {
			return 0.5;
		}
		if(combatente.equals(TipoCombatentes.MÁGICO)) {
			return 0.8;
		}
		if(combatente.equals(TipoCombatentes.LUTADOR)) {
			return 1.2;
		}
		if(combatente.equals(TipoCombatentes.NORMAL)) {
			return 1;
		}
		
		return 0;
	}
}
