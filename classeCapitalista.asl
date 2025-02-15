// BELIEFS: CLASSE CAPITALISTA
player("CC").
player("CO").
player("CM").
player("Stato").

privateCompany("Supermercato (Starter)").
privateCompany("Centro Commerciale (Starter)").
privateCompany("Scuola Superiore (Starter)").
privateCompany("Clinica (Starter)").
privateCompany("Allevamento Ittico").
privateCompany("Coltivazione Ortofrutticola").
privateCompany("Supermercato").
privateCompany("Catena di Fast Food").
privateCompany("Coltivazione Automatizzata di Cereali").
privateCompany("Caseificio Automatizzato").
privateCompany("Stadio").
privateCompany("Hotel").
privateCompany("Centro Commerciale").
privateCompany("Azienda di Moda").
privateCompany("Fabbrica di Dispositivi Elettronici").
privateCompany("Fabbrica di Automobili").
privateCompany("Azienda Farmaceutica").
privateCompany("Centro Medico").
privateCompany("Clinica").
privateCompany("Ospedale").
privateCompany("Istituto di Tecnologia").
privateCompany("Università").
privateCompany("Scuola Superiore").
privateCompany("Accademia").
privateCompany("Emittente Televisiva").
privateCompany("Casa Editrice").
privateCompany("Agenzia di Lobbying").
privateCompany("Stazione Radiofonica").

companyIndustry("Supermercato (Starter)", "Agricoltura").
companyIndustry("Centro Commerciale (Starter)", "Lusso").
companyIndustry("Scuola Superiore (Starter)", "Istruzione").
companyIndustry("Clinica (Starter)", "Sanità").
companyIndustry("Allevamento Ittico", "Agricoltura").
companyIndustry("Coltivazione Ortofrutticola", "Agricoltura").
companyIndustry("Supermercato", "Agricoltura").
companyIndustry("Catena di Fast Food", "Agricoltura").
companyIndustry("Coltivazione Automatizzata di Cereali", "Agricoltura").
companyIndustry("Caseificio Automatizzato", "Agricoltura").
companyIndustry("Stadio", "Lusso").
companyIndustry("Hotel", "Lusso").
companyIndustry("Centro Commerciale", "Lusso").
companyIndustry("Azienda di Moda", "Lusso").
companyIndustry("Fabbrica di Dispositivi Elettronici", "Lusso").
companyIndustry("Fabbrica di Automobili", "Lusso").
companyIndustry("Azienda Farmaceutica", "Sanità").
companyIndustry("Centro Medico", "Sanità").
companyIndustry("Clinica", "Sanità").
companyIndustry("Ospedale", "Sanità").
companyIndustry("Istituto di Tecnologia", "Istruzione").
companyIndustry("Università", "Istruzione").
companyIndustry("Scuola Superiore", "Istruzione").
companyIndustry("Accademia", "Istruzione").
companyIndustry("Emittente Televisiva", "Media").
companyIndustry("Casa Editrice", "Media").
companyIndustry("Agenzia di Lobbying", "Media").
companyIndustry("Stazione Radiofonica", "Media").

companyCost("Supermercato (Starter)", 16).
companyCost("Centro Commerciale (Starter)", 16).
companyCost("Scuola Superiore (Starter)", 16).
companyCost("Clinica (Starter)", 16).
companyCost("Allevamento Ittico", 20).
companyCost("Coltivazione Ortofrutticola", 15).
companyCost("Supermercato", 16).
companyCost("Catena di Fast Food", 8).
companyCost("Coltivazione Automatizzata di Cereali", 25).
companyCost("Caseificio Automatizzato", 45).
companyCost("Stadio", 20).
companyCost("Hotel", 15).
companyCost("Centro Commerciale", 16).
companyCost("Azienda di Moda", 8).
companyCost("Fabbrica di Dispositivi Elettronici", 25).
companyCost("Fabbrica di Automobili", 45).
companyCost("Azienda Farmaceutica", 20).
companyCost("Centro Medico", 24).
companyCost("Clinica", 16).
companyCost("Ospedale", 20).
companyCost("Istituto di Tecnologia", 20).
companyCost("Università", 24).
companyCost("Scuola Superiore", 16).
companyCost("Accademia", 20).
companyCost("Emittente Televisiva", 24).
companyCost("Casa Editrice", 12).
companyCost("Agenzia di Lobbying", 16).
companyCost("Stazione Radiofonica", 8).

