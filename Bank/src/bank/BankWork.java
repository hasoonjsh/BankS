package bank;

import java.io.*;

class BankWork {
    // initialize and declare objects.

    final int max_limit = 20;
    final int min_limit = 1;
    final double min_bal = 500;

    private String name[] = new String[20];
    private int accNo[] = new int[20];
    private String accType[] = new String[20];
    private double balamount[] = new double[20];
    
    //عدد السجلات الحالية
    static int totRec = 0;

    // create a constructor here of Bank.
    BankWork() {
        for (int i = 0; i < max_limit; i++) {
            name[i] = "";
            accNo[i] = 0;
            accType[i] = "";
            balamount[i] = 0.0;
        }
    }

    // Create method to create New entry.
    public void newEntry() {
        String str;

        int account;
        double amount;
        boolean permit;
        permit = true;

        if (totRec > max_limit) {
            System.out.println("\n\n\nSorry we cannot admit you in our bank...\n\n\n");
            permit = false;
        }

        // create new entry.
        if (permit = true) {
            totRec++;

            // Incrementing Records               
            System.out.println("\n\n\n=====SAVING NEW ENTRY=====");
            try {
                accNo[totRec] = totRec;    //Created  AutoNumber  to accNo so no invalid id occurs
                System.out.println("Account Number :  " + accNo[totRec]);

                // create object.
                //للادخال
                BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

                // enter the name of customer here.
                System.out.print("Enter the name of the Customer : ");
                System.out.flush();
                //ادخل الاسم
                name[totRec] = obj.readLine();

                // enter the type of account.
                System.out.print("Enter Account Type : ");
                System.out.flush();
                //ادخال نوع الحساب
                accType[totRec] = obj.readLine();
                //ادخال المبلغ البدائي
                //اعادة الادخال عند ايداع مبلغ اقل من 500
                do {
                    // enter the starting amount.
                    // minimum amount must be 1000.
                    System.out.print("Enter Initial  Amount to be deposited : ");
                    System.out.flush();
                    str = obj.readLine();

                    balamount[totRec] = Double.parseDouble(str);
                } while (balamount[totRec] < min_bal);

                System.out.println("\n\n\n");
            } catch (Exception e) {
                System.out.println("Exception in Entering a record.....");
            }
        }
    }

    // create method to display records.
    //طباعة
    public void display() {
        String str;
        int account = 0;
        boolean valid = true;

        System.out.println("\n\n=====DISPLAYING THE RECORDS=====\n");
        try {
            // create object.
            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

            // enter account number.
            System.out.print("Enter the account number for display record : ");
            System.out.flush();
            //ادخال رقم الحساب
            str = obj.readLine();
            //تحويل الحساب من سترينغ لانتجر
            account = Integer.parseInt(str);

            // check for valid account number
            if (account < min_limit || account > totRec) {
                System.out.println("\n\n\nInvalid Account Number \n\n");
                valid = false;
            }

            if (valid == true) {
                System.out.println("\n\nAccount Number : " + accNo[account]);
                System.out.println("Name : " + name[account]);
                System.out.println("Account Type : " + accType[account]);
                System.out.println("Balance Amount : " + balamount[account] + "\n\n\n");
            }
        } catch (Exception e) {
            System.out.println("Exception in Displaying record.....");
        }
    }

    // create method to deposit amount.
    //ايداع
    public void deposit() {
        String str;
        double amount;
        int account;
        boolean valid = true;
        System.out.println("\n\n\n=====DEPOSIT AMOUNT=====");

        try {
            // create object.
            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter Account No : ");
            System.out.flush();
                //ادخال المبلغ
            str = obj.readLine();
            //تحويل
            account = Integer.parseInt(str);

            // check valid account number.
            if (account < min_limit || account > totRec) {
                System.out.println("\n\n\nInvalid Account Number \n\n");
                valid = false;
            }

            if (valid == true) {
                System.out.print("Enter Amount you want to Deposit  : ");
                System.out.flush();

                str = obj.readLine();
                amount = Double.parseDouble(str);
                //ايداع
                balamount[account] = balamount[account] + amount;

                //Displaying Depsit Details
                System.out.println("\nAfter Updation...");
                System.out.println("Account Number :  " + account);
                System.out.println("Balance Amount :  " + balamount[account] + "\n\n\n");
            }
        } catch (Exception e) {
            System.out.println("Exception in Depositing record.....");
        }
    }
//سحب
    // creating method for withdraw money.
    public void withdraw() {
        String str;

        double amount, checkamount;
        int account;
        boolean valid = true;

        System.out.println("\n\n\n=====WITHDRAW MONEY=====");
        try {
            // create object. 
            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

            // enter account number for entering money
            System.out.print("Enter the account number to deposit money : ");
            System.out.flush();

            str = obj.readLine();
            account = Integer.parseInt(str);

            // check for valid account number.
            if (account < min_limit || account > totRec) {
                System.out.println("\n\n\nInvalid Account Number \n\n");
                valid = false;
            }

            if (valid == true) {
                System.out.println("Balance is : " + balamount[account]);
                System.out.print("Enter Amount you want to withdraw  : ");
                System.out.flush();

                str = obj.readLine();
                amount = Double.parseDouble(str);
                checkamount = balamount[account] - amount;
                //التحقق من اذا كان المبلغ اقل من مبلغ السحب
                if (checkamount >= min_bal) {
                    balamount[account] = checkamount;

                    // Updating the amount after withdraw.
                    System.out.println("\nAfter Updation...");
                    System.out.println("Account Number :  " + account);
                    System.out.println("Balance Amount :  " + balamount[account] + "\n\n\n");
                } else {
                    System.out.println("\n\nAs per Bank Rule you should maintain minimum balance of Rs 500\n\n\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in Withdrawing record.....");
        }
    }
};
