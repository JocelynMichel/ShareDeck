package csid.Datas;

import android.graphics.drawable.*;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by cecca on 10/06/2016.
 */
public class Deck {
    private ArrayList<csid.Datas.Card> cards;
    private int maxCard = 52 ;
    public String[] couleurs = new String[]{"trèfle","coeur","carreau","pique"};
    private BitmapDrawable img=null; // image du deck
    private int x,y;
    Random random = new Random();

    public Deck() {
        this.cards=new ArrayList<>();
        this.buildDeck();
    }

    public void buildDeck(){
        for(int iCouleur = 0; iCouleur < couleurs.length;iCouleur++) {
            for (int i = 1; i < 14; i++) {
                if (i < 11) {
                    cards.add(new Card("" + i, couleurs[iCouleur]));
                } else if (i == 11) {
                    cards.add(new Card("V", couleurs[iCouleur]));
                } else if (i == 12) {
                    cards.add(new Card("D", couleurs[iCouleur]));
                } else if (i == 13) {
                    cards.add(new Card("R", couleurs[iCouleur]));
                }
            }
        }
    }

    public ArrayList<Card> giveAllCard(){
        return cards;
    }

    public Card giveOneCard(){
        int iRandom = (int) (Math.random() * (cards.size() - 1));
        Card oneCard = cards.get(iRandom);
        cards.remove(iRandom);

        return oneCard;
    }

    public int getNbCard(){
        return cards.size();
    }

    public void displayDeck(){
        for(Card oneCard : cards){
            Log.i("Couleur", oneCard.getSymbol());
            Log.i("Valeur", oneCard.getValue());
            Log.i("----------", "-----------------------");
            //System.out.println("Couleur : " +oneCard.getSymbol() +", Valeur : "+oneCard.getValue());
        }
    }
}