companyRequirements("Supermercato (Starter)", ["agricoltura (q)", "generico (q)"]).
companyRequirements("Centro Commerciale (Starter)", ["lusso (q)", "generico (q)"]).
companyRequirements("Scuola Superiore (Starter)", ["istruzione (q)", "generico (q)"]).
companyRequirements("Clinica (Starter)", ["sanità (q)", "generico (q)"]).
companyRequirements("Allevamento Ittico", ["agricoltura (q)", "generico (q)", "generico (q)"]).
companyRequirements("Coltivazione Ortofrutticola", ["generico (q)"]).
companyRequirements("Supermercato", ["agricoltura (q)", "generico (q)"]).
companyRequirements("Catena di Fast Food", ["generico (q)", "generico (q)"]).
companyRequirements("Coltivazione Automatizzata di Cereali", []).
companyRequirements("Caseificio Automatizzato", []).
companyRequirements("Stadio", ["lusso (q)", "generico (q)", "generico (q)"]).
companyRequirements("Hotel", ["generico (q)", "generico (q)", "generico (q)"]).
companyRequirements("Centro Commerciale", ["lusso (q)", "generico (q)"]).
companyRequirements("Azienda di Moda", ["generico (q)", "generico (q)"]).
companyRequirements("Fabbrica di Dispositivi Elettronici", []).
companyRequirements("Fabbrica di Automobili", []).
companyRequirements("Azienda Farmaceutica", ["sanità (q)", "generico (q)", "generico (q)"]).
companyRequirements("Centro Medico", ["sanità (q)", "generico (q)", "generico (q)"]).
companyRequirements("Clinica", ["sanità (q)", "generico (q)"]).
companyRequirements("Ospedale", ["sanità (q)", "generico (q)"]).
companyRequirements("Istituto di Tecnologia", ["istruzione (q)", "generico (q)", "generico (q)"]).
companyRequirements("Università", ["istruzione (q)", "generico (q)", "generico (q)"]).
companyRequirements("Scuola Superiore", ["istruzione (q)", "generico (q)"]).
companyRequirements("Accademia", ["istruzione (q)", "generico (q)"]).
companyRequirements("Emittente Televisiva", ["media (q)", "generico (q)", "generico (q)"]).
companyRequirements("Casa Editrice", ["generico (q)", "generico (q)", "generico (q)"]).
companyRequirements("Agenzia di Lobbying", ["media (q)", "generico (q)"]).
companyRequirements("Stazione Radiofonica", ["generico (q)", "generico (q)"]).

companySalary1("Supermercato (Starter)", 15).
companySalary1("Centro Commerciale (Starter)", 15).
companySalary1("Scuola Superiore (Starter)", 10).
companySalary1("Clinica (Starter)", 10).
companySalary1("Allevamento Ittico", 25).
companySalary1("Coltivazione Ortofrutticola", 20).
companySalary1("Supermercato", 15).
companySalary1("Catena di Fast Food", 10).
companySalary1("Coltivazione Automatizzata di Cereali", 0).
companySalary1("Caseificio Automatizzato", 0).
companySalary1("Stadio", 25).
companySalary1("Hotel", 20).
companySalary1("Centro Commerciale", 15).
companySalary1("Azienda di Moda", 10).
companySalary1("Fabbrica di Dispositivi Elettronici", 0).
companySalary1("Fabbrica di Automobili", 0).
companySalary1("Azienda Farmaceutica", 20).
companySalary1("Centro Medico", 20).
companySalary1("Clinica", 10).
companySalary1("Ospedale", 10).
companySalary1("Istituto di Tecnologia", 20).
companySalary1("Università", 20).
companySalary1("Scuola Superiore", 10).
companySalary1("Accademia", 10).
companySalary1("Emittente Televisiva", 20).
companySalary1("Casa Editrice", 20).
companySalary1("Agenzia di Lobbying", 10).
companySalary1("Stazione Radiofonica", 10).

