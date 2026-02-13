package frames;

import style.DataService;
import style.UIStyle;
import modele.Etudiant;
import modele.Groupe;
import algo.AlgosSafwan;
import algo.AlgosRaphael;
import algo.AlgosHanniel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EditeurGroupesFrame extends JFrame {

    // Modèles de données pour les listes (Ce qui s'affiche à l'écran)
    private DefaultListModel<String> modelNonAffectes;
    private DefaultListModel<String> modelTD1;
    private DefaultListModel<String> modelTD2;

    public EditeurGroupesFrame(String algoType) {
        setTitle("Éditeur de Groupes - " + (algoType.equals("MANUEL") ? "Mode Manuel" : "Résultat Automatique"));
        setSize(1100, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(UIStyle.BG_COLOR);
        setLayout(new BorderLayout(20, 20));

        // --- EN-TÊTE ---
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        header.setBorder(new EmptyBorder(15, 30, 15, 30));
        
        JLabel title = new JLabel(algoType.equals("MANUEL") 
            ? "Constitution Manuelle" 
            : "Résultat : " + algoType);
        title.setFont(UIStyle.FONT_TITLE);
        
        JButton btnSave = UIStyle.createBtn("Valider et Sauvegarder", UIStyle.ACTION_ORANGE);
        btnSave.addActionListener(e -> {
            // Ici, plus tard, tu mettras le code pour faire l'INSERT en base de données
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

        // Initialisation des modèles vides
        modelNonAffectes = new DefaultListModel<>();
        modelTD1 = new DefaultListModel<>();
        modelTD2 = new DefaultListModel<>();

        // CHARGEMENT DES DONNÉES (Correction ici : appel de la bonne méthode)
        chargerDonneesReelles(algoType);

        // Création des colonnes graphiques
        content.add(createColumn("Étudiants Non Affectés", modelNonAffectes, Color.WHITE));
        content.add(createColumn("Groupe TD 1 (30 places)", modelTD1, new Color(235, 245, 255)));
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
        
        // Action simple pour le bouton (Bonus)
        btnMove.addActionListener(e -> JOptionPane.showMessageDialog(this, "Fonctionnalité Drag & Drop à implémenter ici."));
        
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

    // --- LOGIQUE MÉTIER ---
    private void chargerDonneesReelles(String algoType) {
        
        // 1. On récupère les vraies données depuis l'API PHP via le DataService
        DataService service = new DataService();
        List<Etudiant> promo = service.getListeEtudiants(); // Assure-toi que cette méthode existe

        // 2. Traitement selon le mode choisi
        if (algoType.equals("MANUEL")) {
            // CAS MANUEL : Tout le monde va à gauche ("Non Affectés")
            for (Etudiant e : promo) {
                // On vérifie si l'étudiant a déjà un groupe en base
                if (e.groupe_actuel == null || e.groupe_actuel.isEmpty()) {
                    modelNonAffectes.addElement(e.toString()); 
                } else if (e.groupe_actuel.equals("TD1")) {
                     modelTD1.addElement(e.toString());
                } else if (e.groupe_actuel.equals("TD2")) {
                     modelTD2.addElement(e.toString());
                }
            }
        } else {
            // CAS AUTOMATIQUE : On lance les algos
            
            // A. Création des groupes vides pour recevoir les étudiants
            Groupe td1 = new Groupe("TD1");
            td1.setCapacite(30);
            Groupe td2 = new Groupe("TD2");
            td2.setCapacite(30);
            
            List<Groupe> mesGroupes = new ArrayList<>(Arrays.asList(td1, td2));

            // B. Sélection de l'algo
            System.out.println("Lancement de l'algo : " + algoType);
            
            switch (algoType) {
                case "SAFWAN_COVOIT":
                    new AlgosSafwan().gloutonCovoiturage(promo, mesGroupes);
                    break;
                case "HANNIEL_APPRENTIS":
                    new AlgosHanniel().gloutonApprentis(promo, mesGroupes);
                    break;
                case "RAPHAEL_MOYENNE":
                default:
                    new AlgosRaphael().gloutonMoyenne(promo, mesGroupes);
                    break;
            }

            // C. Mise à jour de l'affichage (Transfert Groupe -> JList)
            
            // Remplir la colonne TD1
            modelTD1.clear();
            for (Etudiant e : td1.getMembres()) {
                modelTD1.addElement(e.toString());
            }

            // Remplir la colonne TD2
            modelTD2.clear();
            for (Etudiant e : td2.getMembres()) {
                modelTD2.addElement(e.toString());
            }

            // Les restants vont dans "Non Affectés"
            modelNonAffectes.clear();
            for (Etudiant e : promo) {
                // Si l'étudiant n'est ni dans TD1 ni dans TD2
                if (!td1.getMembres().contains(e) && !td2.getMembres().contains(e)) {
                    modelNonAffectes.addElement(e.toString());
                }
            }
        }
    }

    // --- RENDU GRAPHIQUE ---
    static class StudentRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setBorder(new EmptyBorder(5, 5, 5, 5));
            label.setIcon(UIManager.getIcon("FileView.fileIcon")); 
            return label;
        }
    }
}