package org.example.command.commands;

import org.example.command.ICommand;
import org.example.command.StudentService;
import org.example.dataGroups.DataGroup;
import org.example.methods.Methods;
import org.example.person.Person;

public class Command1 implements ICommand {
    private final StudentService STUDENT_SERVICE;

    public Command1(StudentService studentService) {
        this.STUDENT_SERVICE = studentService;
    }

    @Override
    public void execute() {
        DataGroup<Integer> groupGroup = new DataGroup<>(Person::getGROUP);
        StudentService.toDataGroup(groupGroup, STUDENT_SERVICE);
        Methods.calculateAverageGrade(groupGroup, 10);
        Methods.calculateAverageGrade(groupGroup, 11);
    }
}
