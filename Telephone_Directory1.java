package myself;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Telephone_Directory1 {

    public static void main(String[] args) {
        Map<String, String> directory = new HashMap<>();

        
        directory.put("8609678099", "Bhanu");
        directory.put("9959713005", "Surekha");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Search by Name");
            System.out.println("2. Search by Phone Number");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    String phoneNumberByName = searchPhoneNumberByName(directory, name);
                    if (phoneNumberByName != null) {
                        System.out.println("Phone Number: " + phoneNumberByName);
                    } else {
                        System.out.println("Name not found in the directory.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the phone number: ");
                    scanner.nextLine(); // Consume the newline character
                    String phoneNumber = scanner.nextLine();
                    String nameByPhoneNumber = searchNameByPhoneNumber(directory, phoneNumber);
                    if (nameByPhoneNumber != null) {
                        System.out.println("Name: " + nameByPhoneNumber);
                    } else {
                        System.out.println("Phone number not found in the directory.");
                    }
               
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static String searchPhoneNumberByName(Map<String, String> directory, String name) {
        for (Map.Entry<String, String> entry : directory.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(name)) {
                return entry.getKey();
            }
        }
        return null; // Name not found
    }

    public static String searchNameByPhoneNumber(Map<String, String> directory, String phoneNumber) {
        return directory.get(phoneNumber);
    }
}


	

