package org.example;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterface{
        ATM atm = new ATM();

        Map<Double, String> miniState = new HashMap<>();

    @Override
    public void viewBalance() {
        System.out.println("Available Balance is: " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
            if(withdrawAmount%500 == 0){
                if(withdrawAmount <= atm.getBalance()){
                    System.out.println("withdrawn Successfully" + withdrawAmount);
                    miniState.put(withdrawAmount,"Amount withdrawn");
                    atm.setBalance(atm.getBalance() - withdrawAmount);
                    viewBalance();
                } else {
                    System.out.println("Insufficient Funds");
                }
            }else {
                System.out.println("Please enter the amount multiple of 500");
            }
    }

    @Override
    public void depositAmount(double depositAmount) {
        miniState.put(depositAmount,"Amount deposited");
        System.out.println(depositAmount+ "Deposited Successfully");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        for(Map.Entry<Double, String> m:miniState.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }
    }
}
