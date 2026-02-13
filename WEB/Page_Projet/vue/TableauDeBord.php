<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Tableau de Bord Étudiant</title> 
    <link rel="stylesheet" href="css/style_TableauBord.css">
</head>
<body>
    <div class="sidebar">
      <div class="profile">
        <img class="avatar" src="images/PhotoProfil.jpg" alt="Profil">
        <div class="profile-text">
          <p class="student-name"><?= htmlspecialchars($_SESSION['user']['nom_prenom']) ?></p>
          <p class="student-year"><?= htmlspecialchars(ucfirst($_SESSION['user']['fonction'])) ?></p>
        </div>
      </div>
      <a href="index.php?action=tableauDeBord" class="item active">Tableau de bord</a>
      <a href="index.php?action=sondages" class="item">Sondages</a>
      <a href="index.php?action=information" class="item">Mes Informations</a>
      <a href="index.php?action=deconnexion" class="item disconnect">Se déconnecter</a>
    </div>

    <div class="content">
      <h2>Liste des Étudiants</h2>
      <table class="student-table">
        <thead>
          <tr>
            <th>N° ÉTUDIANT</th><th>NOM</th><th>PRÉNOM</th><th>EMAIL</th>
          </tr>
        </thead>
        <tbody>
          <?php foreach ($etudiants as $e): ?>
          <tr>
            <td><?= htmlspecialchars($e['num_etudiant']) ?></td>
            <td><strong><?= htmlspecialchars($e['nom']) ?></strong></td>
            <td><?= htmlspecialchars($e['prenom']) ?></td>
            <td><?= htmlspecialchars($e['email']) ?></td>
          </tr>
          <?php endforeach; ?>
        </tbody>
      </table>

      <div class="tables-row">
        <div class="table-section">
          <h3>Groupes de TD/TP</h3>
          <ul class="group-list">
            <?php foreach ($groupes as $g): ?>
              <li><strong><?= htmlspecialchars($g['nom_groupe']) ?></strong></li>
            <?php endforeach; ?>
          </ul>
        </div>
      </div>
    </div>
</body>
</html>