package GraphImplementation;

interface Graph {

    void addEdge(int source, int destination);

    Graph transposingGraph();

    void Dfs(int s);

    void Bfs(int s);
}