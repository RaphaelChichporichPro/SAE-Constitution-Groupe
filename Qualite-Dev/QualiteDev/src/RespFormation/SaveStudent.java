package RespFormation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SaveStudent extends JDialog {

    private boolean valide = false; // Pour savoir si on a cliqué sur Ajouter

    // Couleurs de la charte
    private final Color ORANGE_ACTION = new Color(255, 120, 0); // Orange du bouton
    private final Color GREY_BACK = new Color(105, 105, 105);   // Gris du bouton Retour
    private final Color INPUT_BG = new Color(240, 240, 240);    // Gris clair des champs

    public SaveStudent(JFrame parent) {
        super(parent, "Enregistrement Nouvel Enseignant", true); // "true" rend la fenêtre Modale
        setSize(500, 600);
        setLocationRelativeTo(parent); // Centrer sur la fenêtre principale
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        // --- 1. LE TITRE ---
        JLabel title = new JLabel("Enregistrement Enseignant", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBorder(new EmptyBorder(30, 0, 30, 0));
        add(title, BorderLayout.NORTH);

        // --- 2. LE FORMULAIRE ---
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(new EmptyBorder(0, 50, 20, 50)); // Marges gauche/droite

        // Ajout des champs
        formPanel.add(createField("Nom", "Saisissez votre nom"));
        formPanel.add(Box.createVerticalStrut(15)); // Espace
        formPanel.add(createField("Prénom", "Saisissez le prénom"));
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(createField("Matière", "Saisissez la matière"));
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(createField("Groupe", "Saisissez le groupe")); // Pourrait être un JComboBox plus tard

        add(formPanel, BorderLayout.CENTER);

        // --- 3. LES BOUTONS (FOOTER) ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
        buttonPanel.setBackground(Color.WHITE);

        JButton btnRetour = new JButton("Retour");
        styleButton(btnRetour, GREY_BACK);
        btnRetour.addActionListener(e -> dispose()); // Ferme la fenêtre

        JButton btnAjouter = new JButton("Ajouter");
        styleButton(btnAjouter, ORANGE_ACTION);
        btnAjouter.addActionListener(e -> {
            // Ici tu mettras le code pour sauvegarder dans la BDD
            System.out.println("Enseignant ajouté !");
            valide = true;
            dispose();
        });

        buttonPanel.add(btnRetour);
        buttonPanel.add(btnAjouter);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Helper pour créer un bloc "Label + Champ Texte" stylisé
     */
    private JPanel createField(String labelText, String placeholder) {
        JPanel p = new JPanel(new BorderLayout(5, 5));
        p.setBackground(Color.WHITE);
        p.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70)); // Hauteur fixe

        JLabel lbl = new JLabel(labelText);
        lbl.setFont(new Font("Arial", Font.BOLD, 12));
        
        JTextField txt = new JTextField();
        txt.setText(placeholder); // Placeholder simulé
        txt.setForeground(Color.GRAY);
        txt.setBackground(INPUT_BG);
        txt.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding interne
        
        // Petit effet pour effacer le placeholder au clic (Optionnel mais sympa)
        txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txt.getText().equals(placeholder)) {
                    txt.setText("");
                    txt.setForeground(Color.BLACK);
                }
            }
        });

        p.add(lbl, BorderLayout.NORTH);
        p.add(txt, BorderLayout.CENTER);
        return p;
    }

    /**
     * Helper pour styliser les boutons (Arrondis et couleurs)
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