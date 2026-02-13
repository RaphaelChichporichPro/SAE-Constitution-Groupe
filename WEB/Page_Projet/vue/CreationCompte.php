<?php
$erreur = $erreur ?? ($_GET['erreur'] ?? null);
$data = [
    'nom_prenom' => $_POST['nom_prenom'] ?? '',
    'date_naissance' => $_POST['date_naissance'] ?? '',
    'fonction' => $_POST['fonction'] ?? '',
    'login' => $_POST['login'] ?? ''
];
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Page de Création de Compte</title>
    <link rel="stylesheet" href="css/style_Connexion.css">
</head>
<body>

    <div class="form-container">
        <img src="images/logo-iutorsay.png" alt="Logo IUT">

        <h1>Création de Compte</h1>

        <?php if ($erreur) { ?>
            <div class="alert alert-error"><?php echo htmlspecialchars($erreur, ENT_QUOTES, 'UTF-8'); ?></div>
        <?php } ?>

        <form action="index.php?action=enregistrer" method="post">
            
            <div class="input-group">
                <label for="nom_prenom">Nom / Prénom</label>
                <input type="text" id="nom_prenom" name="nom_prenom" value="<?php echo htmlspecialchars($data['nom_prenom'], ENT_QUOTES, 'UTF-8'); ?>" placeholder="Saisissez votre Nom et Prénom" required>
            </div>

            <div class="input-group">
                <label for="date_naissance">Date de naissance</label>
                <input type="date" id="date_naissance" name="date_naissance" value="<?php echo htmlspecialchars($data['date_naissance'], ENT_QUOTES, 'UTF-8'); ?>" required>
            </div>

            <div class="input-group">
                <label for="fonction">Fonction</label>
                <select id="fonction" name="fonction" required>
                    <option value="">-- Sélectionnez votre fonction --</option>
                    <option value="etudiant" <?php if ($data['fonction'] === 'etudiant') echo 'selected'; ?>>Étudiant</option>
                    <option value="enseignant" <?php if ($data['fonction'] === 'enseignant') echo 'selected'; ?>>Enseignant</option>
                    <option value="personnel" <?php if ($data['fonction'] === 'personnel') echo 'selected'; ?>>Responsable Pédagogique</option>
                    <option value="autre" <?php if ($data['fonction'] === 'autre') echo 'selected'; ?>>Responsable Formation</option>
                </select>
            </div>

            <div class="input-group">
                <label for="login">Identifiant (email ou nom d'utilisateur)</label>
                <input type="text" id="login" name="login" value="<?php echo htmlspecialchars($data['login'], ENT_QUOTES, 'UTF-8'); ?>" placeholder="Saisissez votre identifiant" required>
            </div>

            <div class="input-group">
                <label for="mdp">Mot de passe</label>
                <input type="password" id="mdp" name="mdp" placeholder="Saisissez votre mot de passe" required>
            </div>

            <button type="submit" class="btn-connexion">Créer</button>
        </form>
        <div class="connexion">
            <span>Vous avez déjà un compte ?</span>
            <a href="index.php?action=connexion">Connexion</a>
        </div>
    </div>
</body>
</html>