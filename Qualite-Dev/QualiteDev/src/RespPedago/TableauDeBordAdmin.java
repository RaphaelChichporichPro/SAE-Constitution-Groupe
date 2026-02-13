package RespPedago;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableauDeBordAdmin extends JFrame {

    // --- Couleurs de la maquette ---
    private static final Color BG_COLOR = new Color(245, 247, 250); // Fond gris clair
    private static final Color CARD_BG = Color.WHITE;
    private static final Color BTN_BLUE = new Color(13, 100, 220);  // Bleu boutons principaux
    private static final Color BTN_GREEN = new Color(30, 200, 90);  // Vert "Rendre public"
    private static final Color BTN_GRAY_LIGHT = new Color(240, 242, 245); // Fond boutons gris
    private static final Color TEXT_DARK = new Color(30, 30, 30);
    private static final Color LINK_EDIT = new Color(0, 120, 230); // Bleu "Modifier"
    private static final Color LINK_DELETE = new Color(230, 50, 50); // Rouge "Supprimer"

    public TableauDeBordAdmin() {
        setTitle("Tableau de bord - Responsable Pédagogique");
        setSize(1400, 950);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Scroll global
        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
        mainContainer.setBackground(BG_COLOR);

        JScrollPane scrollPane = new JScrollPane(mainContainer);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);

        // 1. Header
        mainContainer.add(createHeader());

        // 2. Contenu (Grille)
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(BG_COLOR);
        contentPanel.setBorder(new EmptyBorder(30, 40, 30, 40));
        mainContainer.add(contentPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 20, 20);
        gbc.fill = GridBagConstraints.BOTH;

        // --- SECTION 1 : Gestion des Étudiants (Haut Gauche - Large) ---
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.weightx = 0.65; gbc.weighty = 0;
        contentPanel.add(createStudentManagementCard(), gbc);

        // --- SECTION 2 : Import/Export (Haut Droite - Étroit) ---
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.weightx = 0.35;
        gbc.insets = new Insets(0, 0, 20, 0); // Pas de marge à droite
        contentPanel.add(createImportExportCard(), gbc);

        // --- SECTION 3 : Constitution des Groupes (Milieu Gauche) ---
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0.65;
        gbc.insets = new Insets(0, 0, 20, 20);
        contentPanel.add(createGroupConfigCard(), gbc);

        // --- SECTION 4 : Sondages (Milieu Droite) ---
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.weightx = 0.35;
        gbc.gridheight = 2; // Prend de la hauteur (s'étend vers le bas)
        gbc.insets = new Insets(0, 0, 20, 0);
        contentPanel.add(createPollsCard(), gbc);

        // --- SECTION 5 : Consultation des Groupes (Bas Gauche) ---
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.weightx = 0.65;
        gbc.insets = new Insets(0, 0, 20, 20);
        contentPanel.add(createGroupListCard(), gbc);
    }

    // --- HEADER ---
    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        header.setBorder(new EmptyBorder(15, 30, 15, 30));
        header.setMaximumSize(new Dimension(3000, 80));

        // Logo + Titre
        JLabel logoText = new JLabel("<html><span style='color:#800040; font-size:14px;'>universite</span> PARIS-SACLAY | <span style='color:#800040;'>IUT D'ORSAY</span></html>");
        
        JLabel title = new JLabel("Tableau de bord - Responsable Pédagogique");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(new EmptyBorder(0, 30, 0, 0));

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.add(logoText);
        leftPanel.add(title);

        // Bouton Déconnexion
        JButton logoutBtn = new JButton("Déconnexion");
        logoutBtn.setBackground(new Color(10, 80, 160));
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setFont(new Font("Arial", Font.BOLD, 12));
        logoutBtn.setBorder(new EmptyBorder(10, 20, 10, 20));

        header.add(leftPanel, BorderLayout.WEST);
        header.add(logoutBtn, BorderLayout.EAST);

        return header;
    }

    // --- CARD 1 : Gestion des Étudiants ---
    private JPanel createStudentManagementCard() {
        JPanel card = createCard("Gestion des Étudiants");
        
        // Tableau
        String[] columns = {"Nom", "Prénom", "Identifiant", "Actions"};
        Object[][] data = {
            {"Dupont", "Jean", "E12345", "Modifier Supprimer"},
            {"Martin", "Marie", "E12346", "Modifier Supprimer"},
            {"Durand", "Pierre", "E12347", "Modifier Supprimer"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model) {
            // Rendu HTML pour la colonne Actions (Bleu/Rouge)
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (column == 3 && c instanceof JLabel) {
                    JLabel l = (JLabel) c;
                    l.setText("<html><font color='#0078D7'><b>Modifier</b></font> &nbsp;&nbsp; <font color='#E63232'><b>Supprimer</b></font></html>");
                    l.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                return c;
            }
        };
        styleTable(table);

        JScrollPane sp = new JScrollPane(table);
        sp.setBorder(new LineBorder(new Color(230, 230, 230)));
        sp.setPreferredSize(new Dimension(0, 180));
        sp.getViewport().setBackground(Color.WHITE);

        card.add(sp);

        // Bouton Ajouter
        JButton addBtn = new JButton("+  Ajouter un étudiant");
        addBtn.setBackground(BTN_BLUE);
        addBtn.setForeground(Color.WHITE);
        addBtn.setFont(new Font("Arial", Font.BOLD, 13));
        addBtn.setFocusPainted(false);
        addBtn.setBorder(new EmptyBorder(10, 15, 10, 15));
        
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnPanel.setBackground(CARD_BG);
        btnPanel.setBorder(new EmptyBorder(15, 0, 0, 0));
        btnPanel.add(addBtn);

        card.add(btnPanel);
        return card;
    }

    // --- CARD 2 : Import/Export ---
    private JPanel createImportExportCard() {
        JPanel card = createCard("Import/Export de Données");
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        card.add(createWideButton("\u2913  Exporter les données étudiants (CSV)")); // Icon Download
        card.add(Box.createVerticalStrut(10));
        card.add(createWideButton("\u21E7  Importer les notes (CSV)")); // Icon Upload
        card.add(Box.createVerticalStrut(10));
        card.add(createWideButton("\u2630  Consulter/Modifier les notes")); // Icon List

        return card;
    }

    // --- CARD 3 : Constitution des Groupes ---
    private JPanel createGroupConfigCard() {
        JPanel card = createCard("Constitution des Groupes");
        JPanel content = new JPanel(new GridLayout(2, 2, 20, 15)); // 2 lignes, 2 cols
        content.setBackground(CARD_BG);

        // Btn Vert
        JButton btnPublic = createStyledButton("\uD83D\uDC41 Rendre les Groupes Publics", BTN_GREEN, Color.WHITE);
        
        // Btn Bleu 1
        JButton btnManuel = createStyledButton("\u270E Constitution Manuelle", BTN_BLUE, Color.WHITE);

        // Btn Gris
        JButton btnExport = createStyledButton("\u2913 Exporter la Promotion (CSV)", BTN_GRAY_LIGHT, TEXT_DARK);

        // Btn Bleu 2
        JButton btnAuto = createStyledButton("\u2699 Constitution Automatique", BTN_BLUE, Color.WHITE);

        content.add(btnPublic);
        content.add(btnManuel);
        content.add(btnExport);
        content.add(btnAuto);

        card.add(content);
        return card;
    }

    // --- CARD 4 : Sondages ---
    private JPanel createPollsCard() {
        JPanel card = createCard("Sondages");
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        // Grand Bouton Bleu
        JButton createPollBtn = new JButton("Mettre en place le sondage");
        //createPollBtn.setIcon(new IconUIResource(new ImageIcon())); // Dummy icon place
        createPollBtn.setBackground(BTN_BLUE);
        createPollBtn.setForeground(Color.WHITE);
        createPollBtn.setFont(new Font("Arial", Font.BOLD, 14));
        createPollBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        createPollBtn.setMaximumSize(new Dimension(300, 50));
        createPollBtn.setFocusPainted(false);
        
        // Grand Bouton Gris
        JButton resultsBtn = new JButton("Accéder aux résultats des sondages");
        resultsBtn.setBackground(BTN_GRAY_LIGHT);
        resultsBtn.setForeground(TEXT_DARK);
        resultsBtn.setFont(new Font("Arial", Font.BOLD, 14));
        resultsBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultsBtn.setMaximumSize(new Dimension(300, 50));
        resultsBtn.setFocusPainted(false);
        resultsBtn.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        card.add(Box.createVerticalStrut(20));
        card.add(createPollBtn);
        card.add(Box.createVerticalStrut(20));
        card.add(resultsBtn);
        card.add(Box.createVerticalGlue());

        return card;
    }

    // --- CARD 5 : Consultation Groupes ---
    private JPanel createGroupListCard() {
        JPanel card = createCard("Consultation des Groupes");
        JPanel list = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        list.setBackground(CARD_BG);

        list.add(createGroupItem("Groupe 1", "5 membres"));
        list.add(createGroupItem("Groupe 2", "4 membres"));
        list.add(createGroupItem("Groupe 3", "5 membres"));

        card.add(list);
        return card;
    }

    // --- Helpers UI ---

    private JPanel createCard(String titleText) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(CARD_BG);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(230, 230, 230), 1), // Bordure fine
            new EmptyBorder(25, 30, 25, 30) // Padding interne
        ));

        // Titre de la carte
        if (titleText != null) {
            JLabel title = new JLabel(titleText);
            title.setFont(new Font("Arial", Font.BOLD, 18));
            title.setForeground(TEXT_DARK);
            title.setAlignmentX(Component.LEFT_ALIGNMENT);
            card.add(title);
            card.add(Box.createVerticalStrut(20)); // Espace sous titre
        }
        return card;
    }

    private void styleTable(JTable table) {
        table.setRowHeight(50); // Lignes hautes
        table.setShowVerticalLines(false);
        table.setGridColor(new Color(240, 240, 240));
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(248, 249, 250));
        header.setFont(new Font("Arial", Font.BOLD, 12));
        header.setForeground(Color.GRAY);
        header.setPreferredSize(new Dimension(0, 40));
    }

    private JButton createWideButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(BTN_GRAY_LIGHT);
        btn.setForeground(TEXT_DARK);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(12, 0, 12, 0));
        btn.setMaximumSize(new Dimension(2000, 45));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private JButton createStyledButton(String text, Color bg, Color fg) {
        JButton btn = new JButton(text);
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding bouton
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private JPanel createGroupItem(String title, String subtitle) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(new Color(248, 250, 252)); // Gris très très clair
        p.setBorder(new LineBorder(new Color(230, 230, 230), 1));
        p.setPreferredSize(new Dimension(150, 80));
        
        JLabel t = new JLabel(title, SwingConstants.LEFT);
        t.setFont(new Font("Arial", Font.BOLD, 14));
        t.setBorder(new EmptyBorder(15, 15, 0, 0));
        
        JLabel s = new JLabel(subtitle, SwingConstants.LEFT);
        s.setFont(new Font("Arial", Font.PLAIN, 12));
        s.setForeground(Color.GRAY);
        s.setBorder(new EmptyBorder(5, 15, 15, 0));

        p.add(t, BorderLayout.NORTH);
        p.add(s, BorderLayout.CENTER);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TableauDeBordAdmin().setVisible(true);
        });
    }
}