import java.util.HashMap;
import java.util.ResourceBundle;

public class I18NManager {
    private static I18NManager instance;

    //Diccionari
    private HashMap<String, ResourceBundle> data = new HashMap<>();

    private I18NManager() {}

    public static I18NManager getInstance(){
        if (instance == null) instance = new I18NManager();
        return instance;
    }

    public String getText(String lang, String key) {
        ResourceBundle rb = data.get(lang);

        if (rb == null) {
            rb = ResourceBundle.getBundle(lang);
            data.put(lang, rb);
        }

        return rb.getString(key);
    }

    public void clear() {
        data.clear();
    }
}
