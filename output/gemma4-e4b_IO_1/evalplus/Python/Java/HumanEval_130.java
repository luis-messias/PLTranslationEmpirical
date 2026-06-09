package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> tri(int n) {
        List<Integer> ans = new ArrayList<>();

        if (n == 0) {
            ans.add(1);
            return ans;
        }
        if (n == 1) {
            ans.add(1);
            ans.add(3);
            return ans;
        }

        // Initialize ans with the first two elements (for i=0 and i=1)
        ans.add(1); // Index 0
        ans.add(3); // Index 1

        // Loop from i=2 up to n
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                // tri(n) = 1 + n / 2, if n is even.
                ans.add(1 + i / 2);
            } else {
                // tri(n) = tri(n - 1) + tri(n - 2) + tri(n + 1), if n is odd.
                // Note: The Python implementation uses ans[-1] and ans[-2], which correspond to tri(i-1) and tri(i-2).
                // The formula in Python is: ans[-1] + ans[-2] + 1 + (i + 1) / 2
                
                // Get tri(i-1) and tri(i-2)
                int last = ans.get(ans.size() - 1);
                int secondLast = ans.get(ans.size() - 2);
                
                // Calculate the next value
                int nextVal = last + secondLast + 1 + (i + 1) / 2;
                ans.add(nextVal);
            }
        }
        return ans;
    }
}
