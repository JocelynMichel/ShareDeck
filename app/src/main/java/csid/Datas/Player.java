package csid.Datas;

/**
 * Created by jocelyn on 26/05/2016.
 */
public class Player {
    //int idPlayer;
    String namePlayer;
    Hand hand;


    public Player(String namePlayer) {
        //this.idPlayer = idPlayer;
        this.namePlayer = namePlayer;
        this.hand = new Hand();
    }
    public void addCardToHand(Card card){
        hand.addCard(card);
    }
    public Hand getHand(){
        return hand;
    }
    public String getNamePlayer(){
        return namePlayer;
    }
}
