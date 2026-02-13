package Etudiant;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class StudentInfoUI extends JFrame {

    // --- Charte Graphique ---
    private static final Color BG_COLOR = new Color(245, 247, 250); // Fond gris clair
    private static final Color CARD_BG = Color.WHITE;
    private static final Color TEXT_DARK = new Color(30, 30, 30);
    private static final Color TEXT_GRAY = new Color(100, 100, 100);
    private static final Color ORANGE_BTN = new Color(255, 100, 0);
    private static final Color BLUE_ACCENT = new Color(0, 120, 255); // Bleu TD/TP
    private static final Color BORDER_COLOR = new Color(230, 230, 230);

    public StudentInfoUI() {
        setTitle("Information de l'étudiant - IUT Orsay");
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

        // 1. Top Bar (Navigation)
        mainContainer.add(createTopBar());

        // 2. Contenu principal
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(BG_COLOR);
        contentPanel.setBorder(new EmptyBorder(30, 40, 30, 40));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 20, 20); // Marges entre les cartes
        gbc.fill = GridBagConstraints.BOTH;

        // --- Titre Page ---
        JLabel pageTitle = new JLabel("Information de l'étudiant");
        pageTitle.setFont(new Font("Arial", Font.BOLD, 28));
        
        GridBagConstraints titleGbc = new GridBagConstraints();
        titleGbc.gridx = 0; titleGbc.gridy = 0; titleGbc.gridwidth = 2;
        titleGbc.anchor = GridBagConstraints.WEST;
        titleGbc.insets = new Insets(0, 0, 20, 0);
        contentPanel.add(pageTitle, titleGbc);

        // --- Carte 1 : Données Personnelles (Gauche, grande hauteur) ---
        gbc.gridx = 0; gbc.gridy = 1; 
        gbc.gridheight = 2; // Prend 2 rangées de hauteur
        gbc.weightx = 0.6;  // Prend 60% de la largeur
        gbc.weighty = 0.0;
        contentPanel.add(createPersonalInfoCard(), gbc);

        // --- Carte 2 : Groupe TD/TP (Droite, Haut) ---
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.4; // Prend 40% de la largeur
        gbc.insets = new Insets(0, 0, 20, 0); // Reset marge droite
        contentPanel.add(createGroupCard(), gbc);

        // --- Carte 3 : Préférences (Droite, Bas) ---
        gbc.gridx = 1; gbc.gridy = 2;
        contentPanel.add(createPreferencesCard(), gbc);

        // --- Carte 4 : Ma Promotion (Bas, Pleine largeur) ---
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2; // Prend toute la largeur
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 0, 20, 0);
        contentPanel.add(createPromotionCard(), gbc);

        // --- Footer Logo ---
        gbc.gridy = 4;
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(BG_COLOR);
        footer.add(new JLabel("<html><span style='color:#800040;'>universite</span> PARIS-SACLAY | IUT D'ORSAY</html>"));
        contentPanel.add(footer, gbc);

        mainContainer.add(contentPanel);
    }

    // --- SECTION 1 : Données Personnelles ---
    private JPanel createPersonalInfoCard() {
        JPanel card = createCard();
        card.setLayout(new BorderLayout());

        JLabel title = new JLabel("Mes Données Personnelles");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBorder(new EmptyBorder(0, 0, 20, 0));
        card.add(title, BorderLayout.NORTH);

        // Formulaire
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(CARD_BG);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 0, 10, 0);

        addInfoRow(formPanel, gbc, 0, "Nom", "Dupont");
        addInfoRow(formPanel, gbc, 1, "Prénom", "Jean");
        addInfoRow(formPanel, gbc, 2, "Numéro Étudiant", "12345678");
        addInfoRow(formPanel, gbc, 3, "Email", "jean.dupont@email.com");
        addInfoRow(formPanel, gbc, 4, "Adresse", "123 Rue de l'Université, 75000 Paris");

        card.add(formPanel, BorderLayout.CENTER);

        // Bouton Signaler erreur
        JButton signalBtn = new JButton("Signaler une erreur");
        signalBtn.setBackground(ORANGE_BTN);
        signalBtn.setForeground(Color.WHITE);
        signalBtn.setFont(new Font("Arial", Font.BOLD, 14));
        signalBtn.setFocusPainted(false);
        signalBtn.setBorder(new EmptyBorder(10, 20, 10, 20));
        signalBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JPanel btnContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnContainer.setBackground(CARD_BG);
        btnContainer.add(signalBtn);
        
        card.add(btnContainer, BorderLayout.SOUTH);

        return card;
    }

    private void addInfoRow(JPanel panel, GridBagConstraints gbc, int row, String label, String value) {
        gbc.gridy = row;
        
        // Label (gris)
        gbc.gridx = 0; gbc.weightx = 0.3;
        JLabel l = new JLabel(label);
        l.setForeground(TEXT_GRAY);
        l.setFont(new Font("Arial", Font.PLAIN, 13));
        panel.add(l, gbc);

        // Valeur (noir)
        gbc.gridx = 1; gbc.weightx = 0.7;
        JLabel v = new JLabel(value);
        v.setForeground(TEXT_DARK);
        v.setFont(new Font("Arial", Font.PLAIN, 13));
        panel.add(v, gbc);

        // Ligne de séparation
        gbc.gridy = row + 1; gbc.gridx = 0; gbc.gridwidth = 2;
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(240, 240, 240));
        gbc.insets = new Insets(15, 0, 15, 0); // Espace autour ligne
        panel.add(sep, gbc);
        
        // Reset insets pour la prochaine ligne
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridwidth = 1;
    }

    // --- SECTION 2 : Groupe TD/TP ---
    private JPanel createGroupCard() {
        JPanel card = createCard();
        card.setLayout(new BorderLayout());

        JLabel title = new JLabel("Mon Groupe de TD/TP");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        card.add(title, BorderLayout.NORTH);

        JLabel groupLabel = new JLabel("TD 3 / TP B", SwingConstants.CENTER);
        groupLabel.setFont(new Font("Arial", Font.BOLD, 40));
        groupLabel.setForeground(BLUE_ACCENT);
        groupLabel.setBorder(new EmptyBorder(30, 0, 30, 0));
        
        card.add(groupLabel, BorderLayout.CENTER);
        return card;
    }

    // --- SECTION 3 : Préférences (Avec Toggles) ---
    private JPanel createPreferencesCard() {
        JPanel card = createCard();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Mes Préférences");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.add(title);
        card.add(Box.createVerticalStrut(20));

        // Toggle 1
        card.add(createToggleRow("Je suis ouvert(e) au covoiturage", true));
        card.add(Box.createVerticalStrut(15));
        
        // Toggle 2
        card.add(createToggleRow("J'accepte de participer aux sondages anonymes", false));

        return card;
    }

    private JPanel createToggleRow(String text, boolean isOn) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(CARD_BG);
        panel.setMaximumSize(new Dimension(2000, 40));

        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 13));
        label.setForeground(TEXT_DARK);

        // Simulation visuelle du Toggle Switch
        JLabel toggle = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (isOn) {
                    g2.setColor(BLUE_ACCENT);
                    g2.fill(new RoundRectangle2D.Double(0, 2, 44, 24, 24, 24)); // Fond Bleu
                    g2.setColor(Color.WHITE);
                    g2.fill(new Ellipse2D.Double(22, 4, 20, 20)); // Rond à droite
                } else {
                    g2.setColor(new Color(220, 220, 220));
                    g2.fill(new RoundRectangle2D.Double(0, 2, 44, 24, 24, 24)); // Fond Gris
                    g2.setColor(Color.WHITE);
                    g2.fill(new Ellipse2D.Double(2, 4, 20, 20)); // Rond à gauche
                }
            }
        };
        toggle.setPreferredSize(new Dimension(46, 30));
        toggle.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.add(label, BorderLayout.CENTER);
        panel.add(toggle, BorderLayout.EAST);
        return panel;
    }

    // --- SECTION 4 : Ma Promotion ---
    private JPanel createPromotionCard() {
        JPanel card = createCard();
        card.setLayout(new BorderLayout());

        JLabel title = new JLabel("Ma Promotion");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBorder(new EmptyBorder(0, 0, 15, 0));
        card.add(title, BorderLayout.NORTH);

        // Barre de recherche
        JTextField searchBar = new JTextField(" Rechercher un étudiant...");
        searchBar.setForeground(Color.GRAY);
        searchBar.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDER_COLOR, 1, true), // Bord arrondi simulé
                new EmptyBorder(8, 10, 8, 10)
        ));
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBackground(CARD_BG);
        searchPanel.setBorder(new EmptyBorder(0, 0, 15, 0));
        searchPanel.add(searchBar, BorderLayout.CENTER);
        card.add(searchPanel, BorderLayout.NORTH); // Astuce: on remplace le titre par un panel titre+search si besoin, ici simple

        // Tableau
        String[] columns = {"Nom", "Prénom", "Genre", "Type de Bac", "Email"};
        Object[][] data = {
                {"Martin", "Léa", "F", "Scientifique", "lea.martin@email.com"},
                {"Bernard", "Thomas", "M", "Économique", "thomas.bernard@email.com"},
                {"Dubois", "Camille", "F", "Littéraire", "camille.dubois@email.com"},
                {"Robert", "Hugo", "M", "Scientifique", "hugo.robert@email.com"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setRowHeight(35);
        table.setShowVerticalLines(false);
        table.setGridColor(new Color(245, 245, 245));
        
        // Header Style
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(245, 247, 250));
        header.setFont(new Font("Arial", Font.BOLD, 12));
        header.setForeground(TEXT_GRAY);
        header.setPreferredSize(new Dimension(0, 35));

        // Ajout du titre et recherche dans un panel nord pour être propre
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(CARD_BG);
        topPanel.add(title, BorderLayout.NORTH);
        topPanel.add(searchPanel, BorderLayout.CENTER);
        card.add(topPanel, BorderLayout.NORTH);

        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.getViewport().setBackground(Color.WHITE);
        tableScroll.setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
        tableScroll.setPreferredSize(new Dimension(0, 200));
        
        card.add(tableScroll, BorderLayout.CENTER);

        // Footer texte
        JLabel footerText = new JLabel("<html><body style='width: 100%'>Pour des raisons de confidentialité, les informations complètes des étudiants ne sont pas toutes affichées. Veuillez respecter la vie privée de vos camarades.</body></html>");
        footerText.setFont(new Font("Arial", Font.PLAIN, 10));
        footerText.setForeground(Color.GRAY);
        footerText.setBorder(new EmptyBorder(10, 0, 0, 0));
        card.add(footerText, BorderLayout.SOUTH);

        return card;
    }

    // --- Helpers Généraux ---
    private JPanel createCard() {
        JPanel card = new JPanel();
        card.setBackground(CARD_BG);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDER_COLOR, 1),
                new EmptyBorder(25, 25, 25, 25)
        ));
        return card;
    }

    private JPanel createTopBar() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BG_COLOR);
        panel.setBorder(new EmptyBorder(20, 30, 0, 30));
        panel.setMaximumSize(new Dimension(2000, 60));

        // Gauche : Navigation Tabs
        JPanel leftNav = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        leftNav.setBackground(BG_COLOR);
        
        JLabel tab1 = new JLabel("Tableau de Bord"); // Inactif
        tab1.setOpaque(true);
        tab1.setBackground(new Color(220, 230, 245));
        tab1.setFont(new Font("Arial", Font.BOLD, 13));
        tab1.setForeground(new Color(0, 80, 160));
        tab1.setBorder(new EmptyBorder(8, 15, 8, 15));

        JLabel tab2 = new JLabel("Sondages"); // Inactif
        tab2.setOpaque(true);
        tab2.setBackground(new Color(220, 230, 245));
        tab2.setFont(new Font("Arial", Font.BOLD, 13));
        tab2.setForeground(new Color(0, 80, 160));
        tab2.setBorder(new EmptyBorder(8, 15, 8, 15));

        leftNav.add(tab1);
        leftNav.add(tab2);

        // Droite : User
        JPanel rightNav = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 5));
        rightNav.setBackground(BG_COLOR);
        
        JLabel bell = new JLabel("\uD83D\uDD14");
        bell.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        
        JLabel avatar = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(245, 200, 150));
                g2.fill(new Ellipse2D.Double(0, 0, 30, 30));
                g2.setColor(new Color(60, 40, 30)); 
                g2.fill(new Ellipse2D.Double(0, 0, 30, 10)); 
            }
        };
        avatar.setPreferredSize(new Dimension(30, 30));

        rightNav.add(bell);
        rightNav.add(avatar);
        rightNav.add(new JLabel("Emploi du temps"));
        rightNav.add(new JLabel("Notes"));

        panel.add(leftNav, BorderLayout.WEST);
        panel.add(rightNav, BorderLayout.EAST);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentInfoUI().setVisible(true);
        });
    }
}