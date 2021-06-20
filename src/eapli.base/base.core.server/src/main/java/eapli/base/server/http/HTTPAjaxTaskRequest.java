package eapli.base.server.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HTTPAjaxTaskRequest extends Thread {

    String baseFolder;
    Socket socket;
    DataInputStream inStream;
    DataOutputStream outStream;

    public HTTPAjaxTaskRequest(Socket socket, String baseFolder) {

        this.baseFolder = baseFolder;
        this.socket = socket;
    }

    public void run() {

        try {
            outStream = new DataOutputStream(socket.getOutputStream());
            inStream = new DataInputStream(socket.getInputStream());

        } catch (IOException ex) {
            System.out.println("Error on Thread on Stream creation.");
        }
        try {
            HTTPmessage request = new HTTPmessage(inStream);
            HTTPmessage response = new HTTPmessage();

            if (request.getMethod().equals("GET")) {

                if (request.getURI().equals("/tasks")) {
                    response.setContentFromString(
                            HTTPServerAjaxDashboard.getTasksHTML(), "text/html");
                    response.setResponseStatus("200 Ok");

                } else {
                    String fullname = baseFolder + "/";

                    if (request.getURI().equals("/")) {
                        fullname = fullname + "index.html";

                    } else {
                        fullname = fullname + request.getURI();
                    }
                    if (response.setContentFromFile(fullname)) {
                        response.setResponseStatus("200 Ok");

                    } else {
                        response.setContentFromString(
                                "<html><body><h1>404 File not found</h1></body></html>",
                                "text/html");
                        response.setResponseStatus("404 Not Found");
                    }
                }
                response.send(outStream);

            } else {

                /* if (request.getMethod().equals("PUT") && request.getURI().startsWith("/colaborador/inc/")) {
                    HTTPServerAjaxDashboard.updateTarefasInc(request.getURI().substring(17));
                    response.setResponseStatus("200 Ok");

                } else if (request.getMethod().equals("PUT")
                        && request.getURI().startsWith("/colaborador/dec/")) {
                    HttpServerAjaxDashboard.updateTarefasDec(request.getURI().substring(17));
                    response.setResponseStatus("200 Ok");
                } else {
                    response.setContentFromString(
                            "<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>",
                            "text/html");
                    response.setResponseStatus("405 Method Not Allowed");
                }*/
                response.setContentFromString(
                        "<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>",
                        "text/html");
                response.setResponseStatus("405 Method Not Allowed");
                response.send(outStream);
            }
        } catch (IOException e) {
            System.out.println("Thread error when reading request");
        }
        try {
            socket.close();
        } catch (IOException ex) {
            System.out.println("IOException. Terminating.");
        }
    }
}
