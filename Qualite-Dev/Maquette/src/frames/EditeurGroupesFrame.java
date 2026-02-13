package frames;

import style.UIStyle;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditeurGroupesFrame extends JFrame {

    // Modèles de données pour les listes
    private DefaultListModel<String> modelNonAffectes;
    private DefaultListModel<String> modelTD1;
    private DefaultListModel<String> modelTD2;

    public EditeurGroupesFrame(String algoType) {
        setTitle("Éditeur de Groupes - " + (algoType.equals("MANUEL") ? "Mode Manuel" : "Résultat Automatique"));
        setSize(1100, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(UIStyle.BG_COLOR);
        setLayout(new BorderLayout(20, 20));

       
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        header.setBorder(new EmptyBorder(15, 30, 15, 30));
        
        JLabel title = new JLabel(algoType.equals("MANUEL") 
            ? "Constitution Manuelle" 
            : "Résultat : " + algoType);
        title.setFont(UIStyle.FONT_TITLE);
        
        JButton btnSave = UIStyle.createBtn("Valider et Sauvegarder", UIStyle.ACTION_ORANGE);
        btnSave.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Groupes sauvegardés en BDD !");
            dispose();
        });

        header.add(title, BorderLayout.WEST);
        header.add(btnSave, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // --- CONTENU (3 Colonnes) ---
        JPanel content = new JPanel(new GridLayout(1, 3, 20, 0));
        content.setBackground(UIStyle.BG_COLOR);
        content.setBorder(new EmptyBorder(0, 30, 30, 30));

        // Initialisation des modèles
        modelNonAffectes = new DefaultListModel<>();
        modelTD1 = new DefaultListModel<>();
        modelTD2 = new DefaultListModel<>();

        // SIMULATION DES DONNÉES SELON L'ALGO CHOISI
        remplirDonneesSimulees(algoType);

        content.add(createColumn("Étudiants Non Affectés", modelNonAffectes, Color.WHITE));
        content.add(createColumn("Groupe TD 1 (30 places)", modelTD1, new Color(235, 245, 255))); // Bleu très clair
        content.add(createColumn("Groupe TD 2 (30 places)", modelTD2, new Color(235, 245, 255)));

        add(content, BorderLayout.CENTER);
    }

    private JPanel createColumn(String title, DefaultListModel<String> model, Color bgColor) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bgColor);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            new EmptyBorder(10, 10, 10, 10)
        ));

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTitle.setBorder(new EmptyBorder(0, 0, 10, 0));
        panel.add(lblTitle, BorderLayout.NORTH);

        JList<String> list = new JList<>(model);
        list.setBackground(bgColor);
        list.setCellRenderer(new StudentRenderer()); 
        panel.add(new JScrollPane(list), BorderLayout.CENTER);

        JPanel btns = new JPanel(new GridLayout(1, 2, 5, 0));
        btns.setBackground(bgColor);
        JButton btnMove = new JButton("Déplacer ici");
        styleMiniBtn(btnMove);
        btns.add(btnMove);
        panel.add(btns, BorderLayout.SOUTH);

        return panel;
    }

    private void styleMiniBtn(JButton btn) {
        btn.setBackground(Color.WHITE);
        btn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // --- SIMULATION LOGIQUE (Pour la démo) ---
    private void remplirDonneesSimulees(String algo) {
        if (algo.equals("MANUEL")) {
            // Tout le monde à gauche
            modelNonAffectes.addElement("Dupont Jean (14.5) [Covoit: Lyon]");
            modelNonAffectes.addElement("Martin Alice (12.0)");
            modelNonAffectes.addElement("Diallo Moussa (16.0) [Covoit: Lyon]");
            modelNonAffectes.addElement("Smith John (10.0)");
        } else if (algo.equals("SAFWAN_COVOIT")) {
            // Logique Safwan : Regroupement par ville
            modelTD1.addElement("Dupont Jean (Lyon)");
            modelTD1.addElement("Diallo Moussa (Lyon)");
            modelTD2.addElement("Martin Alice (Paris)");
            modelTD2.addElement("Smith John (Paris)");
        } else if (algo.equals("RAPHAEL_MOYENNE")) {
            // Logique Raphaël : Snake Draft (Meilleur-Moins bon)
            modelTD1.addElement("Diallo Moussa (16.0)"); // 1er
            modelTD2.addElement("Dupont Jean (14.5)");   // 2eme
            modelTD2.addElement("Martin Alice (12.0)");  // 3eme
            modelTD1.addElement("Smith John (10.0)");    // 4eme
        }
    }

    // --- RENDU GRAPHIQUE DES LIGNES (Pour faire joli) ---
    static class StudentRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setBorder(new EmptyBorder(5, 5, 5, 5));
            label.setIcon(UIManager.getIcon("FileView.fileIcon")); // Icône générique
            return label;
        }
    }
}