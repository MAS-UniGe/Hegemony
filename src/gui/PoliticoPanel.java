package gui;

import javax.swing.*;
import java.awt.*;

public class PoliticoPanel extends JPanel {
    public PoliticoPanel() {
        setLayout(new BorderLayout());

        // Create panels
        JPanel topPanel = new PolitichePubblichePanel();
        JPanel bottomPanel = new SussidiPanel();

        // Add panels to the layout
        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Set preferred sizes to control proportions
        topPanel.setPreferredSize(new Dimension(0, 300));  // Example ratio: 3/4
        bottomPanel.setPreferredSize(new Dimension(0, 100));  // Example ratio: 1/4
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Example Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.add(new PoliticoPanel());
        frame.setVisible(true);
    }
}

class PolitichePubblichePanel extends JPanel {
    public PolitichePubblichePanel() {
        setBorder(BorderFactory.createTitledBorder("Politiche Pubbliche"));
        setLayout(new GridLayout(7, 2));

        add(new JLabel("BILANCIO"));
        add(new PoliticheLivelliPanel());

        add(new JLabel("MER. DEL LAVORO"));
        add(new PoliticheLivelliPanel());

        add(new JLabel("TASSAZIONE"));
        add(new PoliticheLivelliPanel());

        add(new JLabel("SANITÀ"));
        add(new PoliticheLivelliPanel());

        add(new JLabel("ISTRUZIONE"));
        add(new PoliticheLivelliPanel());

        add(new JLabel("COMMERCIO ESTERO"));
        add(new PoliticheLivelliPanel());

        add(new JLabel("IMMIGRAZIONE"));
        add(new PoliticheLivelliPanel());
    }
}

class PoliticheLivelliPanel extends JPanel{
    public PoliticheLivelliPanel() {
        setBorder(BorderFactory.createTitledBorder("Liv."));
        setLayout(new GridLayout(1, 3));
        add(new JLabel("A"));
        add(new JLabel("B"));
        add(new JLabel("C"));
    }
}

class SussidiPanel extends JPanel{
    public SussidiPanel() {
        setBorder(BorderFactory.createTitledBorder("Sussidi Statali"));
        setLayout(new GridLayout(1, 3));

        JPanel capitalistiPanel = createLabelWithBorder("Capitalisti", Color.BLUE);
        JPanel mediaPanel = createLabelWithBorder("Media", new Color(255, 215, 0)); // Gold
        JPanel operaiPanel = createLabelWithBorder("Operai", Color.RED);

        add(capitalistiPanel);
        add(mediaPanel);
        add(operaiPanel);
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