//Status: PARTIAL SOLUTION
/*
Ограничение времени З секунды
Ограничение памяти 512 МБ 

Герман немного устал. Вот бы кто-нибудь сделал за него домашнее задание... 
Задача, которую необходимо решить Герману, звучит следующим образом. Дана последовательность a_1, a_2, ..., a_n и числа x, y, z. 
Разрешается произвольное количество (в том числе ноль} раз выполнить следующую операцию:  выбрать произвольное i (1 <= i <= n) и увеличить a_i на единицу. 
Необходимо, чтобы хотя бы один элемент из последовательности делился на x, хотя бы один элемент делился на y и хотя бы один элемент делился на z. 
Разрешается, чтобы для разных значений из набора (x, y, z) подходил один и тот же элемент из последовательности. 
Помогите Герману отдохнуть перед сессией и найдите минимальное количество операций,  которое необходимо выполнить, чтобы условие стало выполнено. 

Формат входных данных
Первая строка содержит числа n (1 <= n <= 2 * 10^5), x, y, z (1 <= x, y,z <= 10^6)
Вторая строка содержит числа a_1, a_2, ..., a_n (1 <= a_i <= 10^18) 

Формат выходных данных
Выведите одно число — минимальное количество операций, которое надо выполнить, чтобы для  каждого из чисел x, y, z 
был хотя бы один элемент в последовательности, кратный данному числу.
 

Комментарий к примеру
В примере можно дважды увеличить a_4 и один раз увеличить a_5. Тогда на 10 будет делиться a_4, на 20 будет делиться a_5, на 30 будет делиться a_4


Примеры данных
Ввод 
6 10 20 30 
8 17 5 28 39 13
Вывод
3
*/


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        long z = scanner.nextLong();
        long[] a = new long[n];
        
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextLong();

        long lcmXY = lcm(x, y);
        long lcmXZ = lcm(x, z);
        long lcmYZ = lcm(y, z);
        long lcmXYZ = lcm(lcmXY, z);

        long minXYZ = Long.MAX_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long minZ = Long.MAX_VALUE;
        long minXY = Long.MAX_VALUE;
        long minXZ = Long.MAX_VALUE;
        long minYZ = Long.MAX_VALUE;

        for (long num : a) {
            long costXYZ = (lcmXYZ - (num % lcmXYZ)) % lcmXYZ;
            minXYZ = Math.min(minXYZ, costXYZ);
            
            long costX = (x - (num % x)) % x;
            minX = Math.min(minX, costX);

            long costY = (y - (num % y)) % y;
            minY = Math.min(minY, costY);

            long costZ = (z - (num % z)) % z;
            minZ = Math.min(minZ, costZ);

            long costXY = (lcmXY - (num % lcmXY)) % lcmXY;
            minXY = Math.min(minXY, costXY);

            long costXZ = (lcmXZ - (num % lcmXZ)) % lcmXZ;
            minXZ = Math.min(minXZ, costXZ);

            long costYZ = (lcmYZ - (num % lcmYZ)) % lcmYZ;
            minYZ = Math.min(minYZ, costYZ);
        }

        long[] minimalOperations = { minX + minY + minZ,
                        minXY + minZ,
                        minXY + minYZ,
                        minXY + minXZ,
                        minXZ + minY,
                        minXZ + minYZ,
                        minYZ + minX,
                        minXYZ
        };
        long res = Long.MAX_VALUE;
        
        for (long min : minimalOperations)
            res = Math.min(res, min);

        System.out.println(res);
    }
    
    //нод
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //нок
    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
