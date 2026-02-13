package RespPedago;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    /**
     * Point d'entrée principal pour tester tout le package RespPedago
     */
    public static void main(String[] args) {
        // Lancement dans le thread graphique (EDT)
        SwingUtilities.invokeLater(() -> {
            try {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Constructeur du Menu
     */
    public MainFrame() {
        setTitle("Menu Principal - Responsable Pédagogique");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null); // Centrer l'écran

        // Panneau principal avec une liste verticale
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new GridLayout(0, 1, 0, 15)); // 1 colonne, espace de 15px entre les boutons
        setContentPane(contentPane);

        // Titre
        JLabel lblTitre = new JLabel("Navigation RespPedago", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitre.setBorder(new EmptyBorder(0, 0, 20, 0));
        contentPane.add(lblTitre);

        // --- AJOUT DES BOUTONS POUR CHAQUE PAGE ---

        // 1. Tableau de Bord (TableauDeBordAdmin)
        ajouterBouton(contentPane, "Tableau de Bord Admin", e -> {
            new TableauDeBordAdmin().setVisible(true);
        });

        // 2. Sondages (SondagesUI)
        ajouterBouton(contentPane, "Gestion des Sondages", e -> {
            new SondagesUI().setVisible(true);
        });

        // 3. Connexion (LoginPageUI)
        ajouterBouton(contentPane, "Page de Connexion", e -> {
            new LoginPageUI().setVisible(true);
        });

        // 4. Création de Compte (CreateAccountUI)
        ajouterBouton(contentPane, "Création de Compte", e -> {
            new CreateAccountUI().setVisible(true);
        });

        // 5. Mot de Passe Oublié (PasswordResetUi)
        ajouterBouton(contentPane, "Reset Mot de Passe", e -> {
            new PasswordResetUi().setVisible(true);
        });
        
        // Bouton Quitter pour fermer proprement le menu si besoin
        JButton btnQuitter = new JButton("Fermer le menu");
        btnQuitter.setBackground(new Color(200, 50, 50));
        btnQuitter.setForeground(Color.WHITE);
        btnQuitter.addActionListener(e -> System.exit(0));
        contentPane.add(btnQuitter);
    }

    /**
     * Méthode utilitaire pour créer un bouton stylisé rapidement
     */
    private void ajouterBouton(JPanel panel, String texte, ActionListener action) {
        JButton btn = new JButton(texte);
        btn.setFont(new Font("Arial", Font.PLAIN, 16));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(action);
        panel.add(btn);
    }
}