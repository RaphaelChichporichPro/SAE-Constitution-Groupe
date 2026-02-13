<?php
class Etudiant {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    // 1. Récupérer TOUS les profils
    public function getAll() {
        // CORRECTION : On prend nom/prenom dans la table 'Etudiant' (e), pas 'Utilisateur' (u)
        $query = "SELECT 
                    e.id_user, 
                    e.type_bac, 
                    e.apprentissage, 
                    e.nom_etudiant,      
                    e.prenom_etudiant,   
                    u.mail_user AS mail_univ  -- Le mail reste dans Utilisateur d'après ta capture
                  FROM Etudiant e
                  JOIN Utilisateur u ON e.id_user = u.id_user";

        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    // 2. Récupérer les notes
    public function getNotes($id_user) {
        $query = "SELECT libelle, valeur, date_notes 
                  FROM Notes
                  WHERE id_user = ?"; // Vérifie si ta table s'appelle 'Notes' ou 'Note'
        
        $stmt = $this->conn->prepare($query);
        $stmt->execute([$id_user]);
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

   // 3. Création complète (Utilisateur + Etudiant)
    public function create($data) {
        try {
            $this->conn->beginTransaction();

            // --- A. INSERTION UTILISATEUR (Authentification uniquement) ---
            // D'après ta capture, Utilisateur n'a PAS de nom/prenom
            
            $id_user = "ETU" . substr(time(), -5) . rand(10,99);
            $password = "1234"; 

            $queryUser = "INSERT INTO Utilisateur 
                          (id_user, mail_user, password, id_role) 
                          VALUES 
                          (:id_user, :mail, :pass, 'ETU')";
            
            $stmtUser = $this->conn->prepare($queryUser);
            $stmtUser->bindParam(":id_user", $id_user);
            $stmtUser->bindParam(":mail", $data->mail_univ);
            $stmtUser->bindParam(":pass", $password);
            
            if (!$stmtUser->execute()) {
                throw new Exception("Erreur création Utilisateur (Mail déjà pris ?)");
            }

            // --- B. INSERTION ETUDIANT (Données Métier) ---
            // C'est ici qu'on met le nom et le prénom !
            
            $queryEtu = "INSERT INTO Etudiant 
                (id_user, num_etudiant, mail_univ, nom_etudiant, prenom_etudiant, 
                 type_bac, redoublant, genre, adresse_etudiant, telephone_etudiant, 
                 apprentissage, id_promotion) 
                VALUES 
                (:id_user, :num_etu, :mail, :nom, :prenom, 
                 :bac, :redoub, :genre, :adresse, :tel, 
                 :appr, :id_promo)";

            $stmtEtu = $this->conn->prepare($queryEtu);

            // Bind des paramètres
            $stmtEtu->bindParam(":id_user", $id_user);
            
            $num_etu = isset($data->num_etudiant) ? $data->num_etudiant : rand(100000, 999999);
            $stmtEtu->bindParam(":num_etu", $num_etu);
            
            $stmtEtu->bindParam(":mail", $data->mail_univ);
            $stmtEtu->bindParam(":nom", $data->nom_etudiant);       
            $stmtEtu->bindParam(":prenom", $data->prenom_etudiant); 
            $stmtEtu->bindParam(":bac", $data->type_bac);
            
            $redoublant = !empty($data->redoublant) ? 1 : 0;
            $stmtEtu->bindParam(":redoub", $redoublant);
            
            $genre = !empty($data->genre) ? $data->genre : 'Autre';
            $stmtEtu->bindParam(":genre", $genre);
            
            $adresse = !empty($data->adresse_etudiant) ? $data->adresse_etudiant : '';
            $stmtEtu->bindParam(":adresse", $adresse);
            
            $tel = !empty($data->telephone_etudiant) ? $data->telephone_etudiant : '';
            $stmtEtu->bindParam(":tel", $tel);
            
            $apprentissage = !empty($data->apprentissage) ? 1 : 0;
            $stmtEtu->bindParam(":appr", $apprentissage);
            
            // Attention : Assure-toi que l'ID 1 existe dans la table Promotion !
            $id_promo = !empty($data->id_promotion) ? $data->id_promotion : 1; 
            $stmtEtu->bindParam(":id_promo", $id_promo);

            if (!$stmtEtu->execute()) {
                throw new Exception("Erreur insertion Etudiant (Vérifie id_promotion)");
            }

            $this->conn->commit();
            return true;

        } catch (Exception $e) {
            $this->conn->rollBack();
            // Pour le debug uniquement, tu peux décommenter la ligne suivante :
            // file_put_contents("debug_log.txt", $e->getMessage()); 
            return false;
        }
    }


    public function delete($id) {
    try {
        $this->conn->beginTransaction();

        // 1. Supprimer de la table enfant (Etudiant)
        $query1 = "DELETE FROM Etudiant WHERE id_user = :id";
        $stmt1 = $this->conn->prepare($query1);
        $stmt1->bindParam(":id", $id);
        $stmt1->execute();

        // 2. Supprimer de la table parent (Utilisateur)
        $query2 = "DELETE FROM Utilisateur WHERE id_user = :id";
        $stmt2 = $this->conn->prepare($query2);
        $stmt2->bindParam(":id", $id);
        $stmt2->execute();

        $this->conn->commit();
        return true;
    } catch (Exception $e) {
        $this->conn->rollBack();
        return false;
    }
}
}
?>