class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int n= seats.length;
        int minMove=0;
        for(int i=0; i<n; i++){
            minMove+= Math.abs(seats[i] - students[i]);
        }
        return minMove;
    }
}