<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Mes Informations</title>
    <link rel="stylesheet" href="css/style_E.css">
</head>
<body>
    <div class="content">
      <h2>Mes Données Personnelles</h2>
      <table class="info-table">
        <tr>
            <td class="label">Nom complet</td>
            <td class="value"><?= htmlspecialchars($_SESSION['user']['nom_prenom']) ?></td>
        </tr>
        <tr>
            <td class="label">Date de naissance</td>
            <td class="value"><?= htmlspecialchars($_SESSION['user']['date_naissance']) ?></td>
        </tr>
        <tr>
            <td class="label">Identifiant (Login)</td>
            <td class="value"><?= htmlspecialchars($_SESSION['user']['login']) ?></td>
        </tr>
      </table>
      
      <div class="actions">
          <a href="index.php?action=signalerErreur" class="btn-error">Signaler une erreur</a>
      </div>
    </div>
</body>
</html>