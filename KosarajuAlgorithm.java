// Function to find the number of strongly connected components in the graph.
// time complexity O(V + E)
// strongly connected means can be travelled from one node to any other node
public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        // Step 1: Perform a DFS and push nodes onto the stack in the order of completion
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, st);
            }
        }

        // Step 2: Create a transpose of the graph
        ArrayList<Integer>[] transpose = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            transpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                transpose[j].add(i);
            }
        }

        // Step 3: Perform a DFS based on the order in the stack on the transpose graph
        int count = 0;
        vis = new boolean[V];
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                dfs2(node, transpose, vis);
                count++;
            }
        }

        return count;
    }
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, adj, vis, st);
            }
        }
        st.push(node);  // Push node to stack after processing all its neighbors
    }

    public void dfs2(int node, ArrayList<Integer>[] transpose, boolean[] vis) {
        vis[node] = true;
        for (int neighbor : transpose[node]) {
            if (!vis[neighbor]) {
                dfs2(neighbor, transpose, vis);
            }
        }
    }
