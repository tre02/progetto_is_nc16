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
    void AggiuntaEventoTest1(){
        String nomeEvento = "Love is in the air, the musical";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(nomeEvento));
    }
    @Test
    void AggiuntaEventoTest2(){
        String nomeEvento = "Love air the musical";
        String data = "24-09-2010";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(nomeEvento, data));
    }
    @Test
    void AggiuntaEventoTest3(){
        String nomeEvento = "Love air the musical";
        String data = "24/09/2024";
        String luogo = "Città sant@Angelo";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data, luogo)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(nomeEvento, data, luogo));
    }
    @Test
    void AggiuntaEventoTest4(){
        String nomeEvento = "Love air the musical";
        String data = "24-09-2024";
        String luogo = "Città sant'Angelo";
        String ora = "50:18";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data, luogo, ora)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(nomeEvento, data, luogo, ora));
    }
    @Test
    void AggiuntaEventoTest5(){
        String nomeEvento = "Love air the musical";
        String data = "24-09-2024";
        String ora = "18:10";
        String luogo = "Città sant'Angelo";
        String tipoEvento = "";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora,luogo, tipoEvento)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora,luogo, tipoEvento));
    }
    @Test
    void AggiuntaEventoTest6(){
        String nomeEvento = "Love air the musical";
        String data = "24-09-2024";
        String ora = "18:10";
        String luogo = "Città sant'Angelo";
        String tipoEvento = "Concerto";
        String numeroPosti = "53,5";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento,numeroPosti, luogo)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento,numeroPosti, luogo));
    }
    @Test
    void AggiuntaEventoTest7(){
        String nomeEvento = "Love air the musical";
        String data = "24-09-2024";
        String ora = "18:10";
        String luogo = "Città sant'Angelo";
        String tipoEvento = "Concerto";
        String numeroPosti = "55";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento,numeroPosti, luogo)).thenReturn(true);
        assertTrue(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento,numeroPosti, luogo));
    }
}
