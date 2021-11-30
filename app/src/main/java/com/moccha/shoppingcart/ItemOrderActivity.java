package com.moccha.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ItemOrderActivity extends AppCompatActivity {

    public static final String ORDER_ITEM_ID = "itemId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_order);

        LinearLayout myOrder = findViewById(R.id.my_order);
        myOrder.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MyOrderActivity.class));
        });

        Button orderMore = findViewById(R.id.orderMoreBtn);
        Button order = findViewById(R.id.orderBtn);

        orderMore.setOnClickListener(v -> { finish(); });
        order.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Order Successfully", Toast.LENGTH_SHORT).show());

        int itemId = (Integer) getIntent().getExtras().get(ORDER_ITEM_ID);
        String choice = (String) getIntent().getStringExtra("choice");
        Log.d("choice", "onCreate: " + choice);

        if (choice.equals("drink")) {
            String itemTitle = Item.drinks[itemId].getName();
            int itemPrice = Item.drinks[itemId].getPrice();
            int itemImg = Item.drinks[itemId].getImg();

            TextView titleTv = (TextView) findViewById(R.id.item_title);
            TextView priceTv = (TextView) findViewById(R.id.item_price);
            ImageView imageV = (ImageView) findViewById(R.id.image_item);
            titleTv.setText(itemTitle);
            priceTv.setText(String.format("RP %s", String.valueOf(itemPrice)));
            imageV.setImageDrawable(ContextCompat.getDrawable(this, itemImg));
        } else if (choice.equals("food")) {
            String itemTitle = Item.foods[itemId].getName();
            int itemPrice = Item.foods[itemId].getPrice();
            int itemImg = Item.foods[itemId].getImg();

            TextView titleTv = (TextView) findViewById(R.id.item_title);
            TextView priceTv = (TextView) findViewById(R.id.item_price);
            ImageView imageV = (ImageView) findViewById(R.id.image_item);
            titleTv.setText(itemTitle);
            priceTv.setText(String.format("RP %s", String.valueOf(itemPrice)));
            imageV.setImageDrawable(ContextCompat.getDrawable(this, itemImg));
        } else if (choice.equals("snack")) {
            String itemTitle = Item.snacks[itemId].getName();
            int itemPrice = Item.snacks[itemId].getPrice();
            int itemImg = Item.snacks[itemId].getImg();

            TextView titleTv = (TextView) findViewById(R.id.item_title);
            TextView priceTv = (TextView) findViewById(R.id.item_price);
            ImageView imageV = (ImageView) findViewById(R.id.image_item);
            titleTv.setText(itemTitle);
            priceTv.setText(String.format("RP %s", String.valueOf(itemPrice)));
            imageV.setImageDrawable(ContextCompat.getDrawable(this, itemImg));
        }


    }
}