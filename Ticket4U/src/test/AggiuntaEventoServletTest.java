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
        String inputName = "Kendrick Lamar Tour";
        Mockito.when(aggiuntaEventoSupport.validateEvento(inputName)).thenReturn(true);
        assertTrue(aggiuntaEventoSupport.validateEvento(inputName));
    }
    @Test
    void AggiuntaEventoTestNomeEvento2() {
        String inputName = "Kendrick Lamar - Mr. Morale And The Big Steppers Tour";
        Mockito.when(aggiuntaEventoSupport.validateEvento(inputName)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(inputName));
    }

    @Test
    void AggiuntaEventoTestData1(){
        String data = "10-01-2024";
        Mockito.when(aggiuntaEventoSupport.validateEvento(data)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(data));
    }
    @Test
    void AggiuntaEventoTestData2(){
        String data = "10-01-2025";
        Mockito.when(aggiuntaEventoSupport.validateEvento(data)).thenReturn(true);
        assertTrue(aggiuntaEventoSupport.validateEvento(data));
    }
    @Test
    void AggiuntaEventoTestData3(){
        String data = "";
        Mockito.when(aggiuntaEventoSupport.validateEvento(data)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(data));
    }
    @Test
    void AggiuntaEventoTestLuogo1(){
        String luogo = "Sant'Antimo";
        Mockito.when(aggiuntaEventoSupport.validateEvento(luogo)).thenReturn(true);
        assertTrue(aggiuntaEventoSupport.validateEvento(luogo));
    }
    @Test
    void AggiuntaEventoTestLuogo2(){
        String luogo = "Sant'@ntimo";
        Mockito.when(aggiuntaEventoSupport.validateEvento(luogo)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(luogo));
    }
    @Test
    void AggiuntaEventoTestTipo1(){
        String tipoEvento = "Concerto";
        Mockito.when(aggiuntaEventoSupport.validateEvento(tipoEvento)).thenReturn(true);
        assertTrue(aggiuntaEventoSupport.validateEvento(tipoEvento));
    }
    @Test
    void AggiuntaEventoTestTipo2(){
        String tipoEvento = "Concert";
        Mockito.when(aggiuntaEventoSupport.validateEvento(tipoEvento)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(tipoEvento));
    }

    @Test
    void AggiuntaEventoTest1(){
        String nomeEvento = "Kendrick Lamar - Mr. Morale Tour";
        String data = "10/01/2025";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data)).thenReturn(true);
        assertTrue(aggiuntaEventoSupport.validateEvento(nomeEvento, data));
    }
    @Test
    void AggiuntaEventoTest2(){
        String nomeEvento = "Kendrick Lamar - Mr. Morale Tour";
        String data = "10/01/20255";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(nomeEvento, data));
    }
    @Test
    void AggiuntaEventoTest3(){
        String nomeEvento = "Kendrick Lamar - Mr. Morale Tour";
        String data = "10/01/2025";
        String ora = "22:00";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora)).thenReturn(true);
        assertTrue(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora));
    }
    @Test
    void AggiuntaEventoTest4(){
        String nomeEvento = "Kendrick Lamar - Mr. Morale Tour";
        String data = "10/01/2025";
        String ora = "22:00:00";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora));
    }
    @Test
    void AggiuntaEventoTest5(){
        String nomeEvento = "Kendrick Lamar - Mr. Morale Tour";
        String data = "10/01/2025";
        String ora = "22:00:00";
        String tipoEvento = "Concert";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento));
    }
    @Test
    void AggiuntaEventoTest6(){
        String nomeEvento = "Kendrick Lamar - Mr. Morale Tour";
        String data = "10/01/20255";
        String ora = "22:00:00";
        String tipoEvento = "Concerto";
        String numeroPosti = "-200";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento, numeroPosti)).thenReturn(false);
        assertFalse(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento, numeroPosti));
    }
    @Test
    void AggiuntaEventoTest7(){
        String nomeEvento = "Kendrick Lamar - Mr. Morale Tour";
        String data = "10/01/2025";
        String ora = "22:00";
        String tipoEvento = "Concerto";
        String numeroPosti = "200";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento, numeroPosti)).thenReturn(true);
        assertTrue(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento, numeroPosti));
    }

    @Test
    void AggiuntaEventoTest8(){
        String nomeEvento = "Kendrick Lamar - Mr. Morale Tour";
        String data = "10/01/2025";
        String ora = "22:00";
        String tipoEvento = "Concerto";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento)).thenReturn(true);
        assertTrue(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento));
    }
    @Test
    void AggiuntaEventoTest9(){
        String nomeEvento = "Kendrick Lamar Tour";
        String data = "10/01/2025";
        String ora = "22:00";
        String tipoEvento = "Concerto";
        String numeroPosti = "200";
        String luogo = "Forum Milano";
        Mockito.when(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento, numeroPosti, luogo)).thenReturn(true);
        assertTrue(aggiuntaEventoSupport.validateEvento(nomeEvento, data, ora, tipoEvento, numeroPosti, luogo));
    }

}
