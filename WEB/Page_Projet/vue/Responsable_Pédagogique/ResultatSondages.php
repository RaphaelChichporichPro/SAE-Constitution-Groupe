<?php
// Vue résultats des sondages (Responsable Pédagogique)
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
        <h1>Résultat Sondage - Responsable Pédagogique</h1>
      </div>
    </header>
<div class="results-backbar">
  <a href="vue/Responsable_Pédagogique/TableauDeBord.php" class="grouping-back-btn">← Retour au tableau de bord</a>
</div>
<main class="results-container">
  <div class="results-header">
    <div>
      <h1>Résultats des sondages</h1>
      <p>Consultez les résultats des sondages créés.</p>
    </div>
    <a class="btn-export-all" href="#">Exporter tout</a>
  </div>

  <div class="results-table-card">
    <div class="results-table-head">
      <span>Titre du sondage</span>
      <span>Date de création</span>
      <span>Statut</span>
      <span>Action</span>
    </div>
    <div class="results-row">
      <span>Sondage sur les préférences de cours</span>
      <span>12/03/2023</span>
      <span class="pill pill-green">Ouvert</span>
      <a href="#" class="link-results">Voir les résultats</a>
    </div>
    <div class="results-row">
      <span>Feedback sur le TP de programmation</span>
      <span>25/02/2023</span>
      <span class="pill pill-red">Fermé</span>
      <a href="#" class="link-results">Voir les résultats</a>
    </div>
    <div class="results-row">
      <span>Disponibilités pour la session de révision</span>
      <span>15/01/2023</span>
      <span class="pill pill-red">Fermé</span>
      <a href="#" class="link-results">Voir les résultats</a>
    </div>
  </div>

  <section class="results-detail">
    <h2>Résultats pour : Sondage sur les préférences de cours</h2>

    <div class="results-tabs">
      <button class="tab active">Question 1</button>
      <button class="tab">Question 2</button>
      <button class="tab">Réponses individuelles</button>
    </div>

    <div class="question-block">
      <h3>Question 1: Quel est votre langage de programmation préféré pour les projets de développement web ?</h3>
      <div class="question-grid">
        <div class="chart-card">
          <h4>Répartition des réponses</h4>
          <div class="bar-row">
            <span>JavaScript</span>
            <div class="bar"><div class="bar-fill bar-blue" style="width: 75%"></div></div>
            <span class="bar-value">75%</span>
          </div>
          <div class="bar-row">
            <span>Python</span>
            <div class="bar"><div class="bar-fill bar-green" style="width: 50%"></div></div>
            <span class="bar-value">50%</span>
          </div>
          <div class="bar-row">
            <span>PHP</span>
            <div class="bar"><div class="bar-fill bar-orange" style="width: 25%"></div></div>
            <span class="bar-value">25%</span>
          </div>
          <div class="bar-row">
            <span>Autre</span>
            <div class="bar"><div class="bar-fill bar-purple" style="width: 10%"></div></div>
            <span class="bar-value">10%</span>
          </div>
        </div>

        <div class="chart-card">
          <h4>Tableau des votes</h4>
          <table class="votes-table">
            <thead>
              <tr>
                <th>Option</th>
                <th>Nombre de votes</th>
              </tr>
            </thead>
            <tbody>
              <tr><td>JavaScript</td><td>15</td></tr>
              <tr><td>Python</td><td>10</td></tr>
              <tr><td>PHP</td><td>5</td></tr>
              <tr><td>Autre</td><td>2</td></tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </section>
</main>

</body>
</html>