// Status:NONE
/*
Ограничение времени 3 секунды 
Ограничение памяти 512МБ 

На день рождения Дмитрию подарили брусок! На данном бруске Дмитрий обнаружил n-1 засечку. Данные засечки разбивают брусок на n сегментов. 
Длина i-го сегмента равняется a_i. Дмитрию хочется распилить брусок на маленькие части. 
Распил разрешается делать только в местах, в которых есть засечки (но необязательно делать распил там, где есть засечка). 
Часть считается маленькой, если ее длина не превосходит s. При этом Дмитрию хочется тратить как можно меньше усилий, поэтому он хочет делать как можно меньше распилов. 

Не успев приступить к делу, Дмитрий задумался: а если бы ему дали не целый брусок, а его подотрезок, который засечками делился бы 
на части с длинами a_l, a_(l+1), ..., a_(r-1), a_r, то на какое количество частей он должен бы был распилить брусок, 
чтобы каждая часть была маленькая? Такое значение обозначим как f(l,r). 

Подумайте вместе c Дмитрием! Посчитайте, чему равняется сумма от l=1 до n (сумма от r=l до n ( f(l,r) ) )

Формат входных данных 
Первая строка содержит число n (1 <= n <= 250000) и s (1 <= s <= 10^15) — количество сегментов, на которые брусок разбит засечками,
и максимальную возможную длину куска, чтобы он все еще считался маленьким.
Вторая строка содержит значения a_1, a_2, ..., a_n (1 <= a_i <= min(s, 10^9)), где a_i — длина i-того сегмента.

Формат выходных данных
Выведите значение: сумма от l=1 до n (сумма от r=l до n ( f(l,r) ) ) , где f(l,r) — минимальное количество частей, на которое 
должен быть разбит брусок из сегментов с длинами a_l, a_(l+1), ..., a_r, чтобы каждая из частей имела длину не более s. 

Замечание про минимальное разбиение
Если a = [3,2,2],  s= 4, то минимальным по размеру будет разбиение на части [3] и [2,2] Если a = [,1,5,1,5,1,5], s = 5, 
то минимальным по размеру будет разбиение на части [5], [1], [5], [1], [5], [1], [5]

Комментарий про пример
f(1,1)+f(1,2)+f(1,3)+f(2,2)+f(2,3)+f(3,3) = 1+1+2+1+2+1 = 8

Примеры данных
Ввод
3 3
1 2 3
Вывод
8
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        long s = scanner.nextLong();
        long[] a = new long[n + 1];
        long[] S = new long[n + 2];
        
        for (int i = 1; i <= n; i++)
            a[i] = scanner.nextLong();

        for (int i = 1; i <= n; i++)
            S[i] = S[i - 1] + a[i];

        long totalCuts = 0;
        for (int i = 1; i <= n - 1; i++) {
            long currentSum = S[i];
            long A = currentSum - s;
            int highK = i - 1;
            int k = binarySearch(S, highK, A);

            if (k == -1)
                continue;

            int x = k + 1;
            long sumWithNext = S[i + 1] - S[k];
            
            if (sumWithNext > s) {
                long contribution = (long) x * (n - i);
                totalCuts += contribution;
            }
        }

        long totalSubarrays = (long) n * (n + 1) / 2;
        System.out.println(totalCuts + totalSubarrays);
    }
    
    public static int binarySearch(long[] S, int high, long A) {
        int low = 0;
        int res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (S[mid] >= A) {
                res = mid;
                low = mid + 1;
            } 
            else
                high = mid - 1;
        }
        return res;
    }
}
