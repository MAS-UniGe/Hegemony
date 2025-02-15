// BELIEFS: CLASSE CAPITALISTA
player("CC").
player("CO").
player("CM").
player("Stato").

segnaliniCibo("Ambiente", 62).
segnaliniLusso("Ambiente", 64).
segnaliniSanita("Ambiente", 64).
segnaliniIstruzione("Ambiente", 64).
segnaliniMacchinario("Ambiente", 6).
segnaliniManifestazione("Ambiente", 1).
segnaliniSciopero("Ambiente", 7).
segnaliniVardis("Ambiente", 1515).
segnaliniLegittimitaOperaia("Ambiente", 6).
segnaliniLegittimitaMedia("Ambiente", 6).
segnaliniLegittimitaCapitalista("Ambiente", 6).

publicCompany("Radiotelevisione Statale").
publicCompany("Emittente Televisiva Regionale (1)").
publicCompany("Emittente Televisiva Regionale (2)").
publicCompany("Ospedale Universitario").
publicCompany("Ospedale Pubblico (1)").
publicCompany("Ospedale Pubblico (2)").
publicCompany("Politecnico").
publicCompany("Università Pubblica (1)").
publicCompany("Università Pubblica (2)").

companyIndustry("Radiotelevisione Statale", "Media").
companyIndustry("Emittente Televisiva Regionale (1)", "Media").
companyIndustry("Emittente Televisiva Regionale (2)", "Media").
companyIndustry("Ospedale Universitario", "Sanità").
companyIndustry("Ospedale Pubblico (1)", "Sanità").
companyIndustry("Ospedale Pubblico (2)", "Sanità").
companyIndustry("Politecnico", "Istruzione").
companyIndustry("Università Pubblica (1)", "Istruzione").
companyIndustry("Università Pubblica (2)", "Istruzione").

companyCost("Radiotelevisione Statale", 30).
companyCost("Emittente Televisiva Regionale (1)", 20).
companyCost("Emittente Televisiva Regionale (2)", 20).
companyCost("Ospedale Universitario", 30).
companyCost("Ospedale Pubblico (1)", 20).
companyCost("Ospedale Pubblico (2)", 20).
companyCost("Politecnico", 30).
companyCost("Università Pubblica (1)", 20).
companyCost("Università Pubblica (2)", 20).

companyRequirements("Radiotelevisione Statale", ["media (q)", "generico (q)", "generico (q)"]).
companyRequirements("Emittente Televisiva Regionale (1)", ["media (q)", "generico (q)"]).
companyRequirements("Emittente Televisiva Regionale (2)", ["media (q)", "generico (q)"]).
companyRequirements("Ospedale Universitario", ["sanità (q)", "generico (q)", "generico (q)"]).
companyRequirements("Ospedale Pubblico (1)", ["sanità (q)", "generico (q)"]).
companyRequirements("Ospedale Pubblico (2)", ["sanità (q)", "generico (q)"]).
companyRequirements("Politecnico", ["istruzione (q)", "generico (q)", "generico (q)"]).
companyRequirements("Università Pubblica (1)", ["istruzione (q)", "generico (q)"]).
companyRequirements("Università Pubblica (2)", ["istruzione (q)", "generico (q)"]).

companySalary1("Radiotelevisione Statale", 25).
companySalary1("Emittente Televisiva Regionale (1)", 15).
companySalary1("Emittente Televisiva Regionale (2)", 15).
companySalary1("Ospedale Universitario", 25).
companySalary1("Ospedale Pubblico (1)", 15).
companySalary1("Ospedale Pubblico (2)", 15).
companySalary1("Politecnico", 25).
companySalary1("Università Pubblica (1)", 15).
companySalary1("Università Pubblica (2)", 15).

companySalary2("Radiotelevisione Statale", 30).
companySalary2("Emittente Televisiva Regionale (1)", 20).
companySalary2("Emittente Televisiva Regionale (2)", 20).
companySalary2("Ospedale Universitario", 30).
companySalary2("Ospedale Pubblico (1)", 20).
companySalary2("Ospedale Pubblico (2)", 20).
companySalary2("Politecnico", 30).
companySalary2("Università Pubblica (1)", 20).
companySalary2("Università Pubblica (2)", 20).

companySalary3("Radiotelevisione Statale", 35).
companySalary3("Emittente Televisiva Regionale (1)", 25).
companySalary3("Emittente Televisiva Regionale (2)", 25).
companySalary3("Ospedale Universitario", 35).
companySalary3("Ospedale Pubblico (1)", 25).
companySalary3("Ospedale Pubblico (2)", 25).
companySalary3("Politecnico", 35).
companySalary3("Università Pubblica (1)", 25).
companySalary3("Università Pubblica (2)", 25).

