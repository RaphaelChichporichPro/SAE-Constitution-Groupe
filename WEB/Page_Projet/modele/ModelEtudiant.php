<?php
require_once 'config/connexion.php';

class ModelEtudiant {
    public static function getAll() {
        Connexion::connect();
        $st = Connexion::pdo()->query("SELECT * FROM etudiants");
        return $st->fetchAll(PDO::FETCH_ASSOC);
    }

    public static function getGroupes() {
        Connexion::connect();
        $st = Connexion::pdo()->query("SELECT DISTINCT nom_groupe FROM groupes");
        return $st->fetchAll(PDO::FETCH_ASSOC);
    }
}