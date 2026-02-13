package style;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modele.Etudiant;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataService {

    private ApiClient api;
    private Gson gson;

    public DataService() {
        this.api = new ApiClient();
        this.gson = new Gson();
    }

    // Récupère la liste des étudiants depuis le Web
    public List<Etudiant> getListeEtudiants() {
        String json = api.get("etudiants"); // Appelle ton API PHP
        
        if (json != null) {
            // "Magie" Gson : Transforme le texte JSON en List<Etudiant>
            Type listType = new TypeToken<ArrayList<Etudiant>>(){}.getType();
            return gson.fromJson(json, listType);
        }
        return new ArrayList<>(); // Retourne liste vide si erreur
    }
}