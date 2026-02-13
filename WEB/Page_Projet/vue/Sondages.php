<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Sondages</title>
    <link rel="stylesheet" href="css/style_SondagesE.css">
</head>
<body>
    <div class="content">
      <h1>Sondages en cours</h1>
      <table class="surveys-table">
        <thead>
          <tr>
            <th>Titre</th><th>Date</th><th>Action</th>
          </tr>
        </thead>
        <tbody>
          <?php foreach ($sondages as $s): ?>
          <tr>
            <td><?= htmlspecialchars($s['titre']) ?></td>
            <td><?= htmlspecialchars($s['date_creation']) ?></td>
            <td><a href="index.php?action=voter&id=<?= $s['id'] ?>" class="btn-vote">Participer</a></td>
          </tr>
          <?php endforeach; ?>
        </tbody>
      </table>
    </div>
</body>
</html>