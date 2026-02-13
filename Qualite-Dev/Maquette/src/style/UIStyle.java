package style;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UIStyle {
    // Couleurs extraites de tes maquettes
    public static final Color BG_COLOR = new Color(244, 246, 249); // Gris très clair (Fond site)
    public static final Color CARD_COLOR = Color.WHITE;            // Blanc (Cartes)
    public static final Color PRIMARY_BLUE = new Color(0, 123, 255); // Bleu IUT
    public static final Color ACTION_ORANGE = new Color(255, 120, 0); // Orange (Boutons action)
    public static final Color TEXT_DARK = new Color(33, 37, 41);
    public static final Color TEXT_GRAY = new Color(108, 117, 125);
    public static final Font FONT_TITLE = new Font("Segoe UI", Font.BOLD, 22);
    public static final Font FONT_NORMAL = new Font("Segoe UI", Font.PLAIN, 14);

    public static JButton createBtn(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(10, 20, 10, 20));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    public static JPanel createCard(String title) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            new EmptyBorder(20, 20, 20, 20)
        ));
        
        if (title != null) {
            JLabel lbl = new JLabel(title);
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
            lbl.setForeground(TEXT_DARK);
            lbl.setBorder(new EmptyBorder(0, 0, 15, 0));
            card.add(lbl, BorderLayout.NORTH);
        }
        return card;
    }
}