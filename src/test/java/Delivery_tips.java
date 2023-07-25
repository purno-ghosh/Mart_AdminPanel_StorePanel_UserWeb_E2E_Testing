import java.util.Scanner;

public class Delivery_tips {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Read input from the user
            System.out.print("Enter your wallet balance: ");
            int walletBalance = scanner.nextInt();

            System.out.print("Enter the item price: ");
            int itemPrice = scanner.nextInt();

            System.out.print("Enter the delivery fee: ");
            int deliveryFee = scanner.nextInt();

            System.out.print("Enter the admin charge: ");
            int adminCharge = scanner.nextInt();

            // Calculate the total amount
            int totalAmount = itemPrice + deliveryFee + adminCharge;

            // Step 1: Display the total amount
            System.out.println("Total amount: " + totalAmount);

            // Step 2: Calculate the remaining wallet balance after the initial purchase
            int remainingWalletBalance = 0;
            if (walletBalance > totalAmount) {
                remainingWalletBalance = walletBalance - totalAmount;
            }

            System.out.println("Remaining Wallet balance: " + remainingWalletBalance);

            // Step 3: Use delivery tips
            System.out.print("Enter delivery tips: ");
            int deliveryTips = scanner.nextInt();
            totalAmount += deliveryTips;
            System.out.println("Total amount after adding delivery tips total amount : " + totalAmount);

            // Step 4: Calculate the due payment after adding delivery tips
            int duePayment = 0;
            if (totalAmount > walletBalance) {
                duePayment = totalAmount - walletBalance;
            }

            System.out.println("Due payment: " + duePayment);

            // Step 5: Remove delivery tips
            System.out.print("Enter delivery tips to remove: ");
            int deliveryTipsToRemove = scanner.nextInt();
            totalAmount -= deliveryTipsToRemove;
            System.out.println("Total amount after removing delivery tips: " + totalAmount);

            // Step 6: Calculate the due payment after removing delivery tips
            if (totalAmount < walletBalance) {
                duePayment = walletBalance - totalAmount;
            } else {
                duePayment = totalAmount - walletBalance;
            }

            System.out.println("Due payment after removing delivery tips: " + duePayment);

            // Close the Scanner
            scanner.close();
        }
    }



