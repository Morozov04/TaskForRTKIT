package org.example.command.commands;

import org.example.command.ICommand;
import org.example.dto.PersonDto;
import org.example.methods.SQLMethods;

public class Command4 implements ICommand {
    @Override
    public void execute() {
        SQLMethods.calculateAverageGrade("10");
        SQLMethods.calculateAverageGrade("11");

        PersonDto.avgGradeInSubjects.forEach(System.out::println);
    }
}
