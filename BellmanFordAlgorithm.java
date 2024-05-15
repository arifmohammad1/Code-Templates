/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/

/* This Algorithm iterates on all the egdes for V-1 times and finds minimum distance
   It detects negative cycle too
   V-1 because source node may be in last of edges list  */
class BellmanFordAlgorithm {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dis = new int[V];
        Arrays.fill(dis,(int)1e8);
        dis[S] = 0;
        int n = edges.size();
        for(int i = 0; i < V-1; i++) {
            for(int j = 0; j < n; j++) {
                int x = edges.get(j).get(0);
                int y = edges.get(j).get(1);
                int z = edges.get(j).get(2);
                if(dis[x] != (int)1e8)
                dis[y] = Math.min(dis[y],dis[x]+z);
            }
        }
        for(int j = 0; j < n; j++) {
                int x = edges.get(j).get(0);
                int y = edges.get(j).get(1);
                int z = edges.get(j).get(2);
                if(dis[x] != (int)1e8 && dis[y] > dis[x]+z) {
                    return new int[]{-1};
                }
            }
            return dis;
    }
}