companySalary2("Supermercato (Starter)", 20).
companySalary2("Centro Commerciale (Starter)", 20).
companySalary2("Scuola Superiore (Starter)", 20).
companySalary2("Clinica (Starter)", 20).
companySalary2("Allevamento Ittico", 30).
companySalary2("Coltivazione Ortofrutticola", 25).
companySalary2("Supermercato", 20).
companySalary2("Catena di Fast Food", 15).
companySalary2("Coltivazione Automatizzata di Cereali", 0).
companySalary2("Caseificio Automatizzato", 0).
companySalary2("Stadio", 30).
companySalary2("Hotel", 25).
companySalary2("Centro Commerciale", 20).
companySalary2("Azienda di Moda", 15).
companySalary2("Fabbrica di Dispositivi Elettronici", 0).
companySalary2("Fabbrica di Automobili", 0).
companySalary2("Azienda Farmaceutica", 30).
companySalary2("Centro Medico", 30).
companySalary2("Clinica", 20).
companySalary2("Ospedale", 20).
companySalary2("Istituto di Tecnologia", 30).
companySalary2("Università", 30).
companySalary2("Scuola Superiore", 20).
companySalary2("Accademia", 20).
companySalary2("Emittente Televisiva", 30).
companySalary2("Casa Editrice", 25).
companySalary2("Agenzia di Lobbying", 20).
companySalary2("Stazione Radiofonica", 15).

companySalary3("Supermercato (Starter)", 25).
companySalary3("Centro Commerciale (Starter)", 25).
companySalary3("Scuola Superiore (Starter)", 30).
companySalary3("Clinica (Starter)", 30).
companySalary3("Allevamento Ittico", 35).
companySalary3("Coltivazione Ortofrutticola", 30).
companySalary3("Supermercato", 25).
companySalary3("Catena di Fast Food", 20).
companySalary3("Coltivazione Automatizzata di Cereali", 0).
companySalary3("Caseificio Automatizzato", 0).
companySalary3("Stadio", 35).
companySalary3("Hotel", 30).
companySalary3("Centro Commerciale", 25).
companySalary3("Azienda di Moda", 20).
companySalary3("Fabbrica di Dispositivi Elettronici", 0).
companySalary3("Fabbrica di Automobili", 0).
companySalary3("Azienda Farmaceutica", 40).
companySalary3("Centro Medico", 40).
companySalary3("Clinica", 30).
companySalary3("Ospedale", 30).
companySalary3("Istituto di Tecnologia", 40).
companySalary3("Università", 40).
companySalary3("Scuola Superiore", 30).
companySalary3("Accademia", 30).
companySalary3("Emittente Televisiva", 40).
companySalary3("Casa Editrice", 30).
companySalary3("Agenzia di Lobbying", 30).
companySalary3("Stazione Radiofonica", 20).

companyLevel("Supermercato (Starter)", 2).
companyLevel("Centro Commerciale (Starter)", 2).
companyLevel("Scuola Superiore (Starter)", 2).
companyLevel("Clinica (Starter)", 2).
companyLevel("Allevamento Ittico", 1).
companyLevel("Coltivazione Ortofrutticola", 1).
companyLevel("Supermercato", 1).
companyLevel("Catena di Fast Food", 1).
companyLevel("Coltivazione Automatizzata di Cereali", 1).
companyLevel("Caseificio Automatizzato", 1).
companyLevel("Stadio", 1).
companyLevel("Hotel", 1).
companyLevel("Centro Commerciale", 1).
companyLevel("Azienda di Moda", 1).
companyLevel("Fabbrica di Dispositivi Elettronici", 1).
companyLevel("Fabbrica di Automobili", 1).
companyLevel("Azienda Farmaceutica", 1).
companyLevel("Centro Medico", 1).
companyLevel("Clinica", 1).
companyLevel("Ospedale", 1).
companyLevel("Istituto di Tecnologia", 1).
companyLevel("Università", 1).
companyLevel("Scuola Superiore", 1).
companyLevel("Accademia", 1).
companyLevel("Emittente Televisiva", 1).
companyLevel("Casa Editrice", 1).
companyLevel("Agenzia di Lobbying", 1).
companyLevel("Stazione Radiofonica", 1).

