package com.scz.kryptowaluty.RecyclerView;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scz.kryptowaluty.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {
    private List<Item> itemList;
    private Context ctx;

    public RecyclerViewAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item, null);
        ctx = parent.getContext();
        return new RecyclerViewHolders(layoutView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {

        holder.name.setText(itemList.get(position).getSkrot());

        String s0 = itemList.get(position).getPrice();

        if (!s0.equals("null")) {

            if (Float.valueOf(s0) < 1) {
                holder.price.setText(itemList.get(position).getPrice());
            } else {
                holder.price.setText(String.format("%.2f", Float.valueOf(s0)).replace(",", "."));
            }
        }


        holder.rank.setText("#rank " + itemList.get(position).getRank());

        holder.shortname.setText(itemList.get(position).getName());


        /*String s1 = itemList.get(position).getOnehourpercent();
        if (!s1.equals("null")) {
            if (Float.valueOf(s1) < 0) {
                holder.onehour.setTextColor(ContextCompat.getColor(ctx, R.color.redd));
            } else {
                holder.onehour.setTextColor(ContextCompat.getColor(ctx, R.color.greenn));
            }
        } else {
            holder.oneday.setTextColor(ContextCompat.getColor(ctx, R.color.black));
        }*/

        String s2 = itemList.get(position).getOnedaypercent();
        if (!s2.equals("null")) {
            if (Float.valueOf(s2) < 0) {
                holder.oneday.setTextColor(ContextCompat.getColor(ctx, R.color.redd));
            } else {
                holder.oneday.setTextColor(ContextCompat.getColor(ctx, R.color.greenn));
            }
            holder.oneday.setText(s2 + "%");
        } else {
            holder.oneday.setTextColor(ContextCompat.getColor(ctx, R.color.black));
        }


        /*String s3 = itemList.get(position).getSevendayspercent();
        if (!s3.equals("null")) {
            if (Float.valueOf(s3) < 0) {
                holder.sevendays.setTextColor(ContextCompat.getColor(ctx, R.color.redd));
            } else {
                holder.sevendays.setTextColor(ContextCompat.getColor(ctx, R.color.greenn));
            }
        } else {
            holder.oneday.setTextColor(ContextCompat.getColor(ctx, R.color.black));
        }*/

        //holder.onehour.setText(s1 + " %");

        //holder.sevendays.setText(s3 + " %");

        Context context = holder.img.getContext();

        String end = itemList.get(position).getName();
        end = end.toLowerCase().replace(" ", "-").replace(".", "");
        String uri = ("https://coincap.io/images/coins/" + end + ".png");
        Picasso.with(context).load(uri).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}