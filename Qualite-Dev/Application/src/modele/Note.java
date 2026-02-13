package modele;

import java.io.Serializable;

public class Note implements Serializable {

    // On retire "sonEtudiant" car cela créerait une boucle infinie avec Gson
    // (L'étudiant contient les notes, qui contiennent l'étudiant...)
    
    public int id_note;
    public String libelle;  // Ex: "Maths", "Java"
    public double valeur;   // Ex: 14.5 (Double et pas int !)
    public String date_note; // On reçoit une String du PHP (ex: "2024-01-15")

    public Note() {}

    public int getId_note() { return id_note; }
    public void setId_note(int id_note) { this.id_note = id_note; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public double getValeur() { return valeur; }
    public void setValeur(double valeur) { this.valeur = valeur; }

    public String getDate_note() { return date_note; }
    public void setDate_note(String date_note) { this.date_note = date_note; }
    
    @Override
    public String toString() {
        return libelle + " : " + valeur + "/20";
    }
}