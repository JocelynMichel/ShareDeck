package csid.datas;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import csid.sharedeck.R;

/**
 * Created by cecca on 29/06/2016.
 */
public class HandAdapter extends BaseAdapter {
    private Context mContext;

    public HandAdapter(Context c) {
        mContext = c;
        buildListOfImg();
    }

    public int getCount() {
        return mThumbIds.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public void addElement(Card card){
        mThumbIds.add(card);
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(310, 310));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setPadding(2, 2, 2, 2);
        } else {
            imageView = (ImageView) convertView;
        }

        int value ;
        switch(mThumbIds.get(position).getSymbol()){
            case "pique":
                Integer[] listTemp = listOfImg.get(0);
                String testValue = mThumbIds.get(position).getValue() ;
                if(testValue.equals("J")){
                    value =10;
                }
                else if(testValue.equals("D")){
                    value =11;
                }
                else if(testValue.equals("K")){
                    value =12;
                }
                else{
                    value =Integer.parseInt(testValue)-1;
                }
                imageView.setImageResource(listTemp[value]);
                break;
            case "trefle":
               // card.setBackgroundColor(Color.rgb(0,0,0));
                //card.setTextColor(Color.rgb(255,255,255));
                listTemp = listOfImg.get(1);
                testValue = mThumbIds.get(position).getValue() ;
                if(testValue.equals("J")){
                    value =10;
                }
                else if(testValue.equals("D")){
                    value =11;
                }
                else if(testValue.equals("K")){
                    value =12;
                }
                else{
                    value =Integer.parseInt(testValue)-1;
                }
                imageView.setImageResource(listTemp[value]);
                break;
            case "carreau":
                listTemp = listOfImg.get(2);
                testValue = mThumbIds.get(position).getValue() ;
                if(testValue.equals("J")){
                    value =10;
                }
                else if(testValue.equals("D")){
                    value =11;
                }
                else if(testValue.equals("K")){
                    value =12;
                }
                else{
                    value =Integer.parseInt(testValue)-1;
                }
                imageView.setImageResource(listTemp[value]);
                break;
            case "coeur":
                //card.setBackgroundColor(Color.rgb(225,18,18));
                listTemp = listOfImg.get(3);
                testValue = mThumbIds.get(position).getValue() ;
                if(testValue.equals("J")){
                    value =10;
                }
                else if(testValue.equals("D")){
                    value =11;
                }
                else if(testValue.equals("K")){
                    value =12;
                }
                else{
                    value =Integer.parseInt(testValue)-1;
                }
                imageView.setImageResource(listTemp[value]);
                break;
        }
        return imageView;
    }

    // references to our images
    private ArrayList<Card> mThumbIds = new ArrayList<Card>();

    private ArrayList<Integer[]> listOfImg = new ArrayList<Integer[]>();

    public void buildListOfImg() {
        Integer[] listTrefle = {
                R.mipmap.carte_trefle_1, /* 1 */ R.mipmap.carte_trefle_2,  // 2
                R.mipmap.carte_trefle_3, /* 3 */ R.mipmap.carte_trefle_4,  // 4
                R.mipmap.carte_trefle_5, /* 5 */ R.mipmap.carte_trefle_6,  // 6
                R.mipmap.carte_trefle_7, /* 7 */ R.mipmap.carte_trefle_8,  // 8
                R.mipmap.carte_trefle_9, /* 9 */ R.mipmap.carte_trefle_10, // 10
                R.mipmap.carte_trefle_j, /* J */ R.mipmap.carte_trefle_q,  // Q
                R.mipmap.carte_trefle_k  /* K */
        };

        Integer[] listPique = {
                R.mipmap.carte_pique_1, /* 1 */ R.mipmap.carte_pique_2,  // 2
                R.mipmap.carte_pique_3, /* 3 */ R.mipmap.carte_pique_4,  // 4
                R.mipmap.carte_pique_5, /* 5 */ R.mipmap.carte_pique_6,  // 6
                R.mipmap.carte_pique_7, /* 7 */ R.mipmap.carte_pique_8,  // 8
                R.mipmap.carte_pique_9, /* 9 */ R.mipmap.carte_pique_10, // 10
                R.mipmap.carte_pique_j, /* J */ R.mipmap.carte_pique_q,  // Q
                R.mipmap.carte_pique_k  /* K */
        };

        Integer[] listCarreau = {
                R.mipmap.carte_carreau_1, /* 1 */ R.mipmap.carte_carreau_2,  // 2
                R.mipmap.carte_carreau_3, /* 3 */ R.mipmap.carte_carreau_4,  // 4
                R.mipmap.carte_carreau_5, /* 5 */ R.mipmap.carte_carreau_6,  // 6
                R.mipmap.carte_carreau_7, /* 7 */ R.mipmap.carte_carreau_8,  // 8
                R.mipmap.carte_carreau_9, /* 9 */ R.mipmap.carte_carreau_10, // 10
                R.mipmap.carte_carreau_j, /* J */ R.mipmap.carte_carreau_q,  // Q
                R.mipmap.carte_carreau_k  /* K */
        };

        Integer[] listCoeur = {
                R.mipmap.carte_coeur_1, /* 1 */ R.mipmap.carte_coeur_2,  // 2
                R.mipmap.carte_coeur_3, /* 3 */ R.mipmap.carte_coeur_4,  // 4
                R.mipmap.carte_coeur_5, /* 5 */ R.mipmap.carte_coeur_6,  // 6
                R.mipmap.carte_coeur_7, /* 7 */ R.mipmap.carte_coeur_8,  // 8
                R.mipmap.carte_coeur_9, /* 9 */ R.mipmap.carte_coeur_10, // 10
                R.mipmap.carte_coeur_j, /* J */ R.mipmap.carte_coeur_q,  // Q
                R.mipmap.carte_coeur_k  /* K */
        };

        listOfImg.add(listPique);
        listOfImg.add(listTrefle);
        listOfImg.add(listCarreau);
        listOfImg.add(listCoeur);
    }
}
