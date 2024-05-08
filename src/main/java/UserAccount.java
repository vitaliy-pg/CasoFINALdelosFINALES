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
    public UserAccount ( String alias, Email email ) {
        if (!Utils.isValidEmail ( email.toString () )) {
            throw new IllegalArgumentException ( "Email inválido." );
        }
        if (!Utils.isValidAlias ( alias )) {
            throw new IllegalArgumentException ( "Alias inválido." );
        }
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<> ();
        this.following = new ArrayList<> ();
        this.timeline = new ArrayList<> ();
    }

    // Getters y Setters (si son necesarios)
    public String getAlias () {
        return alias;
    }

    public Email getEmail () {
        return email;
    }

    public List<Tweet> getTweets () {
        return tweets;
    }

    public List<UserAccount> getFollowing () {
        return following;
    }

    public List<Tweet> getTimeline () {
        return timeline;
    }

    public void follow ( UserAccount otherUser ) {
        if (this == otherUser || following.contains ( otherUser )) {
            // Si intenta seguirse a sí mismo o ya sigue al otro usuario, no hace nada
            return;
        }
        following.add ( otherUser );
        otherUser.addFollower ( this );
    }

    // Métodos adicionales se definirán aquí (parte b y c)
}

class Utils {
    // Método para validar el email
    public static boolean isValidEmail(String email) {
        return email.contains("@");
    }

    // Método para validar el alias
    public static boolean isValidAlias(String alias) {
        return alias.matches("^[a-zA-Z0-9]+$");
    }
}