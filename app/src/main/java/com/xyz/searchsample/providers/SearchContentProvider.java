package com.xyz.searchsample.providers;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.xyz.searchsample.CityDataCache;
import com.xyz.searchsample.model.CityModel;

import java.util.Iterator;
import java.util.List;

/**
 * Search Provider that handle search suggestion queries.
 */

public class SearchContentProvider extends ContentProvider {

    private static final String TAG = SearchContentProvider.class.getSimpleName();

    @Override
    public boolean onCreate() {
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        String queryType = "";
        List<CityModel> cityModelList = CityDataCache.getCitylList();
        String query = uri.getLastPathSegment().toLowerCase();
        Log.d(TAG, "query=" + query);
        String[] columns = new String[]{BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_2, SearchManager.SUGGEST_COLUMN_INTENT_DATA};
        MatrixCursor matrixCursor = new MatrixCursor(columns);

        Iterator<CityModel> iterator = cityModelList.iterator();
        int rowNo = 0;
        while (iterator.hasNext()) {
            CityModel cityModel = iterator.next();
            if (cityModel.getCity() != null && cityModel.getCity().contains(query)) {
                matrixCursor.addRow(new Object[]{rowNo, cityModel.getCity(), cityModel.getCity()});
                rowNo++;
                Log.d(TAG, "filtered:" + cityModel.toString());
            }
        }

        return matrixCursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }


    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
