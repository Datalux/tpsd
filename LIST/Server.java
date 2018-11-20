
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static String[] lastRequests = new String[10];
    static int index = 0;
    static int size = 0;

    public static void main(String[] args){
        try{

            int port = 7777;

            ServerSocket serverSocket = new ServerSocket(port);

            while(true){
                System.out.println(">> Wait for connection on port " + port);

                Socket clientSocket = serverSocket.accept();
                System.out.println("> New connection received from " + clientSocket.getInetAddress().toString());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

                String request = in.readLine();

                if(request.equals("LIST")){
                    printRequests(out);
                } else {
                    if(contain(request)){
                        out.println("Presente");

                    } else {
                        addRequest(request);
                        out.println("Inserita");
                    }

                }

                clientSocket.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    private static void addRequest(String request){
        lastRequests[index % 10] = request;
        index++;
        if(index <= 10)
            size = index;
    }

    private static boolean contain(String request){
        for(int i = 0; i < size; i++)
            if(lastRequests[i].equals(request))
                return true;
        return false;
    }

    private static void printRequests(PrintWriter out){
        for(int i = 0; i < size; i++)
            out.println(lastRequests[i]);
    }

}
