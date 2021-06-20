package eapli.base.server.tcp;

import eapli.base.server.etc.ProtocolConsts;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//TODO: complete and find a way to communicate with others about the responses
public class TcpFluxCli extends Thread{
	static InetAddress serverIP;
	static SSLSocket sock;
	static final String TRUSTED_STORE="certs/client1_J.jks";
	static final String KEYSTORE_PASS="changeit";

	public TcpFluxCli(String addr)
	{
		try
		{
			serverIP = InetAddress.getByName(addr);
		}
		catch(UnknownHostException ex)
		{
			System.out.println("Invalid server: " + addr);
			serverIP = null;
		}
	}

	public void run(){
		String nick, frase;
		byte[] data;

		// Trust these certificates provided by servers
		System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
		System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

		// Use this certificate and private key for client certificate when requested by the server
		System.setProperty("javax.net.ssl.keyStore",TRUSTED_STORE);
		System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

		SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

		try { sock = (SSLSocket) sf.createSocket(serverIP, ProtocolConsts.TCP_PORT); }
		catch(IOException ex) {
   			System.out.printf("Failed to connect to %s:%d.\n", serverIP.getHostAddress(), ProtocolConsts.TCP_PORT);
   			return;
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream sOut = null;
		try {
			sOut = new DataOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Connected to server");

		try {
			sock.startHandshake();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// start a thread to read incoming messages from the server
		Thread serverConn = new Thread(new TcpChatCliConn(sock));
		serverConn.start();


		/*while(true) { // read messages from the console and send them to the server
			frase=in.readLine();
			if(frase.compareTo("exit")==0) 
				{ sOut.write(0); break;}
			frase="(" + nick + ") " + frase;
			data = frase.getBytes();
			sOut.write((byte)frase.length());
			sOut.write(data,0,(byte)frase.length());
			}

		serverConn.join();
		sock.close();*/
		}
	}

class TcpChatCliConn implements Runnable {
	private Socket s;
	private DataInputStream sIn;

	public TcpChatCliConn(Socket tcp_s) { s=tcp_s;}

	public void run() {
		int nChars;
		byte[] data = new byte[300];
		String frase;

		try {
			sIn = new DataInputStream(s.getInputStream());
			while(true) {
				nChars=sIn.read();
				if(nChars==0) break;
				sIn.read(data,0,nChars);
				frase = new String(data, 0, nChars);
				System.out.println(frase);
				}
			}
		catch(IOException ex) { System.out.println("Client disconnected."); }
		}
	}



