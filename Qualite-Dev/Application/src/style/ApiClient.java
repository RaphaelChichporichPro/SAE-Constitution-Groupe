package style;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ApiClient {

    // -------------------------------------------------------------------------
    // ⚠️ REMPLACE ICI PAR TON URL EXACTE (Attention aux majuscules/minuscules)
    // Exemple : "https://webdev.iut-orsay.fr/~tonLogin/tonDossier/api/index.php/";
    // -------------------------------------------------------------------------
    private static final String BASE_URL = "https://projets.iut-orsay.fr/saes3-sziani1/API-REST_S301/index.php/";

    private final HttpClient client;

    public ApiClient() {
        // On initialise le client HTTP avec un temps d'attente max de 10 secondes
        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    /**
     * Méthode GET (Récupérer des données)
     */
    public String get(String endpoint) {
        try {
            String urlComplete = BASE_URL + endpoint;
            
            // DEBUG : Affiche l'URL dans la console pour vérifier
            System.out.println("DEBUG GET -> " + urlComplete);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlComplete))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.err.println("Erreur API GET (" + response.statusCode() + ") : " + response.body());
            }
        } catch (Exception e) {
            System.err.println("Impossible de contacter le serveur (GET) : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Méthode POST (Envoyer des données : Ajout)
     */
    public String post(String endpoint, String jsonInput) {
        try {
            String urlComplete = BASE_URL + endpoint;
            System.out.println("DEBUG POST -> " + urlComplete);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlComplete))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonInput))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // On accepte 200 (OK) et 201 (Created)
            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                return response.body();
            } else {
                System.err.println("Erreur API POST (" + response.statusCode() + ") : " + response.body());
            }
        } catch (Exception e) {
            System.err.println("Impossible de contacter le serveur (POST)");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Méthode DELETE (Supprimer des données)
     * C'est celle-ci qui manquait pour le bouton rouge !
     */
    public boolean delete(String endpoint) {
        try {
            String urlComplete = BASE_URL + endpoint;
            System.out.println("DEBUG DELETE -> " + urlComplete);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlComplete))
                    .DELETE()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Code 200 = OK, Code 204 = No Content (Succès sans message)
            if (response.statusCode() == 200 || response.statusCode() == 204) {
                return true;
            } else {
                System.err.println("Erreur API DELETE (" + response.statusCode() + ") : " + response.body());
            }
        } catch (Exception e) {
            System.err.println("Impossible de contacter le serveur (DELETE)");
            e.printStackTrace();
        }
        return false;
    }
}