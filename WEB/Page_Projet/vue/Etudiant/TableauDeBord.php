<?php
// On vérifie la sécurité
if (!isset($_SESSION['user'])) {
    header('Location: index.php');
    exit();
}
$user = $_SESSION['user'];
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Tableau de Bord</title> 
    <link rel="stylesheet" href="css/style_TableauBord.css">
</head>
<body>
    <div class="sidebar">
      <div class="profile">
        <img class="avatar" src="images/PhotoProfil.jpg" alt="Photo Profil">
        <div class="profile-text">
          <p class="student-name"><?= htmlspecialchars($user['nom_prenom']) ?></p>
          <p class="student-year"><?= htmlspecialchars(ucfirst($user['fonction'])) ?></p>
        </div>
      </div>
      <a href="index.php?action=tableauDeBord" class="item active">Tableau de bord</a>
      <a href="index.php?action=sondages" class="item">Sondages</a>
      <a href="index.php?action=information" class="item">Information</a>
      <a href="index.php?action=deconnexion" class="item disconnect">Se déconnecter</a>
    </div>

    <div class="content">
      <h2>Informations Pédagogiques</h2>
      <table class="student-table">
        <thead>
          <tr>
            <th>N° ÉTUDIANT</th><th>NOM</th><th>PRÉNOM</th><th>EMAIL</th>
          </tr>
        </thead>
        <tbody>
          <?php foreach ($listeEtudiants as $e): ?>
          <tr>
            <td><?= htmlspecialchars($e['num_etudiant']) ?></td>
            <td><strong><?= htmlspecialchars($e['nom']) ?></strong></td>
            <td><?= htmlspecialchars($e['prenom']) ?></td>
            <td><?= htmlspecialchars($e['email']) ?></td>
          </tr>
          <?php endforeach; ?>
        </tbody>
      </table>
    </div>
</body>
</html>
?>