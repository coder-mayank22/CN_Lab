import java.net.*;

public class network{
    public static void main(String[] args) {
        try{
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local machine IP address: " + localHost.getHostAddress());

            String host = "www.google.com";
            InetAddress remoteHost = InetAddress.getByName(host);
            System.out.println("IP address of " + host + ": " + remoteHost.getHostAddress());
        }

        catch(UnknownHostException e){
            System.out.println("Host not found: " + e.getMessage());
        }
    }
}