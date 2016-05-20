package csid.sharedeck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.BluetoothAdapter;
import android.view.View;
import 	android.widget.*;
import android.content.*;
import 	android.widget.*;
import android.bluetooth.*;
import java.io.*;
import java.util.*;

import csid.bluetooth.*;


public class TestActivity extends AppCompatActivity {
    private final static int REQUEST_CODE_ENABLE_BLUETOOTH = 0;
    private Set<BluetoothDevice> devices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null)
            Toast.makeText(TestActivity.this, "Pas de Bluetooth",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(TestActivity.this, "Avec Bluetooth", Toast.LENGTH_SHORT).show();

        try {
            if (!bluetoothAdapter.isEnabled()) {
                Intent enableBlueTooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBlueTooth, REQUEST_CODE_ENABLE_BLUETOOTH);
            }
        } catch (NullPointerException e) { }



        final Button loginButton = (Button) findViewById(R.id.Jouer);
        try {
            loginButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                    devices = bluetoothAdapter.getBondedDevices();
                    for (BluetoothDevice blueDevice : devices) {
                        Toast.makeText(TestActivity.this, "Device = " + blueDevice.getName(), Toast.LENGTH_SHORT).show();
                    }
                    //ConnectThread connect = new ConnectThread();

                }
            });
        } catch (NullPointerException e) { }

    }




}
