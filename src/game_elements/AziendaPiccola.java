package game_elements;

import java.util.List;
import java.util.ArrayList;

public class AziendaPiccola {
    private String nome;
    private String industria;
    private int costo;
    private List<String> requisiti;
    private int salary1;
    private int salary2;
    private int salary3;
    private int level;
    private List<BonusProduzionePiccola> bonusProduzione;
    private boolean impiegato;
    private String tipoImpiegato;
    private List<ProduzionePiccola> produzione;
    private List<String> lavoratori;

    public AziendaPiccola(String nome, String industria, int costo, List<String> requisiti, int salary1, int salary2, int salary3,
                   int level, List<BonusProduzionePiccola> bonusProduzione, boolean impiegato, String tipoImpiegato, List<ProduzionePiccola> produzione, List<String> lavoratori) {
        this.nome = nome;
        this.industria = industria;
        this.costo = costo;
        this.requisiti = requisiti;
        this.salary1 = salary1;
        this.salary2 = salary2;
        this.salary3 = salary3;
        this.level = level;
        this.bonusProduzione = bonusProduzione;
        this.impiegato = impiegato;
        this.tipoImpiegato = tipoImpiegato;
        this.produzione = produzione;
        this.lavoratori = lavoratori;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getIndustria() {
        return industria;
    }

    public int getCosto() {
        return costo;
    }

    public List<String> getRequisiti() {
        return requisiti;
    }

    public int getSalary1() {
        return salary1;
    }

    public int getSalary2() {
        return salary2;
    }

    public int getSalary3() {
        return salary3;
    }

    public int getLevel() {
        return level;
    }

    public List<BonusProduzionePiccola> getBonusProduzione() {
        return bonusProduzione;
    }

    public boolean isImpiegato() {
        return impiegato;
    }

    public String getTipoImpiegato() {
        return tipoImpiegato;
    }

    public List<ProduzionePiccola> getProduzione() {
        return produzione;
    }

    public List<String> getLavoratori() {
        return lavoratori;
    }

    @Override
    public String toString() {
        StringBuilder requisitiStr = new StringBuilder();
        for (String requisito : requisiti) {
            requisitiStr.append(requisito.toString()).append(", ");
        }

        StringBuilder bonusProduzioneStr = new StringBuilder();
        for (BonusProduzionePiccola bonusProduzione : bonusProduzione) {
            bonusProduzioneStr.append(bonusProduzione.toString()).append(", ");
        }

        StringBuilder produzioneStr = new StringBuilder();
        for (ProduzionePiccola produzione : produzione) {
            produzioneStr.append(produzione.toString()).append(", ");
        }

        StringBuilder lavoratoriStr = new StringBuilder();
        for (String lavoratore : lavoratori) {
            lavoratoriStr.append(lavoratore.toString()).append(", ");
        }

        return nome + " (" + industria + ")\n" +
            "\tCosto: " + costo + "\n" +
            "\tRequisiti: " + (requisitiStr.length() > 0 ? requisitiStr.substring(0, requisitiStr.length() - 2) : "") + "\n" +
            "\tSalario: " + salary1 + "[1] " + salary2 + "[2] " + salary3 + "[3]\n" +
            "\tLivello: " + level + "\n" +
            "\tBonus Produzione: " + (bonusProduzioneStr.length() > 0 ? bonusProduzioneStr.substring(0, bonusProduzioneStr.length() - 2) : "") + "\n" +
            "\tImpiegato: " + impiegato + "\n" +
            "\tTipo Impiegato: " + tipoImpiegato + "\n" +
            "\tProduzione: " + (produzioneStr.length() > 0 ? produzioneStr.substring(0, produzioneStr.length() - 2) : "") + "\n" +
            "\tLavoratori: " + (lavoratoriStr.length() > 0 ? lavoratoriStr.substring(0, lavoratoriStr.length() - 2) : "") + "\n";
    }

    public static class ProduzionePiccola {
        private String type;
        private int value;

        public ProduzionePiccola(String type, int value) {
            this.type = type;
            this.value = value;
        }

        // Getters and Setters
        public String getType() {
            return type;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value + " " + type;
        }
    }

    public static class BonusProduzionePiccola {
        private String bonusType;
        private int bonusValue;

        public BonusProduzionePiccola(String bonusType, int bonusValue) {
            this.bonusType = bonusType;
            this.bonusValue = bonusValue;
        }

        // Getters and Setters
        public String getBonusType() {
            return bonusType;
        }

        public int getBonusValue() {
            return bonusValue;
        }

        @Override
        public String toString() {
            return bonusValue + " " + bonusType;
        }
    }
}

