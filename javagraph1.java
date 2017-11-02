import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.util.LinkedList;

class javagraph1
{
    public static void main(String args[])
    {
        Node head = Graph.createFullyConnectedGraph(10);

        for(Node n : head.getAdjacent())
            System.out.println(n);
    }
}

class Graph
{
    static Node createRandomGraph(int numNodes)
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

    static Node createFullyConnectedGraph(int numNodes)
    {
        Random r = new Random();
        ArrayList<Node> al = new ArrayList<Node>(numNodes);
        for(int i=0;i<numNodes;i++)
        {
            //al.add(new Node(r.nextFloat()));
            al.add(new Node(i+1));
        }

        for(Node n : al)
        {
            for(Node o : al)
            {
                n.addAdjacent(o);
            }
        }

        return al.get(0);
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

    public Set<Node> getAdjacent()
    {
        return this.hashset;
    }

    public float getValue()
    {
        return this.value;
    }

    public boolean addAdjacent(Node node)
    {
        //cannot add yourself to you own adjaceny list
        if(this != node)
        {
            this.hashset.add(node);
            return true;
        }
        
        return false;
    }

    public static Set<Node> createFlatSet(Node node)
    {
        HashSet<Node> flatset = new HashSet<Node>();
        flatset.add(node);

        boolean flag;
        do {
            flag = false;

            HashSet<Node> candidates = new HashSet<Node>();
            for(Node n : flatset)
                for(Node o : n.getAdjacent())
                    candidates.add(o);

            for(Node c : candidates)
                flag = flag || flatset.add(c);
        }while(flag);

        return flatset;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        sb.append(this.value + " ->");
        for(Node n : this.hashset)
            sb.append(" " + n.getValue());

        //sb.append("\n");

        return sb.toString();
    }
}
