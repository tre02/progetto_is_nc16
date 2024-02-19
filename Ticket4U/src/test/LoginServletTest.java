import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginServletTest {

    private static LoginServletSupport login;

    @BeforeAll
    public static void init() {
         login = Mockito.mock(LoginServletSupport.class);
    }

    @Test
    public void LoginServletTest1(){
        String email = "s.vigorito@virgilio";
        String password = "Marefuori01";
        Mockito.when(login.validateLogin(email, password)).thenReturn(false);
        assertFalse(login.validateLogin(email, password));
    }
    @Test
    public void LoginServletTest2(){
        String email = "s.vigorito@virgilio.it";
        String password = "Mf1";
        Mockito.when(login.validateLogin(email, password)).thenReturn(false);
        assertFalse(login.validateLogin(email, password));
    }

    @Test
    public void LoginServletTest3(){
        String email = "s.vigorito@virgilio.it";
        String password = "Marefuori01";
        Mockito.when(login.validateLogin(email, password)).thenReturn(true);
        assertTrue(login.validateLogin(email, password));
    }
}
