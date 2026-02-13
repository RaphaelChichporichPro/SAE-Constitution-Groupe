<?php
class Groupe {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    public function getAll() {
        // Récupère l'ID, le libelle et surtout la CAPACITÉ 
        $query = "SELECT id_groupe, libelle_groupe, type_groupe, capacite 
                  FROM Groupe";
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
?>