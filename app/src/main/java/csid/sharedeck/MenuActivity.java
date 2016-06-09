package csid.sharedeck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        final Button TestDeckButton = (Button) findViewById(R.id.button3);
        TestDeckButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, InteractiveDeckActivity.class);
                startActivity(intent);
            }
        });

    }
}
