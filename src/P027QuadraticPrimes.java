import net.lab0.tools.math.MyMath;

public class P027QuadraticPrimes
{
    public static void main(String[] args)
    {
        int max = 0;
        int maxA;
        int maxB;
        int start = -999;
        int stop = 1000;
        System.out.println(test(-79, 1601));
        for (int a = start; a < stop; ++a)
        {
            for (int b = start; b < stop; ++b)
            {
                int consecutivePrimes = test(a, b);
                if (consecutivePrimes > max)
                {
                    max = consecutivePrimes;
                    maxA = a;
                    maxB = b;
                    System.out.println("max=" + max + ", a=" + maxA + ", b=" + maxB);
                }
            }
        }
    }
    
    private static int test(int a, int b)
    {
        int q = b;
        int count = 0;
        int n = 1;
        while (MyMath.isPrime(q))
        {
            count++;
            q = n * n + n * a + b;
            n++;
        }
        return count - 1;
    }
}
