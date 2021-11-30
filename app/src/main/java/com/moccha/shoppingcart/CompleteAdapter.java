package com.moccha.shoppingcart;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CompleteAdapter extends RecyclerView.Adapter<CompleteAdapter.ViewHolder> {
    private String[] titles;
    private int[] prices;
    private int[] imageIds;

    public CompleteAdapter(String[] titles, int[] prices, int[] imageIds) {
        this.titles = titles;
        this.prices = prices;
        this.imageIds = imageIds;
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    @NonNull
    @Override
    public CompleteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_complete, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull CompleteAdapter.ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView image_view = (ImageView) cardView.findViewById(R.id.image_item);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        image_view.setImageDrawable(drawable);
        TextView text_title = (TextView) cardView.findViewById(R.id.item_title);
        TextView text_price = (TextView) cardView.findViewById(R.id.item_price);

        text_title.setText(titles[position]);
        text_price.setText(String.format("Rp %s", String.valueOf(prices[position])));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(@NonNull CardView v) {
            super(v);
            cardView = v;
        }
    }


}
