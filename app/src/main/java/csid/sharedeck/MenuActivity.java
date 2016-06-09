package csid.sharedeck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.TranslateAnimation;
import android.widget.*;
import android.content.*;
import android.view.*;
import android.view.View.*;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final Button loginButton = (Button) findViewById(R.id.button2);
        loginButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });


        ImageView monImage = (ImageView) findViewById(R.id.image1);

        TranslateAnimation animationTranslation = new TranslateAnimation(0, 100, 0, 100);
        animationTranslation.setFillAfter(true);
        animationTranslation.setDuration(10000);
        monImage.startAnimation(animationTranslation);
    }
}



