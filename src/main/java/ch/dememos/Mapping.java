package ch.dememos;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.nio.charset.StandardCharsets;
import java.util.List;

class Mapping {
    private int altitude;
    private String cityName;
    private Current current;
    private int coordX;
    private int coordY;
    private int weatherSymbolId;
    private String locationId;
    private List<Forecast> forecasts;
    private long timestamp;

    @JsonProperty("altitude")
    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @JsonProperty("city_name")
    public String getCityName() {
        return cityName;
    }

    public byte[] cityNameToBytes() {
        return cityName.getBytes(StandardCharsets.ISO_8859_1);
    }

    public String convertCityName() {
        return new String(cityNameToBytes(), StandardCharsets.UTF_8);
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty("current")
    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    @JsonProperty("coord_x")
    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    @JsonProperty("coord_y")
    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    @JsonProperty("weather_symbol_id")
    public int getWeatherSymbolId() {
        return weatherSymbolId;
    }

    public void setWeatherSymbolId(int weatherSymbolId) {
        this.weatherSymbolId = weatherSymbolId;
    }

    @JsonProperty("location_id")
    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @JsonProperty("forecasts")
    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    @JsonProperty("timestamp")
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Mapping{" +
                "altitude=" + altitude +
                ", cityName='" + cityName + '\'' +
                ", current=" + current +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", weatherSymbolId=" + weatherSymbolId +
                ", locationId='" + locationId + '\'' +
                ", forecasts=" + forecasts +
                ", timestamp=" + timestamp +
                '}';
    }
}