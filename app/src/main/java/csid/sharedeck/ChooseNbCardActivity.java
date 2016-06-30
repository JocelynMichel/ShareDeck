package csid.sharedeck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ChooseNbCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_choose_nb_card);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button nbButton32 = (Button) findViewById(R.id.nbButton32);
        Button nbButton52 = (Button) findViewById(R.id.nbButton52);

        nbButton32.setOnClickListener(clickListener);
        nbButton52.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Button chooseButton = (Button)findViewById(v.getId());
            Intent intent = new Intent(ChooseNbCardActivity.this, ChooseGameActivity.class);
            intent.putExtra("NbCards",chooseButton.getText()+"");
            startActivity(intent);
        }

    } ;

}
