package frames;

import style.UIStyle;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Connexion - Gestion des Groupes IUT");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Fond
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(UIStyle.BG_COLOR);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 40, 50, 40));

        // Logo / Titre
        JLabel lblTitle = new JLabel("IUT ORSAY");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(UIStyle.PRIMARY_BLUE);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitle = new JLabel("Espace Enseignant");
        lblSubtitle.setFont(UIStyle.FONT_NORMAL);
        lblSubtitle.setForeground(UIStyle.TEXT_GRAY);
        lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Champs
        JTextField txtUser = new JTextField("enseignant@universite-paris-saclay.fr");
        JPasswordField txtPass = new JPasswordField("mot de passe");
        styleField(txtUser);
        styleField(txtPass);

        // Bouton
        JButton btnLogin = UIStyle.createBtn("Se Connecter", UIStyle.PRIMARY_BLUE);
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setMaximumSize(new Dimension(320, 45));
        
        btnLogin.addActionListener(e -> {
            // Simulation de connexion réussie
            new MainDashboardFrame().setVisible(true);
            this.dispose(); // Ferme la fenêtre de login
        });

        mainPanel.add(lblTitle);
        mainPanel.add(lblSubtitle);
        mainPanel.add(Box.createVerticalStrut(40));
        mainPanel.add(new JLabel("Email"));
        mainPanel.add(txtUser);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(new JLabel("Mot de passe"));
        mainPanel.add(txtPass);
        mainPanel.add(Box.createVerticalStrut(40));
        mainPanel.add(btnLogin);
        add(mainPanel);
    }

    private void styleField(JComponent field) {
        field.setMaximumSize(new Dimension(320, 40));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        ((JComponent) field).setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}