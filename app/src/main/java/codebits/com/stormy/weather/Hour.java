package codebits.com.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tjah on 14/05/2017.
 */

public class Hour implements Parcelable {

    private long time;
    private String summary;
    private double temperature;
    private String icon;
    private String timeZone;



    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    //round up the value of the temperature with round method.
    public int getTemperature() {
        return (int) Math.round(temperature);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }


    //format date and display time format in seconds
    public String getHour() {
        SimpleDateFormat formatter = new SimpleDateFormat("h a");
        Date date = new Date(time * 1000);
        return formatter.format(date);
    }



    public int getIconId() {
        return Forecast.getIconId(icon);
    }
    //default constructor for Day class
    public Hour() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(time);
        dest.writeDouble(temperature);
        dest.writeString(summary);
        dest.writeString(icon);
        dest.writeString(timeZone);

    }

    private Hour (Parcel in) {
        time = in.readLong();
        temperature = in.readDouble();
        summary = in.readString();
        icon = in.readString();
        timeZone = in.readString();

    };

    //creator field/object
    public static final Creator<Hour> CREATOR = new Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel source) {
            return new Hour(source);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
        }
    };
}

