// Easy. Two Pointers.
// May 20 2023

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder mod = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                mod.append(s.charAt(i));
            }
        }

        String newS = mod.toString();
        int start = 0;
        int end = newS.length() - 1;
        
        while(start < end) 
            if(newS.charAt(start++) != newS.charAt(end--)) return false;
            
        return true;
    }
}
