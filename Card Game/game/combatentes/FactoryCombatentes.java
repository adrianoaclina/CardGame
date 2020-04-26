package game.combatentes;

import game.combatentes.tipos.criaturas.Arqueiro;
import game.combatentes.tipos.criaturas.DragaoFogo;
import game.combatentes.tipos.criaturas.DragaoGelo;
import game.combatentes.tipos.criaturas.MagoEletrico;
import game.combatentes.tipos.criaturas.MagoGelo;
import game.combatentes.tipos.criaturas.OrcDeserto;
import game.combatentes.tipos.criaturas.OrcMontanha;
import game.combatentes.tipos.criaturas.TrolGigante;

public class FactoryCombatentes {
	public Combatentes getCombatentes(int energia, int NumeroCard) {
		switch(NumeroCard) {
		case 1: 
			return new Arqueiro("Arqueiro", energia);
		case 2: 
			return new OrcDeserto("Orc do Deserto", energia);
		case 3: 
			return new DragaoGelo("Dragão de Gelo", energia);
		case 4: 
			return new MagoGelo("Mago de gelo", energia);
		case 5: 
			return new DragaoFogo("Dragão de Fogo", energia);
		case 6: 
			return new OrcMontanha("Orc da Montanha", energia);
		case 7: 
			return new TrolGigante("Trol Gigante", energia);
		case 8:
			return new MagoEletrico("Mago Elétrico", energia);
		default:
			return null;
		}
		
			
	}
}
