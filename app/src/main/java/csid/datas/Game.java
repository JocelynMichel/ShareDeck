package csid.datas;

import java.util.ArrayList;

/**
 * Created by cecca on 10/06/2016.
 */
public class Game {
    ArrayList<Player> players;
    Deck deck;

    public Game(){

    }

    public void run(){
        this.deck = new Deck();
    }

    public void GiveOneCardToPlayer(Player player){
        player.addCardToHand(deck.giveOneCard());
    }

    public Deck getDeck(){
        return this.deck;
    }
}
