import java.util.ArrayList;
import java.util.List;

import data.P018Node;


public class P067MaximumPathSum
{
    public static void main(String[] args)
    {
        P018Node root = P018MaximumPathSum.loadTree(P067MaximumPathSum.class.getResource("./P067Input.txt"));
        System.out.println("compute");
        root.recursiveComputeMaxTotal();
        System.out.println("leaves");
        List<P018Node> leaves = new ArrayList<>();
        root.getLeaves(leaves);
        System.out.println("max");
        System.out.println(0);
    }
}
