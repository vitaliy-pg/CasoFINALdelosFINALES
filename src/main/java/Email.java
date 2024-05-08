public class Email {
    private String emailAddress;

    public Email(String emailAddress) {
        if (!Utils.isValidEmail(emailAddress)) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return emailAddress;
    }
}
