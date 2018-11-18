package com.dakakolp.newapplication.ui.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String image = bundle.getString(ConstantManager.IMAGE_URI_EXTRA);
            String title = bundle.getString(ConstantManager.TITLE_EXTRA);
            String subtitle = bundle.getString(ConstantManager.SUBTITLE_EXTRA);
            String description = bundle.getString(ConstantManager.DESCRIPTION_EXTRA);
            Item item = new Item(
                    Uri.parse(image),
                    title,
                    subtitle,
                    description
            );
            startFragment(item);
        }
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
