import jason.environment.Environment;
import jason.asSyntax.*;
import jason.stdlib.*;
import jason.functions.*;
import javax.swing.*;

import java.util.ArrayList; // for interaction with the game elements
import java.util.List;      
import java.util.Random;    // for random worker selection


import java.io.BufferedReader; // for the executeScript action
import java.io.InputStreamReader;

import gui.HegemonyPanel;

import game_elements.Azienda;
import game_elements.Azienda.BonusProduzione;
import game_elements.Azienda.Produzione;

import game_elements.AziendaPiccola;
import game_elements.AziendaPiccola.BonusProduzionePiccola;
import game_elements.AziendaPiccola.ProduzionePiccola;

public class HegemonyEnv extends Environment {
    private static HegemonyPanel panel;
    private Random randomGenerator = new Random();

    @Override
    public void init(String[] args) {
        // Create and initialize the main panel
        panel = new HegemonyPanel();

        // Setup the JFrame
        JFrame frame = new JFrame("Hegemony Environment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        // Set a preferred window size
        frame.setSize(1500, 700);
        frame.setVisible(true);
    }

    // DEFINE GAME ELEMENTS
    // Aziende (private, pubbliche e piccole)
    private List<Azienda> aziendePrivate = new ArrayList<>();
    private List<Azienda> aziendePubbliche = new ArrayList<>();
    private List<AziendaPiccola> aziendePiccole = new ArrayList<>();

    // variables (common pool)
    private int segnaliniCibo;
    private int segnaliniLusso;
    private int segnaliniSanita;
    private int segnaliniIstruzione;
    private int segnaliniMacchinario;
    private int segnaliniManifestazione;
    private int segnaliniSciopero;
    private int segnaliniVardis; // rappresentano il denaro di gioco: per semplicità, non differenziamo le diverse taglie dei segnalini
    private int segnaliniLegittimitaOperaia;
    private int segnaliniLegittimitaMedia;
    private int segnaliniLegittimitaCapitalista;

    // variables (public services)
    private int serviziPubblici_Sanità;
    private int serviziPubblici_Istruzione;
    private int serviziPubblici_Influenza;

    //variables (worker pool)
    private int lavoratoriMediGenerici;
    private int lavoratoriMediAgrario;
    private int lavoratoriMediLusso;
    private int lavoratoriMediSanita;
    private int lavoratoriMediIstruzione;
    private int lavoratoriMediMedia;
    private int lavoratoriOperaiGenerici;
    private int lavoratoriOperaiAgrario;
    private int lavoratoriOperaiLusso;
    private int lavoratoriOperaiSanita;
    private int lavoratoriOperaiIstruzione;
    private int lavoratoriOperaiMedia;

    // variables (cubetti voto e influenza)
    private int cubettiVotoBlu;
    private int cubettiVotoRosso;
    private int cubettiVotoGiallo;
    private int cubettiInfluenza;
    private int riservaVotoBlu;
    private int riservaVotoRosso;
    private int riservaVotoGiallo;
    private int riservaInfluenza;

    // variables (Classe Capitalista)
    private int proventi_CC;
    private int capitale_CC;
    private int cibo_CC;
    private int lusso_CC;
    private int sanita_CC;
    private int istruzione_CC;
    private int influenza_CC;
    private int prezzoCibo_CC;
    private int prezzoLusso_CC;
    private int prezzoSanita_CC;
    private int prezzoIstruzione_CC;
    private int ricchezza_CC;
    // Va aggiunta la variabile "azioni_CC" per tenere traccia delle azioni disponibili.
    // Va aggiunta la variabile "mercato_CC" per tenere traccia delle proprie Aziende.

    // variables (Classe Operaia)
    private int popolazione_CO;
    private int prosperita_CO;
    private int introiti_CO;
    private int cibo_CO;
    private int lusso_CO;
    private int sanita_CO;
    private int istruzione_CO;
    private int influenza_CO;
    private boolean sindacatoAgricoltura_CO = false;
    private boolean sindacatoLusso_CO = false;
    private boolean sindacatoSanita_CO = false;
    private boolean sindacatoIstruzione_CO = false;
    private boolean sindacatoMedia_CO = false;

    // variables (Classe Media)
    private int popolazione_CM = 10;
    private int prosperita_CM = 0;
    private int introiti_CM = 40;
    private int cibo_CM = 1;
    private int sanita_CM = 1;
    private int lusso_CM = 0;
    private int istruzione_CM = 0;
    private int influenza_CM = 0;
    private int prezzoCibo_CM = 12;
    private int prezzoSanita_CM = 8;
    private int prezzoLusso_CM = 8;
    private int prezzoIstruzione_CM = 8;

    // variables (Classe Stato)
    private int legittimitaCapitalista = 2;
    private int legittimitaOperaia = 2;
    private int legittimitaMedia = 2;
    private int cibo_Stato = 0;
    private int lusso_Stato = 0;
    private int influenza_Stato = 1;

    @Override
    public boolean executeAction(String agName, Structure action) {
        switch (action.getFunctor()) {
            case "executeScript": {
                String scriptPath = action.getTerm(0).toString().replace("\"", "");
                String logEntry = action.getTerm(1).toString().replace("\"", "");

                ProcessBuilder processBuilder = new ProcessBuilder("python3", scriptPath, logEntry);
                try {
                    Process process = processBuilder.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    StringBuilder output = new StringBuilder();
                    String line;
            
                    while ((line = reader.readLine()) != null) {
                        output.append(line).append(" ");
                    }
            
                    process.waitFor();

                    String finalOutput = output.toString().trim();
                    // System.out.println("Python script output: " + finalOutput);

                    // Store the result as a belief in Jason
                    addPercept(agName, Literal.parseLiteral("script_output(\"" + finalOutput + "\")"));

                } catch (Exception e) {
                    System.out.println("Error in executeScript: " + e.getMessage());
                    return true;
                }
                
                // Return output as a Jason term
                return true; // new StringTermImpl(output.toString().trim());
            }

            /*************************************************************
             * PRIVATE COMPANIES
             *************************************************************/
            // Create a new private company
            case "createPrivateCompany": {
                String nome = action.getTerm(0).toString().replace("\"", "");
                String industry = action.getTerm(1).toString().replace("\"", "");
                int costo = Integer.parseInt(action.getTerm(2).toString());

                // Parse requisiti
                List<String> requisiti = new ArrayList<>();
                Term term1 = action.getTerm(3);
                if (term1.isList()) {
                    ListTerm listTerm = (ListTerm) term1;
                    for (Term t : listTerm) {
                        String workerType = t.toString().replace("\"", "");
                        requisiti.add(workerType);
                    }
                }

                int salary1 = Integer.parseInt(action.getTerm(4).toString());
                int salary2 = Integer.parseInt(action.getTerm(5).toString());
                int salary3 = Integer.parseInt(action.getTerm(6).toString());
                int level = Integer.parseInt(action.getTerm(7).toString());

                // Parse bonusProduzione
                List<BonusProduzione> bonusProduzione = new ArrayList<>();
                Term term2 = action.getTerm(8);
                if (term2.isList()) {
                    ListTerm listTerm2 = (ListTerm) term2;
                    for (Term t : listTerm2) {
                        if (t instanceof Literal) {
                            Literal literal = (Literal) t;
                            String bonusType = literal.getTerm(0).toString().replace("\"", "");
                            int bonusValue = Integer.parseInt(literal.getTerm(1).toString());
                            bonusProduzione.add(new Azienda.BonusProduzione(bonusType, bonusValue));
                        }
                    }
                }

                boolean macchinario = Boolean.parseBoolean(action.getTerm(9).toString());

                // Parse produzione
                List<Produzione> produzione = new ArrayList<>();
                Term term3 = action.getTerm(10);
                if (term3.isList()) {
                    ListTerm listTerm3 = (ListTerm) term3;
                    for (Term t : listTerm3) {
                        if (t instanceof Literal) {
                            Literal literal = (Literal) t;
                            String type = literal.getTerm(0).toString().replace("\"", "");
                            int value = Integer.parseInt(literal.getTerm(1).toString());
                            produzione.add(new Azienda.Produzione(type, value));
                        }
                    }
                }

                // Parse lavoratori
                List<String> lavoratori = new ArrayList<>();
                Term term4 = action.getTerm(11);
                if (term4.isList()) {
                    ListTerm listTerm4 = (ListTerm) term4;
                    for (Term t : listTerm4) {
                        String workerType = t.toString().replace("\"", "");
                        lavoratori.add(workerType);
                    }
                }

                // Create and add the private company
                Azienda aziendaPrivata = new Azienda(
                    nome, industry, costo, requisiti,
                    salary1, salary2, salary3, level,
                    bonusProduzione, macchinario, produzione, lavoratori
                );
                aziendePrivate.add(aziendaPrivata);

                // Notify the GUI
                panel.addPrivateCompanyToStack(aziendaPrivata);

                // Print to Jason console
                // this.getLogger().info("Dettagli: " + aziendaPrivata.toString());
                return true;
            }

            // Remove a private company from the stack
            case "removePrivateCompany": {
                String companyName = action.getTerm(0).toString().replace("\"", "");
            
                // Find the company in the stack by name
                Azienda target = null;
                for (Azienda aziendaPrivata : aziendePrivate) {
                    if (aziendaPrivata.getNome().equals(companyName)) {
                        target = aziendaPrivata;
                        break;
                    }
                }
            
                if (target != null) {
                    // Remove the company from the stack and update GUI
                    aziendePrivate.remove(target);
                    panel.removePrivateCompanyFromStack(target);
            
                    // Log success to Jason
                    System.out.println("[" + agName + "] Azienda rimossa: " + target.getNome());
                    return true;
                } else {
                    // Log failure if company not found
                    System.out.println("[" + agName + "] Azienda non trovata: " + companyName);
                    return false;
                }
            }

            // Print all private companies
            case "printPrivateCompanies": {
                if (aziendePrivate.isEmpty()) {
                    System.out.println("[" + agName + "] Nessuna Azienda da stampare.");
                } else {
                    for (Azienda aziendaPrivata : aziendePrivate) {
                        System.out.println("[" + agName + "] " + aziendaPrivata.toString());
                    }
                }
                return true;
            }

            /*************************************************************
             * PUBLIC COMPANIES
             *************************************************************/
            // Create a new public company
            case "createPublicCompany": {
                String nome = action.getTerm(0).toString().replace("\"", "");
                String industry = action.getTerm(1).toString().replace("\"", "");
                int costo = Integer.parseInt(action.getTerm(2).toString());

                // Parse requisiti
                List<String> requisiti = new ArrayList<>();
                Term term1 = action.getTerm(3);
                if (term1.isList()) {
                    ListTerm listTerm1 = (ListTerm) term1;
                    for (Term t : listTerm1) {
                        String workerType = t.toString().replace("\"", "");
                        requisiti.add(workerType);
                    }
                }

                int salary1 = Integer.parseInt(action.getTerm(4).toString());
                int salary2 = Integer.parseInt(action.getTerm(5).toString());
                int salary3 = Integer.parseInt(action.getTerm(6).toString());
                int level = Integer.parseInt(action.getTerm(7).toString());

                // Parse bonusProduzione
                List<BonusProduzione> bonusProduzione = new ArrayList<>();
                Term term2 = action.getTerm(8);
                if (term2.isList()) {
                    ListTerm listTerm2 = (ListTerm) term2;
                    for (Term t : listTerm2) {
                        if (t instanceof Literal) {
                            Literal literal = (Literal) t;
                            String bonusType = literal.getTerm(0).toString().replace("\"", "");
                            int bonusValue = Integer.parseInt(literal.getTerm(1).toString());
                            bonusProduzione.add(new Azienda.BonusProduzione(bonusType, bonusValue));
                        }
                    }
                }

                boolean macchinario = Boolean.parseBoolean(action.getTerm(9).toString());

                // Parse produzione
                List<Produzione> produzione = new ArrayList<>();
                Term term3 = action.getTerm(10);
                if (term3.isList()) {
                    ListTerm listTerm3 = (ListTerm) term3;
                    for (Term t : listTerm3) {
                        if (t instanceof Literal) {
                            Literal literal = (Literal) t;
                            String type = literal.getTerm(0).toString().replace("\"", "");
                            int value = Integer.parseInt(literal.getTerm(1).toString());
                            produzione.add(new Azienda.Produzione(type, value));
                        }
                    }
                }

                // Parse lavoratori
                List<String> lavoratori = new ArrayList<>();
                Term term4 = action.getTerm(11);
                if (term4.isList()) {
                    ListTerm listTerm4 = (ListTerm) term4;
                    for (Term t : listTerm4) {
                        String workerType = t.toString().replace("\"", "");
                        lavoratori.add(workerType);
                    }
                }

                // Create and add the public company
                Azienda aziendaPubblica = new Azienda(
                    nome, industry, costo, requisiti,
                    salary1, salary2, salary3, level,
                    bonusProduzione, macchinario, produzione, lavoratori
                );
                aziendePubbliche.add(aziendaPubblica);

                // Notify the GUI
                panel.addPublicCompanyToStack(aziendaPubblica);

                // Print to Jason console
                // this.getLogger().info("Dettagli: " + aziendaPubblica.toString());
                return true;
            }

            // Remove a public company from the stack
            case "removePublicCompany": {
                String companyName = action.getTerm(0).toString().replace("\"", "");
            
                // Find the company in the stack by name
                Azienda target = null;
                for (Azienda aziendaPubblica : aziendePubbliche) {
                    if (aziendaPubblica.getNome().equals(companyName)) {
                        target = aziendaPubblica;
                        break;
                    }
                }
            
                if (target != null) {
                    // Remove the company from the stack and update GUI
                    aziendePubbliche.remove(target);
                    panel.removePublicCompanyFromStack(target);
            
                    // Log success to Jason
                    System.out.println("[" + agName + "] Azienda rimossa: " + target.getNome());
                    return true;
                } else {
                    // Log failure if company not found
                    System.out.println("[" + agName + "] Azienda non trovata: " + companyName);
                    return false;
                }
            }

            // Print all public companies
            case "printPublicCompanies": {
                if (aziendePubbliche.isEmpty()) {
                    System.out.println("[" + agName + "] Nessuna Azienda da stampare.");
                } else {
                    for (Azienda aziendaPubblica : aziendePubbliche) {
                        System.out.println("[" + agName + "] " + aziendaPubblica.toString());
                    }
                }
                return true;
            }

            /*************************************************************
            * SMALL COMPANIES
            *************************************************************/
            // Create a new small company
            case "createSmallCompany": {
                String nome = action.getTerm(0).toString().replace("\"", "");
                String industry = action.getTerm(1).toString().replace("\"", "");
                int costo = Integer.parseInt(action.getTerm(2).toString());
                
                // Parse requisiti
                List<String> requisiti = new ArrayList<>();
                Term term1 = action.getTerm(3);
                if (term1.isList()) {
                    ListTerm listTerm1 = (ListTerm) term1;
                    for (Term t : listTerm1) {
                        String workerType = t.toString().replace("\"", "");
                        requisiti.add(workerType);
                    }
                }

                int salary1 = Integer.parseInt(action.getTerm(4).toString());
                int salary2 = Integer.parseInt(action.getTerm(5).toString());
                int salary3 = Integer.parseInt(action.getTerm(6).toString());
                int level = Integer.parseInt(action.getTerm(7).toString());

                // Parse bonusProduzione
                List<BonusProduzionePiccola> bonusProduzione = new ArrayList<>();
                Term term2 = action.getTerm(8);
                if (term2.isList()) {
                    ListTerm listTerm2 = (ListTerm) term2;
                    for (Term t : listTerm2) {
                        if (t instanceof Literal) {
                            Literal literal = (Literal) t;
                            String bonusType = literal.getTerm(0).toString().replace("\"", "");
                            int bonusValue = Integer.parseInt(literal.getTerm(1).toString());
                            bonusProduzione.add(new AziendaPiccola.BonusProduzionePiccola(bonusType, bonusValue));
                        }
                    }
                }

                boolean impiegato = Boolean.parseBoolean(action.getTerm(9).toString());
                String tipoImpiegato = action.getTerm(10).toString().replace("\"", "");

                // Parse produzione
                List<ProduzionePiccola> produzione = new ArrayList<>();
                Term term3 = action.getTerm(11);
                if (term3.isList()) {
                    ListTerm listTerm3 = (ListTerm) term3;
                    for (Term t : listTerm3) {
                        if (t instanceof Literal) {
                            Literal literal = (Literal) t;
                            String type = literal.getTerm(0).toString().replace("\"", "");
                            int value = Integer.parseInt(literal.getTerm(1).toString());
                            produzione.add(new AziendaPiccola.ProduzionePiccola(type, value));
                        }
                    }
                }

                // Parse lavoratori
                List<String> lavoratori = new ArrayList<>();
                Term term4 = action.getTerm(12);
                if (term4.isList()) {
                    ListTerm listTerm4 = (ListTerm) term4;
                    for (Term t : listTerm4) {
                        String workerType = t.toString().replace("\"", "");
                        lavoratori.add(workerType);
                    }
                }

                // Create and add the small company
                AziendaPiccola aziendaPiccola = new AziendaPiccola(
                    nome, industry, costo, requisiti,
                    salary1, salary2, salary3, level,
                    bonusProduzione, impiegato, tipoImpiegato, produzione, lavoratori
                );
                aziendePiccole.add(aziendaPiccola);

                // Notify the GUI
                panel.addSmallCompanyToStack(aziendaPiccola);

                // Print to Jason console
                // this.getLogger().info("Dettagli: " + aziendaPiccola.toString());
                return true;
            }

            // Remove a small company from the stack
            case "removeSmallCompany": {
                String companyName = action.getTerm(0).toString().replace("\"", "");
                    
                // Find the company in the stack by name
                AziendaPiccola target = null;
                for (AziendaPiccola aziendaPiccola : aziendePiccole) {
                    if (aziendaPiccola.getNome().equals(companyName)) {
                        target = aziendaPiccola;
                        break;
                    }
                }
                    
                //Continuing indentinf from here
                if (target != null) {
                    // Remove the company from the stack and update GUI
                    aziendePiccole.remove(target);
                    panel.removeSmallCompanyFromStack(target);
                
                    // Log success to Jason
                    System.out.println("[" + agName + "] Azienda rimossa: " + target.getNome());
                    return true;
                } else {
                    // Log failure if company not found
                    System.out.println("[" + agName + "] Azienda non trovata: " + companyName);
                    return false;
                }
            }

            // Print all small companies
            case "printSmallCompanies": {
                if (aziendePiccole.isEmpty()) {
                    System.out.println("[" + agName + "] Nessuna Azienda da stampare.");
                } else {
                    for (AziendaPiccola aziendaPiccola : aziendePiccole) {
                        System.out.println("[" + agName + "] " + aziendaPiccola.toString());
                    }
                }
            return true;
            }

            /*************************************************************
             * RESOURCES (Unique Pool)
             *************************************************************/
            // Add proventi to the player (capitalist only)
            case "addProventi_CC": {
                int amount = Integer.parseInt(action.getTerm(0).toString());
                proventi_CC += amount;
                panel.modifyMoney(proventi_CC);
                // System.out.println("[" + agName + "] Proventi aggiunti: " + amount + " - Proventi totali: " + proventi_CC);
                return true;
            }

            // Subtract proventi to the player (capitalist only)
            case "subtractProventi_CC": {
                int amount = Integer.parseInt(action.getTerm(0).toString());
                proventi_CC -= amount;
                panel.modifyMoney(proventi_CC);
                // System.out.println("[" + agName + "] Proventi sottratti: " + amount + " - Proventi totali: " + proventi_CC);
                return true;
            }

            // Add capitale to the player (capitalist only)
            case "addCapitale_CC": {
                int amount = Integer.parseInt(action.getTerm(0).toString());
                capitale_CC += amount;
                // System.out.println("[" + agName + "] Capitale aggiunto: " + amount + " - Proventi totali: " + capitale_CC);
                return true;
            }

            // Subtract capitale to the player (capitalist only)
            case "subtractCapitale_CC": {
                int amount = Integer.parseInt(action.getTerm(0).toString());
                capitale_CC -= amount;
                // System.out.println("[" + agName + "] Capitale sottratto: " + amount + " - Proventi totali: " + capitale_CC);
                return true;
            }

            // Add introiti to the player (working class only)
            case "addIntroiti_CO": {
                int amount = Integer.parseInt(action.getTerm(0).toString());
                introiti_CO += amount;
                // System.out.println("[" + agName + "] Introiti aggiunti: " + amount + " - Introiti totali: " + introiti_CO);
                return true;
            }

            // Subtract introiti to the player (working class only)
            case "subtractIntroiti_CO": {
                int amount = Integer.parseInt(action.getTerm(0).toString());
                introiti_CO -= amount;
                // System.out.println("[" + agName + "] Introiti sottratti: " + amount + " - Proventi totali: " + introiti_CO);
                return true;
            }
        
            // Add introiti to the player (middle class only)
            case "addIntroiti_CM": {
                int amount = Integer.parseInt(action.getTerm(0).toString());
                introiti_CM += amount;
                // System.out.println("[" + agName + "] Introiti aggiunti: " + amount + " - Introiti totali: " + introiti_CM);
                return true;
            }

            // Subtract introiti to the player (middle class only)
            case "subtractIntroiti_CM": {
                int amount = Integer.parseInt(action.getTerm(0).toString());
                introiti_CM -= amount;
                // System.out.println("[" + agName + "] Introiti sottratti: " + amount + " - Proventi totali: " + introiti_CM);
                return true;
            }

            /*************************************************************
             * RESOURCES (Generic Pool)
             * ************************************************************/
            // Add cibo to the player
            case "addCibo": {
                String socialClass = action.getTerm(0).toString().replace("\"", "");
                int amount = Integer.parseInt(action.getTerm(1).toString());

                if (socialClass.equals("CC")) {
                    cibo_CC += amount;
                    panel.modifyFood(cibo_CC);
                    // System.out.println("[" + agName + "] (CC) Cibo aggiunto: " + amount + " - Cibo totale: " + cibo_CC);
                    return true;
                } else if (socialClass.equals("CO")) {
                    cibo_CO += amount;
                    // System.out.println("[" + agName + "] (CO) Cibo aggiunto: " + amount + " - Cibo totale: " + cibo_CO);
                    return true;
                } else if (socialClass.equals("CM")) {
                    cibo_CM += amount;
                    // System.out.println("[" + agName + "] (CM) Cibo aggiunto: " + amount + " - Cibo totale: " + cibo_CM);
                    return true;
                } else if (socialClass.equals("Stato")) {
                    cibo_Stato += amount;
                    // System.out.println("[" + agName + "] (Stato) Cibo aggiunto: " + amount + " - Cibo totale: " + cibo_Stato);
                    return true;
                } else {
                    System.out.println("[" + agName + "] Classe non trovata: " + socialClass);
                    return false;
                }
            }

            // Subtract cibo to the player
            case "subtractCibo": {
                String socialClass = action.getTerm(0).toString().replace("\"", "");
                int amount = Integer.parseInt(action.getTerm(1).toString());
                
                if (socialClass.equals("CC")) {
                    cibo_CC -= amount;
                    panel.modifyFood(cibo_CC);
                    // System.out.println("[" + agName + "] (CC) Cibo sottratto: " + amount + " - Cibo totale: " + cibo_CC);
                    return true;
                } else if (socialClass.equals("CO")) {
                    cibo_CO -= amount;
                    // System.out.println("[" + agName + "] (CO) Cibo sottratto: " + amount + " - Cibo totale: " + cibo_CO);
                    return true;
                } else if (socialClass.equals("CM")) {
                    cibo_CM -= amount;
                    // System.out.println("[" + agName + "] (CM) Cibo sottratto: " + amount + " - Cibo totale: " + cibo_CM);
                    return true;
                } else if (socialClass.equals("Stato")) {
                    cibo_Stato -= amount;
                    // System.out.println("[" + agName + "] (Stato) Cibo sottratto: " + amount + " - Cibo totale: " + cibo_Stato);
                    return true;
                } else {
                    System.out.println("[" + agName + "] Classe non trovata: " + socialClass);
                    return false;
                }
            }

            // Add lusso to the player
            case "addLusso": {
                String socialClass = action.getTerm(0).toString().replace("\"", "");
                int amount = Integer.parseInt(action.getTerm(1).toString());

                if (socialClass.equals("CC")) {
                    lusso_CC += amount;
                    // System.out.println("[" + agName + "] (CC) Lusso aggiunto: " + amount + " - Lusso totale: " + lusso_CC);
                    return true;
                } else if (socialClass.equals("CO")) {
                    lusso_CO += amount;
                    // System.out.println("[" + agName + "] (CO) Lusso aggiunto: " + amount + " - Lusso totale: " + lusso_CO);
                    return true;
                } else if (socialClass.equals("CM")) {
                    lusso_CM += amount;
                    // System.out.println("[" + agName + "] (CM) Lusso aggiunto: " + amount + " - Lusso totale: " + lusso_CM);
                    return true;
                } else if (socialClass.equals("Stato")) {
                    lusso_Stato += amount;
                    // System.out.println("[" + agName + "] (Stato) Lusso aggiunto: " + amount + " - Lusso totale: " + lusso_Stato);
                    return true;
                } else {
                    System.out.println("[" + agName + "] Classe non trovata: " + socialClass);
                    return false;
                }
            }

            // Subtract lusso to the player
            case "subtractLusso": {
                String socialClass = action.getTerm(0).toString().replace("\"", "");
                int amount = Integer.parseInt(action.getTerm(1).toString());
                
                if (socialClass.equals("CC")) {
                    lusso_CC -= amount;                    
                    // System.out.println("[" + agName + "] (CC) Lusso sottratto: " + amount + " - Lusso totale: " + lusso_CC);
                    return true;
                } else if (socialClass.equals("CO")) {
                    lusso_CO -= amount;
                    // System.out.println("[" + agName + "] (CO) Lusso sottratto: " + amount + " - Lusso totale: " + lusso_CO);
                    return true;
                } else if (socialClass.equals("CM")) {
                    lusso_CM -= amount;
                    // System.out.println("[" + agName + "] (CM) Lusso sottratto: " + amount + " - Lusso totale: " + lusso_CM);
                    return true;
                } else if (socialClass.equals("Stato")) {
                    lusso_Stato -= amount;
                    // System.out.println("[" + agName + "] (Stato) Lusso sottratto: " + amount + " - Lusso totale: " + lusso_Stato);
                    return true;
                } else {
                    System.out.println("[" + agName + "] Classe non trovata: " + socialClass);
                    return false;
                }
            }

            // Add istruzione to the player
            case "addIstruzione": {
                String socialClass = action.getTerm(0).toString().replace("\"", "");
                int amount = Integer.parseInt(action.getTerm(1).toString());

                if (socialClass.equals("CC")) {
                    istruzione_CC += amount;
                    // System.out.println("[" + agName + "] (CC) Istruzione aggiunta: " + amount + " - Istruzione totale: " + istruzione_CC);
                    return true;
                } else if (socialClass.equals("CO")) {
                    istruzione_CO += amount;
                    // System.out.println("[" + agName + "] (CO) Istruzione aggiunta: " + amount + " - Istruzione totale: " + istruzione_CO);
                    return true;
                } else if (socialClass.equals("CM")) {
                    istruzione_CM += amount;
                    // System.out.println("[" + agName + "] (CM) Istruzione aggiunta: " + amount + " - Istruzione totale: " + istruzione_CM);
                    return true;
                } else {
                    System.out.println("[" + agName + "] Classe non trovata: " + socialClass);
                    return false;
                }
            }

            // Subtract istruzione to the player
            case "subtractIstruzione": {
                String socialClass = action.getTerm(0).toString().replace("\"", "");
                int amount = Integer.parseInt(action.getTerm(1).toString());
                
                if (socialClass.equals("CC")) {
                    istruzione_CC -= amount;                    
                    // System.out.println("[" + agName + "] (CC) Istruzione sottratta: " + amount + " - Istruzione totale: " + istruzione_CC);
                    return true;
                } else if (socialClass.equals("CO")) {
                    istruzione_CO -= amount;
                    // System.out.println("[" + agName + "] (CO) Istruzione sottratta: " + amount + " - Istruzione totale: " + istruzione_CO);
                    return true;
                } else if (socialClass.equals("CM")) {
                    istruzione_CM -= amount;
                    // System.out.println("[" + agName + "] (CM) Istruzione sottratta: " + amount + " - Istruzione totale: " + istruzione_CM);
                    return true;
                } else {
                    System.out.println("[" + agName + "] Classe non trovata: " + socialClass);
                    return false;
                }
            }

            // Add sanità to the player
            case "addSanita": {
                String socialClass = action.getTerm(0).toString().replace("\"", "");
                int amount = Integer.parseInt(action.getTerm(1).toString());

                if (socialClass.equals("CC")) {
                    sanita_CC += amount;
                    // System.out.println("[" + agName + "] (CC) Sanita aggiunta: " + amount + " - Sanita totale: " + sanita_CC);
                    return true;
                } else if (socialClass.equals("CO")) {
                    sanita_CO += amount;
                    // System.out.println("[" + agName + "] (CO) Sanita aggiunta: " + amount + " - Sanita totale: " + sanita_CO);
                    return true;
                } else if (socialClass.equals("CM")) {
                    sanita_CM += amount;
                    // System.out.println("[" + agName + "] (CM) Sanita aggiunta: " + amount + " - Sanita totale: " + sanita_CM);
                    return true;
                } else {
                    System.out.println("[" + agName + "] Classe non trovata: " + socialClass);
                    return false;
                }
            }

            // Subtract sanità to the player
            case "subtractSanita": {
                String socialClass = action.getTerm(0).toString().replace("\"", "");
                int amount = Integer.parseInt(action.getTerm(1).toString());
                
                if (socialClass.equals("CC")) {
                    sanita_CC -= amount;                    
                    // System.out.println("[" + agName + "] (CC) Sanita sottratta: " + amount + " - Sanita totale: " + sanita_CC);
                    return true;
                } else if (socialClass.equals("CO")) {
                    sanita_CO -= amount;
                    // System.out.println("[" + agName + "] (CO) Sanita sottratta: " + amount + " - Sanita totale: " + sanita_CO);
                    return true;
                } else if (socialClass.equals("CM")) {
                    sanita_CM -= amount;
                    // System.out.println("[" + agName + "] (CM) Sanita sottratta: " + amount + " - Sanita totale: " + sanita_CM);
                    return true;
                } else {
                    System.out.println("[" + agName + "] Classe non trovata: " + socialClass);
                    return false;
                }
            }

            // Add influenza to the player
            case "addInfluenza": {
                String socialClass = action.getTerm(0).toString().replace("\"", "");
                int amount = Integer.parseInt(action.getTerm(1).toString());

                if (socialClass.equals("CC")) {
                    influenza_CC += amount;
                    // System.out.println("[" + agName + "] (CC) Influenza aggiunta: " + amount + " - Influenza totale: " + influenza_CC);
                    return true;
                } else if (socialClass.equals("CO")) {
                    influenza_CO += amount;
                    // System.out.println("[" + agName + "] (CO) Influenza aggiunta: " + amount + " - Influenza totale: " + influenza_CO);
                    return true;
                } else if (socialClass.equals("CM")) {
                    influenza_CM += amount;
                    // System.out.println("[" + agName + "] (CM) Influenza aggiunta: " + amount + " - Influenza totale: " + influenza_CM);
                    return true;
                } else if (socialClass.equals("Stato")) {
                    influenza_Stato += amount;
                    // System.out.println("[" + agName + "] (Stato) Influenza aggiunta: " + amount + " - Influenza totale: " + influenza_Stato);
                    return true;
                } else {
                    System.out.println("[" + agName + "] Classe non trovata: " + socialClass);
                    return false;
                }
            }

            // Subtract influenza to the player
            case "subtractInfluenza": {
                String socialClass = action.getTerm(0).toString().replace("\"", "");
                int amount = Integer.parseInt(action.getTerm(1).toString());
                
                if (socialClass.equals("CC")) {
                    influenza_CC -= amount;                    
                    // System.out.println("[" + agName + "] (CC) Influenza sottratta: " + amount + " - Influenza totale: " + influenza_CC);
                    return true;
                } else if (socialClass.equals("CO")) {
                    influenza_CO -= amount;
                    // System.out.println("[" + agName + "] (CO) Influenza sottratta: " + amount + " - Influenza totale: " + influenza_CO);
                    return true;
                } else if (socialClass.equals("CM")) {
                    influenza_CM -= amount;
                    // System.out.println("[" + agName + "] (CM) Influenza sottratta: " + amount + " - Influenza totale: " + influenza_CM);
                    return true;
                } else if (socialClass.equals("Stato")) {
                    influenza_Stato -= amount;
                    // System.out.println("[" + agName + "] (Stato) Influenza sottratta: " + amount + " - Influenza totale: " + influenza_Stato);
                    return true;
                } else {
                    System.out.println("[" + agName + "] Classe non trovata: " + socialClass);
                    return false;
                }
            }

            /*************************************************************
             * WORKERS
             * ************************************************************/
            // Add worker to the work market
            case "createWorker": {
                int amount = Integer.parseInt(action.getTerm(0).toString());
                String workerType = action.getTerm(1).toString().replace("\"", "");
                
                if (workerType.equals("agricoltura (o)")){
                    lavoratoriOperaiAgrario += amount;
                }
                if (workerType.equals("agricoltura (m)")){
                    lavoratoriMediAgrario += amount;
                }
                if (workerType.equals("lusso (o)")){
                    lavoratoriOperaiLusso += amount;
                }
                if (workerType.equals("lusso (m)")){
                    lavoratoriMediLusso += amount;
                }
                if (workerType.equals("sanità (o)")){
                    lavoratoriOperaiSanita += amount;
                }
                if (workerType.equals("sanità (m)")){
                    lavoratoriMediSanita += amount;
                }
                if (workerType.equals("istruzione (o)")){
                    lavoratoriOperaiIstruzione += amount;
                }
                if (workerType.equals("istruzione (m)")){
                    lavoratoriMediIstruzione += amount;
                }
                if (workerType.equals("media (o)")){
                    lavoratoriOperaiMedia += amount;
                }
                if (workerType.equals("media (m)")){
                    lavoratoriMediMedia += amount;
                }
                if (workerType.equals("generico (o)")){
                    lavoratoriOperaiGenerici += amount;
                }
                if (workerType.equals("generico (m)")){
                    lavoratoriMediGenerici += amount;
                }
                // System.out.println("[" + agName + "] " + amount + " nuovi lavoratori nel settore " + workerType);
                return true;
            }

            // Eliminate worker from the work market
            case "killWorker": {
                int amount = Integer.parseInt(action.getTerm(0).toString());
                introiti_CM -= amount;
                // System.out.println("[" + agName + "] Introiti sottratti: " + amount + " - Proventi totali: " + introiti_CM);
                return true;
            }
            
            // Add workers to a specific company: this very long case should (if I wrote that correctly) cover all possible possibilities
            case "assumeWorker": {
                String workerType = action.getTerm(0).toString().replace("\"", "");
                String company = action.getTerm(1).toString().replace("\"", "");

                if (workerType.equals("agricoltura (o)")) {
                    if (lavoratoriOperaiAgrario > 0) {
                        lavoratoriOperaiAgrario--;
                    } else
                        return false;
                } else if (workerType.equals("agricoltura (m)")) {
                    if (lavoratoriMediAgrario > 0) {
                        lavoratoriMediAgrario--;
                    } else
                        return false;
                } else if (workerType.equals("agricoltura (q)")) {
                    if (lavoratoriOperaiAgrario >= lavoratoriMediAgrario) {
                        if (lavoratoriOperaiAgrario > 0) {
                            lavoratoriOperaiAgrario--;
                        } else
                            return false;
                    }
                    else {
                        if (lavoratoriMediAgrario > 0) {
                            lavoratoriMediAgrario--;
                        } else
                            return false;
                    }
                } else if (workerType.equals("lusso (o)")) {
                    if (lavoratoriOperaiLusso > 0) {
                        lavoratoriOperaiLusso--;
                    } else
                        return false;
                } else if (workerType.equals("lusso (m)")) {
                    if (lavoratoriMediLusso > 0) {
                        lavoratoriMediLusso--;
                    } else
                        return false;
                } else if (workerType.equals("lusso (q)")) {
                    if (lavoratoriOperaiLusso >= lavoratoriMediLusso) {
                        if (lavoratoriOperaiLusso > 0) {
                            lavoratoriOperaiLusso--;
                        } else
                            return false;
                    }
                    else {
                        if (lavoratoriMediLusso > 0) {
                            lavoratoriMediLusso--;
                        } else
                            return false;
                    }
                } else if (workerType.equals("sanità (o)")) {
                    if (lavoratoriOperaiSanita > 0) {
                        lavoratoriOperaiSanita--;
                    } else
                        return false;
                } else if (workerType.equals("sanità (m)")) {
                    if (lavoratoriMediSanita > 0) {
                        lavoratoriMediSanita--;
                    } else
                        return false;
                }
                else if (workerType.equals("sanità (q)")) {
                    if (lavoratoriOperaiSanita >= lavoratoriMediSanita) {
                        if (lavoratoriOperaiSanita > 0) {
                            lavoratoriOperaiSanita--;
                        } else
                            return false;
                    }
                    else {
                        if (lavoratoriMediSanita > 0) {
                            lavoratoriMediSanita--;
                        } else
                            return false;
                    }
                } else if (workerType.equals("istruzione (o)")) {
                    if (lavoratoriOperaiIstruzione > 0) {
                        lavoratoriOperaiIstruzione--;
                    } else
                        return false;
                } else if (workerType.equals("istruzione (m)")) {
                    if (lavoratoriMediIstruzione > 0) {
                        lavoratoriMediIstruzione--;
                    } else
                        return false;
                }
                else if (workerType.equals("istruzione (q)")) {
                    if (lavoratoriOperaiIstruzione >= lavoratoriMediIstruzione) {
                        if (lavoratoriOperaiIstruzione > 0) {
                            lavoratoriOperaiIstruzione--;
                        } else
                            return false;
                    }
                    else {
                        if (lavoratoriMediIstruzione > 0) {
                            lavoratoriMediIstruzione--;
                        } else
                            return false;
                    }
                } else if (workerType.equals("media (o)")) {
                    if (lavoratoriOperaiMedia > 0) {
                        lavoratoriOperaiMedia--;
                    } else
                        return false;
                } else if (workerType.equals("media (m)")) {
                    if (lavoratoriMediMedia > 0) {
                        lavoratoriMediMedia--;
                    } else
                        return false;
                } else if (workerType.equals("media (q)")) {
                    if (lavoratoriOperaiMedia >= lavoratoriMediMedia) {
                        if (lavoratoriOperaiMedia > 0) {
                            lavoratoriOperaiMedia--;
                        } else
                            return false;
                    }
                    else {
                        if (lavoratoriMediMedia > 0) {
                            lavoratoriMediMedia--;
                        } else
                            return false;
                    }
                }

                /*
                else if (workerType.equals("generico (o)")) {
                    if (lavoratoriOperaiGenerici > 0) {
                        lavoratoriOperaiGenerici--;
                    } else
                        workerType = randomWorker_O();
                        while (workerType.equals("agricoltura (o)") && lavoratoriOperaiAgrario == 0
                            || workerType.equals("lusso (o)") && lavoratoriOperaiLusso == 0
                            || workerType.equals("sanità (o)") && lavoratoriOperaiSanita == 0
                            || workerType.equals("istruzione (o)") && lavoratoriOperaiIstruzione == 0
                            || workerType.equals("media (o)") && lavoratoriOperaiMedia == 0) {
                                workerType = randomWorker_O();
                            }
                        if (workerType.equals("agricoltura (o)")) {
                            lavoratoriOperaiAgrario--;
                        }
                        else if (workerType.equals("lusso (o)")) {
                            lavoratoriOperaiLusso--;
                        }
                        else if (workerType.equals("sanità (o)")) {
                            lavoratoriOperaiSanita--;
                        }
                        else if (workerType.equals("istruzione (o)")) {
                            lavoratoriOperaiIstruzione--;
                        }
                        else if (workerType.equals("media (o)")) {
                            lavoratoriOperaiMedia--;
                        }
                        else
                            return false; // this case represent a "conservative-strategic" failure (to preserve a bit of the worker pool)
                }

                else if (workerType.equals("generico (m)")) {
                    if (lavoratoriMediGenerici > 0) {
                        lavoratoriMediGenerici--;
                    } else {
                        workerType = randomWorker_M();
                        while (workerType.equals("agricoltura (m)") && lavoratoriMediAgrario == 0
                            || workerType.equals("lusso (m)") && lavoratoriMediLusso == 0
                            || workerType.equals("sanità (m)") && lavoratoriMediSanita == 0
                            || workerType.equals("istruzione (m)") && lavoratoriMediIstruzione == 0
                            || workerType.equals("media (m)") && lavoratoriMediMedia == 0) {
                                workerType = randomWorker_M();
                            }
                        if (workerType.equals("agricoltura (m)")) {
                            lavoratoriMediAgrario--;
                        }
                        else if (workerType.equals("lusso (m)")) {
                            lavoratoriMediLusso--;
                        }
                        else if (workerType.equals("sanità (m)")) {
                            lavoratoriMediSanita--;
                        }
                        else if (workerType.equals("istruzione (m)")) {
                            lavoratoriMediIstruzione--;
                        }
                        else if (workerType.equals("media (m)")) {
                            lavoratoriMediMedia--;
                        }
                        else
                            return false; // this case represent a "conservative-strategic" failure (to preserve a bit of the worker pool)
                
                    }
                }

                else { // generico (q) case
                    if (lavoratoriOperaiGenerici >= lavoratoriMediGenerici) {
                        if (lavoratoriOperaiGenerici > 0) {
                            lavoratoriOperaiGenerici--;
                        } else {
                            workerType = randomWorker_O();
                            while (workerType.equals("agricoltura (o)") && lavoratoriOperaiAgrario == 0
                                || workerType.equals("lusso (o)") && lavoratoriOperaiLusso == 0
                                || workerType.equals("sanità (o)") && lavoratoriOperaiSanita == 0
                                || workerType.equals("istruzione (o)") && lavoratoriOperaiIstruzione == 0
                                || workerType.equals("media (o)") && lavoratoriOperaiMedia == 0) {
                                    workerType = randomWorker_O();
                                }
                            if (workerType.equals("agricoltura (o)")) {
                                lavoratoriOperaiAgrario--;
                            }
                            else if (workerType.equals("lusso (o)")) {
                                lavoratoriOperaiLusso--;
                            }
                            else if (workerType.equals("sanità (o)")) {
                                lavoratoriOperaiSanita--;
                            }
                            else if (workerType.equals("istruzione (o)")) {
                                lavoratoriOperaiIstruzione--;
                            }
                            else if (workerType.equals("media (o)")) {
                                lavoratoriOperaiMedia--;
                            }
                            else
                                return false;
                        }
                    }
                    else {
                        if (lavoratoriMediGenerici > 0) {
                            lavoratoriMediGenerici--;
                        } else {
                            workerType = randomWorker_M();
                            while (workerType.equals("agricoltura (m)") && lavoratoriMediAgrario == 0
                                || workerType.equals("lusso (m)") && lavoratoriMediLusso == 0
                                || workerType.equals("sanità (m)") && lavoratoriMediSanita == 0
                                || workerType.equals("istruzione (m)") && lavoratoriMediIstruzione == 0
                                || workerType.equals("media (m)") && lavoratoriMediMedia == 0) {
                                    workerType = randomWorker_M();
                                }
                            if (workerType.equals("agricoltura (m)")) {
                                lavoratoriMediAgrario--;
                            }
                            else if (workerType.equals("lusso (m)")) {
                                lavoratoriMediLusso--;
                            }
                            else if (workerType.equals("sanità (m)")) {
                                lavoratoriMediSanita--;
                            }
                            else if (workerType.equals("istruzione (m)")) {
                                lavoratoriMediIstruzione--;
                            }
                            else if (workerType.equals("media (m)")) {
                                lavoratoriMediMedia--;
                            }
                            else
                                return false;
                        }
                    }
                } */
                
                // panel.modifyFood(cibo_CO); // DA IMPLEMENTARE LA VISUALIZZAZIONE
                // System.out.println("[" + agName + "] Lavoratore aggiunto: " + workerType + " all'azienda: " + company);
                return true;
            }

            // Unknown action
            default:
                System.out.println("[" + agName + "] Azione sconosciuta: " + action.getFunctor());
            return false;
        }
    }

    public String randomWorker_O() {
        List<String> workerTypeList = new ArrayList<>();
        workerTypeList.add("agricoltura (o)");
        workerTypeList.add("lusso (o)");
        workerTypeList.add("sanità (o)");
        workerTypeList.add("istruzione (o)");
        workerTypeList.add("media (o)");
        workerTypeList.add("failure");
        int index = randomGenerator.nextInt(workerTypeList.size());
        String item = workerTypeList.get(index);
        return item;
    }

    public String randomWorker_M() {
        List<String> workerTypeList = new ArrayList<>();
        workerTypeList.add("agricoltura (m)");
        workerTypeList.add("lusso (m)");
        workerTypeList.add("sanità (m)");
        workerTypeList.add("istruzione (m)");
        workerTypeList.add("media (m)");
        workerTypeList.add("failure");
        int index = randomGenerator.nextInt(workerTypeList.size());
        String item = workerTypeList.get(index);
        return item;
    }
    
    // CLOSE THE ENVIRONMENT
    @Override
    public void stop() {
        // Properly close the environment when Jason finishes execution
    }
}
