import java.util.Scanner;

public class CRC {
    private static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
        return result.toString();
    }

    static String mod2div(String dividend, String divisor) {
        int pick = divisor.length();
        String tmp = dividend.substring(0, pick);
        while (pick < dividend.length()) {
            if (tmp.charAt(0) == '1')
                tmp = xor(divisor, tmp) + dividend.charAt(pick);
            else
                tmp = xor("0".repeat(pick), tmp) + dividend.charAt(pick);

            tmp = tmp.substring(1);
            pick++;
        }

        if (tmp.charAt(0) == '1') {
            tmp = xor(divisor, tmp);
        } else {
            tmp = xor("0".repeat(pick), tmp);
        }
        return tmp.substring(1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data bits: ");
        String data = sc.nextLine();

        System.out.print("Enter divisor (CRC polynomial): ");
        String divisor = sc.nextLine();

        int len = divisor.length() - 1;
        String appendedData = data + "0".repeat(len);

        String rem = mod2div(appendedData, divisor);
        String codeword = data + rem;

        System.out.println("Transmitted codeword: " + codeword);

        // For receiver
        System.out.print("Enter received codeword: ");
        String received = sc.nextLine();

        String check = mod2div(received, divisor);

        // Checking for error
        boolean error = !check.equals("0".repeat(check.length()));

        if (error)
            System.out.println("Error detected in received data.");
        else
            System.out.println("No error detected in received data.");
    }
}