// Medium. Stacks.
// June 8 2023
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> cars = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            cars.put(position[i], speed[i]);
        }

        // Track Fleets.
        float mostIterations = 0;
        int fleets = 0;

        Arrays.sort(position);

        for (int i = position.length - 1; i >= 0; i--) {
            float timeToTarget = (float) (target - position[i])/cars.get(position[i]);
            if (mostIterations < timeToTarget) {
                fleets++;
                mostIterations = timeToTarget;
            }
        }

        return fleets;
    }
}
