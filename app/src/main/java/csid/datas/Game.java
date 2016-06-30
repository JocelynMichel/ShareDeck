package csid.Datas;

import java.util.ArrayList;

/**
 * Created by cecca on 10/06/2016.
 */
public class Game {
    ArrayList<csid.Datas.Player> players;
    Deck deck;

    public Game(){

    }

    public void run(){
        this.deck = new Deck();
        this.players = new ArrayList<Player>();
    }

    public boolean GiveOneCardToPlayer(Player player){
        if(deck.getNbCard() > 0) {
            player.addCardToHand(deck.giveOneCard());
            return true;
        }
        else{
            return false;
        }
    }

    public Deck getDeck(){
        return this.deck;
    }

    public void initPlayers(int nbPlayers){
        for(int i = 1 ; i <= nbPlayers; i++) {

        }
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public Player getPlayerByName(String playerName){
        Player returnPlayer = null;
        for (Player onePlayer:players) {
            if(onePlayer.getNamePlayer().equals(playerName)){
                returnPlayer = onePlayer ;
            }
        }
        if(!returnPlayer.getNamePlayer().isEmpty()) {
            return returnPlayer;
        }
        else{
            return null;
        }
    }
}
