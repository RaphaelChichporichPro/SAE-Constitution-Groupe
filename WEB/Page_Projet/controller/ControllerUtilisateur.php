<?php
require_once 'modele/ModelUtilisateur.php';

class ControllerUtilisateur {
    public static function afficherConnexion() { require 'vue/PageConnexion.php'; }
    
    public static function traiterConnexion() {
        $user = ModelUtilisateur::checkAuth($_POST['login'], $_POST['mdp']);
        if ($user) {
            $_SESSION['user'] = $user;
            header('Location: index.php?action=tableauDeBord');
        } else {
            $erreur = "Identifiants invalides";
            require 'vue/PageConnexion.php';
        }
    }

  public static function afficherDashboard() {
    // 1. Vérifier la session
    if(!isset($_SESSION['user'])) {
        header('Location: index.php?action=connexion');
        exit();
    }

    // 2. Récupérer les données via le modèle
    require_once 'model/ModelEtudiant.php';
    $listeEtudiants = ModelEtudiant::getAll();
    $listeGroupes = ModelEtudiant::getGroupes();

    // 3. Charger la vue
    require 'vue/TableauDeBord.php';
}

    public static function traiterInscription() {
        ModelUtilisateur::create($_POST);
        header('Location: index.php?action=connexion&success=1');
    }
}