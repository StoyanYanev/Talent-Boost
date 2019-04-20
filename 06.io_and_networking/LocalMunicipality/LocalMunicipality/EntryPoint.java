package LocalMunicipality;

import java.util.Scanner;

public class EntryPoint {
    private static final int EXIT = 6;

    private static ResidentManager residentManager = new ResidentManager();

    private static long enterRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the record of the resident: ");
        long record = Integer.parseInt(scanner.next());
        return record;
    }

    private static Person createResident() {
        Scanner scanner = new Scanner(System.in);

        String name, address;
        long egn;

        System.out.print("Enter the name of the resident: ");
        name = scanner.next();

        System.out.print("Enter the egn of the resident: ");
        egn = Long.parseLong(scanner.next());

        System.out.print("Enter the address of the resident: ");
        address = scanner.next();

        Person resident = new Person(name, egn, address);

        return resident;
    }

    public static void menu() {
        System.out.println("*******************Menu*******************");
        System.out.println("1. Add resident.");
        System.out.println("2. Modify resident.");
        System.out.println("3. Search resident by name.");
        System.out.println("4. Search resident by record.");
        System.out.println("5. Delete resident.");
        System.out.println("6. Exit.");
        System.out.print("Your choice is: ");
    }

    public static void getInputFromMenu(int input) {
        switch (input) {
            case 1: {
                Person resident = createResident();
                residentManager.addResident(resident);
                break;
            }
            case 2: {
                long record = enterRecord();
                Person person = createResident();
                residentManager.modifyResident(record, person);
                break;
            }
            case 3: {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the name of the resident: ");
                String name = scanner.next();
                residentManager.searchResidentByName(name);
                break;
            }
            case 4: {
                long record = enterRecord();
                residentManager.searchResidentByRecord(record);
                break;
            }
            case 5: {
                long record = enterRecord();
                residentManager.deletingResident(record);
                break;
            }
            case 6: {
                break;
            }
            default:
                System.out.println("Invalid input!");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose = 0;
        while (choose != EXIT) {
            menu();
            choose = Integer.parseInt(scanner.next());
            getInputFromMenu(choose);
        }
    }
}