package ch.dememos;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Connector {
    public static final String JSON_CONTENT_TYPE="application/json";

    public static JsonNode sendGetRequest(String url) throws IOException {
        JsonNode rootNode = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);

                ObjectMapper objectMapper = new ObjectMapper();
                rootNode = objectMapper.readTree(result);

            }
        return rootNode;
    }

    public static String sendPostRequest(String actionAdr, String args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(actionAdr);
        httpPost.setHeader("Content-Type", JSON_CONTENT_TYPE);

        StringEntity entity = new StringEntity(args, "UTF-8");
        httpPost.setEntity(entity);

        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            return EntityUtils.toString(response.getEntity());
        }
    }
}
