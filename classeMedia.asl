// BELIEFS: CLASSE OPERAIA
player("CC").
player("CO").
player("CM").
player("Stato").

smallCompany("Minimarket (Starter)").
smallCompany("Ambulatorio Medico (Starter)").
smallCompany("Ristorante Fast Food").
smallCompany("Minimarket").
smallCompany("Fattoria Biologica").
smallCompany("Gioielleria").
smallCompany("Negozio di Giochi").
smallCompany("Negozio di Elettronica").
smallCompany("Farmacia").
smallCompany("Ambulatorio Medico").
smallCompany("Laboratorio di Analisi").
smallCompany("Centro di Specializzazione").
smallCompany("Azienda di Tutoring").
smallCompany("Scuola Privata").
smallCompany("Agenzia di Pubbliche Relazioni").
smallCompany("Quotidiano Locale").
smallCompany("Stazione Radiofonica Regionale").

companyIndustry("Minimarket (Starter)", "Agricoltura").
companyIndustry("Ambulatorio Medico (Starter)", "Sanità").
companyIndustry("Ristorante Fast Food", "Agricoltura").
companyIndustry("Minimarket", "Agricoltura").
companyIndustry("Fattoria Biologica", "Agricoltura").
companyIndustry("Gioielleria", "Lusso").
companyIndustry("Negozio di Giochi", "Lusso").
companyIndustry("Negozio di Elettronica", "Lusso").
companyIndustry("Farmacia", "Sanità").
companyIndustry("Ambulatorio Medico", "Sanità").
companyIndustry("Laboratorio di Analisi", "Sanità").
companyIndustry("Centro di Specializzazione", "Istruzione").
companyIndustry("Azienda di Tutoring", "Istruzione").
companyIndustry("Scuola Privata", "Istruzione").
companyIndustry("Agenzia di Pubbliche Relazioni", "Media").
companyIndustry("Quotidiano Locale", "Media").
companyIndustry("Stazione Radiofonica Regionale", "Media").

companyCost("Minimarket (Starter)", 14).
companyCost("Ambulatorio Medico (Starter)", 12).
companyCost("Ristorante Fast Food", 20).
companyCost("Minimarket", 14).
companyCost("Fattoria Biologica", 20).
companyCost("Gioielleria", 16).
companyCost("Negozio di Giochi", 12).
companyCost("Negozio di Elettronica", 20).
companyCost("Farmacia", 16).
companyCost("Ambulatorio Medico", 12).
companyCost("Laboratorio di Analisi", 20).
companyCost("Centro di Specializzazione", 16).
companyCost("Azienda di Tutoring", 12).
companyCost("Scuola Privata", 20).
companyCost("Agenzia di Pubbliche Relazioni", 20).
companyCost("Quotidiano Locale", 14).
companyCost("Stazione Radiofonica Regionale", 20).

companyRequirements("Minimarket (Starter)", ["agricoltura (m)"]).
companyRequirements("Ambulatorio Medico (Starter)", ["sanità (m)"]).
companyRequirements("Ristorante Fast Food", ["agricoltura (m)", "generico (m)"]).
companyRequirements("Minimarket", ["agricoltura (m)"]).
companyRequirements("Fattoria Biologica", ["agricoltura (m)"]).
companyRequirements("Gioielleria", ["lusso (m)", "generico (m)"]).
companyRequirements("Negozio di Giochi", ["lusso (m)"]).
companyRequirements("Negozio di Elettronica", ["lusso (m)"]).
companyRequirements("Farmacia", ["sanità (m)", "generico (m)"]).
companyRequirements("Ambulatorio Medico", ["sanità (m)"]).
companyRequirements("Laboratorio di Analisi", ["sanità (m)"]).
companyRequirements("Centro di Specializzazione", ["istruzione (m)", "generico (m)"]).
companyRequirements("Azienda di Tutoring", ["istruzione (m)"]).
companyRequirements("Scuola Privata", ["istruzione (m)"]).
companyRequirements("Agenzia di Pubbliche Relazioni", ["media (m)", "generico (m)"]).
companyRequirements("Quotidiano Locale", ["media (m)"]).
companyRequirements("Stazione Radiofonica Regionale", ["media (m)"]).

