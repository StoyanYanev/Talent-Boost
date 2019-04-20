package CryptText;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class CryptText {
    /**
     * Crypt text using rot 13
     */
    public static void cryptText(String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("secretText.txt"))) {
            for (int i = 0; i < text.length(); i++) {
                bufferedWriter.write(text.charAt(i) + 13);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        cryptText(text);
    }
}
