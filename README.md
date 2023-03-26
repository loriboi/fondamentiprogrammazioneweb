# fondamentiprogrammazioneweb
Progetto Lorenzo Boi

Nella repository è possibile trovare:
- Pagine JSP e relativo file CSS
- Files js (Utilizzo di jquery e ajax)
- Immagini delle jsp
- Servlet
- Dump del database utilizzato per i test


Nel progetto mancano i file di configurazione generati da netbeans, perciò la repository non è funzionante, si possono comunque importare i files della repo in un progetto.

Specifiche del progetto:
Il progetto realizza l'applicazione per la gestione delle prenotazioni di uno stabilimento balneare.

Prevede due tipi di accesso: utente semplice e amministratore.
Senza effettuare nessun accesso si può visualizzare solo l’elenco di slot temporali prenotabili e la quantità di posti disponibili in ogni slot.

L’utente semplice può registrarsi all'applicazione, scegliendo uno username (che deve essere univoco) e una password, e caricando tutti i suoi dati anagrafici. In particolare, ogni utente deve caricare: nome, cognome, data di nascita, codice fiscale, sesso, e-mail, numero di cellulare, un parametro che indica se l’utente desidera ricevere la fattura elettronica o meno e una fotografia.

L’utente semplice può prenotare un certo numero di posti in una delle giornate disponibili sull’applicazione, scegliendo uno
degli slot temporali disponibili. La durata degli slot è sempre pari a sei ore. Ogni giorno ci sono due soli slot prenotabili: lo
slot della mattina inizia sempre alle 8:00 e si conclude alle 14:00, mentre lo slot del pomeriggio inizia alle 14:00 e si
conclude alle 20:00, ogni slot è prenotabile se è disponibile un numero di posti liberi sufficiente a prenotare tutti i posti
che l’utente richiede.

L’utente semplice ha accesso alla sua pagina personale, da cui può visualizzare e modificare le sue informazioni personali.

L’utente semplice ha accesso a una pagina in cui può visualizzare gli estremi delle fatture ricevute dallo stabilimento.

L’utente semplice ha anche accesso a una sezione messaggistica, da cui può scambiare messaggi solo con l’amministratore, l’utente semplice non può mandare messaggi ad altri utenti semplici del sistema. 

L’utente semplice non sa chi sono gli altri utenti registrati.

L’amministratore (il responsabile dello stabilimento), con il suo account da amministratore (creato da chi realizza l’applicazione) può inserire nuovi slot, specificando una data, specificando se si tratta dello slot della mattina (08:00 -14:00) o di quello del pomeriggio (14:00 - 20:00), e un numero di posti totali disponibili (si suppone che lo stabilimento possa variare il numero totale di posti che mette a disposizione) e il bagnino di turno.
Anche se il pagamento del servizio e la creazione della eventuale fattura avvengono con software esterni e indipendenti dall'applicazione web corrente, l’amministratore salva nell’applicazione web gli estremi delle fatture emesse per i clienti che la richiedono. 

Precisamente, l’amministratore può salvare nell’applicazione i dati delle fatture emesse ai clienti che hanno prenotato lo stabilimento. In particolare, l’amministratore analizza una ad una le prenotazioni passate non ancora processate e può decidere di aggiungere i dati della fattura originale nell’applicazione web (ma solo se l’utente che ha effettuato la prenotazione ha indicato, nello specifico campo del suo profilo personale, che è interessato a ricevere la fattura elettronica). I dati della fattura che vengono salvati sono l’identificativo, il prezzo totale, la data, il numero di posti prenotati, il bagnino che era di turno e una descrizione del servizio offerto in formato testuale.
NB: L’emissione della fattura è legata alla sola prenotazione, quindi i clienti ricevono i dati della fattura anche se non hanno ancora utilizzato il servizio (perché magari hanno prenotato oggi per una data futura). Inoltre, ad ogni prenotazione corrisponde una sola fattura: l’utente che prenota per la sua famiglia di quattro persone vedrà i dati di un’unica fattura e non quattro.

L’amministratore può anche aggiungere nuovi bagnini nel sistema. Di ogni bagnino deve inserire nome, cognome, cellulare, email, e un campo descrittivo testuale che indica l’elenco di attestati posseduti.

L’amministratore può utilizzare la sezione messaggi per mandare degli avvisi sulle prenotazioni agli utenti. In particolare, può mandare un messaggio di testo contenente un codice (stringa generata casualmente) che da diritto al 20% di sconto nella prossima stagione a tutti gli utenti che, nella stagione balneare corrente (01/06/2021 - 30/09/2021), hanno usufruito dello stabilimento coprendo almeno 20 posti (anche in più prenotazioni) e hanno richiesto fattura.

L’amministrazione può inviare un reminder agli utenti prenotati, il giorno prima della data della prenotazione.
Tutti questi messaggi vengono visualizzati dall’utente semplice nella propria schermata di messaggistica con l’amministratore.
L’amministratore ha a disposizione anche una schermata in cui può vedere la lista di tutti gli utenti, con i loro dati, il numero di posti prenotati nel tempo per cui è stata richiesta fattura. L’elenco di utenti e numero totale di posti prenotati nel tempo (come sempre, una prenotazione per quattro persone corrisponde a quattro posti prenotati) è ordinabile alfabeticamente per cognome o per numero di posti totali prenotati nel tempo (crescenti o decrescenti). L’amministratore
può scegliere l’ordine da un menù.

L’amministrazione ha anche a disposizione una schermata in cui è presente un elemento di input testuale in cui è possibile inserire il nome e cognome di un utente semplice e visualizzare le sue informazioni anagrafiche e la sua lista di prenotazioni per le quali è stata emessa fattura. Durante la digitazione del nome e del cognome l’amministratore deve ricevere dei suggerimenti (autocompletamento) in base agli utenti presenti nel sistema. Nel caso di utenti con nome e cognome uguali, gli utenti vengono mostrati seguiti dalla data di nascita e l’amministratore seleziona quello che vuole
visualizzare.
