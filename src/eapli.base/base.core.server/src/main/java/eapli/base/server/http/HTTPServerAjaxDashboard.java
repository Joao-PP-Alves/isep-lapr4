package eapli.base.server.http;

import eapli.base.ticket.application.GetTicketTaskInfoController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServerAjaxDashboard {

    private static final int TASK_TYPE_AMOUNT = 3;
    private static final int TASK_PENDING = 0;
    private static final int TASK_EXPIRED = 1;
    private static final int TASK_SOON_EXPIRED = 2;
    private static final String BASE_FOLDER = "www";

    private static int[] taskAmounts = new int[TASK_TYPE_AMOUNT];

    private static ServerSocket socket;

    //TODO Different Tasks Storages by Type for HTTP Text purposes.
    //TODO Implement constant updating.
    private HTTPServerAjaxDashboard() {
    }

    public static void main(String[] args) throws Exception {

        Socket clientSocket;

        if (args.length != 1) {
            System.out.println("Local port number required at the command line.");
            System.exit(1);
        }
        try {
            socket = new ServerSocket(Integer.parseInt(args[0]));

        } catch (IOException ex) {
            System.out.println("Server has failed to open with following port -> " + args[0]);
            System.exit(1);
        }
        while (true) {
            clientSocket = socket.accept();
            HTTPAjaxTaskRequest request = new HTTPAjaxTaskRequest(clientSocket, BASE_FOLDER);
            request.start();
        }
    }

    public static synchronized String getTasksHTML() {

        String text = "WELCOME.<hr> " +
                "<ul style=\"list-style-type:square\">" +
                "<li>Pending Tasks: " + taskAmounts[TASK_PENDING] + "</li>" +
                "<li>Expired Tasks: " + taskAmounts[TASK_EXPIRED] + "</li>" +
                "<li>Soon to be Expired Tasks: " + taskAmounts[TASK_SOON_EXPIRED] + "</li>" +
                "<hr>" + "</ul>";

        return text;
    }

    public static synchronized void updateTasksHTML() {

        GetTicketTaskInfoController gttiController = new GetTicketTaskInfoController();

        gttiController.getTicketTaskInfo(taskAmounts);
    }
}