companyBonusProduction("Supermercato (Starter)", [couple("cibo", 1)]).
companyBonusProduction("Centro Commerciale (Starter)", [couple("lusso", 2)]).
companyBonusProduction("Scuola Superiore (Starter)", [couple("istruzione", 2)]).
companyBonusProduction("Clinica (Starter)", [couple("sanità", 2)]).
companyBonusProduction("Allevamento Ittico", [couple("cibo", 1)]).
companyBonusProduction("Coltivazione Ortofrutticola", []).
companyBonusProduction("Supermercato", [couple("cibo", 1)]).
companyBonusProduction("Catena di Fast Food", []).
companyBonusProduction("Coltivazione Automatizzata di Cereali", [couple("cibo", 2)]).
companyBonusProduction("Caseificio Automatizzato", [couple("cibo", 3)]).
companyBonusProduction("Stadio", [couple("lusso", 3)]).
companyBonusProduction("Hotel", []).
companyBonusProduction("Centro Commerciale", [couple("lusso", 2)]).
companyBonusProduction("Azienda di Moda", [couple("lusso", 2)]).
companyBonusProduction("Fabbrica di Dispositivi Elettronici", [couple("lusso", 3)]).
companyBonusProduction("Fabbrica di Automobili", [couple("lusso", 5)]).
companyBonusProduction("Azienda Farmaceutica", [couple("sanità", 3)]).
companyBonusProduction("Centro Medico", [couple("sanità", 2)]).
companyBonusProduction("Clinica", [couple("sanità", 2)]).
companyBonusProduction("Ospedale", []).
companyBonusProduction("Istituto di Tecnologia", [couple("istruzione", 3)]).
companyBonusProduction("Università", [couple("istruzione", 2)]).
companyBonusProduction("Scuola Superiore", [couple("istruzione", 2)]).
companyBonusProduction("Accademia", []).
companyBonusProduction("Emittente Televisiva", []).
companyBonusProduction("Casa Editrice", []).
companyBonusProduction("Agenzia di Lobbying", []).
companyBonusProduction("Stazione Radiofonica", []).

companyMachinery("Supermercato (Starter)", false).
companyMachinery("Centro Commerciale (Starter)", false).
companyMachinery("Scuola Superiore (Starter)", false).
companyMachinery("Clinica (Starter)", false).
companyMachinery("Allevamento Ittico", false).
companyMachinery("Coltivazione Ortofrutticola", false).
companyMachinery("Supermercato", false).
companyMachinery("Catena di Fast Food", false).
companyMachinery("Coltivazione Automatizzata di Cereali", true).
companyMachinery("Caseificio Automatizzato", true).
companyMachinery("Stadio", false).
companyMachinery("Hotel", false).
companyMachinery("Centro Commerciale", false).
companyMachinery("Azienda di Moda", false).
companyMachinery("Fabbrica di Dispositivi Elettronici", true).
companyMachinery("Fabbrica di Automobili", true).
companyMachinery("Azienda Farmaceutica", false).
companyMachinery("Centro Medico", false).
companyMachinery("Clinica", false).
companyMachinery("Ospedale", false).
companyMachinery("Istituto di Tecnologia", false).
companyMachinery("Università", false).
companyMachinery("Scuola Superiore", false).
companyMachinery("Accademia", false).
companyMachinery("Emittente Televisiva", false).
companyMachinery("Casa Editrice", false).
companyMachinery("Agenzia di Lobbying", false).
companyMachinery("Stazione Radiofonica", false).

