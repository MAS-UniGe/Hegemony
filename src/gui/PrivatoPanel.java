package gui;

import javax.swing.*;
import java.awt.*;

public class PrivatoPanel extends JPanel {
    public PrivatoPanel() {
        setLayout(new BorderLayout());

        // Create panels
        JPanel topPanel = new CommercioPanel();
        JPanel midPanel = new ClasseCapitalistaPanel();
        JPanel bottomPanel = new ClasseMediaPanel();


        // Add panels to the layout
        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Set preferred sizes to control proportions
        topPanel.setPreferredSize(new Dimension(0, 100));  
        midPanel.setPreferredSize(new Dimension(0, 300));  // 3/5 of the card part
        bottomPanel.setPreferredSize(new Dimension(0, 200));  // 3/5 of the card part
    }
}

class ClasseCapitalistaPanel extends JPanel {
    public ClasseCapitalistaPanel() {
        setBorder(BorderFactory.createTitledBorder("Aziende della Classe Capitalista"));
        setLayout(new GridLayout(3, 4)); // 3 rows x 4 cols

        JPanel ClasseCapitalistaPanel1 = createLabelWithBorder("1", Color.BLUE);
        JPanel ClasseCapitalistaPanel2 = createLabelWithBorder("2", Color.BLUE);
        JPanel ClasseCapitalistaPanel3 = createLabelWithBorder("3", Color.BLUE);
        JPanel ClasseCapitalistaPanel4 = createLabelWithBorder("4", Color.BLUE);
        JPanel ClasseCapitalistaPanel5 = createLabelWithBorder("5", Color.BLUE);
        JPanel ClasseCapitalistaPanel6 = createLabelWithBorder("6", Color.BLUE);
        JPanel ClasseCapitalistaPanel7 = createLabelWithBorder("7", Color.BLUE);
        JPanel ClasseCapitalistaPanel8 = createLabelWithBorder("8", Color.BLUE);
        JPanel ClasseCapitalistaPanel9 = createLabelWithBorder("9", Color.BLUE);
        JPanel ClasseCapitalistaPanel10 = createLabelWithBorder("10", Color.BLUE);
        JPanel ClasseCapitalistaPanel11 = createLabelWithBorder("11", Color.BLUE);
        JPanel ClasseCapitalistaPanel12 = createLabelWithBorder("12", Color.BLUE);
        
        add(ClasseCapitalistaPanel1);
        add(ClasseCapitalistaPanel2);
        add(ClasseCapitalistaPanel3);
        add(ClasseCapitalistaPanel4);
        add(ClasseCapitalistaPanel5);
        add(ClasseCapitalistaPanel6);
        add(ClasseCapitalistaPanel7);
        add(ClasseCapitalistaPanel8);
        add(ClasseCapitalistaPanel9);
        add(ClasseCapitalistaPanel10);
        add(ClasseCapitalistaPanel11);
        add(ClasseCapitalistaPanel12);
    }

    private JPanel createLabelWithBorder(String labelText, Color borderColor) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(borderColor), labelText));
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}

class ClasseMediaPanel extends JPanel {
    public ClasseMediaPanel() {
        setBorder(BorderFactory.createTitledBorder("Aziende della Classe Media"));
        setLayout(new GridLayout(2, 4)); // 2 rows x 4 cols

        JPanel classeMediaPanel1 = createLabelWithBorder("1", new Color(255, 215, 0)); // Gold
        JPanel classeMediaPanel2 = createLabelWithBorder("2", new Color(255, 215, 0)); // Gold
        JPanel classeMediaPanel3 = createLabelWithBorder("3", new Color(255, 215, 0)); // Gold
        JPanel classeMediaPanel4 = createLabelWithBorder("4", new Color(255, 215, 0)); // Gold
        JPanel classeMediaPanel5 = createLabelWithBorder("5", new Color(255, 215, 0)); // Gold
        JPanel classeMediaPanel6 = createLabelWithBorder("6", new Color(255, 215, 0)); // Gold
        JPanel classeMediaPanel7 = createLabelWithBorder("7", new Color(255, 215, 0)); // Gold
        JPanel classeMediaPanel8 = createLabelWithBorder("8", new Color(255, 215, 0)); // Gold

        add(classeMediaPanel1);
        add(classeMediaPanel2);
        add(classeMediaPanel3);
        add(classeMediaPanel4);
        add(classeMediaPanel5);
        add(classeMediaPanel6);
        add(classeMediaPanel7);
        add(classeMediaPanel8);
    }

    private JPanel createLabelWithBorder(String labelText, Color borderColor) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(borderColor), labelText));
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}

class CommercioPanel extends JPanel {
    public CommercioPanel() {
        setBorder(BorderFactory.createTitledBorder("Commercio"));
        setLayout(new GridLayout(1, 3));

        JPanel accordiPanel = createLabelWithBorder("Accordi", new Color(255, 215, 0)); // Gold
        JPanel exportPanel = createLabelWithBorder("Export", new Color(255, 215, 0)); // Gold
        JPanel importPanel = createLabelWithBorder("Import", new Color(255, 215, 0)); // Gold

        add(accordiPanel);
        add(exportPanel);
        add(importPanel);
    }

    private JPanel createLabelWithBorder(String labelText, Color borderColor) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(borderColor), labelText));
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}
