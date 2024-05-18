// krushkal algorithm is implemented using disjoint set
// sort all edges according to weights
// for every edge find ultimate parents of source and destination
//if different join them else leave that edge
class KrushkalAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class DisJointSet {
        int[] parent;
        int[] size;

        DisJointSet(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int Upar(int m) {
            if (parent[m] == m) return m;
            return parent[m] = Upar(parent[m]);
        }

        public void UnionBySize(int m, int n) {
            int rootM = Upar(m);
            int rootN = Upar(n);
            if (rootM == rootN) return;
            if (size[rootM] < size[rootN]) {
                parent[rootM] = rootN;
                size[rootN] += size[rootM];
            } else {
                parent[rootN] = rootM;
                size[rootM] += size[rootN];
            }
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> edges = new ArrayList<>();

        // Convert adjacency list to edge list
        for (int u = 0; u < V; u++) {
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                edges.add(new Edge(u, v, weight));
            }
        }

        // Sort edges by weight
        Collections.sort(edges);

        // Initialize disjoint set
        DisJointSet ds = new DisJointSet(V);

        int result = 0;
        int edgesUsed = 0;

        // Process edges
        for (Edge edge : edges) {
            if (edgesUsed == V - 1) {
                break;
            }

            int rootSrc = ds.Upar(edge.src);
            int rootDest = ds.Upar(edge.dest);

            // If adding this edge does not form a cycle
            if (rootSrc != rootDest) {
                result += edge.weight;
                ds.UnionBySize(rootSrc, rootDest);
                edgesUsed++;
            }
        }

        return result;
    }
}
// time complexity O(ElogE)+E for sorting and iteration
