package com.rafaels.crashlyticssample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    String TAG = getClass().getSimpleName();
    //ID del proyecto
    //crashlyticssample-433bf

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCrashlyticsNormal();
//        initCrashlyticsManual();
//        Para personalizar claves de Crashlytics
        if(!BuildConfig.DEBUG)
            Crashlytics.setString("RV"+TAG, "Pantalla: " + TAG);


        Button crash = findViewById(R.id.button);
        crash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    private void initCrashlyticsManual() {
        if(!BuildConfig.DEBUG) {
            final Fabric fabric = new Fabric.Builder(this)
                    .kits(new Crashlytics())
                    .debuggable(true)           // Enables Crashlytics debugger
                    .build();
            Fabric.with(fabric);
        }
    }

    private void initCrashlyticsNormal() {
        if(!BuildConfig.DEBUG)
            Fabric.with(this, new Crashlytics());
    }
}
