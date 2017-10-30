package task;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Arpan on 30/10/2017.
 */

public class Server {


    ServerSocket serverSocket;
    ArrayList<ServerThread> allClients = new ArrayList<ServerThread>();

    public static void main(String[] args) {
        new Server();

    }

    public Server() {
        // ServerSocket is only opened once !!!

        try {
            serverSocket = new ServerSocket(6000);

            System.out.println("Waiting on port 6000...");
            boolean connected = true;

            // this method will block until a client will call me
            while (connected) {
                Socket singleClient = serverSocket.accept();
                // add to the list
                ServerThread myThread = new ServerThread(singleClient);
                allClients.add(myThread);
                myThread.start();
            }

            // here we also close the main server socket
            serverSocket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    class ServerThread extends Thread {
        Socket threadSocket;
        String userName;
        boolean isClientConnected;
        InputStream input;
        ObjectInputStream ois;
        OutputStream output;
        ObjectOutputStream oos; // ObjectOutputStream

        public ServerThread(Socket s) {
            threadSocket = s;
        }

        public void sendText(String text) {
            try {
                oos.writeObject(text);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void run() {

            try {
                input = threadSocket.getInputStream();
                ois = new ObjectInputStream(input);
                output = threadSocket.getOutputStream();
                oos = new ObjectOutputStream(output);

                userName = (String) ois.readObject();
                isClientConnected = true;
                System.out.println("User " + userName + " has connected");

                while (isClientConnected) {
                    String singleText = (String) ois.readObject();
                    System.out.println(singleText);

                    for (ServerThread t : allClients)
                        t.sendText(singleText);
                    // oos.writeObject(singleText);
                }
                // close all resources (streams and sockets)
                ois.close();
                oos.close();
                threadSocket.close();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
