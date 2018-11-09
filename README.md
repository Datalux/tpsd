# TPSD

Esercizi per il corso di Tecnologie per i Sistemi Distribuiti e il Web.

## NetSix
* Un noto distributore di contenuti video ondemand, NetSix, è famoso a livello internazionale per essere l'unico a rendere disponibili ben 6 serie tv, ognuna composta da un certo numero di episodi.
* Esporre un servizio `NetSixServer` interrogabile tramite socket sulla porta 3333, che risponde ai messaggi nel formato "nome_serie,n" con cui un cliente può chiedere se è disponibile l'episodio 'n' 
della serie 'nome_serie' (il carattere virgola fa da separatore), rispondendo alla richiesta con la stringa 'Disponibile' se l'episodio è presente nel sistema, o 'ComingSoon' se l'episodio o la serie
richiesta non sono attualmente disponibili.
* L'elenco delle 6 serie tv (popolabile a piacere) con il rispettivo numero di episodi, deve essere gestito in una classe separata chiamata `ShowList`, che ha al suo interno il metodo
`isAvaible(nome_serie, n)` che verrà usato dal `NetSixServer` per sapere se l'episodio è disponibile o meno.