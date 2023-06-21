package LMS_Projects;

import java.util.Scanner;

public class Email_Search {
    public static void main(String[] args) {
        // Array of employee email IDs
        String[] employeeEmails = {
            "john@example.com",
            "jane@example.com",
            "alex@example.com",
            "mary@example.com"
        };

        // Prompt the user to enter an email ID
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an email ID to search: ");
        String searchEmail = scanner.nextLine();

        // Perform the search
        boolean found = false;
        for (String email : employeeEmails) {
            if (email.equalsIgnoreCase(searchEmail)) {
                found = true;
                break;
            }
        }

        // Display the search result
        if (found) {
            System.out.println("Email ID found in the array.");
        } else {
            System.out.println("Email ID not found in the array.");
        }

        scanner.close();
    }
}
