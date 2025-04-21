import java.util.*;

public class prg1{
    private static void calculate(String IP){
        String[] ipsplit = IP.split("\\.");
        int[] ipsplitint = new int[4];
        for (int i = 0; i < 4; i++) {
            ipsplitint[i] = Integer.parseInt(ipsplit[i]);
        }

        String subnetmask = "";

        if(ipsplitint[0]>=0 && ipsplitint[0]<=127){
            System.out.println("The class of the IP address is A");
            subnetmask = "255.0.0.0";
        }
        else if(ipsplitint[0]>=128 && ipsplitint[0]<=191){
            System.out.println("The class of the IP address is B");
            subnetmask = "255.255.0.0";
        }
        else if(ipsplitint[0]>=192 && ipsplitint[0]<=223){
            System.out.println("The class of the IP address is C");
            subnetmask = "255.255.255.0";
        }
        else if(ipsplitint[0]>=224 && ipsplitint[0]<=239){
            System.out.println("The class of the IP address is D");
            subnetmask = "255.255.0.0";
        }
        else if(ipsplitint[0]>=240 && ipsplitint[0]<=255){
            System.out.println("The class of the IP address is E");
        }

        String[] subnetsplit = subnetmask.split("\\.");
        int[] subnetsplitint = new int[4];
        for (int i = 0; i < 4; i++) {
            subnetsplitint[i] = ipsplitint[i] & Integer.parseInt(subnetsplit[i]);
        }

        System.out.println("The network address is: " + subnetsplitint[0] + "." +
        subnetsplitint[1] + "." + subnetsplitint[2] + "." + subnetsplitint[3]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip;
        System.out.print("Enter IP address: ");
        ip = sc.next();
        calculate(ip);
        sc.close();
    }
}