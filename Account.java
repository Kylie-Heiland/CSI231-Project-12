import java.util.Scanner; 
public class Account
{
    //Declares two private variables.
    private int id;
    private double balance;
   
    //Constructors
    public Account()
    {
        //Initializes both private variables to 0 (no directions were specified for this particular constructor).
        id = 0;
        balance = 0.0;
    }
    
    public Account(int id, double balance)
    {
        //Initializes the private variables to the value of the parameters of id and balance.
        this.id = id;
        this.balance = balance;
    }
    
    //Sets the balance of the account.
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    
    //Returns the balance of the account.
    public double getBalance()
    {
        return balance;
    }
    
    //Sets the account id.
    public void setId(int id)
    {
        this.id = id;
    }
    
    //Returns the account id.
    public int getId()
    {
        return id;
    }
    
    //Adds money to the account's balance.
    public void deposit(double amount)
    {
        balance += amount;
    }
    
    //Removes money from the account's balance.
    public void withdraw(double amount)
    {
        //As per the instructions for this project, this method is implemented by diong nothing. The CheckingAccount and SavingsAccount will handle this.
    }
    
    //Returns a string representation of the object.
    public String toString()
    {
        return("The balance of account " + id + " is $" + Math.floor(balance * 100) / 100 + ".\n");
    }
    
}