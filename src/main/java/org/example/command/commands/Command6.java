package org.example.command.commands;

import org.example.command.ICommand;
import org.example.dto.PersonDto;
import org.example.methods.SQLMethods;
import org.example.person.Person;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Command6 implements ICommand {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);

        System.out.print("\nВведите фамилию ученика: ");

        List<PersonDto> persons = SQLMethods.searchPersonAverageGradeBySurname(in.nextLine());

        for (PersonDto element : persons) {System.out.println(element.ToStringAVG());}
    }
}
