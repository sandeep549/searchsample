package com.xyz.searchsample.contract;

import com.xyz.searchsample.model.CityModel;

import java.util.List;

/**
 * Contract for Search List screen
 */

public interface SearchContract {
    public interface View {
        void showSearchResult(List<CityModel> searhList);

        void showCityDetails(CityModel city);
    }

    public interface Presenter {
        void handleSearch(String queryString);

        void hanleViewAction(String searchId);
    }
}
