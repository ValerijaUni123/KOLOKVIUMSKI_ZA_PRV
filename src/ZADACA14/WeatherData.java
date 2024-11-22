package ZADACA14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class WeatherData{
    private float temperature;
    private float humidity;
    private float wind;
    private float visability;
    private Date date;
    private String timeZone = "GMT";

    public WeatherData(float temperature, float wind, float humidity, float visability, Date date) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.wind = wind;
        this.visability = visability;
        this.date = date;
    }


    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        df.setTimeZone(TimeZone.getTimeZone(timeZone));
        String formattedDate = df.format(date);
        return String.format("%.1f %.1f km/h %.1f%% %.1f km %s", temperature, wind, humidity, visability, formattedDate);
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getWind() {
        return wind;
    }

    public float getVisability() {
        return visability;
    }

    public Date getDate() {
        return date;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setWind(float wind) {
        this.wind = wind;
    }

    public void setVisability(float visability) {
        this.visability = visability;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
