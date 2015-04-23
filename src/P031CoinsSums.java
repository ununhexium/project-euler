import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

public class P031CoinsSums
{
    public static void main(String[] args)
    {
        int[] base = { 1, 2, 5, 10, 20, 50, 100, 200 };
        int q = 5;
        List<int[]> count = allDecompositions(q, base);
        for (int[] c : count)
        {
            printArray(base, c);
        }
    }
    
    private static void printArray(int[] base, int[] d)
    {
        int total = compose(base, d);
        System.out.println("" + total + " is:");
        for (int i = 0; i < d.length; ++i)
        {
            if (d[i] != 0)
            {
                System.out.println("" + d[i] + "\tcoins of " + base[i]);
            }
        }
    }
    
    private static List<int[]> allDecompositions(int value, int[] base)
    {
        int[] d = decompose(value, base);
        printArray(base, d);
        System.out.println();
        List<int[]> combinations = new ArrayList<int[]>();
        combinations.add(Arrays.copyOf(d, d.length));
        while (d[0] * base[0] != value)
        {
            int minIndex = 1;
            while (minIndex < d.length && d[minIndex] == 0)
            {
                minIndex++;
            }
            if (minIndex < d.length)
            {
                d[minIndex]--;
                List<int[]> combinations2 = allDecompositions(base[minIndex], Arrays.copyOf(base, minIndex));
                for (int[] c : combinations2)
                {
                    int[] e = Arrays.copyOf(d, d.length);
                    for (int i = 0; i < c.length; ++i)
                    {
                        e[i] += c[i];
                    }
                    printArray(base, e);
                    combinations.add(e);
                }
            }
        }
        return combinations;
    }
    
    private static int[] decompose(int i, int[] base)
    {
        int index = base.length - 1;
        int[] result = new int[base.length];
        Arrays.sort(base);
        while (i > 0 && index >= 0)
        {
            if (base[index] == 0)
            {
                break; // to avoid funny guys who would use multiple zeros as a base
            }
            while (i >= base[index])
            {
                ++result[index];
                i -= base[index];
            }
            --index;
        }
        
        return result;
    }
    
    private static int compose(int[] base, int[] values)
    {
        if (base.length < values.length)
        {
            throw new IllegalArgumentException("The base must be at least as long as the values. base.length="
            + base.length + ", values.length=" + values.length);
        }
        
        int total = 0;
        for (int i = 0; i < base.length; ++i)
        {
            total += base[i] * values[i];
        }
        
        return total;
    }
}
