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
        String inputName = "Giacomo23";

        Mockito.when(signup.validateSignup(inputName)).thenReturn(false);
        assertFalse(signup.validateSignup(inputName));
    }

    @Test
    void SignupTestNameSurname2() {
        String inputName = "Giacomo";

        Mockito.when(signup.validateSignup(inputName)).thenReturn(true);
        assertTrue(signup.validateSignup(inputName));
    }

    @Test
    void SignupTestNameSurname3() {
        String inputName = "Giacomo";
        String inputSurname = "Verdi1";

        Mockito.when(signup.validateSignup(inputName, inputSurname)).thenReturn(false);
        assertFalse(signup.validateSignup(inputName, inputSurname));
    }

    @Test
    void SignupTestNameSurname4() {
        String inputName = "Giacomo";
        String inputSurname = "Verdi";

        Mockito.when(signup.validateSignup(inputName, inputSurname)).thenReturn(true);
        assertTrue(signup.validateSignup(inputName, inputSurname));
    }

    @Test
    void SignupTestUsername5() {
        String inputName = "Giacomo";
        String inputSurname = "Verdi";
        String inputUsername = "Spark!";

        Mockito.when(signup.validateSignup(inputName, inputSurname, inputUsername)).thenReturn(false);
        assertFalse(signup.validateSignup(inputName, inputSurname, inputUsername));
    }

    @Test
    void SignupTestUsername6() {
        String inputName = "Giacomo";
        String inputSurname = "Verdi";
        String inputUsername = "";

        Mockito.when(signup.validateSignup(inputName, inputSurname, inputUsername)).thenReturn(true);
        assertTrue(signup.validateSignup(inputName, inputSurname, inputUsername));
    }

    @Test
    void SignupTestDate7() {
        String inputName = "Giacomo";
        String inputSurname = "Verdi";
        String inputUsername = "Spark";
        String inputDate = "09/06/2009";

        Mockito.when(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate)).thenReturn(false);
        assertFalse(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate));
    }

    @Test
    void SignupTestDate8() {
        String inputName = "Giacomo";
        String inputSurname = "Verdi";
        String inputUsername = "Spark";
        String inputDate = "09/06/2003";

        Mockito.when(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate)).thenReturn(true);
        assertTrue(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate));
    }

    @Test
    void SignupTestEmail9() {
        String inputName = "Giacomo";
        String inputSurname = "Verdi";
        String inputUsername = "Spark";
        String inputDate = "09/06/2001";
        String inputEmail = "giacomo.verdi@gmail";

        Mockito.when(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate, inputEmail)).thenReturn(false);
        assertFalse(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate, inputEmail));
    }

    @Test
    void SignupTestEmail10() {
        String inputName = "Giacomo";
        String inputSurname = "Verdi";
        String inputUsername = "Spark";
        String inputDate = "09/06/2003";
        String inputEmail = "giacomo.verdi@gmail";

        Mockito.when(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate, inputEmail)).thenReturn(true);
        assertTrue(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate, inputEmail));
    }

    @Test
    void SignupTestPassword11() {
        String inputName = "Giacomo";
        String inputSurname = "Verdi";
        String inputUsername = "Spark";
        String inputDate = "09/06/2003";
        String inputEmail = "giacomo.verdi@gmail";
        String inputPassword = "Spk09";

        Mockito.when(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate, inputEmail, inputPassword)).thenReturn(false);
        assertFalse(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate, inputEmail, inputPassword));
    }

    @Test
    void SignupTestPassword12() {
        String inputName = "Giacomo";
        String inputSurname = "Verdi";
        String inputUsername = "Spark";
        String inputDate = "09/06/2003";
        String inputEmail = "giacomo.verdi@gmail";
        String inputPassword = "Spk09!";
        String inputTelefono = "H477446LN4p?";

        Mockito.when(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate, inputEmail, inputPassword, inputTelefono)).thenReturn(false);
        assertFalse(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate, inputEmail, inputPassword, inputTelefono));
    }

    @Test
    void SignupTestPassword13() {
        String inputName = "Giacomo";
        String inputSurname = "Verdi";
        String inputUsername = "Spark";
        String inputDate = "09/06/2003";
        String inputEmail = "giacomo.verdi@gmail";
        String inputPassword = "Spk09!";
        String inputTelefono = "8609870038";

        Mockito.when(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate, inputEmail, inputPassword, inputTelefono)).thenReturn(true);
        assertTrue(signup.validateSignup(inputName, inputSurname, inputUsername, inputDate, inputEmail, inputPassword, inputTelefono));
    }
}