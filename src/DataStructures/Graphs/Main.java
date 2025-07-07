package DataStructures.Graphs;

import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) {

        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");

        myGraph.addEdge("A", "B");

        System.out.println("\nGraph:");
        myGraph.printGraph();

        myGraph.removeEdge("A", "B");

        System.out.println("\nAfter edge removal Graph:");
        myGraph.printGraph();

        myGraph.removeVertex("B");

        System.out.println("\nAfter vertex removal Graph:");
        myGraph.printGraph();


    }
}
