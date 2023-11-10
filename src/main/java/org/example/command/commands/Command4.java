package org.example.command.commands;

import org.example.command.ICommand;
import org.example.dto.PersonDto;
import org.example.methods.SQLMethods;

import java.util.HashMap;
import java.util.Map;

public class Command4 implements ICommand {
    @Override
    public void execute() {
        System.out.println(SQLMethods.calculateAverageGrade("10"));
        System.out.println(SQLMethods.calculateAverageGrade("11"));
    }
}
