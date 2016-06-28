package com.ieasy360.app.upgrade;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;


public class UpdateDialog extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.newUpdateAvailable);
        builder.setMessage(getArguments().getString(UpdateConstants.APK_UPDATE_CONTENT))
                .setPositiveButton(R.string.dialogPositiveButton, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        goToDownload();
                        dismiss();
                    }
                })
                .setNegativeButton(R.string.dialogNegativeButton, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }


    private void goToDownload() {
    	Intent intent=new Intent(getActivity().getApplicationContext(),DownloadService.class);
    	intent.putExtra(UpdateConstants.APK_DOWNLOAD_URL, getArguments().getString(UpdateConstants.APK_DOWNLOAD_URL));
        intent.putExtra(UpdateConstants.APK_IS_AUTO_INSTALL, getArguments().getBoolean(UpdateConstants.APK_IS_AUTO_INSTALL));
    	getActivity().startService(intent);
    }
}
