package homework.hw1;

import java.util.Random;

public class Main {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        // Создаём массивы
        Integer[] arrayOne = generatorRandom(10, 1, 15);
        Integer[] arrayTwo = generatorRandom(10, 1, 15);
        // выводим в консоль массивы
        System.out.print("arrayOne = ");
        printArray(arrayOne);
        System.out.print("arrayTwo = ");
        printArray(arrayTwo);
        // Выводим в консоль разность и частное массивов
        System.out.print("difference array = ");
        printArray(difference(arrayOne, arrayTwo));
        System.out.print("division array = ");
        printArray(division(arrayOne, arrayTwo));

    }

    /**
     * Метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
     * каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
     * <br><br>Если длины массивов не равны, выбрасывает RuntimeException - Массивы имеют разную длину.
     *
     * @param arrOne Уменьшаемый массив.
     * @param arrTwo Вычитаемый массив.
     * @return Разность массивов.
     */
    public static Integer[] difference(Integer[] arrOne, Integer[] arrTwo) {
        if (arrOne == null || arrTwo == null) {
            throw new RuntimeException("Массив null.");
        } else if (arrOne.length != arrTwo.length) {
            throw new RuntimeException("Массивы имеют разную длину.");
        } else {
            Integer[] result = new Integer[arrOne.length];
            for (int i = 0; i < arrOne.length; i++) {
                result[i] = arrOne[i] - arrTwo[i];
            }
            return result;
        }
    }

    /**
     * Метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
     * каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
     * <br><br>Если длины массивов не равны, выбрасывает RuntimeException - Массивы имеют разную длину.
     *
     * @param arrOne Уменьшаемый массив.
     * @param arrTwo Вычитаемый массив.
     * @return Разность массивов.
     */
    public static double[] division(Integer[] arrOne, Integer[] arrTwo) {
        if (arrOne == null || arrTwo == null) {
            throw new RuntimeException("Массив null.");
        } else if (arrOne.length != arrTwo.length) {
            throw new RuntimeException("Массивы имеют разную длину.");
        } else {
            double[] result = new double[arrOne.length];
            for (int i = 0; i < arrOne.length; i++) {
                result[i] = (double) arrOne[i] / (double) arrTwo[i];
            }
            return result;
        }
    }

    /**
     * Метод создаёт массив наполненный случайными значениями в диапазоне от minValue и maxValur.
     *
     * @param size     Размер массива.
     * @param minValue Минимальное значение элемента.
     * @param maxValur Максимальное значение элемента.
     * @return Возвращает массив.
     */
    public static Integer[] generatorRandom(int size, int minValue, int maxValur) {
        Integer[] result = new Integer[size];
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(minValue, maxValur);
        }
        return result;
    }

    /**
     * Метод выводит в терминал значение целочисленных элементов массива.
     *
     * @param toPrint массив.
     */
    public static void printArray(Integer[] toPrint) {
        for (int element : toPrint) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Метод выводит в терминал значение численных элементов массива с заданной точностью.
     *
     * @param toPrint массив.
     */
    public static void printArray(double[] toPrint) {
        printArray(toPrint, 2);
    }

    /**
     * Метод выводит в терминал значение численных элементов массива с заданной точностью.
     *
     * @param toPrint массив.
     */
    public static void printArray(double[] toPrint, int precision) {
        String format = "%." + precision + "f ";
        for (double element : toPrint) {
            System.out.printf(format, element);
        }
        System.out.println();
    }
}