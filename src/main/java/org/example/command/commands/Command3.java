package org.example.command.commands;

import org.example.command.ICommand;
import org.example.command.StudentService;
import org.example.dataGroups.DataGroup;
import org.example.methods.Methods;

import java.util.Scanner;

public class Command3 implements ICommand {
    private final StudentService studentService;

    public Command3(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void execute() {
        DataGroup<Character> familyGroup = new DataGroup<>(person -> person.getFamily().charAt(0));
        StudentService.toDataGroup(familyGroup, studentService);
        Scanner in = new Scanner(System.in);

        System.out.print("\nВведите фамилию ученика: ");

        Methods.searchPersonBySurname(familyGroup, in.nextLine());
    }
}
