import java.util.ArrayList;
import java.util.List;


public class UserAccount {
    private String alias;
    private Email email;
    private List<Tweet> tweets;
    private List<UserAccount> following;
    private List<Tweet> timeline;


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

