package eapli.base.app.backoffice.console.presentation.engine;

import eapli.base.server.etc.ProtocolConsts;
import eapli.framework.presentation.console.AbstractUI;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class EngineTestUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        final String TRUSTED_STORE="certs/client1_J.jks";
        final String KEYSTORE_PASS="changeit";

        SSLSocket sock;
        InetAddress serverIP = null;

        try {
            serverIP = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // Trust these certificates provided by servers
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore",TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            sock = (SSLSocket) sf.createSocket(serverIP, 32507);
        }
        catch(IOException ex) {

            System.out.printf("Failed to connect to %s:%d.\n", serverIP.getHostAddress(), 32507);
            return true;
        }

        System.out.printf("Connected to %s:%d.\n", serverIP.getHostAddress(), 32507);

        try {
            sock.startHandshake();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataOutputStream sOut = null;
        DataInputStream sIn = null;
        try {
            sOut = new DataOutputStream(sock.getOutputStream());
            sIn = new DataInputStream(sock.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] response = new byte[ProtocolConsts.MESSAGE_SIZE];

        response[ProtocolConsts.VERSION_POS] = ProtocolConsts.PROTOCOL_VERSION;
        response[ProtocolConsts.RESPONSE_CODE_POS] = ProtocolConsts.CODE_TEST;
        response[ProtocolConsts.RESPONSE_SIZE_POS] = 0;

        try {
            sOut.write(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Sent a test message");

        byte[] data = new byte[ProtocolConsts.MESSAGE_SIZE];
        int nrChars = 0;

        while(true) {
            try {
                nrChars = sIn.read(data, 0, ProtocolConsts.MESSAGE_SIZE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nrChars == ProtocolConsts.MESSAGE_SIZE)
                break;
            else if (nrChars == -1)
                return true;
        }

        if (Byte.toUnsignedInt(data[ProtocolConsts.RESPONSE_CODE_POS]) == ProtocolConsts.CODE_CONFIRMATION)
        {
            System.out.println("Server responded affirmatively, sending message to terminate connection");
        }

        response[ProtocolConsts.RESPONSE_CODE_POS] = ProtocolConsts.CODE_END_CONN;
        try {
            sOut.write(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Sent end connection message");

        nrChars = 0;
        try {
            nrChars = sIn.read(data, 0, ProtocolConsts.MESSAGE_SIZE);
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (Byte.toUnsignedInt(data[ProtocolConsts.RESPONSE_CODE_POS]) == ProtocolConsts.CODE_CONFIRMATION)
        {
            System.out.println("Server responded affirmatively, terminating connection");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Connection Test";
    }
}
