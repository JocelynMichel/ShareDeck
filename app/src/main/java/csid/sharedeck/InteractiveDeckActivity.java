package csid.sharedeck;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.*;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.util.*;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import java.util.ArrayList;

import csid.datas.*;

import static csid.sharedeck.R.color.Red;
import static csid.sharedeck.R.drawable.red_button;

public class InteractiveDeckActivity extends AppCompatActivity {
    float initX;
    float initY;
    Game currentGame = new Game();
    Player player1 = new Player("Bboy");
    Player player2 = new Player("Joyceline");
    Player player3 = new Player("Gaêt");
    LinearLayout layoutHand;
    TextView nbCardOfDeck;
    Button resetButton;
    Button autoBouton;
    AlertDialog dialogDistribCardAuto;
    NumberPicker nbPicker;
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

        final String nbCards = (String) getIntent().getSerializableExtra("NbCards") ;

        Log.i("NbcardJeu", nbCards);

        currentGame.run(nbCards);

        nbCardOfDeck = (TextView) findViewById(R.id.displayNbCardInDeck);

        Log.i("nbcalculer", ""+currentGame.getDeck().getNbCard());

        nbCardOfDeck.setText(""+currentGame.getDeck().getNbCard());

        currentGame.addPlayer(player1);
        currentGame.addPlayer(player2);
        currentGame.addPlayer(player3);

        ImageView image = (ImageView) findViewById(R.id.imageDeck);
        image.setOnTouchListener(touchListenerImage);

        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setVisibility(View.INVISIBLE);
        resetButton.setOnClickListener(clickListener);

        autoBouton = (Button) findViewById(R.id.btnAuto);
        //autoBouton.setVisibility(View.INVISIBLE);
        autoBouton.setOnClickListener(clickListener);



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

        Toast.makeText(InteractiveDeckActivity.this, "Début du jeu libre",Toast.LENGTH_SHORT).show();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void createTextView(String value, String signe) {
        layoutHand = (LinearLayout) findViewById(R.id.layout_hand);
        Button buttonHandCards = new Button(this);

        Log.i("Valeur", value);
        Log.i("Signe", signe);

        buttonHandCards.setText(value+" / "+signe);
        buttonHandCards.setWidth(20);

        //buttonHandCards.setBackgroundColor(Red);
        //buttonHandCards.setX(initX);
        //buttonHandCards.setY(initY);

        layoutHand.addView(buttonHandCards);
        //testValue.setVisibility(View.VISIBLE);
    }

    public void displayHand(View v){
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.activity_show_hand, null);
        final GridView handGrid = (GridView) alertLayout.findViewById(R.id.hand_grid);

        HandAdapter handAdapter = new HandAdapter(this);
        Button playerButton = (Button) findViewById(v.getId());
        Player player = currentGame.getPlayerByName((String) playerButton.getText());

        ArrayList<Card> cardsHand = player.getHand().getAllCards();
        for (Card oneCard : cardsHand) {
            handAdapter.addElement(oneCard);
        }

        handGrid.setAdapter(handAdapter);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Ma main");

        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(true);

        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void distribCardAuto(){
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.activity_distrib_auto, null);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        //alert.setTitle("Ma main");

        nbPicker = (NumberPicker)alertLayout.findViewById(R.id.nbPick);
        nbPicker.setMinValue(1);

        nbPicker.setMaxValue((int)Math.floor(currentGame.getDeck().getNbCard()/currentGame.getNbPlayers()));
        nbPicker.setWrapSelectorWheel(false);
        nbPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS); // Désactive clavier numérique


        final Button validBtn = (Button)alertLayout.findViewById(R.id.validNbCard);
        validBtn.setOnClickListener(clickListener);


        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(true);

        dialogDistribCardAuto = alert.create();
        dialogDistribCardAuto.show();


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
                imageCard.setVisibility(View.VISIBLE);
                imageCardBis.setVisibility(View.VISIBLE);
            }
            else if(v.getId() == R.id.btnAuto){
                distribCardAuto();
            }
            else if(v.getId() == R.id.validNbCard){
                currentGame.GiveCardsToPlayerAuto(nbPicker.getValue());
                nbCardOfDeck.setText("" + currentGame.getDeck().getNbCard());
                dialogDistribCardAuto.cancel();

                if(currentGame.getDeck().getNbCard()==0){
                    imageCard.setVisibility(View.INVISIBLE);
                    imageCardBis.setVisibility(View.INVISIBLE);
                }
            }
            else if (v.getId() == R.id.joueur1) {
                displayHand(v);

            } else {
                Button boutonPlayer = (Button) findViewById(v.getId());
                TextView text = (TextView) findViewById(R.id.textView2);
                Player player = currentGame.getPlayerByName((String) boutonPlayer.getText());
                text.setText("Main de : " + player.getNamePlayer()); //Réinitialise le champs
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