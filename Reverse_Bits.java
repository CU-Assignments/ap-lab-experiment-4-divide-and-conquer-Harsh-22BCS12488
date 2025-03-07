public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        
        // Loop through all 32 bits
        for (int i = 0; i < 32; i++) {
            // Shift the result to the left by 1 to make space for the new bit
            result <<= 1;
            
            // Extract the last bit from n (either 0 or 1)
            result |= (n & 1);
            
            // Shift n to the right to process the next bit
            n >>= 1;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 43261596;  // Binary: 00000010100101000001111010011100
        System.out.println(solution.reverseBits(n));  // Output: 964176192
    }
}
