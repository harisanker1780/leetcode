package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class PopulationOutburst {

    public static void main(String args[] ) throws Exception {
    	   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");                // Reading input from STDIN
        int N = Integer.parseInt(line[0]);
        int capacity = Integer.parseInt(line[1]);

        LinkedList<Node> list = new LinkedList<Node>();

        Node root = new Node(0, capacity);
        Node parent = root;

        for(int i = 0; i < N; i++) {
            line = br.readLine().split(" "); 
            int val = Integer.parseInt(line[0]);
            capacity = Integer.parseInt(line[1]);

            Node node = new Node(val, capacity);

            if(!parent.hasCapacity()) {
                parent = list.removeFirst();
            }

            parent.addChild(node);
            
            if(node.hasCapacity()) {
            	list.add(node);
            }
        }

        LinkedList<Node> parents = new LinkedList<Node>();
        parents.add(root);
        printLevel(parents, 1);
    }

    private static void printLevel(LinkedList<Node> parents, int level) {
        LinkedList<Node> childs = new LinkedList<Node>();
        for(Node p : parents) {
            int index = 1;
            for(Node c : p.childrens) {
                System.out.println(c.parent.val + " " + level + " " + index);
                index++;

                childs.add(c);
            }
        }

        if(childs.size() > 0)
            printLevel(childs, level + 1);    
    }

    static class Node {
         int val;
         int capacity;
         LinkedList<Node> childrens = new LinkedList<Node>();
         Node parent;

         public Node(int val, int capacity) {
             this.val = val;
             this.capacity = capacity;
         }

         public void addChild(Node child) {
             if(hasCapacity()) {
                  childrens.add(child);
                  child.parent = this;
             }
         }

         public boolean hasCapacity() {
             return childrens.size() < capacity;
         }
    }
}
