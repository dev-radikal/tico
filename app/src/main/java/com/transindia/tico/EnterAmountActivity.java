package com.transindia.tico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Arpan on 28/10/2017.
 */

public class EnterAmountActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView btn_next,amount_txt;
    ImageView delete_img;
    LinearLayout layout1,layout2,layout3,layout4,layout5,layout6,layout7,layout8,layout9,layout0;
    String amount_str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_amount);

        InitView();
    }

    private void InitView() {
        btn_next = (TextView)findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
        amount_txt = (TextView)findViewById(R.id.amount_txt);

        layout1 = (LinearLayout)findViewById(R.id.layout1);
        layout1.setOnClickListener(this);
        layout2 = (LinearLayout)findViewById(R.id.layout2);
        layout2.setOnClickListener(this);
        layout3 = (LinearLayout)findViewById(R.id.layout3);
        layout3.setOnClickListener(this);
        layout4 = (LinearLayout)findViewById(R.id.layout4);
        layout4.setOnClickListener(this);
        layout5 = (LinearLayout)findViewById(R.id.layout5);
        layout5.setOnClickListener(this);

        layout6 = (LinearLayout)findViewById(R.id.layout6);
        layout6.setOnClickListener(this);
        layout7 = (LinearLayout)findViewById(R.id.layout7);
        layout7.setOnClickListener(this);
        layout8 = (LinearLayout)findViewById(R.id.layout8);
        layout8.setOnClickListener(this);
        layout9 = (LinearLayout)findViewById(R.id.layout9);
        layout9.setOnClickListener(this);
        layout0 = (LinearLayout)findViewById(R.id.layout0);
        layout0.setOnClickListener(this);

        delete_img = (ImageView)findViewById(R.id.delete_img);
        delete_img.setOnClickListener(this);

        //user_name_edit = (EditText)findViewById(R.id.user_name_edit);
        //password_edit =(EditText)findViewById(R.id.password_edit);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_next:
                Intent intent = new Intent(EnterAmountActivity.this,EnterPinActivity.class);
                startActivity(intent);
                break;
            case R.id.delete_img:
                StringRemove();
                break;

            case R.id.layout1:
                amount_str=amount_str+"1";
                amount_txt.setText(amount_str);
                break;

            case R.id.layout2:
                amount_str=amount_str+"2";
                amount_txt.setText(amount_str);
                break;

            case R.id.layout3:
                amount_str=amount_str+"3";
                amount_txt.setText(amount_str);
                break;

            case R.id.layout4:
                amount_str=amount_str+"4";
                amount_txt.setText(amount_str);
                break;
            case R.id.layout5:
                amount_str=amount_str+"5";
                amount_txt.setText(amount_str);
            break;

            case R.id.layout6:
                amount_str=amount_str+"6";
                amount_txt.setText(amount_str);
                break;
            case R.id.layout7:
                amount_str=amount_str+"7";
                amount_txt.setText(amount_str);
                break;
            case R.id.layout8:
                amount_str=amount_str+"8";
                amount_txt.setText(amount_str);
                break;
            case R.id.layout9:
                amount_str=amount_str+"9";
                amount_txt.setText(amount_str);
                break;
            case R.id.layout0:
                amount_str=amount_str+"0";
                amount_txt.setText(amount_str);
                break;





        }

    }

    private void StringRemove() {
        if(amount_str.length()>0){
            amount_str = removeLastChar(amount_str);
            amount_txt.setText(amount_str);
        }

    }

    public String removeLastChar(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, s.length()-1);
    }


}
