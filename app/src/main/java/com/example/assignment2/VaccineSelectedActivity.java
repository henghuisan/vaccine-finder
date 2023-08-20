package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VaccineSelectedActivity extends AppCompatActivity {


    private int targetNo;
    private TextView mJustifiedText;
    private TextView mTitle;
    private ImageView mImageView;
    private String targetUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_selected);

        Intent intent = getIntent();
        targetNo = intent.getIntExtra("index",0);

        getDescription(targetNo);
    }

    public void getDescription(int index){
        mTitle = (TextView) findViewById(R.id.vaccine_name);
        mJustifiedText = (TextView) findViewById(R.id.description);

        switch(index){
            case 0:
                mTitle.setText(R.string.vaccine1);
                mJustifiedText.setText(R.string.fizer_desc);
                targetUrl = getString(R.string.fizer_url);
                break;
            case 1:
                mTitle.setText(R.string.vaccine2);
                mJustifiedText.setText(R.string.az_desc);
                targetUrl = getString(R.string.az_url);
                break;
            case 2:
                mTitle.setText(R.string.vaccine3);
                mJustifiedText.setText(R.string.gamaleya_desc);
                targetUrl = getString(R.string.gamaleya_url);
                break;
            case 3:
                mTitle.setText(R.string.vaccine4);
                mJustifiedText.setText(R.string.moderna_desc);
                targetUrl = getString(R.string.moderna_url);
                break;
            case 4:
                mTitle.setText(R.string.vaccine5);
                mJustifiedText.setText(R.string.sinovac_desc);
                targetUrl = getString(R.string.sinovac_url);
                break;
            default: break;

        }
    }

    public void openWebsite(View view) {
        //encode the url string into "webpage" variable
        Uri webpage = Uri.parse(targetUrl);
        //create an intent to display the webpage for user
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity that can handle the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}