companyLevel("Radiotelevisione Statale", 2).
companyLevel("Emittente Televisiva Regionale (1)", 1).
companyLevel("Emittente Televisiva Regionale (2)", 1).
companyLevel("Ospedale Universitario", 2).
companyLevel("Ospedale Pubblico (1)", 1).
companyLevel("Ospedale Pubblico (2)", 1).
companyLevel("Politecnico", 2).
companyLevel("Università Pubblica (1)", 1).
companyLevel("Università Pubblica (2)", 1).

companyBonusProduction("Radiotelevisione Statale", []).
companyBonusProduction("Emittente Televisiva Regionale (1)", []).
companyBonusProduction("Emittente Televisiva Regionale (2)", []).
companyBonusProduction("Ospedale Universitario", []).
companyBonusProduction("Ospedale Pubblico (1)", []).
companyBonusProduction("Ospedale Pubblico (2)", []).
companyBonusProduction("Politecnico", []).
companyBonusProduction("Università Pubblica (1)", []).
companyBonusProduction("Università Pubblica (2)", []).

companyMachinery("Radiotelevisione Statale", false).
companyMachinery("Emittente Televisiva Regionale (1)", false).
companyMachinery("Emittente Televisiva Regionale (2)", false).
companyMachinery("Ospedale Universitario", false).
companyMachinery("Ospedale Pubblico (1)", false).
companyMachinery("Ospedale Pubblico (2)", false).
companyMachinery("Politecnico", false).
companyMachinery("Università Pubblica (1)", false).
companyMachinery("Università Pubblica (2)", false).

companyProduction("Radiotelevisione Statale", [couple("influenza", 4)]).
companyProduction("Emittente Televisiva Regionale (1)", [couple("influenza", 3)]).
companyProduction("Emittente Televisiva Regionale (2)", [couple("influenza", 3)]).
companyProduction("Ospedale Universitario", [couple("sanità", 6)]).
companyProduction("Ospedale Pubblico (1)", [couple("sanità", 4)]).
companyProduction("Ospedale Pubblico (2)", [couple("sanità", 4)]).
companyProduction("Politecnico", [couple("istruzione", 6)]).
companyProduction("Università Pubblica (1)", [couple("istruzione", 4)]).
companyProduction("Università Pubblica (2)", [couple("istruzione", 4)]).

companyWorkers("Radiotelevisione Statale", []).
companyWorkers("Emittente Televisiva Regionale (1)", []).
companyWorkers("Emittente Televisiva Regionale (2)", []).
companyWorkers("Ospedale Universitario", ["sanità (o)", "generico (o)", "generico (o)"]).
companyWorkers("Ospedale Pubblico (1)", []).
companyWorkers("Ospedale Pubblico (2)", []).
companyWorkers("Politecnico", ["istruzione (m)", "generico (m)", "generico (m)"]).
companyWorkers("Università Pubblica (1)", []).
companyWorkers("Università Pubblica (2)", []).

// risorse visibili (inizializzate da set-up)
serviziPubblici("Sanità", 6).
serviziPubblici("Istruzione", 6).
serviziPubblici("Influenza", 4).

// risorse dello Stato (inizializzate da set-up)
legittimitaCapitalista(2).
legittimitaOperaia(2).
legittimitaMedia(2).
cibo_Stato(0).
lusso_Stato(0).
influenza_Stato(1). // nota: a differenza dell'influenza presente nei servizi pubblici, questa è nascosta agli altri giocatori

// risorse specifiche
proventi_CC(0).
capitale_CC(0).
introiti_CO(0).
introiti_CM(0).

// risorse comuni
cibo_CC(0).
cibo_CO(0).
cibo_CM(0).
lusso_CC(0).
lusso_CO(0).
lusso_CM(0).
sanita_CC(0).
sanita_CO(0).
sanita_CM(0).
istruzione_CC(0).
istruzione_CO(0).
istruzione_CM(0).
influenza_CC(0).
influenza_CO(0).
influenza_CM(0).

// REGOLE INIZIALI
inMarket(X) :- publicCompany(X) & onTable(X) & not(created(X)).

// ESECUZIONE AZIONI
!planner.
+!planner : true <-
    !initializeResources;
    !shareInitialBeliefs;
    !initialize;
    !start_narration.

// DEFINIZIONE AZIONI: Azioni comunicative
+!shareBelief(Belief) : true <- 
    .broadcast(tell, Belief).

