package org.practice;

import com.fasterxml.jackson.annotation.JsonProperty;

class Current {
    private String temperature;
    private int weatherSymbolId;

    @JsonProperty("temperature")
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("weather_symbol_id")
    public int getWeatherSymbolId() {
        return weatherSymbolId;
    }

    public void setWeatherSymbolId(int weatherSymbolId) {
        this.weatherSymbolId = weatherSymbolId;
    }

    public String getWeatherSymbolName() {
        String symbol;
        switch (weatherSymbolId) {
            case 1:
                symbol = "\u2600"; // Символ солнца
                break;
            default:
                if (weatherSymbolId >= 2 && weatherSymbolId <= 5) {
                    symbol = "\u26C5"; // Символ солнце с тучкой
                }
                else if (weatherSymbolId >= 6 && weatherSymbolId <= 10) {
                    symbol = "\uD83C\uDF27"; // Символ тучки с каплями дождя
                }
                else if (weatherSymbolId >= 12 && weatherSymbolId <= 13) {
                    symbol = "\u26C8"; // гроза с тучей
                }
                else if (weatherSymbolId >= 17 && weatherSymbolId <= 20) {
                    symbol = "\uD83C\uDF27"; // Символ тучки с каплями дождя
                }
                else {
                    symbol = "\uD83C\uDF08"; // Значение по умолчанию, если weatherSymbolId не распознан
                }
                break;
        }
        return symbol;
    }

    @Override
    public String toString() {
        return "Current " +
                "temperature: " + temperature + "℃";
    }
}