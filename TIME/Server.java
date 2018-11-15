import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    public static void main(String[] args){

        HashMap<String, Integer> books = new HashMap<>();

        books.put("Fisica", 8);
        books.put("Informatica",10);
        books.put("Matematica", 3);
        books.put("Latino", 1);
        books.put("Chimica", 6);

        try{
            int portNumber = 39939;
            ServerSocket serverSocket = new ServerSocket(portNumber);

            while(true){
                System.out.println(">> Wait for connection on port " + portNumber + "...");

                Socket clientSocket = serverSocket.accept();

                System.out.println("> Connection received from " + clientSocket.getInetAddress());

                InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader in = new BufferedReader(isr);

                OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
                PrintWriter out = new PrintWriter(osw, true);

                String[] requests = in.readLine().split(",");

                if(requests.length == 2){
                    System.out.println("> [REQUEST]  titolo_libro: " + requests[0] + ", n_copie: "+ requests[1]);
                    if(books.containsKey(requests[0]) && (books.get(requests[0]) >= Integer.parseInt(requests[1])))
                        out.println("True");
                    else
                        out.println("False");
                } else {
                    System.out.println("> Invalid request received. Send BAD REQUEST message");
                    out.println("[BAD REQUEST] use: <titolo_libro>,<numero_copie>");
                }

                System.out.println("> Close connection");
                clientSocket.close();
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }



}
