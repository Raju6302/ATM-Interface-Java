package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AtmOperationInterface op = new AtmOperationImpl();

        int atmnumber = 96632;
        int atmpin = 9908;

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine.");
        System.out.print("Enter ATM Number: ");
        int atmNumber = in.nextInt();
        System.out.print("Enter ATM pin: ");
        int atmPin = in.nextInt();

        if((atmnumber == atmNumber) && (atmpin == atmPin)){
            while (true) {
                System.out.println("1.View Available Balance");
                System.out.println("2.Withdraw Amount");
                System.out.println("3. Deposit Amount");
                System.out.println("4.View MiniStatement");
                System.out.println("5.Exit");

                int ch = in.nextInt();
                if(ch == 1){
                    op.viewBalance();
                }
                else if(ch==2){
                    System.out.print("Enter amount to Withdraw: ");
                    double withdrawAmount = in.nextDouble();
                    op.withdrawAmount(withdrawAmount);
                }
                else if(ch==3){
                    System.out.print("Enter Amount to deposit: ");
                    double depositAmount = in.nextDouble();
                    op.depositAmount(depositAmount);
                }
                else if(ch==4){
                    op.viewMiniStatement();
                }
                else if(ch==5){
                    System.out.println("Collect your ATM card ");
                    System.out.println("Thank you for choosing ATM Machine ");
                    System.exit(0);
                }
                else {
                    System.out.print("Please enter a valid number ");
                }
            }

        }else{
            System.out.println("Incorrect Atm Number or Pin");
            System.exit(0);
        }

    }
}