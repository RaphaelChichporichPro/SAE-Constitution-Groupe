<?php
// Vue consultation des notes (Responsable Pédagogique)
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Tableau de Bord Responsable Pédagogique</title>
    <link rel="stylesheet" href="css/style_TableauBordRP.css">
</head>
<body>
    <header class="header">
      <div class="header-left">
        <img src="images/logo-iutorsay.png" alt="Logo IUT Orsay" class="logo">
      </div>
      <div class="header-center">
        <h1>Tableau de bord - Responsable Pédagogique</h1>
      </div>
    </header>

<div class="notes-container">
  <div class="notes-header">
    <h2>Consulter les notes</h2>
    <a href="vue/Responsable_Pédagogique/ModifNotes.php" class="btn-modify-notes">✏️ Modifier les notes</a>
  </div>

  <div class="notes-table-wrapper">
    <table class="notes-table">
      <thead>
        <tr>
          <th>Nom</th>
          <th>Prénom</th>
          <th>Identifiant</th>
          <th class="separator-right">Notes</th>
          <th>Nom</th>
          <th>Prénom</th>
          <th>Identifiant</th>
          <th>Notes</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td><a href="#" class="name-link">Dupont</a></td>
          <td>Jean</td>
          <td>E12345</td>
          <td class="separator-right"><a href="#" class="notes-link">18/20</a></td>
          <td><a href="#" class="name-link">Laurent</a></td>
          <td>Ethan</td>
          <td>E12354</td>
          <td><a href="#" class="notes-link">6/20</a></td>
        </tr>
        <tr>
          <td><a href="#" class="name-link">Martin</a></td>
          <td>Marie</td>
          <td>E12346</td>
          <td class="separator-right"><a href="#" class="notes-link">15/20</a></td>
          <td><a href="#" class="name-link">Garnier</a></td>
          <td>Inès</td>
          <td>E12355</td>
          <td><a href="#" class="notes-link">9/20</a></td>
        </tr>
        <tr>
          <td><a href="#" class="name-link">Durand</a></td>
          <td>Pierre</td>
          <td>E12347</td>
          <td class="separator-right"><a href="#" class="notes-link">13/20</a></td>
          <td><a href="#" class="name-link">Petit</a></td>
          <td>Gabriel</td>
          <td>E12356</td>
          <td><a href="#" class="notes-link">15/20</a></td>
        </tr>
        <tr>
          <td><a href="#" class="name-link">Martin</a></td>
          <td>Lucas</td>
          <td>E12348</td>
          <td class="separator-right"><a href="#" class="notes-link">13/20</a></td>
          <td><a href="#" class="name-link">Roux</a></td>
          <td>Manon</td>
          <td>E12357</td>
          <td><a href="#" class="notes-link">13/20</a></td>
        </tr>
        <tr>
          <td><a href="#" class="name-link">Lefevre</a></td>
          <td>Emma</td>
          <td>E12349</td>
          <td class="separator-right"><a href="#" class="notes-link">14/20</a></td>
          <td><a href="#" class="name-link">Faure</a></td>
          <td>Louis</td>
          <td>E12358</td>
          <td><a href="#" class="notes-link">19/20</a></td>
        </tr>
        <tr>
          <td><a href="#" class="name-link">Dubois</a></td>
          <td>Nathan</td>
          <td>E12350</td>
          <td class="separator-right"><a href="#" class="notes-link">8/20</a></td>
          <td><a href="#" class="name-link">Robert</a></td>
          <td>Camille</td>
          <td>E12359</td>
          <td><a href="#" class="notes-link">11/20</a></td>
        </tr>
        <tr>
          <td><a href="#" class="name-link">Bernard</a></td>
          <td>Chloé</td>
          <td>E12351</td>
          <td class="separator-right"><a href="#" class="notes-link">14/20</a></td>
          <td><a href="#" class="name-link">Girard</a></td>
          <td>Arthur</td>
          <td>E12360</td>
          <td><a href="#" class="notes-link">12/20</a></td>
        </tr>
        <tr>
          <td><a href="#" class="name-link">Moreau</a></td>
          <td>Hugo</td>
          <td>E12352</td>
          <td class="separator-right"><a href="#" class="notes-link">10/20</a></td>
          <td><a href="#" class="name-link">Durand</a></td>
          <td>Clara</td>
          <td>E12361</td>
          <td><a href="#" class="notes-link">3/20</a></td>
        </tr>
        <tr>
          <td><a href="#" class="name-link">Fontaine</a></td>
          <td>Léa</td>
          <td>E12353</td>
          <td class="separator-right"><a href="#" class="notes-link">17/20</a></td>
          <td><a href="#" class="name-link">Blanchard</a></td>
          <td>Tom</td>
          <td>E12362</td>
          <td><a href="#" class="notes-link">7/20</a></td>
        </tr>
      </tbody>
    </table>
  </div>
</div>

</body>
</html>