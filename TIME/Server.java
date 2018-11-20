import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static List<String> blackList = new ArrayList<>();


    public static void main(String[] args){
        String lastIP;

        try{
            int portnumber = 3233;
            lastIP = "";

            ServerSocket serverSocket = new ServerSocket(portnumber);

            while(true){
                System.out.println(">> Wait for connection on port " + portnumber + "...");

                Socket clientSocket = serverSocket.accept();
                System.out.println("> Connection received from " + clientSocket.getInetAddress() + "(" + clientSocket.getPort() + ")");


                InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader in = new BufferedReader(isr);

                OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
                PrintWriter out = new PrintWriter(osw, true);

                String ip = clientSocket.getInetAddress().toString();
                String request = in.readLine().trim();

                if(blackList.contains(clientSocket.getInetAddress().toString()) || isLastIP(lastIP, ip)){
                    out.println("BANNED");
                } else {
                    if(request.equals("TIME"))
                        out.println(System.currentTimeMillis());
                    else
                        out.println("N/A");
                }

                lastIP = ip;

                System.out.println("> Close connection");
                clientSocket.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static boolean isLastIP(String last, String now){
        if(last.equals(now)){
            blackList.add(now);
            System.out.println(last + " added to blacklist");
        }
        return last.equals(now);
    }


}
