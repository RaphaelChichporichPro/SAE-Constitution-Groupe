package RespFormation;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateAccountUI extends JFrame {

    // --- Charte Graphique ---
    private static final Color BG_COLOR = new Color(240, 242, 245); // Gris fond
    private static final Color CARD_BG = Color.WHITE;               // Blanc carte
    private static final Color TEXT_COLOR = new Color(30, 30, 30);  // Noir texte
    private static final Color INPUT_BG = new Color(238, 240, 242); // Gris champs
    private static final Color ORANGE_BTN = new Color(255, 100, 0); // Orange
    private static final Color PLACEHOLDER_COLOR = new Color(150, 150, 150);

    public CreateAccountUI() {
        setTitle("Création de Compte - IUT Orsay");
        setSize(1000, 850); // Un peu plus haut car il y a plus de champs
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fond global
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BG_COLOR);
        add(mainPanel);

        // Carte blanche centrée
        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(CARD_BG);
        cardPanel.setBorder(new EmptyBorder(40, 60, 40, 60)); 
        cardPanel.setPreferredSize(new Dimension(550, 750)); // Taille ajustée

        mainPanel.add(cardPanel);

        // --- Ajout des composants ---
        placeComponents(cardPanel);
    }

    private void placeComponents(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 0, 0, 0);

        // 1. Logo
        JLabel logoLabel = new JLabel("<html><center><span style='color:#800040; font-size:16px;'>universite</span> PARIS-SACLAY <span style='color:gray'>|</span> <b>IUT D'ORSAY</b></center></html>", SwingConstants.CENTER);
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        panel.add(logoLabel, gbc);

        // 2. Titre "Création de Compte"
        JLabel titleLabel = new JLabel("Création de Compte", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.BLACK);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 30, 0);
        panel.add(titleLabel, gbc);

        // --- Champs du formulaire ---
        
        // 3. Nom / Prénom
        addFormField(panel, gbc, 2, "Nom /Prénom", "Saisissez votre Nom et Prénom");

        // 4. Date de naissance
        // (Note: Pour la maquette visuelle, on utilise un TextField simple comme sur l'image)
        addFormField(panel, gbc, 4, "Date de naissance", "Sélectionner votre date de naissance");

        // 5. Fonction
        // (Note: L'image montre un champ gris simple, même si c'est un choix logique)
        addFormField(panel, gbc, 6, "Fonction", "Choisir votre fonction");

        // 6. Identifiant
        addFormField(panel, gbc, 8, "Identifiant (email ou nom d'utilisateur)", "Saisissez votre identifiant");

        // 7. Mot de passe (Avec icône oeil)
        gbc.gridy = 10;
        gbc.insets = new Insets(15, 0, 8, 0); // Marge haut un peu plus grande pour séparer
        panel.add(createLabel("Mot de passe"), gbc);

        gbc.gridy = 11;
        gbc.insets = new Insets(0, 0, 30, 0); // Espace avant le bouton
        JPanel passPanel = createPasswordPanel("Saisissez votre mot de passe");
        panel.add(passPanel, gbc);

        // 8. Bouton "Créer"
        // Note: Sur cette maquette, le bouton semble plus petit et centré, pas "full width"
        JButton createButton = new JButton("Créer");
        createButton.setFont(new Font("Arial", Font.BOLD, 16));
        createButton.setForeground(Color.WHITE);
        createButton.setBackground(ORANGE_BTN);
        createButton.setFocusPainted(false);
        createButton.setBorder(new EmptyBorder(10, 40, 10, 40)); // Padding interne pour largeur
        createButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Pour centrer le bouton dans le GridBagLayout, on change le fill
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.NONE; // Ne pas étirer
        gbc.anchor = GridBagConstraints.CENTER; // Centrer
        panel.add(createButton, gbc);
    }

    // Méthode pour ajouter un bloc Label + Input standard
    private void addFormField(JPanel panel, GridBagConstraints gbc, int gridy, String labelText, String placeholder) {
        // Label
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Reset fill
        gbc.insets = new Insets(10, 0, 8, 0); // Espace standard
        panel.add(createLabel(labelText), gbc);

        // Input
        gbc.gridy = gridy + 1;
        gbc.insets = new Insets(0, 0, 5, 0); // Petit espace sous le champ
        JTextField field = createStyledTextField(placeholder);
        panel.add(field, gbc);
    }

    // --- Helpers de Style (Identiques aux autres pages) ---

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setForeground(TEXT_COLOR);
        return label;
    }

    private JTextField createStyledTextField(String placeholder) {
        JTextField field = new JTextField();
        field.setBackground(INPUT_BG);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(INPUT_BG, 1),
                new EmptyBorder(10, 15, 10, 15)
        ));
        setupPlaceholder(field, placeholder);
        return field;
    }

    private JPanel createPasswordPanel(String placeholder) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(INPUT_BG);
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(INPUT_BG, 1),
                new EmptyBorder(2, 2, 2, 2)
        ));

        JPasswordField passField = new JPasswordField();
        passField.setBackground(INPUT_BG);
        passField.setBorder(new EmptyBorder(8, 13, 8, 5));
        passField.setFont(new Font("Arial", Font.PLAIN, 14));
        passField.setEchoChar((char) 0); // Visible pour le placeholder

        JLabel eyeIcon = new JLabel("\uD83D\uDC41");
        eyeIcon.setFont(new Font("SansSerif", Font.PLAIN, 18));
        eyeIcon.setForeground(Color.GRAY);
        eyeIcon.setBorder(new EmptyBorder(0, 5, 0, 10));
        eyeIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));

        eyeIcon.addMouseListener(new MouseAdapter() {
            boolean visible = false;
            @Override
            public void mouseClicked(MouseEvent e) {
                visible = !visible;
                if (visible) {
                    passField.setEchoChar((char) 0);
                    eyeIcon.setForeground(ORANGE_BTN);
                } else {
                    if(!String.valueOf(passField.getPassword()).equals(placeholder)) {
                        passField.setEchoChar('•');
                    }
                    eyeIcon.setForeground(Color.GRAY);
                }
            }
        });

        passField.setText(placeholder);
        passField.setForeground(PLACEHOLDER_COLOR);

        passField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passField.getPassword()).equals(placeholder)) {
                    passField.setText("");
                    passField.setForeground(Color.BLACK);
                    passField.setEchoChar('•');
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (passField.getPassword().length == 0) {
                    passField.setText(placeholder);
                    passField.setForeground(PLACEHOLDER_COLOR);
                    passField.setEchoChar((char) 0);
                }
            }
        });

        panel.add(passField, BorderLayout.CENTER);
        panel.add(eyeIcon, BorderLayout.EAST);
        return panel;
    }

    private void setupPlaceholder(JTextField field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(PLACEHOLDER_COLOR);
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
                    field.setForeground(PLACEHOLDER_COLOR);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CreateAccountUI().setVisible(true);
        });
    }
}