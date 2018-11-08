import java.io.*;
import java.net.*;
import java.lang.*;

public class NetSixServer {

	public static void printSocketInfo(Socket socket) {
		System.out.println("Local Address: " + socket.getLocalAddress());
		System.out.println("Local Port: " + socket.getLocalPort());
		System.out.println("Remote Address: " + socket.getInetAddress());
		System.out.println("Remote Port: " + socket.getPort());
	}


	public static void main(String[] args){

		ShowList list = new ShowList();

		try{

			int serverPort = 3333;
			ServerSocket serverSocket = new ServerSocket(serverPort);

			while(true){
				System.out.println(">> Wait for connection on port " + serverPort + "...");

				Socket clientSocket = serverSocket.accept();
				System.out.println("> Connection received!");
				printSocketInfo(clientSocket);

				InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
				BufferedReader in = new BufferedReader(isr);

				OutputStreamWriter osr = new OutputStreamWriter(clientSocket.getOutputStream());
				PrintWriter out = new PrintWriter(osr, true);

				String[] request = in.readLine().split(",");

				if(request.length == 2){
					if(list.isAvaible(request[0], Integer.parseInt(request[1]))){
						System.out.println("> Request = nome_serie: " + request[0] + " n: " + request[1]);
						out.println("Disponibile");
					} else {
						System.out.println("> Request = nome_serie: " + request[0] + " n: " + request[1]);
						out.println("ComingSoon");
					}

				} else{
					System.out.println("> Invalid request received: send BAD REQUEST message");
					out.println("[BAD REQUEST] use: NetSixServer <nome_serie>,<n episode>");
				}

				System.out.println("> Close connection");
				clientSocket.close();
			}


		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
