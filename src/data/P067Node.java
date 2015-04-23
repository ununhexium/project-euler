package data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class P067Node
{
    public boolean        mark     = false;
    public List<P067Node> parents  = new ArrayList<>();
    public BigInteger     content;
    public List<P067Node> children = new ArrayList<>();
    public BigInteger     maxTotal = BigInteger.ZERO;
    
    public P067Node(String content)
    {
        super();
        this.content = new BigInteger(content);
    }
    
    public void connectFromThisTo(P067Node other)
    {
        children.add(other);
        other.parents.add(this);
    }
    
    public int getDepth()
    {
        if (parents.size() == 0)
        {
            return 0;
        }
        else
        {
            return 1 + parents.get(0).getDepth();
        }
    }
    
    public void recursiveSetMark(boolean value)
    {
        this.mark = value;
        for (P067Node n : children)
        {
            n.recursiveSetMark(value);
        }
    }
    
    public void getLeaves(List<P067Node> container)
    {
        if (this.children.size() == 0)
        {
            container.add(this);
        }
        else
        {
            for (P067Node n : children)
            {
                getLeaves(container);
            }
        }
    }
}