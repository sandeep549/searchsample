package com.xyz.searchsample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.xyz.searchsample.R;
import com.xyz.searchsample.model.CityModel;

/**
 * Screen to show a single city details.
 */

public class CityDetailActivity extends AppCompatActivity {

    public static final String KEY_CITY = "city";
    private TextView mCityName;
    private TextView mPopulation;
    private TextView mLat;
    private TextView mLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        CityModel cityModel = getIntent().getParcelableExtra(KEY_CITY);
        if (cityModel != null) {
            showDetails(cityModel);
        } else {
            Toast.makeText(getApplicationContext(), "city details is empty", Toast.LENGTH_LONG).show();
        }
    }

    private void initView() {
        mCityName = (TextView) findViewById(R.id.cityname);
        mPopulation = (TextView) findViewById(R.id.population);
        mLat = (TextView) findViewById(R.id.lat);
        mLng = (TextView) findViewById(R.id.lng);
    }

    private void showDetails(CityModel cityModel) {
        mCityName.setText(cityModel.getCity());
        mPopulation.setText(cityModel.getPop().toString());
        mLat.setText(cityModel.getLat().toString());
        mLng.setText(cityModel.getLng().toString());
    }
}
