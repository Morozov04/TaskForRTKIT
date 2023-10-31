package org.example.command.commands;

import org.example.command.ICommand;
import org.example.command.StudentService;
import org.example.dataGroups.DataGroup;
import org.example.methods.Methods;
import org.example.person.Person;

public class Command1 implements ICommand {
    private final StudentService studentService;

    public Command1(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void execute() {
        DataGroup<Integer> groupGroup = new DataGroup<>(Person::getGroup);
        StudentService.toDataGroup(groupGroup, studentService);
        Methods.calculateAverageGrade(groupGroup, 10);
        Methods.calculateAverageGrade(groupGroup, 11);
    }
}
