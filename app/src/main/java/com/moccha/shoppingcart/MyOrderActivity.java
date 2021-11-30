package com.moccha.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moccha.shoppingcart.model.Item;
import com.moccha.shoppingcart.model.ItemData;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        ImageView back_btn = findViewById(R.id.back_button);
        back_btn.setOnClickListener(v -> {
            finish();
        });

        LinearLayout completeOrder = findViewById(R.id.order_complete);
        completeOrder.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), CompleteOrderActivity.class);
            startActivity(i);
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        items.addAll(ItemData.getListOrder());
        OrderAdapter adapter = new OrderAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}