package com.rafaels.crashlyticssample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.crashlytics.android.Crashlytics;

public class Main2Activity extends AppCompatActivity {
    String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Para personalizar registro de Crashlytics
//        Crashlytics.log(Log.DEBUG, TAG, "Pantalla: " + TAG);
//        Para personalizar claves de Crashlytics
        Crashlytics.setString("RV"+TAG, "Pantalla: " + TAG);

        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Crashlytics.getInstance().crash();
            }
        });
    }

}
