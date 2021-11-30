package com.moccha.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moccha.shoppingcart.model.Item;

public class CompleteOrderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);

        LinearLayout mainMenu = findViewById(R.id.main_menu);
        mainMenu.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        String[] orderTitles = new String[Item.orderItems.length];
        for (int i = 0; i < orderTitles.length; i++) {
            orderTitles[i] = Item.orderItems[i].getName();
        }
        int[] orderPrices = new int[Item.orderItems.length];
        for (int i = 0; i < orderPrices.length; i++) {
            orderPrices[i] = Item.orderItems[i].getPrice();
        }
        int[] orderImages = new int[Item.orderItems.length];
        for (int i = 0; i < orderImages.length; i++) {
            orderImages[i] = Item.orderItems[i].getImg();
        }

        CompleteAdapter adapter = new CompleteAdapter(orderTitles, orderPrices, orderImages);
        recyclerView.setAdapter(adapter);
    }
}