import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubUser {

    private long id;

    @JsonProperty("login") // numele proprietatii din obiectul json
                           // care trebuie mapat la username
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
