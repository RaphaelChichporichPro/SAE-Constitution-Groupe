-- =========================
-- 1) ROLE (10 lignes)
-- =========================
INSERT INTO Role VALUES ('R01','Administrateur');
INSERT INTO Role VALUES ('R02','Enseignant');
INSERT INTO Role VALUES ('R03','Etudiant');
INSERT INTO Role VALUES ('R04','Responsable promotion');
INSERT INTO Role VALUES ('R05','Secrétaire');
INSERT INTO Role VALUES ('R06','Tuteur');
INSERT INTO Role VALUES ('R07','Chef département');
INSERT INTO Role VALUES ('R08','Assistant');
INSERT INTO Role VALUES ('R09','Invité');
INSERT INTO Role VALUES ('R10','Support technique');
COMMIT;

-- =========================
-- 2) UTILISATEUR (40 lignes : U001..U040)
-- =========================
INSERT INTO Utilisateur VALUES ('U001','admin@univ.fr','admin01','R01');
INSERT INTO Utilisateur VALUES ('U002','enseignant1@univ.fr','ens01','R02');
INSERT INTO Utilisateur VALUES ('U003','enseignant2@univ.fr','ens02','R02');
INSERT INTO Utilisateur VALUES ('U004','enseignant3@univ.fr','ens03','R02');
INSERT INTO Utilisateur VALUES ('U005','enseignant4@univ.fr','ens04','R02');
INSERT INTO Utilisateur VALUES ('U006','enseignant5@univ.fr','ens05','R02');

INSERT INTO Utilisateur VALUES ('U007','etu01@etu.univ.fr','etu01','R03');
INSERT INTO Utilisateur VALUES ('U008','etu02@etu.univ.fr','etu02','R03');
INSERT INTO Utilisateur VALUES ('U009','etu03@etu.univ.fr','etu03','R03');
INSERT INTO Utilisateur VALUES ('U010','etu04@etu.univ.fr','etu04','R03');
INSERT INTO Utilisateur VALUES ('U011','etu05@etu.univ.fr','etu05','R03');
INSERT INTO Utilisateur VALUES ('U012','etu06@etu.univ.fr','etu06','R03');
INSERT INTO Utilisateur VALUES ('U013','etu07@etu.univ.fr','etu07','R03');
INSERT INTO Utilisateur VALUES ('U014','etu08@etu.univ.fr','etu08','R03');
INSERT INTO Utilisateur VALUES ('U015','etu09@etu.univ.fr','etu09','R03');
INSERT INTO Utilisateur VALUES ('U016','etu10@etu.univ.fr','etu10','R03');
INSERT INTO Utilisateur VALUES ('U017','etu11@etu.univ.fr','etu11','R03');
INSERT INTO Utilisateur VALUES ('U018','etu12@etu.univ.fr','etu12','R03');
INSERT INTO Utilisateur VALUES ('U019','etu13@etu.univ.fr','etu13','R03');
INSERT INTO Utilisateur VALUES ('U020','etu14@etu.univ.fr','etu14','R03');
INSERT INTO Utilisateur VALUES ('U021','etu15@etu.univ.fr','etu15','R03');
INSERT INTO Utilisateur VALUES ('U022','etu16@etu.univ.fr','etu16','R03');
INSERT INTO Utilisateur VALUES ('U023','etu17@etu.univ.fr','etu17','R03');
INSERT INTO Utilisateur VALUES ('U024','etu18@etu.univ.fr','etu18','R03');
INSERT INTO Utilisateur VALUES ('U025','etu19@etu.univ.fr','etu19','R03');
INSERT INTO Utilisateur VALUES ('U026','etu20@etu.univ.fr','etu20','R03');
INSERT INTO Utilisateur VALUES ('U027','etu21@etu.univ.fr','etu21','R03');
INSERT INTO Utilisateur VALUES ('U028','etu22@etu.univ.fr','etu22','R03');
INSERT INTO Utilisateur VALUES ('U029','etu23@etu.univ.fr','etu23','R03');
INSERT INTO Utilisateur VALUES ('U030','etu24@etu.univ.fr','etu24','R03');
INSERT INTO Utilisateur VALUES ('U031','etu25@etu.univ.fr','etu25','R03');
INSERT INTO Utilisateur VALUES ('U032','etu26@etu.univ.fr','etu26','R03');
INSERT INTO Utilisateur VALUES ('U033','etu27@etu.univ.fr','etu27','R03');
INSERT INTO Utilisateur VALUES ('U034','etu28@etu.univ.fr','etu28','R03');
INSERT INTO Utilisateur VALUES ('U035','etu29@etu.univ.fr','etu29','R03');
INSERT INTO Utilisateur VALUES ('U036','etu30@etu.univ.fr','etu30','R03');
INSERT INTO Utilisateur VALUES ('U037','resp1@univ.fr','resp01','R04');
INSERT INTO Utilisateur VALUES ('U038','sec1@univ.fr','sec01','R05');
INSERT INTO Utilisateur VALUES ('U039','tuteur1@univ.fr','tut01','R06');
INSERT INTO Utilisateur VALUES ('U040','assist1@univ.fr','ass01','R08');
COMMIT;

