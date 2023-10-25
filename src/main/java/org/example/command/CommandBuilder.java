package org.example.command;

import org.example.command.commands.*;

public class CommandBuilder {
    private final StudentService STUDENT_SERVICE;

    public CommandBuilder(StudentService studentService) {
        this.STUDENT_SERVICE = studentService;
    }

    public ICommand createCommand(String commandName) {
        return switch (commandName) {
            case "avgGrInClass" -> new Command1(STUDENT_SERVICE);
            case "searchExStd" -> new Command2(STUDENT_SERVICE);
            case "searchByLN" -> new Command3(STUDENT_SERVICE);
            default -> throw new IllegalArgumentException("Неизвестная команда: " + commandName);
        };
    }
}
