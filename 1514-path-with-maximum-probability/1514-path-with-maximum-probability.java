class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Node(v, prob));
            graph.get(v).add(new Node(u, prob));
        }
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Node(start, 1.0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.node;
            double prob = curr.prob;
            if (u == end) return prob;
            for (Node neighbor : graph.get(u)) {
                int v = neighbor.node;
                double newProb = prob * neighbor.prob;
                if (newProb > maxProb[v]) {
                    maxProb[v] = newProb;
                    pq.add(new Node(v, newProb));
                }
            }
        }
        return 0.0;
    }
    class Node {
        int node;
        double prob;
        Node(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
        
    }
}