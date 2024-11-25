import java.util.*;

class Solution {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int slidingPuzzle(int[][] board) {
        String start = boardToString(board);
        String goal = "123450";
        
        if (start.equals(goal)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        
        int moves = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (String next : getNextStates(current)) {
                    if (!visited.contains(next)) {
                        if (next.equals(goal)) return moves;
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    private List<String> getNextStates(String state) {
        List<String> nextStates = new ArrayList<>();
        int zeroIndex = state.indexOf('0');
        int zeroRow = zeroIndex / 3;
        int zeroCol = zeroIndex % 3;

        for (int[] dir : dirs) {
            int newRow = zeroRow + dir[0];
            int newCol = zeroCol + dir[1];
            if (newRow >= 0 && newRow < 2 && newCol >= 0 && newCol < 3) {
                char[] chars = state.toCharArray();
                int newIndex = newRow * 3 + newCol;
                chars[zeroIndex] = chars[newIndex];
                chars[newIndex] = '0';
                nextStates.add(new String(chars));
            }
        }
        return nextStates;
    }
}