package com.newrock.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.startService(new Intent(this,FirstService.class));
        this.startService(new Intent(this,SecondService.class));
    }
}
