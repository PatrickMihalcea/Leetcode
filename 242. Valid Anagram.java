// Easy. Arrays and Hashing.
// May 16 2023
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                int remaining = map.get(c);
                if (remaining == 0) {
                    return false;
                }
                map.replace(c, map.get(c) - 1);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
