import java.io.*;
import java.net.*;
import java.util.*;

public class Server1 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server is waiting for connection...");

            Socket s = ss.accept();
            System.out.println("Client connected!");

            Date date = new Date();
            String currentDateTime = date.toString();

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            dout.writeUTF("Current Date and Time: " + currentDateTime);
            dout.flush();
            dout.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}