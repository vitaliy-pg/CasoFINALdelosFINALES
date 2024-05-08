import java.time.LocalDateTime;

public class Tweet {
    private LocalDateTime time;
    private String message;
    private UserAccount sender;

    public Tweet(UserAccount sender, String message) {
        this.sender = sender;
        this.message = message;
        this.time = LocalDateTime.now();

        if (message.length() > 140) {
            throw new IllegalArgumentException("Message cannot exceed 140 characters.");
        }
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public UserAccount getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "Tweet from " + sender + " at " + time + ": \"" + message + "\"";
    }
}