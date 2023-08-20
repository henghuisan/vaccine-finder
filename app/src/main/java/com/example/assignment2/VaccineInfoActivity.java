package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class VaccineInfoActivity extends AppCompatActivity {
    ConstraintLayout expandableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_info);

        setInvisible();
    }

    public void showAnswer0(View view) {
        expand(findViewById(R.id.expandableView0),
                findViewById(R.id.arrowBtn0),
                findViewById(R.id.cardView0));
    }

    public void showAnswer1(View view) {
        expand(findViewById(R.id.expandableView1),
                findViewById(R.id.arrowBtn1),
                findViewById(R.id.cardView1));
    }

    public void showAnswer2(View view) {
        expand(findViewById(R.id.expandableView2),
                findViewById(R.id.arrowBtn2),
                findViewById(R.id.cardView2));

    }

    public void showAnswer3(View view) {
        expand(findViewById(R.id.expandableView3),
                findViewById(R.id.arrowBtn3),
                findViewById(R.id.cardView3));
    }

    public void showAnswer4(View view) {
        expand(findViewById(R.id.expandableView4),
                findViewById(R.id.arrowBtn4),
                findViewById(R.id.cardView4));
    }

    public void showAnswer5(View view) {
        expand(findViewById(R.id.expandableView5),
                findViewById(R.id.arrowBtn5),
                findViewById(R.id.cardView5));
    }

    private void expand(ConstraintLayout cLayout, Button btn, CardView cView){
        //to animate to a new view defined by the changes within the basic view
        TransitionManager.beginDelayedTransition(cView, new AutoTransition());

        //if the constraint layout is visible, set it visible
        //and change the button image from arrow down to arrow up
        if (cLayout.getVisibility()==View.GONE){
            cLayout.setVisibility(View.VISIBLE);
            btn.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
        } else {
            //the constraint layout is invisible and change the button image to arrow down
            cLayout.setVisibility(View.GONE);
            btn.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
        }
    }

    private void setInvisible(){
        //find the id of the constraint layout and
        //store it inside the expandableView variable
        expandableView = findViewById(R.id.expandableView0);
        //set the constraint layout invisible without taking any space
        expandableView.setVisibility(View.GONE);

        expandableView = findViewById(R.id.expandableView1);
        expandableView.setVisibility(View.GONE);

        expandableView = findViewById(R.id.expandableView2);
        expandableView.setVisibility(View.GONE);

        expandableView = findViewById(R.id.expandableView3);
        expandableView.setVisibility(View.GONE);

        expandableView = findViewById(R.id.expandableView4);
        expandableView.setVisibility(View.GONE);

        expandableView = findViewById(R.id.expandableView5);
        expandableView.setVisibility(View.GONE);
    }
}