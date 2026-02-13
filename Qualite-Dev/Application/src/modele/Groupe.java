package modele;

import java.util.ArrayList;
import java.util.List;

public class Groupe {
    public String libelle_groupe;
    public int capacite = 30; // Valeur par défaut
    
    // Liste interne pour stocker les étudiants
    private List<Etudiant> membres = new ArrayList<>();

    public Groupe(String libelle) {
        this.libelle_groupe = libelle;
    }

    // --- MÉTHODES REQUISES PAR LES ALGOS (Correction de "undefined") ---

    // Corrige l'erreur "The method ajouterEtudiant is undefined"
    public void ajouterEtudiant(Etudiant e) {
        if (membres.size() < capacite) {
            membres.add(e);
            e.groupe_actuel = this.libelle_groupe; // Met à jour l'étudiant
        }
    }

    public void retirerEtudiant(Etudiant e) {
        membres.remove(e);
        if (e.groupe_actuel != null && e.groupe_actuel.equals(this.libelle_groupe)) {
            e.groupe_actuel = null;
        }
    }

    // Getters utiles pour les algos
    public List<Etudiant> getMembres() {
        return membres;
    }

    public int getTaille() {
        return membres.size();
    }
    
    public int getCapacite() {
        return capacite;
    }
    
    public void setCapacite(int cap) {
        this.capacite = cap;
    }
}