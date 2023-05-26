// Medium. Stacks.
// May 25 2023.
class MinStack {
    private Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.empty()) {
            stack.push(new Pair<>(val, val));
        }
        else {
            stack.push(new Pair<>(val, Math.min(stack.peek().getValue(), val)));
        }
    }
    
    // Does not need to check for empty stack.
    public void pop() {
        stack.pop();
    }
    
    // Does not need to check for empty stack.
    public int top() {
        return stack.peek().getKey();
    }
    
    // Does not need to check for empty stack.
    public int getMin() {
        return stack.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
