import model.UtenteDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RimuoviAccountServletTest {

    @Test
    public void testRimozioneAccount1(){
        String email = "l.greco@gmail.com";
        String password = "mf1";
        UtenteDAO testDao = new UtenteDAO();
        Boolean result = testDao.doDelete(email, password);
        assertFalse(result);
    }
    @Test
    public void testRimozioneAccount2(){
        String email = "l.greco@gmail.com";
        String password = "luca03";
        UtenteDAO testDao = new UtenteDAO();
        Boolean result = testDao.doDelete(email, password);
        assertTrue(result);
    }



}
