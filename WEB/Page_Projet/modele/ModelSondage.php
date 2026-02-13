<?php
require_once 'config/connexion.php';

class ModelSondage {
    public static function getAll() {
        Connexion::connect();
        $st = Connexion::pdo()->query("SELECT * FROM sondages ORDER BY date_creation DESC");
        return $st->fetchAll(PDO::FETCH_ASSOC);
    }
}