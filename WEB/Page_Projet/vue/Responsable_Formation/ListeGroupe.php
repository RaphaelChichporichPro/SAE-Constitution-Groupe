<?php
// Vue Liste des Groupes Responsable Formation
?>
<!doctype html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>Liste des Groupes - Responsable Formation</title>
		<link rel="stylesheet" href="css/style_TableauDeBordRF.css">
	</head>
	<body>
		<div class="app">
			<aside class="sidebar">
				<div class="brand">
					<img src="images/logo.png" alt="logo" class="brand-logo" onerror="this.style.display='none'">
					<img src="images/PhotoProfil.jpg" alt="avatar" class="brand-avatar" onerror="this.onerror=null;this.src='images/avatar.svg'">
					<div class="brand-text">Responsable de<br/>Formation<br/><span class="role">Admin</span></div>
				</div>

				<nav class="nav">
					<a class="nav-item" href="vue/Responsable_Formation/TableauDeBord.php">
						<img src="images/avatar3.jpg" alt="" class="nav-icon" onerror="this.onerror=null;this.src='images/avatar.svg'">
						<span>Gestion des Enseignants</span>
					</a>
					<a class="nav-item active" href="vue/Responsable_Formation/ListeGroupe.php">
						<img src="images/avatar3.jpg" alt="" class="nav-icon" onerror="this.onerror=null;this.src='images/avatar.svg'">
						<span>Visibilité des Groupes</span>
					</a>
				</nav>

				<div class="sidebar-bottom">
					<a href="index.php?action=deconnexion" class="logout">Se déconnecter</a>
					<div class="univ">
						<img src="images/logo-iutorsay.png" alt="IUT d'Orsay" class="iut-logo" onerror="this.onerror=null;this.src='images/logo-iutorsay.svg'">
					</div>
				</div>
			</aside>

			<main class="main">
				<header class="main-header">
					<h1>Visibilité des groupes</h1>
				</header>

				<section class="list-section">
					<div class="list-header">
						<h2>Liste des Groupes</h2>
						<div class="search">
							<input type="search" placeholder="Rechercher un groupe...">
						</div>
					</div>

					<div class="list-empty">
						<svg width="80" height="80" viewBox="0 0 24 24" fill="none" class="empty-icon"><path d="M21 21l-4.35-4.35" stroke="#c3c7cc" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path><circle cx="11" cy="11" r="6" stroke="#c3c7cc" stroke-width="1.5"></circle></svg>
						<p class="empty-title">Aucun groupe trouvé</p>
						<p class="empty-sub">Commencez par enregistrer un nouveau groupe</p>
					</div>
				</section>
			</main>
		</div>
	</body>
</html>