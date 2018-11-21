/*
	Realizzare un server che tiene traccia della disponibilità di 10 libri, che possono essere disponibili o in prestito;
	riceve delle richieste da parte dei client del tipo "titolo del libro"
	e risponde "Disponibile", "In prestito" o "Inesistente" a seconda del titolo richiesto.
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {

    private static HashMap<String, Boolean> booksList = new HashMap<>();

    public static void main(String[] args){

        try{
            initData();

            int port = 3333;
            ServerSocket serverSocket = new ServerSocket(port);

            while(true){
                System.out.println(">> Wait for connection on port " + port);

                Socket clientSocket = serverSocket.accept();

                System.out.println("> New connection received from " + clientSocket.getInetAddress().toString());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

                String request = in.readLine().trim();

                if(booksList.containsKey(request)){
                    if(booksList.get(request))
                        out.println("Disponibile");
                    else
                        out.println("In prestito");
                } else {
                    out.println("Inesistente");
                }

                clientSocket.close();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void initData(){
        booksList.put("Fisica 1", true );
        booksList.put("Analisi 2", false);
        booksList.put("Basi di Dati", true);
        booksList.put("Java 8", true);
        booksList.put("Sistemi Operativi", true);
        booksList.put("Reti di Calcolatori", true);
        booksList.put("Architettura degli Elaboratori", true);
        booksList.put("Matematica Discreta", false);
        booksList.put("Programmazione C", false);
        booksList.put("Algoritmi", false);
    }
}
