package csid.Datas;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by jocelyn on 26/05/2016.
 */
public class Card {
    int idCard;
    private int img; // image de la carte
    String value;
    String symbol;

    public Card(int idCard, String value, String symbol, int img) {
        this.idCard = idCard;
        this.value = value;
        this.symbol = symbol;
        this.img = img;
    }
    public Card(String value, String symbol, int img) {
        this.idCard = 0;
        this.value = value;
        this.symbol = symbol;
        this.img = img;
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
