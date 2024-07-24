import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] sortJumbled(int[] m, int[] n) {
        int l = n.length;
        int ans[] = new int[l];

        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            h.put(i, m[i]);
        }

        for (int i = 0; i < l; i++) {
            int original = n[i];
            int transformed = 0;
            int place = 1;

            if (original == 0) {
                transformed = h.get(0);
            } else {
                while (original != 0) {
                    int digit = original % 10;
                    original /= 10;
                    transformed += h.get(digit) * place;
                    place *= 10;
                }
            }

            ans[i] = transformed;
        }

    
        int[][] pairs = new int[l][2];
        for (int i = 0; i < l; i++) {
            pairs[i][0] = n[i]; // original number
            pairs[i][1] = ans[i]; // transformed value
        }

   
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        for (int i = 0; i < l; i++) {
            n[i] = pairs[i][0];
        }

        return n;
    }
}
