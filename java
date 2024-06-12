import java.util.Scanner;

class Passenger {
    private String name;
    private int age;
    private String gender;

    public Passenger(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

class RailwayTicketBooking {
    private static boolean[][] seats;
    private static Passenger[][] passengers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int numCols = scanner.nextInt();

        seats = new boolean[numRows][numCols];
        passengers = new Passenger[numRows][numCols];

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Check seat availability");
            System.out.println("2. Book a ticket");
            System.out.println("3. Cancel a ticket");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkSeatAvailability();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                    System.out.println("Thank you for using the Railway Ticket Booking System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkSeatAvailability() {
        int numRows = seats.length;
        int numCols = seats[0].length;
        int availableSeats = 0;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (!seats[row][col]) {
                    availableSeats++;
                }
            }
        }

        System.out.println("Number of available seats: " + availableSeats);
    }

    private static void bookTicket() {
        Scanner scanner = new Scanner(System.in);
        int numRows = seats.length;
        int numCols = seats[0].length;

        System.out.print("Enter the row number (1-" + numRows + "): ");
        int row = scanner.nextInt();
        System.out.print("Enter the column number (1-" + numCols + "): ");
        int col = scanner.nextInt();

        if (row < 1 || row > numRows || col < 1 || col > numCols) {
            System.out.println("Invalid seat selection.");
            return;
        }

        if (seats[row - 1][col - 1]) {
            System.out.println("Seat " + row + "-" + col + " is already booked.");
        } else {
            scanner.nextLine(); // Consume newline character
            System.out.print("Enter passenger name: ");
            String name = scanner.nextLine();
            System.out.print("Enter passenger age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.print("Enter passenger gender: ");
            String gender = scanner.nextLine();

            Passenger passenger = new Passenger(name, age, gender);
            seats[row - 1][col - 1] = true;
            passengers[row - 1][col - 1] = passenger;

            System.out.println("Ticket booked successfully. Seat number: " + row + "-" + col);
        }
    }

    private static void cancelTicket() {
        Scanner scanner = new Scanner(System.in);
        int numRows = seats.length;
        int numCols = seats[0].length;

        System.out.print("Enter the row number (1-" + numRows + "): ");
        int row = scanner.nextInt();
        System.out.print("Enter the column number (1-" + numCols + "): ");
        int col = scanner.nextInt();

        if (row < 1 || row > numRows || col < 1 || col > numCols) {
            System.out.println("Invalid seat selection.");
            return;
        }

        if (!seats[row - 1][col - 1]) {
            System.out.println("Seat " + row + "-" + col + " is not booked.");
        } else {
            seats[row - 1][col - 1] = false;
            Passenger passenger = passengers[row - 1][col - 1];
            passengers[row - 1][col - 1] = null;

            System.out.println("Ticket for seat " + row + "-" + col + " (Passenger: " + passenger.getName() + ") has been cancelled.");
        }
    }
}