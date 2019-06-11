package graph;

public class Main {
    public static void main(String[] args) {
        MyGraph graph = new MyGraph(13);
//        graph.addEdge(0,6);
//        graph.addEdge(0,1);
//        graph.addEdge(0,2);
//        graph.addEdge(5,3);
//        graph.addEdge(5,4);
//        graph.addEdge(5,0);
//        graph.addEdge(6,4);
//        graph.addEdge(3,4);
//
//        DepthFirstPath dfp = new DepthFirstPath(graph, 0);
//        System.out.println(dfp.hasPathTo(6));
//        if (dfp.hasPathTo(3)){
//            System.out.println(dfp.pathTo(3));
//        }

        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 2);
        graph.addEdge(4, 2);
        graph.addEdge(5, 0);

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
        System.out.println(bfs.hasPathTo(3));
        if (bfs.hasPathTo(3)) {
            System.out.println(bfs.pathTo(3));
            System.out.println(bfs.distTo(3));
        }

    }
}
