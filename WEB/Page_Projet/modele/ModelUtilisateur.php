<?php
require_once 'config/connexion.php';

class ModelUtilisateur {
    // Vérifier les identifiants
    public static function checkAuth($login, $mdp) {
        Connexion::connect();
        $sql = "SELECT * FROM utilisateurs WHERE login = :login";
        $st = Connexion::pdo()->prepare($sql);
        $st->execute(['login' => $login]);
        $user = $st->fetch(PDO::FETCH_ASSOC);

        if ($user && password_verify($mdp, $user['mdp'])) return $user;
        return false;
    }

    // Créer un compte
    public static function create($data) {
        Connexion::connect();
        $sql = "INSERT INTO utilisateurs (nom_prenom, date_naissance, fonction, login, mdp) 
                VALUES (:nom, :date_n, :fonction, :login, :mdp)";
        $st = Connexion::pdo()->prepare($sql);
        return $st->execute([
            'nom' => $data['nom_prenom'],
            'date_n' => $data['date_naissance'],
            'fonction' => $data['fonction'],
            'login' => $data['login'],
            'mdp' => password_hash($data['mdp'], PASSWORD_DEFAULT)
        ]);
    }
}
?>