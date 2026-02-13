<?php
// Vue attribution de groupe (Responsable Pédagogique)
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
<div class="assign-wrapper">
  <div class="assign-background">
    <div class="assign-bg-content">
      <div class="grouping-container">
        <div class="grouping-topbar">
          <a href="vue/Responsable_Pédagogique/TableauDeBord.php" class="grouping-back-btn">← Retour au tableau de bord</a>
        </div>
        <div class="grouping-header">
          <h2>Constituer les groupes</h2>
          <a href="vue/Responsable_Pédagogique/AttributionGroupe.php" class="grouping-assign-btn"><span aria-hidden="true">✏️</span> Attribuer un groupe à un étudiant</a>
        </div>

        <div class="grouping-table-wrapper">
          <table class="grouping-table">
            <thead>
              <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Identifiant</th>
                <th class="divider-col">Groupe</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Identifiant</th>
                <th>Groupe</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Dupont</td>
                <td>Jean</td>
                <td>E12345</td>
                <td class="divider-col">1</td>
                <td>Laurent</td>
                <td>Ethan</td>
                <td>E12354</td>
                <td>1</td>
              </tr>
              <tr>
                <td>Martin</td>
                <td>Marie</td>
                <td>E12346</td>
                <td class="divider-col">2</td>
                <td>Garnier</td>
                <td>Inès</td>
                <td>E12355</td>
                <td>2</td>
              </tr>
              <tr>
                <td>Durand</td>
                <td>Pierre</td>
                <td>E12347</td>
                <td class="divider-col">2</td>
                <td>Petit</td>
                <td>Gabriel</td>
                <td>E12356</td>
                <td>1</td>
              </tr>
              <tr>
                <td>Martin</td>
                <td>Lucas</td>
                <td>E12348</td>
                <td class="divider-col">1</td>
                <td>Roux</td>
                <td>Manon</td>
                <td>E12357</td>
                <td>3</td>
              </tr>
              <tr>
                <td>Lefèvre</td>
                <td>Emma</td>
                <td>E12349</td>
                <td class="divider-col">1</td>
                <td>Faure</td>
                <td>Louis</td>
                <td>E12358</td>
                <td>3</td>
              </tr>
              <tr>
                <td>Dubois</td>
                <td>Nathan</td>
                <td>E12350</td>
                <td class="divider-col">2</td>
                <td>Robert</td>
                <td>Camille</td>
                <td>E12359</td>
                <td>1</td>
              </tr>
              <tr>
                <td>Bernard</td>
                <td>Chloé</td>
                <td>E12351</td>
                <td class="divider-col">1</td>
                <td>Girard</td>
                <td>Arthur</td>
                <td>E12360</td>
                <td>3</td>
              </tr>
              <tr>
                <td>Moreau</td>
                <td>Hugo</td>
                <td>E12352</td>
                <td class="divider-col">3</td>
                <td>Durand</td>
                <td>Clara</td>
                <td>E12361</td>
                <td>2</td>
              </tr>
              <tr>
                <td>Fontaine</td>
                <td>Léa</td>
                <td>E12353</td>
                <td class="divider-col">3</td>
                <td>Blanchard</td>
                <td>Tom</td>
                <td>E12362</td>
                <td>1</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <div class="assign-bg-overlay"></div>
  </div>

  <div class="assign-form-card">
    <h2>Attribuer un groupe<br>à un étudiant</h2>
    <form class="assign-form" action="vue/Responsable_Pédagogique/TableauDeBord.php" method="get">
      <label class="assign-field">
        <span>Nom</span>
        <input type="text" name="nom" value="Dupont" readonly>
      </label>
      <label class="assign-field">
        <span>Prénom</span>
        <input type="text" name="prenom" value="Jean" readonly>
      </label>
      <label class="assign-field">
        <span>Identifiant</span>
        <input type="text" name="identifiant" value="E12345" readonly>
      </label>
      <label class="assign-field">
        <span>Groupe à attribuer</span>
        <input type="text" name="groupe" value="2" readonly>
      </label>
      <div class="assign-actions">
        <a class="assign-btn-secondary" href="vue/Responsable_Pédagogique/ConstitutionGroupe.php">Fermer</a>
        <button type="submit" class="assign-btn-primary">Ajouter</button>
      </div>
    </form>
  </div>
</div>

</body>
</html>