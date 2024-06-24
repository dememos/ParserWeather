package org.practice;

import com.fasterxml.jackson.annotation.JsonProperty;

class Forecast {
    private long noon;
    private String tempHigh;
    private String weekday;
    private String tempLow;
    private String precipMean;
    private String weatherSymbolId;

    @JsonProperty("noon")
    public long getNoon() {
        return noon;
    }

    public void setNoon(long noon) {
        this.noon = noon;
    }

    @JsonProperty("temp_high")
    public String getTempHigh() {
        return tempHigh;
    }

    public void setTempHigh(String tempHigh) {
        this.tempHigh = tempHigh;
    }

    @JsonProperty("weekday")
    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    @JsonProperty("temp_low")
    public String getTempLow() {
        return tempLow;
    }

    public void setTempLow(String tempLow) {
        this.tempLow = tempLow;
    }

    @JsonProperty("precip_mean")
    public String getPrecipMean() {
        return precipMean;
    }

    public void setPrecipMean(String precipMean) {
        this.precipMean = precipMean;
    }

    @JsonProperty("weather_symbol_id")
    public String getWeatherSymbolId() {
        return weatherSymbolId;
    }

    public void setWeatherSymbolId(String weatherSymbolId) {
        this.weatherSymbolId = weatherSymbolId;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "noon=" + noon +
                ", tempHigh='" + tempHigh + '\'' +
                ", weekday='" + weekday + '\'' +
                ", tempLow='" + tempLow + '\'' +
                ", precipMean='" + precipMean + '\'' +
                ", weatherSymbolId='" + weatherSymbolId + '\'' +
                '}';
    }
}
