package game.combatentes;

import game.combatentes.tipos.criaturas.anoes.AnaoAnciao;
import game.combatentes.tipos.criaturas.anoes.AnaoArqueiro;
import game.combatentes.tipos.criaturas.anoes.AnaoGuerreiro;
import game.combatentes.tipos.criaturas.anoes.AnaoMagico;
import game.combatentes.tipos.criaturas.dragoes.DragaoAgua;
import game.combatentes.tipos.criaturas.dragoes.DragaoAnciao;
import game.combatentes.tipos.criaturas.dragoes.DragaoEletrico;
import game.combatentes.tipos.criaturas.dragoes.DragaoFogo;
import game.combatentes.tipos.criaturas.elfos.ElfoArqueiro;
import game.combatentes.tipos.criaturas.elfos.ElfoEscuridao;
import game.combatentes.tipos.criaturas.elfos.ElfoFloresta;
import game.combatentes.tipos.criaturas.elfos.ElfoGuerreiro;
import game.combatentes.tipos.criaturas.elfos.ElfoLuz;
import game.combatentes.tipos.criaturas.humanos.Arqueiro;
import game.combatentes.tipos.criaturas.humanos.Guerreiro;
import game.combatentes.tipos.criaturas.humanos.Ladrao;
import game.combatentes.tipos.criaturas.humanos.Monge;
import game.combatentes.tipos.criaturas.magos.MagoEletrico;
import game.combatentes.tipos.criaturas.magos.MagoFogo;
import game.combatentes.tipos.criaturas.magos.MagoGelo;
import game.combatentes.tipos.criaturas.orcs.OrcCavernas;
import game.combatentes.tipos.criaturas.orcs.OrcColinas;
import game.combatentes.tipos.criaturas.orcs.OrcDeserto;
import game.combatentes.tipos.criaturas.orcs.OrcMontanha;
import game.combatentes.tipos.criaturas.trols.TrolCavernas;
import game.combatentes.tipos.criaturas.trols.TrolColinas;
import game.combatentes.tipos.criaturas.trols.TrolGigante;
import game.combatentes.tipos.criaturas.trols.TrolNeves;
import game.combatentes.tipos.criaturas.trols.TrolPedra;
import game.combatentes.tipos.criaturas.magos.MagoAgua;

public class FactoryCombatentes {
	public Combatentes getCombatentes(int NumeroCard) {
		switch(NumeroCard) {
		case 1: 
			return new Arqueiro();
		case 2: 
			return new OrcDeserto();
		case 3: 
			return new DragaoAgua();
		case 4: 
			return new MagoAgua();
		case 5: 
			return new DragaoFogo();
		case 6: 
			return new OrcMontanha();
		case 7: 
			return new TrolGigante();
		case 8:
			return new MagoEletrico();
		case 9:
			return new MagoFogo();
		case 10:
			return new Guerreiro();
		case 11:
			return new ElfoLuz();
		case 12:
			return new ElfoEscuridao();
		case 13:
			return new ElfoArqueiro();
		case 14:
			return new ElfoFloresta();
		case 15:
			return new TrolColinas();
		case 16:
			return new TrolCavernas();
		case 17:
			return new TrolPedra();
		case 18:
			return new TrolNeves();
		case 19:
			return new AnaoArqueiro();
		case 20:
			return new AnaoGuerreiro();
		case 21:
			return new AnaoMagico();
		case 22:
			return new OrcColinas();
		case 23:
			return new OrcCavernas();
		case 24:
			return new Ladrao();
		case 25:
			return new DragaoAnciao();
		case 26:
			return new DragaoEletrico();
		case 27:
			return new Monge();
		case 28:
			return new MagoGelo();
		case 29:
			return new ElfoGuerreiro();
		case 30:
			return new AnaoAnciao();
			
		default:
			return null;
		}
		
			
	}
}
