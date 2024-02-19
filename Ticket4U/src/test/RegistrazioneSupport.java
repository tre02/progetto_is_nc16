import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RegistrazioneSupport {
    public RegistrazioneSupport () {}

    public boolean validateSyntaxNameSurname(String input) {
        return input.matches("^[a-zA-Z\\s]+$");
    }

    public boolean validateDate (String date) {
        String[] array = date.split("/");
        int anno = Integer.parseInt(array[2]);
        int mese = Integer.parseInt(array[1]);
        int giorno = Integer.parseInt(array[0]);

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(anno, mese, giorno);

        Period p = Period.between(birthday, today);

        if(p.getYears() < 18) {
            return false;
        } else {
            return true;
        }
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
    public boolean validateSignup(String name, String surname,String ddn) {
        return validateSyntaxNameSurname(name) && validateSyntaxNameSurname(surname)
                && validateDate(ddn);
    }

    public boolean validateSignup(String name, String surname,String email, String password) {
        return validateSyntaxNameSurname(name) && validateSyntaxNameSurname(surname)
                && validateSyntaxEmail(email) && validateLenghtPassword(password);
    }

    public boolean validateSignup(String name, String surname, String ddn, String email, String password) {
        return validateSyntaxNameSurname(name) && validateSyntaxNameSurname(surname)
                && validateDate(ddn) && validateSyntaxEmail(email)
                && validateLenghtPassword(password);
    }
}