companyProduction("Supermercato (Starter)", [couple("cibo", 4)]).
companyProduction("Centro Commerciale (Starter)", [couple("lusso", 6)]).
companyProduction("Scuola Superiore (Starter)", [couple("istruzione", 6)]).
companyProduction("Clinica (Starter)", [couple("sanità", 6)]).
companyProduction("Allevamento Ittico", [couple("cibo", 6)]).
companyProduction("Coltivazione Ortofrutticola", [couple("cibo", 5)]).
companyProduction("Supermercato", [couple("cibo", 4)]).
companyProduction("Catena di Fast Food", [couple("cibo", 3)]).
companyProduction("Coltivazione Automatizzata di Cereali", []).
companyProduction("Caseificio Automatizzato", []).
companyProduction("Stadio", [couple("lusso", 8)]).
companyProduction("Hotel", [couple("lusso", 7)]).
companyProduction("Centro Commerciale", [couple("lusso", 6)]).
companyProduction("Azienda di Moda", [couple("lusso", 4)]).
companyProduction("Fabbrica di Dispositivi Elettronici", []).
companyProduction("Fabbrica di Automobili", []).
companyProduction("Azienda Farmaceutica", [couple("sanità", 8)]).
companyProduction("Centro Medico", [couple("sanità", 9)]).
companyProduction("Clinica", [couple("sanità", 6)]).
companyProduction("Ospedale", [couple("sanità", 7)]).
companyProduction("Istituto di Tecnologia", [couple("istruzione", 8)]).
companyProduction("Università", [couple("istruzione", 9)]).
companyProduction("Scuola Superiore", [couple("istruzione", 6)]).
companyProduction("Accademia", [couple("istruzione", 7)]).
companyProduction("Emittente Televisiva", [couple("media", 4)]).
companyProduction("Casa Editrice", [couple("media", 3)]).
companyProduction("Agenzia di Lobbying", [couple("media", 3)]).
companyProduction("Stazione Radiofonica", [couple("media", 2)]).

companyWorkers("Supermercato (Starter)", ["agricoltura (o)", "generico (o)"]).
companyWorkers("Centro Commerciale (Starter)", ["lusso (m)", "generico (m)"]).
companyWorkers("Scuola Superiore (Starter)", ["istruzione (o)", "generico(o)"]).
companyWorkers("Clinica (Starter)", []).
companyWorkers("Allevamento Ittico", []).
companyWorkers("Coltivazione Ortofrutticola", []).
companyWorkers("Supermercato", []).
companyWorkers("Catena di Fast Food", []).
companyWorkers("Coltivazione Automatizzata di Cereali", []).
companyWorkers("Caseificio Automatizzato", []).
companyWorkers("Stadio", []).
companyWorkers("Hotel", []).
companyWorkers("Centro Commerciale", []).
companyWorkers("Azienda di Moda", []).
companyWorkers("Fabbrica di Dispositivi Elettronici", []).
companyWorkers("Fabbrica di Automobili", []).
companyWorkers("Azienda Farmaceutica", []).
companyWorkers("Centro Medico", []).
companyWorkers("Clinica", []).
companyWorkers("Ospedale", []).
companyWorkers("Istituto di Tecnologia", []).
companyWorkers("Università", []).
companyWorkers("Scuola Superiore", []).
companyWorkers("Accademia", []).
companyWorkers("Emittente Televisiva", []).
companyWorkers("Casa Editrice", []).
companyWorkers("Agenzia di Lobbying", []).
companyWorkers("Stazione Radiofonica", []).

// risorse visibili a tutti
prezzoCibo_CC(12).
prezzoLusso_CC(8).
prezzoSanita_CC(8).
prezzoIstruzione_CC(8).

// risorse visibili dallo Stato
capitale_CC(0).
proventi_CC(0).
cibo_CC(0).
lusso_CC(0).
sanita_CC(0).
istruzione_CC(0).
influenza_CC(0).

// risorse invisibili (valori di set-up)
capitale_CC(0).
ricchezza_CC(0).

// REGOLE INIZIALI
iscompany(X) :- privateCompany(X). // Regola per verificare se ho combinato qualche casino con la belief base
inMarket(X) :- privateCompany(X) & onTable(X) & not(created(X)).

// ESECUZIONE AZIONI
!planner.
+!planner : true <-
    !shareInitialBeliefs;
    !initialize.
    !start_narration.

// DEFINIZIONE AZIONI: Azioni comunicative
+!shareBelief(Belief) : true <- 
    .broadcast(tell, Belief).

