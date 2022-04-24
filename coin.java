package com.company;

public class coin {
    private double balance; // Starting Balance


    public coin() {
        this.balance = 100.0;
        if (this.balance <= 0) {
            System.out.println("No more betting");
            this.balance = 0;
        }
    }

    public void newBal(double betWinnings) {
        this.balance = balance + betWinnings;
    }

    public double getBal() {
        return balance;
    }

}
