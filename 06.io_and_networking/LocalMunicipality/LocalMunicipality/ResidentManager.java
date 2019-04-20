package LocalMunicipality;

import java.io.*;
import java.util.Scanner;

public class ResidentManager {
    private long records;

    private static final String EXTENSION = ".txt";
    private static final String DIRECTORY = "records/";
    private static final String DELIMITER = "/";
    private static final int POSITION_OF_THE_NAME = 1;

    private void nextRecord() {
        this.records++;
    }

    private long getRecord() {
        return this.records;
    }

    private String getFileName(long record) {
        return (DIRECTORY + record + EXTENSION);
    }

    private void writeInFile(long record, Person person) {
        String fileName = this.getFileName(record);
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(fileName))) {
            String fileContent = record + DELIMITER + person.toString();
            writer.write(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ResidentManager() {
        this.records = 0;
    }

    public void addResident(Person person) {
        this.nextRecord();
        this.writeInFile(this.getRecord(), person);
        System.out.println("The resident was successfully added!");
    }

    public void modifyResident(long record, Person person) {
        this.writeInFile(record, person);
        System.out.println("The resident was successfully modified!");
    }

    public void searchResidentByName(String name) {
        try {
            File directory = new File(DIRECTORY);
            File[] listOfFiles = directory.listFiles();
            Scanner scanner;
            String fileContent;
            String[] splitContent;
            boolean isFound = false;
            for (File file : listOfFiles) {
                scanner = new Scanner(file);
                fileContent = scanner.nextLine();
                splitContent = fileContent.split(DELIMITER);
                if (splitContent[POSITION_OF_THE_NAME].equals(name)) {
                    System.out.println(fileContent);
                    isFound = true;
                    break;
                }
            }
            if (isFound == false) {
                System.out.println("The name " + name + " not found!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void searchResidentByRecord(long record) {
        String fileName = this.getFileName(record);
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                //print content of the file
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deletingResident(long record) {
        String fileName = this.getFileName(record);
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("The record " + record + EXTENSION + " was successfully deleted!");
        } else {
            //if file not exist
            System.out.println("The record " + record + EXTENSION + " doesn't exist!");
        }
    }
}