companySalary1("Minimarket (Starter)", 6).
companySalary1("Ambulatorio Medico (Starter)", 6).
companySalary1("Ristorante Fast Food", 0).
companySalary1("Minimarket", 6).
companySalary1("Fattoria Biologica", 9).
companySalary1("Gioielleria", 0).
companySalary1("Negozio di Giochi", 6).
companySalary1("Negozio di Elettronica", 9).
companySalary1("Farmacia", 0).
companySalary1("Ambulatorio Medico", 6).
companySalary1("Laboratorio di Analisi", 9).
companySalary1("Centro di Specializzazione", 0).
companySalary1("Azienda di Tutoring", 6).
companySalary1("Scuola Privata", 9).
companySalary1("Agenzia di Pubbliche Relazioni", 0).
companySalary1("Quotidiano Locale", 6).
companySalary1("Stazione Radiofonica Regionale", 9).

companySalary2("Minimarket (Starter)", 8).
companySalary2("Ambulatorio Medico (Starter)", 8).
companySalary2("Ristorante Fast Food", 0).
companySalary2("Minimarket", 8).
companySalary2("Fattoria Biologica", 12).
companySalary2("Gioielleria", 0).
companySalary2("Negozio di Giochi", 8).
companySalary2("Negozio di Elettronica", 12).
companySalary2("Farmacia", 0).
companySalary2("Ambulatorio Medico", 8).
companySalary2("Laboratorio di Analisi", 12).
companySalary2("Centro di Specializzazione", 0).
companySalary2("Azienda di Tutoring", 8).
companySalary2("Scuola Privata", 12).
companySalary2("Agenzia di Pubbliche Relazioni", 0).
companySalary2("Quotidiano Locale", 8).
companySalary2("Stazione Radiofonica Regionale", 12).

companySalary3("Minimarket (Starter)", 10).
companySalary3("Ambulatorio Medico (Starter)", 10).
companySalary3("Ristorante Fast Food", 0).
companySalary3("Minimarket", 10).
companySalary3("Fattoria Biologica", 15).
companySalary3("Gioielleria", 0).
companySalary3("Negozio di Giochi", 10).
companySalary3("Negozio di Elettronica", 15).
companySalary3("Farmacia", 0).
companySalary3("Ambulatorio Medico", 10).
companySalary3("Laboratorio di Analisi", 15).
companySalary3("Centro di Specializzazione", 0).
companySalary3("Azienda di Tutoring", 10).
companySalary3("Scuola Privata", 15).
companySalary3("Agenzia di Pubbliche Relazioni", 0).
companySalary3("Quotidiano Locale", 10).
companySalary3("Stazione Radiofonica Regionale", 15).

companyLevel("Minimarket (Starter)", 2).
companyLevel("Ambulatorio Medico (Starter)", 2).
companyLevel("Ristorante Fast Food", 1).
companyLevel("Minimarket", 1).
companyLevel("Fattoria Biologica", 1).
companyLevel("Gioielleria", 1).
companyLevel("Negozio di Giochi", 1).
companyLevel("Negozio di Elettronica", 1).
companyLevel("Farmacia", 1).
companyLevel("Ambulatorio Medico", 1).
companyLevel("Laboratorio di Analisi", 1).
companyLevel("Centro di Specializzazione", 1).
companyLevel("Azienda di Tutoring", 1).
companyLevel("Scuola Privata", 1).
companyLevel("Agenzia di Pubbliche Relazioni", 1).
companyLevel("Quotidiano Locale", 1).
companyLevel("Stazione Radiofonica Regionale", 1).

