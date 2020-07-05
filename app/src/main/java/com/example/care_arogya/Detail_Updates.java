 package com.example.care_arogya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;

 public class Detail_Updates extends AppCompatActivity {

     private  int positionCountry;
     TextView tvCountry,tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths,tvTotalTests,tvTodayRecovered,
             tvDeathsPerOneMillion,tvTestsPerOneMillion,tvRecoveredPerOneMillion,tvCriticalPerOneMillion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__updates);

        Intent intent = getIntent();
        positionCountry= intent.getIntExtra("position",0);
        getSupportActionBar().setTitle("Details of"+Affected_Update.countryModelList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvTotalTests= findViewById(R.id.tvtests);
        tvTodayRecovered= findViewById(R.id.tvtodayRecovered);
        tvDeathsPerOneMillion= findViewById(R.id.tvdeathsPerOneMillion);
        tvTestsPerOneMillion= findViewById(R.id.tvtestsPerOneMillion);
        tvRecoveredPerOneMillion= findViewById(R.id.tvrecoveredPerOneMillion);
        tvCriticalPerOneMillion= findViewById(R.id.tvCriticalPerOneMillion);


        // this is for the setting up the data from  the myadapter class and show in the textView

        tvCountry.setText(Affected_Update.countryModelList.get(positionCountry).getCountry());
        tvCases.setText(Affected_Update.countryModelList.get(positionCountry).getCases());
        tvRecovered.setText(Affected_Update.countryModelList.get(positionCountry).getRecovered());
        tvCritical.setText(Affected_Update.countryModelList.get(positionCountry).getCritical());
        tvActive.setText(Affected_Update.countryModelList.get(positionCountry).getActive());
        tvTodayCases.setText(Affected_Update.countryModelList.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(Affected_Update.countryModelList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(Affected_Update.countryModelList.get(positionCountry).getTodayDeaths());
        tvTotalTests.setText(Affected_Update.countryModelList.get(positionCountry).getTests());
        tvTodayRecovered.setText(Affected_Update.countryModelList.get(positionCountry).getTodayrecoverd());
        tvDeathsPerOneMillion.setText(Affected_Update.countryModelList.get(positionCountry).getDeathsPerOneMillion());
        tvTestsPerOneMillion.setText(Affected_Update.countryModelList.get(positionCountry).getTestsPerOneMillion());
        tvRecoveredPerOneMillion.setText(Affected_Update.countryModelList.get(positionCountry).getRecoveredPerOneMillion());
        tvCriticalPerOneMillion.setText(Affected_Update.countryModelList.get(positionCountry).getCriticalPerOneMillion());




    }



     // this is for the whenever user click on the back button it automatically jump on the previous activity
     @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         if(item.getItemId()==android.R.id.home);
         finish();
         return super.onOptionsItemSelected(item);
     }

 }