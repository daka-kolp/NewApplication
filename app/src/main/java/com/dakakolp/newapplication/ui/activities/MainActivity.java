package com.dakakolp.newapplication.ui.activities;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dakakolp.newapplication.R;
import com.dakakolp.newapplication.ui.adapters.ItemAdapter;
import com.dakakolp.newapplication.ui.adapters.models.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewItems;
    private ItemAdapter mItemAdapter;
    private List<Item> mItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*        setTheme(R.style.AppTheme);*/
        setContentView(R.layout.activity_main);

        mItemList = getItemList();

        mRecyclerViewItems = findViewById(R.id.recycler_view_items);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            mRecyclerViewItems.setLayoutManager(linearLayoutManager);
        } else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            mRecyclerViewItems.setLayoutManager(gridLayoutManager);
        }

        mItemAdapter = new ItemAdapter(mItemList, new ItemAdapter.CardViewListener() {
            @Override
            public void onClickCardView(int position) {

            }
        });

        mRecyclerViewItems.setAdapter(mItemAdapter);
    }

    private List<Item> getItemList (){
        List<Item> items = new ArrayList<>();
        String[] arrayStr = getResources().getStringArray(R.array.items);
        for (String str : arrayStr) {
            items.add(new Item(str));
        }
        return items;
    }
}
