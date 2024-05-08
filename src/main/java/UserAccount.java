import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    // Atributos
    private String alias;
    private Email email;
    private List<Tweet> tweets;
    private List<UserAccount> following;
    private List<Tweet> timeline;

    // Constructor
    public UserAccount(String alias, Email email) {
        if (!Utils.isValidEmail(email.toString())) {
            throw new IllegalArgumentException("Email inválido.");
        }
        if (!Utils.isValidAlias(alias)) {
            throw new IllegalArgumentException("Alias inválido.");
        }
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<>();
        this.following = new ArrayList<>();
        this.timeline = new ArrayList<>();
    }

    // Getters y Setters (si son necesarios)
    public String getAlias() {
        return alias;
    }

    public Email getEmail() {
        return email;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public List<UserAccount> getFollowing() {
        return following;
    }

    public List<Tweet> getTimeline() {
        return timeline;
    }

    // Métodos adicionales se definirán aquí (parte b y c)
}
