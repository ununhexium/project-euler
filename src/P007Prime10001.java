import java.util.List;

import net.lab0.tools.math.MyMath;

public class P007Prime10001
{
    public static void main(String[] args)
    {
        List<Integer> primes = MyMath.getPrimes(Integer.MAX_VALUE / 16);
        int index = 1;
        for (int i : primes)
        {
            if (index < 10)
            {
                System.out.println("" + index + ": " + i);
            }
            if (index > 9999)
            {
                System.out.println("" + index + ": " + i);
            }
            if (index > 10005)
            {
                break;
            }
            index++;
        }
    }
}
