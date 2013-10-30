import java.util.List;

import net.lab0.tools.math.MyMath;

public class P010SummationOfPrimes
{
    public static void main(String[] args)
    {
        List<Integer> primes = MyMath.getPrimes(2_000_001);
        long sum = 0;
        for (Integer i : primes)
        {
            sum += i;
        }
        System.out.println(sum);
    }
}
