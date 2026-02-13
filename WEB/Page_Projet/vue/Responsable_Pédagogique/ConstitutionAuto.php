<?php
// Vue constitution automatique des groupes (Responsable Pédagogique)
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
<div class="container">
    <section class="section">
      <h2>Gestion des Étudiants</h2>
      <table class="student-table">
        <thead>
          <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Identifiant</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Dupont</td>
            <td>Jean</td>
            <td>E12345</td>
            <td class="actions">
              <a href="vue/Responsable_Pédagogique/ModifEtudiant.php" class="action-link">Modifier</a>
              <a href="vue/Responsable_Pédagogique/SuppressionEtudiant.php" class="action-link danger">Supprimer</a>
            </td>
          </tr>
          <tr>
            <td>Martin</td>
            <td>Marie</td>
            <td>E12346</td>
            <td class="actions">
              <a href="vue/Responsable_Pédagogique/ModifEtudiant.php" class="action-link">Modifier</a>
              <a href="vue/Responsable_Pédagogique/SuppressionEtudiant.php" class="action-link danger">Supprimer</a>
            </td>
          </tr>
          <tr>
            <td>Durand</td>
            <td>Pierre</td>
            <td>E12347</td>
            <td class="actions">
              <a href="vue/Responsable_Pédagogique/ModifEtudiant.php" class="action-link">Modifier</a>
              <a href="vue/Responsable_Pédagogique/SuppressionEtudiant.php" class="action-link danger">Supprimer</a>
            </td>
          </tr>
        </tbody>
      </table>
      <a href="vue/Responsable_Pédagogique/AjoutEtudiant.php" class="btn-add">+ Ajouter un étudiant</a>
    </section>

    <section class="section-right">
      <h2>Import/Export de Données</h2>
      <div class="export-section">
        <div class="export-item">
          <span class="icon">⬇</span>
          <p>Exporter les données étudiants (CSV)</p>
        </div>
        <a href="vue/Responsable_Pédagogique/ImportNotes.php" class="export-item">
          <span class="icon">⬇</span>
          <p>Importer les notes (CSV)</p>
        </a>
        <a href="vue/Responsable_Pédagogique/ConsultationNotes.php" class="export-item">
          <span class="icon">⇅</span>
          <p>Consulter/Modifier les notes</p>
        </a>
      </div>
    </section>

    <section class="section-half">
      <h2>Constitution des Groupes</h2>
      <div class="button-group">
        <a href="vue/Responsable_Pédagogique/PublicationGroupes.php" class="btn btn-primary">👁 Rendre les Groupes Publics</a>
        <a href="vue/Responsable_Pédagogique/AttributionGroupe.php" class="btn btn-secondary">✏️ Constitution Manuelle</a>
        <a href="vue/Responsable_Pédagogique/ConstitutionAuto.php" class="btn btn-secondary">✏️ Constitution Automatique</a>
        <button class="btn btn-export">⬇ Exporter la Promotion (CSV)</button>
      </div>
    </section>

    <section class="section-half">
      <h2>Consultation des Groupes</h2>
      <div class="groups-grid">
        <a href="vue/Responsable_Pédagogique/ConstitutionGroupe.php" class="group-card">
          <h3>Groupe 1</h3>
          <p>5 membres</p>
        </a>
        <a href="vue/Responsable_Pédagogique/ConstitutionGroupe.php" class="group-card">
          <h3>Groupe 2</h3>
          <p>4 membres</p>
        </a>
        <a href="vue/Responsable_Pédagogique/ConstitutionGroupe.php" class="group-card">
          <h3>Groupe 3</h3>
          <p>5 membres</p>
        </a>
      </div>
    </section>

    <section class="section-surveys">
      <h2>Sondages</h2>
      <div class="survey-buttons">
        <a href="vue/Responsable_Pédagogique/CreationSondage.php" class="btn btn-blue">👥 Mettre en place le sondage</a>
      </div>
      <div class="survey-results">
        <a href="vue/Responsable_Pédagogique/ResultatSondages.php" class="btn-results">⬇ Accéder aux résultats des sondages</a>
      </div>
    </section>
</div>

<!-- Modal Constitution automatique -->
<div class="auto-modal is-visible">
  <div class="auto-dialog">
    <div class="auto-body">
      <div class="auto-header">
        <span class="auto-icon" aria-hidden="true">🗳️</span>
        <h2>Constitution automatique</h2>
      </div>
      <p class="auto-subtitle">Choisir les critères pour la constitution automatique :</p>

      <div class="auto-grid">
        <a class="auto-chip" href="vue/Responsable_Pédagogique/ConstitutionGroupe.php">Covoiturage</a>
        <a class="auto-chip" href="vue/Responsable_Pédagogique/ConstitutionGroupe.php">Langue</a>
        <a class="auto-chip" href="vue/Responsable_Pédagogique/ConstitutionGroupe.php">Spécialité</a>
        <a class="auto-chip" href="vue/Responsable_Pédagogique/ConstitutionGroupe.php">Genre</a>
        <a class="auto-chip auto-chip-wide" href="vue/Responsable_Pédagogique/ConstitutionGroupe.php">Handicap</a>
      </div>

      <div class="auto-actions">
        <a class="auto-btn-close" href="vue/Responsable_Pédagogique/TableauDeBord.php">Fermer</a>
      </div>
    </div>
  </div>
</div>

</body>
</html>