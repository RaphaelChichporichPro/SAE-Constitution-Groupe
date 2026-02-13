<?php
session_start();
require_once 'config/connexion.php';
require_once 'controller/ControllerUtilisateur.php';
require_once 'controller/ControllerEtudiant.php';

Connexion::connect();

$action = $_GET['action'] ?? 'connexion';

// Sécurité : Vérification de session
$actions_publiques = ['connexion', 'validerConnexion', 'creerCompte', 'enregistrer'];
if (!isset($_SESSION['user']) && !in_array($action, $actions_publiques)) {
    header('Location: index.php?action=connexion');
    exit();
}

switch($action) {
    case 'tableauDeBord':
        ControllerEtudiant::afficherDashboard();
        break;
    case 'information':
        ControllerEtudiant::afficherProfil();
        break;
    case 'sondages':
        ControllerEtudiant::afficherSondages();
        break;
    case 'signalerErreur':
        ControllerEtudiant::afficherFormErreur();
        break;
    case 'deconnexion':
        ControllerUtilisateur::deconnexion();
        break;
    default:
        ControllerUtilisateur::afficherConnexion();
        break;
}
?>