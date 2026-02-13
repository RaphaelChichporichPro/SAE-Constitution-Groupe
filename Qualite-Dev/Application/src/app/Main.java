package app;

import panels.ConstitutionPanel;
import style.UIStyle;

import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	        new frames.LoginFrame().setVisible(true);
	    });
	}
}