-- =========================
-- 3) ENSEIGNANT (6 lignes : U002..U006)
-- =========================
INSERT INTO Enseignant VALUES ('U002',1100,'Martin','Paul','paul.martin@univ.fr',TO_DATE('1978-05-12','YYYY-MM-DD'),'Titulaire','Informatique','12 rue A', '0601000001');
INSERT INTO Enseignant VALUES ('U003',1101,'Dupont','Claire','claire.dupont@univ.fr',TO_DATE('1982-07-01','YYYY-MM-DD'),'Titulaire','Mathématiques','5 avenue B', '0601000002');
INSERT INTO Enseignant VALUES ('U004',1102,'Morel','Sophie','sophie.morel@univ.fr',TO_DATE('1979-11-20','YYYY-MM-DD'),'Contractuel','Physique','3 place C', '0601000003');
INSERT INTO Enseignant VALUES ('U005',1103,'Roux','Alain','alain.roux@univ.fr',TO_DATE('1985-02-14','YYYY-MM-DD'),'Titulaire','Chimie','8 rue D', '0601000004');
INSERT INTO Enseignant VALUES ('U006',1104,'Petit','Julie','julie.petit@univ.fr',TO_DATE('1980-10-30','YYYY-MM-DD'),'Vacataire','Anglais','1 bd E', '0601000005');
INSERT INTO Enseignant VALUES ('U037',1200,'Leclerc','Anne','anne.leclerc@univ.fr',TO_DATE('1970-03-03','YYYY-MM-DD'),'Titulaire','Administration','10 rue Admin', '0601000006');
COMMIT;

-- =========================
-- 4) PROMOTION (4 lignes)
-- =========================
INSERT INTO Promotion VALUES (1, TO_DATE('2023-09-01','YYYY-MM-DD'), 'Informatique', 'Parcours A', 'U002');
INSERT INTO Promotion VALUES (2, TO_DATE('2023-09-01','YYYY-MM-DD'), 'Informatique', 'Parcours B', 'U003');
INSERT INTO Promotion VALUES (3, TO_DATE('2023-09-01','YYYY-MM-DD'), 'Mathématiques', 'Parcours C', 'U004');
INSERT INTO Promotion VALUES (4, TO_DATE('2024-09-01','YYYY-MM-DD'), 'Chimie', 'Parcours D', 'U005');
COMMIT;

-- =========================
-- 5) GROUPE (8 lignes)
-- =========================
INSERT INTO Groupe VALUES (1,'G1','TD',1,'U002');
INSERT INTO Groupe VALUES (2,'G2','TP',1,'U002');
INSERT INTO Groupe VALUES (3,'G3','TD',2,'U003');
INSERT INTO Groupe VALUES (4,'G4','TP',2,'U003');
INSERT INTO Groupe VALUES (5,'G5','TD',3,'U004');
INSERT INTO Groupe VALUES (6,'G6','TP',3,'U004');
INSERT INTO Groupe VALUES (7,'G7','TD',4,'U005');
INSERT INTO Groupe VALUES (8,'G8','TP',4,'U005');
COMMIT;

