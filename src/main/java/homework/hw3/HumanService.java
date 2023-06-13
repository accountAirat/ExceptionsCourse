package homework.hw3;

import homework.hw3.exceptions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanService implements AutoCloseable {
    Human human;
    Scanner scanner;
    FileWriter fileWriter;

    public HumanService(Human human){
        this.human = human;
        this.scanner = new Scanner(System.in);
        try {
            this.fileWriter = new FileWriter("C:\\Учёба\\ExceptionsCourse\\untitled\\src\\main\\java\\homework\\hw3\\Нет_данных.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String scan() {
        System.out.println("Введит значение: ");
        return scanner.next();
    }

    public void save() throws SavedException {
        String path = "C:\\Учёба\\ExceptionsCourse\\untitled\\src\\main\\java\\homework\\hw3\\" + human.getSurname() + ".txt";
        try {
            this.fileWriter = new FileWriter(path, true);
            fileWriter.write(this.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            throw new SavedException("Ошибка сохранения дкоумента", e);
        }
    }



    @Override
    public void close() throws CloseException {
        try {
            scanner.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new CloseException("Ошибка закрытия AutoCloseable ", e);
        }
    }

    public void pars(String value) {
        ArrayList<String> array = new ArrayList<>(List.of(value.split(" ")));
        for (int i = 0; i < human.getSize(); i++) {
            set(array.get(i));
        }
    }

    public Boolean set(String value) {
        if (human.setSex(value)) {
            return true;
        } else if (human.setBirthday(value)) {
            return true;
        } else if (human.setPhone(value)) {
            return true;
        } else if (human.setSurname(value)) {
            return true;
        } else if (human.setName(value)) {
            return true;
        } else if (human.setFatherName(value)) {
            return true;
        } else {
            return false;
        }
    }

    public int lengthCheck(String value) {
        return Integer.compare(value.split(" ").length, human.getSize());
    }

    @Override
    public String toString() {
        return "<" + human.getSurname() + "><" + human.getName() + "><" + human.getFatherName() + "><" + human.getPhone() + "><" + human.getSex() + ">";
    }
}
