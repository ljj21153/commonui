package com.ljj.commonui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import com.ljj.commonui.dialog.AlertDialogs;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add a radio button list
        String[] animals = {"horse", "cow", "camel", "sheep", "goat"};
        int checkedItem = 1; // cow
        AlertDialogs.dialogForMulSelect(this, animals, new boolean[]{false, true, true, true, true},
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Log.d(TAG, "toggle :" + which + " " + isChecked);
                    } },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "ok btn" );

                    } },
                null, "Choose an animal");


        AlertDialogs.dialogForSingleSelect(this, animals, checkedItem,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "click :" + which );
                    } },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "ok btn " );
                    } },
                null, "Choose an animal");
    }

    void dialogForListSelection() {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an animal");

        // add a radio button list
        String[] animals = {"horse", "cow", "camel", "sheep", "goat"};
        int checkedItem = 1; // cow
        builder.setSingleChoiceItems(animals, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user checked an item
                Log.d("aatt", "adsfasdf :" + which);
            }
        });
        builder.setMultiChoiceItems(animals, new boolean[]{true, true, true, true, true}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Log.d("aatt", "adsfasdf :" + which + " " + isChecked);
            }
        });

        // add OK and Cancel buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("aatt", "adsfasdf");
            }
        });
        builder.setNegativeButton("Cancel", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
