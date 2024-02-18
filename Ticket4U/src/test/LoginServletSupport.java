import model.UtenteDAO;

public class LoginServletSupport {
    public LoginServletSupport(){}

    public boolean validateLogin(String email, String password){
        UtenteDAO dao = new UtenteDAO();
        return dao.doRetrieveByEmailPassword(email, password) != null;
    }

}
