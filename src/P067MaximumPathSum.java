import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import data.P018Node;
import data.P067Node;

public class P067MaximumPathSum
{
    public static void main(String[] args)
    {
        URL resource = P018MaximumPathSum.class.getResource("./P067Input.txt");
        List<List<P018Node>> tmp = new ArrayList<>();
        try (
            BufferedReader br = new BufferedReader(new FileReader(new File(resource.toURI()))))
        {
            String line = null;
            while ((line = br.readLine()) != null)
            {
                String[] strs = line.split(" ");
                List<P018Node> currentLine = new ArrayList<>();
                for (String s : strs)
                {
                    currentLine.add(new P018Node(Integer.parseInt(s)));
                    System.out.print(s + " ");
                }
                tmp.add(currentLine);
                System.out.println();
            }
        }
        catch (URISyntaxException | IOException e)
        {
            e.printStackTrace();
        }
        
        List<List<P067Node>> lines = new ArrayList<>();
        for (int i = 0; i < tmp.size(); ++i)
        {
            ArrayList<P067Node> list = new ArrayList<>();
            for (int j = 0; j < tmp.get(i).size(); ++j)
            {
                list.add(new P067Node(Long.toString(tmp.get(i).get(j).content)));
            }
            lines.add(list);
        }
        
        for (int depth = 1; depth < lines.size(); depth++)
        {
            for (int width = 0; width < lines.get(depth).size(); width++)
            {
                if (width <= depth)
                {
                    // connect to the element at top of it
                    if (width < depth)
                    {
                        lines.get(depth - 1).get(width).connectFromThisTo(lines.get(depth).get(width));
                    }
                    if (width > 0)
                    {
                        // connect to the element at top left of it
                        lines.get(depth - 1).get(width - 1).connectFromThisTo(lines.get(depth).get(width));
                    }
                }
                assert (false);
            }
        }
        
        lines.get(0).get(0).maxTotal = lines.get(0).get(0).content;
        for (int i = 1; i < lines.size(); ++i)
        {
            int max = i + 1;
            for (int j = 0; j < max; ++j)
            {
                BigInteger res = BigInteger.ZERO;
                if (j > 0)
                {
                    res = res.add(lines.get(i - 1).get(j - 1).maxTotal);
                }
                if (j < i)
                {
                    BigInteger other = lines.get(i - 1).get(j).maxTotal;
                    if (res.compareTo(other)<0){
                        res = other;
                    }
                }
                
                res = res.add(lines.get(i).get(j).content);
                lines.get(i).get(j).maxTotal = res;
            }
        }
        
        displayTreeMax(lines.get(0).get(0), "0000");
    }
    
    public static void displayTreeMax(P067Node root, String format)
    {
        BigInteger max = BigInteger.ZERO;
        NumberFormat numberFormat = new DecimalFormat(format);
        LinkedList<P067Node> nodesToDisplay = new LinkedList<>();
        nodesToDisplay.addLast(root);
        int currentDepth = root.getDepth();
        
        while (!nodesToDisplay.isEmpty())
        {
            P067Node current = nodesToDisplay.pollFirst();
            if (current.getDepth() > currentDepth)
            {
                currentDepth = current.getDepth();
                System.out.println();
            }
            for (P067Node n : current.children)
            {
                if (!n.mark)
                {
                    n.mark = true;
                    nodesToDisplay.addLast(n);
                }
            }
            
            if (current.maxTotal.compareTo(max)>0){
                max = current.maxTotal;
            }
            System.out.print(numberFormat.format(current.maxTotal) + " ");
        }
        System.out.println();
        System.out.println(max);
    }
}
