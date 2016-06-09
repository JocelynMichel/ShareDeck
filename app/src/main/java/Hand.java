import java.util.ArrayList;

/**
 * Created by jocelyn on 26/05/2016.
 */
public class Hand {
    int idHand;
    Player player;
    ArrayList<Card> cards=new ArrayList<>();

    public Hand(int idHand, Player player, ArrayList<Card> cards) {
        this.idHand = idHand;
        this.player = player;
        this.cards = cards;
    }
}
