package csid.Datas;

import android.graphics.drawable.*;

import java.util.ArrayList;

/**
 * Created by jocelyn on 26/05/2016.
 */
public class Hand {
    Player player;
    ArrayList<Card> cards;

    public Hand() {
        this.player = null;
        this.cards = new ArrayList<>();
    }
    public void addCard(Card card){
        cards.add(card);
    }
    public ArrayList<Card> getCards(){
        return cards;
    }

    public ArrayList<Card> getAllCards(){
        return cards;
    }

    public Card getLastCard(){
        return cards.get(cards.size()-1);
    }

    public int getNbCard(){
        return cards.size();
    }
}
