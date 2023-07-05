// Medium. Sliding Window.
// July 4 2023.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;
        int curLength = 0;
        int record = 0;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        while (fast < s.length()) {
            
            char cur = s.charAt(fast);
            
            if (map.containsKey(cur) && (map.get(cur) >= slow)) {
                
                slow = map.get(cur) + 1;
                map.replace(cur, fast);
                curLength = fast - slow + 1;
                
            }
            else {
                map.put(cur, fast);
                curLength++;
                record = Math.max(record, curLength);
            }
            
            fast++;
        }
        
        return record;
    }
}
