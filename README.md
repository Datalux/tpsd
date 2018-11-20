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

## ThreadC

### Hit 
Una variabile intera `x`, inizializzata a 0, è condivisa tra 2 thread `tA`, `tB`. Ogni thread dispone di una variabile locale `hit` ed esegue le seguenti azioni:

1.  attende un numero casuale di ms (N.B.: la chiamata `usleep(n)` attende per  n microsecondi )
2.  se la variabile condivisa `x > 500`, allora scrive su `stdout` il valore di `hit` e termina la propria esecuzione
3.  altrimenti, incrementa `x`, incrementa la variabile locale `hit` e ricomincia da (1) 

Il programma termina quando tutti i thread hanno terminato la propria esecuzione. Nel codice, proteggere opportunamente la variabile `x` dagli accessi concorrenti.

