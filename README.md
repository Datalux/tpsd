# TPSD

Esercizi per il corso di Tecnologie per i Sistemi Distribuiti e il Web.

# Indice
[Socket In Java](#socket-in-java)
* [NetSix](#netsix)
* [23-04-18](#23-04-18)
* [TIME](#time)
* [BOOK](#book)
* [LIST](#list)
* [Prova in itinere gennaio](#prova-in-itinere-gennaio)


[Thread in C](#thread-in-c)
* [Prova in itinere del 19/12/2013](#prova-in-itinere-del-19122013)
* [Prova in itinere gennaio](#prova-in-itinere-gennaio--1)
* [Esercitazione del 31/11/18](#esercitazione-del-30112018)
* [Tiro alla fune](#tiro-alla-fune-esercitazione-del-30112018)


[Thread  In Java](#thread-in-java)
* [Esercitazione del 31/11/18](#esercitazione-del-30112018--1)
* [Tiro alla fune](#tiro-alla-fune-esercitazione-del-30112018-1)


## Socket in Java
### NetSix ![source code](https://gitlab.com/Datalux/tpsd/tree/master/NetSix)

* Un noto distributore di contenuti video ondemand, NetSix, è famoso a livello internazionale per essere l'unico a rendere disponibili ben 6 serie tv, ognuna composta da un certo numero di episodi.
* Esporre un servizio `NetSixServer` interrogabile tramite socket sulla porta 3333, che risponde ai messaggi nel formato "nome_serie,n" con cui un cliente può chiedere se è disponibile l'episodio 'n' 
della serie 'nome_serie' (il carattere virgola fa da separatore), rispondendo alla richiesta con la stringa 'Disponibile' se l'episodio è presente nel sistema, o 'ComingSoon' se l'episodio o la serie
richiesta non sono attualmente disponibili.
* L'elenco delle 6 serie tv (popolabile a piacere) con il rispettivo numero di episodi, deve essere gestito in una classe separata chiamata `ShowList`, che ha al suo interno il metodo
`isAvaible(nome_serie, n)` che verrà usato dal `NetSixServer` per sapere se l'episodio è disponibile o meno.

### 23-04-18 ![source code](https://gitlab.com/Datalux/tpsd/tree/master/23-04-18)
![Testo del compito](https://gitlab.com/Datalux/tpsd/blob/master/23-04-18/testo.png)

### TIME  ![source code](https://gitlab.com/Datalux/tpsd/tree/master/TIME)
![Testo del compito](https://gitlab.com/Datalux/tpsd/blob/master/TIME/testo.png)

### BOOK ![source code](https://gitlab.com/Datalux/tpsd/tree/master/BOOK)
![Testo del compito](https://gitlab.com/Datalux/tpsd/blob/master/BOOK/testo.png)

### LIST ![source code](https://gitlab.com/Datalux/tpsd/tree/master/LIST)
Implementare un server, in C o Java, che risponde sul port 7777. Il server mantiene un vettore V con le ultime dieci richieste (stringhe di 10 caratteri) ricevute. Le richieste a cui il server deve 
rispondere sono:

1. la stringa "LIST", a cui il server risponde inviando al client tutte le risposte finora memorizzate in V, separate da '\n';
2. qualsiasi altra stringa viene trattata come messaggio da inserire nel vettore V: <br />
&nbsp; 2.1 se la stringa è già presente in V, il server risponde con "presente"; <br />
&nbsp; 2.2 se la stringa non è ancora presente in V, il server la aggiunge a V, eventualmente sovrascrivendone una a caso tra quelle già esistenti, e risponde "inserita" al client.

Dopo avere risposto, il server chiude la connessione con il client e torna in attesa di richieste.

### Prova in itinere gennaio ![source code](https://gitlab.com/Datalux/tpsd/blob/master/SocketJava/Server.java)
Realizzare un server che tiene traccia della disponibilità di 10 libri, che possono essere disponibili o in prestito;
riceve delle richieste da parte dei client del tipo "titolo del libro"
e risponde "Disponibile", "In prestito" o "Inesistente" a seconda del titolo richiesto.

## Thread in C
### Prova in itinere del 19/12/2013 
#### Hit ![source code](https://gitlab.com/Datalux/tpsd/blob/master/ThreadC/hit.c)
Una variabile intera `x`, inizializzata a 0, è condivisa tra 2 thread `tA`, `tB`. Ogni thread dispone di una variabile locale `hit` ed esegue le seguenti azioni:

1.  attende un numero casuale di ms (N.B.: la chiamata `usleep(n)` attende per  n microsecondi )
2.  se la variabile condivisa `x > 500`, allora scrive su `stdout` il valore di `hit` e termina la propria esecuzione
3.  altrimenti, incrementa `x`, incrementa la variabile locale `hit` e ricomincia da (1) 

Il programma termina quando tutti i thread hanno terminato la propria esecuzione. Nel codice, proteggere opportunamente la variabile `x` dagli accessi concorrenti.



#### ProdConsM ![source code](https://gitlab.com/Datalux/tpsd/blob/master/ThreadC/ProdConsM.c)
Scrivere in C un programma con due thread produttori `P1` e `P2` che condividono una variabile `m`  intera, che va inizializzata con un numero casuale compreso tra 1 e 10.
I thread eseguono un ciclo infinito, comportandosi rispettivamente come segue: <br />
&nbsp; P1 controlla il valore M di `m`:
* se M è compreso tra 1 e 5, P1 sveglia P2, genera un numero casuale compreso tra 1 e 10, lo memorizza in M e lo stampa a video
* se invece M è compreso tra 6 e 10, P1 si mette in attesa 

&nbsp; P2 controlla il valore di M:
* se M è compreso tra 6 e 10, P2 sveglia P1, genera un numero casuale compreso tra 1 e 10, lo memorizza in M e lo stampa a video
* se M è compreso tra 1 e 5, P2 si mette in attesa

### Prova in itinere del 03/02/2017 ![source code](https://gitlab.com/Datalux/tpsd/blob/master/ThreadC/itinere-03-02-2017.c)
Una variabile intera n, inizializzata a 0, è condivisa tra 2 thread tO, tE.
Il thread tE, ciclicamente:
1. attende 200 ms (N.B.: la chiamata usleep(t) attende per t microsecondi)
2. genera un int casuale pari e lo somma alla variabile condivisa n
3. se ha eseguito almeno 10 cicli e n è pari termina
4. altrimenti ricomincia da (1), a meno che abbia già compiuto 1000 iterazioni, nel qual caso termina.

Il thread tO, ciclicamente:
1. attende 200 ms (N.B.: la chiamata usleep(n) attende per n microsecondi)
2. genera un int casuale dispari e lo somma alla variabile condivisa n
3. se ha eseguito almeno 10 cicli e n è dispari termina
4. altrimenti ricomincia da (1), a meno che abbia già compiuto 1000 iterazioni, nel qual caso termina.

(Non ricorrere a un array di 2 thread per l’implementazione!)
Il programma termina quando tutti i thread hanno terminato la propria esecuzione. I thread scriveranno di essere terminati. Possono anche visualizzare, a ogni ciclo, il valore trovato in n.
Nel codice, proteggere opportunamente la variabile n dagli accessi concorrenti. 

### Prova in itinere gennaio ![source code](https://gitlab.com/Datalux/tpsd/blob/master/ThreadC/pari-dispari.c)
Realizzare due thread A e B, che stampano rispettivamente i numeri pari e i numeri dispari (da 1 a 100).

### Esercitazione del 30/11/2018 ![source code](https://gitlab.com/Datalux/tpsd/blob/master/ThreadC/esercitazione-30.11-18.c)
Una variabile `int n`, inizializzata a 100, è condivisa tra 2 thread `tI`, `tD`.
Il thread `tI`, ciclicamente:
1. attende 100 ms (N.B.: la chiamata `usleep(t)` attende per t microsecondi)
2. genera un `int` casuale tra 0 e 9 e lo<b>somma</b> alla variabile condivisa `n`
3. se `n` è maggiore di 150 termina
4. altrimenti ricomincia da (1), a meno che abbia già compiuto 1000 iterazioni, nel qual
caso termina.

Il thread `tD`, ciclicamente:
1. attende 300 ms (N.B.: la chiamata `usleep(n)` attende per n microsecondi)
2. genera un `int` casuale tra 0 e 9 e lo <b>sottrae</b> dalla variabile condivisa `n`
3. se `n` è minore di 80 termina
4. altrimenti ricomincia da (1), a meno che abbia già compiuto 1000 iterazioni, nel qual
caso termina.

(Non ricorrere a un array di 2 thread per l’implementazione!)
Il programma termina quando tutti i thread hanno terminato la propria esecuzione. I thread
scriveranno di essere terminati. Possono anche visualizzare, a ogni ciclo, il valore trovato in `n`.
Nel codice, proteggere opportunamente la variabile `n` dagli accessi concorrenti.

### Tiro alla fune (esercitazione del 30/11/2018) ![source code](https://gitlab.com/Datalux/tpsd/tree/master/ThreadC)
Scrivere un programma che simuli un incontro di “tiro alla fune” tra due 2 thread
“giocatori” `tp[0]`, `tp[1]`.
E’ data una variabile globale intera `posizione` (con valore iniziale 0) condivisa da tutti i thread. 
Sono date inoltre due variabili globali intere, `vittorie_tp0` e `vittorie_tp1`.
Ogni thread giocatore esegue un ciclo in cui:
- genera un intero casuale `recupero` compreso tra 0 e 3
- genera un intero casuale `forza` compreso tra 0 e 5
- attende `recupero` secondi
- se `tp[0]`:
    - se `posizione` >= 10 riconosce la vittoria di `tp[1]` e:
        * incrementa `vittorie_tp1`
        * setta `posizione = 0`
        * sveglia `tp[1]`
    - altrimenti:
        * decrementa `posizione` di `forza`
        * se `posizione <= -10` ha vinto, e si mette in attesa di `tp[1]`
- se `tp[1]`:
    - se `posizione <= -10` riconosce la vittoria di `tp[0]` e:
        * incrementa `vittorie_tp0`
        * setta `posizione = 0`
        * sveglia `tp[0]`
    - altrimenti:
        * incrementa `posizione` di `forza`
        * se `posizione >= 10` ha vinto, e si mette in attesa di `tp[0]`

(Opzionale) quando uno dei giocatori ha raggiunto 10 vittorie interrompere il gioco, entrambi i giocatori `tp[0]` , `tp[1]` devono aver terminato la loro esecuzione, e la
funzione `main()` se ne deve accorgere scrivendo sullo standard output il giocatore che ha totalizzato più vittorie.

## Thread in Java
### Esercitazione del 30/11/2018 ![source code](https://gitlab.com/Datalux/tpsd/tree/master/ThreadJava/esercitazione-30-11-18)
Una variabile `int n`, inizializzata a 100, è condivisa tra 2 thread `tI`, `tD`.
Il thread `tI`, ciclicamente:
1. attende 100 ms (N.B.: la chiamata `usleep(t)` attende per t microsecondi)
2. genera un `int` casuale tra 0 e 9 e lo<b>somma</b> alla variabile condivisa `n`
3. se `n` è maggiore di 150 termina
4. altrimenti ricomincia da (1), a meno che abbia già compiuto 1000 iterazioni, nel qual
caso termina.

Il thread `tD`, ciclicamente:
1. attende 300 ms (N.B.: la chiamata `usleep(n)` attende per n microsecondi)
2. genera un `int` casuale tra 0 e 9 e lo <b>sottrae</b> dalla variabile condivisa `n`
3. se `n` è minore di 80 termina
4. altrimenti ricomincia da (1), a meno che abbia già compiuto 1000 iterazioni, nel qual
caso termina.

(Non ricorrere a un array di 2 thread per l’implementazione!)
Il programma termina quando tutti i thread hanno terminato la propria esecuzione. I thread
scriveranno di essere terminati. Possono anche visualizzare, a ogni ciclo, il valore trovato in `n`.
Nel codice, proteggere opportunamente la variabile `n` dagli accessi concorrenti.

### Tiro alla fune (esercitazione del 30/11/2018) ![source code](https://gitlab.com/Datalux/tpsd/tree/master/ThreadJava/TiroAllaFune)
Scrivere un programma che simuli un incontro di “tiro alla fune” tra due 2 thread
“giocatori” `tp[0]`, `tp[1]`.
E’ data una variabile globale intera `posizione` (con valore iniziale 0) condivisa da tutti i thread. 
Sono date inoltre due variabili globali intere, `vittorie_tp0` e `vittorie_tp1`.
Ogni thread giocatore esegue un ciclo in cui:
- genera un intero casuale `recupero` compreso tra 0 e 3
- genera un intero casuale `forza` compreso tra 0 e 5
- attende `recupero` secondi
- se `tp[0]`:
    - se `posizione` >= 10 riconosce la vittoria di `tp[1]` e:
        * incrementa `vittorie_tp1`
        * setta `posizione = 0`
        * sveglia `tp[1]`
    - altrimenti:
        * decrementa `posizione` di `forza`
        * se `posizione <= -10` ha vinto, e si mette in attesa di `tp[1]`
- se `tp[1]`:
    - se `posizione <= -10` riconosce la vittoria di `tp[0]` e:
        * incrementa `vittorie_tp0`
        * setta `posizione = 0`
        * sveglia `tp[0]`
    - altrimenti:
        * incrementa `posizione` di `forza`
        * se `posizione >= 10` ha vinto, e si mette in attesa di `tp[0]`

(Opzionale) quando uno dei giocatori ha raggiunto 10 vittorie interrompere il gioco, entrambi i giocatori `tp[0]` , `tp[1]` devono aver terminato la loro esecuzione, e la
funzione `main()` se ne deve accorgere scrivendo sullo standard output il giocatore che ha totalizzato più vittorie.





