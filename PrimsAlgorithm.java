//prims algorithm is used to find minimum spanning tree using priority queue
// takes minimum weight edge and mark it visited if not visited yet
//time complexity O((V+E)logV)
class PrimsAlgorithm {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean[] vis = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight); // Use weight for comparison
        pq.add(new Pair(0, 0, -1));
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair t = pq.poll();
            int weight = t.weight;
            int dest = t.dest;
            int src = t.src;

            if (!vis[dest]) {
                sum += weight;
                vis[dest] = true;

                for (int[] edge : adj.get(dest)) {
                    int nextDest = edge[0];
                    int edgeWeight = edge[1];
                        pq.add(new Pair(edgeWeight, nextDest, dest));
                }
            }
        }
        return sum;
    }

    static class Pair {
        int weight; // Weight of the edge
        int dest;   // Destination vertex
        int src;    // Source vertex

        Pair(int weight, int dest, int src) {
            this.weight = weight;
            this.dest = dest;
            this.src = src;
        }
    }
}
