# TPSD

Esercizi per il corso di Tecnologie per i Sistemi Distribuiti e il Web.

## NetSix
* Un noto distributore di contenuti video ondemand, NetSix, è famoso a livello internazionale per essere l'unico a rendere disponibili ben 6 serie tv, ognuna composta da un certo numero di episodi.
* Esporre un servizio `NetSixServer` interrogabile tramite socket sulla porta 3333, che risponde ai messaggi nel formato "nome_serie,n" con cui un cliente può chiedere se è disponibile l'episodio 'n' 
della serie 'nome_serie' (il carattere virgola fa da separatore), rispondendo alla richiesta con la stringa 'Disponibile' se l'episodio è presente nel sistema, o 'ComingSoon' se l'episodio o la serie
richiesta non sono attualmente disponibili.
* L'elenco delle 6 serie tv (popolabile a piacere) con il rispettivo numero di episodi, deve essere gestito in una classe separata chiamata `ShowList`, che ha al suo interno il metodo
`isAvaible(nome_serie, n)` che verrà usato dal `NetSixServer` per sapere se l'episodio è disponibile o meno.

## 23-04-18
![Testo del compito](https://gitlab.com/Datalux/tpsd/blob/master/23-04-18/testo.png)

## TIME
![Testo del compito](https://gitlab.com/Datalux/tpsd/blob/master/TIME/testo.png)

## BOOK
![Testo del compito](https://gitlab.com/Datalux/tpsd/blob/master/BOOK/testo.png)

## LIST
Implementare un server, in C o Java, che risponde sul port 7777. Il server mantiene un vettore V con le ultime dieci richieste (stringhe di 10 caratteri) ricevute. Le richieste a cui il server deve 
rispondere sono:

1. la stringa "LIST", a cui il server risponde inviando al client tutte le risposte finora memorizzate in V, separate da '\n';
2. qualsiasi altra stringa viene trattata come messaggio da inserire nel vettore V: <br />
&nbsp; 2.1 se la stringa è già presente in V, il server risponde con "presente"; <br />
&nbsp; 2.2 se la stringa non è ancora presente in V, il server la aggiunge a V, eventualmente sovrascrivendone una a caso tra quelle già esistenti, e risponde "inserita" al client.

Dopo avere risposto, il server chiude la connessione con il client e torna in attesa di richieste.

## ThreadC
### Prova in itinere del 19/12/2013
#### Hit 
Una variabile intera `x`, inizializzata a 0, è condivisa tra 2 thread `tA`, `tB`. Ogni thread dispone di una variabile locale `hit` ed esegue le seguenti azioni:

1.  attende un numero casuale di ms (N.B.: la chiamata `usleep(n)` attende per  n microsecondi )
2.  se la variabile condivisa `x > 500`, allora scrive su `stdout` il valore di `hit` e termina la propria esecuzione
3.  altrimenti, incrementa `x`, incrementa la variabile locale `hit` e ricomincia da (1) 

Il programma termina quando tutti i thread hanno terminato la propria esecuzione. Nel codice, proteggere opportunamente la variabile `x` dagli accessi concorrenti.

#### ProdConsM
Scrivere in C un programma con due thread produttori `P1` e `P2` che condividono una variabile `m`  intera, che va inizializzata con un numero casuale compreso tra 1 e 10.
I thread eseguono un ciclo infinito, comportandosi rispettivamente come segue: <br />
&nbsp; P1 controlla il valore M di `m`:
* se M è compreso tra 1 e 5, P1 sveglia P2, genera un numero casuale compreso tra 1 e 10, lo memorizza in M e lo stampa a video
* se invece M è compreso tra 6 e 10, P1 si mette in attesa 

&nbsp; P2 controlla il valore di M:
* se M è compreso tra 6 e 10, P2 sveglia P1, genera un numero casuale compreso tra 1 e 10, lo memorizza in M e lo stampa a video
* se M è compreso tra 1 e 5, P2 si mette in attesa

### Prova in itinere del 03/02/2017
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




