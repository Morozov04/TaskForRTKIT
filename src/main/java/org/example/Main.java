package org.example;

import org.example.command.CommandBuilder;
import org.example.command.StudentService;
import org.example.dataLoad.*;

/**
 * task 2
 * avgGrInClass- Вычисление средней оценки в старших классах (10 и 11) - Command1
 * searchExStd - Поиск всех отличников, старше 14 лет - Command2
 * searchByLN - Поиск ученика по фамили (фамилия ученика задается через консоль) - Command3

 * task 3
 * avgGrInClassDB- Вычисление средней оценки в старших классах (10 и 11) [Из БД] - Command4
 * searchExStdDB - Поиск всех отличников, старше 14 лет [Из БД] - Command5
 * searchByLNDB - Вычисление средней оценки ученика по указанной фамилии [Из БД] - Command6
 **/

public class Main {
    public static void main(String[] args) {

        IDataLoader fileDataLoader = new FileDataLoader();
        fileDataLoader.loadData("src/main/resources/students.csv");
        StudentService studentService = new StudentService(fileDataLoader);
        CommandBuilder commandBuilder = new CommandBuilder(studentService);

       try {
            commandBuilder.createCommand(args[0]).execute();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage() + " | Нет аргументов.");
        }
    }
}
