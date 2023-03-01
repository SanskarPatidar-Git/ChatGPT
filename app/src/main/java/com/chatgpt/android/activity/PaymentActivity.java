package com.chatgpt.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chatgpt.android.R;
import com.chatgpt.android.SharedPref;
import com.chatgpt.android.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {

    ActivityPaymentBinding binding;
    float paymentValue=0.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.radioLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             setLayout1();
            }
        });
        binding.radioLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setLayout2();
            }
        });

        binding.radiobutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setLayout1();
            }
        });
        binding.radiobutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setLayout2();
            }
        });

        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(paymentValue == 0.0f){
                    Toast.makeText(PaymentActivity.this, "Please select payment procedure", Toast.LENGTH_SHORT).show();
                }else{

                    SharedPref.setAppIsOpened(PaymentActivity.this);

                    Intent intent =new Intent(PaymentActivity.this,ChatActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setLayout1(){
        binding.radioLayout1.setBackgroundResource(R.drawable.edit_text_border_blue);
        binding.radioLayout2.setBackgroundResource(R.drawable.edit_text_border_grey);

        binding.radiobutton1.setChecked(true);
        binding.radiobutton2.setChecked(false);

        paymentValue = 12.99f;
    }
    private void setLayout2(){
        binding.radioLayout2.setBackgroundResource(R.drawable.edit_text_border_blue);
        binding.radioLayout1.setBackgroundResource(R.drawable.edit_text_border_grey);

        binding.radiobutton1.setChecked(false);
        binding.radiobutton2.setChecked(true);

        paymentValue = 4.99f;
    }
}