package org.example;

import org.example.command.CommandBuilder;
import org.example.command.StudentService;
import org.example.dataBase.DBUtils;
import org.example.dataLoad.*;


/**
 * Task 2.
 * <p>avgGrInClass- Вычисление средней оценки в старших классах (10 и 11) - Command1.
 * <p>searchExStd - Поиск всех отличников, старше 14 лет - Command2.
 * <p>searchByLN - Поиск ученика по фамили (фамилия ученика задается через консоль) - Command3.
 * <p>
 * <p>Task 3.
 * <p>avgGrInClassDB- Вычисление средней оценки в старших классах (10 и 11) [Из БД] - Command4.
 * <p>searchExStdDB - Поиск всех отличников, старше 14 лет [Из БД] - Command5.
 * <p>searchByLNDB - Вычисление средней оценки ученика по указанной фамилии [Из БД] - Command6.
 * <p>
 * <p>src/main/resources/config.properties - конфиг для подключения к БД.
 * <p>src/main/resources/student_create.sql - скрипт создания\инициализации таблиц в БД.
 */

public class Main {
    public static void main(String[] args) {

        IDataLoader fileDataLoader = new FileDataLoader();
        fileDataLoader.loadData("src/main/resources/students.csv");

        StudentService studentService = new StudentService(fileDataLoader);
        CommandBuilder commandBuilder = new CommandBuilder(studentService);

        DBUtils.createConnection();

       try {
            commandBuilder.createCommand(args[0]).execute();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage() + " | Нет аргументов.");
        }

        DBUtils.closeConnection();
    }
}
