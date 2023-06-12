package homework.hw2;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        System.out.println("inputFloat = " + inputFloat());
    }

    public static float inputFloat() {
        float value;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Введите значение float: ");
            String data = scan.nextLine();
            if (data.isEmpty()) {
                System.out.println("Пустые строки вводить нельзя");
            } else {
                try {
                    value = Float.parseFloat(data);
                    scan.close();
                    return value;
                } catch (NumberFormatException e) {
                    System.out.println("Exception: " + e);
                    System.out.println("Введённое значение не float");
                }
            }
        }
    }
}
