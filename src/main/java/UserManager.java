import java.util.*;

public class UserManager {
    private Map<String, UserAccount> accounts; // Almacena las cuentas de usuario
    private UserAccount currentUser; // Usuario actualmente cargado en sesión

    public UserManager() {
        this.accounts = new HashMap<>(); // Inicializar el mapa de cuentas
    }

    /**
     * Intenta cargar un usuario basado en el alias proporcionado.
     * Establece el usuario cargado como el 'currentUser' si se encuentra.
     * @param alias el alias del usuario a cargar
     */
    public void loadUser(String alias) {
        currentUser = accounts.get(alias);
        if (currentUser == null) {
            System.out.println("Usuario no encontrado.");
        } else {
            System.out.println("Usuario " + alias + " cargado correctamente.");
        }
    }

    /**
     * Añade un usuario al sistema.
     * @param alias el alias único para el usuario
     * @param user la cuenta de usuario a añadir
     */
    public void addUser(String alias, UserAccount user) {
        accounts.put(alias, user);
    }

    /**
     * Devuelve el usuario actualmente cargado.
     * @return el usuario cargado actualmente
     */
    public UserAccount getCurrentUser() {
        return currentUser;


    }


    public void sortByEmail() {
        List<UserAccount> userList = new ArrayList<> (accounts.values());
        userList.sort( Comparator.comparing( u -> u.getEmail().toString()));
        System.out.println("Usuarios ordenados por email:");
        userList.forEach(u -> System.out.println(u.getEmail().toString()));
    }
}