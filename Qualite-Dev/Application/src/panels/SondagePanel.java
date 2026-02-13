package panels;

import style.UIStyle;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SondagePanel extends JPanel {

    public SondagePanel() {
        setLayout(new BorderLayout(30, 30));
        setBackground(UIStyle.BG_COLOR);
        setBorder(new EmptyBorder(30, 30, 30, 30));

        // Titre
        JLabel title = new JLabel("Résultats des Sondages Préliminaires");
        title.setFont(UIStyle.FONT_TITLE);
        add(title, BorderLayout.NORTH);

        // Grille de statistiques
        JPanel grid = new JPanel(new GridLayout(2, 2, 20, 20)); 
        grid.setBackground(UIStyle.BG_COLOR);

        // On ajoute des cartes de stats
        grid.add(createStatCard("Préférence Covoiturage", 65, Color.BLUE, "65% souhaitent covoiturer"));
        grid.add(createStatCard("Niveau en Programmation", 40, Color.ORANGE, "40% se sentent 'Débutant'"));
        grid.add(createStatCard("Préférence Matin/Soir", 80, Color.GREEN, "80% préfèrent les TD le matin"));
        grid.add(createStatCard("Équipement Personnel", 95, Color.MAGENTA, "95% ont leur propre PC portable"));
        add(grid, BorderLayout.CENTER);
    }

    private JPanel createStatCard(String title, int percent, Color barColor, String desc) {
        JPanel card = UIStyle.createCard(title);
        
        JPanel content = new JPanel(new GridLayout(3, 1));
        content.setBackground(Color.WHITE);

        JProgressBar bar = new JProgressBar(0, 100);
        bar.setValue(percent);
        bar.setStringPainted(true);
        bar.setForeground(barColor);
        bar.setPreferredSize(new Dimension(100, 25));

        JLabel lblDesc = new JLabel(desc);
        lblDesc.setForeground(UIStyle.TEXT_GRAY);

        content.add(new JLabel("Taux de réponse positive :"));
        content.add(bar);
        content.add(lblDesc);
        
        card.add(content, BorderLayout.CENTER);
        return card;
    }
}