package Etudiant;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PasswordResetUi extends JFrame {

    // Couleurs extraites de la maquette
    private static final Color BG_COLOR = new Color(240, 242, 245); // Gris clair fond page
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TEXT_COLOR = new Color(30, 30, 30);
    private static final Color INPUT_BG = new Color(238, 240, 242); // Gris champs
    private static final Color BUTTON_COLOR = new Color(255, 100, 0); // Orange
    private static final Color LINK_COLOR = new Color(0, 102, 204); // Bleu lien

    public PasswordResetUi() {
        setTitle("Mot de Passe Oublié - IUT Orsay");
        setSize(1000, 800); // Taille initiale
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panneau principal (Fond gris global)
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BG_COLOR);
        add(mainPanel);

        // La "Carte" blanche centrale
        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(CARD_COLOR);
        cardPanel.setBorder(new EmptyBorder(40, 50, 40, 50)); // Padding interne de la carte
        
        // Configuration pour centrer la carte
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        // La carte a une taille préférée fixe pour ressembler à la maquette
        cardPanel.setPreferredSize(new Dimension(500, 680)); 
        mainPanel.add(cardPanel, gbc);

        // --- Remplissage de la carte ---
        addComponentsToCard(cardPanel);
    }

    private void addComponentsToCard(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 15, 0); // Espacement vertical standard
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.weightx = 1.0;

        // 1. Logo (Simulation texte car pas d'image)
        JLabel logoLabel = new JLabel("<html><center><span style='color:#800040; font-size:18px;'>universite</span> PARIS-SACLAY <span style='color:gray'>|</span> <b>IUT D'ORSAY</b></center></html>", SwingConstants.CENTER);
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        panel.add(logoLabel, gbc);

        // 2. Titre "Nouveau Mot de Passe"
        JLabel titleLabel = new JLabel("Nouveau Mot de Passe", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(Color.BLACK);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 25, 0);
        panel.add(titleLabel, gbc);

        // 3. Label Identifiant
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 0, 5, 0);
        panel.add(createLabel("Identifiant (email ou nom d'utilisateur)"), gbc);

        // 4. Champ Identifiant
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 20, 0);
        JTextField idField = createStyledTextField("Saisissez votre identifiant");
        panel.add(idField, gbc);

        // 5. Info Box (Boite blanche avec bordure)
        JPanel infoBox = new JPanel(new BorderLayout());
        infoBox.setBackground(Color.WHITE);
        infoBox.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        JLabel infoText = new JLabel("Un mail sera envoyé sur votre boîte mail.", SwingConstants.CENTER);
        infoText.setFont(new Font("Arial", Font.BOLD, 13));
        infoText.setBorder(new EmptyBorder(15, 10, 15, 10));
        infoBox.add(infoText);
        
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 20, 0);
        panel.add(infoBox, gbc);

        // 6. Label Nouveau MDP
        gbc.gridy = 5;
        gbc.insets = new Insets(5, 0, 5, 0);
        panel.add(createLabel("Nouveau mot de passe"), gbc);

        // 7. Champ Nouveau MDP
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 0, 10, 0);
        JPasswordField passField1 = createStyledPasswordField("Saisissez votre nouveau mot de passe");
        panel.add(passField1, gbc);

        // 8. Label Confirmation
        gbc.gridy = 7;
        gbc.insets = new Insets(5, 0, 5, 0);
        panel.add(createLabel("Confirmation"), gbc);

        // 9. Champ Confirmation
        gbc.gridy = 8;
        gbc.insets = new Insets(0, 0, 30, 0);
        JPasswordField passField2 = createStyledPasswordField("Confirmez votre mot de passe");
        panel.add(passField2, gbc);

        // 10. Bouton Confirmer
        JButton confirmButton = new JButton("Confirmer");
        confirmButton.setBackground(BUTTON_COLOR);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new Font("Arial", Font.BOLD, 16));
        confirmButton.setFocusPainted(false);
        confirmButton.setBorder(new EmptyBorder(12, 0, 12, 0)); // Padding bouton
        confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        gbc.gridy = 9;
        gbc.insets = new Insets(0, 0, 20, 0);
        panel.add(confirmButton, gbc);

        // 11. Footer (Lien créer compte)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(CARD_COLOR);
        JLabel noAccountLabel = new JLabel("Vous n'avez pas de compte ? ");
        noAccountLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        noAccountLabel.setForeground(Color.GRAY);
        
        JLabel createAccountLink = new JLabel("Créer un compte");
        createAccountLink.setFont(new Font("Arial", Font.BOLD, 12));
        createAccountLink.setForeground(LINK_COLOR);
        createAccountLink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        footerPanel.add(noAccountLabel);
        footerPanel.add(createAccountLink);

        gbc.gridy = 10;
        panel.add(footerPanel, gbc);
    }

    // --- Méthodes utilitaires pour le style ---

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setForeground(TEXT_COLOR);
        return label;
    }

    private JTextField createStyledTextField(String placeholder) {
        JTextField field = new JTextField();
        styleField(field, placeholder);
        return field;
    }

    private JPasswordField createStyledPasswordField(String placeholder) {
        JPasswordField field = new JPasswordField();
        styleField(field, placeholder);
        // Pour voir le placeholder sur un password field, on doit changer le caractère d'écho
        char defaultEcho = field.getEchoChar();
        field.setEchoChar((char) 0); // Pas de masquage quand placeholder est visible
        
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                    field.setEchoChar(defaultEcho); // Remettre le masquage
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (field.getPassword().length == 0) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                    field.setEchoChar((char) 0); // Enlever masquage pour lire le placeholder
                }
            }
        });
        return field;
    }

    private void styleField(JTextField field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(Color.GRAY);
        field.setBackground(INPUT_BG);
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(INPUT_BG, 1), // Bordure invisible couleur fond
                BorderFactory.createEmptyBorder(10, 15, 10, 15) // Padding interne
        ));
        field.setFont(new Font("Arial", Font.PLAIN, 14));

        // Gestion du Placeholder simple pour JTextField
        if (!(field instanceof JPasswordField)) {
            field.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (field.getText().equals(placeholder)) {
                        field.setText("");
                        field.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (field.getText().isEmpty()) {
                        field.setText(placeholder);
                        field.setForeground(Color.GRAY);
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        // Appliquer un LookAndFeel système pour de meilleures polices
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            new PasswordResetUi().setVisible(true);
        });
    }
}