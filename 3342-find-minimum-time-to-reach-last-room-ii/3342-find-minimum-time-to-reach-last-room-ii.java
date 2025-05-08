class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.f - b.f);
        pq.offer(new Pair(0, 0, 0));
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!pq.isEmpty()){
            Pair cur = pq.poll();
            int curTime = cur.f;
            int r = cur.s;
            int c = cur.t;
            if (r == m-1 && c == n-1)
                return curTime;
            for (int[] dir : directions){
                int r_ = r + dir[0];
                int c_ = c + dir[1];
                if (r_ < 0 || r_ >= m || c_ < 0 || c_ >= n) continue;
                int step = (r + c) % 2 + 1;
                int time = Math.max(moveTime[r_][c_], curTime) + step;
                if (time < dist[r_][c_]){
                    dist[r_][c_] = time;
                    pq.offer(new Pair(time, r_, c_));
                }
                
            }
        }
        return dist[m-1][n-1];
    }
}
class Pair{
    int f, s, t;
    Pair(int f, int s, int t){
        this.f = f;
        this.s = s;
        this.t = t;
    }
}