class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int nodeA = edges[i][0], nodeB = edges[i][1];
            // Add both directions to the adjacency list as the graph is undirected
            adjacencyList[nodeA].add(new int[]{nodeB, i});
            adjacencyList[nodeB].add(new int[]{nodeA, i});
        }

        // Initialize distances array with maximum values
        int[][] distances = new int[n][2];
        Arrays.fill(distances[source], 0);  // Distance to source is 0 for both runs
        for (int i = 0; i < n; i++) {
            if (i != source) {
                distances[i][0] = distances[i][1] = Integer.MAX_VALUE;  // Initialize distances to infinity
            }
        }

        // Run Dijkstra's algorithm for the first time with original weights
        runDijkstra(adjacencyList, edges, distances, source, 0, 0);
        int difference = target - distances[destination][0];
        if (difference < 0) return new int[][]{}; // If the target is smaller than the shortest path, return empty array

        // Run Dijkstra's algorithm again to modify weights to meet the target
        runDijkstra(adjacencyList, edges, distances, source, difference, 1);
        if (distances[destination][1] < target) return new int[][]{}; // If we can't meet the target distance, return empty array

        // Adjust all edges that were initially set to -1 to 1
        for (int[] edge : edges) {
            if (edge[2] == -1) edge[2] = 1;
        }
        return edges;
    }

    // Helper method to run Dijkstra's algorithm
    private void runDijkstra(List<int[]>[] adjacencyList, int[][] edges, int[][] distances, int source, int difference, int run) {
        int n = adjacencyList.length;
        // Min-heap priority queue to get the node with the smallest distance
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        priorityQueue.add(new int[]{source, 0});
        distances[source][run] = 0;

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            // Skip if the current distance is not optimal
            if (currentDistance > distances[currentNode][run]) continue;

            // Iterate over all neighbors of the current node
            for (int[] neighbor : adjacencyList[currentNode]) {
                int nextNode = neighbor[0], edgeIndex = neighbor[1];
                int weight = edges[edgeIndex][2];

                // For unassigned edge weights, assume the weight as 1
                if (weight == -1) weight = 1;

                // If this is the second run, adjust weights to try to reach the target distance
                if (run == 1 && edges[edgeIndex][2] == -1) {
                    // Calculate the new weight needed to meet the target distance
                    int newWeight = difference + distances[nextNode][0] - distances[currentNode][1];
                    if (newWeight > weight) {
                        // Update the edge weight if the new weight is larger
                        edges[edgeIndex][2] = weight = newWeight;
                    }
                }

                // If a shorter path to nextNode is found, update the distance and push to the priority queue
                if (distances[nextNode][run] > distances[currentNode][run] + weight) {
                    distances[nextNode][run] = distances[currentNode][run] + weight;
                    priorityQueue.add(new int[]{nextNode, distances[nextNode][run]});
                }
            }
        }
        
    }
}