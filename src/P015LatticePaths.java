import java.math.BigInteger;

import net.lab0.tools.math.MyMath;

public class P015LatticePaths
{
    public static BigInteger combinations(int n)
    {
        return MyMath.fact(2 * n).divide(MyMath.fact(n)).divide(MyMath.fact(n));
    }
    
    public static void main(String[] args)
    {
        long count = 0;
        
        /**
         * <pre>
         * 
         * T T F F
         * T F T F
         * T F F T
         * F T T F
         * F T F T
         * F F T T
         * 
         * </pre>
         * 
         * n! / (n/2)! / (n/2)!
         */
        
        System.out.println(combinations(20));
    }
}
