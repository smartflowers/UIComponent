package com.example.uicomponent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Alert_Dialog extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog);

    }
    public void click(View view){
        AlertDialog alertDialog=new AlertDialog.Builder(this).setView(R.layout.loginview).
                setNegativeButton("Cancel", null).
                setPositiveButton("Sign in", null).create();
        alertDialog.show();
    }
}
