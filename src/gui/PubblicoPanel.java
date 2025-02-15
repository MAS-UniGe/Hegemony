package gui;

import javax.swing.*;
import java.awt.*;

public class PubblicoPanel extends JPanel {
    public PubblicoPanel() {
        setLayout(new BorderLayout());

        // Create panels
        JPanel topPanel = new TesoreriaPanel();
        JPanel midPanel = new ServiziPubbliciPanel();
        JPanel bottomPanel = new StatoPanel();


        // Add panels to the layout
        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Set preferred sizes to control proportions
        topPanel.setPreferredSize(new Dimension(0, 100));  
        midPanel.setPreferredSize(new Dimension(0, 100));
        bottomPanel.setPreferredSize(new Dimension(0, 300));
    }
}

class TesoreriaPanel extends JPanel {
    public TesoreriaPanel() {
        setBorder(BorderFactory.createTitledBorder("Tesoreria di Stato"));
        setLayout(new GridLayout(1, 1));

        JPanel tesoreriaPanel = createLabelWithBorder("Denaro", new Color(255, 215, 0)); // Gold

        add(tesoreriaPanel);
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

class ServiziPubbliciPanel extends JPanel {
    public ServiziPubbliciPanel() {
        setBorder(BorderFactory.createTitledBorder("Servizi Pubblici"));
        setLayout(new GridLayout(1, 3));

        JPanel sanitaPanel = createLabelWithBorder("Sanità", Color.RED);
        JPanel istruzionePanel = createLabelWithBorder("Istruz.", new Color(255, 215, 0)); // Gold
        JPanel influenzaPanel = createLabelWithBorder("Influen.", new Color(215, 15, 255)); // Purple

        add(sanitaPanel);
        add(istruzionePanel);
        add(influenzaPanel);
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

class StatoPanel extends JPanel {
    public StatoPanel() {
        setBorder(BorderFactory.createTitledBorder("Aziende dello Stato"));
        setLayout(new GridLayout(3, 3)); // 3 rows x 3 cols

        JPanel statoPanel1 = createLabelWithBorder("1", new Color(80, 80, 80)); // Grey
        JPanel statoPanel2 = createLabelWithBorder("2", new Color(80, 80, 80)); // Grey
        JPanel statoPanel3 = createLabelWithBorder("3", new Color(80, 80, 80)); // Grey
        JPanel statoPanel4 = createLabelWithBorder("4", new Color(80, 80, 80)); // Grey
        JPanel statoPanel5 = createLabelWithBorder("5", new Color(80, 80, 80)); // Grey
        JPanel statoPanel6 = createLabelWithBorder("6", new Color(80, 80, 80)); // Grey
        JPanel statoPanel7 = createLabelWithBorder("7", new Color(80, 80, 80)); // Grey
        JPanel statoPanel8 = createLabelWithBorder("8", new Color(80, 80, 80)); // Grey
        JPanel statoPanel9 = createLabelWithBorder("9", new Color(80, 80, 80)); // Grey

        add(statoPanel1);
        add(statoPanel2);
        add(statoPanel3);
        add(statoPanel4);
        add(statoPanel5);
        add(statoPanel6);
        add(statoPanel7);
        add(statoPanel8);
        add(statoPanel9);
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

