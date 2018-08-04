package com.scz.kryptowaluty.RecyclerView;

public class Item {
    private String name;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    private String rank;
    private String shortname;
    private String onehourpercent;
    private String onedaypercent;
    private String sevendayspercent;
    private String price;

    public Item() {
    }

    public Item(String name, String rank, String price, String shortname, String onehourpercent, String onedaypercent, String sevendayspercent) {
        this.name = name;
        this.rank = rank;
        this.price = price;
        this.shortname = shortname;
        this.onehourpercent = onehourpercent;
        this.onedaypercent = onedaypercent;
        this.sevendayspercent = sevendayspercent;
    }

    public String getSkrot() {
        return shortname;
    }

    public void setSkrot(String skrot) {
        this.shortname = skrot;
    }

    public String getOnehourpercent() {
        return onehourpercent;
    }

    public void setOnehourpercent(String onehourpercent) {
        this.onehourpercent = onehourpercent;
    }

    public String getOnedaypercent() {
        return onedaypercent;
    }

    public void setOnedaypercent(String onedaypercent) {
        this.onedaypercent = onedaypercent;
    }

    public String getSevendayspercent() {
        return sevendayspercent;
    }

    public void setSevendayspercent(String sevendayspercent) {
        this.sevendayspercent = sevendayspercent;
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
