// BELIEFS: CLASSE OPERAIA
player("CC").
player("CO").
player("CM").
player("Stato").

cooperative("Cooperativa Agricola (1)").
cooperative("Cooperativa Agricola (2)").

companyIndustry("Cooperativa Agricola (1)", "Agricoltura").
companyIndustry("Cooperativa Agricola (2)", "Agricoltura").

companyRequirements("Cooperativa Agricola (1)", [couple("generico (o)", 3)]).
companyRequirements("Cooperativa Agricola (2)", [couple("generico (o)", 3)]).

companyProduction("Cooperativa Agricola (1)", [couple("cibo", 2)]).
companyProduction("Cooperativa Agricola (2)", [couple("cibo", 2)]).

// risorse visibili da tutti
sindacatoAgricoltura_CO(false).
sindacatoLusso_CO(false).
sindacatoSanita_CO(false).
sindacatoIstruzione_CO(false).
sindacatoMedia_CO(false).

// risorse visibili dallo Stato
introiti_CO(0).
cibo_CO(0).
lusso_CO(0).
sanita_CO(0).
istruzione_CO(0).
influenza_CO(0).

// risorse invisibili (valori di set-up)
popolazione_CO(10).
prosperita_CO(0).

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
    .print("Condivido la situazione dei miei sindacati.");
    !shareBelief(sindacatoAgricoltura_CO(false));
    !shareBelief(sindacatoLusso_CO(false));
    !shareBelief(sindacatoSanita_CO(false));
    !shareBelief(sindacatoIstruzione_CO(false));
    !shareBelief(sindacatoMedia_CO(false)).

// Azioni di rimozione risorse (a seguito di un messaggio)
+!removeResource(Resource) : true <-
    if (Resource == "introiti_CO") {
        -introiti_CO(_);
    }
    if (Resource == "cibo_CO") {
        -cibo_CO(_);
    }
    if (Resource == "lusso_CO") {
        -lusso_CO(_);
    }
    if (Resource == "sanita_CO") {
        -sanita_CO(_);
    }
    if (Resource == "istruzione_CO") {
        -istruzione_CO(_);
    }
    if (Resource == "influenza_CO") {
        -influenza_CO(_);
    };
    .print("Ho aggiornato ", Resource, " a seguito di un messaggio dallo Stato.").

// Azioni di attesa
+!waitForCompletion : introiti_CO(S) & cibo_CO(A) & lusso_CO(B) & sanita_CO(C) & istruzione_CO(D) & influenza_CO(E) <-
    if (done_init_CC & done_init_CM & done_init_Stato) {
        !initialize;
        //.print("Merci e Servizi:\nCibo: ", A, "\nLusso: ", B, "\nSanità: ", C, "\nIstruzione: ", D, "\nInfluenza: ", E, "\n\nIntroiti: ", S, "");
    } else {
        .print("Aspetto che gli altri giocatori finiscano l'inizializzazione delle Aziende...");
        .wait(1000);
        !waitForCompletion;
    }.

// Azioni per la creazione e la distruzione dei lavoratori
+!addWorkers(Number, Type) : true <-
    createWorker(Number, Type);
    .print(Number, " lavoratori del settore ", Type, " sono entrati nel mercato del lavoro.");
    if (Type == "generico (o)") {
        +lavoratoriOperaiGenerici(Number);
    }
    if (Type == "agricoltura (o)") {
        +lavoratoriOperaiAgrario(Number);
    }
    if (Type == "lusso (o)") {
        +lavoratoriOperaiLusso(Number);
    }
    if (Type == "sanita (o)") {
        +lavoratoriOperaiSanita(Number);
    }
    if (Type == "istruzione (o)") {
        +lavoratoriOperaiIstruzione(Number);
    }
    if (Type == "media (o)") {
        +lavoratoriOperaiMedia(Number);
    };
    .concat("You created workers in the sector ", Type, Msg);
    !log(Msg).

