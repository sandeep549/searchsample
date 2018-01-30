package com.xyz.searchsample.view;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.xyz.searchsample.R;
import com.xyz.searchsample.adapters.CustomAdapter;
import com.xyz.searchsample.contract.SearchContract;
import com.xyz.searchsample.model.CityModel;
import com.xyz.searchsample.presenter.SearchPresenter;

import java.util.List;

/**
 * Screen to show cities that matches search criteria.
 */
public class CitySearchActivity extends AppCompatActivity implements SearchContract.View {

    private String TAG = CitySearchActivity.class.getSimpleName();
    private LinearLayoutManager mLayoutManager;
    private CustomAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SearchPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mPresenter = new SearchPresenter(this);
        initView();
        handleSearch();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleSearch();
    }

    private void handleSearch() {
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String searchQuery = intent.getStringExtra(SearchManager.QUERY);
            mPresenter.handleSearch(searchQuery);

        } else if (Intent.ACTION_VIEW.equals(intent.getAction())) {
            String searchId = intent.getDataString();
            mPresenter.hanleViewAction(searchId);
        }
    }

    @Override
    public void showSearchResult(List<CityModel> searhList) {
        if (searhList.size() > 0) {
            mAdapter = new CustomAdapter(getApplicationContext(), searhList);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            Log.e(TAG, "Search result is empty");
        }
    }

    @Override
    public void showCityDetails(CityModel city) {
        Intent intent = new Intent(CitySearchActivity.this, CityDetailActivity.class);
        intent.putExtra(CityDetailActivity.KEY_CITY, city);
        startActivity(intent);
        this.finish();
    }
}
