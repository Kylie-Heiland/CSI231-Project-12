
/*MAKES SURE THAT THE AMOUNT BEING WITHDRAWN IS MORE THAN 0 AND LESS THAN THE ORIGINAL BALANCE. */
public class IllegalAmountException extends Exception
{
    String a = "";
    
    public IllegalAmountException(String str) //Constructor.
    {
        super(str);
        a = str;
    }
    
    public String getMessage()
    {
        return a;
    }
}