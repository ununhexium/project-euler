import net.lab0.tools.math.MyMath;

public class P004LargestPalindromeProduct
{
    
    public static void main(String[] args)
    {
        int max = 0;
        for (int i = 100; i < 1000; ++i)
        {
            for (int j = 100; j < 1000; j++)
            {
                if (MyMath.isPalindrome(i * j))
                {
                    if (i * j > max)
                    {
                        max = i * j;
                        System.out.println(i * j);
                    }
                }
            }
        }
    }
}
