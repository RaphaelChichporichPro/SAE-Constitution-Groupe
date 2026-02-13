<?php
require_once 'modele/ModelEtudiant.php';
// require_once 'model/ModelSondage.php'; // À décommenter quand tu auras le modèle

class ControllerEtudiant {
    
    public static function afficherDashboard() {
        $etudiants = ModelEtudiant::getAll(); 
        $groupes = ModelEtudiant::getGroupes();
        require 'vue/TableauDeBord.php';
    }

    public static function afficherProfil() {
        // Les infos sont déjà dans $_SESSION['user']
        require 'vue/Information.php';
    }

    public static function afficherSondages() {
        // Logique pour récupérer les sondages si nécessaire
        require 'view/Sondages.php';
    }

    public static function afficherFormErreur() {
        require 'view/SignalerErreur.php';
    }
}
?>