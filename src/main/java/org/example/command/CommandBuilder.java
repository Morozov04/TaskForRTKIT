package org.example.command;

import org.example.command.commands.*;

public class CommandBuilder {
    private final StudentService studentService;

    public CommandBuilder(StudentService studentService) {
        this.studentService = studentService;
    }

    public ICommand createCommand(String commandName) {
        return switch (commandName) {
            case "avgGrInClass" -> new Command1(studentService);
            case "searchExStd" -> new Command2(studentService);
            case "searchByLN" -> new Command3(studentService);
            case "avgGrInClassDB" -> new Command4();
            case "searchExStdDB" -> new Command5();
            case "searchByLNDB" -> new Command6();
            default -> throw new IllegalArgumentException("Неизвестная команда: " + commandName);
        };
    }
}
