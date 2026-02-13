<?php
// Vue ajout étudiant Responsable Pédagogique
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
    <!-- contenu identique au tableau mais modal ajout visible -->
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

<div class="add-student-modal is-visible">
  <div class="add-student-dialog">
    <div class="add-student-body">
      <h2>Ajout d'un Étudiant</h2>
      <form class="add-student-form" action="vue/Responsable_Pédagogique/TableauDeBord.php" method="get">
        <label class="add-field">
          <span>Nom</span>
          <input type="text" name="nom" placeholder="Saisissez le nom">
        </label>
        <label class="add-field">
          <span>Prénom</span>
          <input type="text" name="prenom" placeholder="Saisissez le prénom">
        </label>
        <label class="add-field">
          <span>Groupe</span>
          <input type="text" name="groupe" placeholder="Saisissez le groupe">
        </label>
        <label class="add-field">
          <span>N° Étudiant</span>
          <input type="text" name="numero" placeholder="Saisissez le N° Étudiant">
        </label>
        <div class="add-student-actions">
          <a href="vue/Responsable_Pédagogique/TableauDeBord.php" class="btn-secondary">Retour</a>
          <button type="submit" class="btn-primary">Ajouter</button>
        </div>
      </form>
    </div>
  </div>
</div>

</body>
</html>