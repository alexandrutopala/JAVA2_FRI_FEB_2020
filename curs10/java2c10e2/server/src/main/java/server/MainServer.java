package server;

import com.fasterxml.jackson.databind.ObjectMapper;
import lib.Message;
import spark.Spark;

public class MainServer {

    public static void main(String[] args) {
        Spark.port(9000);
        Spark.init();

        Spark.post("/message", (request, response) -> {

            String body = request.body();

            ObjectMapper mapper = new ObjectMapper();

            Message message = mapper.readValue(body, Message.class);

            System.out.println(message.getContent());

            return null;
        });

        Spark.get("/message", (request, response) -> {
            Message message = new Message("hello");

            ObjectMapper mapper = new ObjectMapper();

            String json = mapper.writeValueAsString(message);

            return json;
        });

        Spark.get("/my/custom/path", (request, response) -> "my way");

    }


}
