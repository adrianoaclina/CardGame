package game.settings;

import java.util.ArrayList;
import java.util.List;

import game.armaduras.Armaduras;
import game.armas.Armas;
import game.combatentes.Combatentes;
import game.joias.Joias;

public class Deck {
    public List<Combatentes> cards = new ArrayList<Combatentes>();
    public List<Armas> armas = new ArrayList<Armas>();
    public List<Armaduras> armaduras = new ArrayList<Armaduras>();
    public List<Joias> joias = new ArrayList<Joias>();

    public Deck(List<Combatentes> cards, List<Armas> armas,List<Armaduras> armaduras, List<Joias> joias) {
        this.cards = cards;
        this.armas = armas;
        this.armaduras = armaduras;
        this.joias = joias;
    }
    
    public List<Combatentes> getCards() {
        return this.cards;
    } 
    
    public int getTamanhoDeck(){
    	return this.cards.size();
    }
    public void tiraCardsMortas(){

        for(int i = 0; i < this.getTamanhoDeck(); i++){
            Combatentes card = this.getCards().get(i);
            if(!card.vivo()){
                this.cards.remove(i);
            }

        }
        
    }
}
