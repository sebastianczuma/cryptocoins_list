package com.scz.kryptowaluty.RecyclerView;

public class Item {
    private String name;
    private String rank;
    private String shortname;
    private String onedaypercent;
    private String price;

    public Item(String name, String rank, String price, String shortname, String onedaypercent) {
        this.name = name;
        this.rank = rank;
        this.price = price;
        this.shortname = shortname;
        this.onedaypercent = onedaypercent;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSkrot() {
        return shortname;
    }

    public String getOnedaypercent() {
        return onedaypercent;
    }

    public void setOnedaypercent(String onedaypercent) {
        this.onedaypercent = onedaypercent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
