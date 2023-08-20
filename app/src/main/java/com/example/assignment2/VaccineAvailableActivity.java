package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VaccineAvailableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_available);
    }

   @SuppressLint("NonConstantResourceId")
   public void showVaccine(View view) {
        Intent intent = new Intent(this, VaccineSelectedActivity.class);

        switch (view.getId()) {
            case R.id.vac1: intent.putExtra("index", 0); break;
            case R.id.vac2: intent.putExtra("index", 1); break;
            case R.id.vac3: intent.putExtra("index", 2); break;
            case R.id.vac4: intent.putExtra("index", 3); break;
            case R.id.vac5: intent.putExtra("index", 4); break;
            default: break;
        }
        startActivity(intent);
    }
}

