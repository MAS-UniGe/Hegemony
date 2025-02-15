package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

public class PLAYER_MediaPanel extends JPanel {
    public PLAYER_MediaPanel() {
        setLayout(null); // Disable the layout manager

        LavoratoriMediaPanel lavoratoriMediaPanel = new LavoratoriMediaPanel();
        lavoratoriMediaPanel.setBounds(5, 20, 290, 30); // x, y, width, height
        add(lavoratoriMediaPanel);

        PopolazioneMediaPanel popolazioneMediaPanel = new PopolazioneMediaPanel();
        popolazioneMediaPanel.setBounds(5, 50, 290, 30); // x, y, width, height
        add(popolazioneMediaPanel);

        ProsperitaMediaPanel prosperitaMediaPanel = new ProsperitaMediaPanel();
        prosperitaMediaPanel.setBounds(5, 90, 200, 30); // x, y, width, height
        add(prosperitaMediaPanel);

        MagazziniMediaPanel magazziniMediaPanel = new MagazziniMediaPanel();
        magazziniMediaPanel.setBounds(5, 120, 200, 70); // x, y, width, height
        add(magazziniMediaPanel);

        IntroitiMediaPanel introitiMediaPanel = new IntroitiMediaPanel();
        introitiMediaPanel.setBounds(210, 90, 85, 50); // x, y, width, height
        add(introitiMediaPanel);

        MerciServiziMediaPanel merciServiziMediaPanel = new MerciServiziMediaPanel();
        merciServiziMediaPanel.setBounds(210, 140, 85, 50); // x, y, width, height
        add(merciServiziMediaPanel);
    }
}

class LavoratoriMediaPanel extends JPanel {
    public LavoratoriMediaPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Lavoratori");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10)); // Change size to 20
        setBorder(titledBorder);
        setLayout(new GridLayout(1, 20));
    
        // Set the desired font size for the labels
        Font labelFont = new Font("Arial", Font.BOLD, 7); // Set font to Arial, regular, size 20
    
        for (int i = 0; i < 21; i++) {
            JLabel label = new JLabel(Integer.toString(i+10), SwingConstants.CENTER);
            label.setFont(labelFont); // Apply the font to the label
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

class PopolazioneMediaPanel extends JPanel{
    public PopolazioneMediaPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Popolazione");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10)); // Change size to 20
        setBorder(titledBorder);
        setLayout(new GridLayout(1, 1));
    }
}

class ProsperitaMediaPanel extends JPanel {
    public ProsperitaMediaPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Prosperità");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10)); // Change size to 20
        setBorder(titledBorder);
        setLayout(new GridLayout(1, 11));

        Font labelFont = new Font("Arial", Font.BOLD, 8);
        
        for (int i = 0; i < 11; i++) {
            if (i < 5) {
                JLabel label = new JLabel(Integer.toString(i), SwingConstants.CENTER);
                label.setFont(labelFont);
                add(label);
            } else if (i == 5 || i == 6) {
                JLabel label = new JLabel("5", SwingConstants.CENTER);
                label.setFont(labelFont);
                add(label);
            } else if (i == 7 || i == 8) {
                JLabel label = new JLabel("6", SwingConstants.CENTER);
                label.setFont(labelFont);
                add(label);
            } else if (i == 9 || i == 10) {
                JLabel label = new JLabel("7", SwingConstants.CENTER);
                label.setFont(labelFont);
                add(label);
            }
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

class MagazziniMediaPanel extends JPanel {
    public MagazziniMediaPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Magazzini");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10)); // Change size to 20
        setBorder(titledBorder);

        setLayout(new GridLayout(1, 4));

        JPanel ciboPanel = createLabelWithBorder("Cibo", Color.GREEN, 7);
        JPanel lussoPanel = createLabelWithBorder("Lusso", Color.BLUE, 7);
        JPanel sanitaPanel = createLabelWithBorder("Sanità", Color.RED, 7);
        JPanel istruzionePanel = createLabelWithBorder("Istruz.", new Color(255, 215, 0), 7); // Gold
        
        add(ciboPanel);
        add(lussoPanel);
        add(sanitaPanel);
        add(istruzionePanel);
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

class IntroitiMediaPanel extends JPanel {
    public IntroitiMediaPanel() {
        setLayout(new GridLayout(1, 1));

        JPanel introitiPanel = createLabelWithBorder("Introiti", null, 10);
        add(introitiPanel);
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

class MerciServiziMediaPanel extends JPanel{
    public MerciServiziMediaPanel() {
        setLayout(new GridLayout(1, 1));

        JPanel merciServiziPanel = createLabelWithBorder("Mer. e Serv.", null, 10);
        add(merciServiziPanel);
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
