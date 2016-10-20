package com.example.john.listviewtest3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;



import static com.example.john.listviewtest3.MainActivity.FILENAME;



/**
 * Created by John on 10/17/2016.
 */

public class SelectVersionDialogFragment extends DialogFragment {

    String path;
    int checked;
    int version = 0;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        path = getTag();
        checked = getVersion();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Set the dialog title
        builder.setTitle(R.string.select_version)
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setSingleChoiceItems(R.array.versions, checked, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        version = which;
                    }
                })
                // Set the action buttons //The problem is right here, id = -1 always
                .setPositiveButton(R.string.set, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        saveVersion(version);

                        //MainActivity.someHow();
                        ((MainActivity)getActivity()).setAnAVersion();

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }

    public int getVersion(){
        File file = new File(path, FILENAME);
        int length = (int) file.length();
        byte[] bytes = new byte[length];

        try {
            FileInputStream streamIn = new FileInputStream(file);
            streamIn.read(bytes);
            streamIn.close();

            String contents = new String(bytes);
            return Integer.parseInt(contents.trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void saveVersion(int version){
        File file = new File(path, FILENAME);
        FileOutputStream streamOut;
        String fileData;

        try {
            streamOut = new FileOutputStream(file, false);
            fileData = String.valueOf(version);
            fileData.trim();
            streamOut.write(fileData.getBytes());
            streamOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

