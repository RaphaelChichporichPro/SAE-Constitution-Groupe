<?php
// Vue création de sondage (Responsable Pédagogique)
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
        <h1>Création Sondage - Responsable Pédagogique</h1>
      </div>
    </header>
<main class="survey-container">
  <div class="survey-header">
    <h1>Création d'un sondage pour les groupes</h1>
    <p>Remplissez les sections ci-dessous pour créer un sondage pour les étudiants.</p>
  </div>

  <section class="survey-card">
    <div class="survey-card-title">
      <span class="survey-card-icon" aria-hidden="true">🏫</span>
      <span>Préférences d'apprentissage</span>
    </div>

    <div class="survey-field">
      <label>Anglais renforcé ?</label>
      <div class="chip-row">
        <button type="button" class="chip chip-active">Oui</button>
        <button type="button" class="chip">Non</button>
        <button type="button" class="chip">Sans avis</button>
      </div>
    </div>

    <div class="survey-field">
      <label>Matière optionnelle</label>
      <div class="chip-row">
        <button type="button" class="chip chip-small">Mathématiques</button>
        <button type="button" class="chip chip-small">Marketing</button>
        <button type="button" class="chip chip-small">Réseaux</button>
        <button type="button" class="chip chip-small">IA</button>
      </div>
    </div>

    <div class="survey-field">
      <label>Composition du groupe</label>
      <div class="radio-list">
        <label class="radio-row">
          <input type="radio" name="composition" checked>
          <span>Mixte</span>
        </label>
        <label class="radio-row">
          <input type="radio" name="composition">
          <span>Même niveau</span>
        </label>
        <label class="radio-row">
          <input type="radio" name="composition">
          <span>Peu importe</span>
        </label>
      </div>
    </div>
  </section>

  <section class="accordion">
    <div class="accordion-row">
      <div class="accordion-left">
        <span class="accordion-icon" aria-hidden="true">🧭</span>
        <span>Covoiutage et contraintes géographiques</span>
      </div>
      <span class="accordion-caret" aria-hidden="true">▾</span>
    </div>
    <div class="accordion-row">
      <div class="accordion-left">
        <span class="accordion-icon" aria-hidden="true">🗂</span>
        <span>Organisation des projets</span>
      </div>
      <span class="accordion-caret" aria-hidden="true">▾</span>
    </div>
    <div class="accordion-row">
      <div class="accordion-left">
        <span class="accordion-icon" aria-hidden="true">ℹ️</span>
        <span>Informations de suivi</span>
      </div>
      <span class="accordion-caret" aria-hidden="true">▾</span>
    </div>
  </section>

  <div class="survey-actions">
    <a href="vue/Responsable_Pédagogique/TableauDeBord.php" class="btn-draft" role="button">Enregistrer le brouillon</a>
    <a href="vue/Responsable_Pédagogique/TableauDeBord.php" class="btn-create" role="button">Créer le sondage</a>
  </div>
</main>

<script>
  // Toggle active state within each chip row
  document.querySelectorAll('.chip-row').forEach(function(row) {
    const chips = Array.from(row.querySelectorAll('.chip'));
    chips.forEach(function(chip) {
      chip.addEventListener('click', function() {
        chips.forEach(function(c) { c.classList.remove('chip-active'); });
        chip.classList.add('chip-active');
      });
    });
  });
</script>

</body>
</html>