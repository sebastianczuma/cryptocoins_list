package com.scz.kryptowaluty;

import android.app.ProgressDialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;

import com.scz.kryptowaluty.RecyclerView.Item;
import com.scz.kryptowaluty.RecyclerView.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UrlApi {
    static JSONArray jarr;
    RecyclerView rView;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#d4b22a'>" + getString(R.string.app_name) + "</font>"));

        pDialog = ProgressDialog.show(this, "Wczytywanie", "Pobieram dane...");

        jarr = new JSONArray();

        testDownload.getCrypto(this);

        GridLayoutManager lLayout = new GridLayoutManager(this, 1);
        rView = findViewById(R.id.recycler_view);
        rView.setNestedScrollingEnabled(false);

        // Recycle View setup
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        SpaceItemDecoration dividerItemDecoration = new SpaceItemDecoration(20);
        rView.addItemDecoration(dividerItemDecoration);

    }

    public void updateRR() {
        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(getAllItemList());
        rView.setAdapter(rcAdapter);
    }

    private List<Item> getAllItemList() {
        List<Item> allItems = new ArrayList<>();

        try {
            for (int i = 0; i < jarr.length(); i++) {
                JSONObject jsonObject = new JSONObject(jarr.get(i).toString());
                allItems.add(new Item(
                        jsonObject.get("name").toString(),
                        jsonObject.get("rank").toString(),
                        jsonObject.get("price_pln").toString(),
                        jsonObject.get("symbol").toString(),
                        jsonObject.get("percent_change_24h").toString()));
            }
        } catch (JSONException e) {
            Log.e("JSONException", "msg: " + e);
        }
        pDialog.dismiss();

        return allItems;
    }

    private class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        private final int space;

        SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect,
                                   View view,
                                   RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.top = space;
            outRect.left = space;
        }
    }
}
