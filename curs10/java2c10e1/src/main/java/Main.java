import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        HttpClient client = HttpClients.createDefault();

        // https://api.github.com
        String url = "https://api.github.com/users/alexandrutopala";
        HttpGet get = new HttpGet(url);

        HttpResponse response = client.execute(get);

        HttpEntity body = response.getEntity();

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false
        );

        GithubUser user = mapper.readValue(
                new InputStreamReader(body.getContent()),
                GithubUser.class
        );

        System.out.println(user);
    }
}
