package com.ps;

public class Main {
    // Create a static variable to store transactions: hint- ArrayList<Transaction>
    public static void main(String[] args) {
        // Create class for storing transactions
            // Fields include date, time, description, vendor and amount
            // *Note
                // if amount is positive then the amount is a deposit
                // if amount is negative then the amount is a payment

        // Load records of transactions to the static variable for transactions
            // * hint-Load transactions before the menu loop

        // Create CLI menu items
            // *hint
            // first do-while: Home menu
            // second do-while: Ledger menu
            // third do-while: Reports menu

        // Perform deposit and payment transactions while recording the transactions to the file

        // Reports

        // Menu Outline
        // **Home Menu**
        // D) Add Deposit
        // P) Make Payment(Debit)
        // L) Ledger
            // **Ledger Menu**
            // A) All
            // D) Deposit
            // P) Payments
            // R) Reports
                // R) **Reports Menu**
                // 1) Month To Date
                // 2) Previous Month
                // 3) Year To Date
                // 4) Previous Year
                // 5) Search by Vendor
                // 0) Back
            // H) Home
        // X) Exit
    }
}