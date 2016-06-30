package csid.datas;

import android.graphics.drawable.*;
import android.renderscript.Allocation;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import csid.sharedeck.R;

/**
 * Created by cecca on 10/06/2016.
 */
public class Deck {
    private ArrayList<Card> cards;
    private int maxCard = 52 ;
    public String[] couleurs = new String[]{"trefle","coeur","carreau","pique"};
    private BitmapDrawable img=null; // image du deck
    private int x,y;
    Random random = new Random();

    public Deck(String nbCards) {
        this.cards=new ArrayList<>();
        if(nbCards.equals("32")){
            this.buildDeck32();
        }
        else{
            this.buildDeck52();
        }

    }

    public void buildDeck32(){
        for(int iCouleur = 0; iCouleur < couleurs.length;iCouleur++) {
            for (int i = 6; i < 14; i++) {
                if(i == 6){
                    cards.add(new Card("1", couleurs[iCouleur]));
                }
                else if (i < 11) {
                    cards.add(new Card("" + i, couleurs[iCouleur]));
                } else if (i == 11) {
                    cards.add(new Card("J", couleurs[iCouleur]));
                } else if (i == 12) {
                    cards.add(new Card("D", couleurs[iCouleur]));
                } else if (i == 13) {
                    cards.add(new Card("K", couleurs[iCouleur]));
                }
            }
        }
    }

    public void buildDeck52(){
        for(int iCouleur = 0; iCouleur < couleurs.length;iCouleur++) {
            for (int i = 1; i < 14; i++) {
                if (i < 11) {
                    cards.add(new Card("" + i, couleurs[iCouleur]));
                } else if (i == 11) {
                    cards.add(new Card("J", couleurs[iCouleur]));
                } else if (i == 12) {
                    cards.add(new Card("D", couleurs[iCouleur]));
                } else if (i == 13) {
                    cards.add(new Card("K", couleurs[iCouleur]));
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
