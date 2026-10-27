import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class searchengine {

    // Method to log user actions
    public static void logAction(String action) {
        try {
            FileWriter writer = new FileWriter("logs.txt", true); // append mode

            // Format timestamp: yyyy-MM-dd HH:mm:ss
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = LocalDateTime.now().format(formatter);

            writer.write(timestamp + " " + action + "\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("Error writing to log file.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Log launching the application
        logAction("launch");

        // Prompt user for search term
        System.out.print("Enter a search term: ");
        String term = scanner.nextLine();

        // Log the search action
        logAction("search : " + term);

        // Exit action
        logAction("exit");

        System.out.println("Search logged. Application exiting.");
    }
}