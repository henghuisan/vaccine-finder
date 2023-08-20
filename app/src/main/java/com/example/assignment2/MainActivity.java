package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showVaccine(View view) {
        Intent intent = new Intent(this, VaccineAvailableActivity.class);
        startActivity(intent);
    }

    public void showInfo(View view) {
        Intent intent = new Intent(this, VaccineInfoActivity.class);
        startActivity(intent);
    }

    public void onApplyNowClick(View view) {
        Intent intent = new Intent(this,ApplyVaccineActivity.class);
        startActivity(intent);
    }
}

