/**
 Ввести с консоли n-размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью генератора случайных
 чисел.
 Найти количество всех седловых точек матрицы (матрица А имеет седловую точку А(i, j), если А(i, j) является минимальным элементом в i-й
 строке и максимальным в j-м столбце).
 */

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Ввод размерности матрицы
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();

        // Создание матрицы
        int[][] matrix = new int[n][n];

        // Заполнение матрицы случайными значениями от -n до n
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }

        // Вывод матрицы
        System.out.println("Матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Поиск седловых точек
        int saddlePointsCount = 0;
        for (int i = 0; i < n; i++) {
            int minInRow = matrix[i][0];
            int minColIndex = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < minInRow) {
                    minInRow = matrix[i][j];
                    minColIndex = j;
                }
            }
            boolean isSaddlePoint = true;
            for (int k = 0; k < n; k++) {
                if (matrix[k][minColIndex] > minInRow) {
                    isSaddlePoint = false;
                    break;
                }
            }
            if (isSaddlePoint) {
                saddlePointsCount++;
                System.out.println("Седловая точка: [" + i + "][" + minColIndex + "] = " + minInRow);
            }
        }

        // Вывод количества седловых точек
        System.out.println("Количество седловых точек: " + saddlePointsCount);
    }
}
