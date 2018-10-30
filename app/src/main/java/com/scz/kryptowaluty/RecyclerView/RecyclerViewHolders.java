package com.scz.kryptowaluty.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.scz.kryptowaluty.R;


class RecyclerViewHolders extends RecyclerView.ViewHolder {
    TextView name;
    TextView price;
    TextView shortname;
    TextView oneday;
    TextView rank;
    ImageView img;

    RecyclerViewHolders(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        price = itemView.findViewById(R.id.price);
        shortname = itemView.findViewById(R.id.shortname);
        oneday = itemView.findViewById(R.id.onedaypercent);
        rank = itemView.findViewById(R.id.rank);
        img = itemView.findViewById(R.id.img);
    }
}