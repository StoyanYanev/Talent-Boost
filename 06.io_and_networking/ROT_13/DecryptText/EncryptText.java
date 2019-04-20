package EncryptText;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EncryptText {
    public static void encryptText() {
        try (InputStream inputStream = new FileInputStream("secretText.txt")) {
            char currentChar;
            while (true) {
                int currentByte = inputStream.read();
                if (currentByte == -1) break;
                currentChar = (char) (currentByte - 13);
                System.out.print(currentChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        encryptText();
    }
}