package DataStructures.Graphs;



public class Main {


    public static void main(String[] args) {

        Graph_DFS_MaxSumPath myGraph = new Graph_DFS_MaxSumPath();

        myGraph.addVertex("A");
        myGraph.addVertex("B");

        myGraph.addEdge("A", "B");

        System.out.println("\nGraph:");
        myGraph.printGraph();

    }
}
