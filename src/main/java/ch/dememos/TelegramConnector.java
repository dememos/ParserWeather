package ch.dememos;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.HashMap;
import java.util.Map;

public class TelegramConnector {
    static String token = "";
    static String chatId = "";

    TelegramConnector() {
        Dotenv dotenv = Dotenv.load();
        token = dotenv.get("TELEGRAM_TOKEN");
        chatId = dotenv.get("CHAT_ID");
    }

    public static String getUrl() {
        String url = String.format("https://api.telegram.org/bot%s/sendMessage", token);
        return url;
    }

    public String sendMessage(String text) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("chat_id", chatId);
        jsonMap.put("text", text);
        jsonMap.put("parse_mode", "HTML");

        String jsonArgs = objectMapper.writeValueAsString(jsonMap);
        return Connector.sendPostRequest(getUrl(), jsonArgs);
    }


}
