package com.dakakolp.newapplication.ui.fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialogDeleteUserProfileFragment extends DialogFragment {

    public interface OnDialogExitClickListener {
        void onClickCancel();

        void onClickDeleteUserProfile();
    }

    private OnDialogExitClickListener listener;

    public void setListener(OnDialogExitClickListener listener) {
        this.listener = listener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Do you want to delete your profile?")
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onClickCancel();
                    }
                })
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onClickDeleteUserProfile();
                    }
                });
        return builder.create();
    }

}
