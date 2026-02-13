<?php
$erreur = $erreur ?? ($_GET['erreur'] ?? null);
$success = $_GET['success'] ?? null;
$loginSaisi = $_POST['login'] ?? '';
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Page de Connexion</title>
    <link rel="stylesheet" href="css/style_Connexion.css">
</head>
<body>

    <div class="form-container">
        <img src="images/logo-iutorsay.png" alt="Logo IUT">

        <h1>Connexion</h1>

        <?php if ($erreur) { ?>
            <div class="alert alert-error"><?php echo htmlspecialchars($erreur, ENT_QUOTES, 'UTF-8'); ?></div>
        <?php } ?>

        <?php if ($success) { ?>
            <div class="alert alert-success">Compte créé avec succès. Vous pouvez vous connecter.</div>
        <?php } ?>

        <form action="index.php?action=validerConnexion" method="post">
            <div class="input-group">
                <label for="login">Identifiant (email ou nom d'utilisateur)</label>
                <input type="text" id="login" name="login" value="<?php echo htmlspecialchars($loginSaisi, ENT_QUOTES, 'UTF-8'); ?>" placeholder="Saisissez votre identifiant" required>
            </div>

            <div class="input-group">
                <label for="mdp">Mot de passe</label>
                <input type="password" id="mdp" name="mdp" placeholder="Saisissez votre mot de passe" required>
            </div>

            <a href="vue/MotDePasseOublie.php" class="lien-oubli">Mot de passe oublié ?</a>

            <button type="submit" class="btn-connexion">Se Connecter</button>
        </form>

        <div class="creation-compte">
            <span>Vous n'avez pas de compte ?</span>
            <a href="index.php?action=creerCompte">Créer un compte</a>
        </div>
    </div>
</body>
</html>