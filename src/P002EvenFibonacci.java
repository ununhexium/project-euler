import net.lab0.tools.math.MyMath;

public class P002EvenFibonacci
{
    
    public static void main(String[] args)
    {
        int i = 0;
        long total = 0;
        
        while (true)
        {
            long result = MyMath.resursiveFibo(i);
            if (result > 4_000_000L)
            {
                break;
            }
            if (result % 2 == 0)
            {
                total += result;
            }
            i++;
        }
        
        System.out.println(total);
    }
}
