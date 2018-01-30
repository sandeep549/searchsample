package com.xyz.searchsample.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * City model to hold city data.
 */

public class CityModel implements Parcelable {

    public static final Creator<CityModel> CREATOR = new Creator<CityModel>() {
        @Override
        public CityModel createFromParcel(Parcel in) {
            return new CityModel(in);
        }

        @Override
        public CityModel[] newArray(int size) {
            return new CityModel[size];
        }
    };
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("city_ascii")
    @Expose
    private String cityAscii;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("pop")
    @Expose
    private Double pop;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("iso2")
    @Expose
    private String iso2;
    @SerializedName("iso3")
    @Expose
    private String iso3;
    @SerializedName("province")
    @Expose
    private String province;

    protected CityModel(Parcel in) {
        city = in.readString();
        cityAscii = in.readString();
        if (in.readByte() == 0) {
            lat = null;
        } else {
            lat = in.readDouble();
        }
        if (in.readByte() == 0) {
            lng = null;
        } else {
            lng = in.readDouble();
        }
        if (in.readByte() == 0) {
            pop = null;
        } else {
            pop = in.readDouble();
        }
        country = in.readString();
        iso2 = in.readString();
        iso3 = in.readString();
        province = in.readString();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityAscii() {
        return cityAscii;
    }

    public void setCityAscii(String cityAscii) {
        this.cityAscii = cityAscii;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getPop() {
        return pop;
    }

    public void setPop(Double pop) {
        this.pop = pop;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("city", city).append("cityAscii", cityAscii).append("lat", lat).append("lng", lng).append("pop", pop).append("country", country).append("iso2", iso2).append("iso3", iso3).append("province", province).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cityAscii).append(province).append(iso3).append(iso2).append(pop).append(lng).append(lat).append(country).append(city).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CityModel) == false) {
            return false;
        }
        CityModel rhs = ((CityModel) other);
        return new EqualsBuilder().append(cityAscii, rhs.cityAscii).append(province, rhs.province).append(iso3, rhs.iso3).append(iso2, rhs.iso2).append(pop, rhs.pop).append(lng, rhs.lng).append(lat, rhs.lat).append(country, rhs.country).append(city, rhs.city).isEquals();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(city);
        parcel.writeString(cityAscii);
        if (lat == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(lat);
        }
        if (lng == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(lng);
        }
        if (pop == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(pop);
        }
        parcel.writeString(country);
        parcel.writeString(iso2);
        parcel.writeString(iso3);
        parcel.writeString(province);
    }
}