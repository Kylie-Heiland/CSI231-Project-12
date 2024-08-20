/*The bank account does not have enough funds. */
public class NoSufficientFundsException extends Exception
{
    String a = "";
    
    public NoSufficientFundsException(String str) //Constructor.
    {
        super(str);
        a = str;
    }
    
    public String getMessage()
    {
        return a;
    }
}