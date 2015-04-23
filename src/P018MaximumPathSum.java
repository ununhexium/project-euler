import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import data.P018Node;

public class P018MaximumPathSum
{
    public static void main(String[] args)
    {
        P018Node root = loadTree(P018MaximumPathSum.class.getResource("./P018Input.txt"));
        
        System.out.println();
        System.out.println("Tree");
        displayTree(root);
        
        root.recursiveComputeMaxTotal();
        root.recursiveSetMark(false);
        
        System.out.println();
        System.out.println();
        System.out.println("Tree");
        displayTreeMax(root, "0000");
        
        System.out.println();
        // System.out.println("MAX= "+root.getLeafMaxTotal());
    }
    
    public static P018Node loadTree(URL resource)
    {
        System.out.println("Loading: " + resource);
        List<List<P018Node>> lines = new ArrayList<>();
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
                lines.add(currentLine);
                System.out.println();
            }
        }
        catch (URISyntaxException | IOException e)
        {
            e.printStackTrace();
        }
        
        P018Node root = lines.get(0).get(0);
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
        
        return root;
    }
    
    /**
     * display width first. Love this function :p
     * 
     * @param root
     */
    private static void displayTree(P018Node root)
    {
        NumberFormat numberFormat = new DecimalFormat("00");
        LinkedList<P018Node> nodesToDisplay = new LinkedList<>();
        nodesToDisplay.addLast(root);
        int currentDepth = root.getDepth();
        
        while (!nodesToDisplay.isEmpty())
        {
            P018Node current = nodesToDisplay.pollFirst();
            if (current.getDepth() > currentDepth)
            {
                currentDepth = current.getDepth();
                System.out.println();
            }
            for (P018Node n : current.children)
            {
                if (!n.mark)
                {
                    n.mark = true;
                    nodesToDisplay.addLast(n);
                }
            }
            System.out.print(numberFormat.format(current.content) + " ");
        }
    }
    
    public static void displayTreeMax(P018Node root, String format)
    {
        long max = 0;
        NumberFormat numberFormat = new DecimalFormat(format);
        LinkedList<P018Node> nodesToDisplay = new LinkedList<>();
        nodesToDisplay.addLast(root);
        int currentDepth = root.getDepth();
        
        while (!nodesToDisplay.isEmpty())
        {
            P018Node current = nodesToDisplay.pollFirst();
            if (current.getDepth() > currentDepth)
            {
                currentDepth = current.getDepth();
                System.out.println();
            }
            for (P018Node n : current.children)
            {
                if (!n.mark)
                {
                    n.mark = true;
                    nodesToDisplay.addLast(n);
                }
            }
            if (current.maxTotal > max)
            {
                max = current.maxTotal;
            }
            System.out.print(numberFormat.format(current.maxTotal) + " ");
        }
        System.out.println();
        System.out.println(max);
    }
}
