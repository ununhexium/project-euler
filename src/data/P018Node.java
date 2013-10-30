package data;

import java.util.ArrayList;
import java.util.List;

public class P018Node
{
    public boolean        mark     = false;
    public List<P018Node> parents  = new ArrayList<>();
    public int            content;
    public List<P018Node> children = new ArrayList<>();
    public int            maxTotal = 0;
    
    public P018Node(int content)
    {
        super();
        this.content = content;
    }
    
    public void connectFromThisTo(P018Node other)
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
        for (P018Node n : children)
        {
            n.recursiveSetMark(value);
        }
    }
    
    // launch on the root
    public void recursiveComputeMaxTotal()
    {
        if (parents.size() == 0)
        {
            this.maxTotal = this.content;
        }
        else
        {
            if (parents.size() == 1)
            {
                this.maxTotal = this.content + parents.get(0).maxTotal;
            }
            else
            {
                this.maxTotal = this.content + Math.max(parents.get(0).maxTotal, parents.get(1).maxTotal);
            }
        }
        
        for (P018Node n : children)
        {
            n.recursiveComputeMaxTotal();
        }
    }
    
    public void getLeaves(List<P018Node> container)
    {
        if (this.children.size() == 0)
        {
            container.add(this);
        }
        else
        {
            for (P018Node n : children)
            {
                getLeaves(container);
            }
        }
    }
}