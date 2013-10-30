public class P006SumSquareDifference
{
    public static void main(String[] args)
    {
        long squares = 0;
        long sum = 0;
        for (int i = 0; i < 101; i++)
        {
            squares += i * i;
            sum += i;
        }
        
        System.out.println(sum * sum - squares);
    }
}
