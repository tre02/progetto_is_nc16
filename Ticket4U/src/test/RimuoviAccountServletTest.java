import model.Utente;
import model.UtenteDAO;
import model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class RimuoviAccountServletTest {

    @Test
    public void testRimozioneAccount1(){
        String email = "n.sora@libero.it";
        String password = "nsroa1001";
        Utente test = new Utente();
        UtenteDAO testDao = new UtenteDAO();
        test.setEmail(email);
        test.setPassword(password);
        Boolean result = testDao.doDelete(test);
        assertTrue(result);
    }
    @Test
    public void testRimozioneAccount2(){
        String email = "n.sora@libero.it";
        String password = "nsroa1005";
        Utente test = new Utente();
        UtenteDAO testDao = new UtenteDAO();
        test.setEmail(email);
        test.setPassword(password);
        Boolean result = testDao.doDelete(test);
        assertTrue(result);
    }


}
