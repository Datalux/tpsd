import java.io.*;
import java.net.*;

public class ServerA{

	public static void main(String[] args){

		try{
			int serverPort = 3333;
			ServerSocket serverSocket = new ServerSocket(serverPort);

			while(true){
				System.out.println(">> Wait for connection on port " + serverPort);

				Socket clientSocket = serverSocket.accept();
				System.out.println("> Connection received");

				InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
				BufferedReader in = new BufferedReader(isr);

				System.out.println(in.readLine());

				System.out.println("> Close connection");
				clientSocket.close();
			}	

		} catch(Exception e){

		}
	}

}