-- =========================
-- 6) ETUDIANT (24 lignes : U007..U030)
-- =========================
INSERT INTO Etudiant VALUES ('U007',3007,'etu01@univ.fr','Durand','Alice',TO_DATE('2004-04-15','YYYY-MM-DD'),'S',0,'Femme','10 rue V', '0602000007',0,1,1);
INSERT INTO Etudiant VALUES ('U008',3008,'etu02@univ.fr','Bernard','Lucas',TO_DATE('2003-09-10','YYYY-MM-DD'),'STI2D',0,'Homme','5 rue E', '0602000008',0,2,1);
INSERT INTO Etudiant VALUES ('U009',3009,'etu03@univ.fr','Petit','Emma',TO_DATE('2004-01-20','YYYY-MM-DD'),'S',0,'Femme','7 avenue F', '0602000009',0,1,1);
INSERT INTO Etudiant VALUES ('U010',3010,'etu04@univ.fr','Moreau','Leo',TO_DATE('2002-12-05','YYYY-MM-DD'),'ES',0,'Homme','2 place G', '0602000010',0,2,1);
INSERT INTO Etudiant VALUES ('U011',3011,'etu05@univ.fr','Garcia','Mia',TO_DATE('2004-06-25','YYYY-MM-DD'),'S',1,'Femme','11 rue H', '0602000011',0,3,2);
INSERT INTO Etudiant VALUES ('U012',3012,'etu06@univ.fr','Lopez','Noah',TO_DATE('2003-03-13','YYYY-MM-DD'),'STI2D',0,'Homme','4 rue I', '0602000012',0,3,2);
INSERT INTO Etudiant VALUES ('U013',3013,'etu07@univ.fr','Leroy','Camille',TO_DATE('2004-08-09','YYYY-MM-DD'),'ES',0,'Femme','6 avenue J', '0602000013',0,4,3);
INSERT INTO Etudiant VALUES ('U014',3014,'etu08@univ.fr','Fournier','Hugo',TO_DATE('2004-11-30','YYYY-MM-DD'),'S',0,'Homme','9 bd K', '0602000014',0,4,3);
INSERT INTO Etudiant VALUES ('U015',3015,'etu09@univ.fr','Rivière','Inès',TO_DATE('2003-05-02','YYYY-MM-DD'),'S',0,'Femme','3 rue L', '0602000015',0,5,3);
INSERT INTO Etudiant VALUES ('U016',3016,'etu10@univ.fr','Gautier','Malo',TO_DATE('2004-02-18','YYYY-MM-DD'),'STI2D',0,'Homme','13 rue M', '0602000016',0,5,3);
INSERT INTO Etudiant VALUES ('U017',3017,'etu11@univ.fr','Perrin','Léna',TO_DATE('2003-07-22','YYYY-MM-DD'),'ES',1,'Femme','14 rue N', '0602000017',0,6,4);
INSERT INTO Etudiant VALUES ('U018',3018,'etu12@univ.fr','Marchand','Ethan',TO_DATE('2004-10-10','YYYY-MM-DD'),'S',0,'Homme','15 avenue O', '0602000018',0,6,4);
INSERT INTO Etudiant VALUES ('U019',3019,'etu13@univ.fr','Blanc','Chloé',TO_DATE('2004-12-01','YYYY-MM-DD'),'S',0,'Femme','16 rue P', '0602000019',0,7,4);
INSERT INTO Etudiant VALUES ('U020',3020,'etu14@univ.fr','Chevalier','Tom',TO_DATE('2003-01-17','YYYY-MM-DD'),'S',0,'Homme','17 rue Q', '0602000020',0,8,4);
INSERT INTO Etudiant VALUES ('U021',3021,'etu15@univ.fr','Germain','Emma',TO_DATE('2004-05-05','YYYY-MM-DD'),'ES',0,'Femme','18 rue R', '0602000021',0,1,1);
INSERT INTO Etudiant VALUES ('U022',3022,'etu16@univ.fr','Fabre','Noé',TO_DATE('2003-06-06','YYYY-MM-DD'),'S',0,'Homme','19 rue S', '0602000022',0,2,1);
INSERT INTO Etudiant VALUES ('U023',3023,'etu17@univ.fr','Colin','Sasha',TO_DATE('2004-09-09','YYYY-MM-DD'),'STI2D',0,'Femme','20 rue T', '0602000023',0,3,2);
INSERT INTO Etudiant VALUES ('U024',3024,'etu18@univ.fr','Morin','Luca',TO_DATE('2002-10-10','YYYY-MM-DD'),'S',1,'Homme','21 avenue U', '0602000024',0,4,3);
INSERT INTO Etudiant VALUES ('U025',3025,'etu19@univ.fr','Henry','Lina',TO_DATE('2003-11-11','YYYY-MM-DD'),'ES',0,'Femme','22 rue V', '0602000025',0,5,3);
INSERT INTO Etudiant VALUES ('U026',3026,'etu20@univ.fr','Roger','Adam',TO_DATE('2004-03-03','YYYY-MM-DD'),'S',0,'Homme','23 rue W', '0602000026',0,6,4);
INSERT INTO Etudiant VALUES ('U027',3027,'etu21@univ.fr','Baron','Zoé',TO_DATE('2004-04-04','YYYY-MM-DD'),'S',0,'Femme','24 rue X', '0602000027',0,7,4);
INSERT INTO Etudiant VALUES ('U028',3028,'etu22@univ.fr','Nolet','Eli',TO_DATE('2003-08-08','YYYY-MM-DD'),'STI2D',0,'Homme','25 rue Y', '0602000028',0,8,4);
INSERT INTO Etudiant VALUES ('U029',3029,'etu23@univ.fr','Vidal','Maya',TO_DATE('2004-09-09','YYYY-MM-DD'),'S',0,'Femme','26 rue Z', '0602000029',0,1,1);
INSERT INTO Etudiant VALUES ('U030',3030,'etu24@univ.fr','Colle','Swan',TO_DATE('2003-02-02','YYYY-MM-DD'),'ES',0,'Homme','27 rue AA', '0602000030',0,2,1);
COMMIT;

