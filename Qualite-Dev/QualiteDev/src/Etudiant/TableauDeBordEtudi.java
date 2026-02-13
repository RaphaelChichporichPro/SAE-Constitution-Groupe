package Etudiant;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TableauDeBordEtudi extends JPanel {

    private MainFrame mainFrame;

    // Couleurs extraites de ta maquette
    private final Color SIDEBAR_BG = new Color(240, 248, 255); // Bleu très pâle
    private final Color ACTIVE_MENU_BG = new Color(220, 235, 250);
    private final Color BUTTON_BLUE = new Color(65, 125, 225); // Bleu "Se déconnecter"
    private final Color TEXT_GREY = new Color(100, 100, 100);

    public TableauDeBordEtudi(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        // --- 1. SIDEBAR (GAUCHE) ---
        add(createSidebar(), BorderLayout.WEST);

        // --- 2. CONTENU PRINCIPAL (DROITE) ---
        add(createMainContent(), BorderLayout.CENTER);
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(SIDEBAR_BG);
        sidebar.setPreferredSize(new Dimension(250, 0));
        sidebar.setBorder(new EmptyBorder(20, 20, 20, 20));

        // -- Profil --
        JPanel profilePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        profilePanel.setBackground(SIDEBAR_BG);
        profilePanel.setMaximumSize(new Dimension(250, 80));
        
        // Simulation Avatar (Rond coloré)
        JLabel avatar = new JLabel("  MD  ");
        avatar.setOpaque(true);
        avatar.setBackground(new Color(139, 69, 19)); // Marron (comme l'image)
        avatar.setForeground(Color.WHITE);
        avatar.setFont(new Font("Arial", Font.BOLD, 16));
        avatar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        
        JLabel nameLabel = new JLabel("<html><b>M. Dupont</b><br><span style='font-size:10px; color:grey;'>Etudiant 1ère Année</span></html>");
        nameLabel.setBorder(new EmptyBorder(0, 10, 0, 0));

        profilePanel.add(avatar);
        profilePanel.add(nameLabel);
        sidebar.add(profilePanel);
        sidebar.add(Box.createVerticalStrut(30));

        // -- Menu --
        sidebar.add(createMenuItem("Tableau de Bord", true));
        sidebar.add(createSubMenuItem("Liste de Classes"));
        sidebar.add(createSubMenuItem("TD/TP Groupes"));
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(createMenuItem("Sondages", false));
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(createMenuItem("Information de l'étudiant", false)); // Correction ici pour éviter le caractère spécial dans le nom de variable

        // -- Espace vide pour pousser le bouton en bas --
        sidebar.add(Box.createVerticalGlue());

        // -- Bouton Déconnexion --
        JButton logoutBtn = new JButton("Se déconnecter");
        logoutBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        logoutBtn.setMaximumSize(new Dimension(200, 40));
        logoutBtn.setBackground(BUTTON_BLUE);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Action pour revenir au Login
        
        sidebar.add(logoutBtn);

        return sidebar;
    }

    private JPanel createMainContent() {
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.WHITE);
        content.setBorder(new EmptyBorder(20, 30, 20, 30));

        // -- Header (Titre + Recherche) --
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        JLabel title = new JLabel("Tableau de Bord");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        
        JTextField search = new JTextField("Rechercher un étudiant");
        search.setPreferredSize(new Dimension(200, 30));
        
        header.add(title, BorderLayout.WEST);
        header.add(search, BorderLayout.EAST);
        content.add(header, BorderLayout.NORTH);

        // -- Corps (Scrollable) --
        JPanel body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.setBackground(Color.WHITE);

        // Section 1 : Informations Pédagogiques (Tableau principal)
        body.add(Box.createVerticalStrut(20));
        body.add(createSectionTitle("Informations Pédagogiques des Étudiants"));
        body.add(Box.createVerticalStrut(10));
        body.add(createMainTable());

        // Section 2 : Split (Liste Promo vs Groupes)
        body.add(Box.createVerticalStrut(30));
        JPanel splitSection = new JPanel(new GridLayout(1, 2, 20, 0)); // Grille 2 colonnes
        splitSection.setBackground(Color.WHITE);
        splitSection.setPreferredSize(new Dimension(800, 250)); // Force la hauteur

        // Gauche
        splitSection.add(createSubSection("Liste de la Promotion", createPromoTable()));
        // Droite
        splitSection.add(createSubSection("Groupes de TD/TP", createGroupList()));

        body.add(splitSection);
        
        // Footer Logo
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(Color.WHITE);
        JLabel logo = new JLabel("université PARIS-SACLAY | IUT D'ORSAY");
        logo.setForeground(new Color(150, 50, 80));
        footer.add(logo);
        body.add(footer);

        content.add(new JScrollPane(body), BorderLayout.CENTER);
        return content;
    }

    // --- Composants Helpers ---

    private JComponent createMainTable() {
        String[] cols = {"N° ÉTUDIANT", "NOM", "PRÉNOM", "GENRE", "EMAIL UNIVERSITAIRE", "TYPE DE BAC", "REDOUBLEMENTS"};
        Object[][] data = {
            {"22001234", "Martin", "Alice", "F", "alice.martin@univ.fr", "Scientifique", "0"},
            {"22005678", "Bernard", "Lucas", "M", "lucas.bernard@univ.fr", "Littéraire", "1"},
            {"22009012", "Dubois", "Chloé", "F", "chloe.dubois@univ.fr", "Économique et Social", "0"},
            {"22003456", "Robert", "Thomas", "M", "thomas.robert@univ.fr", "Scientifique", "0"}
        };
        return styleTable(new JTable(new DefaultTableModel(data, cols)));
    }

    private JComponent createPromoTable() {
        String[] cols = {"Nom, Prénom", "N°"};
        Object[][] data = {
            {"Martin, Alice", "22001234"},
            {"Bernard, Lucas", "22005678"},
            {"Dubois, Chloé", "22009012"},
            {"Robert, Thomas", "22003456"},
            {"Petit, Léa", "22007890"}
        };
        return styleTable(new JTable(new DefaultTableModel(data, cols)));
    }

    private JComponent createGroupList() {
        String[] data = {"TD Groupe 1", "TD Groupe 2", "TP Groupe A", "TP Groupe B", "TP Groupe C"};
        JList<String> list = new JList<>(data);
        list.setFixedCellHeight(35);
        list.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return new JScrollPane(list);
    }

    private JPanel createSubSection(String title, JComponent component) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(Color.WHITE);
        p.add(createSectionTitle(title), BorderLayout.NORTH);
        p.add(component, BorderLayout.CENTER);
        return p;
    }

    private JLabel createSectionTitle(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setBorder(new EmptyBorder(0, 0, 10, 0));
        return label;
    }

    // Design des Boutons du Menu (Onglets bleus)
    private JPanel createMenuItem(String text, boolean isActive) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setMaximumSize(new Dimension(250, 40));
        p.setBackground(isActive ? ACTIVE_MENU_BG : SIDEBAR_BG);
        if (isActive) {
            p.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0, BUTTON_BLUE)); // Barre bleue à gauche
        }
        
        JLabel l = new JLabel(text);
        l.setForeground(isActive ? BUTTON_BLUE : TEXT_GREY);
        l.setFont(new Font("Arial", isActive ? Font.BOLD : Font.PLAIN, 14));
        
        p.add(l);
        return p;
    }

    private JPanel createSubMenuItem(String text) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setMaximumSize(new Dimension(250, 30));
        p.setBackground(SIDEBAR_BG);
        
        JLabel l = new JLabel(text);
        l.setForeground(TEXT_GREY);
        l.setFont(new Font("Arial", Font.PLAIN, 12));
        l.setBorder(new EmptyBorder(0, 20, 0, 0)); // Indentation
        
        p.add(l);
        return p;
    }

    // Style "Web" pour les tableaux (En-tête gris clair, pas de grille verticale)
    private JScrollPane styleTable(JTable table) {
        table.setRowHeight(30);
        table.setShowVerticalLines(false);
        table.setGridColor(new Color(230, 230, 230));
        
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(245, 245, 245));
        header.setFont(new Font("Arial", Font.BOLD, 10));
        header.setForeground(TEXT_GREY);
        
        // Centrer les données optionnel
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setBorder(new EmptyBorder(0, 10, 0, 0));
        table.setDefaultRenderer(Object.class, centerRenderer);

        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
        return scroll;
    }
}