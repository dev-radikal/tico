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

public class PaymentSuccessActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        InitView();
    }

    private void InitView() {


    }

    @Override
    public void onClick(View v) {

    }


}
