package org.example.command.commands;

import org.example.command.ICommand;
import org.example.command.StudentService;
import org.example.dataGroups.DataGroup;
import org.example.dataGroups.IGroupCriterion;
import org.example.methods.Methods;

import java.util.Scanner;

public class Command3 implements ICommand {
    private final StudentService STUDENT_SERVICE;

    public Command3(StudentService studentService) {
        this.STUDENT_SERVICE = studentService;
    }

    @Override
    public void execute() {
        IGroupCriterion familyCriterion = person -> String.valueOf(person.getFAMILY().charAt(0));
        DataGroup familyGroup = new DataGroup(familyCriterion);
        StudentService.toDataGroup(familyGroup, STUDENT_SERVICE);
        Scanner in = new Scanner(System.in);

        System.out.print("\nВведите фамилию ученика: ");

        Methods.searchPersonBySurname(familyGroup, in.nextLine());
    }
}
