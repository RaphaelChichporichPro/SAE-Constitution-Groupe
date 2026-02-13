package panels;

import style.UIStyle;
import javax.swing.*;
import java.awt.*;

public class ConstitutionPanel extends JPanel {

    private JRadioButton radioAlgoRaphael;
    private JRadioButton radioAlgoSafwan;
    private JRadioButton radioAlgoHanniel;
    private JComboBox<String> comboOption;

    public ConstitutionPanel() {
        setLayout(new BorderLayout(30, 30));
        setBackground(UIStyle.BG_COLOR);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // HEADER
        JLabel title = new JLabel("Constitution des Groupes");
        title.setFont(UIStyle.FONT_TITLE);
        add(title, BorderLayout.NORTH);

        // CENTRE : CARTE DE SÉLECTIOn
        JPanel card = UIStyle.createCard("Choisir la stratégie de répartition");
        JPanel content = new JPanel(new GridLayout(1, 2, 20, 0)); 
        content.setBackground(Color.WHITE);

        // COLONNE GAUCHE : Algorithmes Principaux
        JPanel algosPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        algosPanel.setBackground(Color.WHITE);
        algosPanel.setBorder(BorderFactory.createTitledBorder("Algorithme Principal"));
        
        ButtonGroup group = new ButtonGroup();
        // Référence aux algos de Raphaël (Moyenne/Mixité)
        radioAlgoRaphael = new JRadioButton("<html><b>Pédagogique (Raphaël)</b><br><small>Snake Draft (Notes) & Mixité H/F</small></html>");
        // Référence aux algos de Safwan (Covoit/Bac)
        radioAlgoSafwan = new JRadioButton("<html><b>Logistique (Safwan)</b><br><small>Priorité Covoiturage & Diversité Bac</small></html>");
        // Référence aux algos de Hanniel (Apprentis)
        radioAlgoHanniel = new JRadioButton("<html><b>Alternance (Hanniel)</b><br><small>Répartition Apprentis & Entreprises</small></html>");
        
        styleRadio(radioAlgoRaphael); styleRadio(radioAlgoSafwan); styleRadio(radioAlgoHanniel);
        group.add(radioAlgoRaphael); group.add(radioAlgoSafwan); group.add(radioAlgoHanniel);
        radioAlgoRaphael.setSelected(true); // Par défaut

        algosPanel.add(radioAlgoRaphael);
        algosPanel.add(radioAlgoSafwan);
        algosPanel.add(radioAlgoHanniel);

        // COLONNE DROITE : Options
        JPanel optionsPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        optionsPanel.setBackground(Color.WHITE);
        optionsPanel.setBorder(BorderFactory.createTitledBorder("Options Avancées"));
        
        optionsPanel.add(new JCheckBox("Forcer l'équilibre H/F (±10%)"));
        optionsPanel.add(new JCheckBox("Exclure les redoublants des mêmes groupes"));
        
        // Sélecteur de méthode (Glouton vs BruteForce)
        optionsPanel.add(new JLabel("Méthode de calcul :"));
        comboOption = new JComboBox<>(new String[]{"Glouton (Rapide)", "Brute Force (Optimal - Lent)"});
        optionsPanel.add(comboOption);

        content.add(algosPanel);
        content.add(optionsPanel);
        card.add(content, BorderLayout.CENTER);
        
        add(card, BorderLayout.CENTER);

        // ACTION
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        actions.setBackground(UIStyle.BG_COLOR);

        JButton btnManuel = UIStyle.createBtn("Constitution Manuelle", UIStyle.TEXT_GRAY);
        btnManuel.addActionListener(e -> new frames.EditeurGroupesFrame("MANUEL").setVisible(true));

        JButton btnAuto = UIStyle.createBtn("Lancer la Constitution Automatique", UIStyle.PRIMARY_BLUE);
        btnAuto.addActionListener(e -> {
            String algoChoisi = getAlgoName();
            JOptionPane.showMessageDialog(this, "Lancement de l'algorithme : " + algoChoisi);
            // On ouvre l'éditeur avec le résultat de l'algo
            new frames.EditeurGroupesFrame(algoChoisi).setVisible(true);
        });

        actions.add(btnManuel);
        actions.add(btnAuto);
        add(actions, BorderLayout.SOUTH);
    }
    
    private String getAlgoName() {
        if (radioAlgoSafwan.isSelected()) return "SAFWAN_COVOIT";
        if (radioAlgoHanniel.isSelected()) return "HANNIEL_APPRENTIS";
        return "RAPHAEL_MOYENNE";
    }

    private void styleRadio(JRadioButton rb) {
        rb.setBackground(Color.WHITE);
        rb.setFont(UIStyle.FONT_NORMAL);
        rb.setFocusPainted(false);
    }
}