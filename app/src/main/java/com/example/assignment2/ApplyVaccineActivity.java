package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ApplyVaccineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_vacine);
    }

    public void onRegisterNowClick(View view){
        if(RegistrationActivity.allowRegistration) {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),"Please take the quiz ",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onTakeQuizClick(View view){
        Intent intent = new Intent(this,QuizActivity.class);
        startActivity(intent);
    }
}
