import java.util.ArrayList;
import java.util.List;

import net.lab0.tools.math.MyMath;

public class P003LargestPrimeFactor
{
    public static void main(String[] args)
    {
        long i = 2;
        long target = 600851475143L;
        long max = 0;
        
        List<Long> factors = new ArrayList<>();
        
        while (i <= Math.sqrt(target) + 1)
        {
            while (target % i == 0)
            {
//                System.out.println(target);
                max = i;
                target /= i;
                factors.add(i);
            }
            i++;
        }
        factors.add(target);
        
        long check = 1;
        for (Long l : factors)
        {
            System.out.println(l);
            check *= l;
        }
        System.out.println(check);
        System.out.println(max);
        
        List<Long> factors2 = MyMath.primeDecomposition(target);
        System.out.println(factors2.get(factors2.size()-1));
    }
}
