package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    RadioGroup rbg;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }
    public void onSubmitClick(View view){
        if(!com.example.assignment2.RegistrationActivity.allowRegistration){
            if(checkAnswer()) {
                com.example.assignment2.RegistrationActivity.allowRegistration = true;
                showAllowMessage();
            }else{
                showNotAllowMessage();
            }
        }
    }
    public void showAllowMessage(){
        Toast toast = Toast.makeText(getApplicationContext(),"Congratulation! You are allowed to register vaccination.",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showNotAllowMessage(){
        Toast toast = Toast.makeText(getApplicationContext(),"Correct all questions to apply vaccination",Toast.LENGTH_SHORT);
        toast.show();
    }

    public boolean checkAnswer(){
        boolean result = true;
        result &= isQuestion1AnswerCorrect();
        result &= isQuestion2AnswerCorrect();
        result &= isQuestion3AnswerCorrect();
        result &= isQuestion4AnswerCorrect();
        result &= isQuestion5AnswerCorrect();
        return result;
    }

    public boolean isQuestion1AnswerCorrect() {
        boolean result =  false;

        rbg = findViewById(R.id.rgb_quiz_quest_1);
        tv = findViewById(R.id.result_quiz_quest_1);
        int rb_id_selected = rbg.getCheckedRadioButtonId();

        if(rb_id_selected != -1) {
            boolean selected_value = false;
            if (R.id.rb_quiz_quest_1_t == rb_id_selected)
                selected_value = true;

            result = !selected_value;
        }

        if (result) {
            tv.setText(R.string.quiz_result_correct_message);
            tv.setTextColor(getResources().getColor(R.color.result_font_color_correct));
        } else {
            tv.setText(R.string.quiz_result_wrong_message);
            tv.setTextColor(getResources().getColor(R.color.result_font_color_wrong));
        }

        return result;
    }

    public boolean isQuestion2AnswerCorrect() {
        boolean result =  false;

        rbg = findViewById(R.id.rgb_quiz_quest_2);
        tv = findViewById(R.id.result_quiz_quest_2);
        int rb_id_selected = rbg.getCheckedRadioButtonId();

        if(rb_id_selected != -1) {
            boolean selected_value = false;
            if (R.id.rb_quiz_quest_2_t == rb_id_selected)
                selected_value = true;

            result = !selected_value;
        }

        if (result) {
            tv.setText(R.string.quiz_result_correct_message);
            tv.setTextColor(getResources().getColor(R.color.result_font_color_correct));
        } else {
            tv.setText(R.string.quiz_result_wrong_message);
            tv.setTextColor(getResources().getColor(R.color.result_font_color_wrong));
        }

        return result;
    }
    public boolean isQuestion3AnswerCorrect() {
        boolean result =  false;

        rbg = findViewById(R.id.rgb_quiz_quest_3);
        tv = findViewById(R.id.result_quiz_quest_3);
        int rb_id_selected = rbg.getCheckedRadioButtonId();

        if(rb_id_selected != -1) {
            boolean selected_value = false;
            if (R.id.rb_quiz_quest_3_t == rb_id_selected)
                selected_value = true;

            result = selected_value;
        }

        if (result) {
            tv.setText(R.string.quiz_result_correct_message);
            tv.setTextColor(getResources().getColor(R.color.result_font_color_correct));
        } else {
            tv.setText(R.string.quiz_result_wrong_message);
            tv.setTextColor(getResources().getColor(R.color.result_font_color_wrong));
        }

        return result;
    }
    public boolean isQuestion4AnswerCorrect() {
        boolean result =  false;

        rbg = findViewById(R.id.rgb_quiz_quest_4);
        tv = findViewById(R.id.result_quiz_quest_4);
        int rb_id_selected = rbg.getCheckedRadioButtonId();

        if(rb_id_selected != -1) {
            boolean selected_value = false;
            if (R.id.rb_quiz_quest_4_t == rb_id_selected)
                selected_value = true;

            result = selected_value;
        }

        if (result) {
            tv.setText(R.string.quiz_result_correct_message);
            tv.setTextColor(getResources().getColor(R.color.result_font_color_correct));
        } else {
            tv.setText(R.string.quiz_result_wrong_message);
            tv.setTextColor(getResources().getColor(R.color.result_font_color_wrong));
        }

        return result;
    }
    public boolean isQuestion5AnswerCorrect() {
        boolean result =  false;

        rbg = findViewById(R.id.rgb_quiz_quest_5);
        tv = findViewById(R.id.result_quiz_quest_5);
        int rb_id_selected = rbg.getCheckedRadioButtonId();

        if(rb_id_selected != -1) {
            boolean selected_value = false;
            if (R.id.rb_quiz_quest_5_t == rb_id_selected)
                selected_value = true;

            result = !selected_value;
        }

        if (result) {
            tv.setText(R.string.quiz_result_correct_message);
            tv.setTextColor(getResources().getColor(R.color.result_font_color_correct));
        } else {
            tv.setText(R.string.quiz_result_wrong_message);
            tv.setTextColor(getResources().getColor(R.color.result_font_color_wrong));
        }

        return result;
    }
}