companyBonusProduction("Minimarket (Starter)", [couple("cibo", 1)]).
companyBonusProduction("Ambulatorio Medico (Starter)", [couple("sanità", 2)]).
companyBonusProduction("Ristorante Fast Food", []).
companyBonusProduction("Minimarket", [couple("cibo", 1)]).
companyBonusProduction("Fattoria Biologica", [couple("cibo", 2)]).
companyBonusProduction("Gioielleria", []).
companyBonusProduction("Negozio di Giochi", [couple("lusso", 2)]).
companyBonusProduction("Negozio di Elettronica", [couple("lusso", 4)]).
companyBonusProduction("Farmacia", []).
companyBonusProduction("Ambulatorio Medico", [couple("sanità", 2)]).
companyBonusProduction("Laboratorio di Analisi", [couple("sanità", 4)]).
companyBonusProduction("Centro di Specializzazione", []).
companyBonusProduction("Azienda di Tutoring", [couple("istruzione", 2)]).
companyBonusProduction("Scuola Privata", [couple("istruzione", 4)]).
companyBonusProduction("Agenzia di Pubbliche Relazioni", []).
companyBonusProduction("Quotidiano Locale", [couple("influenza", 1)]).
companyBonusProduction("Stazione Radiofonica Regionale", [couple("influenza", 2)]).

companyEmployee("Minimarket (Starter)", false).
companyEmployee("Ambulatorio Medico (Starter)", false).
companyEmployee("Ristorante Fast Food", false).
companyEmployee("Minimarket", false).
companyEmployee("Fattoria Biologica", false).
companyEmployee("Gioielleria", false).
companyEmployee("Negozio di Giochi", false).
companyEmployee("Negozio di Elettronica", false).
companyEmployee("Farmacia", false).
companyEmployee("Ambulatorio Medico", false).
companyEmployee("Laboratorio di Analisi", false).
companyEmployee("Centro di Specializzazione", false).
companyEmployee("Azienda di Tutoring", false).
companyEmployee("Scuola Privata", false).
companyEmployee("Agenzia di Pubbliche Relazioni", false).
companyEmployee("Quotidiano Locale", false).
companyEmployee("Stazione Radiofonica Regionale", false).

companyEmployeeType("Minimarket (Starter)", "generico (o)").
companyEmployeeType("Ambulatorio Medico (Starter)", "generico (o)").
companyEmployeeType("Ristorante Fast Food", "").
companyEmployeeType("Minimarket", "generico (o)").
companyEmployeeType("Fattoria Biologica", "agricoltura (o)").
companyEmployeeType("Gioielleria", "").
companyEmployeeType("Negozio di Giochi", "generico (o)").
companyEmployeeType("Negozio di Elettronica", "lusso (o)").
companyEmployeeType("Farmacia", "").
companyEmployeeType("Ambulatorio Medico", "generico (o)").
companyEmployeeType("Laboratorio di Analisi", "sanità (o)").
companyEmployeeType("Centro di Specializzazione", "").
companyEmployeeType("Azienda di Tutoring", "generico (o)").
companyEmployeeType("Scuola Privata", "istruzione (o)").
companyEmployeeType("Agenzia di Pubbliche Relazioni", "").
companyEmployeeType("Quotidiano Locale", "generico (o)").
companyEmployeeType("Stazione Radiofonica Regionale", "media (o)").

companyProduction("Minimarket (Starter)", [couple("cibo", 2)]).
companyProduction("Ambulatorio Medico (Starter)", [couple("sanità", 2)]).
companyProduction("Ristorante Fast Food", [couple("cibo", 3)]).
companyProduction("Minimarket", [couple("cibo", 2)]).
companyProduction("Fattoria Biologica", [couple("cibo", 2)]).
companyProduction("Gioielleria", [couple("lusso", 4)]).
companyProduction("Negozio di Giochi", [couple("lusso", 2)]).
companyProduction("Negozio di Elettronica", [couple("lusso", 2)]).
companyProduction("Farmacia", [couple("sanità", 4)]).
companyProduction("Ambulatorio Medico", [couple("sanità", 2)]).
companyProduction("Laboratorio di Analisi", [couple("sanità", 2)]).
companyProduction("Centro di Specializzazione", [couple("istruzione", 4)]).
companyProduction("Azienda di Tutoring", [couple("istruzione", 2)]).
companyProduction("Scuola Privata", [couple("istruzione", 2)]).
companyProduction("Agenzia di Pubbliche Relazioni", [couple("influenza", 3)]).
companyProduction("Quotidiano Locale", [couple("influenza", 2)]).
companyProduction("Stazione Radiofonica Regionale", [couple("influenza", 2)]).

