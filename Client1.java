import java.io.*;
import java.net.*;

public class Client1 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 6666);
            DataInputStream din = new DataInputStream(s.getInputStream());

            String str = din.readUTF();

            System.out.println("Message from server: " + str);

            din.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}