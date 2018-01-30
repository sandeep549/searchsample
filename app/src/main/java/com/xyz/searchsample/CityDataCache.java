package com.xyz.searchsample;

/**
 * Created by sandeepkumar on 25/01/18.
 */

import android.content.Context;
import android.util.Log;

import com.xyz.searchsample.model.CityModel;
import com.xyz.searchsample.util.ResourceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * RAM based cache for city list data.
 * 1. Keeps list of city for ease of searching.
 * 2. Keeps HashMap of city for easy access to show a single selected city.
 */
public class CityDataCache {
    private static final String TAG = CityDataCache.class.getSimpleName();

    // City list to show list on screen
    private static List<CityModel> mCityModelList;

    // city map get a single city details when selected.
    private static Map<String, CityModel> mCityModelMap = new HashMap<>();


    private CityDataCache() {
    }

    public static void init(Context context) {
        mCityModelList = ResourceUtil.loadCityList(context);
        Iterator<CityModel> iterator = mCityModelList.iterator();
        while (iterator.hasNext()) {
            CityModel cityModel = iterator.next();
            mCityModelMap.put(cityModel.getCity(), cityModel);
            Log.d(TAG, cityModel.toString());
        }
    }

    public static List<CityModel> filterData(String searchString) {
        List<CityModel> filteredcitylist = new ArrayList<>();
        if (searchString != null) {
            searchString = searchString.toLowerCase();
        } else {
            return filteredcitylist;
        }

        Iterator<CityModel> iterator = mCityModelList.iterator();
        while (iterator.hasNext()) {
            CityModel cityModel = iterator.next();
            if (cityModel.getCity().toLowerCase().contains(searchString)) {
                filteredcitylist.add(cityModel);
            }
        }
        return filteredcitylist;
    }

    public static List<CityModel> getCitylList() {
        return mCityModelList;
    }

    public static CityModel getCityByName(String cityName) {
        return mCityModelMap.get(cityName);
    }
}
