//Status: PARTIAL SOLUTION

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt() - 1;
        }

        boolean[] visited = new boolean[n];

        int current = 0;
        int cycleLength = 0;

        while (!visited[current] && cycleLength < n) {
            visited[current] = true;
            current = a[current];
            cycleLength++;
        }

        if (cycleLength == n)
            System.out.println("-1 -1");
        else {
            for (int i = 0; i < n; i++) {
                if (a[i] == i) {
                    //если кто-то дарит подарок себе, можно изменить
                    for (int j = 0; j < n; j++) {
                        if (i != j && a[j] != j) {
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
            System.out.println("-1 -1");
        }
    }
}
