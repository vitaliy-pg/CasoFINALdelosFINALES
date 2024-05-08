import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

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

    public void follow(UserAccount otherUser) {
        if (this == otherUser || following.contains(otherUser)) {
            return;
        }
        following.add(otherUser);
        otherUser.addFollower(this);
    }

    private void addFollower(UserAccount follower) {
        follower.timeline.addAll(this.tweets);
    }

    public void tweet(Tweet newTweet) {
        tweets.add(newTweet);
        for (UserAccount follower : following) {
            follower.timeline.add(newTweet);
        }
    }


    @Override
    public String toString() {
        return "UserAccount{" +
                "alias='" + alias + '\'' +
                ", email=" + email +
                '}';
    }

    // Métodos para obtener listas para el 'main'
    public List<Tweet> getTimeline() {
        return timeline;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }


    public Email getEmail() {
        return email;
    }
}