-- =========================
-- 7) ACTIVITE (20 lignes A001..A020)
-- =========================
INSERT INTO Activite VALUES ('A001','Football universitaire','Septembre - Juin','Sport',0,1);
INSERT INTO Activite VALUES ('A002','Théâtre étudiant','Octobre - Mai','Arts',0,0);
INSERT INTO Activite VALUES ('A003','Atelier robotique','Novembre - Mars','Informatique',0,0);
INSERT INTO Activite VALUES ('A004','Cours d''anglais renforcé','Septembre - Juin','Langues',1,0);
INSERT INTO Activite VALUES ('A005','Club de débat','Octobre - Avril','Communication',1,1);
INSERT INTO Activite VALUES ('A006','Chorale universitaire','Septembre - Juin','Musique',0,0);
INSERT INTO Activite VALUES ('A007','Tournoi d''échecs','Mars - Avril','Mathématiques',0,1);
INSERT INTO Activite VALUES ('A008','Projet environnemental','Février - Juin','Écologie',0,1);
INSERT INTO Activite VALUES ('A009','Cours de cinéma','Septembre - Décembre','Audiovisuel',1,0);
INSERT INTO Activite VALUES ('A010','Atelier photographie','Janvier - Mai','Arts',0,0);
INSERT INTO Activite VALUES ('A011','Club informatique','Septembre - Juin','Informatique',0,0);
INSERT INTO Activite VALUES ('A012','Atelier IA','Janvier - Mai','Informatique',1,0);
INSERT INTO Activite VALUES ('A013','Basketball','Septembre - Juin','Sport',0,1);
INSERT INTO Activite VALUES ('A014','Club lecture','Octobre - Mai','Culture',0,0);
INSERT INTO Activite VALUES ('A015','Atelier électronique','Novembre - Avril','Informatique',0,0);
INSERT INTO Activite VALUES ('A016','Yoga étudiant','Septembre - Juin','Sport',0,1);
INSERT INTO Activite VALUES ('A017','Club photo avancé','Janvier - Juin','Arts',0,0);
INSERT INTO Activite VALUES ('A018','Atelier vidéo','Février - Mai','Audiovisuel',0,0);
INSERT INTO Activite VALUES ('A019','Club jardinage','Mars - Juin','Écologie',0,1);
INSERT INTO Activite VALUES ('A020','Atelier startup','Septembre - Décembre','Entreprenariat',1,0);
COMMIT;

