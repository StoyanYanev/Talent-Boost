package ConcurrentHashMap;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class CountWordsInAText {
    private static final ConcurrentHashMap<String, Integer> numberOfWords = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("ConcurrentHashMap.txt"))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            String[] sentences = builder.toString().split("\\.");
            int numberOfThreds = sentences.length;

            for (final String l : sentences) {
                Thread thread = new Thread(() -> {
                    String[] words = l.split(" ");
                    for (String currentWord : words) {
                        if (numberOfWords.containsKey(currentWord)) {
                            int wordCount = numberOfWords.get(currentWord);
                            numberOfWords.put(currentWord, wordCount + 1);
                        } else {
                            numberOfWords.put(currentWord, 1);
                        }
                    }
                });
                thread.start();
            }

            for (String w : numberOfWords.keySet()) {
                System.out.println(w + " " + numberOfWords.get(w));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}