import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegistrazioneServletTest {

    private static RegistrazioneSupport signup;

    @BeforeAll
    public static void init() {
        signup = Mockito.mock(RegistrazioneSupport.class);
    }

    @Test
    void SignupTestNameSurname1() {
        String inputName = "Tresy70";

        Mockito.when(signup.validateSignup(inputName)).thenReturn(false);
        assertFalse(signup.validateSignup(inputName));
    }
    @Test
    void SignupTestNameSurname2() {
        String inputName = "Tresy";
        String inputSurname = "Sorrent1no";
        Mockito.when(signup.validateSignup(inputName, inputSurname)).thenReturn(false);
        assertFalse(signup.validateSignup(inputName, inputSurname));
    }
    @Test
    void SignupTestEmail3() {
        String inputName = "Tresy";
        String inputSurname = "Sorrentino";
        String inputEmail = "t.sorrentino@gmail";

        Mockito.when(signup.validateSignup(inputName, inputSurname, inputEmail)).thenReturn(false);
        assertFalse(signup.validateSignup(inputName, inputSurname, inputEmail));
    }
    @Test
    void SignupTestEmail4() {
        String inputName = "Tresy";
        String inputSurname = "Sorrentino";
        String inputEmail = "t.sorrentino@gmail.com";
        String password = "Ag3";

        Mockito.when(signup.validateSignup(inputName, inputSurname, inputEmail, password)).thenReturn(false);
        assertFalse(signup.validateSignup(inputName, inputSurname, inputEmail, password));
    }
    @Test
    void SignupTestUsername5() {
        String inputName = "Tresy";
        String inputSurname = "Sorrentino";
        String inputEmail = "t.sorrentino@gmail.com";
        String inputPassword = "Arianagrande02";
        Mockito.when(signup.validateSignup(inputName, inputSurname, inputEmail, inputPassword )).thenReturn(true);
        assertTrue(signup.validateSignup(inputName, inputSurname, inputEmail, inputPassword ));
    }
}