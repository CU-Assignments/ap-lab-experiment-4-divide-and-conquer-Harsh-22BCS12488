public class Solution {
    public String longestNiceSubstring(String s) {
        // If the string is empty or has only one character, it cannot be a nice string
        if (s == null || s.length() <= 1) {
            return "";
        }
        
        // Initialize the result as an empty string
        String result = "";
        
        // Iterate through the string, considering all substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                
                // Check if the substring is nice
                if (isNice(substring)) {
                    // If the current substring is nice and its length is greater than the result
                    if (substring.length() > result.length()) {
                        result = substring;
                    }
                }
            }
        }
        
        return result;
    }
    
    // Helper function to check if a string is nice
    private boolean isNice(String s) {
        // Use a set to keep track of all characters
        boolean[] seenLower = new boolean[26];  // To track lowercase letters
        boolean[] seenUpper = new boolean[26];  // To track uppercase letters
        
        // Check each character in the string
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                seenLower[c - 'a'] = true;
            } else if (Character.isUpperCase(c)) {
                seenUpper[c - 'A'] = true;
            }
        }
        
        // For each letter in the alphabet, check if both uppercase and lowercase exist
        for (int i = 0; i < 26; i++) {
            if (seenLower[i] != seenUpper[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "YazaAay";
        System.out.println(solution.longestNiceSubstring(s));  // Output: "aAa"
    }
}
