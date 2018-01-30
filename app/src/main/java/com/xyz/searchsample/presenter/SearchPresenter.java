package com.xyz.searchsample.presenter;

import android.text.TextUtils;

import com.xyz.searchsample.CityDataCache;
import com.xyz.searchsample.contract.SearchContract;
import com.xyz.searchsample.model.CityModel;

import java.util.List;

/**
 * Presenter for Search List screen.
 */

public class SearchPresenter implements SearchContract.Presenter {

    private SearchContract.View mView;

    public SearchPresenter(SearchContract.View view) {
        this.mView = view;
    }

    @Override
    public void handleSearch(String queryString) {
        if (!TextUtils.isEmpty(queryString)) {
            List<CityModel> list = CityDataCache.filterData(queryString);
            mView.showSearchResult(list);
        }
    }

    @Override
    public void hanleViewAction(String searchId) {
        if (!TextUtils.isEmpty(searchId)) {
            CityModel cityModel = CityDataCache.getCityByName(searchId);
            mView.showCityDetails(cityModel);
        }
    }
}
