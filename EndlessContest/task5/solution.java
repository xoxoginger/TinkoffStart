//Status: OK

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        int count = 0;

        for (int digit = 1; digit <= 9; digit++) {
            long uniformNumber = digit;
            
            while (uniformNumber <= r) {
                if (uniformNumber >= l) count++;
                uniformNumber = uniformNumber * 10 + digit;
            }
        }
        
        System.out.println(count);
    }
}
