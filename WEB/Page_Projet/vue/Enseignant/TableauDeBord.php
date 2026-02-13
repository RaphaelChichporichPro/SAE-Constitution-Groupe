<?php
// Vue tableau de bord enseignant
?>
<!doctype html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>Tableau de Bord - Enseignant</title>
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
					<a class="nav-item active" href="vue/Enseignant/TableauDeBord.php">
						<img src="images/avatar3.jpg" alt="" class="nav-icon" onerror="this.onerror=null;this.src='images/avatar.svg'">
						<span>Tableau de bord</span>
					</a>
					<a class="nav-item" href="vue/Enseignant/InfoEtudiant.php">
						<img src="images/avatar3.jpg" alt="" class="nav-icon" onerror="this.onerror=null;this.src='images/avatar.svg'">
						<span>Informations (Étudiants)</span>
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
					<h1>Tableau de Bord Enseignant</h1>
				</header>

				<section class="list-section">
					<div class="list-header">
						<h2>Liste de la Promotion</h2>
					</div>

					<div class="tables-container">
						<div class="table-half">
							<table class="data-table">
								<thead>
									<tr>
										<th>Nom</th>
										<th>N° Étudiant</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Martin, Alice</td>
										<td>22001234</td>
									</tr>
									<tr>
										<td>Bernard, Lucas</td>
										<td>22005678</td>
									</tr>
									<tr>
										<td>Dubois, Chloé</td>
										<td>22009012</td>
									</tr>
									<tr>
										<td>Robert, Thomas</td>
										<td>22003456</td>
									</tr>
									<tr>
										<td>Petit, Léa</td>
										<td>22007890</td>
									</tr>
								</tbody>
							</table>
						</div>

						<div class="table-half">
							<h2>Groupes de TD/TP</h2>
							<table class="data-table">
								<thead>
									<tr>
										<th>Groupe</th>
										<th>Effectif</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>TD Groupe 1</td>
										<td><span class="badge badge-green">30 étudiants</span></td>
									</tr>
									<tr>
										<td>TD Groupe 2</td>
										<td><span class="badge badge-green">32 étudiants</span></td>
									</tr>
									<tr>
										<td>TP Groupe A</td>
										<td><span class="badge badge-blue">15 étudiants</span></td>
									</tr>
									<tr>
										<td>TP Groupe B</td>
										<td><span class="badge badge-blue">15 étudiants</span></td>
									</tr>
									<tr>
										<td>TP Groupe C</td>
										<td><span class="badge badge-blue">17 étudiants</span></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</section>
			</main>
		</div>
	</body>
</html>