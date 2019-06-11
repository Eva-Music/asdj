package graph;

import java.util.LinkedList;

public class DepthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPath(MyGraph g, int source) {
        if (source < 0 || source > g.getVertexCount() - 1) {
            throw new IllegalArgumentException();
        }
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        dfs(g, source);
    }

    private void dfs(MyGraph g, int v) {
        marked[v] = true;
        for (int w : g.adjList(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public boolean hasPathTo(int dist) {
        if (dist < 0 || dist > marked.length - 1) {
            throw new IllegalArgumentException();
        }
        return marked[dist];
    }


    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int currentVertex = dist;
        while (currentVertex != source) {
            stack.push(currentVertex);
            currentVertex = edgeTo[currentVertex];
        }
        return stack;
    }
}
