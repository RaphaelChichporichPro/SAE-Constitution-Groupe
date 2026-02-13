package frames;

import panels.ConstitutionPanel;
import style.UIStyle;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainDashboardFrame extends JFrame {

    private JPanel contentArea;
    private CardLayout cardLayout;

    public MainDashboardFrame() {
        setTitle("Tableau de Bord - Responsable Pédagogique");
        setSize(1280, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // MENU LATÉRAL 
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(Color.WHITE);
        sidebar.setPreferredSize(new Dimension(250, 0));
        sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY));

        // En-tête Sidebar
        JLabel lblUser = new JLabel("Bienvenue, Enseignant");
        lblUser.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblUser.setBorder(new EmptyBorder(30, 20, 30, 20));
        sidebar.add(lblUser);

        // Boutons de Navigation
        sidebar.add(createNavButton(" Vue d'ensemble (Sondages)", "SONDAGES"));
        sidebar.add(createNavButton(" Liste des Étudiants", "ETUDIANTS"));
        sidebar.add(createNavButton(" Constitution Groupes", "CONSTITUTION")); 
        sidebar.add(Box.createVerticalGlue()); 
        
        JButton btnLogout = createNavButton(" Déconnexion", "LOGOUT");
        btnLogout.setForeground(Color.RED);
        sidebar.add(btnLogout);

        // ZONE DE CONTENU 
        cardLayout = new CardLayout();
        contentArea = new JPanel(cardLayout);
        contentArea.setBackground(UIStyle.BG_COLOR);

        // AJOUT DES PANNEAUX 
        contentArea.add(new panels.SondagePanel(), "SONDAGES");
        contentArea.add(new panels.EtudiantsPanel(), "ETUDIANTS");
        contentArea.add(new panels.ConstitutionPanel(), "CONSTITUTION"); 

        add(sidebar, BorderLayout.WEST);
        add(contentArea, BorderLayout.CENTER);
    }

    private JButton createNavButton(String text, String cardName) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setBackground(Color.WHITE);
        btn.setBorder(new EmptyBorder(15, 20, 15, 20));
        btn.setMaximumSize(new Dimension(250, 50));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Action au clic
        btn.addActionListener(e -> {
            if (cardName.equals("LOGOUT")) {
                new LoginFrame().setVisible(true);
                dispose();
            } else {
                cardLayout.show(contentArea, cardName);
            }
        });
        return btn;
    }
}