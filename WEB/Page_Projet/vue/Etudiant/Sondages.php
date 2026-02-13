<?php
// Vue sondages étudiant
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Sondages Etudiant</title> <link rel="stylesheet" href="css/style_SondagesE.css">
</head>
<body>
    <img src="images/logo-iutorsay.png" alt="Logo iut" class="logo-iut">
    <div class="sidebar">
      <div class="profile">
        <img class="avatar" src="images/PhotoProfil.jpg" alt="Photo Profil">
        <div class="profile-text">
          <p class="student-name">Nom de l'étudiant à ajouter avec php dynamique</p>
          <p class="student-year">Etudiant de "x" Année à ajouter avec php dynamique</p>
        </div>
      </div>
      <a href="vue/Etudiant/TableauDeBord.php" class="item">Tableau de bord</a>
      <a href="vue/Etudiant/Sondages.php" class="item active">Sondages</a>
      <a href="vue/Etudiant/Information.php" class="item">Information de l'étudiant</a>
      <a href="index.php?action=deconnexion" class="item disconnect">Se déconnecter</a>
    </div>
    <div class="navbar">
      <h1>Sondages</h1>
      <div class="search-box">
        <input type="text" id="search-student" placeholder="Rechercher un étudiant">
      </div>
    </div>
<div class="content">
  <table class="surveys-table">
    <thead>
      <tr>
        <th>Titre du sondage</th>
        <th>Date de création</th>
        <th>Statut</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Sondage sur les préférences de cours</td>
        <td>12/03/2023</td>
        <td><span class="status open">Ouvert</span></td>
        <td><a href="#" class="action-link">Répondre</a></td>
      </tr>
      <tr>
        <td>Feedback sur le TP de programmation</td>
        <td>25/02/2023</td>
        <td><span class="status open">Ouvert</span></td>
        <td><a href="#" class="action-link">Répondre</a></td>
      </tr>
      <tr>
        <td>Disponibilités pour la session de révision</td>
        <td>15/01/2023</td>
        <td><span class="status closed">Fermé</span></td>
        <td></td>
      </tr>
    </tbody>
  </table>

  <div class="survey-detail">
    <h3 class="survey-title">Sondage sur les préférences de cours</h3>
    
    <div class="tabs">
      <button class="tab active" onclick="showQuestion(1)">Question 1</button>
      <button class="tab" onclick="showQuestion(2)">Question 2</button>
      <button class="tab" onclick="showQuestion(3)">Réponses individuelles</button>
    </div>

    <div class="question-container" id="question1">
      <h4 class="question-text">Question 1: Quel est votre langage de programmation préféré pour les projets de développement web ?</h4>
      
      <div class="vote-section">
        <div class="vote-header">
          <span>Faire un vote</span>
          <span class="vote-icon">🗳️</span>
        </div>
        
        <div class="choices-grid">
          <button class="choice-btn">JavaScript</button>
          <button class="choice-btn">Python</button>
          <button class="choice-btn">PHP</button>
          <button class="choice-btn">Autre</button>
        </div>
      </div>
    </div>

    <div class="question-container" id="question2" style="display: none;">
      <h4 class="question-text">Question 2: Votre avis sur l'IA en Informatique</h4>
      
      <div class="vote-section">
        <div class="vote-header">
          <span>Faire un vote</span>
          <span class="vote-icon">🗳️</span>
        </div>
        
        <div class="choices-grid">
          <button class="choice-btn">Obligatoire</button>
          <button class="choice-btn">Très utile</button>
          <button class="choice-btn">utile</button>
          <button class="choice-btn">Inutile</button>
        </div>
      </div>
    </div>

    <div class="question-container" id="question3" style="display: none;">
      <h4 class="question-text">Réponses individuelles</h4>
      <p>Contenu des réponses individuelles à ajouter ici</p>
    </div>
  </div>
</div>

<script>
function showQuestion(num) {
  // Masquer toutes les questions
  document.getElementById('question1').style.display = 'none';
  document.getElementById('question2').style.display = 'none';
  document.getElementById('question3').style.display = 'none';
  
  // Retirer la classe active de tous les onglets
  const tabs = document.querySelectorAll('.tab');
  tabs.forEach(tab => tab.classList.remove('active'));
  
  // Afficher la question sélectionnée
  document.getElementById('question' + num).style.display = 'block';
  
  // Ajouter la classe active à l'onglet cliqué
  tabs[num - 1].classList.add('active');
}
</script>
</body>
</html>