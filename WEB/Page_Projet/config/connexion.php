<?php
class Connexion {
    static private $hostname = 'localhost';
    static private $database = 'saes3-sziani1';
    static private $login = 'saes3-sziani1';
    static private $password = '3wqe8FTMvZJrJZrP';
    static private $tabUTF8 = array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8");
    static private $pdo;

    static public function pdo() { return self::$pdo; }

    static public function connect() {
        if (empty(self::$pdo)) {
            try {
                self::$pdo = new PDO("mysql:host=".self::$hostname.";dbname=".self::$database, self::$login, self::$password, self::$tabUTF8);
                self::$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            } catch(PDOException $e) {
                die("Erreur de connexion : ".$e->getMessage());
            } 
        }
    }
}