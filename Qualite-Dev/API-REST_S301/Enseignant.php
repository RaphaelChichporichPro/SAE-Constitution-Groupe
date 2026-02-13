<?php
class Enseignant {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    // Authentification : Vérifie email + mot de passe
    public function login($email, $password) {
        // 1. Vérifier dans la table Utilisateur (pour le mdp)
        // On joint avec la table Enseignant pour récupérer le nom/prénom
        $query = "SELECT u.id_user, e.nom_enseignant, e.prenom_enseignant, u.id_role 
                  FROM Utilisateur u
                  JOIN Enseignant e ON u.id_user = e.id_user
                  WHERE u.mail_user = :email AND u.password = :mdp AND u.id_role = 'ENS'";
        $stmt = $this->conn->prepare($query);
        $stmt->bindParam(":email", $email);
        $stmt->bindParam(":mdp", $password);
        
        $stmt->execute();

        if ($stmt->rowCount() > 0) {
            return $stmt->fetch(PDO::FETCH_ASSOC); // Retourne les infos prof
        } else {
            return false; // Échec
        }
    }

    public function getAll() {
        $query = "SELECT * FROM Enseignant";
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}
?>