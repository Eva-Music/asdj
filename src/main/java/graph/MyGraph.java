package graph;

import java.util.LinkedList;

public class MyGraph {
    private int vertexCount; // вершины
    private int edgeCount;  //ребра
    private LinkedList<Integer>[] adjLists;

    public MyGraph(int vertexCount) {
        if (vertexCount < 0) {
            throw new IllegalArgumentException();
        }
        this.vertexCount = vertexCount;
        this.edgeCount = 0;
        adjLists = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public void addEdge(int v1, int v2) { // 2 вершины
        if (v1 < 0 || v2 < 0 || v1 > vertexCount - 1 || v2 > vertexCount - 1) {
            throw new IllegalArgumentException();
        }
        adjLists[v1].add(v2);
        adjLists[v2].add(v1);
        edgeCount++;
    }

    public LinkedList<Integer> adjList(int v) { //получить список смежностей
        if (v < 0 || v > vertexCount - 1) {
            throw new IllegalArgumentException();
        }
        return adjLists[v];
    }
}
