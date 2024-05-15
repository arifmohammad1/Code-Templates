import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
//Function to find the shortest distance of all the vertices
//from the source vertex S.
// the adj list has edges form one node to another
public class DijkstraAlgorithm {
    
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.add(new Pair(0, S));
        int[] ans = new int[V];
        Arrays.fill(ans, (int) 1e8);
        ans[S] = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int m = p.distance;
            int n = p.lastnode;
            for (int i = 0; i < adj.get(n).size(); i++) {
                int x = adj.get(n).get(i).get(0);
                int y = adj.get(n).get(i).get(1);
                if (m + y < ans[x]) {
                    ans[x] = m + y;
                    pq.add(new Pair(ans[x], x));
                }
            }
        }
        return ans;
    }

    static class Pair {
        int distance, lastnode;

        Pair(int m, int n) {
            distance = m;
            lastnode = n;
        }
    }
}
