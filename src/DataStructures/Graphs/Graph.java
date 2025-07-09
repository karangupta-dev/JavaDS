package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

//    Below goes into main()
//    Graph myGraph = new Graph();
//
//        myGraph.addVertex("A");
//        myGraph.addVertex("B");
//
//        myGraph.addEdge("A", "B");
//
//        System.out.println("\nGraph:");
//        myGraph.printGraph();
//
//        myGraph.removeEdge("A", "B");
//
//        System.out.println("\nAfter edge removal Graph:");
//        myGraph.printGraph();
//
//        myGraph.removeVertex("B");
//
//        System.out.println("\nAfter vertex removal Graph:");
//        myGraph.printGraph();

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(final String vertexName) {
        if (adjList.get(vertexName) == null) {
            adjList.put(vertexName, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(final String vertex1, final String vertex2) {
        if (vertex1 != null && vertex2 != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(final String vertex1, final String vertex2) {
        if (vertex1 != null && vertex2 != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(final String vertexName) {
        if (adjList.get(vertexName) != null) {
            adjList.remove(vertexName);
            for (String otherVertex : adjList.get(vertexName)) {
                adjList.get(otherVertex).remove(vertexName);
            }
            return true;
        }
        return false;
    }

}