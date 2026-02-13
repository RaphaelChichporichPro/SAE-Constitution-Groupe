package panels;

import style.UIStyle;
import style.ApiClient;
import style.DataService;
import modele.Etudiant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;

public class EtudiantsPanel extends JPanel {

    private DefaultTableModel model;
    private JTable table;
    private TableRowSorter<DefaultTableModel> sorter; // Nécessaire pour la recherche
    private JTextField searchField;

    public EtudiantsPanel() {
        setLayout(new BorderLayout(20, 20));
        setBackground(UIStyle.BG_COLOR);
        setBorder(new EmptyBorder(20, 20, 20, 20));

        // --- HAUT : Titre + Recherche ---
        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(UIStyle.BG_COLOR);
        
        JLabel title = new JLabel("Gestion de la Promotion");
        title.setFont(UIStyle.FONT_TITLE);
        
        // Barre de recherche
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(250, 30));
        searchField.putClientProperty("JTextField.placeholderText", "Rechercher par nom, prénom..."); // (Optionnel, marche sur Java récents)

        top.add(title, BorderLayout.WEST);
        top.add(searchField, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        // --- CENTRE : Tableau ---
        String[] columns = {"ID", "Nom", "Prénom", "Email", "Bac", "Apprentissage"};
        
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Lecture seule
            }
        };

        table = new JTable(model);
        table.setRowHeight(30);
        table.getTableHeader().setBackground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));

        // Mise en place du TRI (Sorter) pour la recherche
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Ajout de l'écouteur sur la barre de recherche
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filter(); }
            public void removeUpdate(DocumentEvent e) { filter(); }
            public void changedUpdate(DocumentEvent e) { filter(); }
        });

        // Chargement initial des données
        chargerDonnees();

        add(new JScrollPane(table), BorderLayout.CENTER);
        
        // --- BAS : Boutons ---
        JPanel bot = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bot.setBackground(UIStyle.BG_COLOR);

        // Bouton AJOUTER
        JButton btnAdd = UIStyle.createBtn("Ajouter un étudiant", UIStyle.PRIMARY_BLUE);
        btnAdd.addActionListener(e -> ouvrirFormulaireAjout());
        
        // Bouton SUPPRIMER
        JButton btnDelete = UIStyle.createBtn("Supprimer la sélection", Color.RED);
        btnDelete.addActionListener(e -> actionSupprimer());

        bot.add(btnAdd);
        bot.add(btnDelete);
        add(bot, BorderLayout.SOUTH);
    }

    /**
     * Filtre le tableau selon le texte saisi
     */
    private void filter() {
        String text = searchField.getText();
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            // (?i) rend la recherche insensible à la casse (majuscule/minuscule)
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }

    /**
     * Logique de suppression d'un étudiant
     */
    private void actionSupprimer() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à supprimer.");
            return;
        }

        // IMPORTANT : Quand on filtre le tableau (recherche), l'index visuel change.
        // On doit convertir l'index visuel en index du modèle réel.
        int modelRow = table.convertRowIndexToModel(selectedRow);

        String idToDelete = (String) model.getValueAt(modelRow, 0); // Col 0 = ID
        String nom = (String) model.getValueAt(modelRow, 1);
        String prenom = (String) model.getValueAt(modelRow, 2);

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Voulez-vous vraiment supprimer " + nom + " " + prenom + " ?", 
            "Confirmation de suppression", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            ApiClient api = new ApiClient();
            // Appel API : DELETE .../etudiants?id=ETU123
            boolean success = api.delete("etudiants?id=" + idToDelete);

            if (success) {
                model.removeRow(modelRow);
                JOptionPane.showMessageDialog(this, "Étudiant supprimé avec succès.");
            } else {
                JOptionPane.showMessageDialog(this, "Erreur API lors de la suppression.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Récupère la liste depuis l'API et remplit le tableau
     */
    private void chargerDonnees() {
        model.setRowCount(0); // Vider le tableau
        DataService service = new DataService();
        List<Etudiant> liste = service.getListeEtudiants();

        if (liste != null) {
            for (Etudiant e : liste) {
                model.addRow(new Object[]{
                    e.id_user,
                    e.nom_etudiant,
                    e.prenom_etudiant,
                    e.mail_univ,
                    e.getType_bac(),
                    e.isApprentissage() ? "Oui" : "Non"
                });
            }
        }
    }

    /**
     * Ouvre le formulaire d'ajout
     */
    private void ouvrirFormulaireAjout() {
        JTextField txtNom = new JTextField();
        JTextField txtPrenom = new JTextField();
        JTextField txtMail = new JTextField();
        String[] typesBac = {"General", "Techno", "Pro", "Autre"};
        JComboBox<String> cmbBac = new JComboBox<>(typesBac);
        JCheckBox chkApprentissage = new JCheckBox("En Apprentissage ?");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nom :")); panel.add(txtNom);
        panel.add(new JLabel("Prénom :")); panel.add(txtPrenom);
        panel.add(new JLabel("Email :")); panel.add(txtMail);
        panel.add(new JLabel("Bac :")); panel.add(cmbBac);
        panel.add(chkApprentissage);

        int result = JOptionPane.showConfirmDialog(null, panel, 
                "Nouvel Étudiant", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            // Vérification basique
            if (txtNom.getText().isEmpty() || txtMail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Le nom et l'email sont obligatoires.");
                return;
            }

            // Construction JSON
            String jsonInput = String.format(
                "{" +
                "\"nom_etudiant\": \"%s\", " +
                "\"prenom_etudiant\": \"%s\", " +
                "\"mail_univ\": \"%s\", " +
                "\"type_bac\": \"%s\", " +
                "\"apprentissage\": %b" + // %b -> true/false
                "}",
                txtNom.getText().trim(),
                txtPrenom.getText().trim(),
                txtMail.getText().trim(),
                cmbBac.getSelectedItem().toString(),
                chkApprentissage.isSelected()
            );

            // Envoi API
            ApiClient api = new ApiClient();
            String reponse = api.post("etudiants", jsonInput);

            if (reponse != null) {
                JOptionPane.showMessageDialog(this, "Ajouté avec succès !");
                chargerDonnees(); // Rafraichir le tableau
            } else {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}