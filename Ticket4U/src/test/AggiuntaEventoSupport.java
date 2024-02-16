import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AggiuntaEventoSupport {
    public AggiuntaEventoSupport(){}
    public boolean checkDataFormato(String data) {
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
    public boolean checkLunghezzaNome(String nome) {
        int lunghezzaMinima = 8;
        int lunghezzaMassima = 50;

        int lunghezzaNome = nome.length();
        return lunghezzaNome >= lunghezzaMinima && lunghezzaNome <= lunghezzaMassima;
    }
    public boolean checkLuogo(String luogo) {
        String regex = "^[a-zA-ZÀ-ÿ\\s*]*$";
        return luogo.matches(regex);
    }
    public boolean checkFormatoOra(String ora) {
        String regex = "^\\d{2}:\\d{2}$";
        return ora.matches(regex);
    }
    public boolean checkNumeroPosti(String numeroPosti){
        return Integer.parseInt(numeroPosti) >= 0;
    }
    public boolean checkTipoEvento(String tipoEvento) {
        String[] opzioni = {"Concerto", "Sportivo", "Teatrale", "Cinema", "Museo"};
        for (String opzione : opzioni) {
            if (tipoEvento.equals(opzione)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateEvento(String nomeEvento){
        return checkLunghezzaNome(nomeEvento);
    }
    public boolean validateEvento(String nomeEvento, String data){
        return checkLunghezzaNome(nomeEvento) && checkDataFormato(data);
    }
    public boolean validateEvento(String nomeEvento, String data, String ora){
        return checkLunghezzaNome(nomeEvento) && checkDataFormato(data) && checkDataFormato(ora);
    }
    public boolean validateEvento(String nomeEvento, String data, String ora, String tipoEvento){
        return checkLunghezzaNome(nomeEvento) && checkDataFormato(data) && checkDataFormato(ora) && checkTipoEvento(tipoEvento);
    }
    public boolean validateEvento(String nomeEvento, String data, String ora, String tipoEvento, String numeroPosti){
        return checkLunghezzaNome(nomeEvento) && checkDataFormato(data) && checkDataFormato(ora) && checkTipoEvento(tipoEvento) && checkNumeroPosti(numeroPosti);
    }
}