companyWorkers("Minimarket (Starter)", ["agricoltura (m)"]).
companyWorkers("Ambulatorio Medico (Starter)", ["sanità (m)"]).
companyWorkers("Ristorante Fast Food", []).
companyWorkers("Minimarket", []).
companyWorkers("Fattoria Biologica", []).
companyWorkers("Gioielleria", []).
companyWorkers("Negozio di Giochi", []).
companyWorkers("Negozio di Elettronica", []).
companyWorkers("Farmacia", []).
companyWorkers("Ambulatorio Medico", []).
companyWorkers("Laboratorio di Analisi", []).
companyWorkers("Centro di Specializzazione", []).
companyWorkers("Azienda di Tutoring", []).
companyWorkers("Scuola Privata", []).
companyWorkers("Agenzia di Pubbliche Relazioni", []).
companyWorkers("Quotidiano Locale", []).
companyWorkers("Stazione Radiofonica Regionale", []).

// risorse visibili a tutti
prezzoCibo_CM(12).
prezzoSanita_CM(8).
prezzoLusso_CM(8).
prezzoIstruzione_CM(8).

// risorse visibili dallo Stato
introiti_CM(40).
cibo_CM(1).
lusso_CM(0).
sanita_CM(1).
istruzione_CM(0).
influenza_CM(0).

// risorse invisibili (valori di set-up)
popolazione_CM(10).
prosperita_CM(0).

// REGOLE INIZIALI
inMarket(X) :- privateCompany(X) & onTable(X) & not(created(X)).

// ESECUZIONE AZIONI
!planner.
+!planner : true <-
    !initializeWorkers;
    !shareInitialBeliefs;
    !waitForCompletion;
    !start_narration.

// DEFINIZIONE AZIONI: Azioni comunicative
+!shareBelief(Belief) : true <- 
    .broadcast(tell, Belief).

+!shareInitialBeliefs : true <-
    .print("Condivido i miei belief iniziali...");
    !shareBelief(prezzoCibo_CM(12));
    !shareBelief(prezzoSanita_CM(8));
    !shareBelief(prezzoLusso_CM(8));
    !shareBelief(prezzoIstruzione_CM(8)).

+!notify_WorkingClass(Message) <-
    .print(Message);
    .send("classeOperaia", tell, done_init_CM).

// Azioni di rimozione risorse (a seguito di un messaggio)
+!removeResource(Resource) : true <-
    if (Resource == "introiti_CM") {
        -introiti_CM(_);
    }
    if (Resource == "cibo_CM") {
        -cibo_CM(_);
    }
    if (Resource == "lusso_CM") {
        -lusso_CM(_);
    }
    if (Resource == "sanita_CM") {
        -sanita_CM(_);
    }
    if (Resource == "istruzione_CM") {
        -istruzione_CM(_);
    }
    if (Resource == "influenza_CM") {
        -influenza_CM(_);
    };
    .print("Ho aggiornato ", Resource, " a seguito di un messaggio dallo Stato.").

// Azioni di attesa
+!waitForCompletion : true <-
    if (done_init_CC & done_init_Stato) {
        !initialize;
    } else {
        .print("Aspetto che gli altri giocatori finiscano l'inizializzazione delle Aziende...");
        .wait(1000);
        !waitForCompletion;
    }.

// Azioni di controllo
+!isOnTable(Company) : onTable(Company) <- 
    .print("L'azienda ", Company, " è sul tabellone").
+!isOnTable(Company) : not onTable(Company) <- 
    .print("L'azienda ", Company, " non è sul tabellone").

