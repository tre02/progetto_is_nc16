import model.Utente;
import model.UtenteDAO;

public class LoginServletSupport {
    public LoginServletSupport(){}

    public boolean validateLogin(String email, String password){

        if(password.length()<=8){
            return false;
        } else if (!validateSyntaxEmail(email)) {
            return false;
        }
        UtenteDAO dao = new UtenteDAO();
        return dao.doRetrieveByEmailPassword(email, password) != null;
    }
    public boolean validateSyntaxEmail (String email) {
        return email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
    }
}
