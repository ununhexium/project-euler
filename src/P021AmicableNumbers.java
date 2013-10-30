import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.lab0.tools.math.MyMath;

public class P021AmicableNumbers
{
    public static void main(String[] args)
    {
        List<Long> list = MyMath.properDivisors(220);
        System.out.println(list);
        System.out.println(d(list));
        
        Set<Long> amicalNumbers = new HashSet<>();
        for (long a = 1L; a < 10000L; ++a)
        {
            long b = d(MyMath.properDivisors(a));
            long A = d(MyMath.properDivisors(b));
            if (A == a && a != b)
            {
                amicalNumbers.add(a);
                amicalNumbers.add(b);
            }
        }
        
        System.out.println(amicalNumbers);
        long total = 0;
        for (long l : amicalNumbers)
        {
            total += l;
        }
        System.out.println(total);
    }
    
    public static long d(List<Long> list)
    {
        long total = 0;
        for (long l : list)
        {
            total += l;
        }
        return total;
    }
}