+!shareInitialBeliefs : true <-
    !shareBelief(segnaliniCibo("Ambiente", 62));
    !shareBelief(segnaliniLusso("Ambiente", 64));
    !shareBelief(segnaliniSanita("Ambiente", 64));
    !shareBelief(segnaliniIstruzione("Ambiente", 64));
    !shareBelief(segnaliniMacchinario("Ambiente", 6));
    !shareBelief(segnaliniManifestazione("Ambiente", 1));
    !shareBelief(segnaliniSciopero("Ambiente", 7));
    !shareBelief(segnaliniVardis("Ambiente", 1515));

    !shareBelief(serviziPubblici("Sanità", 6)).
    !shareBelief(serviziPubblici("Istruzione", 6)).
    !shareBelief(serviziPubblici("Influenza", 4)).

+!notify_WorkingClass(Message) <-
    .print(Message);
    .send("classeOperaia", tell, done_init_Stato).
+!notify_MiddleClass(Message) <-
    .print(Message);
    .send("classeMedia", tell, done_init_Stato).
// Azioni di distribuzione delle risorse (dalla pool dell'ambiente)
+!shareProventi_CC(Proventi) <-
    if (Proventi >= 0) {
        .print("Mando proventi (", Proventi, ") alla classe capitalista");
        addProventi_CC(Proventi);
        +proventi_CC(Proventi);
    } else {
        .print("Tolgo proventi (", Proventi, ") alla classe capitalista");
        subtractProventi_CC(Proventi);
        -proventi_CC(Proventi);
    }
    !updateSegnaliniVardis;
    .send("classeCapitalista", achieve, removeResource("proventi_CC")); // Rimozione di qualsiasi belief precedente
    .send("classeCapitalista", tell, proventi_CC(Proventi)).

+!shareIntroiti_CO(Introiti) <-
    if (Introiti >= 0) {
        .print("Mando introiti (", Introiti, ") alla classe operaia");
        addIntroiti_CO(Introiti);
        +introiti_CO(Introiti);
    } else {
        .print("Tolgo introiti (", Introiti, ") alla classe operaia");
        subtractIntroiti_CO(Introiti);
        -introiti_CC(Introiti);
    }
    !updateSegnaliniVardis;
    .send("classeOperaia", achieve, removeResource("introiti_CO"));
    .send("classeOperaia", tell, introiti_CO(Introiti)).

+!shareIntroiti_CM(Introiti) <-
    if (Introiti >= 0) {
        .print("Mando introiti (", Introiti, ") alla classe media");
        addIntroiti_CM(Introiti);
        +introiti_CM(Introiti);
    } else {
        .print("Tolgo introiti (", Introiti, ") alla classe media");
        subtractIntroiti_CM(Introiti);
        -introiti_CM(Introiti);
    }
    !updateSegnaliniVardis;
    .send("classeMedia", achieve, removeResource("introiti_CM"));
    .send("classeMedia", tell, introiti_CM(Introiti)).

+!shareCibo(Player, Cibo) <- 
    if (Cibo >= 0) {
        .print("Mando ", Cibo, " unità di cibo a ", Player);
        addCibo(Player, Cibo);
    } else {
        .print("Tolgo ", Cibo, " unità di cibo a ", Player);
        subtractCibo(Player, Cibo);
    }
    if (Player == "CC") {
        -+cibo_CC(Cibo);
        .send("classeCapitalista", achieve, removeResource("cibo_CC"));
        .send("classeCapitalista", tell, cibo_CC(Cibo));
    }
    if (Player == "CO") {
        .send("classeOperaia", tell, removeResource("cibo_CO"));
        .send("classeOperaia", tell, cibo_CO(Cibo));
    }
    if (Player == "CM") {
        .send("classeMedia", tell, removeResource("cibo_CM"));
        .send("classeMedia", tell, cibo_CM(Cibo));
    };
    !updateSegnaliniCibo.

+!shareLusso(Player, Lusso) <- 
    if (Lusso >= 0) {
        .print("Mando ", Lusso, " unità di lusso a ", Player);
        addLusso(Player, Lusso);
    } else {
        .print("Tolgo ", Lusso, " unità di lusso a ", Player);
        subtractLusso(Player, Lusso);
        -lusso_CC(Lusso);
    }
    -+lusso_CC(Lusso);
    if (Player == "CC") {
        .send("classeCapitalista", achieve, removeResource("lusso_CC"));
        .send("classeCapitalista", tell, lusso_CC(Lusso));
    }
    if (Player == "CO") {
        .send("classeOperaia", tell, removeResource("lusso_CO"));
        .send("classeOperaia", tell, lusso_CO(Lusso));
    }
    if (Player == "CM") {
        .send("classeMedia", tell, removeResource("lusso_CM"));
        .send("classeMedia", tell, lusso_CM(Lusso));
    };
    !updateSegnaliniLusso.

