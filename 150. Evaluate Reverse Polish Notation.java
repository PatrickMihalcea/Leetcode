// Medium. Stacks.
// May 26 2023.
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            char c;
            if (s.length() == 1) {
                c = s.charAt(0);
            }
            else {
                stack.push(Integer.parseInt(s));
                continue;
            }

            switch (c) {
                case '+':
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y + x);
                    break;
                case '-':
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y - x);
                    break;
                case '/':
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y / x);
                    break;
                case '*':
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y * x);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }

        return stack.peek();
    }
}
