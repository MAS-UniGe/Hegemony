package gui;

import javax.swing.*;
import java.awt.*;

public class MatchControlPart extends JPanel {
    public MatchControlPart() {
        setLayout(new GridLayout(3, 1));

        add(new JLabel("Contatore Round: 0"));
        add(new JLabel("Moltiplicatore Fiscale: 1"));
        add(new VotazioniPanel());
    }
}

class VotazioniPanel extends JPanel {
    public VotazioniPanel() {
        setBorder(BorderFactory.createTitledBorder("Risultati Votazioni"));
        setLayout(new GridLayout(1, 2));

        JPanel favorevoliPanel = createLabelWithBorder("Favorevoli", Color.GREEN);
        JPanel contrariPanel = createLabelWithBorder("Contrari", Color.RED);

        add(favorevoliPanel);
        add(contrariPanel);
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