+!shareSanita(Player, Sanita) <- 
    if (Sanita >= 0) {
        .print("Mando ", Sanita, " unità di sanità a ", Player);
        addSanita(Player, Sanita);
    } else {
        .print("Tolgo ", Sanita, " unità di sanità a ", Player);
        subtractSanita(Player, Sanita);
    }
    -+sanita_CC(Sanita);
    if (Player == "CC") {
        .send("classeCapitalista", achieve, removeResource("sanita_CC"));
        .send("classeCapitalista", tell, sanita_CC(Sanita));
    }
    if (Player == "CO") {
        .send("classeOperaia", tell, removeResource("sanita_CO"));
        .send("classeOperaia", tell, sanita_CO(Sanita));
    }
    if (Player == "CM") {
        .send("classeMedia", tell, removeResource("sanita_CM"));
        .send("classeMedia", tell, sanita_CM(Sanita));
    };
    !updateSegnaliniSanita.

+!shareIstruzione(Player, Istruzione) <- 
    if (Istruzione >= 0) {
        .print("Mando ", Istruzione, " unità di istruzione a ", Player);
        addIstruzione(Player, Istruzione);
    } else {
        .print("Tolgo ", Istruzione, " unità di istruzione a ", Player);
        subtractIstruzione(Player, Istruzione);
    }
    -+istruzione_CC(Istruzione);
    if (Player == "CC") {
        .send("classeCapitalista", achieve, removeResource("istruzione_CC"));
        .send("classeCapitalista", tell, istruzione_CC(Istruzione));
    }
    if (Player == "CO") {
        .send("classeOperaia", tell, removeResource("istruzione_CO"));
        .send("classeOperaia", tell, istruzione_CO(Istruzione));
    }
    if (Player == "CM") {
        .send("classeMedia", tell, removeResource("istruzione_CM"));
        .send("classeMedia", tell, istruzione_CM(Istruzione));
    };
    !updateSegnaliniIstruzione.

+!shareInfluenza(Player, Influenza) <- 
    if (Influenza >= 0) {
        .print("Mando ", Influenza, " unità di influenza a ", Player);
        addInfluenza(Player, Influenza);
    } else {
        .print("Tolgo ", Influenza, " unità di influenza a ", Player);
        subtractInfluenza(Player, Influenza);
    }
    -+influenza_CC(Influenza);
    if (Player == "CC") {
        .send("classeCapitalista", achieve, removeResource("influenza_CC"));
        .send("classeCapitalista", tell, influenza_CC(Influenza));
    }
    if (Player == "CO") {
        .send("classeOperaia", tell, removeResource("influenza_CO"));
        .send("classeOperaia", tell, influenza_CO(Influenza));
    }
    if (Player == "CM") {
        .send("classeMedia", tell, removeResource("influenza_CM"));
        .send("classeMedia", tell, influenza_CM(Influenza));
    }.

// Azioni di update dei segnalini
+!updateSegnaliniVardis <-
    ?proventi_CC(A);
    ?introiti_CO(B);
    ?introiti_CM(C);
    X = 1515 - (A + B + C);
    -+ segnaliniVardis("Ambiente", X);
    .broadcast(tell, segnaliniVardis("Ambiente", X));
    .print("Aggiornamento segnalino Vardis: ", X).

+!updateSegnaliniCibo <- 
    ?cibo_CC(A);
    ?cibo_CM(B);
    ?cibo_CO(C);
    ?cibo_Stato(D);
    X = 62 - (A + B + C + D);
    -+ segnaliniCibo("Ambiente", X);
    .broadcast(tell, segnaliniCibo("Ambiente", X)).

+!updateSegnaliniLusso <-
    ?lusso_CC(A);
    ?lusso_CM(B);
    ?lusso_CO(C);
    ?lusso_Stato(D);
    X = 64 - (A + B + C + D);
    -+ segnaliniLusso("Ambiente", X);
    .broadcast(tell, segnaliniLusso("Ambiente", X)).

+!updateSegnaliniSanita <-
    ?sanita_CC(A);
    ?sanita_CM(B);
    ?sanita_CO(C);
    X = 64 - (A + B + C);
    -+ segnaliniSanita("Ambiente", X);
    .broadcast(tell, segnaliniSanita("Ambiente", X)).

+!updateSegnaliniIstruzione <-
    ?istruzione_CC(A);
    ?istruzione_CM(B);
    ?istruzione_CO(C);
    X = 64 - (A + B + C);
    -+ segnaliniIstruzione("Ambiente", X);
    .broadcast(tell, segnaliniIstruzione("Ambiente", X)).

