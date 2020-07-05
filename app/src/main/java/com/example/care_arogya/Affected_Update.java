package com.example.care_arogya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.models.PieModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Affected_Update extends AppCompatActivity {
    EditText edtSearch;
    ListView listView;
    SimpleArcLoader simpleArcLoader;

    public  static List<CountryModel> countryModelList= new ArrayList<>();
    CountryModel countryModel;
    MyCustomAdapter myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affected__update);

        edtSearch= findViewById(R.id.edtSearch);
        listView= findViewById(R.id.listView);
        simpleArcLoader= findViewById(R.id.loader);


        getSupportActionBar().setTitle("Countries Updates");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fetchData();


 listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     @Override
     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         startActivity(new Intent(getApplicationContext(),Detail_Updates.class).putExtra("position",position));
     }
 });



        // this is for the edt text search listener which watches the every character which is searched
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myCustomAdapter.getFilter().filter(s);
                myCustomAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
// this is for the whenever user click on the back button it automatically jump on the previous activity
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void fetchData() {
        String url= "https://corona.lmao.ninja/v2/countries";

        simpleArcLoader.start();

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray= new JSONArray(response);
                             for(int i=0;i<jsonArray.length();i++){

                                 JSONObject jsonObject= jsonArray.getJSONObject(i);
                                 String countryName = jsonObject.getString("country");
                                 String cases = jsonObject.getString("cases");
                                 String todayCases = jsonObject.getString("todayCases");
                                 String deaths = jsonObject.getString("deaths");
                                 String todayDeaths = jsonObject.getString("todayDeaths");
                                 String recovered = jsonObject.getString("recovered");
                                 String todayrecoverd= jsonObject.getString("todayRecovered");
                                 String active = jsonObject.getString("active");
                                 String tests= jsonObject.getString("tests");
                                 String critical = jsonObject.getString("critical");
                                 String casesPerOneMillion= jsonObject.getString("casesPerOneMillion");
                                 String deathsPerOneMillion= jsonObject.getString("deathsPerOneMillion");
                                 String recoveredPerOneMillion= jsonObject.getString("recoveredPerOneMillion");
                                 String testsPerOneMillion= jsonObject.getString("testsPerOneMillion");
                                 String criticalPerOneMillion= jsonObject.getString("criticalPerOneMillion");

                                 JSONObject object= jsonObject.getJSONObject("countryInfo");
                                 String  flagUrl= object.getString("flag");

                                 countryModel= new CountryModel(flagUrl,countryName,cases,todayCases,deaths,todayDeaths,recovered,todayrecoverd,active,tests,critical,casesPerOneMillion,deathsPerOneMillion,recoveredPerOneMillion,testsPerOneMillion,criticalPerOneMillion);
                                 countryModelList.add(countryModel);

                             }
                              myCustomAdapter = new MyCustomAdapter(Affected_Update.this,countryModelList);
                             listView.setAdapter(myCustomAdapter);
                              simpleArcLoader.stop();
                              simpleArcLoader.setVisibility(listView.GONE);



                        } catch (JSONException e) {
                            e.printStackTrace();
                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(listView.GONE);

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(listView.GONE);
                Toast.makeText(Affected_Update.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}