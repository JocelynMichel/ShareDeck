package csid.bluetooth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.*;
import 	android.widget.*;
import android.content.*;
import java.io.IOException;
import java.util.*;

public class AcceptThread extends Thread {
    private final BluetoothServerSocket mmServerSocket;
    private final BluetoothAdapter mbluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    public AcceptThread() {
        BluetoothServerSocket tmp = null;
        try {
            UUID MY_UUID = UUID.fromString("fb36491d-7c21-40ef-9f67-a63237b5bbea");
            tmp = mbluetoothAdapter.listenUsingRfcommWithServiceRecord("Serveur", MY_UUID);
        } catch (IOException e) { }
        mmServerSocket = tmp;
    }

    public void run() {
        BluetoothSocket socket = null;
        while (true) {
            try {
                socket = mmServerSocket.accept();
            } catch (IOException e) {
                break;
            }

            if (socket != null) {
                //manageConnectedSocket(socket);
                try {
                    mmServerSocket.close();
                } catch (IOException e) {
                    break;
                }

                break;
            }
        }
    }

    public void cancel() {
        try {
            mmServerSocket.close();
        } catch (IOException e) { }
    }
}