import model.UtenteDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RimuoviAccountServletTest {

    @Test
    public void testRimozioneAccount1(){
        String email = "n.sora@libero.it";
        String password = "nsroa1005";
        UtenteDAO testDao = new UtenteDAO();
        Boolean result = testDao.doDelete(email, password);
        assertFalse(result);
    }
    @Test
    public void testRimozioneAccount2(){
        String email = "n.sora@libero.it";
        String password = "nsora1001";
        UtenteDAO testDao = new UtenteDAO();
        Boolean result = testDao.doDelete(email, password);
        assertTrue(result);
    }



}
