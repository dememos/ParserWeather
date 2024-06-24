package org.practice;

import com.fasterxml.jackson.annotation.JsonProperty;

class Current {
    private String temperature;
    private String weatherSymbolId;

    @JsonProperty("temperature")
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
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
        return "Current " +
                "temperature: " + temperature + "℃";
    }
}