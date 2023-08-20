package com.example.assignment2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationResultActivity extends AppCompatActivity {
    TextView name,age,email,address,phone,ic,state,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_result);
        setText(getIntent().getExtras());
    }

    public void setText(Bundle bundle){
        name = (TextView)findViewById(R.id.text_name_label);
        name.setText("Name: "+ bundle.getString("Name"));

        age = (TextView)findViewById(R.id.text_age_label);
        age.setText("Age: "+bundle.getString("Age"));

        gender = (TextView)findViewById(R.id.text_gender_label);
        gender.setText("Gender: "+bundle.getString("Gender"));

        email = (TextView)findViewById(R.id.text_email_label);
        email.setText("Email: "+bundle.getString("Email"));

        phone = (TextView)findViewById(R.id.text_phone_label);
        phone.setText("Phone Number: "+bundle.getString("Phone"));

        ic = (TextView)findViewById(R.id.text_ic_label);
        ic.setText("Ic: "+bundle.getString("Ic"));

        state = (TextView)findViewById(R.id.text_state_label);
        state.setText("State: "+bundle.getString("State"));

        if(bundle.containsKey("Address")){
            address = (TextView)findViewById(R.id.text_address_label);
            address.setText("Address: "+bundle.getString("Address"));
        }
    }
}