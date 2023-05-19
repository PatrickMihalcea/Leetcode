// Medium. Arrays and Hashing.
// May 18 2023.
// Required some help with solution to optimize.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Iterate through nums to fill hashmap.
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        // 2. Iterate through hashmap to fill priority queue.
        // Used custom comparator to organize queue from lowest freq. to highest freq. Poll() pops lowest priority.
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int n: map.keySet()) {
            heap.add(n);
        }

        // 3. Pop values until the size of the queue is k, then insert remaining into array and return.
        while (heap.size() > k) {
            heap.poll();
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}
