package com.xyz.searchsample.util;

import android.content.Context;

import com.google.gson.Gson;
import com.xyz.searchsample.R;
import com.xyz.searchsample.model.CityModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class used to load city list from resources file.
 */

public class ResourceUtil {

    public static List<CityModel> loadCityList(Context context) {
        String myJson = inputStreamToString(context.getResources().openRawResource(R.raw.city_population));
        List<CityModel> cityModels = Arrays.asList(new Gson().fromJson(myJson, CityModel[].class));
        return cityModels;
    }

    private static String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            String json = new String(bytes);
            return json;
        } catch (IOException e) {
            return null;
        }
    }
}
