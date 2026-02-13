<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS");
header("Access-Control-Allow-Headers: Content-Type");

if ($_SERVER['REQUEST_METHOD'] == 'OPTIONS') {
    http_response_code(200);
    exit;
}

require_once 'Database.php';
require_once 'Etudiant.php';
require_once 'Covoiturage.php';
require_once 'Groupe.php';
require_once 'Note.php';
require_once 'Sondage.php';
require_once 'Enseignant.php';

// Connexion
$database = new Database();
$db = $database->getConnection();

// Analyse de l'URL
$method = $_SERVER['REQUEST_METHOD'];
$request_uri = $_SERVER['REQUEST_URI'];
$path = parse_url($request_uri, PHP_URL_PATH);
$path_parts = explode('/', trim($path, '/'));

$resource_index = array_search('index.php', $path_parts);
if ($resource_index === false) {
    // Si index.php n'est pas dans l'URL, on cherche 'api'
    $resource_index = array_search('api', $path_parts);
}

if ($resource_index !== false && isset($path_parts[$resource_index + 1])) {
    $resource = $path_parts[$resource_index + 1]; // ex: "etudiants"
    $id = $path_parts[$resource_index + 2] ?? null; // ex: "ETU1"
    $sub_resource = $path_parts[$resource_index + 3] ?? null; // ex: "notes"
} else {
    $resource = end($path_parts);
    $id = null;
}

// --- ROUTAGE PAR RESSOURCE (Plus fiable) ---

switch ($resource) {
    
    case 'etudiants':
        $etu = new Etudiant($db);
        
        if ($method == 'GET') {
            // Lecture (Code existant)
            if ($id && $sub_resource == 'notes') {
                echo json_encode($etu->getNotes($id));
            } else {
                echo json_encode($etu->getAll());
            }
        } 
       elseif ($method == 'POST') {
            $data = json_decode(file_get_contents("php://input"));
            
            // Vérification des champs obligatoires minimum
            if(!empty($data->nom_etudiant) && !empty($data->prenom_etudiant) && !empty($data->mail_univ)) {
                
                // Appel de la fonction create
                if($etu->create($data)) {
                    http_response_code(201);
                    echo json_encode(["message" => "Etudiant créé avec succès."]);
                } else {
                    http_response_code(503);
                    echo json_encode(["message" => "Erreur serveur lors de la création."]);
                }
            } else {
                http_response_code(400);
                echo json_encode(["message" => "Données incomplètes. Nom, Prenom et Mail requis."]);
            }
        }
        elseif ($method == 'DELETE') {
             if (isset($_GET['id'])) {
             if ($etu->delete($_GET['id'])) {
            http_response_code(200);
            echo json_encode(["message" => "Etudiant supprime."]);
        } else {
            http_response_code(503);
            echo json_encode(["message" => "Impossible de supprimer."]);
        }
        } else {
        http_response_code(400);
        echo json_encode(["message" => "ID manquant."]);
        }
        }
        break;

    case 'covoiturages':
        if ($method == 'GET') {
            $cov = new Covoiturage($db);
            echo json_encode($cov->getAllWithParticipants());
        }
        break;
    
    case 'enseignants':
        if ($method == 'GET') {
            $ensObj = new Enseignant($db);
            echo json_encode($ensObj->getAll());
        }
        break;

    case 'groupes':
        if ($method == 'GET') {
            $grp = new Groupe($db);
            echo json_encode($grp->getAll());
        }
        break;

    case 'notes':
        if ($method == 'GET') {
            $noteObj = new Note($db);
            if ($id) {
                echo json_encode($noteObj->getByStudent($id));
            } else {
                echo json_encode($noteObj->getAll());
            }
        }
        break;

    case 'sondages':
        if ($method == 'GET') {
            $sondageObj = new Sondage($db);
            if ($id === 'stats') {
                echo json_encode($sondageObj->getStats());
            } else {
                echo json_encode($sondageObj->getAll());
            }
        }
        break;

    case 'login':
        if ($method == 'POST') {
            $ensObj = new Enseignant($db);
            // Récupère le JSON envoyé par le Java/JS
            $input = json_decode(file_get_contents("php://input"), true);
            
            if(isset($input['email']) && isset($input['password'])) {
                $user = $ensObj->login($input['email'], $input['password']);
                if ($user) {
                    echo json_encode(["success" => true, "user" => $user]);
                } else {
                    http_response_code(401); // Non autorisé
                    echo json_encode(["success" => false, "message" => "Identifiants incorrects"]);
                }
            } else {
                http_response_code(400); // Mauvaise requête
                echo json_encode(["message" => "Données manquantes"]);
            }
        }
        break;

    default:
        http_response_code(404);
        echo json_encode(["message" => "Ressource '$resource' inconnue ou URL incorrecte"]);
        break;
}
?>