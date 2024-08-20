/*This program is used to determine an account balance for a bank. Four elements in an Account array are created, two accounts are Checking and the remaining are
 * savings. For a checking account, there is no interest rate, so this program sets the balance and id for the account, withdraws an amount, then deposits an amount
 * back in. For the savings accounts, there is an interest rate. The interest rate is first applied to the original balance of an account, then as the account
 * withdraws an amount, the interest rate will apply to the new balance. When an amount is depositied, the interest rate would apply to the new balance yet again.
 * Two exception classes, IllegalAmountException and NoSufficientFundsException, help ensure that the account balance and withdrawal amount are always valid.
 * 
 * Note: I was quite unsure how the interest rate should be applied, so I went ahead and just applied it whenever the balance was adjusted. Alternatively, the interest
 * rate could have just been added once, to the original amount, but it did not make sense to me when such significant amounts were being withdrawn/deposited. 
 * 
 * Kylie Heiland
 * 
 * 5-4-2022
 * 
 * Project 12
*/

//MAIN METHOD
public class KylieHeilandProject11
{
    public static void main(String[] args) throws IllegalAmountException, NoSufficientFundsException
    {
        //Declare an array of Account of size 4.
        Account[] accounts = new Account[4];
        
        double withdraw = 0;
        double balance = 0;
        
        //FIRST ELEMENT
        
        
        //Makes the first element be CheckingAccount.
        accounts[0] = new CheckingAccount();
        
        //Initializes the first element to a balance of $___ and an id of 21.
        accounts[0].setBalance(13796);
        accounts[0].setId(21);
        
        try
        {
            balance = accounts[0].getBalance();
            withdraw = 1236;
            
            System.out.println("FIRST ACCOUNT: CHECKING");
            
        //Checks if the withdrawal amount is valid. 
        if(withdraw <= 0)
        {
            System.out.println("The account balance is: $" + balance);
            throw new IllegalAmountException("Withdrawal amount must be greater than $0.");
        }
        else if(withdraw > balance)
        {
            System.out.println("The account balance is: $" + balance);
            throw new NoSufficientFundsException("The withdrawal amount of $1,236 would cause the account's funds to be negative.");
        }
        
        //Withdraws from the account 21's balance.
        accounts[0].withdraw(withdraw);
        
        //Prints out the balance of account 21 prior to (using super.toString() ) and after the withdrawal.
        System.out.println(accounts[0]);

        //Deposits into account 21.
        System.out.println("...Depositing $94.52 into your account.");
        accounts[0].deposit(94.52);
        
        //Prints out the balance of account 21 after the deposit.
        System.out.println(accounts[0]);
        
    }
    
    catch(NoSufficientFundsException str)
    {
        System.out.println(str.getMessage());
    }
    
    catch(IllegalAmountException str)
    {
        System.out.println(str.getMessage());
    }
        
    System.out.println();
    System.out.println("SECOND ACCOUNT: CHECKING");
    
        //SECOND ELEMENT
        
        
        //Makes the second element be CheckingAccount.
        accounts[1] = new CheckingAccount();
        
        //Initializes the second element to a balance of $____ and an id of 13.
        accounts[1].setBalance(150.0);
        accounts[1].setId(13);
        
        balance = accounts[1].getBalance();
        
        withdraw = 136.27;
                
        try
        {
        
            //Checks if the withdrawal amount is valid. 
        if(withdraw <= 0)
        {
            System.out.println("The account balance is: $" + balance);
            throw new IllegalAmountException("Withdrawal amount $136.27 must be greater than $0.");
        }
        else if(withdraw > balance)
        {
            System.out.println("The account balance is: $" + balance);
            throw new NoSufficientFundsException("The withdrawal amount $136.27 would cause the account's funds to be negative.");
        }
        
        //Withdraws from the account 13's balance.
        accounts[1].withdraw(withdraw);
        
        //Prints out the balance of account 13 prior to (using super.toString() ) and after the withdrawal.
        System.out.println(accounts[1]);

        //Deposits into account 13.
        System.out.println("...Depositing $391,231.37 into your account.");
        accounts[1].deposit(391231.37);
        
        //Prints out the balance of account 13 after the deposit.
        System.out.println(accounts[1]);
        
    }
    
    catch(IllegalAmountException str)
    {
        System.out.println(str.getMessage());
    }
    
    catch(NoSufficientFundsException str)
    {
        System.out.println(str.getMessage());
    }
        
    System.out.println();
    System.out.println("THIRD ACCOUNT: SAVINGS");
       
        //THIRD ELEMENT
        
        
        //Makes the third element be SavingsAccount.
        accounts[2] = new SavingsAccount();
        
        //Initializes the third element to a balance of $13,783.23 and an id of 1.
        accounts[2].setBalance(7812);
        accounts[2].setId(1);            
        
        //Sets the interest rate of the third element to 5.09%. Casting is required here, as without it,an error pops up saying that the method is undefined.
        ((SavingsAccount)accounts[2]).setInterestRate(5.09);
                
        try
        {
            //Checks the balance to make sure that prior to adding interest, it is $500 or more.
            if(accounts[2].getBalance() < 500)
            {
                System.out.println("The account balance is: $" + Math.floor(accounts[2].getBalance() * 100) / 100);
                throw new NoSufficientFundsException("Before interest, the account balance is less than $500.");
            }
            
        //Let's user know that the program is adding the interest rate to the account's balance.
        System.out.println("...Adding " + ((SavingsAccount)accounts[2]).getInterestRate() + "% interest to account 30's balance ($" + 
        (Math.floor(accounts[2].getBalance() * 100) / 100) + ").");  
        
        //Updates the account balance to include the interest rate
        ((SavingsAccount)accounts[2]).addInterest();
        
        withdraw = 5000;
        
        //Checks if the withdrawal amount is valid. 
        if(withdraw <= 0)
        {
            System.out.println("The account balance is: $" + Math.floor(accounts[2].getBalance() * 100) / 100);
            throw new IllegalAmountException("Withdrawal amount must be greater than $0.");
        }
        else if(withdraw > accounts[2].getBalance())
        {
            System.out.println("The account balance is: $" + Math.floor(accounts[2].getBalance() * 100) / 100);
            throw new NoSufficientFundsException("The withdrawal amount of $5000 would cause the account's funds to be negative.");
        }
        else if(accounts[2].getBalance() - withdraw < 500)
        {
            System.out.println("The account balance is: $" + Math.floor(accounts[2].getBalance() * 100) / 100);
            throw new NoSufficientFundsException("Withdrawing $5000 will cause the balance of the account to be less than $500.");
        }
        
        //Withdraws from the account 13's balance.
        accounts[2].withdraw(withdraw);
        
        ((SavingsAccount)accounts[2]).addInterest(); //adds the interest to the newly adjusted balance.
            
        //Checks to see if the balance is 500 or more. If it is, then amounts are withdrawn and deposited.
            
            //Prints out the balance of account 13 prior to (using super.toString() ) and after the withdrawal.
            System.out.println(accounts[2]);

            //Deposits into account 13.
            System.out.println("...Depositing $231.37 into your account.");
            accounts[2].deposit(231.37);
            ((SavingsAccount)accounts[2]).addInterest(); //adds the interest to the newly adjusted balance.
        
            //Prints out the balance of account 13 after the deposit.
            System.out.println(accounts[2]);
    }
    
    catch(IllegalAmountException str)
    {
        System.out.println(str.getMessage());
    }
    
    catch(NoSufficientFundsException str)
    {
        System.out.println(str.getMessage());
    }
    
    System.out.println();
    System.out.println("FOURTH ACCOUNT: SAVINGS");
       
        //FOURTH ELEMENT
        
        
        //Makes the fourth element be SavingsAccount.
        accounts[3] = new SavingsAccount();
        
        //Initializes the fourth element to a balance of $___ and an id of 30.
        accounts[3].setBalance(8959.20);
        accounts[3].setId(30);
        
        //Sets the interest rate of the fourth element to 6.56%. Casting is required here, as without it,an error pops up saying that the method is undefined.
        ((SavingsAccount)accounts[3]).setInterestRate(6.56);
        
        try
        {
            //Checks the balance to make sure that prior to adding interest, it is $500 or more.
            if(accounts[3].getBalance() < 500)
            {
                throw new NoSufficientFundsException("Before interest, the account balance is less than $500.");
            }
            
        //Lets user know that the program is adding the interest rate to the account's balance.
        System.out.println("...Adding " + ((SavingsAccount)accounts[3]).getInterestRate() + "% interest to account 30's balance ($" +
        (Math.floor(accounts[3].getBalance() * 100) / 100) + ").");
        
        //Updates the account balance to include the interest rate
        ((SavingsAccount)accounts[3]).addInterest();
        
        withdraw = 378.92;
        
        //Checks if the withdrawal amount is valid. 
        if(withdraw <= 0)
        {
            System.out.println("The account balance is: $" + Math.floor(accounts[3].getBalance() * 100) / 100);
            throw new IllegalAmountException("Withdrawal amount must be greater than $0.");
        }
        else if(withdraw > accounts[3].getBalance())
        {
            System.out.println("The account balance is: $" + Math.floor(accounts[3].getBalance() * 100) / 100);
            throw new NoSufficientFundsException("The withdrawal amount of $378.92 would cause the account's funds to be negative.");
        }
        else if(accounts[3].getBalance() - withdraw < 500)
        {
            System.out.println("The account balance is: $" + Math.floor(accounts[3].getBalance() * 100) / 100);
            throw new NoSufficientFundsException("Withdrawing $378.92 will cause the balance of the account to be less than $500.");
        }
        
        //Withdraws from the account 30's balance.
        accounts[3].withdraw(withdraw);
        
        ((SavingsAccount)accounts[3]).addInterest(); //adds the interest to the newly adjusted balance.
            
        //Checks to see if the balance is 500 or more. If it is, then amounts are withdrawn and deposited.
              
            //Prints out the balance of account 30 prior to (using super.toString() ) and after the withdrawal.
            System.out.println(accounts[3]);

            //Deposits into account 13.
            System.out.println("...Depositing $609.60 into your account.");
            accounts[3].deposit(609.60);
            ((SavingsAccount)accounts[3]).addInterest(); //adds the interest to the newly adjusted balance.
        
            //Prints out the balance of account 13 after the deposit.
            System.out.println(accounts[3]);
    }
    
    catch(IllegalAmountException str)
    {
        System.out.println(str.getMessage());
    }
    
    catch(NoSufficientFundsException str)
    {
        System.out.println(str.getMessage());
    }
        
        
    }
}


