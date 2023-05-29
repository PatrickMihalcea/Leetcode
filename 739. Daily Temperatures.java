// Medium. Stacks.
// May 29 2023.
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            
            while (!stack.isEmpty()) {
                int priorTemp = stack.peek().getKey();
                int priorIndex = stack.peek().getValue();
                if (priorTemp < temperatures[i]) {
                    temperatures[priorIndex] = i - priorIndex;
                    stack.pop();
                }
                else {
                    break;
                }
            }

            stack.push(new Pair<Integer, Integer>(temperatures[i], i));

        }

        while (!stack.isEmpty()) {
            temperatures[stack.pop().getValue()] = 0;
        }

        return temperatures;

    }
}
