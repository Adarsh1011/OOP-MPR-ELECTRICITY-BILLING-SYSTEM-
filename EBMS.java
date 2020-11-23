import java.util.Scanner;

class User {
    String name, connectionType;
    int meterNum, prevReading, curReading, unitsUsed;
    double totalCost;

    void getDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter your connection type:");
        System.out.print("1) Domestic 2) Commercial: ");
        if (sc.nextInt() == 1) {
            connectionType = "domestic";
        } else {
            connectionType = "commercial";
        }
        System.out.print("Enter your meter number (last 2 digits only): ");
        meterNum = sc.nextInt();
    }

    void getMeterReadings() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter previous month units reading: ");
        prevReading = sc.nextInt();
        System.out.print("Enter current month units reading: ");
        curReading = sc.nextInt();
        unitsUsed = curReading - prevReading;
    }

    int getUnitsUsed() {
        return (curReading - prevReading);
    }

    double getTotalCost() {
        if (connectionType == "domestic") {
            if (unitsUsed < 100) {
                totalCost = unitsUsed * 2.93;
            } else if (unitsUsed >= 100 && unitsUsed < 300) {
                totalCost = unitsUsed * 5.18;
            } else if (unitsUsed >= 300 && unitsUsed < 500) {
                totalCost = unitsUsed * 7.79;
            } else if (unitsUsed >= 500) {
                totalCost = unitsUsed * 9.20;
            }
        } else {
            if (unitsUsed < 100) {
                totalCost = unitsUsed * 4.77;
            } else if (unitsUsed >= 100 && unitsUsed < 300) {
                totalCost = unitsUsed * 7.90;
            } else if (unitsUsed >= 300 && unitsUsed < 500) {
                totalCost = unitsUsed * 9.08;
            } else if (unitsUsed >= 500) {
                totalCost = unitsUsed * 10.92;
            }
        }
        return totalCost;
    }

    void displayBill() {
        System.out.println();
        System.out.println("Name: " + name);
        System.out.println("Connection Type: " + connectionType);
        System.out.println("Meter number: " + meterNum);
        System.out.println("Units of electricity consumed: " + getUnitsUsed());
        System.out.println("Total cost: Rs. " + getTotalCost());
    }
}

class EBMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User users[] = new User[99];
        int choice = 0;
        do {
            System.out.println();
            System.out.print("Choose an option: 1) Add new account 2) Get Bill 3) Exit: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    User u = new User();
                    u.getDetails();
                    users[u.meterNum] = u;
                    break;
                case 2:
                    System.out.print("Enter meter number (last 2 digits only): ");
                    int user = sc.nextInt();
                    try {
                        users[user].getMeterReadings();
                        users[user].displayBill();
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;
                default:
                    break;
            }
        } while (choice != 3);
    }
}
