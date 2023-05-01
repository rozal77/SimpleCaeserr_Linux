import java.util.Scanner;

public class assignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a message: ");
        String message = scanner.nextLine();

        System.out.print("Enter a key (1-25): ");
        int key = scanner.nextInt();

        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted message: " + decryptedMessage);
        scanner.close();
    }

    public static String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (((ch - 'a' + key) % 26) + 'a');
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (((ch - 'A' + key) % 26) + 'A');
            }

            result.append(ch);
        }

        return result.toString();
    }

    public static String decrypt(String message, int key) {
        return encrypt(message, 26 - key);
    }
}