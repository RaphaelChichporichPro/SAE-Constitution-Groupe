<?php
class Covoiturage {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    // Récupérer la liste des covoiturages avec les participants
    public function getAllWithParticipants() {
        // Jointure entre Participation et Covoiturage 
        $query = "SELECT c.id_covoiturage, c.point_depart, 
                         p.id_user, p.role_participation
                  FROM Covoiturage c
                  JOIN Participation_covoiturage p ON c.id_covoiturage = p.id_covoiturage
                  ORDER BY c.id_covoiturage";

        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        
        // On organise les données pour qu'elles soient faciles à lire en Java
        $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
        
        // Transformation en tableau structuré : [ID_COVOIT => [Passager1, Passager2...]]
        $covoiturages = [];
        foreach($result as $row) {
            $id = $row['id_covoiturage'];
            if (!isset($covoiturages[$id])) {
                $covoiturages[$id] = [
                    'ville' => $row['point_depart'],
                    'membres' => []
                ];
            }
            $covoiturages[$id]['membres'][] = [
                'id_user' => $row['id_user'],
                'role' => $row['role_participation']
            ];
        }
        
        // On retourne les valeurs (indexées numériquement pour le JSON)
        return array_values($covoiturages);
    }
}
?>