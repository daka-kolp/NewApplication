package com.dakakolp.newapplication.ui.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dakakolp.newapplication.NewApplicationApp;
import com.dakakolp.newapplication.R;
import com.dakakolp.newapplication.ui.adapters.ItemAdapter;
import com.dakakolp.newapplication.ui.adapters.models.Item;
import com.dakakolp.newapplication.ui.fragments.dialogs.DialogDeleteUserProfileFragment;
import com.dakakolp.newapplication.utils.ConstantManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements DialogDeleteUserProfileFragment.OnDialogExitClickListener {

    private RecyclerView mRecyclerViewItems;
    private ItemAdapter mItemAdapter;
    private List<Item> mItemList;

    private FloatingActionButton mFloatingExitActionButton;
    private NewApplicationApp mApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mApp = NewApplicationApp.getApplicationInstance();

        initRecyclerView();
        initFloatActionButton();
    }



    private void initRecyclerView() {
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
                Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
                intent.putExtra(ConstantManager.ITEM_EXTRA, mItemList.get(position));
                startActivity(intent);
            }
        });
        mRecyclerViewItems.setAdapter(mItemAdapter);
    }

    private List<Item> getItemList() {
        List<Item> items = new ArrayList<>();
        String[] arrayStr = getResources().getStringArray(R.array.items);
        for (String str : arrayStr) {
            items.add(new Item(str));
        }
        return items;
    }

    private void initFloatActionButton() {
        mFloatingExitActionButton = findViewById(R.id.float_exit_button);

        mFloatingExitActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        DialogDeleteUserProfileFragment dialogFragment = DialogDeleteUserProfileFragment.newInstance();
        dialogFragment.show(getSupportFragmentManager(), null);
    }


    @Override
    public void onClickCancel() {
    }

    @Override
    public void onClickDeleteUserProfile() {
        mApp.getPrivatePreferenceManager().deleteUserData();
        Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(intent);
        finish();
    }

}