-- =========================
-- 8) COVOITURAGE (10 lignes C001..C010)
-- =========================
INSERT INTO Covoiturage VALUES ('C001','Lucas','Orsay');
INSERT INTO Covoiturage VALUES ('C002','Alice','Palaiseau');
INSERT INTO Covoiturage VALUES ('C003','Emma','Massy');
INSERT INTO Covoiturage VALUES ('C004','Noah','Gif-sur-Yvette');
INSERT INTO Covoiturage VALUES ('C005','Lina','Saint-Quentin');
INSERT INTO Covoiturage VALUES ('C006','Tom','Paris');
INSERT INTO Covoiturage VALUES ('C007','Malo','Versailles');
INSERT INTO Covoiturage VALUES ('C008','Ines','Evry');
INSERT INTO Covoiturage VALUES ('C009','Hugo','Saclay');
INSERT INTO Covoiturage VALUES ('C010','Chloe','Monts');
COMMIT;

-- =========================
-- 9) CRITERE (10 lignes CR01..CR10)
-- =========================
INSERT INTO Critere VALUES ('CR01','Assiduité',1,'Comportement','Présence','90%',3);
INSERT INTO Critere VALUES ('CR02','Résultats',1,'Performance','Moyenne','12',5);
INSERT INTO Critere VALUES ('CR03','Ponctualité',1,'Comportement','Ponctualité','95%',2);
INSERT INTO Critere VALUES ('CR04','Esprit d''équipe',1,'Attitude','Collaboration','Bonne',2);
INSERT INTO Critere VALUES ('CR05','Autonomie',1,'Travail','Projets','Élevée',3);
INSERT INTO Critere VALUES ('CR06','Participation',1,'Comportement','Interventions','Frequent',2);
INSERT INTO Critere VALUES ('CR07','Projet final',1,'Performance','Livrable','Validé',4);
INSERT INTO Critere VALUES ('CR08','Stage',1,'Expérience','Stage obligatoire','Oui',4);
INSERT INTO Critere VALUES ('CR09','Portfolio',1,'Travail','Qualité','Bonne',2);
INSERT INTO Critere VALUES ('CR10','Langues',1,'Compétence','Anglais','B2',1);
COMMIT;

-- =========================
-- 10) CRITERE_PROMOTION (8 lignes)
-- =========================
INSERT INTO Critere_promotion VALUES (1,'CR01');
INSERT INTO Critere_promotion VALUES (1,'CR02');
INSERT INTO Critere_promotion VALUES (2,'CR03');
INSERT INTO Critere_promotion VALUES (2,'CR04');
INSERT INTO Critere_promotion VALUES (3,'CR05');
INSERT INTO Critere_promotion VALUES (3,'CR06');
INSERT INTO Critere_promotion VALUES (4,'CR07');
INSERT INTO Critere_promotion VALUES (4,'CR08');
COMMIT;

-- =========================
-- 11) CRITERE_GROUPE (8 lignes)
-- =========================
INSERT INTO Critere_groupe VALUES (1,'CR01');
INSERT INTO Critere_groupe VALUES (2,'CR02');
INSERT INTO Critere_groupe VALUES (3,'CR03');
INSERT INTO Critere_groupe VALUES (4,'CR04');
INSERT INTO Critere_groupe VALUES (5,'CR05');
INSERT INTO Critere_groupe VALUES (6,'CR06');
INSERT INTO Critere_groupe VALUES (7,'CR07');
INSERT INTO Critere_groupe VALUES (8,'CR08');
COMMIT;

-- =========================
-- 12) SONDAGE (6 lignes)
-- =========================
INSERT INTO Sondage VALUES (1, TO_DATE('2024-02-01','YYYY-MM-DD'),'Choix d''activité',1,'U002');
INSERT INTO Sondage VALUES (2, TO_DATE('2024-03-10','YYYY-MM-DD'),'Evaluation des cours',2,'U003');
INSERT INTO Sondage VALUES (3, TO_DATE('2024-04-05','YYYY-MM-DD'),'Projet tutoré',3,'U004');
INSERT INTO Sondage VALUES (4, TO_DATE('2024-05-12','YYYY-MM-DD'),'Satisfaction services',4,'U005');
INSERT INTO Sondage VALUES (5, TO_DATE('2024-06-01','YYYY-MM-DD'),'Choix sortie',1,'U002');
INSERT INTO Sondage VALUES (6, TO_DATE('2024-06-15','YYYY-MM-DD'),'Organisation exam',2,'U003');
COMMIT;

