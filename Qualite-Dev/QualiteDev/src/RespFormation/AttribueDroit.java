package RespFormation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AttribueDroit extends JDialog {

    // Couleurs extraites de la charte graphique
    private final Color ORANGE_ACTION = new Color(255, 120, 0); // Orange du bouton "Attribuer"
    private final Color GREY_BACK = new Color(105, 105, 105);   // Gris du bouton "Retour"
    private final Color INPUT_BG = new Color(240, 240, 240);    // Fond gris clair des champs

    public AttribueDroit(JFrame parent) {
        super(parent, "Attribuer Droits/Rôles", true); // "true" pour bloquer la fenêtre principale (Modale)
        setSize(500, 600);
        setLocationRelativeTo(parent); // Centrer par rapport à l'application
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        // --- 1. EN-TÊTE (TITRE) ---
        // Utilisation de HTML pour permettre le saut de ligne comme sur la maquette
        JLabel title = new JLabel("<html><center>Attribuer Droits/<br>Rôles aux<br>Enseignants</center></html>", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBorder(new EmptyBorder(20, 0, 20, 0));
        add(title, BorderLayout.NORTH);

        // --- 2. FORMULAIRE ---
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(new EmptyBorder(0, 50, 20, 50)); // Marges latérales

        // Ajout des champs basés sur l'image fournie
        formPanel.add(createField("Nom", "Saisissez votre nom"));
        formPanel.add(Box.createVerticalStrut(15)); // Espace vertical
        
        formPanel.add(createField("Prénom", "Saisissez le prénom"));
        formPanel.add(Box.createVerticalStrut(15));
        
        formPanel.add(createField("Rôles", "Saisissez le rôle à attribuer"));
        
        add(formPanel, BorderLayout.CENTER);

        // --- 3. PIED DE PAGE (BOUTONS) ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
        buttonPanel.setBackground(Color.WHITE);

        // Bouton Retour
        JButton btnRetour = new JButton("Retour");
        styleButton(btnRetour, GREY_BACK);
        btnRetour.addActionListener(e -> dispose()); // Ferme la fenêtre

        // Bouton Attribuer
        JButton btnAttribuer = new JButton("Attribuer");
        styleButton(btnAttribuer, ORANGE_ACTION);
        btnAttribuer.addActionListener(e -> {
            // Logique de sauvegarde à implémenter plus tard
            System.out.println("Rôle attribué avec succès !");
            dispose();
        });

        buttonPanel.add(btnRetour);
        buttonPanel.add(btnAttribuer);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Méthode utilitaire pour créer un champ de saisie stylisé avec un label.
     */
    private JPanel createField(String labelText, String placeholder) {
        JPanel p = new JPanel(new BorderLayout(5, 5));
        p.setBackground(Color.WHITE);
        p.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70)); // Hauteur fixe pour l'esthétique

        JLabel lbl = new JLabel(labelText);
        lbl.setFont(new Font("Arial", Font.BOLD, 12));
        
        JTextField txt = new JTextField();
        txt.setText(placeholder); // Simulation du placeholder
        txt.setForeground(Color.GRAY);
        txt.setBackground(INPUT_BG);
        txt.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding interne pour le texte
        
        // Gestion du focus pour effacer le placeholder quand on clique
        txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txt.getText().equals(placeholder)) {
                    txt.setText("");
                    txt.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txt.getText().isEmpty()) {
                    txt.setText(placeholder);
                    txt.setForeground(Color.GRAY);
                }
            }
        });

        p.add(lbl, BorderLayout.NORTH);
        p.add(txt, BorderLayout.CENTER);
        return p;
    }

    /**
     * Méthode utilitaire pour appliquer le style (Couleur, Arrondi) aux boutons.
     */
    private void styleButton(JButton btn, Color bgColor) {
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    
}