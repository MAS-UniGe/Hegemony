package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

public class PLAYER_StatoPanel extends JPanel {
    public PLAYER_StatoPanel() {
        setLayout(null); // Disable the layout manager

        LegittimitaOperaiaStatoPanel legittimitaOperaiaStatoPanel = new LegittimitaOperaiaStatoPanel();
        legittimitaOperaiaStatoPanel.setBounds(5, 20, 290, 30); // x, y, width, height
        add(legittimitaOperaiaStatoPanel);

        LegittimitaMediaStatoPanel legittimitaMediaStatoPanel = new LegittimitaMediaStatoPanel();
        legittimitaMediaStatoPanel.setBounds(5, 55, 290, 30); // x, y, width, height
        add(legittimitaMediaStatoPanel);

        LegittimitaCapitalistaStatoPanel legittimitaCapitalistaStatoPanel = new LegittimitaCapitalistaStatoPanel();
        legittimitaCapitalistaStatoPanel.setBounds(5, 90, 290, 30); // x, y, width, height
        add(legittimitaCapitalistaStatoPanel);

        MagazziniStatoPanel magazziniStatoPanel = new MagazziniStatoPanel();
        magazziniStatoPanel.setBounds(5, 120, 290, 70); // x, y, width, height
        add(magazziniStatoPanel);
    }
}

class LegittimitaOperaiaStatoPanel extends JPanel {
    public LegittimitaOperaiaStatoPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Legittimità (Classe Operaia)");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10));
        setBorder(titledBorder);
        setLayout(new GridLayout(1, 11));

        Font labelFont = new Font("Arial", Font.BOLD, 8);
        
        for (int i = 0; i < 11; i++) {
            JLabel label = new JLabel(Integer.toString(i), SwingConstants.CENTER);
            label.setFont(labelFont);
            add(label);
        }
    }
}

class LegittimitaMediaStatoPanel extends JPanel {
    public LegittimitaMediaStatoPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255, 215, 0)), "Legittimità (Classe Media)");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10));
        setBorder(titledBorder);
        setLayout(new GridLayout(1, 11));

        Font labelFont = new Font("Arial", Font.BOLD, 8);
        
        for (int i = 0; i < 11; i++) {
            JLabel label = new JLabel(Integer.toString(i), SwingConstants.CENTER);
            label.setFont(labelFont);
            add(label);
        }
    }
}

class LegittimitaCapitalistaStatoPanel extends JPanel {
    public LegittimitaCapitalistaStatoPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Legittimità (Classe Capitalista)");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10));
        setBorder(titledBorder);
        setLayout(new GridLayout(1, 11));

        Font labelFont = new Font("Arial", Font.BOLD, 8);
        
        for (int i = 0; i < 11; i++) {
            JLabel label = new JLabel(Integer.toString(i), SwingConstants.CENTER);
            label.setFont(labelFont);
            add(label);
        }
    }
}

class MagazziniStatoPanel extends JPanel {
    public MagazziniStatoPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Magazzini");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10)); // Change size to 20
        setBorder(titledBorder);

        setLayout(new GridLayout(1, 3));

        JPanel ciboPanel = createLabelWithBorder("Cibo", Color.GREEN, 7);
        JPanel lussoPanel = createLabelWithBorder("Lusso", Color.BLUE, 7);
        JPanel influenzaPanel = createLabelWithBorder("Influenza", new Color(215, 15, 255), 7); // Purple
        
        add(ciboPanel);
        add(lussoPanel);
        add(influenzaPanel);
    }

    private JPanel createLabelWithBorder(String labelText, Color borderColor, int fontSize) {
        JPanel panel = new JPanel();

        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(borderColor), labelText);
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, fontSize));
        panel.setBorder(titledBorder);

        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}