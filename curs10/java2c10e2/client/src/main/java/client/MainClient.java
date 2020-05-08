package client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lib.Message;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MainClient {

    public static void main(String[] args) throws IOException {
        HttpClient client = HttpClients.createDefault();

        HttpPost post = new HttpPost("http://localhost:9000/message");

        Message message = new Message("hello from client");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(message);

        HttpEntity body = new StringEntity(json);

        post.setEntity(body);

        client.execute(post);
    }
}
