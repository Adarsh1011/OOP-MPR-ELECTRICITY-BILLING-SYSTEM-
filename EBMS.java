import java.util.Scanner;

public class EBMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your connection type:");
        System.out.print("1) Domestic 2) Commercial: ");
        String connectionType;
        if (sc.nextInt() == 1) {
            connectionType = "domestic";
        } else {
            connectionType = "commercial";
        }
        System.out.print("Enter your meter number: ");
        int meterNum = sc.nextInt();
        System.out.print("Enter previous month units reading: ");
        int prevReading = sc.nextInt();
        System.out.print("Enter current month units reading: ");
        int curReading = sc.nextInt();
        int unitReading = curReading - prevReading;
        double cost = 0;
        if (connectionType == "domestic") {
            if (unitReading < 100) {
                cost = unitReading * 2.93;
            } else if (unitReading >= 100 && unitReading < 300) {
                cost = unitReading * 5.18;
            } else if (unitReading >= 300 && unitReading < 500) {
                cost = unitReading * 7.79;
            } else if (unitReading >= 500) {
                cost = unitReading * 9.20;
            }
        } else {
            if (unitReading < 100) {
                cost = unitReading * 4.77;
            } else if (unitReading >= 100 && unitReading < 300) {
                cost = unitReading * 7.90;
            } else if (unitReading >= 300 && unitReading < 500) {
                cost = unitReading * 9.08;
            } else if (unitReading >= 500) {
                cost = unitReading * 10.92;
            }
        }
        System.out.println();
        System.out.println("Meter number: " + meterNum);
        System.out.println("Connection Type: " + connectionType);
        System.out.println("Units consumed: " + unitReading);
        System.out.println("Total Cost = Rs. " + cost);
    }
}
