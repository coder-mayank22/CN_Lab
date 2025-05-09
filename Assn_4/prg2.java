import java.util.Scanner;

public class prg2 {
    private static char calcClass(String firstPart){
        int firstByte = Integer.parseInt(firstPart);
        if(firstByte >= 0 && firstByte <= 127) return 'A';
        else if(firstByte >= 128 && firstByte <= 191) return 'B';
        else if(firstByte >= 192 && firstByte <= 223) return 'C';
        else return 'D';
    }

    private static String[] calcNetworkAddress(char classIP, String[] parts){
        String[] nwaddress = new String[4];
        int[] defaultMask = new int[4];
        if(classIP=='A'){
            defaultMask[0] = 255; defaultMask[1] = 0; defaultMask[2] = 0; defaultMask[3] = 0;
        }
        else if(classIP=='B'){
            defaultMask[0] = 255; defaultMask[1] = 255; defaultMask[2] = 0; defaultMask[3] = 0;
        }
        else if(classIP=='C'){
            defaultMask[0] = 255; defaultMask[1] = 255; defaultMask[2] = 255; defaultMask[3] = 0;
        }
        else{
            defaultMask[0] = 255; defaultMask[1] = 255; defaultMask[2] = 255; defaultMask[3] = 255;
        }

        for (int i = 0; i < 4; i++) {
            int temp = Integer.parseInt(parts[i]);
            nwaddress[i] = String.valueOf(temp & defaultMask[i]);
        }

        return nwaddress;
    }

    private static void subnetting(String[] parts, String[] nwaddress, int subnetNum){
        int addressTrack = (int)Math.ceil(256 / subnetNum);
        for(int i=0; i<subnetNum; i++){
            int c = 0;
            System.out.println("Subnetwork address of subnet " + (i+1) + " = ");
            for(String item : nwaddress){
                c++;
                if(c!=4) System.out.print(item + ".");
                else System.out.print(Integer.parseInt(item) + addressTrack*i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the IP address: ");
        String IP = sc.next();
        String[] parts = IP.split("\\.");
        System.out.print("Enter the number of subnets: ");
        int subnetNum = sc.nextInt();

        String[] nwaddress = calcNetworkAddress(calcClass(parts[0]), parts);
        subnetting(parts, nwaddress, subnetNum);
    }
}