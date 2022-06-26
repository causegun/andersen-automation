public class Triangle {

    public static double area(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("side of a triangle can't be negative");
        } else if ((a >= b + c) || (b >= a + c) || (c >= a + b)) {
            throw new IllegalArgumentException("each side of a triangle should be greater than sum of other sides");
        } else {
            double p = (double) (a + b + c) / 2;
            double scale = Math.pow(10, 2);
            return Math.round(Math.sqrt(p * (p - a) * (p - b) * (p - c)) * scale) / scale;
        }
    }
}