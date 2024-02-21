public class RegistrazioneSupport {
    public RegistrazioneSupport () {}

    public boolean validateSyntaxNameSurname(String input) {
        return input.matches("^[a-zA-Z\\s]+$");
    }


    public boolean validateSyntaxEmail (String email) {
        return email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
    }

    public boolean validateLenghtPassword(String password) {
        return password.length() >= 6 && password.length() <= 20;
    }


    public boolean validateSignup(String name) {
        return validateSyntaxNameSurname(name);
    }

    public boolean validateSignup(String name, String surname) {
        return validateSyntaxNameSurname(name) && validateSyntaxNameSurname(surname);
    }
    public boolean validateSignup(String name, String surname,String email) {
        return validateSyntaxNameSurname(name) && validateSyntaxNameSurname(surname)
                && validateSyntaxEmail(email);
    }

    public boolean validateSignup(String name, String surname,String email, String password) {
        return validateSyntaxNameSurname(name) && validateSyntaxNameSurname(surname)
                && validateSyntaxEmail(email) && validateLenghtPassword(password);
    }
}