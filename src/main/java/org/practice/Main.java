package org.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class Main {
    static String urlVersion = "https://www.meteoschweiz.admin.ch/product/output/versions.json";

    public static void main(String[] args) throws IOException {
        JsonNode rootNodeVersion = null;
        JsonNode rootNodeForecast = null;
        Connector connector = new Connector();
        try {
            rootNodeVersion = connector.sendGetRequest(urlVersion);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JsonNode forecastNodeVersion = rootNodeVersion.path("weather-widget/forecast");
        String urlForecast = makeUrlToGetForecast(forecastNodeVersion.asText());

        System.out.println(urlForecast);
        rootNodeForecast = connector.sendGetRequest(urlForecast);
        JsonNode data = rootNodeForecast.path("data");


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Mapping mapping = objectMapper.readValue(data.toString(), Mapping.class);

            String decodedCityName = mapping.convertCityName();
            System.out.println(decodedCityName);


            //String text = String.format("Weather in %s: \n%s", mapping.getCityName(), mapping.getCurrent().toString());
            StringBuilder text = new StringBuilder(String.format("Weather in %s \n%s", mapping.getCityName(), mapping.getCurrent().toString()));
            text.append(String.format(" %s", mapping.getWeatherSymbolName()));
            System.out.println(text.toString());

            //byte[] bytes = text.getBytes(StandardCharsets.ISO_8859_1);
            //String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);

            TelegramConnector tc = new TelegramConnector();

            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("chat_id", tc.chatId);
            jsonMap.put("text", text.toString());
            jsonMap.put("parse_mode", "HTML");
            String jsonArgs = objectMapper.writeValueAsString(jsonMap);

            String response = Connector.sendPostRequest(tc.getUrl(), jsonArgs);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static String makeUrlToGetForecast(String forecastNodeVersion) {
        return String.format("https://www.meteoschweiz.admin.ch/product/output/weather-widget/forecast/version__%s/en/531200.json", forecastNodeVersion);
    }
}