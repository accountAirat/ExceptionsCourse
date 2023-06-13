package homework.hw3;

import homework.hw3.exceptions.*;

public class Main {
    public static void main(String[] args) {
        Human h = new Human();
        try (HumanService hs = new HumanService(h)) {
            System.out.println("Введите следующие данные в произвольном порядке, разделенные пробелом:\n" +
                    "Фамилия Имя Отчество, дата рождения, номер телефона, пол:\n");
            //String data = scan.nextLine();
            String data = "Краснов Иван Васильевич 18.10.1990 m 89006789876";
            if (countCheck(hs.lengthCheck(data))) {
                hs.pars(data);
                System.out.println("h = " + h);
                hs.save();
            }
            System.out.println("data = " + data);
        } catch (SavedException e) {
            System.out.println("SavedException = " + e.getMessage());
        } catch (CloseException e) {
            System.out.println("CloseException = " + e.getMessage());
        }
    }

    public static Boolean countCheck(int response) {
        switch (response) {
            case (1):
                System.out.println("Введено больше данных чем требуется.");
                return false;
            case (-1):
                System.out.println("Введено меньше данных чем требуется.");
                return false;
            case (0):
                return true;
            default:
                System.out.println("Не известный код ошибки.");
                return false;
        }
    }
}

