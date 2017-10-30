package com.transindia.tico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Arpan on 28/10/2017.
 */

public class PaymetFailuerActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView btn_login;
    private EditText user_name_edit,password_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InitView();
    }

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
               // LoginFunction();
                break;


        }

    }


}
