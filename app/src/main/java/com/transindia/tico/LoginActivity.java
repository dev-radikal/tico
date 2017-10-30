package com.transindia.tico;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Arpan on 28/10/2017.
 */

public class LoginActivity  extends AppCompatActivity implements View.OnClickListener {

    private TextView btn_login;
    private EditText user_name_edit,password_edit;

    private static final String HOST = "ec2-54-68-124-204.us-west-2.compute.amazonaws.com";
    private static final int PORT = 2214;
    private String line="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InitView();
        ConnectionSocket();



    }

    private void ConnectionSocket() {

        new Thread() {
            @Override
            public void run() {
                try {
                    // Create Socket instance
                    Socket socket = new Socket(HOST, PORT);
                    // Get input buffer
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    line = br.readLine();
                    br.close();
                } catch (UnknownHostException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(0);
            }
        }.start();




    }
    // Define Handler object
    private Handler handler = new Handler() {
        @Override
        // When there is message, execute this method
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // Update UI

            Log.i("PDA", "----->" + line);
        }
    };


    private void InitView() {
        btn_login = (TextView)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        user_name_edit = (EditText)findViewById(R.id.user_name_edit);
        password_edit =(EditText)findViewById(R.id.password_edit);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_login:
                LoginFunction();
                break;


        }

    }

    private void LoginFunction() {
        Intent intent = new Intent(LoginActivity.this,EnterAmountActivity.class);
        startActivity(intent);
    }
}
