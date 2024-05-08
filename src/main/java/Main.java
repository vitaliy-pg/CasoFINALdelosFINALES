import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main extends JFrame {
    private static UserAccount currentUser; // Declaración de currentUser

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, UserAccount> accounts = new HashMap<>();
    private JTextField aliasField;
    private JTextField emailField;
    private JTextField userAliasField;
    private JTextField otherUserAliasField;
    private JTextField tweetAliasField;
    private JTextField tweetContentField;
    private JTextField retweetAliasField;
    private JTextField originalSenderAliasField;
    private JTextField retweetMessageField;
    private JTextField dmSenderAliasField;
    private JTextField dmReceiverAliasField;
    private JTextField dmMessageField;
    private JTextArea sortedUsersArea;

    public  Main() {

        super("Twitter Mini");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(13, 2, 10, 10));

        addComponent(mainPanel, "Create User Account", createTextField("Alias:"), aliasField = new JTextField());
        addComponent(mainPanel, "", createTextField("Email:"), emailField = new JTextField());
        JButton createUserButton = createButton("Create User Account", e -> createUserAccount());
        mainPanel.add(new JLabel());
        mainPanel.add(createUserButton);

        addComponent(mainPanel, "Follow User", createTextField("Your Alias:"), userAliasField = new JTextField());
        addComponent(mainPanel, "", createTextField("Other User's Alias:"), otherUserAliasField = new JTextField());
        JButton followUserButton = createButton("Follow User", e -> followUser());
        mainPanel.add(new JLabel());
        mainPanel.add(followUserButton);

        addComponent(mainPanel, "Post Tweet", createTextField("Alias:"), tweetAliasField = new JTextField());
        addComponent(mainPanel, "", createTextField("Tweet Content:"), tweetContentField = new JTextField());
        JButton postTweetButton = createButton("Post Tweet", e -> postTweet());
        mainPanel.add(new JLabel());
        mainPanel.add(postTweetButton);

        addComponent(mainPanel, "Retweet", createTextField("Alias:"), retweetAliasField = new JTextField());
        addComponent(mainPanel, "", createTextField("Original Sender's Alias:"), originalSenderAliasField = new JTextField());
        addComponent(mainPanel, "", createTextField("Retweet Message:"), retweetMessageField = new JTextField());
        JButton retweetButton = createButton("Retweet", e -> retweet());
        mainPanel.add(new JLabel());
        mainPanel.add(retweetButton);

        // Send Direct Message
        addComponent(mainPanel, "Send Direct Message", createTextField("Sender Alias:"), dmSenderAliasField = new JTextField());
        addComponent(mainPanel, "", createTextField("Receiver Alias:"), dmReceiverAliasField = new JTextField());
        addComponent(mainPanel, "", createTextField("Message:"), dmMessageField = new JTextField());
        JButton dmButton = createButton("Send Direct Message", e -> sendDirectMessage());
        mainPanel.add(new JLabel());
        mainPanel.add(dmButton);

        // Show Account Info
        addComponent(mainPanel, "Show Account Info", createTextField("Alias:"), aliasField = new JTextField());
        JButton showAccountInfoButton = createButton("Show Account Info", e -> showAccountInfo());
        mainPanel.add(new JLabel());
        mainPanel.add(showAccountInfoButton);

        // Load User
        addComponent(mainPanel, "Load User", createTextField("Alias:"), aliasField = new JTextField());
        JButton loadUserButton = createButton("Load User", e -> loadUser(aliasField.getText()));
        mainPanel.add(new JLabel());
        mainPanel.add(loadUserButton);

        // Sort Users by Email
        JButton sortByEmailButton = createButton("Sort Users by Email", e -> sortByEmail());
        mainPanel.add(new JLabel());
        mainPanel.add(sortByEmailButton);

        sortedUsersArea = new JTextArea(); // Inicialización del campo sortedUsersArea
        sortedUsersArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(sortedUsersArea);
        mainPanel.add(scrollPane);

        getContentPane().add(mainPanel);
    }



    private void addComponent(JPanel panel, String label, Component... components) {
        panel.add(new JLabel(label));
        for (Component component : components) {
            panel.add(component);
        }
    }

    private JTextField createTextField(String label) {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField.setToolTipText(label);
        return textField;
    }

    private JButton createButton(String label, ActionListener actionListener) {
        JButton button = new JButton(label);
        button.addActionListener(actionListener);
        return button;
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

    private static void followUser () {
        System.out.print ( "Enter your alias: " );
        String yourAlias = scanner.nextLine ();
        System.out.print ( "Enter the alias of the user you want to follow: " );
        String otherAlias = scanner.nextLine ();

        UserAccount yourAccount = accounts.get ( yourAlias );
        UserAccount otherAccount = accounts.get ( otherAlias );

        if (yourAccount == null || otherAccount == null) {
            System.out.println ( "One or both aliases do not exist." );
            return;
        }

        yourAccount.follow ( otherAccount );
        System.out.println ( yourAlias + " is now following " + otherAlias );
    }

    private static void postTweet () {
        System.out.print ( "Enter your alias: " );
        String alias = scanner.nextLine ();
        System.out.print ( "Enter tweet content: " );
        String content = scanner.nextLine ();

        UserAccount account = accounts.get ( alias );
        if (account == null) {
            System.out.println ( "Alias does not exist." );
            return;
        }

        Tweet tweet = new Tweet ( account, content );
        account.tweet ( tweet );
        System.out.println ( "Tweet posted." );

        try {
            Tweet newTweet = new Tweet(currentUser, content);
            currentUser.tweet(newTweet);
            System.out.println("Tweet publicado: " + content);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    private static void retweet () {
        System.out.print ( "Enter your alias: " );
        String alias = scanner.nextLine ();
        System.out.print ( "Enter the original tweet sender's alias: " );
        String originalSenderAlias = scanner.nextLine ();
        System.out.print ( "Enter your message for the retweet: " );
        String retweetMessage = scanner.nextLine ();

        UserAccount retweeter = accounts.get ( alias );
        UserAccount originalSender = accounts.get ( originalSenderAlias );

        if (retweeter == null || originalSender == null) {
            System.out.println ( "One or both aliases do not exist." );
            return;
        }

        // Assumption: the original Tweet is the last one sent by the original sender
        Tweet originalTweet = originalSender.getTweets ().get ( originalSender.getTweets ().size () - 1 );
        Retweet retweet = new Retweet ( retweeter, retweetMessage, originalTweet );
        retweeter.tweet ( retweet );
        System.out.println ( "Retweet posted." );
    }

    private static void sendDirectMessage () {
        System.out.print ( "Enter your alias: " );
        String senderAlias = scanner.nextLine ();
        System.out.print ( "Enter the receiver's alias: " );
        String receiverAlias = scanner.nextLine ();
        System.out.print ( "Enter your message: " );
        String message = scanner.nextLine ();

        UserAccount sender = accounts.get ( senderAlias );
        UserAccount receiver = accounts.get ( receiverAlias );

        if (sender == null || receiver == null) {
            System.out.println ( "One or both aliases do not exist." );
            return;
        }

        DirectMessage dm = new DirectMessage ( sender, receiver, message );
        System.out.println ( "Direct message sent." );
    }

    private static void showAccountInfo () {
        System.out.print ( "Enter alias: " );
        String alias = scanner.nextLine ();

        UserAccount account = accounts.get ( alias );
        if (account == null) {
            System.out.println ( "Alias does not exist." );
            return;
        }

        System.out.println ( account );
        System.out.println ( "Tweets:" );
        for (Tweet tweet : account.getTweets ()) {
            System.out.println ( tweet );
        }
        System.out.println ( "Timeline:" );
        for (Tweet tweet : account.getTimeline ()) {
            System.out.println ( tweet );
        }
    }

    private static void loadUser(String alias) {
        currentUser = accounts.get(alias);
        if (currentUser == null) {
            System.out.println("Usuario no encontrado.");
        } else {
            System.out.println("Usuario " + alias + " cargado correctamente.");
        }
    }

    private void sortByEmail() {
        List<UserAccount> userList = new ArrayList<>(accounts.values());
        userList.sort(Comparator.comparing(u -> u.getEmail().toString()));

        StringBuilder sortedUsersText = new StringBuilder();
        sortedUsersText.append("Usuarios ordenados por email:\n");
        for (UserAccount user : userList) {
            sortedUsersText.append(user.getEmail().toString()).append("\n");
        }
        sortedUsersArea.setText(sortedUsersText.toString());
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.setVisible(true);
    }
}

