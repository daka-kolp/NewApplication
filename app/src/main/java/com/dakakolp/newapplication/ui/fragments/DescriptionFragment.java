package com.dakakolp.newapplication.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dakakolp.newapplication.R;
import com.dakakolp.newapplication.ui.adapters.models.Item;
import com.dakakolp.newapplication.utils.ConstantManager;
import com.squareup.picasso.Picasso;

public class DescriptionFragment extends Fragment {

    private Item mItem;
    private ImageView mImage;
    private TextView mTitle;
    private TextView mSubtitle;
    private TextView mDescription;

    public DescriptionFragment() {
        // Required empty public constructor
    }

    public static DescriptionFragment newInstance(Item item) {
        DescriptionFragment fragment = new DescriptionFragment();
        Bundle args = new Bundle();
        args.putParcelable(ConstantManager.ITEM_ARG, item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mItem = getArguments().getParcelable(ConstantManager.ITEM_ARG);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);

        mImage = view.findViewById(R.id.desc_image_item);
        mTitle = view.findViewById(R.id.desc_title);
        mSubtitle = view.findViewById(R.id.desc_subtitle);
        mDescription = view.findViewById(R.id.desc_description);

        setData(mItem);

        return view;
    }

    private void setData(Item item) {
        if(item == null) return;
        Picasso.get().load(item.getImage()).into(mImage);
        mTitle.setText(item.getTitle());
        mSubtitle.setText(item.getSubtitle());
        mDescription.setText(item.getDescription());
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
