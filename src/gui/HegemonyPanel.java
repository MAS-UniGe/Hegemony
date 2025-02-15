package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import game_elements.Azienda;
import game_elements.AziendaPiccola;

public class HegemonyPanel extends JLayeredPane {
    private List<Azienda> aziendePrivateStack = new ArrayList<>(); // Stack for private companies
    private List<Azienda> aziendePubblicheStack = new ArrayList<>(); // Stack for public companies
    private List<AziendaPiccola> aziendePiccoleStack = new ArrayList<>(); // Stack for small companies
    //private List<LavoratoriPrivati> lavoratoriPrivatiStack = new ArrayList<>(); // Stack for workers
    //private List<LavoratoriPubblici> lavoratoriPubbliciStack = new ArrayList<>(); // Stack for workers
    //private List<LavoratoriPiccoli> lavoratoriPiccoliStack = new ArrayList<>(); // Stack for workers
    private int proventi_CC = 0; // Variable for money
    private int cibo_CC = 0; // Variable for food
    private JPanel basePanel; // Holds the main layout components

    public HegemonyPanel() {
        // Initialize the main panel with components
        basePanel = new JPanel();
        basePanel.setLayout(null); // Disable the layout manager
        basePanel.setBounds(0, 0, 1500, 700); // Full size of the main window
        add(basePanel, JLayeredPane.DEFAULT_LAYER); // Add it to the base layer

        // Add components with manual positioning: First Column
        MatchControlPart matchControlPart = new MatchControlPart();
        matchControlPart.setBounds(10, 410, 300, 200); // x, y, width, height
        basePanel.add(matchControlPart);

        PoliticoPanel politicoPanel = new PoliticoPanel();
        politicoPanel.setBounds(10, 10, 300, 400); // x, y, width, height
        basePanel.add(politicoPanel);

        // Add components with manual positioning: Second Column
        PrivatoPanel privatoPanel = new PrivatoPanel();
        privatoPanel.setBounds(320, 10, 300, 600); // x, y, width, height
        basePanel.add(privatoPanel);

        // Add components with manual positioning: Third Column
        PubblicoPanel pubblicoPanel = new PubblicoPanel();
        pubblicoPanel.setBounds(630, 10, 230, 500); // x, y, width, height
        basePanel.add(pubblicoPanel);

        LavoratoriPanel lavoratoriPanel = new LavoratoriPanel();
        lavoratoriPanel.setBounds(630, 510, 140, 100); // x, y, width, height
        basePanel.add(lavoratoriPanel);

        ImmigrazionePanel immigrazionePanel = new ImmigrazionePanel();
        immigrazionePanel.setBounds(770, 510, 90, 100); // x, y, width, height
        basePanel.add(immigrazionePanel);

        // Add components with manual positioning: Classi sociali
        PLAYER_OperaiaPanel operaiaPanel = new PLAYER_OperaiaPanel();
        operaiaPanel.setBounds(870, 10, 300, 200); // x, y, width, height

        TitledBorder titledBorderOperaia = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.RED, 2), // Red border
                "Classe Operaia", // Title text
                TitledBorder.CENTER, // Title alignment (centered)
                TitledBorder.TOP, // Title position (on top of the border)
                new Font("Arial", Font.BOLD, 16), // Title font
                Color.RED // Title color
        );
        operaiaPanel.setBorder(titledBorderOperaia);
        basePanel.add(operaiaPanel);

        PLAYER_MediaPanel mediaPanel = new PLAYER_MediaPanel();
        mediaPanel.setBounds(1180, 10, 300, 200); // x, y, width, height

        TitledBorder titledBorderMedia = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(255, 215, 0), 2), // Golden border
                "Classe Media", // Title text
                TitledBorder.CENTER, // Title alignment (centered)
                TitledBorder.TOP, // Title position (on top of the border)
                new Font("Arial", Font.BOLD, 16), // Title font
                new Color(255, 215, 0) // Title color
        );
        mediaPanel.setBorder(titledBorderMedia);
        basePanel.add(mediaPanel);

        PLAYER_CapitalistaPanel capitalistaPanel = new PLAYER_CapitalistaPanel();
        capitalistaPanel.setBounds(870, 220, 300, 200); // x, y, width, height

        TitledBorder titledBorderCapitalista = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE, 2), // Blue border
                "Classe Capitalista", // Title text
                TitledBorder.CENTER, // Title alignment (centered)
                TitledBorder.TOP, // Title position (on top of the border)
                new Font("Arial", Font.BOLD, 16), // Title font
                Color.BLUE // Title color
        );
        capitalistaPanel.setBorder(titledBorderCapitalista);
        basePanel.add(capitalistaPanel);

        PLAYER_StatoPanel statoPanel = new PLAYER_StatoPanel();
        statoPanel.setBounds(1180, 220, 300, 200); // x, y, width, height

        TitledBorder titledBorderStato = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(80, 80, 80), 2), // Grey border
                "Stato", // Title text
                TitledBorder.CENTER, // Title alignment (centered)
                TitledBorder.TOP, // Title position (on top of the border)
                new Font("Arial", Font.BOLD, 16), // Title font
                new Color(80, 80, 80) // Title color
        );
        statoPanel.setBorder(titledBorderStato);
        basePanel.add(statoPanel);

        /*******************
         * DYNAMIC PANELS
         *******************/

        // Add the private stack layer
        AziendePrivatePanel aziendePrivatePanel = new AziendePrivatePanel();
        aziendePrivatePanel.setOpaque(false);
        aziendePrivatePanel.setBounds(320, 10, 300, 600); // Cover the entire area
        add(aziendePrivatePanel, JLayeredPane.PALETTE_LAYER); // Add it to the overlay layer

        // Add the public stack layer
        AziendePubblichePanel aziendePubblichePanel = new AziendePubblichePanel();
        aziendePubblichePanel.setOpaque(false);
        aziendePubblichePanel.setBounds(630, 10, 230, 500); // Cover the entire area
        add(aziendePubblichePanel, JLayeredPane.PALETTE_LAYER); // Add it to the overlay layer

        // Add the private stack layer
        AziendePiccolePanel aziendePiccolePanel = new AziendePiccolePanel();
        aziendePiccolePanel.setOpaque(false);
        aziendePiccolePanel.setBounds(320, 10, 300, 600); // Cover the entire area
        add(aziendePiccolePanel, JLayeredPane.PALETTE_LAYER); // Add it to the overlay layer

        // Add the private workers layer
        PrivateWorkersPanel privateWorkersPanel = new PrivateWorkersPanel();
        privateWorkersPanel.setOpaque(false);
        privateWorkersPanel.setBounds(320, 10, 300, 600); // Cover the entire area
        add(privateWorkersPanel, JLayeredPane.MODAL_LAYER); // Add it to the overlay layer

        // Add the private workers assigned layer
        PrivateWorkersAssignedPanel privateWorkersAssignedPanel = new PrivateWorkersAssignedPanel();
        privateWorkersAssignedPanel.setOpaque(false);
        privateWorkersAssignedPanel.setBounds(320, 10, 300, 600); // Cover the entire area
        add(privateWorkersAssignedPanel, JLayeredPane.POPUP_LAYER); // Add it to the overlay layer

        // Add the public workers layer
        PublicWorkersPanel publicWorkersPanel = new PublicWorkersPanel();
        publicWorkersPanel.setOpaque(false);
        publicWorkersPanel.setBounds(630, 10, 230, 500); // Cover the entire area
        add(publicWorkersPanel, JLayeredPane.MODAL_LAYER); // Add it to the overlay layer

        // Add the public workers assigned layer
        PublicWorkersAssignedPanel publicWorkersAssignedPanel = new PublicWorkersAssignedPanel();
        publicWorkersAssignedPanel.setOpaque(false);
        publicWorkersAssignedPanel.setBounds(630, 10, 230, 500); // Cover the entire area
        add(publicWorkersAssignedPanel, JLayeredPane.POPUP_LAYER); // Add it to the overlay layer

        // Add the private workers layer
        SmallWorkersPanel smallWorkersPanel = new SmallWorkersPanel();
        smallWorkersPanel.setOpaque(false);
        smallWorkersPanel.setBounds(320, 10, 300, 600); // Cover the entire area
        add(smallWorkersPanel, JLayeredPane.MODAL_LAYER); // Add it to the overlay layer

        // Add the private workers assigned layer
        SmallWorkersAssignedPanel smallWorkersAssignedPanel = new SmallWorkersAssignedPanel();
        smallWorkersAssignedPanel.setOpaque(false);
        smallWorkersAssignedPanel.setBounds(320, 10, 300, 600); // Cover the entire area
        add(smallWorkersAssignedPanel, JLayeredPane.POPUP_LAYER); // Add it to the overlay layer

        // Add the proventi_CC layers (capitalist class)
        ProventiPanel_CC proventiPanel_CC = new ProventiPanel_CC();
        proventiPanel_CC.setOpaque(false);
        proventiPanel_CC.setBounds(870, 220, 300, 200); // x, y, width, height
        add(proventiPanel_CC, JLayeredPane.PALETTE_LAYER); // Add it to the overlay layer

        // Add the cibo_CC layers (capitalist class)
        CiboPanel_CC ciboPanel_CC = new CiboPanel_CC();
        ciboPanel_CC.setOpaque(false);
        ciboPanel_CC.setBounds(870, 220, 300, 200); // x, y, width, height
        add(ciboPanel_CC, JLayeredPane.PALETTE_LAYER); // Add it to the overlay layer
    }

    private class AziendePrivatePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw the company stack as an overlay
            int stackStartX = 10; // X-coordinate for the stack area
            int stackStartY = 132; // Y-coordinate for the first company (bottom of the screen)
            int companyWidth = 64; // Width of each company rectangle
            int companyHeight = 74; // Height of each company rectangle
            int spacing = 8; // Spacing between companies
            int vSpacing = 18; // Vertical spacing between companies

            for (int i = 0; i < aziendePrivateStack.size(); i++) {
                Azienda azienda = aziendePrivateStack.get(i);

                // Determine the color based on the industry
                Color companyColor;
                switch (azienda.getIndustria().toLowerCase()) {
                    case "agricoltura":
                        companyColor = Color.GREEN;
                        break;
                    case "lusso":
                        companyColor = Color.BLUE;
                        break;
                    case "sanità":
                        companyColor = Color.RED;
                        break;
                    case "istruzione":
                        companyColor = Color.ORANGE;
                        break;
                    case "media":
                        companyColor = new Color(215, 15, 255); // Purple
                        break;
                    default:
                        companyColor = Color.GRAY; // Default color for other industries
                        break;
                }

                // Calculate position for this company
                int x = stackStartX + (i % 4) * (companyWidth + spacing); // Move horizontally
                int y = stackStartY + (i / 4) * (companyHeight + vSpacing); // Move vertically after every 4 companies

                // Draw company rectangle
                g2d.setColor(companyColor);
                g2d.fillRect(x, y, companyWidth, companyHeight);

                // Draw company name with line breaking if necessary
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Arial", Font.BOLD, 9));

                String companyName = azienda.getNome();
                int maxWidth = companyWidth - 18; // Reserve some space from the left
                String[] words = companyName.split(" ");

                StringBuilder line = new StringBuilder();
                int lineHeight = 0;

                for (String word : words) {
                    // If adding this word exceeds max width, start a new line
                    if (g2d.getFontMetrics().stringWidth(line + word) > maxWidth) {
                        // Draw the current line
                        g2d.drawString(line.toString(), x + 3, y + 15 + lineHeight * 10);
                        line.setLength(0); // Reset the line
                        line.append(word).append(" "); // Start new line with the current word
                        lineHeight++;
                    } else {
                        line.append(word).append(" ");
                    }
                }

                // Draw the last line (in case it's not drawn yet)
                if (line.length() > 0) {
                    g2d.drawString(line.toString(), x + 3, y + 15 + lineHeight * 10);
                }
            }
        }
    }

    // Define the PrivateWorkersPanel as a separate class
    public class PrivateWorkersPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw the company stack as an overlay
            int stackStartX = 10; // X-coordinate for the stack area
            int stackStartY = 132; // Y-coordinate for the first company (bottom of the screen)
            int companyWidth = 64; // Width of each company rectangle
            int companyHeight = 74; // Height of each company rectangle
            int spacing = 8; // Spacing between companies
            int vSpacing = 18; // Vertical spacing between companies

            int miniStackStartX = 15;
            int miniStackStartY = 185;
            int miniWidth = 15;
            int miniHeight = 15;

            for (int i = 0; i < aziendePrivateStack.size(); i++) {
                Azienda azienda = aziendePrivateStack.get(i);

                // Determine the color based on the worker specialization (only the first worker can be specialized)
                Color workerColor;
                Color textColor;
                if (azienda.getRequisiti().size() >= 1) {
                    switch (azienda.getRequisiti().get(0).toLowerCase()) {
                        case "generico (q)":
                            workerColor = Color.WHITE; // Color for generic worker
                            textColor = Color.BLACK;
                            break;
                        default:
                            workerColor = Color.BLACK; // Default color for specialized worker
                            textColor = Color.WHITE;
                            break;
                    }
                } else {
                    workerColor = Color.GRAY; // Color for automatic company
                    textColor = Color.WHITE;
                }

                // Calculate position for these workers
                int x = stackStartX + (i % 4) * (companyWidth + spacing); // Move horizontally
                int y = stackStartY + (i / 4) * (companyHeight + vSpacing); // Move vertically after every 4 companies

                int miniX = miniStackStartX + (i % 4) * (companyWidth + spacing);
                int miniY = miniStackStartY + (i / 4) * (companyHeight + vSpacing);

                // Draw first worker rectangle
                g2d.setColor(workerColor);
                g2d.fillRect(miniX, miniY, miniWidth, miniHeight);

                // Draw second worker rectangle
                if(azienda.getRequisiti().size() >= 2) {
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(miniX+20, miniY, miniWidth, miniHeight);
                }

                // Draw third worker rectangle
                if(azienda.getRequisiti().size() >= 3) {
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(miniX+40, miniY, miniWidth, miniHeight);
                }

                // Draw first worker name
                g2d.setColor(textColor);
                g2d.setFont(new Font("Arial", Font.BOLD, 9));
                if (workerColor == Color.GRAY) {
                    g2d.drawString("A", miniX+4, miniY+10);
                }
                else {
                    g2d.drawString("q", miniX+4, miniY+10);
                }

                // Draw second worker name
                if(azienda.getRequisiti().size() >= 2) {
                    g2d.setColor(Color.BLACK);
                    g2d.setFont(new Font("Arial", Font.BOLD, 9));
                    g2d.drawString("q", miniX+24, miniY+10);
                }

                // Draw third worker name
                if(azienda.getRequisiti().size() >= 3) {
                    g2d.setColor(Color.BLACK);
                    g2d.setFont(new Font("Arial", Font.BOLD, 9));
                    g2d.drawString("q", miniX+44, miniY+10);
                }
            }
        }
    }

    // Define the PrivateWorkersPanel as a separate class
    public class PrivateWorkersAssignedPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw the company stack as an overlay
            int stackStartX = 10; // X-coordinate for the stack area
            int stackStartY = 132; // Y-coordinate for the first company (bottom of the screen)
            int companyWidth = 64; // Width of each company rectangle
            int companyHeight = 74; // Height of each company rectangle
            int spacing = 8; // Spacing between companies
            int vSpacing = 18; // Vertical spacing between companies

            int miniStackStartX = 17;
            int miniStackStartY = 187;
            int miniWidth = 11;
            int miniHeight = 11;

            for (int i = 0; i < aziendePrivateStack.size(); i++) {
                Azienda azienda = aziendePrivateStack.get(i);

                // Determine the color based on the worker specialization (only the first worker can be specialized)
                Color workerColor;
                Color textColor;
                if (azienda.getLavoratori().size() >= 1) {
                    switch (azienda.getLavoratori().get(0).toLowerCase()) {
                        case "agricoltura (m)":
                        case "agricoltura (o)":
                            workerColor = Color.GREEN;
                            break;
                        case "lusso (m)":
                        case "lusso (o)":
                            workerColor = Color.BLUE;
                            break;
                        case "sanità (m)":
                        case "sanità (o)":
                            workerColor = Color.RED;
                            break;
                        case "istruzione (m)":
                        case "istruzione (o)":
                            workerColor = Color.ORANGE;
                            break;
                        case "media (m)":
                        case "media (o)":
                            workerColor = new Color(215, 15, 255); // Purple
                            break;
                        default:
                            workerColor = Color.GRAY; // Default color for generic worker
                            break;
                    }
                } else {
                    workerColor = Color.WHITE; // Color for automatic company
                }

                // Calculate position for these workers
                int x = stackStartX + (i % 4) * (companyWidth + spacing); // Move horizontally
                int y = stackStartY + (i / 4) * (companyHeight + vSpacing); // Move vertically after every 4 companies

                int miniX = miniStackStartX + (i % 4) * (companyWidth + spacing);
                int miniY = miniStackStartY + (i / 4) * (companyHeight + vSpacing);

                // Draw first worker rectangle
                if(azienda.getLavoratori().size() >= 1) {
                g2d.setColor(workerColor);
                g2d.fillRect(miniX, miniY, miniWidth, miniHeight);
                }

                // Draw second worker rectangle
                if(azienda.getLavoratori().size() >= 2) {
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(miniX+20, miniY, miniWidth, miniHeight);
                }

                // Draw third worker rectangle
                if(azienda.getLavoratori().size() >= 3) {
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(miniX+40, miniY, miniWidth, miniHeight);
                }
            }
        }
    }

    // Adds a private company to the stack and updates the display
    public void addPrivateCompanyToStack(Azienda azienda) {
        if (aziendePrivateStack.size() < 12) { // Limit to 12 companies
            aziendePrivateStack.add(azienda);
            repaint(); // Refresh the panel to display the updated stack
        }
    }

    // Removes a private company from the stack and shifts others up
    public void removePrivateCompanyFromStack(Azienda azienda) {
        aziendePrivateStack.remove(azienda);
        repaint(); // Refresh the panel to reflect changes
    }

    private class AziendePubblichePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw the company stack as an overlay
            int stackStartX = 9; // X-coordinate for the stack area
            int stackStartY = 233; // Y-coordinate for the first company (bottom of the screen)
            int companyWidth = 65; // Width of each company rectangle
            int companyHeight = 73; // Height of each company rectangle
            int spacing = 8; // Spacing between companies
            int vSpacing = 19; // Vertical spacing between companies

            for (int i = 0; i < aziendePubblicheStack.size(); i++) {
                Azienda azienda = aziendePubblicheStack.get(i);

                // Determine the color based on the industry
                Color companyColor;
                switch (azienda.getIndustria().toLowerCase()) {
                    case "agricoltura":
                        companyColor = Color.GREEN;
                        break;
                    case "lusso":
                        companyColor = Color.BLUE;
                        break;
                    case "sanità":
                        companyColor = Color.RED;
                        break;
                    case "istruzione":
                        companyColor = Color.ORANGE;
                        break;
                    case "media":
                        companyColor = new Color(215, 15, 255); // Purple
                        break;
                    default:
                        companyColor = Color.GRAY; // Default color for other industries
                        break;
                }

                // Calculate position for this company
                int x = stackStartX + (i % 3) * (companyWidth + spacing); // Move horizontally
                int y = stackStartY + (i / 3) * (companyHeight + vSpacing); // Move vertically after every 4 companies

                // Draw company rectangle
                g2d.setColor(companyColor);
                g2d.fillRect(x, y, companyWidth, companyHeight);

                // Draw company name with line breaking if necessary
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Arial", Font.BOLD, 9));

                String companyName = azienda.getNome();
                int maxWidth = companyWidth - 18; // Reserve some space from the left
                String[] words = companyName.split(" ");

                StringBuilder line = new StringBuilder();
                int lineHeight = 0;

                for (String word : words) {
                    // If adding this word exceeds max width, start a new line
                    if (g2d.getFontMetrics().stringWidth(line + word) > maxWidth) {
                        // Draw the current line
                        g2d.drawString(line.toString(), x + 3, y + 15 + lineHeight * 10);
                        line.setLength(0); // Reset the line
                        line.append(word).append(" "); // Start new line with the current word
                        lineHeight++;
                    } else {
                        line.append(word).append(" ");
                    }
                }

                // Draw the last line (in case it's not drawn yet)
                if (line.length() > 0) {
                    g2d.drawString(line.toString(), x + 3, y + 15 + lineHeight * 10);
                }
            }
        }
    }

    // Define the PublicWorkersPanel as a separate class
    public class PublicWorkersPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw the company stack as an overlay
            int stackStartX = 9; // X-coordinate for the stack area
            int stackStartY = 233; // Y-coordinate for the first company (bottom of the screen)
            int companyWidth = 65; // Width of each company rectangle
            int companyHeight = 73; // Height of each company rectangle
            int spacing = 8; // Spacing between companies
            int vSpacing = 19; // Vertical spacing between companies

            int miniStackStartX = 15;
            int miniStackStartY = 285;
            int miniWidth = 15;
            int miniHeight = 15;

            for (int i = 0; i < aziendePubblicheStack.size(); i++) {
                Azienda azienda = aziendePubblicheStack.get(i);

                // Determine the color based on the worker specialization (only the first worker can be specialized)
                Color workerColor;
                Color textColor;
                if (azienda.getRequisiti().size() >= 1) {
                    switch (azienda.getRequisiti().get(0).toLowerCase()) {
                        case "generico (q)":
                            workerColor = Color.WHITE; // Color for generic worker
                            textColor = Color.BLACK;
                            break;
                        default:
                            workerColor = Color.BLACK; // Default color for specialized worker
                            textColor = Color.WHITE;
                            break;
                    }
                } else {
                    workerColor = Color.GRAY; // Color for automatic company
                    textColor = Color.WHITE;
                }

                // Calculate position for these workers
                int x = stackStartX + (i % 3) * (companyWidth + spacing); // Move horizontally
                int y = stackStartY + (i / 3) * (companyHeight + vSpacing); // Move vertically after every 4 companies

                int miniX = miniStackStartX + (i % 3) * (companyWidth + spacing);
                int miniY = miniStackStartY + (i / 3) * (companyHeight + vSpacing);

                // Draw first worker rectangle
                g2d.setColor(workerColor);
                g2d.fillRect(miniX, miniY, miniWidth, miniHeight);

                // Draw second worker rectangle
                if(azienda.getRequisiti().size() >= 2) {
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(miniX+20, miniY, miniWidth, miniHeight);
                }

                // Draw third worker rectangle
                if(azienda.getRequisiti().size() >= 3) {
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(miniX+40, miniY, miniWidth, miniHeight);
                }

                // Draw first worker name
                g2d.setColor(textColor);
                g2d.setFont(new Font("Arial", Font.BOLD, 9));
                if (workerColor == Color.WHITE) {
                    g2d.drawString("A", miniX+4, miniY+10);
                }
                else {
                    g2d.drawString("q", miniX+4, miniY+10);
                }

                // Draw second worker name
                if(azienda.getRequisiti().size() >= 2) {
                    g2d.setColor(Color.BLACK);
                    g2d.setFont(new Font("Arial", Font.BOLD, 9));
                    g2d.drawString("q", miniX+24, miniY+10);
                }

                // Draw third worker name
                if(azienda.getRequisiti().size() >= 3) {
                    g2d.setColor(Color.BLACK);
                    g2d.setFont(new Font("Arial", Font.BOLD, 9));
                    g2d.drawString("q", miniX+44, miniY+10);
                }
            }
        }
    }

    // Define the PublicWorkersPanel as a separate class
    public class PublicWorkersAssignedPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw the company stack as an overlay
            int stackStartX = 9; // X-coordinate for the stack area
            int stackStartY = 233; // Y-coordinate for the first company (bottom of the screen)
            int companyWidth = 65; // Width of each company rectangle
            int companyHeight = 73; // Height of each company rectangle
            int spacing = 8; // Spacing between companies
            int vSpacing = 19; // Vertical spacing between companies

            int miniStackStartX = 17;
            int miniStackStartY = 287;
            int miniWidth = 11;
            int miniHeight = 11;

            for (int i = 0; i < aziendePubblicheStack.size(); i++) {
                Azienda azienda = aziendePubblicheStack.get(i);

                // Determine the color based on the worker specialization (only the first worker can be specialized)
                Color workerColor;
                Color textColor;
                if (azienda.getLavoratori().size() >= 1) {
                    switch (azienda.getLavoratori().get(0).toLowerCase()) {
                        case "agricoltura (m)":
                        case "agricoltura (o)":
                            workerColor = Color.GREEN;
                            break;
                        case "lusso (m)":
                        case "lusso (o)":
                            workerColor = Color.BLUE;
                            break;
                        case "sanità (m)":
                        case "sanità (o)":
                            workerColor = Color.RED;
                            break;
                        case "istruzione (m)":
                        case "istruzione (o)":
                            workerColor = Color.ORANGE;
                            break;
                        case "media (m)":
                        case "media (o)":
                            workerColor = new Color(215, 15, 255); // Purple
                            break;
                        default:
                            workerColor = Color.GRAY; // Default color for generic worker
                            break;
                    }
                } else {
                    workerColor = Color.WHITE; // Color for automatic company
                }

                // Calculate position for these workers
                int x = stackStartX + (i % 3) * (companyWidth + spacing); // Move horizontally
                int y = stackStartY + (i / 3) * (companyHeight + vSpacing); // Move vertically after every 4 companies

                int miniX = miniStackStartX + (i % 3) * (companyWidth + spacing);
                int miniY = miniStackStartY + (i / 3) * (companyHeight + vSpacing);

                // Draw first worker rectangle
                if(azienda.getLavoratori().size() >= 1) {
                g2d.setColor(workerColor);
                g2d.fillRect(miniX, miniY, miniWidth, miniHeight);
                }

                // Draw second worker rectangle
                if(azienda.getLavoratori().size() >= 2) {
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(miniX+20, miniY, miniWidth, miniHeight);
                }

                // Draw third worker rectangle
                if(azienda.getLavoratori().size() >= 3) {
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(miniX+40, miniY, miniWidth, miniHeight);
                }
            }
        }
    }

    // Adds a public company to the stack and updates the display
    public void addPublicCompanyToStack(Azienda azienda) {
        if (aziendePubblicheStack.size() < 9) {
            aziendePubblicheStack.add(azienda);
            repaint(); // Refresh the panel to display the updated stack
        }
    }

    // Removes a public company from the stack and shifts others up
    public void removePublicCompanyFromStack(Azienda azienda) {
        aziendePubblicheStack.remove(azienda);
        repaint(); // Refresh the panel to reflect changes
    }

    private class AziendePiccolePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw the company stack as an overlay
            int stackStartX = 10; // X-coordinate for the stack area
            int stackStartY = 428; // Y-coordinate for the first company (bottom of the screen)
            int companyWidth = 64; // Width of each company rectangle
            int companyHeight = 74; // Height of each company rectangle
            int spacing = 8; // Spacing between companies
            int vSpacing = 18; // Vertical spacing between companies

            for (int i = 0; i < aziendePiccoleStack.size(); i++) {
                AziendaPiccola azienda = aziendePiccoleStack.get(i);

                // Determine the color based on the industry
                Color companyColor;
                switch (azienda.getIndustria().toLowerCase()) {
                    case "agricoltura":
                        companyColor = Color.GREEN;
                        break;
                    case "lusso":
                        companyColor = Color.BLUE;
                        break;
                    case "sanità":
                        companyColor = Color.RED;
                        break;
                    case "istruzione":
                        companyColor = Color.ORANGE;
                        break;
                    case "media":
                        companyColor = new Color(215, 15, 255); // Purple
                        break;
                    default:
                        companyColor = Color.GRAY; // Default color for other industries
                        break;
                }

                // Calculate position for this company
                int x = stackStartX + (i % 4) * (companyWidth + spacing); // Move horizontally
                int y = stackStartY + (i / 4) * (companyHeight + vSpacing); // Move vertically after every 4 companies

                // Draw company rectangle
                g2d.setColor(companyColor);
                g2d.fillRect(x, y, companyWidth, companyHeight);

                // Draw company name with line breaking if necessary
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Arial", Font.BOLD, 9));

                String companyName = azienda.getNome();
                int maxWidth = companyWidth - 18; // Reserve some space from the left
                String[] words = companyName.split(" ");

                StringBuilder line = new StringBuilder();
                int lineHeight = 0;

                for (String word : words) {
                    // If adding this word exceeds max width, start a new line
                    if (g2d.getFontMetrics().stringWidth(line + word) > maxWidth) {
                        // Draw the current line
                        g2d.drawString(line.toString(), x + 3, y + 15 + lineHeight * 10);
                        line.setLength(0); // Reset the line
                        line.append(word).append(" "); // Start new line with the current word
                        lineHeight++;
                    } else {
                        line.append(word).append(" ");
                    }
                }

                // Draw the last line (in case it's not drawn yet)
                if (line.length() > 0) {
                    g2d.drawString(line.toString(), x + 3, y + 15 + lineHeight * 10);
                }
            }
        }
    }

    // Define the SmallWorkersPanel as a separate class
    public class SmallWorkersPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw the company stack as an overlay
            int stackStartX = 10; // X-coordinate for the stack area
            int stackStartY = 428; // Y-coordinate for the first company (bottom of the screen)
            int companyWidth = 64; // Width of each company rectangle
            int companyHeight = 74; // Height of each company rectangle
            int spacing = 8; // Spacing between companies
            int vSpacing = 18; // Vertical spacing between companies

            int miniStackStartX = 15;
            int miniStackStartY = 481;
            int miniWidth = 15;
            int miniHeight = 15;

            for (int i = 0; i < aziendePiccoleStack.size(); i++) {
                AziendaPiccola azienda = aziendePiccoleStack.get(i);

                // Determine the color based on the worker specialization (only the first worker can be specialized)
                Color workerColor;
                Color textColor;
                
                switch (azienda.getRequisiti().get(0).toLowerCase()) {
                    case "generico (m)":
                        workerColor = Color.WHITE; // Color for generic worker
                        textColor = Color.BLACK;
                        break;
                    default:
                        workerColor = Color.BLACK; // Default color for specialized worker
                        textColor = Color.WHITE;
                        break;
                }

                // Calculate position for these workers
                int x = stackStartX + (i % 4) * (companyWidth + spacing); // Move horizontally
                int y = stackStartY + (i / 4) * (companyHeight + vSpacing); // Move vertically after every 4 companies

                int miniX = miniStackStartX + (i % 4) * (companyWidth + spacing);
                int miniY = miniStackStartY + (i / 4) * (companyHeight + vSpacing);

                // Draw first worker rectangle
                g2d.setColor(workerColor);
                g2d.fillRect(miniX, miniY, miniWidth, miniHeight);

                // Draw second worker rectangle
                if(azienda.getRequisiti().size() >= 2) {
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(miniX+20, miniY, miniWidth, miniHeight);
                }

                // Draw third worker rectangle
                if(azienda.getRequisiti().size() >= 3) {
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(miniX+40, miniY, miniWidth, miniHeight);
                }

                // Draw first worker name
                g2d.setColor(textColor);
                g2d.setFont(new Font("Arial", Font.BOLD, 9));
                g2d.drawString("m", miniX+2, miniY+11);

                // Draw second worker name
                if(azienda.getRequisiti().size() >= 2) {
                    g2d.setColor(Color.BLACK);
                    g2d.setFont(new Font("Arial", Font.BOLD, 9));
                    g2d.drawString("m", miniX+22, miniY+11);
                }

                // Draw third worker name
                if(azienda.getRequisiti().size() >= 3) {
                    g2d.setColor(Color.BLACK);
                    g2d.setFont(new Font("Arial", Font.BOLD, 9));
                    g2d.drawString("m", miniX+42, miniY+11);
                }
            }
        }
    }

    // Define the SmallWorkersPanel as a separate class
    public class SmallWorkersAssignedPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw the company stack as an overlay
            int stackStartX = 10; // X-coordinate for the stack area
            int stackStartY = 428; // Y-coordinate for the first company (bottom of the screen)
            int companyWidth = 64; // Width of each company rectangle
            int companyHeight = 74; // Height of each company rectangle
            int spacing = 8; // Spacing between companies
            int vSpacing = 18; // Vertical spacing between companies

            int miniStackStartX = 17;
            int miniStackStartY = 483;
            int miniWidth = 11;
            int miniHeight = 11;

            for (int i = 0; i < aziendePiccoleStack.size(); i++) {
                AziendaPiccola azienda = aziendePiccoleStack.get(i);

                // Determine the color based on the worker specialization (only the first worker can be specialized)
                Color workerColor;
                Color textColor;
                if (azienda.getLavoratori().size() >= 1) {
                    switch (azienda.getLavoratori().get(0).toLowerCase()) {
                        case "agricoltura (m)":
                            workerColor = Color.GREEN;
                            break;
                        case "lusso (m)":
                            workerColor = Color.BLUE;
                            break;
                        case "sanità (m)":
                            workerColor = Color.RED;
                            break;
                        case "istruzione (m)":
                            workerColor = Color.ORANGE;
                            break;
                        case "media (m)":
                            workerColor = new Color(215, 15, 255); // Purple
                            break;
                        default:
                            workerColor = Color.GRAY; // Default color for generic worker
                            break;
                    }
                } else {
                    workerColor = Color.WHITE; // Color for automatic company
                }

                // Calculate position for these workers
                int x = stackStartX + (i % 4) * (companyWidth + spacing); // Move horizontally
                int y = stackStartY + (i / 4) * (companyHeight + vSpacing); // Move vertically after every 4 companies

                int miniX = miniStackStartX + (i % 4) * (companyWidth + spacing);
                int miniY = miniStackStartY + (i / 4) * (companyHeight + vSpacing);

                // Draw first worker rectangle
                if(azienda.getLavoratori().size() >= 1) {
                g2d.setColor(workerColor);
                g2d.fillRect(miniX, miniY, miniWidth, miniHeight);
                }

                // Draw second worker rectangle
                if(azienda.getLavoratori().size() >= 2) {
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(miniX+20, miniY, miniWidth, miniHeight);
                }

                // Draw third worker rectangle
                if(azienda.getLavoratori().size() >= 3) {
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(miniX+40, miniY, miniWidth, miniHeight);
                }
            }
        }
    }

    // Adds a small company to the stack and updates the display
    public void addSmallCompanyToStack(AziendaPiccola azienda) {
        if (aziendePiccoleStack.size() < 8) { // Limit to 8 companies
            aziendePiccoleStack.add(azienda);
            repaint(); // Refresh the panel to display the updated stack
        }
    }

    // Removes a private company from the stack and shifts others up
    public void removeSmallCompanyFromStack(AziendaPiccola azienda) {
        aziendePiccoleStack.remove(azienda);
        repaint(); // Refresh the panel to reflect changes
    }

    private class ProventiPanel_CC extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int x = 60; // X-coordinate
            int y = 45; // Y-coordinate
            int width = 20; // Width
            int height = 15; // Height

            int money = proventi_CC; // Get the current money value

            // Draw the money amount
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 16));

            // Calculate text position to center it inside the rectangle
            FontMetrics metrics = g2d.getFontMetrics();
            String text = "$" + money;
            int textX = x + (width - metrics.stringWidth(text)) / 2;
            int textY = y + (height - metrics.getHeight()) / 2 + metrics.getAscent();

            g2d.drawString(text, textX, textY);
        }
    }

    // Modify the amount of money and repaint the panel
    public void modifyMoney(int money) {
        proventi_CC = money;
        repaint(); // Refresh the panel to reflect changes
    }

    private class CiboPanel_CC extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int x = 28; // X-coordinate
            int y = 155; // Y-coordinate
            int width = 20; // Width
            int height = 15; // Height

            int food = cibo_CC;

            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 20));

            // Calculate text position to center it inside the rectangle
            FontMetrics metrics = g2d.getFontMetrics();
            String text = "" + food;
            int textX = x + (width - metrics.stringWidth(text)) / 2;
            int textY = y + (height - metrics.getHeight()) / 2 + metrics.getAscent();

            g2d.drawString(text, textX, textY);
        }
    }

    // Modify the amount of money and repaint the panel
    public void modifyFood(int food) {
        cibo_CC = food;
        repaint(); // Refresh the panel to reflect changes
    }
}
