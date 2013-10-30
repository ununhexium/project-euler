public class P005SmallestMultiple
{
    public static boolean testOk(long number)
    {
        for (int i = 1; i < 21; i++)
        {
            if (number % i != 0)
            {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        for (int i = 1; i < Integer.MAX_VALUE; i++)
        {
            if (testOk(i))
            {
                System.out.println(i);
                break;
            }
        }
    }
}
