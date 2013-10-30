import java.util.List;

import net.lab0.tools.math.MyMath;


public class P012HighlyDivisibleTriangularNumber
{
    
    public static void main(String[] args)
    {
        System.out.println(MyMath.triangular(7));
        System.out.println(MyMath.divisors(81));
        System.out.println(MyMath.divisors(MyMath.triangular(7)));
        
        long triangular = 1;
        
        int max = 0;
        for (int i = 2; i < Integer.MAX_VALUE; i++)
        {
            // System.out.println(triangular);
            List<Long> div = MyMath.divisors(triangular);
            if (div.size() > max)
            {
                max = div.size();
                System.out.println(i + "-> T" + triangular + "-> D " + max);
                if (div.size() > 500)
                {
                    break;
                }
            }
            triangular += i;
        }
    }
}
