import model.Evento;
import model.EventoDAO;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class AggiuntaEventoServletTest {
    public static AggiuntaEventoSupport aggiuntaEventoSupport;

    @BeforeAll
    public static void init() {
        aggiuntaEventoSupport = Mockito.mock(AggiuntaEventoSupport.class);
    }

    @Test
    void AggiuntaEventoTestNomeEvento1() {
        String inputName = "Kendrick Lamar - Mr. Morale Tour";

        Mockito.when(aggiuntaEventoSupport.validateEvento(inputName)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(inputName));
    }
    @Test
    void AggiuntaEventoTestNomeEvento2() {
        String inputName = "Kend";

        Mockito.when(aggiuntaEventoSupport.validateEvento(inputName)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(inputName));
    }


}
