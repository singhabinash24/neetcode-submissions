class Solution {
    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        } 
        Set<Integer> sqSumSet = new HashSet<>();
        while(!sqSumSet.contains(n)) {
            sqSumSet.add(n);
            n = squareSumofDigit(n);
            if(n == 1) {
                return true;
            }
        }
        return false; 
    }

    int squareSumofDigit(int n) {
        int sum = 0;
        while(n > 0) {
            int mod = n % 10;
            mod = mod * mod;
            sum += mod;
            n = n/10;
        }
        return sum;
    }
}