// Azioni di controllo
+!allPublicCompany : publicCompany(X) & not acknowledged(X) <-
    .print("Ok, ", X, " è un'azienda pubblica");
    +acknowledged(X);
    !isPublicCompany. // recursion to check all the public companies

+!allPublicCompany : true <- // Caso base per ricorsione
    .print("Ho finito di controllare le aziende pubbliche"). // fallback: necessario per evitare errori nella MAS Console

+!isOnTable(Company) : onTable(Company) <- 
    .print("L'azienda ", Company, " è sul tabellone").

// Azioni di creazione e rimozione delle aziende pubbliche
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
    createPublicCompany(Company, Industry, Cost, Requirements, Salary1, Salary2, Salary3, Level, BonusProduction, Machinery, Production, Workers);
    .print("Azienda pubblica creata: ", Company);
    +onTable(Company);
    +created(Company);
    !shareBelief(onTable(Company));
    !shareBelief(created(Company));
    .concat("You created the public company ", Company, Msg);
    !log(Msg).
    
+!removeCompany(Company) : publicCompany(Company) <- 
    removePublicCompany(Company);
    -onTable(Company);
    -created(Company);
    !shareBelief(onTable(Company));
    !shareBelief(created(Company));
    .concat("You removed the public company ", Company, Msg);
    !log(Msg).

// REGOLE AUSILIARIE
+!matchCompany(Number, StoredCompany) : true <- 
    if (Number == 0) {
        StoredCompany = "Radiotelevisione Statale";
    }
    if (Number == 1) {
        StoredCompany = "Emittente Televisiva Regionale (1)";
    }
    if (Number == 2) {
        StoredCompany = "Emittente Televisiva Regionale (2)";
    }
    if (Number == 3) {
        StoredCompany = "Ospedale Universitario";
    }
    if (Number == 4) {
        StoredCompany = "Ospedale Pubblico (1)";
    }
    if (Number == 5) {
        StoredCompany = "Ospedale Pubblico (2)";
    }
    if (Number == 6) {
        StoredCompany = "Politecnico";
    }
    if (Number == 7) {
        StoredCompany = "Università Pubblica (1)";
    }
    if (Number == 8) {
        StoredCompany = "Università Pubblica (2)";
    }.
    
+!randomCompany(F): true <-
    .random(Raw);
    R = (Raw * 28); // 28 possibili aziende pubbliche
    F = math.floor(R).

+!randomCompanyNotOnTable : true <-
    !randomCompany(F);
    !matchCompany(F, StoredCompany);
    if (onTable(StoredCompany)) {
        !randomCompanyNotOnTable;
    } else {
        !addCompany(StoredCompany);
    }.

// Azioni principali (azioni di gioco)
+!initializeVardis : true <-
    !shareProventi_CC(120);
    !shareIntroiti_CM(40);
    !shareIntroiti_CO(30).

+!initialize : true <- 
    .print("Creazione delle Aziende Pubbliche..."); 
    !addCompany("Radiotelevisione Statale");
    !addCompany("Ospedale Universitario");
    !addCompany("Politecnico");

    !randomCompanyNotOnTable; // one random public company

    !notify_WorkingClass("Inizializzazione conclusa: notifico la classe operaia.");
    !notify_MiddleClass("Inizializzazione conclusa: notifico la classe media.").
    !log("You told working and middle class that you created public companies to work in.").

+!initializeResources : true <-
    .print("Distribuisco le risorse ai giocatori...");

    !shareCibo("CC", 1);
    !shareCibo("CM", 1).

    !initializeVardis.

    !shareSanita("CM", 2).
    !shareLusso("CC", 2).
    !shareIstruzione("CC", 2).

    !shareInfluenza("CC", 1).
    !shareInfluenza("CO", 1).
    !log("You distributed resources to the population.").

// Azioni di narrazione
+!log(Msg) <-
    .my_name(Name);
    .concat(Msg, LogEntry);
    +log_entry(LogEntry).

+!start_narration <-
    .wait(3000);  // Wait 3 seconds (adjust as needed)
    .findall(L, log_entry(L), Logs);
    .term2string(Logs, FinalLogs);
    executeScript("./scripts/generator_Stato.py", FinalLogs);
    !tell_story.

+!tell_story : script_output(Story) <-
    .print("\nLo Stato dice:\n", Story).

// DEBUG
+!debugOnTable <- 
    .findall(X, onTable(X), CompaniesOnTable);
    .print("Current onTable beliefs: ", CompaniesOnTable).