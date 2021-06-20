package eapli.base.server.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServerAjaxDashboard {

    static private ServerSocket socket;

    //TODO Different Tasks Storages by Type for HTTP Text purposes.
    //TODO Implement constant updating.
    private HTTPServerAjaxDashboard() {
    }

    public static void dashboard(int port, int userType) {

        Socket clientSocket;

        try {
            socket = new ServerSocket(port);

        } catch (IOException ex) {
            System.out.println("Server has failed to open with following port -> " + port);
            System.exit(1);
        }
    }

    public static synchronized String getTasksHTML() {

        String text = "WELCOME.<hr> " +
                "<ul style=\"list-style-type:square\">" +
                "<li>Pending Tasks: " + 1 + "</li>" +
                "<li>Expired Tasks: " + 2 + "</li>" +
                "<li>Soon to be Expired Tasks: " + 3 + "</li>" +
                "<hr>" + "</ul>";

        return text;
    }
}
