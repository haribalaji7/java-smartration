package smartration      ;
import java.util.*;

class Beneficiary {
    int cardNo;
    String name;
    int members;
    String category;

    Beneficiary(int cardNo, String name, int members, String category) {
        this.cardNo = cardNo;
        this.name = name;
        this.members = members;
        this.category = category;
    }

    void display() {
        System.out.println(cardNo + "\t" + name + "\t" +
                members + "\t" + category);
    }
}

public class SmartRationSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Beneficiary> list = new ArrayList<>();
    static ArrayList<String> history = new ArrayList<>();

    static void register() {
        System.out.print("Enter Card Number: ");
        int no = sc.nextInt();
        sc.nextLine();

        for (Beneficiary b : list) {
            if (b.cardNo == no) {
                System.out.println("Card already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Family Members: ");
        int members = sc.nextInt();
        sc.nextLine();

        if (members <= 0) {
            System.out.println("Invalid family size!");
            return;
        }

        System.out.print("Enter Category (PHH/NPHH): ");
        String category = sc.nextLine().toUpperCase();

        if (!category.equals("PHH") && !category.equals("NPHH")) {
            System.out.println("Invalid category!");
            return;
        }

        list.add(new Beneficiary(no, name, members, category));
        System.out.println("Beneficiary registered successfully!");
    }

    static void viewBeneficiaries() {
        System.out.println("\nCard No\tName\tMembers\tCategory");

        for (Beneficiary b : list) {
            b.display();
        }

        if (list.isEmpty())
            System.out.println("No beneficiaries found.");
    }

    static Beneficiary search(int no) {
        for (Beneficiary b : list) {
            if (b.cardNo == no)
                return b;
        }
        return null;
    }

    static void searchBeneficiary() {
        System.out.print("Enter Card Number: ");
        int no = sc.nextInt();

        Beneficiary b = search(no);

        if (b != null) {
            System.out.println("Beneficiary Details:");
            b.display();
        } else {
            System.out.println("Beneficiary not found!");
        }
    }

    static void distributeRation() {
        System.out.print("Enter Ration Card Number: ");
        int no = sc.nextInt();

        Beneficiary b = search(no);

        if (b == null) {
            System.out.println("Invalid ration card!");
            return;
        }

        System.out.println("\nRation Details for " + b.name);

        // Sample project allocation rates
        double rice = b.members * 5.0;
        double wheat = b.members * 2.0;
        double sugar = 1.0;

        if (b.category.equals("PHH")) {
            System.out.println("Rice: " + rice + " kg");
            System.out.println("Wheat: " + wheat + " kg");
            System.out.println("Sugar: " + sugar + " kg");
        } else {
            rice = 10;
            wheat = 0;
            sugar = 0;
            System.out.println("Rice: " + rice + " kg");
            System.out.println("Wheat: " + wheat + " kg");
            System.out.println("Sugar: " + sugar + " kg");
        }

        System.out.println("\nRation distributed successfully!");

        history.add("Card: " + no + " | Name: " + b.name +
                " | Rice: " + rice + " kg | Wheat: " +
                wheat + " kg | Sugar: " + sugar + " kg");
    }

    static void viewHistory() {
        System.out.println("\n----- Distribution History -----");

        if (history.isEmpty()) {
            System.out.println("No distribution records found.");
        } else {
            for (String record : history) {
                System.out.println(record);
            }
        }
    }

    public static void main(String[] args) {

        int choice;

        System.out.println("================================");
        System.out.println(" SMART RATION DISTRIBUTION SYSTEM");
        System.out.println("================================");

        System.out.print("Enter Admin Password: ");
        String password = sc.nextLine();

        if (!password.equals("admin123")) {
            System.out.println("Invalid Password!");
            return;
        }

        System.out.println("Login Successful!");

        do {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Register Beneficiary");
            System.out.println("2. View Beneficiaries");
            System.out.println("3. Search Beneficiary");
            System.out.println("4. Distribute Ration");
            System.out.println("5. View Distribution History");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    register();
                    break;

                case 2:
                    viewBeneficiaries();
                    break;

                case 3:
                    searchBeneficiary();
                    break;

                case 4:
                    distributeRation();
                    break;

                case 5:
                    viewHistory();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.out.println("System Closed.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}