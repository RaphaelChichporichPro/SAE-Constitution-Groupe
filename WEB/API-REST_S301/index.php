<?php
// index.php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *"); // Important pour Java/JS

require_once 'Database.php';
require_once 'Etudiant.php';
require_once 'Covoiturage.php';
require_once 'Groupe.php';

// Connexion
$database = new Database();
$db = $database->getConnection();

// Analyse de l'URL
$method = $_SERVER['REQUEST_METHOD'];
$request_uri = $_SERVER['REQUEST_URI'];
// Nettoyage de l'URL pour garder ce qui vient après index.php
$path = parse_url($request_uri, PHP_URL_PATH);
$path_parts = explode('/', trim($path, '/'));

// Astuce : Trouver où commence "api" ou "index.php" pour prendre la suite
// Adapte l'index selon ton dossier (ici je suppose localhost/api/index.php/ressource)
$resource_index = array_search('index.php', $path_parts);

if ($resource_index !== false && isset($path_parts[$resource_index + 1])) {
    $resource = $path_parts[$resource_index + 1]; // "etudiants", "covoiturages"...
    $id = $path_parts[$resource_index + 2] ?? null;
    $sub_resource = $path_parts[$resource_index + 3] ?? null; // "notes"
} else {
    // Si tu appelles à la racine du dossier API sans index.php visible
    $resource = end($path_parts); 
    $id = null;
    $sub_resource = null;
}

// --- ROUTAGE ---

switch ($method) {
    case 'GET':
        if ($resource == 'etudiants') {
            $etu = new Etudiant($db);
            if ($id && $sub_resource == 'notes') {
                // Cas : /etudiants/ETU1/notes
                echo json_encode($etu->getNotes($id));
            } else {
                // Cas : /etudiants
                echo json_encode($etu->getAll());
            }
        } 
        elseif ($resource == 'covoiturages') {
            // Cas : /covoiturages
            $cov = new Covoiturage($db);
            echo json_encode($cov->getAllWithParticipants());
        }
        elseif ($resource == 'groupes') {
            // Cas : /groupes
            $grp = new Groupe($db);
            echo json_encode($grp->getAll());
        }
        else {
            echo json_encode(["message" => "Ressource inconnue"]);
        }
        break;

    default:
        http_response_code(405);
        echo json_encode(["message" => "Méthode non autorisée"]);
        break;
}
?>