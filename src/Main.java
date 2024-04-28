/**
 Ввести с консоли n-размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью генератора случайных
 чисел.
 Перестроить заданную матрицу, переставляя в ней столбцы так, чтобы значения их характеристик убывали. Характеристикой столбца прямоугольной
 матрицы называется сумма модулей его элементов.
 */

import java.util.Arrays;
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

        // Заполнение матрицы случайными значениями в интервале от -n до n
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }

        // Вывод исходной матрицы
        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        // Перестройка матрицы
        rearrangeColumns(matrix);

        // Вывод перестроенной матрицы
        System.out.println("Перестроенная матрица:");
        printMatrix(matrix);
    }

    // Метод для вывода матрицы
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Метод для перестройки матрицы
    public static void rearrangeColumns(int[][] matrix) {
        int[] columnCharacteristics = new int[matrix[0].length];

        // Вычисление характеристик столбцов
        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                sum += Math.abs(matrix[i][j]);
            }
            columnCharacteristics[j] = sum;
        }

        // Сортировка столбцов по убыванию характеристик
        for (int i = 0; i < matrix[0].length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1 - i; j++) {
                if (columnCharacteristics[j] < columnCharacteristics[j + 1]) {
                    // Перестановка столбцов
                    for (int k = 0; k < matrix.length; k++) {
                        int temp = matrix[k][j];
                        matrix[k][j] = matrix[k][j + 1];
                        matrix[k][j + 1] = temp;
                    }
                    // Перестановка характеристик
                    int temp = columnCharacteristics[j];
                    columnCharacteristics[j] = columnCharacteristics[j + 1];
                    columnCharacteristics[j + 1] = temp;
                }
            }
        }
    }
}

