//Status: PARTIAL SOLUTION

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long n = scanner.nextLong();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();

        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigB = BigInteger.valueOf(b);
        BigInteger bigC = BigInteger.valueOf(c);

        BigInteger lcmAB = bigA.multiply(bigB).divide(bigA.gcd(bigB));
        BigInteger lcmABC = lcmAB.multiply(bigC).divide(lcmAB.gcd(bigC));

        if (n >= lcmABC.longValue()) System.out.println(n);
        else {
            boolean[] reachable = new boolean[(int) n + 1];
            reachable[1] = true;  // Изначально есть 1 рубль

            for (long i = 1; i <= n; i++) {
                if (reachable[(int) i]) {
                    if (i + a <= n) reachable[(int) (i + a)] = true;
                    if (i + b <= n) reachable[(int) (i + b)] = true;
                    if (i + c <= n) reachable[(int) (i + c)] = true;
                }
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (reachable[i]) count++;
            }
            System.out.println(count);
        }
    }
}
