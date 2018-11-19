package com.dakakolp.newapplication.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.dakakolp.newapplication.R;
import com.dakakolp.newapplication.ui.adapters.models.Item;
import com.dakakolp.newapplication.ui.fragments.DescriptionFragment;
import com.dakakolp.newapplication.utils.ConstantManager;

public class DescriptionActivity extends BaseActivity {

    private DescriptionFragment mDescriptionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Intent intent = getIntent();
        getIntentFromMainActivity(intent);

    }

    private void getIntentFromMainActivity(Intent intent) {
        Item item = intent.getParcelableExtra(ConstantManager.ITEM_EXTRA);
        startFragment(item);
    }

    private void startFragment(Item item) {
        mDescriptionFragment = DescriptionFragment.newInstance(item);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.desc_fragment_container, mDescriptionFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

}
