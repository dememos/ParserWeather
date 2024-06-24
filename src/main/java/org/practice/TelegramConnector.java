package org.practice;

import io.github.cdimascio.dotenv.Dotenv;

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


}
