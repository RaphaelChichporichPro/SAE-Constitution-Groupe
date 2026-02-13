package RespPedago;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class SondagesUI extends JFrame {

    // --- Charte Graphique ---
    private static final Color BG_COLOR = new Color(245, 247, 250); // Fond gris clair
    private static final Color CARD_BG = Color.WHITE;
    private static final Color TEXT_DARK = new Color(30, 30, 30);
    private static final Color TEXT_GRAY = new Color(100, 100, 100);
    
    // Couleurs spécifiques Sondages
    private static final Color STATUS_OPEN_BG = new Color(220, 255, 220); // Vert clair
    private static final Color STATUS_OPEN_FG = new Color(0, 120, 0);     // Vert foncé
    private static final Color STATUS_CLOSED_BG = new Color(255, 230, 230); // Rouge clair
    private static final Color STATUS_CLOSED_FG = new Color(200, 50, 50);   // Rouge foncé
    private static final Color LINK_BLUE = new Color(0, 102, 204);
    
    // Couleurs Boutons Vote
    private static final Color VOTE_BTN_BG = new Color(210, 245, 225); // Vert pastel menthe
    private static final Color VOTE_BTN_TEXT = new Color(0, 100, 50);

    public SondagesUI() {
        setTitle("Sondages - IUT Orsay");
        setSize(1400, 950);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout principal avec Scroll
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(BG_COLOR);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);

        // --- 1. Top Bar (Navigation) ---
        mainPanel.add(createTopBar());

        // --- Conteneur du contenu central ---
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(BG_COLOR);
        contentPanel.setBorder(new EmptyBorder(30, 60, 30, 60)); // Marges latérales
        mainPanel.add(contentPanel);

        // --- 2. En-tête de la page ---
        JLabel title = new JLabel("Sondages");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(title);

        JLabel subtitle = new JLabel("Répondre aux sondages en cours.");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(TEXT_GRAY);
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(subtitle);
        
        contentPanel.add(Box.createVerticalStrut(30));

        // --- 3. Tableau des Sondages ---
        contentPanel.add(createPollsTable());
        contentPanel.add(Box.createVerticalStrut(40));

        // --- 4. Section Détail Vote ---
        contentPanel.add(createVoteSection());
        contentPanel.add(Box.createVerticalStrut(30));

        // --- 5. Footer ---
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(BG_COLOR);
        footer.setMaximumSize(new Dimension(2000, 60));
        footer.add(new JLabel("<html><span style='color:#800040;'>universite</span> PARIS-SACLAY | IUT D'ORSAY</html>"));
        contentPanel.add(footer);
    }

    // --- Composant : Top Bar ---
    private JPanel createTopBar() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BG_COLOR);
        panel.setBorder(new EmptyBorder(20, 30, 0, 30));
        panel.setMaximumSize(new Dimension(2000, 60));

        // Gauche : Boutons de navigation (Style "Pill")
        JPanel leftNav = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        leftNav.setBackground(BG_COLOR);
        leftNav.add(createNavPill("Tableau de Bord", new Color(200, 220, 240))); // Bleu clair
        leftNav.add(createNavPill("Information de l'étudiant", new Color(200, 220, 240)));
        
        // Droite : Profil et Liens
        JPanel rightNav = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 5));
        rightNav.setBackground(BG_COLOR);
        
        // Cloche
        JLabel bell = new JLabel("\uD83D\uDD14"); // Bell Unicode
        bell.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        
        // Avatar
        JLabel avatar = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(245, 200, 150)); // Peau
                g2.fill(new Ellipse2D.Double(0, 0, 30, 30));
                // Cheveux
                g2.setColor(new Color(60, 40, 30)); 
                g2.fill(new Ellipse2D.Double(0, 0, 30, 10)); 
            }
        };
        avatar.setPreferredSize(new Dimension(30, 30));

        JLabel link1 = new JLabel("Emploi du temps");
        link1.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel link2 = new JLabel("Notes");
        link2.setFont(new Font("Arial", Font.PLAIN, 12));

        rightNav.add(bell);
        rightNav.add(avatar);
        rightNav.add(link1);
        rightNav.add(link2);

        panel.add(leftNav, BorderLayout.WEST);
        panel.add(rightNav, BorderLayout.EAST);
        return panel;
    }

    private JLabel createNavPill(String text, Color bg) {
        JLabel label = new JLabel(text);
        label.setOpaque(true);
        label.setBackground(bg);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(new Color(0, 50, 100));
        label.setBorder(new EmptyBorder(8, 15, 8, 15));
        return label;
    }

    // --- Composant : Tableau des Sondages (Simulé avec Panels) ---
    private JPanel createPollsTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(new LineBorder(new Color(230, 230, 230), 1));
        tablePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Header du tableau
        JPanel header = createTableRow("Titre du sondage", "Date de création", "Statut", "Action", true);
        tablePanel.add(header);

        // Lignes de données
        tablePanel.add(createTableRow("Sondage sur les préférences de cours", "12/03/2023", "Ouvert", "Répondre", false));
        tablePanel.add(createJSeparator());
        tablePanel.add(createTableRow("Feedback sur le TP de programmation", "25/02/2023", "Ouvert", "Répondre", false));
        tablePanel.add(createJSeparator());
        tablePanel.add(createTableRow("Disponibilités pour la session de révision", "15/01/2023", "Fermé", "", false));

        return tablePanel;
    }

    private JPanel createTableRow(String col1, String col2, String status, String action, boolean isHeader) {
        JPanel row = new JPanel(new GridLayout(1, 4));
        row.setBackground(Color.WHITE);
        row.setMaximumSize(new Dimension(2000, 50));
        row.setBorder(new EmptyBorder(15, 20, 15, 20));

        Font font = isHeader ? new Font("Arial", Font.BOLD, 12) : new Font("Arial", Font.PLAIN, 13);
        Color textColor = isHeader ? TEXT_DARK : new Color(60, 60, 60);

        // Col 1: Titre
        JLabel l1 = new JLabel(col1);
        l1.setFont(font); l1.setForeground(textColor);
        row.add(l1);

        // Col 2: Date
        JLabel l2 = new JLabel(col2);
        l2.setFont(font); l2.setForeground(textColor);
        row.add(l2);

        // Col 3: Statut (Badge)
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        statusPanel.setBackground(Color.WHITE);
        if (!isHeader) {
            JLabel badge = new JLabel(status, SwingConstants.CENTER);
            badge.setFont(new Font("Arial", Font.BOLD, 11));
            badge.setOpaque(true);
            if ("Ouvert".equals(status)) {
                badge.setBackground(STATUS_OPEN_BG);
                badge.setForeground(STATUS_OPEN_FG);
            } else {
                badge.setBackground(STATUS_CLOSED_BG);
                badge.setForeground(STATUS_CLOSED_FG);
            }
            badge.setBorder(new EmptyBorder(4, 12, 4, 12));
            statusPanel.add(badge);
        } else {
            JLabel l3 = new JLabel(status);
            l3.setFont(font); l3.setForeground(textColor);
            statusPanel.add(l3);
        }
        row.add(statusPanel);

        // Col 4: Action
        JLabel l4 = new JLabel(action);
        l4.setFont(isHeader ? font : new Font("Arial", Font.BOLD, 13));
        l4.setForeground(isHeader ? textColor : LINK_BLUE);
        l4.setCursor(isHeader ? Cursor.getDefaultCursor() : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        row.add(l4);

        return row;
    }

    private JSeparator createJSeparator() {
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(240, 240, 240));
        return sep;
    }

    // --- Composant : Section Détail Vote ---
    private JPanel createVoteSection() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(BG_COLOR);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 1. Titre de section
        JLabel title = new JLabel("Sondage sur les préférences de cours");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(title);
        panel.add(Box.createVerticalStrut(20));

        // 2. Onglets (Question 1 / Question 2...)
        JPanel tabs = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        tabs.setBackground(BG_COLOR);
        tabs.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel tab1 = new JLabel("Question 1");
        tab1.setFont(new Font("Arial", Font.BOLD, 14));
        tab1.setForeground(LINK_BLUE);
        tab1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, LINK_BLUE)); // Souligné bleu

        JLabel tab2 = new JLabel("Question 2");
        tab2.setFont(new Font("Arial", Font.BOLD, 14));
        tab2.setForeground(Color.GRAY);

        JLabel tab3 = new JLabel("Réponses individuelles");
        tab3.setFont(new Font("Arial", Font.BOLD, 14));
        tab3.setForeground(Color.GRAY);

        tabs.add(tab1);
        tabs.add(tab2);
        tabs.add(tab3);
        panel.add(tabs);
        
        // Ligne grise sous les onglets
        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(2000, 1));
        sep.setForeground(Color.LIGHT_GRAY);
        panel.add(sep);
        panel.add(Box.createVerticalStrut(20));

        // 3. La Question
        JLabel question = new JLabel("Question 1: Quel est votre langage de programmation préféré pour les projets de développement web ?");
        question.setFont(new Font("Arial", Font.BOLD, 16));
        question.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(question);
        panel.add(Box.createVerticalStrut(20));

        // 4. Carte de Vote (Blanche centrée)
        JPanel voteCard = new JPanel(new GridBagLayout());
        voteCard.setBackground(Color.WHITE);
        voteCard.setMaximumSize(new Dimension(600, 300)); // Taille contrainte pour ressembler à l'image
        voteCard.setBorder(new EmptyBorder(30, 30, 30, 30));
        
        // Pour arrondir les bords de la carte, on peut utiliser un panneau custom, 
        // mais ici un panneau blanc simple suffit pour la structure.
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 20, 0);

        // Titre "Faire un vote" + Icone
        JLabel voteTitle = new JLabel("Faire un vote   \uD83D\uDDF3"); // Icone Urne Unicode
        voteTitle.setFont(new Font("Arial", Font.BOLD, 16));
        voteCard.add(voteTitle, gbc);

        // Boutons de choix (Grid 2x2)
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridy = 1; gbc.gridx = 0;
        voteCard.add(createOptionButton("JavaScript"), gbc);
        gbc.gridx = 1;
        voteCard.add(createOptionButton("Python"), gbc);

        gbc.gridy = 2; gbc.gridx = 0;
        voteCard.add(createOptionButton("PHP"), gbc);
        gbc.gridx = 1;
        voteCard.add(createOptionButton("Autre"), gbc);

        panel.add(voteCard);

        return panel;
    }

    private JButton createOptionButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setBackground(VOTE_BTN_BG);
        btn.setForeground(VOTE_BTN_TEXT);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hack pour simuler les coins ronds sur un bouton standard Swing :
        // On enlève la bordure par défaut et on laisse le fond de couleur
        btn.setBorderPainted(false); 
        btn.setOpaque(true);
        
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SondagesUI().setVisible(true);
        });
    }
}