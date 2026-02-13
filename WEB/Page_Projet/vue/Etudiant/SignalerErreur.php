<?php
// Vue signaler erreur étudiant
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Information Étudiant</title>
    <link rel="stylesheet" href="css/style_E.css">
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
      <a href="vue/Etudiant/Sondages.php" class="item">Sondages</a>
      <a href="vue/Etudiant/Information.php" class="item active">Information de l'étudiant</a>
      <a href="index.php?action=deconnexion" class="item disconnect">Se déconnecter</a>
    </div>
    <div class="navbar">
      <h1>Information de l'étudiant</h1>
    </div>
<div class="content">
  <div class="content-main">
    <h2>Mes Données Personnelles</h2>
    <table class="info-table">
    <tbody>
      <tr>
        <td class="label">Nom</td>
        <td class="value">Dupont</td>
      </tr>
      <tr>
        <td class="label">Prénom</td>
        <td class="value">Jean</td>
      </tr>
      <tr>
        <td class="label">Numéro Étudiant</td>
        <td class="value">12345678</td>
      </tr>
      <tr>
        <td class="label">Email</td>
        <td class="value">jean.dupont@email.com</td>
      </tr>
      <tr>
        <td class="label">Adresse</td>
        <td class="value">123 Rue de l'Université, 75000 Paris</td>
      </tr>
    </tbody>
  </table>
  <a href="vue/Etudiant/SignalerErreur.php" class="error-btn">Signaler une erreur</a>

  <div class="promotion-section">
    <div class="promotion-main">
      <h2>Ma Promotion</h2>
      <div class="search-promotion">
        <input type="text" placeholder="Rechercher un étudiant...">
      </div>
      <table class="promotion-table">
        <thead>
          <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Genre</th>
            <th>Type de Bac</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><strong>Martin</strong></td>
            <td>Léa</td>
            <td>F</td>
            <td>Scientifique</td>
            <td>lea.martin@email.com</td>
          </tr>
          <tr>
            <td><strong>Bernard</strong></td>
            <td>Thomas</td>
            <td>M</td>
            <td>Économique</td>
            <td>thomas.bernard@email.com</td>
          </tr>
          <tr>
            <td><strong>Dubois</strong></td>
            <td>Camille</td>
            <td>F</td>
            <td>Littéraire</td>
            <td>camille.dubois@email.com</td>
          </tr>
          <tr>
            <td><strong>Robert</strong></td>
            <td>Hugo</td>
            <td>M</td>
            <td>Scientifique</td>
            <td>hugo.robert@email.com</td>
          </tr>
        </tbody>
      </table>
      <p class="info-message">Pour des raisons de confidentialité, les informations complètes des étudiants ne sont pas toutes affichées. Veuillez respecter la privée de vos camarades.</p>
    </div>

    <div class="promotion-sidebar">
      <div class="sidebar-section">
        <h3>Mon Groupe de TD/TP</h3>
        <div class="group-display">TD 3 / TP B</div>
      </div>

      <div class="sidebar-section">
        <h3>Mes Préférences</h3>
        <div class="preferences">
          <div class="preference-item">
            <span>Je suis ouvert(e) au covoiturage</span>
            <label class="toggle">
              <input type="checkbox" checked>
              <span class="toggle-slider"></span>
            </label>
          </div>
          <div class="preference-item">
            <span>J'accepte de participer aux sondages anonymes</span>
            <label class="toggle">
              <input type="checkbox">
              <span class="toggle-slider"></span>
            </label>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="modal-overlay" id="errorModal">
  <div class="modal-content">
    <div class="modal-header">
      <img src="images/warning.png" alt="Avertissement" class="modal-icon">
      <h2>Signaler</h2>
    </div>
    
    <div class="modal-body">
      <div class="form-group">
        <label for="error-type">Type d'erreur</label>
        <input type="text" id="error-type" placeholder="Saisissez le type d'erreur">
      </div>
      
      <div class="form-group">
        <label for="error-message">Rédigez votre message</label>
        <textarea id="error-message" placeholder="Écrire..."></textarea>
      </div>
    </div>
    
    <div class="modal-footer">
      <button class="btn-secondary" onclick="document.getElementById('errorModal').style.display='none';">Retour</button>
      <button class="btn-primary" onclick="window.location.href='vue/Etudiant/Information.php';">Envoyer</button>
    </div>
  </div>
</div>

</body>
</html>