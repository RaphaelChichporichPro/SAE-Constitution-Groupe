package RespFormation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

// Imports pour le package Etudiant (si ces fichiers existent)
//import Etudiant.DashboardUI;
import Etudiant.StudentInfoUI;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        // Lancement de la fenêtre dans le thread Swing
        EventQueue.invokeLater(() -> {
            try {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainFrame() {
        setTitle("Menu Principal - Projet QualiteDev");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 600); // Taille ajustée pour contenir tous les boutons
        setLocationRelativeTo(null); // Centrer à l'écran

        // Panneau principal avec une mise en page en liste verticale
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new GridLayout(0, 1, 0, 10)); // 1 colonne, espacement de 10px
        setContentPane(contentPane);

        // Titre
        JLabel lblTitre = new JLabel("Menu de Navigation", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitre.setBorder(new EmptyBorder(0, 0, 10, 0));
        contentPane.add(lblTitre);

        // --- 1. BOUTONS DU PACKAGE RespFormation ---

        // Cas spécial : SaveStudent est un JDialog (besoin d'un parent)
        ajouterBouton(contentPane, "Enregistrer Enseignant (SaveStudent)", e -> {
            // 'this' représente cette fenêtre MainFrame qui agit comme parent
            SaveStudent dialog = new SaveStudent(this);
            dialog.setVisible(true);
        });

        // Cas spécial : AttribueDroit est un JDialog
        ajouterBouton(contentPane, "Attribuer Droits (AttribueDroit)", e -> {
            AttribueDroit dialog = new AttribueDroit(this);
            dialog.setVisible(true);
        });

        // Les autres sont des JFrames autonomes
        ajouterBouton(contentPane, "Créer Compte (CreateAccountUI)", e -> {
            new CreateAccountUI().setVisible(true);
        });

        ajouterBouton(contentPane, "Connexion (LoginPageUI)", e -> {
            new LoginPageUI().setVisible(true);
        });

        ajouterBouton(contentPane, "Reset Password (PasswordResetUi)", e -> {
            new PasswordResetUi().setVisible(true);
        });

        // --- 2. BOUTONS DU PACKAGE Etudiant ---
        
        /*ajouterBouton(contentPane, "Dashboard Étudiant", e -> {
            try {
                // Vérifie que DashboardUI existe et est public
                new DashboardUI().setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur ouverture DashboardUI: " + ex);
            }
        });*/

        ajouterBouton(contentPane, "Info Étudiant", e -> {
            try {
                new StudentInfoUI().setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur ouverture StudentInfoUI: " + ex);
            }
        });
    }

    // Petite méthode pour éviter de répéter le code de création de bouton
    private void ajouterBouton(JPanel panel, String texte, ActionListener action) {
        JButton btn = new JButton(texte);
        btn.setFont(new Font("Arial", Font.PLAIN, 14));
        btn.setFocusPainted(false);
        btn.addActionListener(action);
        panel.add(btn);
    }
}