package panels;

import style.UIStyle;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EtudiantsPanel extends JPanel {

    public EtudiantsPanel() {
        setLayout(new BorderLayout(20, 20));
        setBackground(UIStyle.BG_COLOR);
        setBorder(new EmptyBorder(20, 20, 20, 20));

        // Titre + Recherche
        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(UIStyle.BG_COLOR);
        JLabel title = new JLabel("Gestion de la Promotion");
        title.setFont(UIStyle.FONT_TITLE);
        
        JTextField search = new JTextField("Rechercher un étudiant...");
        search.setPreferredSize(new Dimension(200, 30));
        
        top.add(title, BorderLayout.WEST);
        top.add(search, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        // Tableau
        String[] columns = {"ID", "Nom", "Prénom", "Email", "Groupe Actuel"};
        Object[][] data = {
            {"ETU1", "Dupont", "Jean", "jean.dupont@univ.fr", "Non affecté"},
            {"ETU2", "Martin", "Alice", "alice.martin@univ.fr", "TD1"},
            {"ETU3", "Diallo", "Moussa", "moussa.diallo@univ.fr", "Non affecté"},
            // ... Ici  brancher la JDBC plus tard
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.getTableHeader().setBackground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        add(new JScrollPane(table), BorderLayout.CENTER);
        
        // Boutons bas
        JPanel bot = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bot.setBackground(UIStyle.BG_COLOR);
        bot.add(UIStyle.createBtn("Ajouter un étudiant", UIStyle.PRIMARY_BLUE));
        bot.add(UIStyle.createBtn("Supprimer la sélection", Color.RED));
        add(bot, BorderLayout.SOUTH);
    }
}