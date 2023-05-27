// Medium. Stacks and Recursion.
// May 27 2023

// Use a recursive function to build strings. Can always add an open parentheses as long as there are fewer than n already,
// but can only add a closed parantheses when there are fewer in the string than open. Names in function as left and right.
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recurse(ans, "", 0, 0, n);
        return ans;
    }

    public void recurse(List<String> ans, String s, int left, int right, int n) {
        if (s.length() == n * 2) {
            ans.add(s);
            return;
        }

        if (left < n) {
            recurse(ans, s+"(", left+1, right, n);
        }
        if (left > right) {
            recurse(ans, s+")", left, right+1, n);
        }
    }
}
