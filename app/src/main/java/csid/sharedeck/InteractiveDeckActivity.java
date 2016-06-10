package csid.sharedeck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.*;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.util.*;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import csid.datas.*;

public class InteractiveDeckActivity extends AppCompatActivity {
    float initX = 60 ;
    float initY = 424;
    Game currentGame = new Game();
    Player player1 = new Player("joueur 1");
    boolean isSelect = false ;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactive_deck);

        currentGame.run();

        ImageView image = (ImageView) findViewById(R.id.imageDeck);
        image.setOnTouchListener(touchListenerBouton1);

        Button buttonJoueur = (Button) findViewById(R.id.joueur);
        buttonJoueur.setOnHoverListener(hoverListenerDrop);
        buttonJoueur.setText(player1.getNamePlayer());
    }


    private OnTouchListener touchListenerBouton1 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.i("case", "Action_Down");

                    Log.i("case",""+v.getX());
                    Log.i("case",""+v.getY());

                    isSelect = true ;
                    break;
                case MotionEvent.ACTION_MOVE:
                    //Log.i("case", "Action_Move");
                    v.setX(event.getX() + (v.getX() - (v.getWidth() / 2)));
                    v.setY(event.getY() + (v.getY() - (v.getHeight() / 2)));


                    //TranslateAnimation animation = new TranslateAnimation(0,(int)event.getX(),0,(int)event.getY() );
                    //animation.setFillAfter(true);
                    //v.startAnimation(animation);
                    break;
                case MotionEvent.ACTION_UP:
                    Log.i("case" , "Action_up");

                    break;
            }
            return true;
        }
    };

    private OnHoverListener hoverListenerDrop = new View.OnHoverListener() {
        @Override
        public boolean onHover(View v, MotionEvent event) {
            ImageView image = (ImageView) findViewById(R.id.imageDeck);

            TextView text = (TextView) findViewById(R.id.textView2);
            switch (event.getAction()) {
                case MotionEvent.ACTION_HOVER_ENTER:
                    Log.i("case", "Hover_Enter");
                     if(isSelect) {
                         currentGame.GiveOneCardToPlayer(player1);
                         String value = player1.getHand().getLastCard().getValue();
                         String Symbol = player1.getHand().getLastCard().getSymbol();

                         text.setText(text.getText() + "\nCard[Couleur:" + Symbol + " | Valeur:" + value + "]");
                         image.setX(initX);
                         image.setY(initY);

                         isSelect = false ;
                     }
            }
            return true;
        }
    };
}