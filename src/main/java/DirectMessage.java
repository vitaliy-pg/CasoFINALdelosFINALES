public class DirectMessage extends Tweet {
    private UserAccount receiver;

    public DirectMessage(UserAccount sender, UserAccount receiver, String message) {
        super(sender, message);
        this.receiver = receiver;
        if (message.length() > 140) {
            throw new IllegalArgumentException("Message cannot exceed 140 characters.");
        }
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return "Direct message from " + getSender() + " to " + receiver + " at " + getTime() + ": \"" + getMessage() + "\"";
    }
}