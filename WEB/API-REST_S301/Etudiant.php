<?php
class Etudiant {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    // 1. Récupérer TOUS les profils (Pour l'initialisation de l'algo)
    public function getAll() {
        // On récupère les infos utiles pour les contraintes (Genre, Bac, Redoublant)
        // Voir table Etudiant [cite: 83]
        $query = "SELECT id_user, num_etudiant, nom_etudiant, prenom_etudiant, 
                         mail_univ, genre, type_bac, redoublant 
                  FROM Etudiant";
        
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    // 2. Récupérer les notes d'un étudiant (Pour le calcul de niveau)
    public function getNotes($id_user) {
        // Voir table Notes [cite: 90]
        $query = "SELECT libelle, valeur, date_ 
                  FROM Notes 
                  WHERE id_user = ?";
        
        $stmt = $this->conn->prepare($query);
        $stmt->execute([$id_user]);
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
?>