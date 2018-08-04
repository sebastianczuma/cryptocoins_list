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
    TextView onehour;
    TextView oneday;
    TextView sevendays;
    TextView rank;
    ImageView img;

    RecyclerViewHolders(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        price = itemView.findViewById(R.id.price);
        shortname = itemView.findViewById(R.id.shortname);
        //onehour = itemView.findViewById(R.id.onehourpercent);
        oneday = itemView.findViewById(R.id.onedaypercent);
        //sevendays = itemView.findViewById(R.id.sevendayspercent);
        rank = itemView.findViewById(R.id.rank);
        img = itemView.findViewById(R.id.img);
    }
}