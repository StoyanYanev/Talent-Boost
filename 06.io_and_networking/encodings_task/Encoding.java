package encodings_task;

import java.io.*;

public class Encoding {
    private static final String INPUT_FILE_NAME = "input_utf8.txt";
    private static final String OUTPUT_FILE_NAME = "output_win1251.txt";
    private static final String UTF_8 = "UTF8";
    private static final String WINDOWS_1251 = "windows-1251";

    public static void readTextWithEncodingUTF8() {
        try (Reader inputStreamRead = new InputStreamReader(new FileInputStream(INPUT_FILE_NAME), UTF_8)) {
            int i;
            while ((i = inputStreamRead.read()) > 0) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTextWithEncodingWindows1251() {
        try (Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE_NAME), WINDOWS_1251)) {
            Reader inputStream = new FileReader(INPUT_FILE_NAME);
            int i;
            while ((i = inputStream.read()) > 0) {
                outputStreamWriter.write((char) i);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBytesForFile(String fileName) {
        try (InputStream inputStream = new FileInputStream(fileName)) {
            int i;
            while ((i = inputStream.read()) > 0) {
                System.out.print(i + " ");
            }
            System.out.println();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readTextWithEncodingUTF8();
        saveTextWithEncodingWindows1251();
        readBytesForFile(INPUT_FILE_NAME);
        readBytesForFile(OUTPUT_FILE_NAME);
    }
}