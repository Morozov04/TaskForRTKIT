package org.example.command.commands;

import org.example.command.ICommand;
import org.example.dto.PersonDto;
import org.example.methods.SQLMethods;

import java.util.List;

public class Command5 implements ICommand {
    @Override
    public void execute() {
       List<PersonDto> persons = SQLMethods.searchPersonByAssessment("14","18","5");

       persons.forEach(System.out::println);
    }
}
