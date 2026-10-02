class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // Store position and speed together
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars from closest to target → farthest
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;
        double previousTime = 0;

        // Check cars from front → back
        for (int i = 0; i < n; i++) {

            int pos = cars[i][0];
            int spd = cars[i][1];

            // Time needed to reach target
            double time = (double) (target - pos) / spd;

            // If this car takes longer, it creates a new fleet
            if (time > previousTime) {
                fleets++;
                previousTime = time;
            }

            // Otherwise, it catches the fleet ahead
        }

        return fleets;
    }
}