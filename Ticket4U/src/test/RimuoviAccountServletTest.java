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
        String password = "nsora1001";
        UtenteDAO testDao = new UtenteDAO();
        Boolean result = testDao.doDelete(email, password);
        assertTrue(result);
    }
    @Test
    public void testRimozioneAccount2(){
        String email = "n.sora@libero.it";
        String password = "nsroa1005";
        UtenteDAO testDao = new UtenteDAO();
        Boolean result = testDao.doDelete(email, password);
        assertFalse(result);
    }


}
