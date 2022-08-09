package com.example.barterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class buy_or_sell_class extends AppCompatActivity {

    Button buy,sell;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_or_sell);

        buy = findViewById(R.id.buy_btn);
        sell = findViewById(R.id.sell_btn);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(buy_or_sell_class.this, buy_recycler_homepage.class);  //from and to
                startActivity(intent);                                                             //         -----set page
            }
        });

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(buy_or_sell_class.this, upload_details.class);  //from and to
                startActivity(intent);                                                   //         -----set page
            }
        });


    }
}
