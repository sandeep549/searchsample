package com.xyz.searchsample.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xyz.searchsample.R;
import com.xyz.searchsample.model.CityModel;
import com.xyz.searchsample.view.CityDetailActivity;

import java.util.List;

/**
 * Adapter to show country list.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private static final String TAG = CustomAdapter.class.getSimpleName();
    private static List<CityModel> mCityModelList;
    private static Context mContext;

    public CustomAdapter(Context context, List<CityModel> cityModelList) {
        this.mContext = context.getApplicationContext();
        this.mCityModelList = cityModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");
        holder.cityName.setText(mCityModelList.get(position).getCity());
        holder.population.setText(mCityModelList.get(position).getPop().toString());
    }

    @Override
    public int getItemCount() {
        return mCityModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView cityName;
        private final TextView population;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                    Intent intent = new Intent(mContext, CityDetailActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(CityDetailActivity.KEY_CITY, mCityModelList.get(getAdapterPosition()));
                    mContext.startActivity(intent);
                }
            });
            cityName = (TextView) v.findViewById(R.id.cityname);
            population = (TextView) v.findViewById(R.id.population);
        }
    }
}