+!shareInitialBeliefs : true <-
    .print("Espongo i prezzi delle mie merci e dei miei servizi.");
    !shareBelief(prezzoCibo_CC(12));
    !shareBelief(prezzoLusso_CC(8));
    !shareBelief(prezzoSanita_CC(8));
    !shareBelief(prezzoIstruzione_CC(8)).

+!notify_WorkingClass(Message) <-
    .print(Message);
    .send("classeOperaia", tell, done_init_CC).

+!notify_MiddleClass(Message) <-
    .print(Message);
    .send("classeMedia", tell, done_init_CC).
// Azioni di rimozione risorse (a seguito di un messaggio)
+!removeResource(Resource) : true <-
    if (Resource == "capitale_CC") {
        -capitale_CC(_);
    }
    if (Resource == "proventi_CC") {
        -proventi_CC(_);
    }
    if (Resource == "cibo_CC") {
        -cibo_CC(_);
    }
    if (Resource == "lusso_CC") {
        -lusso_CC(_);
    }
    if (Resource == "sanita_CC") {
        -sanita_CC(_);
    }
    if (Resource == "istruzione_CC") {
        -istruzione_CC(_);
    }
    if (Resource == "influenza_CC") {
        -influenza_CC(_);
    }
    .print("Ho aggiornato ", Resource, " a seguito di un messaggio dallo Stato.").

// Azioni di controllo
+!allPrivateCompany : privateCompany(X) & not acknowledged(X) <-
    .print("Ok, ", X, " è un'azienda privata");
    +acknowledged(X);
    !isPrivateCompany. // recursion to check all the private companies

+!allPrivateCompany : true <- // Caso base per ricorsione
    .print("Ho finito di controllare le aziende private"). // fallback: necessario per evitare errori nella MAS Console

+!isOnTable(Company) : onTable(Company) <- 
    .print("L'azienda ", Company, " è sul tabellone").

// Azioni di crezione e rimozione delle aziende private
+!addCompany(Company) : companyIndustry(Company, Industry)
                            & companyCost(Company, Cost)
                            & companyRequirements(Company, Requirements) 
                            & companySalary1(Company, Salary1)
                            & companySalary2(Company, Salary2)
                            & companySalary3(Company, Salary3)
                            & companyLevel(Company, Level)
                            & companyBonusProduction(Company, BonusProduction)
                            & companyMachinery(Company, Machinery)
                            & companyProduction(Company, Production)
                            & companyWorkers(Company, Workers) <- 
    createPrivateCompany(Company, Industry, Cost, Requirements, Salary1, Salary2, Salary3, Level, BonusProduction, Machinery, Production, Workers);
    .print("Azienda privata creata: ", Company);
    +onTable(Company);
    +created(Company);
    !shareBelief(onTable(Company));
    !shareBelief(created(Company));
    .concat("You created the company ", Company, Msg);
    !log(Msg).
    
+!removeCompany(Company) : privateCompany(Company) <- 
    removePrivateCompany(Company);
    -onTable(Company);
    -created(Company);
    !shareBelief(onTable(Company));
    !shareBelief(created(Company));
    .concat("You removed the company ", Company, Msg);
    !log(Msg).

+!addCompanyToMarket(Company) : privateCompany(Company) <- 
    +onTable(Company);
    !shareBelief(onTable(Company));
    .print("Mercato: ", Company);
    .concat("You added the company ", Company, Partial);
    .concat(Partial, " to the market", Msg);
    !log(Msg).

