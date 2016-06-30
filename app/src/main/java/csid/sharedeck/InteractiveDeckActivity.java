package csid.sharedeck;

import android.net.Uri;
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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import java.util.ArrayList;

import csid.Datas.*;

import static csid.sharedeck.R.color.Red;
import static csid.sharedeck.R.drawable.red_button;

public class InteractiveDeckActivity extends AppCompatActivity {
    float initX;
    float initY;
    Game currentGame = new Game();
    Player player1 = new Player("Bboy");
    Player player2 = new Player("Joyceline");
    Player player3 = new Player("Gaêt");
    TextView nbCardOfDeck;
    Button resetButton;
    boolean isSelect = false;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_interactive_deck);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentGame.run();

        nbCardOfDeck = (TextView) findViewById(R.id.displayNbCardInDeck);

        nbCardOfDeck.setText("" + currentGame.getDeck().getNbCard());

        currentGame.addPlayer(player1);
        currentGame.addPlayer(player2);
        currentGame.addPlayer(player3);

        ImageView image = (ImageView) findViewById(R.id.imageDeck);
        image.setOnTouchListener(touchListenerImage);

        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setVisibility(View.INVISIBLE);
        resetButton.setOnClickListener(clickListener);

        Button buttonJoueur1 = (Button) findViewById(R.id.joueur1);
        buttonJoueur1.setOnHoverListener(hoverListenerDrop);
        buttonJoueur1.setOnClickListener(clickListener);
        buttonJoueur1.setText(player1.getNamePlayer());

        Button buttonJoueur2 = (Button) findViewById(R.id.joueur2);
        buttonJoueur2.setOnHoverListener(hoverListenerDrop);
        buttonJoueur2.setOnClickListener(clickListener);
        buttonJoueur2.setText(player2.getNamePlayer());

        Button buttonJoueur3 = (Button) findViewById(R.id.joueur3);
        buttonJoueur3.setOnHoverListener(hoverListenerDrop);
        buttonJoueur3.setOnClickListener(clickListener);
        buttonJoueur3.setText(player3.getNamePlayer());

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void createTextView(String value, String signe) {
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout_parent);
        Button buttonHandCards = new Button(this);

        buttonHandCards.setText("Je test");
        //buttonHandCards.setBackgroundColor(Red);
        buttonHandCards.setX(initX);
        buttonHandCards.setY(initY);

        layout.addView(buttonHandCards);
        //testValue.setVisibility(View.VISIBLE);
    }

    private OnTouchListener touchListenerImage = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.i("case", "Action_Down");
                    if (initX == 0 && initY == 0) {
                        initX = v.getX();
                        initY = v.getY();
                    }
                    isSelect = true;
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
                    Log.i("case", "Action_up");
                    break;
            }
            return true;
        }
    };

    private OnHoverListener hoverListenerDrop = new OnHoverListener() {
        @Override
        public boolean onHover(View v, MotionEvent event) {
            ImageView imageCard = (ImageView) findViewById(R.id.imageDeck);
            ImageView imageCardBis = (ImageView) findViewById(R.id.imageDeck1);
            Button boutonPlayer = (Button) findViewById(v.getId());
            TextView text = (TextView) findViewById(R.id.textView2);

            switch (event.getAction()) {
                case MotionEvent.ACTION_HOVER_ENTER:
                    Log.i("case", "Hover_Enter");
                    Log.i("player", "" + boutonPlayer.getText());
                    if (isSelect) {
                        Player player = currentGame.getPlayerByName((String) boutonPlayer.getText());
                        Log.i("player2", "" + player.getNamePlayer());
                        if (currentGame.GiveOneCardToPlayer(player)) {

                            imageCard.setX(initX);
                            imageCard.setY(initY);
                        } else {
                            imageCard.setVisibility(View.INVISIBLE);
                            imageCardBis.setVisibility(View.INVISIBLE);
                        }

                        nbCardOfDeck.setText("" + currentGame.getDeck().getNbCard());

                        isSelect = false;
                    }
            }
            return true;
        }
    };

    private OnClickListener clickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            ImageView imageCard = (ImageView) findViewById(R.id.imageDeck);
            ImageView imageCardBis = (ImageView) findViewById(R.id.imageDeck1);

            if (v.getId() == R.id.resetButton) {
                TextView text = (TextView) findViewById(R.id.textView2);
                text.setText("Distribuez !"); //Réinitialise le champs
                v.setVisibility(View.INVISIBLE);
            }
            /*else if (v.getId() == R.id.joueur1) {
                imageCard.setVisibility(View.INVISIBLE);
                imageCardBis.setVisibility(View.INVISIBLE);
                Button playerButton = (Button) findViewById(R.id.joueur1);
                Player player = currentGame.getPlayerByName((String) playerButton.getText());

                ArrayList<Card> cardsHand = player.getHand().getAllCards();
                for (Card oneCard : cardsHand) {
                    createTextView(oneCard.getSymbol(), oneCard.getValue());
                }

            }*/ else {
                Button boutonPlayer = (Button) findViewById(v.getId());
                TextView text = (TextView) findViewById(R.id.textView2);
                Player player = currentGame.getPlayerByName((String) boutonPlayer.getText());
                text.setText("Main de :" + player.getNamePlayer()); //Réinitialise le champs
                resetButton.setVisibility(View.VISIBLE);

                ArrayList<Card> playerHand = player.getHand().getAllCards();
                for (Card oneCard : playerHand) {
                    text.setText(text.getText() + "\n[Couleur:" + oneCard.getSymbol() + " | Valeur:" + oneCard.getValue() + "]");
                }
            }
        }

    };

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "InteractiveDeck Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://csid.sharedeck/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "InteractiveDeck Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://csid.sharedeck/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}