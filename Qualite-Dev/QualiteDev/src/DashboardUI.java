import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class DashboardUI extends JFrame {

    // --- Charte Graphique ---
    private static final Color BG_COLOR = new Color(245, 247, 250); // Fond gris clair global
    private static final Color SIDEBAR_BG = Color.WHITE;            // Fond sidebar
    private static final Color ACTIVE_MENU_BG = new Color(225, 240, 255); // Bleu clair menu actif
    private static final Color ACTIVE_MENU_TEXT = new Color(0, 102, 204); // Bleu texte actif
    private static final Color BTN_LOGOUT = new Color(60, 130, 240); // Bleu bouton déconnexion
    private static final Color TEXT_DARK = new Color(40, 40, 40);
    private static final Color BORDER_COLOR = new Color(230, 230, 230);

    public DashboardUI() {
        setTitle("Tableau de Bord - Étudiant");
        setSize(1400, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Layout principal : Sidebar à gauche, Contenu au centre
        setLayout(new BorderLayout());

        // 1. Sidebar (Gauche)
        add(createSidebar(), BorderLayout.WEST);

        // 2. Contenu Principal (Centre + Scroll)
        JPanel contentPanel = createContentPanel();
        
        // On met le contenu dans un JScrollPane car la page peut être longue
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Scroll plus fluide
        add(scrollPane, BorderLayout.CENTER);
    }

    // --- ZONE 1 : SIDEBAR ---
    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(SIDEBAR_BG);
        sidebar.setPreferredSize(new Dimension(280, getHeight()));
        sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, BORDER_COLOR));

        // -- Profil --
        JPanel profilePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 20));
        profilePanel.setBackground(SIDEBAR_BG);
        
        // Avatar (Cercle simulé)
        JLabel avatarLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(150, 100, 80)); // Couleur avatar simulée
                g2.fill(new Ellipse2D.Double(0, 0, 40, 40));
                super.paintComponent(g);
            }
        };
        avatarLabel.setPreferredSize(new Dimension(40, 40));
        
        // Infos Nom/Rôle
        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setBackground(SIDEBAR_BG);
        JLabel nameLabel = new JLabel("M. Dupont");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel roleLabel = new JLabel("Etudiant 1ère Année");
        roleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        roleLabel.setForeground(Color.GRAY);
        textPanel.add(nameLabel);
        textPanel.add(roleLabel);

        profilePanel.add(avatarLabel);
        profilePanel.add(textPanel);
        sidebar.add(profilePanel);

        sidebar.add(Box.createVerticalStrut(20));

        // -- Menu Items --
        sidebar.add(createMenuItem("Tableau de Bord", true));
        // Sous-items (simples labels avec padding)
        sidebar.add(createSubMenuItem("Liste de Classes"));
        sidebar.add(createSubMenuItem("TD/TP Groupes"));
        
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(createMenuItem("Sondages", false));
        
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(createMenuItem("Information de l'étudiant", false)); // Le 'l' minuscule est intentionnel pour gérer la longueur

        // Espace flexible pour pousser le bouton déconnexion en bas
        sidebar.add(Box.createVerticalGlue());

        // -- Bouton Déconnexion --
        JButton logoutBtn = new JButton("Se déconnecter");
        logoutBtn.setBackground(BTN_LOGOUT);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFont(new Font("Arial", Font.BOLD, 14));
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorder(new EmptyBorder(10, 0, 10, 0));
        logoutBtn.setMaximumSize(new Dimension(240, 45));
        logoutBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        sidebar.add(logoutBtn);
        sidebar.add(Box.createVerticalStrut(30)); // Marge bas

        return sidebar;
    }

    private JPanel createMenuItem(String text, boolean active) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setMaximumSize(new Dimension(280, 50));
        panel.setBackground(active ? ACTIVE_MENU_BG : SIDEBAR_BG);
        
        // Bordure bleue à gauche si actif
        if (active) {
            panel.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, ACTIVE_MENU_TEXT));
        } else {
            panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        }

        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", active ? Font.BOLD : Font.PLAIN, 15));
        label.setForeground(active ? ACTIVE_MENU_TEXT : TEXT_DARK);
        label.setBorder(new EmptyBorder(12, 20, 12, 10)); // Padding texte

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    private JLabel createSubMenuItem(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(Color.DARK_GRAY);
        label.setBorder(new EmptyBorder(5, 45, 5, 0)); // Indentation
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Wrapper pour l'alignement dans le BoxLayout
        // Note: En Swing simple, aligner des JLabels dans un BoxLayout peut être délicat, 
        // ici on l'ajoute directement au panel parent.
        return label;
    }

    // --- ZONE 2 : CONTENU PRINCIPAL ---
    private JPanel createContentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(BG_COLOR);
        panel.setBorder(new EmptyBorder(30, 40, 30, 40)); // Marge globale contenu

        // 1. Header (Titre + Recherche)
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(BG_COLOR);
        header.setMaximumSize(new Dimension(2000, 50));
        
        JLabel title = new JLabel("Tableau de Bord");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        
        JTextField searchBar = new JTextField("Rechercher un étudiant");
        searchBar.setPreferredSize(new Dimension(250, 35));
        searchBar.setForeground(Color.GRAY);
        searchBar.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(Color.LIGHT_GRAY, 1),
            new EmptyBorder(0, 10, 0, 0)
        ));

        header.add(title, BorderLayout.WEST);
        header.add(searchBar, BorderLayout.EAST);
        
        panel.add(header);
        panel.add(Box.createVerticalStrut(30));

        // 2. Titre Section "Informations Pédagogiques..."
        JLabel sectionTitle = new JLabel("Informations Pédagogiques des Étudiants");
        sectionTitle.setFont(new Font("Arial", Font.BOLD, 18));
        sectionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(sectionTitle);
        panel.add(Box.createVerticalStrut(15));

        // 3. Le Tableau (JTable)
        panel.add(createStudentTable());
        panel.add(Box.createVerticalStrut(40));

        // 4. Section Basse (2 Colonnes : Liste Promo & Groupes)
        JPanel bottomSection = new JPanel(new GridLayout(1, 2, 40, 0)); // Grid 1 ligne, 2 cols, espace 40px
        bottomSection.setBackground(BG_COLOR);
        bottomSection.setMaximumSize(new Dimension(2000, 300));
        bottomSection.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Colonne Gauche
        bottomSection.add(createListSection("Liste de la Promotion", new String[][] {
            {"Martin, Alice", "22001234"},
            {"Bernard, Lucas", "22005678"},
            {"Dubois, Chloé", "22009012"},
            {"Robert, Thomas", "22003456"},
            {"Petit, Léa", "22007890"}
        }, true));

        // Colonne Droite
        bottomSection.add(createListSection("Groupes de TD/TP", new String[][] {
            {"TD Groupe 1", ""},
            {"TD Groupe 2", ""},
            {"TP Groupe A", ""},
            {"TP Groupe B", ""},
            {"TP Groupe C", ""}
        }, false));

        panel.add(bottomSection);
        
        // 5. Footer Logo
        panel.add(Box.createVerticalStrut(30));
        JLabel logoFooter = new JLabel("<html><span style='color:#800040;'>universite</span> PARIS-SACLAY | IUT D'ORSAY</html>");
        logoFooter.setAlignmentX(Component.RIGHT_ALIGNMENT); // Alignement à droite ne marche pas toujours bien en box layout sans wrapper
        
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footerPanel.setBackground(BG_COLOR);
        footerPanel.setMaximumSize(new Dimension(2000, 40));
        footerPanel.add(logoFooter);
        panel.add(footerPanel);

        return panel;
    }

    private JScrollPane createStudentTable() {
        String[] columns = {"N° ÉTUDIANT", "NOM", "PRÉNOM", "GENRE", "EMAIL UNIVERSITAIRE", "TYPE DE BAC", "REDOUBLEMENTS"};
        Object[][] data = {
            {"22001234", "Martin", "Alice", "F", "alice.martin@univ.fr", "Scientifique", "0"},
            {"22005678", "Bernard", "Lucas", "M", "lucas.bernard@univ.fr", "Littéraire", "1"},
            {"22009012", "Dubois", "Chloé", "F", "chloe.dubois@univ.fr", "Économique et Social", "0"},
            {"22003456", "Robert", "Thomas", "M", "thomas.robert@univ.fr", "Scientifique", "0"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        
        // Style Table
        table.setRowHeight(40);
        table.setShowVerticalLines(false);
        table.setGridColor(new Color(240, 240, 240));
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        
        // Style Header
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(245, 247, 250)); // Gris très clair
        header.setFont(new Font("Arial", Font.BOLD, 11));
        header.setForeground(Color.GRAY);
        header.setPreferredSize(new Dimension(0, 40));
        
        // Fond blanc pour les lignes
        table.setBackground(Color.WHITE);

        // ScrollPane style blanc
        JScrollPane sp = new JScrollPane(table);
        sp.getViewport().setBackground(Color.WHITE); // Fond blanc derrière la table
        sp.setBorder(BorderFactory.createEmptyBorder()); // Pas de bordure moche
        sp.setPreferredSize(new Dimension(1000, 200)); // Hauteur table
        
        return sp;
    }

    private JPanel createListSection(String titleStr, String[][] data, boolean showId) {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(BG_COLOR);

        // Titre
        JLabel title = new JLabel(titleStr);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        container.add(title);
        container.add(Box.createVerticalStrut(15));

        // Liste des items (Cartes blanches)
        for (String[] rowData : data) {
            JPanel card = new JPanel(new BorderLayout());
            card.setBackground(Color.WHITE);
            card.setMaximumSize(new Dimension(2000, 50));
            card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(230, 230, 230), 1),
                new EmptyBorder(10, 15, 10, 15)
            ));

            JLabel leftText = new JLabel(rowData[0]);
            leftText.setFont(new Font("Arial", Font.BOLD, 13));
            
            card.add(leftText, BorderLayout.WEST);

            if (showId && !rowData[1].isEmpty()) {
                JLabel rightText = new JLabel(rowData[1]);
                rightText.setForeground(Color.GRAY);
                card.add(rightText, BorderLayout.EAST);
            }

            container.add(card);
            // Petit espace entre les lignes pour simuler le style "liste séparée"
            // (Sur l'image c'est collé, donc on peut commenter cette ligne si on veut que ce soit collé)
            // container.add(Box.createVerticalStrut(2)); 
        }

        return container;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DashboardUI().setVisible(true);
        });
    }
}