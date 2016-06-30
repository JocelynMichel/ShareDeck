package csid.sharedeck;

import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ChooseGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_choose_game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final String nbCards = (String) getIntent().getSerializableExtra("NbCards") ;

        Log.i("Nbcard", nbCards);

        Button choiceBtnLibre = (Button) findViewById(R.id.choiceButtonLibre);
        Button choiceBtnRegle = (Button) findViewById(R.id.choiceButtonRegle);

        choiceBtnLibre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseGameActivity.this, InteractiveDeckActivity.class);
                intent.putExtra("NbCards",nbCards);
                startActivity(intent);
            }
        });

        choiceBtnRegle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseGameActivity.this, ToDoActivity.class);
                intent.putExtra("NbCards",nbCards);
                startActivity(intent);
            }
        });


    }
}
