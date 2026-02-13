<?php
// Vue informations étudiants pour enseignant
?>
<!doctype html>
<html lang="fr">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>Informations des Étudiants - Enseignant</title>
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
				<a class="nav-item active" href="vue/Enseignant/InfoEtudiant.php">
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
				<h1>Informations des Étudiants</h1>
			</header>

			<section class="list-section">
				<div class="list-header">
					<h2>Informations pédagogiques détaillées de vos étudiants.</h2>
					<div style="display:flex;gap:12px;align-items:center;">
						<div class="search"><input type="search" placeholder="Rechercher par nom, ID..."></div>
						<a href="#" class="btn btn-primary">Exporter en CSV</a>
					</div>
				</div>

				<div style="margin-top:18px;display:flex;gap:8px;">
					<button class="btn btn-outline">Filtrer par promotion</button>
					<button class="btn btn-outline">Filtrer par type de bac</button>
					<button class="btn btn-outline">Filtrer par redoublement</button>
				</div>

				<div class="tables-container">
					<div class="table-half">
						<table class="data-table">
							<thead>
								<tr>
									<th>Numéro Étudiant</th>
									<th>Nom</th>
									<th>Prénom</th>
									<th>Genre</th>
									<th>Email Universitaire</th>
									<th>Type de Bac</th>
									<th>Périodes de Redoublement</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>22104587</td>
									<td>Dupont</td>
									<td>Marie</td>
									<td>Féminin</td>
									<td>marie.dupont@etu.univ.fr</td>
									<td>Baccalauréat Scientifique</td>
									<td><span class="badge badge-yellow">L1 (2022-2023)</span></td>
									<td><a href="vue/Enseignant/DetailEtudiant.php">Détails</a></td>
								</tr>
								<tr>
									<td>22104588</td>
									<td>Martin</td>
									<td>Lucas</td>
									<td>Masculin</td>
									<td>lucas.martin@etu.univ.fr</td>
									<td>Baccalauréat Économique et Social</td>
									<td><span class="badge badge-green">Aucune</span></td>
									<td><a href="vue/Enseignant/DetailEtudiant.php">Détails</a></td>
								</tr>
								<tr>
									<td>22104589</td>
									<td>Petit</td>
									<td>Camille</td>
									<td>Féminin</td>
									<td>camille.petit@etu.univ.fr</td>
									<td>Baccalauréat Littéraire</td>
									<td><span class="badge badge-green">Aucune</span></td>
									<td><a href="vue/Enseignant/DetailEtudiant.php">Détails</a></td>
								</tr>
								<tr>
									<td>22104590</td>
									<td>Dubois</td>
									<td>Hugo</td>
									<td>Masculin</td>
									<td>hugo.dubois@etu.univ.fr</td>
									<td>Baccalauréat Scientifique</td>
									<td><span class="badge badge-green">Aucune</span></td>
									<td><a href="vue/Enseignant/DetailEtudiant.php">Détails</a></td>
								</tr>
								<tr>
									<td>22104591</td>
									<td>Moreau</td>
									<td>Léa</td>
									<td>Féminin</td>
									<td>lea.moreau@etu.univ.fr</td>
									<td>Baccalauréat Scientifique</td>
									<td><span class="badge badge-yellow">L2 (2023-2024)</span></td>
									<td><a href="vue/Enseignant/DetailEtudiant.php">Détails</a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<div style="margin-top:18px;display:flex;justify-content:center;gap:8px;align-items:center;">
					<button class="btn btn-outline">&lt;</button>
					<button class="btn btn-primary">1</button>
					<button class="btn">2</button>
					<button class="btn">3</button>
					<span>…</span>
					<button class="btn">10</button>
					<button class="btn btn-outline">&gt;</button>
				</div>
			</section>
		</main>
	</div>
</body>
</html>