-- =========================
-- 13) REPONSE_SONDAGE (24 lignes : chaque étudiant répond à 1 ou 2 sondages)
-- =========================
INSERT INTO Reponse_sondage VALUES ('U007',1,TO_DATE('2024-02-10','YYYY-MM-DD'),'Football',1);
INSERT INTO Reponse_sondage VALUES ('U008',1,TO_DATE('2024-02-10','YYYY-MM-DD'),'Théâtre',2);
INSERT INTO Reponse_sondage VALUES ('U009',1,TO_DATE('2024-02-11','YYYY-MM-DD'),'Robotique',1);
INSERT INTO Reponse_sondage VALUES ('U010',2,TO_DATE('2024-03-12','YYYY-MM-DD'),'Satisfait',1);
INSERT INTO Reponse_sondage VALUES ('U011',2,TO_DATE('2024-03-12','YYYY-MM-DD'),'Très satisfait',1);
INSERT INTO Reponse_sondage VALUES ('U012',3,TO_DATE('2024-04-06','YYYY-MM-DD'),'Ok',1);
INSERT INTO Reponse_sondage VALUES ('U013',3,TO_DATE('2024-04-07','YYYY-MM-DD'),'Bonne idée',1);
INSERT INTO Reponse_sondage VALUES ('U014',4,TO_DATE('2024-05-13','YYYY-MM-DD'),'Non',1);
INSERT INTO Reponse_sondage VALUES ('U015',4,TO_DATE('2024-05-13','YYYY-MM-DD'),'Oui',2);
INSERT INTO Reponse_sondage VALUES ('U016',5,TO_DATE('2024-06-02','YYYY-MM-DD'),'Sortie A',1);
INSERT INTO Reponse_sondage VALUES ('U017',5,TO_DATE('2024-06-02','YYYY-MM-DD'),'Sortie B',2);
INSERT INTO Reponse_sondage VALUES ('U018',6,TO_DATE('2024-06-16','YYYY-MM-DD'),'Ok',1);
INSERT INTO Reponse_sondage VALUES ('U019',6,TO_DATE('2024-06-16','YYYY-MM-DD'),'Non',2);
INSERT INTO Reponse_sondage VALUES ('U020',1,TO_DATE('2024-02-10','YYYY-MM-DD'),'Football',1);
INSERT INTO Reponse_sondage VALUES ('U021',2,TO_DATE('2024-03-12','YYYY-MM-DD'),'Satisfait',1);
INSERT INTO Reponse_sondage VALUES ('U022',3,TO_DATE('2024-04-06','YYYY-MM-DD'),'Ok',1);
INSERT INTO Reponse_sondage VALUES ('U023',4,TO_DATE('2024-05-13','YYYY-MM-DD'),'Oui',1);
INSERT INTO Reponse_sondage VALUES ('U024',5,TO_DATE('2024-06-02','YYYY-MM-DD'),'Sortie A',1);
INSERT INTO Reponse_sondage VALUES ('U025',6,TO_DATE('2024-06-16','YYYY-MM-DD'),'Ok',1);
INSERT INTO Reponse_sondage VALUES ('U026',1,TO_DATE('2024-02-11','YYYY-MM-DD'),'Robotique',2);
INSERT INTO Reponse_sondage VALUES ('U027',2,TO_DATE('2024-03-13','YYYY-MM-DD'),'Neutre',1);
INSERT INTO Reponse_sondage VALUES ('U028',3,TO_DATE('2024-04-08','YYYY-MM-DD'),'Oui',1);
INSERT INTO Reponse_sondage VALUES ('U029',4,TO_DATE('2024-05-14','YYYY-MM-DD'),'Non',1);
INSERT INTO Reponse_sondage VALUES ('U030',5,TO_DATE('2024-06-03','YYYY-MM-DD'),'Sortie C',1);
INSERT INTO Reponse_sondage VALUES ('U031',6,TO_DATE('2024-06-16','YYYY-MM-DD'),'Ok',1);
INSERT INTO Reponse_sondage VALUES ('U032',1,TO_DATE('2024-02-12','YYYY-MM-DD'),'Théâtre',2);
COMMIT;

-- =========================
-- 14) NOTES (72 lignes : 3 notes par étudiant U007..U030)
-- =========================
INSERT INTO Notes VALUES (1,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),14,'U007');
INSERT INTO Notes VALUES (2,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),16,'U007');
INSERT INTO Notes VALUES (3,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),12,'U007');

