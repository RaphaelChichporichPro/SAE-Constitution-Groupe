<?php
// Vue détail étudiant pour un enseignant
?>
<!doctype html>
<html lang="fr">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>Détails de l'étudiant - Enseignant</title>
	<link rel="stylesheet" href="css/style_TableauDeBordRF.css">
	<link rel="stylesheet" href="css/style_TableauDeBordE.css">
</head>
<body>
	<div class="app">
		<aside class="sidebar">
			<div class="brand">
				<img src="images/logo.png" alt="logo" class="brand-logo" onerror="this.style.display='none'">
				<img src="images/PhotoProfil.jpg" alt="avatar" class="brand-avatar" onerror="this.onerror=null;this.src='images/avatar.svg'">
				<div class="brand-text">Mr. Dupont<br/>Enseignant<br/><span class="role">Computer Science</span></div>
			</div>

			<nav class="nav">
				<a class="nav-item" href="vue/Enseignant/TableauDeBord.php">
					<img src="images/avatar3.jpg" alt="" class="nav-icon" onerror="this.onerror=null;this.src='images/avatar.svg'">
					<span>Tableau de bord</span>
				</a>
				<a class="nav-item" href="vue/Enseignant/InfoEtudiant.php">
					<img src="images/avatar3.jpg" alt="" class="nav-icon" onerror="this.onerror=null;this.src='images/avatar.svg'">
					<span>Informations Étudiants</span>
				</a>
			</nav>

			<div class="sidebar-bottom">
				<a class="logout" href="index.php?action=deconnexion">Déconnexion</a>
				<div class="univ">
					<img src="images/logo-iutorsay.png" alt="IUT d'Orsay" class="iut-logo" onerror="this.onerror=null;this.src='images/logo-iutorsay.svg'">
				</div>
			</div>
		</aside>

		<main class="main">
			<header class="main-header">
				<h1>Détails de l'étudiant</h1>
			</header>

			<section class="card" style="margin-top:18px;padding:18px;">
				<a href="vue/Enseignant/InfoEtudiant.php" class="btn btn-secondary" style="display:inline-flex;align-items:center;gap:8px;margin-bottom:12px">← Retour à la liste</a>

				<div style="background:var(--card);border-radius:8px;padding:18px;border:1px solid #eef1f4">
					<h3 style="color:#0f1724;margin:0 0 12px">Informations Personnelles</h3>
					<div style="display:grid;grid-template-columns:repeat(3,1fr);gap:12px;padding-top:8px">
						<div>
							<strong>Numéro Étudiant</strong>
							<p>123456</p>
						</div>
						<div>
							<strong>Nom</strong>
							<p>Dupont</p>
						</div>
						<div>
							<strong>Prénom</strong>
							<p>Jean</p>
						</div>
						<div>
							<strong>Genre</strong>
							<p>Masculin</p>
						</div>
						<div>
							<strong>Date de Naissance</strong>
							<p>01/01/2000</p>
						</div>
						<div>
							<strong>Email Universitaire</strong>
							<p>jean.dupont@univ.fr</p>
						</div>
						<div>
							<strong>Type de Bac</strong>
							<p>Scientifique</p>
						</div>
						<div>
							<strong>Périodes de Redoublement</strong>
							<p>Aucune</p>
						</div>
					</div>
				</div>

				<div style="background:var(--card);border-radius:8px;padding:18px;border:1px solid #eef1f4;margin-top:14px">
					<h3 style="color:#0f1724;margin:0 0 12px">Informations de Groupe</h3>
					<p>Groupe TD/TP: <span class="badge badge-blue">TD-G03 / TP-B01</span></p>
				</div>

				<div style="background:var(--card);border-radius:8px;padding:18px;border:1px solid #eef1f4;margin-top:14px">
					<h3 style="color:#0f1724;margin:0 0 12px">Autres</h3>
					<div style="background:#f9fafb;border-radius:8px;padding:12px;">
						<label style="display:block;color:#6b7280;margin-bottom:6px">Disponibilité pour les sessions de tutorat</label>
						<select style="width:100%;padding:10px;border-radius:6px;border:1px solid #e6e9ec;background:#fff">
							<option>Disponible</option>
							<option>Non disponible</option>
						</select>
					</div>
				</div>
			</section>
		</main>
	</div>
</body>
</html>