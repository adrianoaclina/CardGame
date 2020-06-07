package game.caracteristicas;

public class FraquezasArmasArmaduras {
	
	
	public double fraqueza(TipoArmasArmaduras atacante, TipoArmasArmaduras defensor) {
		
		if(atacante.equals(TipoArmasArmaduras.TERRESTRE) && defensor.equals(TipoArmasArmaduras.FOGO)) {
			return 1.5;
		}
		if(atacante.equals(TipoArmasArmaduras.TERRESTRE) && defensor.equals(TipoArmasArmaduras.ELETRICO)) {
			return 1.3;
		}
		if(atacante.equals(TipoArmasArmaduras.FOGO) && defensor.equals(TipoArmasArmaduras.ELETRICO)) {
			return 1.3;
		}
		if(atacante.equals(TipoArmasArmaduras.FOGO) && defensor.equals(TipoArmasArmaduras.VENENOSO)) {
			return 1.5;
		}
		if(atacante.equals(TipoArmasArmaduras.VENENOSO) && defensor.equals(TipoArmasArmaduras.AGUA)) {
			return 1.5;
		}
		if(atacante.equals(TipoArmasArmaduras.VENENOSO) && defensor.equals(TipoArmasArmaduras.TERRESTRE)) {
			return 1.3;
		}
		if(atacante.equals(TipoArmasArmaduras.AGUA) && defensor.equals(TipoArmasArmaduras.TERRESTRE)) {
			return 1.3;
		}
		if(atacante.equals(TipoArmasArmaduras.AGUA) && defensor.equals(TipoArmasArmaduras.FOGO)) {
			return 1.5;
		}
		if(atacante.equals(TipoArmasArmaduras.ELETRICO) && defensor.equals(TipoArmasArmaduras.VENENOSO)) {
			return 1.3;
		}
		if(atacante.equals(TipoArmasArmaduras.ELETRICO) && defensor.equals(TipoArmasArmaduras.AGUA)) {
			return 1.5;
		}
		
		return 1;
	}
}
