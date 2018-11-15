import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args){

        List<InetAddress> blackList = new ArrayList<>();

        try{
            int portnumber = 3233;

            ServerSocket serverSocket = new ServerSocket(portnumber);

            while(true){
                System.out.println(">> Wait for connection on port " + portnumber + "...");

                Socket clientSocket = serverSocket.accept();
                System.out.println("> Connection received from " + clientSocket.getInetAddress() + "(" + clientSocket.getPort() + ")");

                InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader in = new BufferedReader(isr);

                OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
                PrintWriter out = new PrintWriter(osw, true);

                String request = in.readLine().trim();

                if(blackList.contains(clientSocket.getInetAddress())){
                    out.println("BANNED");
                } else {
                    if(request.equals("TIME"))
                        out.println(System.currentTimeMillis());
                    else
                        out.println("N/A");
                    blackList.add(clientSocket.getInetAddress());
                    System.out.println(clientSocket.getInetAddress() + " added to blacklist");
                }

                System.out.println("> Close connection");
                clientSocket.close();
            }


        }catch (Exception e){
            e.printStackTrace();
        }



    }


}
