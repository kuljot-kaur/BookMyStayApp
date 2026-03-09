/**
 * BookMyStayApp
 *
 * This class represents the entry point of the Book My Stay
 * Hotel Booking Management System application.
 * It demonstrates centralized room inventory management using HashMap.
 *
 * @author kuljot
 * @version 3.1
 */

import java.util.HashMap;
import java.util.Map;

public class BookMyStayApp {

    /**
     * Abstract Room class defining common properties of all rooms.
     */
    static abstract class Room {

        private String type;
        private int beds;
        private int size;
        private double price;

        public Room(String type, int beds, int size, double price) {
            this.type = type;
            this.beds = beds;
            this.size = size;
            this.price = price;
        }

        public String getType() {
            return type;
        }

        public void displayDetails() {
            System.out.println("Room Type: " + type);
            System.out.println("Beds: " + beds);
            System.out.println("Room Size: " + size + " sq ft");
            System.out.println("Price per Night: $" + price);
            System.out.println("----------------------------------");
        }
    }

    /** Single Room Implementation */
    static class SingleRoom extends Room {
        public SingleRoom() {
            super("Single Room", 1, 200, 80.0);
        }
    }

    /** Double Room Implementation */
    static class DoubleRoom extends Room {
        public DoubleRoom() {
            super("Double Room", 2, 350, 120.0);
        }
    }

    /** Suite Room Implementation */
    static class SuiteRoom extends Room {
        public SuiteRoom() {
            super("Suite Room", 3, 600, 250.0);
        }
    }

    /**
     * RoomInventory class
     * Manages centralized room availability using HashMap
     */
    static class RoomInventory {

        private HashMap<String, Integer> inventory;

        public RoomInventory() {
            inventory = new HashMap<>();

            // Initialize inventory
            inventory.put("Single Room", 5);
            inventory.put("Double Room", 3);
            inventory.put("Suite Room", 2);
        }

        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

        public void updateAvailability(String roomType, int newCount) {
            inventory.put(roomType, newCount);
        }

        public void displayInventory() {
            System.out.println("Hotel Room Inventory Status");
            System.out.println("----------------------------------");

            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + " -> Available: " + entry.getValue());
            }

            System.out.println("----------------------------------");
        }
    }

    /**
     * Main method - Entry point of the application.
     */
    public static void main(String[] args) {

        System.out.println("Welcome to the Hotel Booking Management System");
        System.out.println("System initialized successfully");
        System.out.println("Version: 3.1");
        System.out.println("----------------------------------");

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Display room details
        single.displayDetails();
        doubleRoom.displayDetails();
        suite.displayDetails();

        // Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Display inventory
        inventory.displayInventory();

        // Example update
        System.out.println("Updating Single Room availability...");
        inventory.updateAvailability("Single Room", 4);

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("Application terminated successfully.");
    }
}