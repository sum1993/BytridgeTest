package com.smartron.sid.bytridgesample.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.smartron.sid.bytridgesample.R;


public class CustomProgressDialog extends ProgressDialog {

    //private Context mcontext;

    public CustomProgressDialog(Context context) {
        super(context);
        //  this.mcontext = context;
    }

    public static ProgressDialog ctor(Context context) {
        CustomProgressDialog dialog = new CustomProgressDialog(context);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        return dialog;
    }

/*
        public CustomProgressDialog(Context context, int theme) {
            super(context, theme);
        }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_custom_progress_dialog);
    }

    @Override
    public void dismiss() {
        if (this != null && this.isShowing())
            super.dismiss();
    }
}
