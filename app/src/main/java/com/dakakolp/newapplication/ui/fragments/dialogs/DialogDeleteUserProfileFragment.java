package com.dakakolp.newapplication.ui.fragments.dialogs;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class DialogDeleteUserProfileFragment extends DialogFragment {

    private OnDialogExitClickListener mListener;

    public interface OnDialogExitClickListener {
        void onClickCancel();
        void onClickDeleteUserProfile();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDialogExitClickListener) {
            mListener = (OnDialogExitClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRecipeFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public static DialogDeleteUserProfileFragment newInstance() {
        DialogDeleteUserProfileFragment fragment = new DialogDeleteUserProfileFragment();
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Do you want to delete your profile?")
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onClickCancel();
                    }
                })
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onClickDeleteUserProfile();
                    }
                });
        return builder.create();
    }

}
