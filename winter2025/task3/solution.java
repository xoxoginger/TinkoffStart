//Status:OK
/*
Ограничение времени З секунды 
Ограничение памяти 512 МБ 
Чтобы набрать форму к лету, Виктория решила бегать каждый день. До лета осталось всего n дней — именно на протяжении этого срока она и будет бегать. 
Ее личный тренер уже составил ей расписание: в i-й день Виктория должна пробежать a_i километров. 

Виктория считает i-й (3 <= i <= n) день хорошим, если в этот день она пробежит не меньше, чем в первый день, и не больше, чем во второй день. 
Расписание же ей понравится, если хотя бы m дней будут хорошими. В расписании можно делать корректировки: 
произвольное а_i (1 <= i <= n) можно увеличить или уменьшить на 1 километр. Разрешается корректировать один и тот же день несколько раз. 

Какое минимальное корректировок необходимо внести в расписание, чтобы оно понравилось  Виктории? 

Формат входных данных
Первая строка содержит числа n (3 <= n  <= 2 * 10^5) и (1 <= m <= n- 2) — количество дней до лета и количество хороших дней, 
которое необходимо Виктории, чтобы ей понравилось расписание. 

Следующая строка содержит числа a_1, a_2, ..., a_n (1 <= a_i <= 10^9), где a_i — количество километров, 
которое должна пробежать Виктория согласно начальному расписанию. 

Формат выходных данных
Выведите одно число — минимальное количество корректировок, которое необходимо внести в расписание, чтобы оно понравилось Виктории.

Комментарий к примеру
В примере можно дважды уменьшить a_3 на единицу, чтобы расписание понравилось Виктории.
 
Примеры данных
Ввод 
3 1 
3 4 6
Вывод
2

*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
         
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int goodDays = 0; 
        long minCorrections = 0;

        for (int i = 2; i < n; i++) {
            if (a[i] >= a[0] && a[i] <= a[1]) goodDays++;
            else if (goodDays < m) {
                if (a[i] < a[0]) {
                    minCorrections += a[0] - a[i];
                    a[i] = a[0];
                }
                if (a[i] > a[1]) {
                    minCorrections += a[i] - a[1];
                    a[i] = a[1];
                }
                goodDays++;
            }
        }

        if (goodDays >= m) System.out.println(minCorrections);
        else System.out.println(-1);
    }
}
