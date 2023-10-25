package org.example;

import org.example.command.CommandBuilder;
import org.example.command.StudentService;
import org.example.dataLoad.*;

/**
 * avgGrInClass- Вычисление средней оценки в старших классах (10 и 11)
 * searchExStd - Поиск всех отличников, старше 14 лет
 * searchByLN - Поиск ученика по фамили (фамилия ученика задается через консоль)
 **/

public class Main {
    public static void main(String[] args) {

        IDataLoader fileDataLoader = new FileDataLoader();
        fileDataLoader.loadData("src/main/resources/students.csv");
        StudentService studentService = new StudentService(fileDataLoader);
        CommandBuilder commandBuilder = new CommandBuilder(studentService);

        try {
            commandBuilder.createCommand(args[0]).execute();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage() + " | Нет аргументов.");
        }
    }
}
