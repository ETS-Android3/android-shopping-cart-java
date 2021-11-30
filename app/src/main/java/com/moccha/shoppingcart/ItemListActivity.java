package com.moccha.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Intent intent = getIntent();
        String choice = intent.getStringExtra("choice");

        LinearLayout myOrder = findViewById(R.id.my_order);
        myOrder.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MyOrderActivity.class);
            startActivity(i);
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        if (choice.equals("drink")) {
            String[] drinkTitles = new String[Item.drinks.length];
            for (int i = 0; i < drinkTitles.length; i++) drinkTitles[i] = Item.drinks[i].getName();

            int[] drinkPrices = new int[Item.drinks.length];
            for (int i = 0; i < drinkPrices.length; i++) drinkPrices[i] = Item.drinks[i].getPrice();

            int[] drinkImages = new int[Item.drinks.length];
            for (int i = 0; i < drinkImages.length; i++) drinkImages[i] = Item.drinks[i].getImg();

            ItemAdapter adapter = new ItemAdapter(drinkTitles, drinkPrices, drinkImages);
            recyclerView.setAdapter(adapter);

            adapter.setListener(position -> {
                Intent intent1 = new Intent(getApplicationContext(), ItemOrderActivity.class);
                intent1.putExtra(ItemOrderActivity.ORDER_ITEM_ID, position);
                String value = "drink";
                intent1.putExtra("choice", value);
                startActivity(intent1);
            });
        }
        else if (choice.equals("food")) {
            String[] foodTitles = new String[Item.foods.length];
            for (int i = 0; i < foodTitles.length; i++) {
                foodTitles[i] = Item.foods[i].getName();
            }

            int[] foodPrices = new int[Item.foods.length];
            for (int i = 0; i < foodPrices.length; i++) {
                foodPrices[i] = Item.foods[i].getPrice();
            }

            int[] foodImages = new int[Item.foods.length];
            for (int i = 0; i < foodImages.length; i++) {
                foodImages[i] = Item.foods[i].getImg();
            }

            ItemAdapter adapter = new ItemAdapter(foodTitles, foodPrices, foodImages);
            recyclerView.setAdapter(adapter);

            adapter.setListener(new ItemAdapter.Listener() {
                @Override
                public void onClick(int position) {
                    Intent intent = new Intent(getApplicationContext(), ItemOrderActivity.class);
                    intent.putExtra(ItemOrderActivity.ORDER_ITEM_ID, position);
                    String value = "food";
                    intent.putExtra("choice", value);
                    startActivity(intent);
                }
            });
        }
        else if (choice.equals("snack")) {
            String[] snackTitles = new String[Item.snacks.length];
            for (int i = 0; i < snackTitles.length; i++) {
                snackTitles[i] = Item.snacks[i].getName();
            }

            int[] snackPrices = new int[Item.snacks.length];
            for (int i = 0; i < snackPrices.length; i++) {
                snackPrices[i] = Item.snacks[i].getPrice();
            }

            int[] snackImages = new int[Item.snacks.length];
            for (int i = 0; i < snackImages.length; i++) {
                snackImages[i] = Item.snacks[i].getImg();
            }

            ItemAdapter adapter = new ItemAdapter(snackTitles, snackPrices, snackImages);
            recyclerView.setAdapter(adapter);

            adapter.setListener(new ItemAdapter.Listener() {
                @Override
                public void onClick(int position) {
                    Intent intent = new Intent(getApplicationContext(), ItemOrderActivity.class);
                    intent.putExtra(ItemOrderActivity.ORDER_ITEM_ID, position);
                    String value = "snack";
                    intent.putExtra("choice", value);
                    startActivity(intent);
                }
            });
        }


    }
}