import java.io.*;
import java.util.HashMap;

public class FileHandler {
    public static HashMap<String, UserAccount> loadUsersFromFile(String filename) throws IOException {
        HashMap<String, UserAccount> users = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                // Suponemos que userData[0] es alias, userData[1] es email
                users.put(userData[0], new UserAccount(userData[0], new Email(userData[1])));
            }
        }
        return users;
    }
}
