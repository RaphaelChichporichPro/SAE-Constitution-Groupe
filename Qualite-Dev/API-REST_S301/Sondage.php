<?php
class Sondage {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    // Récupérer la liste des sondages
    public function getAll() {
        $query = "SELECT * FROM Sondage";
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function getStats() {
        $stats = [];

        // Statistique 1 : Pourcentage de Covoiturage (Basé sur la table Participation_covoiturage ou Reponse_sondage)
        // Ici on regarde ceux qui ont répondu 'Oui' à un sondage sur le covoiturage
        $queryCov = "SELECT 
                        (SELECT COUNT(*) FROM Reponse_sondage WHERE id_sondage = 3 AND valeur_reponse = 'Oui') as oui,
                        (SELECT COUNT(*) FROM Reponse_sondage WHERE id_sondage = 3) as total";
        
        $stmt = $this->conn->prepare($queryCov);
        $stmt->execute();
        $resCov = $stmt->fetch(PDO::FETCH_ASSOC);
        
        // Calcul du pourcentage 
        $stats['covoiturage'] = ($resCov['total'] > 0) ? round(($resCov['oui'] / $resCov['total']) * 100) : 0;

        // Statistique 2 : Préférence Matin (Sondage 8 - Disponibilités)
        // Exemple basé sur tes données (Matin vs Après-midi)
        $queryMatin = "SELECT COUNT(*) as nb FROM Reponse_sondage WHERE id_sondage = 8 AND valeur_reponse = 'Matin'";
        $stmt = $this->conn->prepare($queryMatin);
        $stmt->execute();
        $resMatin = $stmt->fetch(PDO::FETCH_ASSOC);
        
        $stats['preference_matin'] = $resMatin['nb']; // Nombre brut ou % selon ton besoin

        return $stats;
    }
}
?>