INSERT INTO Notes VALUES (4,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),13,'U008');
INSERT INTO Notes VALUES (5,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),15,'U008');
INSERT INTO Notes VALUES (6,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),11,'U008');

INSERT INTO Notes VALUES (7,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),12,'U009');
INSERT INTO Notes VALUES (8,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),14,'U009');
INSERT INTO Notes VALUES (9,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),13,'U009');

INSERT INTO Notes VALUES (10,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),15,'U010');
INSERT INTO Notes VALUES (11,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),17,'U010');
INSERT INTO Notes VALUES (12,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),14,'U010');

INSERT INTO Notes VALUES (13,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),11,'U011');
INSERT INTO Notes VALUES (14,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),13,'U011');
INSERT INTO Notes VALUES (15,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),10,'U011');

INSERT INTO Notes VALUES (16,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),16,'U012');
INSERT INTO Notes VALUES (17,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),18,'U012');
INSERT INTO Notes VALUES (18,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),15,'U012');

INSERT INTO Notes VALUES (19,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),12,'U013');
INSERT INTO Notes VALUES (20,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),14,'U013');
INSERT INTO Notes VALUES (21,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),13,'U013');

INSERT INTO Notes VALUES (22,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),13,'U014');
INSERT INTO Notes VALUES (23,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),15,'U014');
INSERT INTO Notes VALUES (24,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),12,'U014');

INSERT INTO Notes VALUES (25,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),14,'U015');
INSERT INTO Notes VALUES (26,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),16,'U015');
INSERT INTO Notes VALUES (27,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),14,'U015');

INSERT INTO Notes VALUES (28,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),10,'U016');
INSERT INTO Notes VALUES (29,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),12,'U016');
INSERT INTO Notes VALUES (30,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),11,'U016');

INSERT INTO Notes VALUES (31,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),13,'U017');
INSERT INTO Notes VALUES (32,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),15,'U017');
INSERT INTO Notes VALUES (33,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),12,'U017');

INSERT INTO Notes VALUES (34,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),15,'U018');
INSERT INTO Notes VALUES (35,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),17,'U018');
INSERT INTO Notes VALUES (36,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),14,'U018');

INSERT INTO Notes VALUES (37,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),11,'U019');
INSERT INTO Notes VALUES (38,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),13,'U019');
INSERT INTO Notes VALUES (39,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),12,'U019');

INSERT INTO Notes VALUES (40,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),14,'U020');
INSERT INTO Notes VALUES (41,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),16,'U020');
INSERT INTO Notes VALUES (42,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),13,'U020');

INSERT INTO Notes VALUES (43,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),12,'U021');
INSERT INTO Notes VALUES (44,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),14,'U021');
INSERT INTO Notes VALUES (45,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),11,'U021');

INSERT INTO Notes VALUES (46,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),13,'U022');
INSERT INTO Notes VALUES (47,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),15,'U022');
INSERT INTO Notes VALUES (48,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),12,'U022');

INSERT INTO Notes VALUES (49,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),14,'U023');
INSERT INTO Notes VALUES (50,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),16,'U023');
INSERT INTO Notes VALUES (51,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),13,'U023');

INSERT INTO Notes VALUES (52,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),12,'U024');
INSERT INTO Notes VALUES (53,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),14,'U024');
INSERT INTO Notes VALUES (54,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),11,'U024');

INSERT INTO Notes VALUES (55,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),13,'U025');
INSERT INTO Notes VALUES (56,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),15,'U025');
INSERT INTO Notes VALUES (57,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),12,'U025');

INSERT INTO Notes VALUES (58,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),14,'U026');
INSERT INTO Notes VALUES (59,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),16,'U026');
INSERT INTO Notes VALUES (60,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),15,'U026');

INSERT INTO Notes VALUES (61,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),13,'U027');
INSERT INTO Notes VALUES (62,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),14,'U027');
INSERT INTO Notes VALUES (63,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),12,'U027');

INSERT INTO Notes VALUES (64,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),15,'U028');
INSERT INTO Notes VALUES (65,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),17,'U028');
INSERT INTO Notes VALUES (66,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),14,'U028');