/*
 * OUTPUT
 * 
FIRST ACCOUNT: CHECKING
The account balance is: $89940.58
The withdrawal amount of $12,368,429 would cause the account's funds to be negative.

SECOND ACCOUNT: CHECKING
The account balance is: $68429.64
Withdrawal amount $-136.27 must be greater than $0.

THIRD ACCOUNT: SAVINGS
...Adding 5.09% interest to account 30's balance ($13783.23).
The balance of account 1 is $14484.79.
...Withdrawing $5000.0 from your account.
Account 1's balance with the interest rate of 5.09% is now $9967.57.
...Depositing $231.37 into your account.
Account 1's balance with the interest rate of 5.09% is now $10718.06.

FOURTH ACCOUNT: SAVINGS
...Adding 6.56% interest to account 30's balance ($799590.24).
The balance of account 30 is $852043.35.
...Withdrawing $378.92 from your account.
Account 30's balance with the interest rate of 6.56% is now $907533.62.
...Depositing $609.60 into your account.
Account 30's balance with the interest rate of 6.56% is now $967717.42.



FIRST ACCOUNT: CHECKING
The balance of account 21 is $13796.0.
...Withdrawing $1236.0 from your account.
Account 21's balance is now $12560.0.
...Depositing $94.52 into your account.
Account 21's balance is now $12654.52.

SECOND ACCOUNT: CHECKING
The balance of account 13 is $150.0.
...Withdrawing $136.27 from your account.
Account 13's balance is now $13.72.
...Depositing $391,231.37 into your account.
Account 13's balance is now $391245.1.

THIRD ACCOUNT: SAVINGS
...Adding 5.09% interest to account 30's balance ($7812.0).
The balance of account 1 is $8209.63.
...Withdrawing $5000.0 from your account.
Account 1's balance with the interest rate of 5.09% is now $3373.0.
...Depositing $231.37 into your account.
Account 1's balance with the interest rate of 5.09% is now $3787.83.

FOURTH ACCOUNT: SAVINGS
...Adding 6.56% interest to account 30's balance ($8959.2).
The balance of account 30 is $9546.92.
...Withdrawing $378.92 from your account.
Account 30's balance with the interest rate of 6.56% is now $9769.42.
...Depositing $609.60 into your account.
Account 30's balance with the interest rate of 6.56% is now $11059.88.



FIRST ACCOUNT: CHECKING
The account balance is: $90074.74
The withdrawal amount of $12,368,429 would cause the account's funds to be negative.

SECOND ACCOUNT: CHECKING
The account balance is: $162.35
Withdrawal amount $-136.27 must be greater than $0.

THIRD ACCOUNT: SAVINGS
...Adding 5.09% interest to account 30's balance ($4663.75).
The account balance is: $4901.13
The withdrawal amount of $5000 would cause the account's funds to be negative.

FOURTH ACCOUNT: SAVINGS
...Adding 6.56% interest to account 30's balance ($97632.02).
The balance of account 30 is $104036.68.
...Withdrawing $378.92 from your account.
Account 30's balance with the interest rate of 6.56% is now $110457.7.
...Depositing $609.60 into your account.
Account 30's balance with the interest rate of 6.56% is now $118353.32.
 */