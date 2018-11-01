package com.smartron.sid.bytridgesample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.smartron.sid.bytridgesample.utils.CustomProgressDialog;

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog customProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public void showCustomProgressDialog() {
        if (customProgressDialog == null) customProgressDialog = CustomProgressDialog.ctor(this);
        customProgressDialog.show();
    }

    public void dismissCustomProgressDialog() {
        if (null == customProgressDialog) return;
        if (customProgressDialog.isShowing()) {
            customProgressDialog.dismiss();
            customProgressDialog = null;
        }
    }


}