INSERT INTO Notes VALUES (67,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),12,'U029');
INSERT INTO Notes VALUES (68,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),13,'U029');
INSERT INTO Notes VALUES (69,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),11,'U029');

INSERT INTO Notes VALUES (70,'Mathématiques','Devoir1',TO_DATE('2024-02-01','YYYY-MM-DD'),14,'U030');
INSERT INTO Notes VALUES (71,'Informatique','Projet1',TO_DATE('2024-02-10','YYYY-MM-DD'),16,'U030');
INSERT INTO Notes VALUES (72,'Physique','TP1',TO_DATE('2024-02-20','YYYY-MM-DD'),13,'U030');
COMMIT;

-- =========================
-- 15) CHOIX_ACTIVITE (24+ lignes : chaque étudiant choisit 1 ou 2 activités)
-- =========================
INSERT INTO Choix_activite VALUES ('U007','A001');
INSERT INTO Choix_activite VALUES ('U007','A005');
INSERT INTO Choix_activite VALUES ('U008','A002');
INSERT INTO Choix_activite VALUES ('U009','A003');
INSERT INTO Choix_activite VALUES ('U010','A001');
INSERT INTO Choix_activite VALUES ('U011','A004');
INSERT INTO Choix_activite VALUES ('U012','A005');
INSERT INTO Choix_activite VALUES ('U013','A006');
INSERT INTO Choix_activite VALUES ('U014','A007');
INSERT INTO Choix_activite VALUES ('U015','A008');
INSERT INTO Choix_activite VALUES ('U016','A009');
INSERT INTO Choix_activite VALUES ('U017','A010');
INSERT INTO Choix_activite VALUES ('U018','A011');
INSERT INTO Choix_activite VALUES ('U019','A012');
INSERT INTO Choix_activite VALUES ('U020','A002');
INSERT INTO Choix_activite VALUES ('U021','A003');
INSERT INTO Choix_activite VALUES ('U022','A004');
INSERT INTO Choix_activite VALUES ('U023','A005');
INSERT INTO Choix_activite VALUES ('U024','A006');
INSERT INTO Choix_activite VALUES ('U025','A007');
INSERT INTO Choix_activite VALUES ('U026','A008');
INSERT INTO Choix_activite VALUES ('U027','A009');
INSERT INTO Choix_activite VALUES ('U028','A010');
INSERT INTO Choix_activite VALUES ('U029','A001');
INSERT INTO Choix_activite VALUES ('U030','A002');
COMMIT;

-- =========================
-- 16) PARTICIPATION_COVOITURAGE (20 lignes)
-- =========================
INSERT INTO Participation_covoiturage VALUES ('U007','C002','Passager');
INSERT INTO Participation_covoiturage VALUES ('U008','C001','Passager');
INSERT INTO Participation_covoiturage VALUES ('U009','C003','Conducteur');
INSERT INTO Participation_covoiturage VALUES ('U010','C004','Passager');
INSERT INTO Participation_covoiturage VALUES ('U011','C005','Passager');
INSERT INTO Participation_covoiturage VALUES ('U012','C006','Conducteur');
INSERT INTO Participation_covoiturage VALUES ('U013','C007','Passager');
INSERT INTO Participation_covoiturage VALUES ('U014','C008','Passager');
INSERT INTO Participation_covoiturage VALUES ('U015','C009','Conducteur');
INSERT INTO Participation_covoiturage VALUES ('U016','C010','Passager');
INSERT INTO Participation_covoiturage VALUES ('U017','C001','Passager');
INSERT INTO Participation_covoiturage VALUES ('U018','C002','Passager');
INSERT INTO Participation_covoiturage VALUES ('U019','C003','Passager');
INSERT INTO Participation_covoiturage VALUES ('U020','C004','Conducteur');
INSERT INTO Participation_covoiturage VALUES ('U021','C005','Passager');
INSERT INTO Participation_covoiturage VALUES ('U022','C006','Passager');
INSERT INTO Participation_covoiturage VALUES ('U023','C007','Conducteur');
INSERT INTO Participation_covoiturage VALUES ('U024','C008','Passager');
INSERT INTO Participation_covoiturage VALUES ('U025','C009','Passager');
INSERT INTO Participation_covoiturage VALUES ('U026','C010','Passager');
COMMIT;

