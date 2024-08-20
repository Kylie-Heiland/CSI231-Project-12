//CHECKINGACCOUNT CLASS
    public class CheckingAccount extends Account
    {
    //Removes a specific amount from the account balance.
    public void withdraw(double amount)
    {
        System.out.print(super.toString());
        
        System.out.println("...Withdrawing $" + amount + " from your account.");

        //Will only withdraw if amount is less than/equal to the balance and greater than zero.
        if(amount > 0 && amount <= getBalance())
        {
            setBalance(getBalance() - amount);            
        }
        else
        //Executed if the withdraw is not valid.
        {
            System.out.println("The withdraw amount must be less than or equal to the account's balance and greater than zero.\nThe balance is unchanged.");
            return;
        }
    }
    
    //Returns a string representation of the object.
    public String toString()
    {
        return("Account " + getId() + "'s balance is now $" + Math.floor(getBalance() * 100) / 100 + ".");
    }
    }