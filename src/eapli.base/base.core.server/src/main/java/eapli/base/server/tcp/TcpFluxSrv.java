package eapli.base.server.tcp;

import eapli.base.server.etc.ProtocolConsts;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

class TcpFluxSrv{

	private static HashMap<Socket,DataOutputStream> cliList = new HashMap<>();

	public static synchronized void sendToAll(int len, byte[] data) throws Exception {
		for(DataOutputStream cOut: cliList.values()) {
			cOut.write(len);
			cOut.write(data,0,len);
			}

		}
	
	public static synchronized void addCli(Socket s) throws Exception {
		cliList.put(s,new DataOutputStream(s.getOutputStream()));
		}

	public static synchronized void remCli(Socket s) throws Exception {
		cliList.get(s).write(0);
		cliList.remove(s);
		s.close();
		}



	private static ServerSocket sock;

	public static void start(int port) throws Exception {

		try {
			sock = new ServerSocket(port);
		}
		catch(IOException ex) {
			System.out.println("Local port number not available.");
			System.exit(1); }

		while(true) {
			Socket s=sock.accept(); // wait for a new client connection request
			addCli(s);
			Thread cli = new TcpChatSrvClient(s);
			cli.start();
			}
		} 
	}


class TcpChatSrvClient extends Thread {
	private Socket myS;
	private DataInputStream sIn;

	public TcpChatSrvClient(Socket s) { myS=s;}
	
	public void run() {
		int nChars = 0;
		byte[] data = new byte[ProtocolConsts.MESSAGE_SIZE];

		try {
			sIn = new DataInputStream(myS.getInputStream());
			while(true) {
   				/*nChars=sIn.read();
   				if(nChars==0) break; // empty line means client wants to exit*/
   				sIn.read(data,0,nChars);
				int version = ParseMessage.getVersion(data);
				if (version != ProtocolConsts.PROTOCOL_VERSION)
				{
					//I don't know this protocol version, ending connection.
					break;
				}
				int code = ParseMessage.getCode(data);
				if (code == ProtocolConsts.CODE_END_CONN);
					break;

   				}
   			// the client wants to exit
			TcpFluxSrv.remCli(myS);
			}
  		catch(Exception ex) { System.out.println("Error"); }
		}
	}



