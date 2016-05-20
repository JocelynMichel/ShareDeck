package csid.sharedeck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.*;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.util.*;

public class InteractiveDeckActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactive_deck);

       ImageView image = (ImageView) findViewById(R.id.imageDeck);
       image.setOnTouchListener(touchListenerBouton1);
       // image.setOnDragListener(test);
    }



    private OnTouchListener touchListenerBouton1 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int initX = 0 ;
            int initY = 0 ;

            switch(event.getAction())
            {
               /* case MotionEvent.ACTION_DOWN:
                    Log.i("case" , "Action_Down");
                    initX = (int) v.getX();
                    initY = (int) v.getY();
                    break;*/
                case MotionEvent.ACTION_MOVE:
                    Log.i("case" , "Action_Move");
                    v.setX(event.getX() + (v.getX()-(v.getWidth()  / 2)));
                    v.setY(event.getY() + (v.getY()-(v.getHeight()  / 2)));
                    //TranslateAnimation animation = new TranslateAnimation(0,(int)event.getX(),0,(int)event.getY() );
                    //animation.setFillAfter(true);
                    //v.startAnimation(animation);
                    break;
                /*case MotionEvent.ACTION_UP:
                    Log.i("case" , "Action_up");
                    v.setX(initX);
                    v.setY(initY);
                    break;*/
            }
            return true;
        }
    };
}
