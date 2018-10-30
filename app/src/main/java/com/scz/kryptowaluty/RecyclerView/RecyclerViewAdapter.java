package com.scz.kryptowaluty.RecyclerView;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scz.kryptowaluty.R;
import com.scz.kryptowaluty.UrlApi;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> implements UrlApi {
    private List<Item> itemList;
    private Context ctx;

    public RecyclerViewAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }


    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_item, null);
        ctx = parent.getContext();
        return new RecyclerViewHolders(layoutView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {

        holder.name.setText(itemList.get(position).getSkrot());

        String s0 = itemList.get(position).getPrice();

        if (!s0.equals("null")) {

            if (Float.valueOf(s0) < 1) {
                String priceText = String.format("%.7f", Float.valueOf(s0))
                        .replace(",", ".") + " PLN";
                holder.price.setText(priceText);
            } else {
                String priceText = String.format("%.2f", Float.valueOf(s0))
                        .replace(",", ".") + " PLN";
                holder.price.setText(priceText);
            }
        }

        String rankText = "#rank " + itemList.get(position).getRank();

        holder.rank.setText(rankText);

        holder.shortname.setText(itemList.get(position).getName());

        String s2 = itemList.get(position).getOnedaypercent();
        if (!s2.equals("null")) {
            if (Float.valueOf(s2) < 0) {
                holder.oneday.setTextColor(ContextCompat.getColor(ctx, R.color.redd));
            } else {
                holder.oneday.setTextColor(ContextCompat.getColor(ctx, R.color.greenn));
            }
            String oneDayText = s2 + "%";
            holder.oneday.setText(oneDayText);
        } else {
            holder.oneday.setTextColor(ContextCompat.getColor(ctx, R.color.black));
        }

        Context context = holder.img.getContext();

        String end = itemList.get(position).getName();
        end = end.toLowerCase().replace(" ", "-")
                .replace(".", "");
        String uri = (imageUrl + end + ".png");
        Picasso
                .with(context)
                .load(uri)
                .resize(256, 256)
                .onlyScaleDown()
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}