package com.sanjar.hacker.earth;

/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class TestClass {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] nk = line.split(" ");
        Tree1 tree = new Tree1();
        for(int i = 0 ;i<Integer.valueOf(nk[0])-1;i++){
        	String[] values = br.readLine().split(" ");
        	tree.addNode(values[1], values[0]);
        }
        int count =0;
       // tree.display("1");
        for(Node1 n : tree.getNodes().values()){
        	int parent = Integer.valueOf(n.getIdentifier());
        	for(String n1 : n.getChildren()){
        		int child = Integer.valueOf(n1);
        		if((parent*child)>=Integer.valueOf(nk[1])){
        			count = count+1;
        		}
        	}
        }
        System.out.println(count);
	}
}
class Tree1 {


    private HashMap<String, Node1> nodes;

    // Constructors
    public Tree1() {
    	 this.nodes = new HashMap<String, Node1>();
    }

    // Public interface
    public Node1 addNode(String identifier) {
        return this.addNode(identifier, null);
    }

    public Node1 addNode(String identifier, String parent) {
        Node1 node = new Node1(identifier);
        if(nodes.get(identifier)==null)
        	nodes.put(identifier, node);

        if (parent != null) {
        	if(nodes.get(parent)==null){
        		this.addNode(parent, null);
        	}
            nodes.get(parent).addChild(identifier);
        }

        return node;
    }
    public HashMap<String, Node1> getNodes() {
        return nodes;
    }
   
}
class Node1 {

    private String identifier;
    private ArrayList<String> children;

    // Constructor
    public Node1(String identifier) {
        this.identifier = identifier;
        children = new ArrayList<String>();
    }

    // Properties
    public String getIdentifier() {
        return identifier;
    }

    public ArrayList<String> getChildren() {
        return children;
    }

    // Public interface
    public void addChild(String identifier) {
        children.add(identifier);
    }
}


