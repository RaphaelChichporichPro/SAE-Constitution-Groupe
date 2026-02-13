<?php
$erreur = $erreur ?? ($_GET['erreur'] ?? null);
$message = $_GET['message'] ?? null;
$loginSaisi = $_POST['login'] ?? ($_GET['login'] ?? '');
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Page de Mot de passe</title>
    <link rel="stylesheet" href="css/style_Connexion.css">
</head>
<body>

    <div class="form-container">
        <img src="images/logo-iutorsay.png" alt="Logo IUT">

        <h1>Nouveau Mot de Passe</h1>

        <?php if ($erreur) { ?>
            <div class="alert alert-error"><?php echo htmlspecialchars($erreur, ENT_QUOTES, 'UTF-8'); ?></div>
        <?php } ?>

        <?php if ($message) { ?>
            <div class="alert alert-success"><?php echo htmlspecialchars($message, ENT_QUOTES, 'UTF-8'); ?></div>
        <?php } ?>

        <form action="index.php?action=motDePasseOublie" method="post">

            <div class="input-group">
                <label for="login">Identifiant (email ou nom d'utilisateur)</label>
                <input type="text" id="login" name="login" value="<?php echo htmlspecialchars($loginSaisi, ENT_QUOTES, 'UTF-8'); ?>" placeholder="Saisissez votre identifiant" required>
            </div>

            <p class="mail-gras-p">Un mail sera envoyé sur votre boîte mail.</p>

            <div class="input-group">
                <label for="mdp">Nouveau mot de passe</label>
                <input type="password" id="mdp" name="mdp" placeholder="Saisissez votre nouveau mot de passe" required>
            </div>

            <div class="input-group">
                <label for="mdp_confirmation">Confirmation</label>
                <input type="password" id="mdp_confirmation" name="mdp_confirmation" placeholder="Confirmez votre mot de passe" required>
            </div>

            <button type="submit" class="btn-connexion">Confirmer</button>
        </form>
        
        <div class="creation-compte">
            <span>Vous n'avez pas de compte ?</span>
            <a href="index.php?action=creerCompte">Créer un compte</a>
        </div>
    </div>
</body>
</html>