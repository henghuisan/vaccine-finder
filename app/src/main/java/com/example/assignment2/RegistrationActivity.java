package com.example.assignment2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    public static boolean allowRegistration = false;
    private EditText name, age, address, phone, email, ic;
    private RadioGroup rbgGender;
    private Spinner ddlState;
    private CheckBox cbCondition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        bindControls();
        loadAdapterToStateDdl();
    }

    public void bindControls() {
        name = (EditText) findViewById(R.id.text_name_input);
        age = (EditText) findViewById(R.id.text_age_input);
        address = (EditText) findViewById(R.id.text_address_input);
        phone = (EditText) findViewById(R.id.text_phone_input);
        email = (EditText) findViewById(R.id.text_email_input);
        ic = (EditText) findViewById(R.id.text_ic_input);

        ddlState = (Spinner) findViewById(R.id.ddl_state);

        rbgGender = (RadioGroup) findViewById(R.id.rbg_gender);

        cbCondition = (CheckBox) findViewById(R.id.cb_condition);
    }

    public void loadAdapterToStateDdl() {
        @SuppressLint("ResourceType") ArrayAdapter<CharSequence> states =
                ArrayAdapter.createFromResource(getApplicationContext(), R.array.states, R.drawable.spinner);

        states.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ddlState.setAdapter(states);
    }

    public void onRegistrationSubmitClick(View view) {
        if (isValid())
            showResult(wrapFormDataToBundle());
    }

    public boolean isValid() {
        boolean isControlsValid = true;
        isControlsValid &= isNameValid();
        isControlsValid &= isAgeValid();
        isControlsValid &= isPhoneValid();
        isControlsValid &= isIcNumberValid();
        isControlsValid &= isGenderSelected();
        isControlsValid &= isEmailValid();
        isControlsValid &= isStateSelected();
        isControlsValid &= isConditionAgreed();
        return isControlsValid;
    }

    public boolean isNameValid() {
        if (TextUtils.isEmpty(this.name.getText().toString().trim())) {
            this.name.setError(getString(R.string.input_empty_error));
            return false;
        }
        return true;
    }

    public boolean isAgeValid() {
        int min = 1;
        int max = 110;
        if (TextUtils.isEmpty(this.age.getText().toString().trim())) {
            age.setError(getString(R.string.input_empty_error));
            return false;
        }
        int age = Integer.parseInt(this.age.getText().toString().trim());

        if (age < min || age > max) {
            this.age.setError(getString(R.string.input_invalid_error));
            return false;
        }

        return true;
    }

    public boolean isPhoneValid() {
        if (TextUtils.isEmpty(this.phone.getText().toString().trim())) {
            this.phone.setError(getString(R.string.input_empty_error));
            return false;
        }
        Pattern phoneRegex = Pattern.compile(Regex.MALAYSIA_PHONE_REGEX);
        if (!phoneRegex.matcher(this.phone.getText().toString().trim()).matches()) {
            this.phone.setError(getString(R.string.input_format_error));
            return false;
        }
        return true;
    }

    public boolean isIcNumberValid() {
        if (TextUtils.isEmpty(this.ic.getText().toString().trim())) {
            this.ic.setError(getString(R.string.input_empty_error));
            return false;
        }
        Pattern icRegex = Pattern.compile(Regex.IC_NUMBER_REGEX);
        if (!icRegex.matcher(this.ic.getText().toString().trim()).matches()) {
            this.ic.setError(getString(R.string.input_format_error));
            return false;
        }
        return true;
    }

    public boolean isGenderSelected() {
        if (rbgGender.getCheckedRadioButtonId() == -1) {
            RadioButton rbLast = (RadioButton) findViewById(R.id.rb_gender_f);
            rbLast.setError(getString(R.string.input_empty_error));
            return false;
        }
        return true;
    }

    public boolean isEmailValid() {
        if (TextUtils.isEmpty(this.email.getText().toString().trim())) {
            this.email.setError(getString(R.string.input_empty_error));
            return false;
        }
        Pattern emailRegex = Pattern.compile(Regex.EMAIL_ADDRESS_REGEX);
        if (!emailRegex.matcher(this.email.getText().toString().trim()).matches()) {
            this.email.setError(getString(R.string.input_format_error));
            return false;
        }
        return true;
    }

    public boolean isStateSelected() {
        if (ddlState.getSelectedItemPosition() == 0) {
            View spinner = ddlState.getSelectedView();
            spinner.requestFocus();
            TextView textView = (TextView) spinner;
            textView.setError(getString(R.string.input_empty_error));
            spinner.performClick();
            return false;
        }
        return true;
    }

    public boolean isConditionAgreed(){
        if(!cbCondition.isChecked()){
            cbCondition.setError("");
            return false;
        }
        return true;
    }

    public Bundle wrapFormDataToBundle() {
        Bundle registrationFormData = new Bundle();
        registrationFormData.putString("Name", name.getText().toString().trim());
        registrationFormData.putString("Age", age.getText().toString());
        registrationFormData.putString("Phone", phone.getText().toString());
        registrationFormData.putString("Ic", ic.getText().toString());
        registrationFormData.putString("Email", email.getText().toString());
        TextView state = (TextView) ddlState.getSelectedView();
        registrationFormData.putString("State", state.getText().toString());
        int rbSelected = rbgGender.getCheckedRadioButtonId();
        if (rbSelected == R.id.rb_gender_m)
            registrationFormData.putString("Gender", "Male");
        else
            registrationFormData.putString("Gender", "Female");
        if(!TextUtils.isEmpty(ic.getText()))
            registrationFormData.putString("Address", address.getText().toString());
        return registrationFormData;
    }

    public void showResult(Bundle formData) {
        Intent intent = new Intent(this, RegistrationResultActivity.class);
        intent.putExtras(formData);
        startActivity(intent);
    }
}