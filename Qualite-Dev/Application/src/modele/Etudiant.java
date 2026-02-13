package modele;

import java.io.Serializable;
import modele.TypeGenre; 

public class Etudiant implements Serializable {
    
    public String id_user;
    public String nom_etudiant;
    public String prenom_etudiant;
    public String mail_univ;
    public String type_bac;
    public String groupe_actuel;

    // CORRECTION BDD : On reçoit un int (0 ou 1) pour l'apprentissage
    public int apprentissage; 
    
    // CHAMPS POUR LES ALGOS DE RAPHAËL
    // Note : Ton API PHP doit renvoyer "moyenne" et "genre" pour que ça se remplisse
    public double moyenne;   
    public String genre;     // On reçoit une String ("HOMME", "FEMME") du JSON

    
    public Etudiant() {}

    // --- GETTERS ---

    public String getNom() { return nom_etudiant; }
    public String getPrenom() { return prenom_etudiant; }
    
    public String getType_bac() { 
        return type_bac != null ? type_bac : "Non renseigné"; 
    }

    // Convertit le int (0/1) en boolean pour l'interface graphique
    public boolean isApprentissage() { 
        return apprentissage == 1; 
    }

    // --- MÉTHODES REQUISES PAR ALGOS RAPHAËL ---

    //Pour l'erreur "getMoyenne is undefined"
    public double getMoyenne() {
        return moyenne;
    }

    //Pour l'erreur "getGenre is undefined"
    // Cette méthode convertit le texte reçu (ex: "HOMME") en Enum Java
    public TypeGenre getGenre() {
        if (genre == null || genre.isEmpty()) {
            return TypeGenre.AUTRE; // Sécurité si vide
        }
        try {
            // On met en majuscules pour être sûr (ex: "Femme" -> "FEMME")
            return TypeGenre.valueOf(genre.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Si la base contient un truc inconnu, on renvoie AUTRE
            return TypeGenre.AUTRE;
        }
    }

    @Override
    public String toString() {
        return nom_etudiant + " " + prenom_etudiant;
    }
}