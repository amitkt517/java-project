import java.io.*;
import java.util.*;

public class Ticket {
    private String destination;
    private String departure;
    private String date;
    private String train;
    private String name;
    private int age;
    private int distance;
    private int price;

    public void book() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter destination: ");
        destination = scanner.nextLine();
        
        System.out.print("Enter departure: ");
        departure = scanner.nextLine();
        
        System.out.print("Enter date (of this month): ");
        date = scanner.nextLine();
        
        System.out.print("Enter distance: ");
        while (!scanner.hasNextInt() || (distance = scanner.nextInt()) <= 0) {
            System.out.print("Invalid input. Please enter a positive distance: ");
            scanner.next();
        }
        
        System.out.println("Select a train:");
        System.out.println("1. Shatabdi Express");
        System.out.println("2. Rajdhani Express");
        System.out.print("Enter your choice: ");
        int trainChoice = 0;
        while (!scanner.hasNextInt() || ((trainChoice = scanner.nextInt()) != 1 && trainChoice != 2)) {
            System.out.print("Invalid train choice. Please enter 1 or 2: ");
            scanner.next();
        }
        
        if (trainChoice == 1) {
            train = "Shatabdi Express";
        } else if (trainChoice == 2) {
            train = "Rajdhani Express";
        }
        
        scanner.nextLine(); // consume the remaining newline
        
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        
        System.out.print("Enter age: ");
        while (!scanner.hasNextInt() || (age = scanner.nextInt()) <= 0) {
            System.out.print("Invalid input. Please enter a positive age: ");
            scanner.next();
        }

        double basePrice = (trainChoice == 1) ? 2.0 : 3.0;
        
        if (age < 5) {
            price = 0;
        } else {
            price = (int)(distance * basePrice);
        }

        try (FileWriter fileWriter = new FileWriter("tickets.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println("Destination: " + destination);
            printWriter.println("Departure: " + departure);
            printWriter.println("Date: " + date);
            printWriter.println("Distance: " + distance + " km");
            printWriter.println("Train: " + train);
            printWriter.println("Name: " + name);
            printWriter.println("Age: " + age);
            printWriter.println("Price: Rs." + price);
            printWriter.println("------------------------");
            System.out.println("Ticket booked successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public void display() {
        try (FileReader fileReader = new FileReader("tickets.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            System.out.println("Booked Tickets:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error opening tickets file.");
        }
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Railway Platform Ticket Interface");
            System.out.println("--------------------------------");
            System.out.println("1. Book Ticket");
            System.out.println("2. Display Tickets");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt() || (choice = scanner.nextInt()) < 1 || choice > 3) {
                System.out.print("Invalid choice. Please enter 1, 2, or 3: ");
                scanner.next();
            }

            switch (choice) {
                case 1:
                    ticket.book();
                    break;
                case 2:
                    ticket.display();
                    break;
                case 3:
                    return;
            }
        }
    }
}
