import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, UserAccount> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nTwitter Mini:");
            System.out.println("1. Create User Account");
            System.out.println("2. Follow User");
            System.out.println("3. Post Tweet");
            System.out.println("4. Retweet");
            System.out.println("5. Send Direct Message");
            System.out.println("6. Show Account Info");
            System.out.println("7. Exit");
            System.out.print("Enter option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    createUserAccount();
                    break;
                case 2:
                    followUser();
                    break;
                case 3:
                    postTweet();
                    break;
                case 4:
                    retweet();
                    break;
                case 5:
                    sendDirectMessage();
                    break;
                case 6:
                    showAccountInfo();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void createUserAccount() {
        System.out.print("Enter alias: ");
        String alias = scanner.nextLine();
        System.out.print("Enter email: ");
        String emailString = scanner.nextLine();
        Email email = new Email(emailString); // Asumimos que el constructor de Email está implementado correctamente

        try {
            UserAccount newAccount = new UserAccount(alias, email);
            accounts.put(alias, newAccount);
            System.out.println("User account created successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void followUser() {
        System.out.print("Enter your alias: ");
        String yourAlias = scanner.nextLine();
        System.out.print("Enter the alias of the user you want to follow: ");
        String otherAlias = scanner.nextLine();

        UserAccount yourAccount = accounts.get(yourAlias);
        UserAccount otherAccount = accounts.get(otherAlias);

        if (yourAccount == null || otherAccount == null) {
            System.out.println("One or both aliases do not exist.");
            return;
        }

        yourAccount.follow(otherAccount);
        System.out.println(yourAlias + " is now following " + otherAlias);
    }

    private static void postTweet() {
        System.out.print("Enter your alias: ");
        String alias = scanner.nextLine();
        System.out.print("Enter tweet content: ");
        String content = scanner.nextLine();

        UserAccount account = accounts.get(alias);
        if (account == null) {
            System.out.println("Alias does not exist.");
            return;
        }

        Tweet tweet = new Tweet(account, content);
        account.tweet(tweet);
        System.out.println("Tweet posted.");
    }

    private static void retweet() {
        System.out.print("Enter your alias: ");
        String alias = scanner.nextLine();
        System.out.print("Enter the original tweet sender's alias: ");
        String originalSenderAlias = scanner.nextLine();
        System.out.print("Enter your message for the retweet: ");
        String retweetMessage = scanner.nextLine();

        UserAccount retweeter = accounts.get(alias);
        UserAccount originalSender = accounts.get(originalSenderAlias);

        if (retweeter == null || originalSender == null) {
            System.out.println("One or both aliases do not exist.");
            return;
        }

        // Assumption: the original Tweet is the last one sent by the original sender
        Tweet originalTweet = originalSender.getTweets().get(originalSender.getTweets().size() - 1);
        Retweet retweet = new Retweet(retweeter, retweetMessage, originalTweet);
        retweeter.tweet(retweet);
        System.out.println("Retweet posted.");
    }

    private static void sendDirectMessage() {
        System.out.print("Enter your alias: ");
        String senderAlias = scanner.nextLine();
        System.out.print("Enter the receiver's alias: ");
        String receiverAlias = scanner.nextLine();
        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        UserAccount sender = accounts.get(senderAlias);
        UserAccount receiver = accounts.get(receiverAlias);

        if (sender == null || receiver == null) {
            System.out.println("One or both aliases do not exist.");
            return;
        }

        DirectMessage dm = new DirectMessage(sender, receiver, message);
        System.out.println("Direct message sent.");
    }

    private static void showAccountInfo() {
        System.out.print("Enter alias: ");
        String alias = scanner.nextLine();

        UserAccount account = accounts.get(alias);
        if (account == null) {
            System.out.println("Alias does not exist.");
            return;
        }

        System.out.println(account);
        System.out.println("Tweets:");
        for (Tweet tweet : account.getTweets()) {
            System.out.println(tweet);
        }
        System.out.println("Timeline:");
        for (Tweet tweet : account.getTimeline()) {
            System.out.println(tweet);
        }
    }

    private static HashMap<String, UserAccount> accounts;
    private static UserAccount currentUser;

    public static void loadUser(String alias) {
        currentUser = accounts.get(alias);
        if (currentUser == null) {
            System.out.println("Usuario no encontrado.");
        } else {
            System.out.println("Usuario " + alias + " cargado correctamente.");
        }
}

