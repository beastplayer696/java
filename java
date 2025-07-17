import java.util.Scanner;

class ElectricityBill {
    private int consumerNumber;
    private String consumerName;
    private int previousReading;
    private int currentReading;
    private int unitsConsumed;
    private int tariffChoice; // 1 for Domestic, 2 for Commercial
    private double billAmount;

    Scanner sc = new Scanner(System.in);

    // Method to read customer and meter details
    public void readDetails() {
        System.out.print("Enter Consumer Number: ");
        consumerNumber = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Consumer Name: ");
        consumerName = sc.nextLine();

        System.out.print("Enter Previous Month Reading: ");
        previousReading = sc.nextInt();

        System.out.print("Enter Current Month Reading: ");
        currentReading = sc.nextInt();

        unitsConsumed = currentReading - previousReading;

        System.out.println("\nTariff Type:");
        System.out.println("1. DOMESTIC");
        System.out.println("2. COMMERCIAL");
        System.out.print("Enter your choice (1 or 2): ");
        tariffChoice = sc.nextInt();
    }

    // Method to calculate bill based on tariff and units
    public void calculateBill() {
        if (tariffChoice == 1) { // Domestic
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 1;
            } else if (unitsConsumed <= 200) {
                billAmount = 100 * 1 + (unitsConsumed - 100) * 2.50;
            } else if (unitsConsumed <= 500) {
                billAmount = 100 * 1 + 100 * 2.50 + (unitsConsumed - 200) * 4.00;
            } else {
                billAmount = 100 * 1 + 100 * 2.50 + 300 * 4.00 + (unitsConsumed - 500) * 6.00;
            }
        } else if (tariffChoice == 2) { // Commercial
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 2;
            } else if (unitsConsumed <= 200) {
                billAmount = 100 * 2 + (unitsConsumed - 100) * 4.50;
            } else if (unitsConsumed <= 500) {
                billAmount = 100 * 2 + 100 * 4.50 + (unitsConsumed - 200) * 6.00;
            } else {
                billAmount = 100 * 2 + 100 * 4.50 + 300 * 6.00 + (unitsConsumed - 500) * 7.00;
            }
        } else {
            System.out.println("Invalid tariff type.");
            billAmount = 0;
        }
    }

    // Method to display the final bill
    public void displayBill() {
        System.out.println("\n--- Electricity Bill ---");
        System.out.println("Consumer Number : " + consumerNumber);
        System.out.println("Consumer Name   : " + consumerName);
        System.out.println("Units Consumed  : " + unitsConsumed);
        System.out.println("Tariff Type     : " + (tariffChoice == 1 ? "DOMESTIC" : "COMMERCIAL"));
        System.out.printf("Total Bill      : Rs. %.2f\n", billAmount);
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricityBill bill = new ElectricityBill();
        bill.readDetails();
        bill.calculateBill();
        bill.displayBill();
    }
}
