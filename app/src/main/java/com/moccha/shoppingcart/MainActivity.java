package com.moccha.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    private CardView drinks, snacks, foods, topUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drinks = findViewById(R.id.drinks_menu);
        snacks = findViewById(R.id.snacks_menu);
        foods = findViewById(R.id.foods_menu);
        topUp = findViewById(R.id.topUp_menu);
        LinearLayout myOrder = findViewById(R.id.my_order);

        myOrder.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MyOrderActivity.class);
            startActivity(intent);
        });

        drinks.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ItemListActivity.class);
            String value = "drink";
            intent.putExtra("choice", value);
            startActivity(intent);
        });

        foods.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ItemListActivity.class);
            String value = "food";
            intent.putExtra("choice", value);
            startActivity(intent);
        });

        snacks.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ItemListActivity.class);
            String value = "snack";
            intent.putExtra("choice", value);
            startActivity(intent);
        });

        topUp.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "top up successfully", Toast.LENGTH_SHORT).show());
    }
}