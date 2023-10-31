package org.example.command.commands;

import org.example.command.ICommand;
import org.example.command.StudentService;
import org.example.dataGroups.DataGroup;
import org.example.methods.Methods;
import org.example.person.Person;

public class Command2 implements ICommand {
    private final StudentService studentService;

    public Command2(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void execute() {
        DataGroup<Integer> ageGroup = new DataGroup<>(Person::getAge);
        StudentService.toDataGroup(ageGroup, studentService);
        Methods.searchPersonByAssessment(ageGroup, 14, 18, 5);
    }
}
