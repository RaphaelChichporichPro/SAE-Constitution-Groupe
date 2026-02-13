package RespFormation;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LoginPageUI extends JFrame {

    // --- Charte Graphique (Pipette sur l'image) ---
    private static final Color BG_COLOR = new Color(240, 242, 245); // Fond gris global
    private static final Color CARD_BG = Color.WHITE;               // Fond carte
    private static final Color TEXT_COLOR = new Color(30, 30, 30);  // Texte noir/gris foncé
    private static final Color INPUT_BG = new Color(238, 240, 242); // Fond des inputs
    private static final Color ORANGE_BTN = new Color(255, 100, 0); // Bouton Orange
    private static final Color LINK_BLUE = new Color(0, 102, 204);  // Lien bleu
    private static final Color ORANGE_LINK = new Color(255, 120, 20); // Lien mdp oublié

    public LoginPageUI() {
        // Configuration Fenêtre
        setTitle("Connexion - IUT Orsay");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel Principal (Fond Gris)
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BG_COLOR);
        add(mainPanel);

        // Panel Carte (Blanc au centre)
        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(CARD_BG);
        // Padding interne de la carte (Haut, Gauche, Bas, Droite)
        cardPanel.setBorder(new EmptyBorder(40, 60, 40, 60)); 
        
        // Taille fixe suggérée pour ressembler à la maquette
        cardPanel.setPreferredSize(new Dimension(500, 650));

        // Ajout de la carte au centre du fond gris
        mainPanel.add(cardPanel);

        // --- Construction du contenu ---
        placeComponents(cardPanel);
    }

    private void placeComponents(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0); // Reset padding
        gbc.weightx = 1.0;

        // 1. Logo (HTML pour le style)
        // Note: Idéalement on utilise une ImageIcon, ici on simule en texte
        JLabel logoLabel = new JLabel("<html><center><span style='color:#800040; font-size:16px;'>universite</span> PARIS-SACLAY <span style='color:gray'>|</span> <b>IUT D'ORSAY</b></center></html>", SwingConstants.CENTER);
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 40, 0); // Espace sous le logo
        panel.add(logoLabel, gbc);

        // 2. Titre "Connexion"
        JLabel titleLabel = new JLabel("Connexion", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.BLACK);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 30, 0);
        panel.add(titleLabel, gbc);

        // 3. Label Identifiant
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 8, 0);
        panel.add(createLabel("Identifiant (email ou nom d'utilisateur)"), gbc);

        // 4. Champ Identifiant
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 20, 0);
        JTextField userField = createStyledTextField("Saisissez votre identifiant");
        panel.add(userField, gbc);

        // 5. Label Mot de Passe
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 8, 0);
        panel.add(createLabel("Mot de passe"), gbc);

        // 6. Champ Mot de Passe (Complexe avec icône Oeil)
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 0, 10, 0);
        JPanel passwordContainer = createPasswordPanel("Saisissez votre mot de passe");
        panel.add(passwordContainer, gbc);

        // 7. Lien "Mot de passe oublié ?"
        JLabel forgotPassLabel = new JLabel("Mot de passe oublié ?");
        forgotPassLabel.setFont(new Font("Arial", Font.BOLD, 12));
        forgotPassLabel.setForeground(ORANGE_LINK);
        forgotPassLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 0, 25, 0);
        panel.add(forgotPassLabel, gbc);

        // 8. Bouton "Se connecter"
        JButton loginButton = new JButton("Se connecter");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(ORANGE_BTN);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(new EmptyBorder(12, 0, 12, 0)); // Hauteur du bouton
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy = 7;
        gbc.insets = new Insets(0, 0, 25, 0);
        panel.add(loginButton, gbc);

        // 9. Footer (Créer un compte)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(CARD_BG);
        
        JLabel noAccountLabel = new JLabel("Vous n'avez pas de compte ? ");
        noAccountLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        noAccountLabel.setForeground(Color.GRAY);
        
        JLabel createAccountLink = new JLabel("Créer un compte");
        createAccountLink.setFont(new Font("Arial", Font.BOLD, 12));
        createAccountLink.setForeground(LINK_BLUE);
        createAccountLink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        footerPanel.add(noAccountLabel);
        footerPanel.add(createAccountLink);

        gbc.gridy = 8;
        gbc.insets = new Insets(10, 0, 0, 0);
        panel.add(footerPanel, gbc);
    }

    // --- Méthodes Utilitaires de Design ---

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setForeground(TEXT_COLOR);
        return label;
    }

    private JTextField createStyledTextField(String placeholder) {
        JTextField field = new JTextField();
        // Style visuel
        field.setBackground(INPUT_BG);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(INPUT_BG, 1), 
            new EmptyBorder(10, 15, 10, 15)
        ));
        
        // Logique Placeholder
        setupPlaceholder(field, placeholder);
        
        return field;
    }

    // Création du champ mot de passe avec l'icône "Oeil"
    private JPanel createPasswordPanel(String placeholder) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(INPUT_BG);
        panel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(INPUT_BG, 1), 
            new EmptyBorder(2, 2, 2, 2)
        ));

        JPasswordField passField = new JPasswordField();
        passField.setBackground(INPUT_BG);
        passField.setBorder(new EmptyBorder(8, 13, 8, 5)); // Padding interne
        passField.setFont(new Font("Arial", Font.PLAIN, 14));
        passField.setEchoChar((char) 0); // Visible par défaut pour afficher le placeholder

        // Bouton Oeil (Simulation Unicode)
        JLabel eyeIcon = new JLabel("\uD83D\uDC41"); // Symbole Oeil Unicode
        eyeIcon.setFont(new Font("SansSerif", Font.PLAIN, 18));
        eyeIcon.setForeground(Color.GRAY);
        eyeIcon.setBorder(new EmptyBorder(0, 5, 0, 10));
        eyeIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Interaction Oeil
        eyeIcon.addMouseListener(new MouseAdapter() {
            boolean visible = false;
            @Override
            public void mouseClicked(MouseEvent e) {
                visible = !visible;
                if (visible) {
                    passField.setEchoChar((char) 0); // Visible
                    eyeIcon.setForeground(ORANGE_BTN); // Feedback visuel
                } else {
                    if(!String.valueOf(passField.getPassword()).equals(placeholder)) {
                        passField.setEchoChar('•'); // Masqué
                    }
                    eyeIcon.setForeground(Color.GRAY);
                }
            }
        });

        // Logique Placeholder spécifique au Password
        passField.setText(placeholder);
        passField.setForeground(Color.GRAY);
        
        passField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passField.getPassword()).equals(placeholder)) {
                    passField.setText("");
                    passField.setForeground(Color.BLACK);
                    passField.setEchoChar('•'); // Activer le masquage à la frappe
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (passField.getPassword().length == 0) {
                    passField.setText(placeholder);
                    passField.setForeground(Color.GRAY);
                    passField.setEchoChar((char) 0); // Désactiver masquage pour lire placeholder
                }
            }
        });

        panel.add(passField, BorderLayout.CENTER);
        panel.add(eyeIcon, BorderLayout.EAST);
        
        return panel;
    }

    private void setupPlaceholder(JTextField field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(Color.GRAY);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginPageUI frame = new LoginPageUI();
            frame.setVisible(true);
        });
    }
}