// Azioni di creazione e rimozione delle piccole aziende 
+!addCompany(Company) : companyIndustry(Company, Industry)
                            & companyCost(Company, Cost)
                            & companyRequirements(Company, Requirements) 
                            & companySalary1(Company, Salary1)
                            & companySalary2(Company, Salary2)
                            & companySalary3(Company, Salary3)
                            & companyLevel(Company, Level)
                            & companyBonusProduction(Company, BonusProduction)
                            & companyEmployee(Company, Employee)
                            & companyEmployeeType(Company, EmployeeType)
                            & companyProduction(Company, Production)
                            & companyWorkers(Company, Workers) <- 
    createSmallCompany(Company, Industry, Cost, Requirements, Salary1, Salary2, Salary3, Level, BonusProduction, Employee, EmployeeType, Production, Workers);
    .print("Piccola Azienda creata: ", Company);
    +onTable(Company);
    +created(Company);
    !shareBelief(onTable(Company));
    !shareBelief(created(Company));
    .concat("You created the company ", Company, Msg);
    !log(Msg).
    
+!removeCompany(Company) : smallCompany(Company) <- 
    removeSmallCompany(Company);
    -onTable(Company);
    -created(Company);
    !shareBelief(onTable(Company));
    !shareBelief(created(Company));
    .concat("You removed the company ", Company, Msg);
    !log(Msg).

+!addCompanyToMarket(Company) : smallCompany(Company) <- 
    +onTable(Company);
    !shareBelief(onTable(Company));
    .print("Mercato: ", Company);
    .concat("You added the company ", Company, Partial);
    .concat(Partial, " to the market", Msg);
    !log(Msg).
// Azioni di utilità per le piccole aziende
+!matchCompany(Number, StoredCompany) : true <- 
    if (Number == 0) {
        StoredCompany = "Minimarket (Starter)";
    }
    if (Number == 1) {
        StoredCompany = "Ambulatorio Medico (Starter)";
    }
    if (Number == 2) {
        StoredCompany = "Ristorante Fast Food";
    }
    if (Number == 3) {
        StoredCompany = "Minimarket";
    }
    if (Number == 4) {
        StoredCompany = "Fattoria Biologica";
    }
    if (Number == 5) {
        StoredCompany = "Gioielleria";
    }
    if (Number == 6) {
        StoredCompany = "Negozio di Giochi";
    }
    if (Number == 7) {
        StoredCompany = "Negozio di Elettronica";
    }
    if (Number == 8) {
        StoredCompany = "Farmacia";
    }
    if (Number == 9) {
        StoredCompany = "Ambulatorio Medico";
    }
    if (Number == 10) {
        StoredCompany = "Laboratorio di Analisi";
    }
    if (Number == 11) {
        StoredCompany = "Centro di Specializzazione";
    }
    if (Number == 12) {
        StoredCompany = "Azienda di Tutoring";
    }
    if (Number == 13) {
        StoredCompany = "Scuola Privata";
    }
    if (Number == 14) {
        StoredCompany = "Agenzia di Pubbliche Relazioni";
    }
    if (Number == 15) {
        StoredCompany = "Quotidiano Locale";
    }
    if (Number == 16) {
        StoredCompany = "Stazione Radiofonica Regionale";
    }.

+!randomCompany(F): true <-
    .random(Raw);
    R = (Raw * 17); // 17 possibili piccole aziende
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

// Azioni per la creazione e la distruzione dei lavoratori
+!addWorkers(Number, Type) : true <-
    createWorker(Number, Type);
    .print(Number, " lavoratori del settore ", Type, " sono entrati nel mercato del lavoro.");
    if (Type == "generico (m)") {
        +lavoratoriMediGenerici(Number);
    }
    if (Type == "agricoltura (m)") {
        +lavoratoriMediAgrario(Number);
    }
    if (Type == "lusso (m)") {
        +lavoratoriMediLusso(Number);
    }
    if (Type == "sanita (m)") {
        +lavoratoriMediSanita(Number);
    }
    if (Type == "istruzione (m)") {
        +lavoratoriMediIstruzione(Number);
    }
    if (Type == "media (m)") {
        +lavoratoriMediMedia(Number);
    };
    .concat("You created workers in the sector ", Type, Msg);
    !log(Msg).

