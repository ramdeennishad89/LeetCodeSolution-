class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0, direction = 0;
        int maxDistance = 0;

        for (int command : commands) {
            if (command == -1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction + 3) % 4;
            } else {
                for (int k = 0; k < command; k++) {
                    int nx = x + dx[direction];
                    int ny = y + dy[direction];
                    if (!obstacleSet.contains(nx + "," + ny)) {
                        x = nx;
                        y = ny;
                    }
                }
            }
            maxDistance = Math.max(maxDistance, x * x + y * y);
        }
        return maxDistance;
    }
}