<?php
class Note {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    // Récupérer toutes les notes (pour calculs globaux)
    public function getAll() {
        $query = "SELECT * FROM Notes";
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    // Récupérer les notes d'un étudiant précis
    public function getByStudent($id_user) {
        $query = "SELECT * FROM Notes WHERE id_user = ?";
        $stmt = $this->conn->prepare($query);
        $stmt->execute([$id_user]);
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
?>