// Azioni di utilità per le aziende private
+!matchCompany(Number, StoredCompany) : true <- 
    if (Number == 0) {
        StoredCompany = "Supermercato (Starter)";
    }
    if (Number == 1) {
        StoredCompany = "Centro Commerciale (Starter)";
    }
    if (Number == 2) {
        StoredCompany = "Scuola Superiore (Starter)";
    }
    if (Number == 3) {
        StoredCompany = "Clinica (Starter)";
    }
    if (Number == 4) {
        StoredCompany = "Allevamento Ittico";
    }
    if (Number == 5) {
        StoredCompany = "Coltivazione Ortofrutticola";
    }
    if (Number == 6) {
        StoredCompany = "Supermercato";
    }
    if (Number == 7) {
        StoredCompany = "Catena di Fast Food";
    }
    if (Number == 8) {
        StoredCompany = "Coltivazione Automatizzata di Cereali";
    }
    if (Number == 9) {
        StoredCompany = "Caseificio Automatizzato";
    }
    if (Number == 10) {
        StoredCompany = "Stadio";
    }
    if (Number == 11) {
        StoredCompany = "Hotel";
    }
    if (Number == 12) {
        StoredCompany = "Centro Commerciale";
    }
    if (Number == 13) {
        StoredCompany = "Azienda di Moda";
    }
    if (Number == 14) {
        StoredCompany = "Fabbrica di Dispositivi Elettronici";
    }
    if (Number == 15) {
        StoredCompany = "Fabbrica di Automobili";
    }
    if (Number == 16) {
        StoredCompany = "Azienda Farmaceutica";
    }
    if (Number == 17) {
        StoredCompany = "Centro Medico";
    }
    if (Number == 18) {
        StoredCompany = "Clinica";
    }
    if (Number == 19) {
        StoredCompany = "Ospedale";
    }
    if (Number == 20) {
        StoredCompany = "Istituto di Tecnologia";
    }
    if (Number == 21) {
        StoredCompany = "Università";
    }
    if (Number == 22) {
        StoredCompany = "Scuola Superiore";
    }
    if (Number == 23) {
        StoredCompany = "Accademia";
    }
    if (Number == 24) {
        StoredCompany = "Emittente Televisiva";
    }
    if (Number == 25) {
        StoredCompany = "Casa Editrice";
    }
    if (Number == 26) {
        StoredCompany = "Agenzia di Lobbying";
    }
    if (Number == 27) {
        StoredCompany = "Stazione Radiofonica";
    }.

+!randomCompany(F): true <-
    .random(Raw);
    R = (Raw * 28); // 28 possibili aziende private
    F = math.floor(R).

+!randomCompanyNotOnTable : true <-
    !randomCompany(F);
    !matchCompany(F, StoredCompany);
    if (onTable(StoredCompany)) {
        !randomCompanyNotOnTable;
    } else {
        !addCompany(StoredCompany);
    }.

+!randomMarketCompany : true <-
    !randomCompany(F);
    !matchCompany(F, StoredCompany);
    if (onTable(StoredCompany)) {
        !randomMarketCompany;
    } else {
        !addCompanyToMarket(StoredCompany);
    }.

// Azioni principali (azioni di gioco)
+!createMarket : true <-
    .print("Creo il mercato delle aziende private...\nNota: il mercato non è visibile sulla plancia di gioco");
    !randomMarketCompany;
    !randomMarketCompany;
    !randomMarketCompany;
    !randomMarketCompany.

+!initialize : true <- 
    .print("Creazione delle Aziende Private..."); 
    !addCompany("Supermercato (Starter)");
    !addCompany("Centro Commerciale (Starter)");
    !addCompany("Scuola Superiore (Starter)");
    !addCompany("Clinica (Starter)");

    !randomCompanyNotOnTable; // two random private company
    !randomCompanyNotOnTable; 
    
    !notify_WorkingClass("Inizializzazione conclusa: notifico la classe operaia.");
    !notify_MiddleClass("Inizializzazione conclusa: notifico la classe media.");
    !log("You told working and middle class that you created companies to work in.").
    !createMarket. // Nota: non è importante se viene eseguito prima o dopo notify_WorkingClass, per questo hanno entrambe il "punto" alla fine.

// Azioni di narrazione
+!log(Msg) <-
    .my_name(Name);
    .concat(Msg, LogEntry);
    +log_entry(LogEntry).

+!start_narration <-
    .wait(3000);  // Wait 3 seconds (adjust as needed)
    .findall(L, log_entry(L), Logs);
    .term2string(Logs, FinalLogs);
    executeScript("./scripts/generator_CC.py", FinalLogs);
    !tell_story.

+!tell_story : script_output(Story) <-
    .print("\nLa Classe Capitalista dice:\n", Story).

// DEBUG
+!debugOnTable <- 
    .findall(X, onTable(X), CompaniesOnTable);
    .print("Current onTable beliefs: ", CompaniesOnTable).