+!removeWorkers(Number, Type) : true <-
    .print(Number, " lavoratori del settore ", Type, " sono usciti dal mercato del lavoro.");
    killWorker(Number, Type);
    if (Type == "generico (o)") {
        -lavoratoriOperaiGenerici(Number);
    }
    if (Type == "agricoltura (o)") {
        -lavoratoriOperaiAgrario(Number);
    }
    if (Type == "lusso (o)") {
        -lavoratoriOperaiLusso(Number);
    }
    if (Type == "sanita (o)") {
        -lavoratoriOperaiSanita(Number);
    }
    if (Type == "istruzione (o)") {
        -lavoratoriOperaiIstruzione(Number);
    }
    if (Type == "media (o)") {
        -lavoratoriOperaiMedia(Number);
    }.
// Azioni di assunzione dei lavoratori della classe operaia
+!placeWorker(Worker, Company) : onTable(Company) & created(Company) <- 
    .print("Il lavoratore ", Worker, " è stato assunto nell'azienda ", Company);
    assumeWorker(Worker, Company);
    if (Worker == "generico (o)") {
        -lavoratoriOperaiGenerici(1);
    }
    if (Worker == "agricoltura (o)") {
        -lavoratoriOperaiAgrario(1);
    }
    if (Worker == "lusso (o)") {
        -lavoratoriOperaiLusso(1);
    }
    if (Worker == "sanita (o)") {
        -lavoratoriOperaiSanita(1);
    }
    if (Worker == "istruzione (o)") {
        -lavoratoriOperaiIstruzione(1);
    }
    if (Worker == "media (o)") {
        -lavoratoriOperaiMedia(1);
    }.

+!placeWorker(Worker, Company) : onTable(Company) & not created(Company) <-
    .print("L'azienda ", Company, " non è stata creata").
+!placeWorker(Worker, Company) : not onTable(Company) <- 
    .print("L'azienda ", Company, " non è sul tabellone").

// Azioni di controllo
+!isOnTable(Company) : onTable(Company) <- 
    .print("L'azienda ", Company, " è sul tabellone").

// Azioni principali (azioni di gioco)
+!initializeWorkers : true <-
    .print("Creo il mercato del lavoro operaio.");
    !addWorkers(23, "generico (o)").
    !addWorkers(5, "agricoltura (o)").
    !addWorkers(5, "lusso (o)").
    !addWorkers(5, "sanita (o)").
    !addWorkers(5, "istruzione (o)").
    !addWorkers(5, "media (o)").
    
+!initialize : true <-
    // Questa inizializzazione deve obbligatoriamente avvenire dopo quella delle altre classi sociali
    // inizializza sia i lavoratori della classe operaia sia quelli della classe media
    .print("Le altre classi hanno finito, ora posso iniziare io.");
    
    !placeWorker("agricoltura (o)", "Supermercato (Starter)");
    !placeWorker("generico (o)", "Supermercato (Starter)");

    !placeWorker("istruzione (o)", "Scuola Superiore (Starter)");
    !placeWorker("generico (o)", "Scuola Superiore (Starter)");

    !placeWorker("sanita (o)", "Ospedale Universitario");
    !placeWorker("generico (o)", "Ospedale Universitario");
    !placeWorker("generico (o)", "Ospedale Universitario");

    .print("Inizializzazione Conclusa").

// Azioni di narrazione
+!log(Msg) <-
    .my_name(Name);
    .concat(Msg, LogEntry);
    +log_entry(LogEntry).

+!start_narration <-
    .wait(3000);  // Wait 3 seconds (adjust as needed)
    .findall(L, log_entry(L), Logs);
    .term2string(Logs, FinalLogs);
    executeScript("./scripts/generator_CO.py", FinalLogs);
    !tell_story.

+!tell_story : script_output(Story) <-
    .print("\nLa Classe Operaia dice:\n", Story).