class Solution {
    public int maximumGain(String s, int x, int y) {
        int points = 0, aCount = 0, bCount = 0;
        int lesser = Math.min(x, y);
        for(char ch : s.toCharArray()) {
            if(ch == 'b') {
                if(x > y && aCount > 0) {
                    aCount--;
                    points += x;
                } else 
                    bCount++;
            } else if(ch == 'a') {
                if(x < y && bCount > 0) {
                    bCount--;
                    points += y;
                } else
                    aCount++;
            } else {
               
                points += Math.min(aCount, bCount) * lesser;
                aCount = 0; bCount = 0;
            }
        }
        points += Math.min(aCount, bCount) * lesser;
        return points;
    }
}