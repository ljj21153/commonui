package com.ljj.commonui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

public class AlertDialogs {

    private static final String TAG  = "AlertDialogs";

    public static void dialogForSingleSelect(Context c, String[] items, int selectedIndex,
                                             DialogInterface.OnClickListener listener,
                                             DialogInterface.OnClickListener onOkListener,
                                             DialogInterface.OnClickListener onCancelListener,
                                             String title) {
        dialogForListSelection(c, items, true, selectedIndex, null,
            listener, null, onOkListener, onCancelListener,title);
    }

    public static void dialogForMulSelect(Context c, String[] items, boolean []selectedIndexs ,
                                          DialogInterface.OnMultiChoiceClickListener listener,
                                          DialogInterface.OnClickListener onOkListener,
                                          DialogInterface.OnClickListener onCancelListener,
                                          String title) {
        dialogForListSelection(c, items, false, -1, selectedIndexs,
            null, listener, onOkListener, onCancelListener,title);
    }

    private static void dialogForListSelection(Context c, String[] items, boolean isSigleSelection,
                                               int selectedIndex, boolean []selectedIndexs,
                                               DialogInterface.OnClickListener singleListener,
                                               DialogInterface.OnMultiChoiceClickListener multiListener,
                                               DialogInterface.OnClickListener onOkListener,
                                               DialogInterface.OnClickListener onCancelListener,
                                               String title) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle(title);

        // add a radio button list

        if(isSigleSelection) {
            builder.setSingleChoiceItems(items, selectedIndex, singleListener);
        } else {
            builder.setMultiChoiceItems(items, selectedIndexs, multiListener);
        }

        // add OK and Cancel buttons
        builder.setPositiveButton("OK", onOkListener);
        builder.setNegativeButton("Cancel", onCancelListener);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
