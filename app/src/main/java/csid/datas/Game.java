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

    public void run(String nbCards){
        this.deck = new Deck(nbCards);
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
    public boolean GiveCardsToPlayerAuto(int nbCards){
        if(deck.getNbCard() > 0 && nbCards*players.size()<=deck.getNbCard()) {
            for (Player onePlayer:players) {
                for (int i = 0; i < nbCards ; i++){
                    onePlayer.addCardToHand(deck.giveOneCard());
                }
            }
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

    public int getNbPlayers(){
        return players.size();
    }
}
