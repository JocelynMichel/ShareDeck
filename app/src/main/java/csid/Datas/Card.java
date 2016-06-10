package csid.datas;

import android.graphics.drawable.BitmapDrawable;

/**
 * Created by jocelyn on 26/05/2016.
 */
public class Card {
    int idCard;
    private BitmapDrawable img=null; // image de la carte
    String value;
    String symbol;

    public Card(int idCard, String value, String symbol) {
        this.idCard = idCard;
        this.value = value;
        this.symbol = symbol;
    }
    public Card(String value, String symbol) {
        this.idCard = 0;
        this.value = value;
        this.symbol = symbol;
    }

    public String getValue(){
        return this.value;
    }

    public String getSymbol(){
        return this.symbol;
    }
}
