package com.example.dubsydesktop.gaslog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class addFuel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fuel);
    }

    public void saveGasLog(View view) {
        Intent intent = new Intent(this, DisplayResultsActivity.class);

        startActivity(intent);
    }
}
