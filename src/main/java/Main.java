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
            System.out.println("4. Show Account Info");
            System.out.println("5. Exit");
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
                    showAccountInfo();
                    break;
                case 5:
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



    }
