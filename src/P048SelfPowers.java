import java.math.BigInteger;

public class P048SelfPowers
{
    public static void main(String[] args)
    {
        BigInteger bi = BigInteger.ZERO;
        for (int i = 1; i <= 1000; ++i)
        {
            bi = bi.add(new BigInteger(Integer.toString(i)).pow(i));
        }
        String out = bi.toString();
        System.out.println(out);
        String trunk = out.substring(out.length() - 10);
        System.out.println(trunk);
    }
}
