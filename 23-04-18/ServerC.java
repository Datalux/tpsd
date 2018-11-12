import java.io.*;
import java.net.*;

public class ServerC{

	public static void main(String[] args){

		try{
			int serverPort = 3333;
			int status = 0;
			ServerSocket serverSocket = new ServerSocket(serverPort);

			while(true){
				System.out.println(">> Wait for connection on port " + serverPort);

				Socket clientSocket = serverSocket.accept();
				System.out.println("> Connection received");

				status++;

				InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
				BufferedReader in = new BufferedReader(isr);

				OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
				PrintWriter out = new PrintWriter(osw, true);

				String s = in.readLine();
				int x = sommacifre(s);

				System.out.println(s);

				out.println(status+","+x);

				System.out.println("> Close connection");
				clientSocket.close();
			}	

		} catch(Exception e){

		}
	}

	static int sommacifre(String s){
		return 0;
	}

}