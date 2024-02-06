/*



 */

import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PortfolioManager {
    ArrayList<TransactionHistory> portfolioList = new ArrayList<TransactionHistory>(); //ArrayList to store any number of TransactionHistory records
    TransactionHistory transaction = new TransactionHistory();


    double cashAvailable = 0;
    double stockAvaiable = 0;




    public void menu () {
        //print menu
        int selection = 0;
        double userAmount =0;
        Scanner userIn = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("David Brown Brokerage Acoount");
            System.out.println();
            System.out.println("     Transaction Menu     ");
            System.out.println("--------------------------");
            System.out.println("Enter 0 to Exit");
            System.out.println("Enter 1 to Deposit Cash");
            System.out.println("Enter 2 to Withdraw Cash");
            System.out.println("Enter 3 to Buy Stock");
            System.out.println("Enter 4 to Sell Stock");
            System.out.println("Enter 5 to Display Transaction History");
            System.out.println("Enter 6 to Display Portfolio");
            selection = userIn.nextInt();

            switch (selection) {
                case 0: //Exit
                    break;
                case 1: //Deposit Cash
                    userAmount = DepositCashMenu();
                    DepositCash(userAmount);
                    break;
                case 2: //Withdraw Cash
                    userAmount = WithdrawCashMenu();
                    WithdrawCash(userAmount);
                    break;
                case 3: //Buy Stock
                    BuyStockMenu();
                    BuyStock(userAmount);

                    break;
                case 4: //Sell Stock
                    SellStockMenu();
                    SellStock(userAmount);
                    break;
                case 5: //Display Transaction History
                    DisplayTransactionHistory();
                    break;
                case 6: // Display Portfolio
                    DisplayPortfolio();
                    break;
                default: // Enter option (0 to 6):
                    System.out.println("Entered incorrect option please select from the menu.");
                    break;
            }
        } while (selection != 0);
    }
    public void DepositCash(double userAmount) {
        String date ="";
        portfolioList.add(new TransactionHistory("CASH", date, "Deposit", userAmount, 1));
    }
    public double DepositCashMenu() {
        Scanner userIn = new Scanner(System.in);
        double amount = 0;
        boolean exit = false;
        do {
            System.out.println("Enter amount for deposit");
            amount = userIn.nextDouble();
            if ( amount < 0.0){
                System.out.println("Amount entered is invalid please enter a valid input");
            }
            else {
                cashAvailable = cashAvailable + amount;
                exit = true;
            }
        }while (!exit);
        return amount;
    }
    public void WithdrawCash(double userAmount) {

    }

    public double WithdrawCashMenu() {
        Scanner userIn = new Scanner(System.in);
        double amount = 0;
        boolean exit = false;
        do {
            System.out.println("Enter amount for withdrawal");
            amount = userIn.nextDouble();
            if (amount < 0.0) {
                System.out.println("Amount entered is invalid please enter a valid input");
            }
            if (amount > cashAvailable) {
                System.out.println("Withdrawl amount exceeds available funds");
            }
            if (amount < cashAvailable) {
                cashAvailable = cashAvailable - amount;
                break;
            }
            else{
                exit = true;
            }
        }while (!exit);
        return amount;
    }
    public void BuyStock(double userAmount) {
    }
    public void BuyStockMenu() {
        Scanner userIn = new Scanner(System.in);
        double amount = 0;
        boolean exit = false;
        double userCostBasis = 0;
        do {
            System.out.println("Enter amount of stock to purchase");
            amount = userIn.nextDouble();
            if ( amount < 0.0){
                System.out.println("Amount entered is invalid please enter a valid input");
            }
            else{
                exit = true;
            }
        }while (!exit);
        do {
            System.out.println("Enter cost basis of stock");
            userCostBasis = userIn.nextDouble();
            if ( userCostBasis < 0.0) {
                System.out.println("Amount entered is invalid please enter a valid input");
            }
            if ((amount * userCostBasis) > cashAvailable) {
                System.out.println("Amount entered exceeds available funds");
                break;
            }
            if ((amount * userCostBasis) < cashAvailable) {
                cashAvailable = cashAvailable - (amount * userCostBasis);
                stockAvaiable = stockAvaiable + amount;
                break;
            }
            else{
                exit = true;
            }
        }while (!exit);
    }
    public void SellStock(double userAmount) {

    }
    public void SellStockMenu() {
        Scanner userIn = new Scanner(System.in);
        double amount = 0;
        boolean exit = false;
        double userCostBasis;
        do {
            System.out.println("Enter amount of stock to sell");
            amount = userIn.nextDouble();
            if (amount < 0.0){
                System.out.println("Amount entered is invalid please enter a valid input");
            }
            else{
                exit = true;
            }
        }while (!exit);
        do {
            System.out.println("Enter cost basis of stock");
            userCostBasis = userIn.nextDouble();
            if (userCostBasis < 0.0){
                System.out.println("Amount entered is invalid please enter a valid input");
                break;
            }
            if (stockAvaiable < amount) {
                System.out.println("Amount entered exceeds amount of stock owned");
                break;
            }
            if (stockAvaiable > amount) {
                stockAvaiable = stockAvaiable - amount;
                break;
            }
            else{
                exit = true;
            }
        }while (!exit);
    }
    public void DisplayTransactionHistory() {

    }
    public void DisplayPortfolio() {

    }

    public static void main(String[] args) {
        PortfolioManager manager = new PortfolioManager();
        manager.menu();

    }

}