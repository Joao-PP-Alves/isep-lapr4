package eapli.base.server.tcp;

import eapli.base.server.etc.ProtocolConsts;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
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

    static final String TRUSTED_STORE="certs/server_J.jks";
    static final String KEYSTORE_PASS="changeit";

    private static SSLServerSocket sock;

    private static int port = ProtocolConsts.TCP_PORT;

    public void run(){

        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore",TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        System.out.println();

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            sock = (SSLServerSocket) sslF.createServerSocket(port);
            sock.setNeedClientAuth(true);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Local port number not available.");
            return;
        }

        while (true) {
            Socket s = null; // wait for a new client connection request
            try {
                s = sock.accept();
                addCli(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
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



