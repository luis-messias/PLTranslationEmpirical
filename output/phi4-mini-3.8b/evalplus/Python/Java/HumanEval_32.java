package com.example;
import java.util.List;

public class HumanEval_32 {

    public static double poly(List<Double> xs, double x) {
        double result = 0;
        for (int i = 0; i < xs.size(); i++) {
            result += xs.get(i) * Math.pow(x, i);
        }
        return result;
    }

    public static double findZero(List<Double> xs) throws IllegalArgumentException {
        if (xs == null || !xs.contains(0)) throw new IllegalArgumentException("List must contain at least one zero coefficient.");
        int n = xs.size();
        if ((n % 2 != 1 && Math.abs(xs.get(n - 1)) > Math.abs(xs.get(n))) || (Math.abs(xs.get(n - 1)) <= Math.abs(xs.get(n)))) {
            throw new IllegalArgumentException("List must have an even number of coefficients and the largest non-zero coefficient should be at index n.");
        }

        double dxs = xs.stream().skip(1).mapToDouble(i -> i * (n / 2 - i)).toArray();
        
        return findZeroHelper(xs, new int[]{0}, Math.pow(x, 0), x);
    }
    
    private static double findZeroHelper(List<Double> xs, int[] indices, long powerX, double currentX) {
        if (Math.abs(poly(xs, currentX)) < 1e-5) return currentX;
        
        for (int i = -1; i <= Math.min(indices.length + 2, xs.size() / 3); ++i) {
            int newIndex = indices[i];
            double derivativeValue = poly(dxs, currentX);
            
            if (derivativeValue != 0 && powerX * derivativeValue < 0 || 
                ((newIndex == -1 && Math.abs(xs.get(newIndex)) > xs.get(indices[indices.length - 2])) ||
                 (Math.abs(xs.get(newIndex)) <= Math.abs(xs.get(indices[newIndex + indices.length / 3]))) &&
                newIndex != indices[indices.length - 2] || 
                ((newIndex == indices[0]) && powerX * derivativeValue > 0))) {
                
                double nextPower = currentX;
                if (i >= 1) { // i is not equal to the first index
                    for (int j = newIndex + 1; j < xs.size(); ++j)
                        nextPower += Math.pow(currentX, indices[j] - newIndex);
                }
                
                double result = findZeroHelper(xs, Arrays.copyOf(indices, indices.length), powerX * derivativeValue / dxs.get(newIndex),
                    currentX - (poly(xs, currentX) / derivativeValue));
                
                if ((i == 0 && Math.abs(result - nextPower) < 1e-5 || i > 0)
                        || result != null
                        ) return result;
            }
        }

        throw new IllegalArgumentException("No zero found within the specified range.");
    }


    public static void main(String[] args) {
        List<Double> xs = Arrays.asList(1, 2);
        System.out.println(findZero(xs).equals(-0.5));
        
        xs = Arrays.asList(-6, 11, -6, 1);
        try { 
            double zeroPoint = findZero(xs); 
            System.out.printf("%.2f", zeroPoint); // Expected output: 1.00
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

}