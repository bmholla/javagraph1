import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.util.LinkedList;

class javagraph1
{
}

class Graph
{
    static Node CreateRandomGraph(int numNodes)
    {
        Random r = new Random();
    
        //Random Nodes
        LinkedList<Node> ll = new LinkedList<Node>();
        for(int i=0;i<numNodes;i++)
        {
            ll.add(new Node(r.nextFloat()));
        }

        return ll.get(1);        
    }
}

class Node
{
    float value;
    HashSet<Node> hashset;

    public Node(float value)
    {
        this.hashset = new HashSet<Node>();
        this.value = value;
    }

    public Set<Node> getAjacent()
    {
        return this.hashset;
    }

    public float getValue()
    {
        return this.value;
    }

    public void addAdjacent(Node node)
    {
        this.hashset.add(node);
    }
}
