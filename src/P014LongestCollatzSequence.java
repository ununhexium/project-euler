import net.lab0.tools.math.MyMath;

public class P014LongestCollatzSequence
{
    
    public static void main(String[] args)
    {
//        System.out.println(MyMath.collatz(10));
        long max = 0;
        int index = 0;
        for (int i = 1; i < 1_000_000; ++i)
        {
            long calc = MyMath.collatz(i).size();
            if (calc > max)
            {
                System.out.println(max);
                System.out.println(i);
                System.out.println();
                max = calc;
                index = i;
            }
        }
        
        System.out.println(max);
        System.out.println(index);
    }
}