+!removeWorkers(Number, Type) : true <-
    .print(Number, " lavoratori del settore ", Type, " sono usciti dal mercato del lavoro.");
    killWorker(Number, Type);
    if (Type == "generico (m)") {
        -lavoratoriMediGenerici(Number);
    }
    if (Type == "agricoltura (m)") {
        -lavoratoriMediAgrario(Number);
    }
    if (Type == "lusso (m)") {
        -lavoratoriMediLusso(Number);
    }
    if (Type == "sanita (m)") {
        -lavoratoriMediSanita(Number);
    }
    if (Type == "istruzione (m)") {
        -lavoratoriMediIstruzione(Number);
    }
    if (Type == "media (m)") {
        -lavoratoriMediMedia(Number);
    }.
// Azioni di assunzione dei lavoratori della classe media
+!placeWorker(Worker, Company) : onTable(Company) & created(Company) <- 
    .print("Il lavoratore ", Worker, " è stato assunto nell'azienda ", Company);
    assumeWorker(Worker, Company);
    if (Worker == "generico (m)") {
        -lavoratoriMediGenerici(1);
    }
    if (Worker == "agricoltura (m)") {
        -lavoratoriMediAgrario(1);
    }
    if (Worker == "lusso (m)") {
        -lavoratoriMediLusso(1);
    }
    if (Worker == "sanita (m)") {
        -lavoratoriMediSanita(1);
    }
    if (Worker == "istruzione (m)") {
        -lavoratoriMediIstruzione(1);
    }
    if (Worker == "media (m)") {
        -lavoratoriMediMedia(1);
    }.

+!placeWorker(Worker, Company) : onTable(Company) & not created(Company) <-
    .print("L'azienda ", Company, " non è stata creata").
+!placeWorker(Worker, Company) : not onTable(Company) <- 
    .print("L'azienda ", Company, " non è sul tabellone").

// Azioni principali (azioni di gioco)
+!createMarket : true <-
    .print("Creo il mercato delle piccole aziende...\nNota: il mercato non è visibile sulla plancia di gioco");
    !randomMarketCompany;
    !randomMarketCompany;
    !randomMarketCompany.

+!initializeWorkers : true <-
    .print("Creo il mercato del lavoro della classe media...");
    !addWorkers(20, "generico (m)");
    !addWorkers(6, "agricoltura (m)");
    !addWorkers(6, "lusso (m)");
    !addWorkers(6, "sanità (m)");
    !addWorkers(6, "istruzione (m)");
    !addWorkers(6, "media (m)").

+!placeMiddleClassWorkers : true <-
    !placeWorker("istruzione (m)", "Politecnico");
    !placeWorker("generico (m)", "Politecnico");
    !placeWorker("generico (m)", "Politecnico");

    !placeWorker("lusso (m)", "Centro Commerciale (Starter)");

    !placeWorker("agricoltura (m)", "Minimarket (Starter)");

    !placeWorker("sanità (m)", "Ambulatorio Medico (Starter)").

+!initialize : true <- 
    .print("Creazione delle Aziende Piccole..."); 
    !addCompany("Minimarket (Starter)");
    !addCompany("Ambulatorio Medico (Starter)");

    !randomCompanyNotOnTable; // one random middle company

    !notify_WorkingClass("Inizializzazione conclusa: notifico la classe operaia.");
    !log("You told working and middle class that you created companies to work in.");
    !placeMiddleClassWorkers.
    !createMarket.

// Azioni di narrazione
+!log(Msg) <-
    .my_name(Name);
    .concat(Msg, LogEntry);
    +log_entry(LogEntry).

+!start_narration <-
    .wait(3000);  // Wait 3 seconds (adjust as needed)
    .findall(L, log_entry(L), Logs);
    .term2string(Logs, FinalLogs);
    executeScript("./scripts/generator_CM.py", FinalLogs);
    !tell_story.

+!tell_story : script_output(Story) <-
    .print("\nLa Classe Media dice:\n", Story).

// DEBUG
+!debugOnTable <- 
    .findall(X, onTable(X), CompaniesOnTable);
    .print("Current onTable beliefs: ", CompaniesOnTable).