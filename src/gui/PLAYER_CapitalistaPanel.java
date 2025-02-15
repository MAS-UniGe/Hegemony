package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

public class PLAYER_CapitalistaPanel extends JPanel {
    public PLAYER_CapitalistaPanel() {
        setLayout(null); // Disable the layout manager

        ProventiCapitalistaPanel proventiCapitalistaPanel = new ProventiCapitalistaPanel();
        proventiCapitalistaPanel.setBounds(5, 20, 145, 60); // x, y, width, height
        add(proventiCapitalistaPanel);

        CapitaleCapitalistaPanel capitaleCapitalistaPanel = new CapitaleCapitalistaPanel();
        capitaleCapitalistaPanel.setBounds(150, 20, 145, 60); // x, y, width, height
        add(capitaleCapitalistaPanel);

        RicchezzaCapitalistaPanel ricchezzaCapitalistaPanel = new RicchezzaCapitalistaPanel();
        ricchezzaCapitalistaPanel.setBounds(5, 90, 290, 30); // x, y, width, height
        add(ricchezzaCapitalistaPanel);

        MagazziniCapitalistaPanel magazziniCapitalistaPanel = new MagazziniCapitalistaPanel();
        magazziniCapitalistaPanel.setBounds(5, 120, 290, 70); // x, y, width, height
        add(magazziniCapitalistaPanel);
    }
}

class ProventiCapitalistaPanel extends JPanel {
    public ProventiCapitalistaPanel() {
        setLayout(new GridLayout(1, 1));

        JPanel proventiCapitalistaPanel = createLabelWithBorder("Proventi", null, 10);
        add(proventiCapitalistaPanel);
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

class CapitaleCapitalistaPanel extends JPanel {
    public CapitaleCapitalistaPanel() {
        setLayout(new GridLayout(1, 1));

        JPanel capitaleCapitalistaPanel = createLabelWithBorder("Capitale", null, 10);
        add(capitaleCapitalistaPanel);
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

class RicchezzaCapitalistaPanel extends JPanel {
    public RicchezzaCapitalistaPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Ricchezza");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10)); // Change size to 20
        setBorder(titledBorder);
        setLayout(new GridLayout(1, 16));

        Font labelFont = new Font("Arial", Font.BOLD, 8);
        
        for (int i = 0; i < 16; i++) {
            JLabel label = new JLabel(Integer.toString(i), SwingConstants.CENTER);
            label.setFont(labelFont);
            add(label);
        }
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

class MagazziniCapitalistaPanel extends JPanel {
    public MagazziniCapitalistaPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Magazzini");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10)); // Change size to 20
        setBorder(titledBorder);

        setLayout(new GridLayout(1, 5));

        JPanel ciboPanel = createLabelWithBorder("Cibo", Color.GREEN, 7);
        JPanel lussoPanel = createLabelWithBorder("Lusso", Color.BLUE, 7);
        JPanel sanitaPanel = createLabelWithBorder("Sanità", Color.RED, 7);
        JPanel istruzionePanel = createLabelWithBorder("Istruzione", new Color(255, 215, 0), 7); // Gold
        JPanel influenzaPanel = createLabelWithBorder("Influenza", new Color(215, 15, 255), 7); // Purple
        
        add(ciboPanel);
        add(lussoPanel);
        add(sanitaPanel);
        add(istruzionePanel);
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