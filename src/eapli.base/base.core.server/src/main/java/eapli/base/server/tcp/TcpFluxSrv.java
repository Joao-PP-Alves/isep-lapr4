package eapli.base.server.tcp;

import eapli.base.server.etc.ProtocolConsts;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class TcpFluxSrv extends Thread{

    private static HashMap<Socket, DataOutputStream> cliList = new HashMap<>();

    public static synchronized void addCli(Socket s) throws Exception {
        cliList.put(s, new DataOutputStream(s.getOutputStream()));
    }

    public static synchronized void remCli(Socket s) throws Exception {
        cliList.remove(s);
        s.close();
    }


    private static ServerSocket sock;

    public static void run(int port) throws Exception {

        try {
            sock = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Local port number not available.");
            System.exit(1);
        }

        while (true) {
            Socket s = sock.accept(); // wait for a new client connection request
            addCli(s);
            Thread cli = new TCPFluxSrvClient(s);
            cli.start();
        }
    }
}


class TCPFluxSrvClient extends Thread {
    private Socket myS;
    private DataInputStream sIn;
    private DataOutputStream sOut;

    public TCPFluxSrvClient(Socket s) {
        myS = s;
    }

    public void run() {
        int nChars = 0;
        byte[] data = new byte[ProtocolConsts.MESSAGE_SIZE];

        try {
            sIn = new DataInputStream(myS.getInputStream());
            sOut = new DataOutputStream(myS.getOutputStream());
            while (true) {
                sIn.read(data, 0, nChars);
                int version = ParseMessage.getVersion(data);
                if (version != ProtocolConsts.PROTOCOL_VERSION) {
                    //I don't know this protocol version, ending connection.
                    break;
                }
                int code = ParseMessage.getCode(data);
                if (code == ProtocolConsts.CODE_END_CONN)
                {
                    //Respond that you understood, close connection afterwards
                    sOut.write(RespondAffirmative.getMessage());
                    break;
                }
                else if (code == ProtocolConsts.CODE_TEST)
                {
                    sOut.write(RespondAffirmative.getMessage());
                }

            }
            // the client wants to exit
            TcpFluxSrv.remCli(myS);
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}



