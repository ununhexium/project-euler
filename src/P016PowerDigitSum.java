import java.math.BigInteger;


public class P016PowerDigitSum
{
    public static void main(String[] args)
    {
        BigInteger bigInteger = new BigInteger("2");
        bigInteger = bigInteger.pow(1000);
//        System.out.println(bigInteger);
        String figures = bigInteger.toString();
        int sum = 0;
        for (int i = 0; i < figures.length(); i++)
        {
            sum += Integer.parseInt(figures.substring(i, i+1));
        }
        System.out.println(sum);
    }
}
