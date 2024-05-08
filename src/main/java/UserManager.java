import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, UserAccount> accounts; // Almacenamiento para las cuentas de usuario
    private UserAccount currentUser; // Usuario actualmente cargado

    public UserManager() {
        this.accounts = new HashMap<>(); // Inicializa el almacenamiento de cuentas
    }

    // Método para añadir usuarios al sistema para poder luego cargarlos
    public void addUser(String alias, UserAccount user) {
        accounts.put(alias, user);
    }

    // Método para cargar un usuario según su alias
    public void loadUser(String alias) {
        currentUser = accounts.get(alias);
        if (currentUser == null) {
            System.out.println("Usuario no encontrado.");
        } else {
            System.out.println("Usuario " + alias + " cargado correctamente.");
        }
    }

    // Método para obtener el usuario actualmente cargado
    public UserAccount getCurrentUser() {
        return currentUser;
    }

    // Otros métodos que podrías necesitar
}