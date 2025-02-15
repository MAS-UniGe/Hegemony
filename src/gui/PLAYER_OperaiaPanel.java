package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

public class PLAYER_OperaiaPanel extends JPanel {
    public PLAYER_OperaiaPanel() {
        setLayout(null); // Disable the layout manager

        LavoratoriOperaiaPanel lavoratoriOperaiaPanel = new LavoratoriOperaiaPanel();
        lavoratoriOperaiaPanel.setBounds(5, 20, 290, 30); // x, y, width, height
        add(lavoratoriOperaiaPanel);

        PopolazioneOperaiaPanel popolazioneOperaiaPanel = new PopolazioneOperaiaPanel();
        popolazioneOperaiaPanel.setBounds(5, 50, 290, 30); // x, y, width, height
        add(popolazioneOperaiaPanel);

        ProsperitaOperaiaPanel prosperitaOperaiaPanel = new ProsperitaOperaiaPanel();
        prosperitaOperaiaPanel.setBounds(5, 90, 200, 30); // x, y, width, height
        add(prosperitaOperaiaPanel);

        SindacatiOperaiaPanel sindacatiOperaiaPanel = new SindacatiOperaiaPanel();
        sindacatiOperaiaPanel.setBounds(5, 120, 200, 70); // x, y, width, height
        add(sindacatiOperaiaPanel);

        IntroitiOperaiaPanel introitiOperaiaPanel = new IntroitiOperaiaPanel();
        introitiOperaiaPanel.setBounds(210, 90, 85, 50); // x, y, width, height
        add(introitiOperaiaPanel);

        MerciServiziOperaiaPanel merciServiziOperaiaPanel = new MerciServiziOperaiaPanel();
        merciServiziOperaiaPanel.setBounds(210, 140, 85, 50); // x, y, width, height
        add(merciServiziOperaiaPanel);
    }
}

class LavoratoriOperaiaPanel extends JPanel {
    public LavoratoriOperaiaPanel() {
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

class PopolazioneOperaiaPanel extends JPanel{
    public PopolazioneOperaiaPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Popolazione");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10)); // Change size to 20
        setBorder(titledBorder);
        setLayout(new GridLayout(1, 1));
    }
}

class ProsperitaOperaiaPanel extends JPanel {
    public ProsperitaOperaiaPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Prosperità");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10)); // Change size to 20
        setBorder(titledBorder);
        setLayout(new GridLayout(1, 11));

        Font labelFont = new Font("Arial", Font.BOLD, 8);
        
        for (int i = 0; i < 11; i++) {
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

class SindacatiOperaiaPanel extends JPanel {
    public SindacatiOperaiaPanel() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Sindacati");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 10)); // Change size to 20
        setBorder(titledBorder);

        setLayout(new GridLayout(1, 5));

        JPanel agricolturaPanel = createLabelWithBorder("Agri.", Color.GREEN, 7);
        JPanel lussoPanel = createLabelWithBorder("Lus.", Color.BLUE, 7);
        JPanel sanitaPanel = createLabelWithBorder("San.", Color.RED, 7);
        JPanel istruzionePanel = createLabelWithBorder("Istr.", new Color(255, 215, 0), 7); // Gold
        JPanel mediaPanel = createLabelWithBorder("Med.", new Color(215, 15, 255), 7); // Purple
        
        add(agricolturaPanel);
        add(lussoPanel);
        add(sanitaPanel);
        add(istruzionePanel);
        add(mediaPanel);
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

class IntroitiOperaiaPanel extends JPanel {
    public IntroitiOperaiaPanel() {
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

class MerciServiziOperaiaPanel extends JPanel{
    public MerciServiziOperaiaPanel() {
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
