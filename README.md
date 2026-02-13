## Documentation Technique - Base de Données (S3.01)
Projet : Gestion des Groupes

Auteurs : Safwan, Hanniel, Raphaël

Contexte : BUT Informatique - Semestre 3

## Présentation du Projet
Ce dépôt contient l'ensemble des scripts SQL nécessaires au déploiement de la base de données relationnelle. Le système gère :

L'administration : Étudiants, Enseignants, Promotions.

La pédagogie : Constitution des Groupes (TD/TP), Gestion des Notes, Sondages.


## Prérequis Techniques

Pour exécuter ces scripts, l'environnement doit respecter les critères suivants :

SGBD : MySQL 
Encodage : utf8mb4 (Recommandé).

Privilèges : L'utilisateur doit avoir les droits CREATE, DROP, INSERT, SELECT, CREATE VIEW, CREATE TRIGGER et CREATE ROUTINE.

## Guide d'Installation (Ordre d'Exécution)
## IMPORTANT : Les scripts doivent être exécutés strictement dans l'ordre ci-dessous pour respecter les dépendances (Clés étrangères -> Données -> Logique PL/SQL).

# Étape 1 : Architecture & Creations des Tables 
Fichier : SCRIPT_DE_CREATION_DES_TABLES_FINAL.sql

Description :

Réinitialise l'environnement (DROP TABLE IF EXISTS avec désactivation temporaire des clés étrangères).

Crée les tables principales (Utilisateur, Groupe, Etudiant, Covoiturage) et les tables d'association (Groupe_Etudiant, Choix_activite).

Définit l'intégrité référentielle (Primary & Foreign Keys).

# Étape 2 : Jeu de Données 
Fichier : SCRIPT_DINSERTION_FINAL.sql

Description :

Initialise les rôles (ENS, ETU).

Génère un jeu de test volumineux : 20 Enseignants, 100 Étudiants, 20 Groupes.

Simule des scénarios réels : Notes, Sondages remplis, et Participations aux covoiturages.

# Étape 3 : Sécurité des Données (Triggers)
Fichier : SCRIPT_TRIGGERS_FINAL.sql

Description : Active les contrôles automatiques :


trg_capacite_groupe : Bloque l'inscription si la capacité du groupe est atteinte.


trg_note_valide : Empêche l'insertion de notes hors de l'intervalle [0, 20].


trg_conducteur_unique : Garantit qu'un covoiturage n'a qu'un seul conducteur.

# Étape 4 : Logique Métier (Procédures Stockées)
Fichier : SCRIPT_FONCTION_PROCEDURE_FINAL.sql

Description : Déploie les algorithmes côté serveur :


Fonctions : moyenne_etudiant pour les calculs de niveau.

Procédures CRUD : ajouter_etudiant_groupe, lister_etudiants_groupe.

Algorithmes :

affectation_auto : Remplissage de masse des groupes.


proc_bilan_alertes : Audit automatique (étudiants en échec, groupes saturés).


proc_affectation_secours : Utilisation de CURSEURS pour traiter les étudiants isolés.

# Étape 5 : Exploitation (Vues & Requêtes)
Fichier : SCRIPT_VUES_ET_REQUETTES_FINAL.sql

Description :

Création de vues métier : vue_statistiques_covoiturage, vue_moyenne_etudiant, vue_effectif_groupes.

Exécution des 11 requêtes types demandées (Q1 à Q11) pour les tableaux de bord.

## Comment Exécuter ?
Option A : Via phpMyAdmin (Interface Graphique)
Créez une base de données vide (ex : sae_s3).

Allez dans l'onglet Importer.

Chargez les fichiers un par un dans l'ordre indiqué ci-dessus.

Note : phpMyAdmin gère automatiquement le délimiteur présent dans les scripts 3 et 4.

OU 

Allez dans l'onglet SQL

Executez les scripts en respectant l'ordre (Création des tables, Insertion, ...)

## Dépannage (FAQ)
Erreur "Foreign key constraint fails" :

Vérifiez que vous avez bien exécuté le script de Création (1) avant le script d'Insertion (2).



