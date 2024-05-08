public class Retweet extends Tweet {
    private Tweet originalTweet;

    public Retweet(UserAccount sender, String message, Tweet originalTweet) {
        super(sender, message);
        this.originalTweet = originalTweet;
        if (message.length() > 140) {
            throw new IllegalArgumentException("Message cannot exceed 140 characters.");
        }
    }

    public Tweet getOriginalTweet() {
        return originalTweet;
    }

    @Override
    public String toString() {
        return "Retweet by " + getSender() + " at " + getTime() + ": \"" + getMessage() + "\"\nOriginal tweet: " + originalTweet;
    }
}
