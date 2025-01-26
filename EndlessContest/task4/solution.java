//Status: OK

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long initialSum = 0;
        long[] numbers = new long[n];
        
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
            initialSum += numbers[i];
        }
        
        List<Long> gains = new ArrayList<>();

        for (long num : numbers) {
            int multiplier = 1;
            while (num > 0) {
                long digit = num % 10;
                if (digit < 9) {
                    gains.add((9 - digit) * multiplier);
                }
                
                num /= 10;
                multiplier *= 10;
            }
        }

        gains.sort(Collections.reverseOrder());

        long maxIncrease = 0;
        for (int i = 0; i < k && i < gains.size(); i++) {
            maxIncrease += gains.get(i);
        }

        System.out.println(maxIncrease);
    }
}
