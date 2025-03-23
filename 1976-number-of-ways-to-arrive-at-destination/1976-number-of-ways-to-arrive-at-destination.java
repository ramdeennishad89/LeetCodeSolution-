class Solution {
    public int countPaths(int n, int[][] roads) {
       List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] road : roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int[] ways = new int[n];
        ways[0] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{0, 0});
        int mod = 1_000_000_007;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            if (d > dist[u]) continue;
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], time = neighbor[1];
                if (dist[u] + time < dist[v]) {
                    dist[v] = dist[u] + time;
                    ways[v] = ways[u];
                    pq.offer(new int[]{v, dist[v]});
                } else if (dist[u] + time == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }
        return ways[n - 1]; 
    }
}