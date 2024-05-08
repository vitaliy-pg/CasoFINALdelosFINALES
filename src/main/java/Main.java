import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Main extends JFrame {
    private static HashMap<String, UserAccount> accounts = new HashMap<>();
    private static UserAccount currentUser;  // Usuario actualmente cargado
    private static Scanner scanner = new Scanner(System.in);

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

    public Main() {
        super("Twitter Mini");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(10, 2));

        JButton createUserButton = new JButton("Create User Account");
        createUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createUserAccount();
            }
        });
        mainPanel.add(new JLabel("Alias:"));
        aliasField = new JTextField();
        mainPanel.add(aliasField);
        mainPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        mainPanel.add(emailField);
        mainPanel.add(createUserButton);

        JButton followUserButton = new JButton("Follow User");
        followUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                followUser();
            }
        });
        mainPanel.add(new JLabel("Your Alias:"));
        userAliasField = new JTextField();
        mainPanel.add(userAliasField);
        mainPanel.add(new JLabel("Other User's Alias:"));
        otherUserAliasField = new JTextField();
        mainPanel.add(otherUserAliasField);
        mainPanel.add(followUserButton);

        JButton postTweetButton = new JButton("Post Tweet");
        postTweetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                postTweet();
            }
        });
        mainPanel.add(new JLabel("Alias:"));
        tweetAliasField = new JTextField();
        mainPanel.add(tweetAliasField);
        mainPanel.add(new JLabel("Tweet Content:"));
        tweetContentField = new JTextField();
        mainPanel.add(tweetContentField);
        mainPanel.add(postTweetButton);

        JButton retweetButton = new JButton("Retweet");
        retweetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retweet();
            }
        });
        mainPanel.add(new JLabel("Alias:"));
        retweetAliasField = new JTextField();
        mainPanel.add(retweetAliasField);
        mainPanel.add(new JLabel("Original Sender's Alias:"));
        originalSenderAliasField = new JTextField();
        mainPanel.add(originalSenderAliasField);

        mainPanel.add(new JLabel("Retweet Message:"));
        retweetMessageField = new JTextField();
        mainPanel.add(retweetMessageField);
        mainPanel.add(retweetButton);

        JButton dmButton = new JButton("Send Direct Message");
        dmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendDirectMessage();
            }
        });
        mainPanel.add(new JLabel("Sender Alias:"));
        dmSenderAliasField = new JTextField();
        mainPanel.add(dmSenderAliasField);
        mainPanel.add(new JLabel("Receiver Alias:"));
        dmReceiverAliasField = new JTextField();
        mainPanel.add(dmReceiverAliasField);
        mainPanel.add(new JLabel("Message:"));
        dmMessageField = new JTextField();
        mainPanel.add(dmMessageField);
        mainPanel.add(dmButton);

        JButton showAccountInfoButton = new JButton("Show Account Info");
        showAccountInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAccountInfo();
            }
        });
        mainPanel.add(new JLabel("Alias:"));
        JTextField aliasField = new JTextField();


        mainPanel.add(aliasField);
        mainPanel.add(showAccountInfoButton);

        JButton loadUserButton = new JButton("Load User");
        loadUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadUser(aliasField.getText());
            }
        });
        mainPanel.add(new JLabel("Alias:"));
        mainPanel.add(aliasField);
        mainPanel.add(loadUserButton);

        JButton sortByEmailButton = new JButton("Sort Users by Email");
        sortByEmailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortByEmail();
            }
        });
        mainPanel.add(new JLabel(""));
        mainPanel.add(sortByEmailButton);


        sortedUsersArea = new JTextArea(); // Inicialización del campo sortedUsersArea
        sortedUsersArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(sortedUsersArea);
        mainPanel.add(scrollPane);



        // Add more components for other functionalities...

        getContentPane().add(mainPanel);
    }


    private static void createUserAccount () {
        System.out.print ( "Enter alias: " );
        String alias = scanner.nextLine ();
        System.out.print ( "Enter email: " );
        String emailString = scanner.nextLine ();
        Email email = new Email ( emailString ); // Asumimos que el constructor de Email está implementado correctamente

        try {
            UserAccount newAccount = new UserAccount ( alias, email );
            accounts.put ( alias, newAccount );
            System.out.println ( "User account created successfully." );
        } catch (IllegalArgumentException e) {
            System.out.println ( "Error: " + e.getMessage () );
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
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main main = new Main();
                main.setVisible(true);
            }
        });
    }
}

