import java.util.ArrayList;
import java.util.List;

import net.lab0.tools.math.MyMath;

public class P030DigitFifthPowers
{
    public static void main(String[] args)
    {
        int max = 413343; // this value is the biggest value you can reach with 6 times 9^5
        /*
         * So it is not possible to create numbers of 7 digits by summing their digits to the power 5.
         */
        List<Integer> toSum = new ArrayList<>();
        for (int i = 2; i < max; ++i)
        {
            if (test(i))
            {
                toSum.add(i);
            }
        }
        
        System.out.println(toSum);
        System.out.println(MyMath.longSum(toSum));
    }
    
    private static boolean test(int i)
    {
        String s = String.valueOf(i);
        int total = 0;
        for (char c : s.toCharArray())
        {
            int digit = Integer.parseInt("" + c);
            int power5 = digit * digit * digit * digit * digit;
            total += power5;
        }
        return total == i;
    }
}
