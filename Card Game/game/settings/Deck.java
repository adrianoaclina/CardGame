package game.settings;

import java.util.ArrayList;
import java.util.List;

import game.combatentes.Combatentes;

public class Deck {
    public List<Combatentes> cards = new ArrayList<Combatentes>();

    public Deck(List<Combatentes> cards) {
        this.cards = cards;
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
